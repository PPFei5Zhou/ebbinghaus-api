package ebbinghaus.api.service;

import ebbinghaus.api.model.entity.Card;

/**
 * Card service.
 *
 * @author Easy
 */
public interface CardService {
    /**
     * Insert.
     *
     * @param model entity of card
     * @return entity of card
     */
    Card insert(Card model);

    /**
     * Update.
     *
     * @param model entity of card
     * @return entity of card
     */
    Card update(Card model);

    /**
     * Delete by id.
     *
     * @param id id
     */
    void deleteById(String id);

    /**
     * Delete card by multiple id.
     *
     * @param ids list of id
     */
    void deleteBatchById(String[] ids);

    /**
     * Find card by id.
     *
     * @param id id
     * @return entity of card
     */
    Card findById(String id);
}
