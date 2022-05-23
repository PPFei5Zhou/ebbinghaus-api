package ebbinghaus.api.service.impl;

import ebbinghaus.api.model.entity.Card;
import ebbinghaus.api.repository.CardRepository;
import ebbinghaus.api.service.CardService;
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

@Service
public class CardServiceImpl implements CardService {
    @Resource
    private CardRepository repository;

    @Override
    public Card insert(Card model) {
        model.setId(UUID.randomUUID().toString());
        return repository.saveAndFlush(model);
    }

    @Override
    public Card update(Card model) {
        if (!StringUtils.hasText(model.getId())) {
            throw new IllegalArgumentException("Card id can not be null or empty.");
        }
        Optional<Card> optional = repository.findById(model.getId());
        if (optional.isEmpty()) {
            throw new NullPointerException("Card dose not exit.");
        }
        JpaUtil.copyNotNullProperties(model, optional.get());
        return repository.saveAndFlush(model);
    }

    @Override
    public void deleteById(String id) {
        Optional<Card> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NullPointerException("Card dose not exit.");
        }
        repository.delete(optional.get());
    }

    @Override
    public void deleteBatchById(String[] ids) {
        repository.deleteAllById(Arrays.asList(ids));
    }

    @Override
    public Card findById(String id) {
        return repository.findById(id).orElseThrow(() -> new NullPointerException("Card dose not exit."));
    }

    @Override
    public List<Card> findAllBy(Card model) {
        return repository.findAll((Specification<Card>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(model.getCardName())) {
                predicates.add(criteriaBuilder.equal(root.get("cardName"), model.getCardName()));
            }
            Predicate[] predicates1 = new Predicate[predicates.size()];
            return query.where(predicates.toArray(predicates1)).getGroupRestriction();
        });
    }
}
