package ebbinghaus.api.model.request;

import ebbinghaus.api.model.entity.Tag;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;

/**
 * Tag Request body.
 *
 * @author Easy
 */
public class TagBody {
    private String id;
    private String tagName;
    private String userId;
    private String parentId;
    private Timestamp creatAt;

    public Tag ofUpdate(String id) {
        Tag parent = null;
        if (StringUtils.hasText(this.parentId)) {
            parent = new Tag(this.parentId, null, null, null, null);
        }
        return new Tag(id, this.tagName, this.userId, null, parent);
    }

    public Tag ofInsert() {
        Tag parent = null;
        if (StringUtils.hasText(this.parentId)) {
            parent = new Tag(this.parentId, null, null, null, null);
        }
        return new Tag(this.getId(), this.tagName, this.userId, null, parent);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Timestamp getCreatAt() {
        return creatAt;
    }

    public void setCreatAt(Timestamp creatAt) {
        this.creatAt = creatAt;
    }
}
