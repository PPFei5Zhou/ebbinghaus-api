package ebbinghaus.api.repository;

import ebbinghaus.api.core.JpaRepositoryTest;
import ebbinghaus.api.model.entity.Card;
import ebbinghaus.api.utils.JpaUtil;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@JpaRepositoryTest
class CardRepositoryTest {
    @Resource
    private EntityManager manager;
    @Resource
    private CardRepository repository;

    private final String id = UUID.randomUUID().toString();
    private final Card card = Card.ofCreate(id, "test card name", "tag id", "test card content");
    private final Card update = Card.ofUpdate(id, "update card name", "update card content");

    @Test
    void repository_crud() {
        var inserted = repository.saveAndFlush(card);
        assertSameCard(card, inserted);
        manager.detach(inserted);
        var finded = repository.findById(id).orElseThrow(AssertionError::new);
        assertSameCard(card, finded);
        JpaUtil.copyNotNullProperties(update, finded);
        var updated = repository.saveAndFlush(finded);
        assertSameCard(updated, updated);
        repository.deleteById(id);
    }

    void assertSameCard(Card expected, Card actual) {
        assertThat(actual.getId(), equalTo(expected.getId()));
        assertThat(actual.getCardName(), equalTo(expected.getCardName()));
        for (int i = 0; i < expected.getContent().size(); i++) {
            assertThat(actual.getContent().get(i), equalTo(expected.getContent().get(i)));
        }
    }
}