package ebbinghaus.api.model.request.card;

import com.fasterxml.jackson.annotation.JsonFormat;
import ebbinghaus.api.model.entity.Card;
import ebbinghaus.api.model.entity.CardContent;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CardBody {
    private String id;
    private String cardName;
    private String tagId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createAt;
    private List<Content> content;

    public Card ofCreate() {
        List<CardContent> list = new ArrayList<>();
        content.forEach((c) -> list.add(c.convert()));
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Card(getId(), getCardName(), getTagId(), now, list);
    }

    public Card ofUpdate(String id) {
        List<CardContent> list = new ArrayList<>();
        content.forEach((c) -> list.add(c.convert()));
        return new Card(id, getCardName(), null, null, list);
    }

    public Card ofSearch() {
        List<CardContent> list = new ArrayList<>();
        if (content != null) {
            content.forEach((c) -> list.add(c.convert()));
        }
        return new Card(getId(), getCardName(), getTagId(), getCreateAt(), list);
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

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }
}
