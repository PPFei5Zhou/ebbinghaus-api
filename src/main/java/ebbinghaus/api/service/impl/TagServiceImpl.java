package ebbinghaus.api.service.impl;

import ebbinghaus.api.model.entity.Tag;
import ebbinghaus.api.repository.TagRepository;
import ebbinghaus.api.service.TagService;
import ebbinghaus.api.utils.JpaUtil;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implement of TagService.
 *
 * @author Easy
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagRepository repository;

    @Override
    public Tag insert(Tag model) {
        model.setId(UUID.randomUUID().toString());
        return repository.saveAndFlush(model);
    }

    @Override
    public Tag update(Tag model) {
        if (!StringUtils.hasText(model.getId())) {
            throw new IllegalArgumentException("Tag id can not be null or empty.");
        }
        Optional<Tag> optional = repository.findById(model.getId());
        if (optional.isEmpty()) {
            throw new NullPointerException("Tag dose not exit.");
        }
        JpaUtil.copyNotNullProperties(model, optional.get());
        return repository.saveAndFlush(model);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteBatchById(String[] ids) {
        repository.deleteAllById(Arrays.asList(ids));
    }

    @Override
    public Tag findById(String id) {
        return repository.findById(id).orElseThrow(NullPointerException::new);
    }

    @Override
    public List<Tag> findByCondition(Tag model) {
        return repository.findAll((Specification<Tag>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(model.getId())) {
                predicates.add(criteriaBuilder.equal(root.get("id"), model.getId()));
            }
            if (StringUtils.hasText(model.getTagName())) {
                predicates.add(criteriaBuilder.like(root.get("tagName"), "%" + model.getTagName() + "%"));
            }
            // predicates.add(criteriaBuilder.equal(root.get("userId"), model.getUserId()));
            Predicate[] predicates1 = new Predicate[predicates.size()];
            return query.where(predicates.toArray(predicates1)).getGroupRestriction();
        });
    }

    @Override
    public List<Tag> userTagList(String userId) {
        return repository.findAllByUserIdAndParentIdIsNull(userId);
    }
}
