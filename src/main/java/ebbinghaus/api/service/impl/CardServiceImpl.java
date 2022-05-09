package ebbinghaus.api.service.impl;

import ebbinghaus.api.model.entity.Card;
import ebbinghaus.api.repository.CardRepository;
import ebbinghaus.api.service.CardService;
import ebbinghaus.api.utils.JpaUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
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
}
