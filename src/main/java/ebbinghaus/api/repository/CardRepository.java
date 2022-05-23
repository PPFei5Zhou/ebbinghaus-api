package ebbinghaus.api.repository;

import ebbinghaus.api.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Card repository.
 *
 * @author Easy
 */
public interface CardRepository extends JpaRepository<Card, String>, JpaSpecificationExecutor<Card> {
}
