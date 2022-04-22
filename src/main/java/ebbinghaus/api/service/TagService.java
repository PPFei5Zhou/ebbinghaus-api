package ebbinghaus.api.service;

import ebbinghaus.api.model.entity.Tag;

import java.util.List;

/**
 * Tag service interface.
 *
 * @author Easy
 */
public interface TagService {
    /**
     * Insert.
     *
     * @param model Entity of Tag
     * @return Entity of Tag
     */
    Tag insert(Tag model);

    /**
     * Update.
     *
     * @param model Entity of Tag
     * @return Entity of Tag
     */
    Tag update(Tag model);

    /**
     * delete tag by id.
     *
     * @param id id of tag
     */
    void deleteById(String id);

    /**
     * delete tag by multiple id.
     *
     * @param ids list of id
     */
    void deleteBatchById(String[] ids);

    /**
     * find tag by id.
     *
     * @param id id of tag
     * @return Entity of Tag
     */
    Tag findById(String id);

    /**
     * find tag by multiple condition.
     *
     * @param model Entity of Tag
     * @return list of tag
     */
    List<Tag> findByCondition(Tag model);

    /**
     * current user tag menu list.
     *
     * @param userId user id
     * @return list of tag
     */
    List<Tag> userTagList(String userId);
}
