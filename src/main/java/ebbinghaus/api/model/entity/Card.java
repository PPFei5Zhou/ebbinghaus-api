package ebbinghaus.api.model.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Entity for table card.
 *
 * @author Easy
 */
@Entity
public class Card {
    @Id
    private String id;
    private String cardName;
    @Column(updatable = false)
    private Timestamp createAt;
    @Column(updatable = false)
    private String tagId;

    @ElementCollection
    private List<CardContent> content;

    @PersistenceConstructor
    protected Card() {
    }

    public static Card ofCreate(String id, String cardName, String tagId, String content) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Card(id, cardName, tagId, now, content);
    }

    public static Card ofUpdate(String id, String cardName, String content) {
        return new Card(id, cardName, null, null, content);
    }

    private Card(String id, String cardName, String tagId, Timestamp createAt, String content) {
        this.id = id;
        this.cardName = cardName;
        this.tagId = tagId;
        this.createAt = createAt;
        if (StringUtils.hasText(content)) {
            this.content = new ArrayList<>();
            this.content.add(new CardContent(content));
        }
    }

    public Card(String id, String cardName, String tagId, Timestamp createAt, List<CardContent> content) {
        this.id = id;
        this.cardName = cardName;
        this.tagId = tagId;
        this.createAt = createAt;
        this.content = content;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("cardName='" + cardName + "'")
                .add("tagId='" + tagId + "'")
                .add("createAt=" + createAt)
                .add("content=" + content)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(getId(), card.getId())
                && Objects.equals(getCardName(), card.getCardName())
                && Objects.equals(getTagId(), card.getTagId())
                && Objects.equals(getCreateAt(), card.getCreateAt())
                && Objects.equals(getContent(), card.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCardName(), getTagId(), getCreateAt(), getContent());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public List<CardContent> getContent() {
        return content;
    }

    public void setContent(List<CardContent> content) {
        this.content = content;
    }
}
