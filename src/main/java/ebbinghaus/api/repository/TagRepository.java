package ebbinghaus.api.repository;

import ebbinghaus.api.model.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Tag repository.
 *
 * @author Easy
 */
public interface TagRepository extends JpaRepository<Tag, String>, JpaSpecificationExecutor<Tag> {
    /**
     * find tag list by parent id.
     *
     * @param parentId parent id
     * @return list of tag
     */
    List<Tag> findAllByParentId(String parentId);

    /**
     * find tag list by user id and parent id is null.
     *
     * @param userId user id
     * @return list of tag
     */
    List<Tag> findAllByUserIdAndParentIdIsNull(String userId);
}
