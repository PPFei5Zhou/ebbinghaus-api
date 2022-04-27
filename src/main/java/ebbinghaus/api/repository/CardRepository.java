package ebbinghaus.api.repository;

import ebbinghaus.api.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Card repository.
 *
 * @author Easy
 */
public interface CardRepository extends JpaRepository<Card, String> {
}
