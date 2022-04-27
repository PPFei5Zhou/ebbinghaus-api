package ebbinghaus.api.model.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;
import java.util.StringJoiner;

/**
 * entity for tag.
 *
 * @author Easy
 */
@Entity
public class Tag {
    @Id
    private String id;
    private String tagName;
    @Column(updatable = false)
    private String userId;
    private Timestamp createAt;

    @OneToOne
    private Tag parent;

    @OneToMany
    @JoinColumn(name = "parent_id")
    private List<Tag> children;

    public Tag(String id, String tagName, String userId, Timestamp createAt, Tag parent) {
        this.id = id;
        this.tagName = tagName;
        this.userId = userId;
        this.createAt = createAt;
        this.parent = parent;
    }

    @PersistenceConstructor
    protected Tag() {
    }

    private Tag(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("tagName='" + tagName + "'")
                .add("userId='" + userId + "'")
                .add("createAt='" + createAt + "'")
                .toString();
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

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Tag getParent() {
        return parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

    public List<Tag> getChildren() {
        return children;
    }

    public void setChildren(List<Tag> children) {
        this.children = children;
    }
}
