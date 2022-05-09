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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createAt;
    private List<Content> content;

    public Card ofCreate() {
        List<CardContent> list = new ArrayList<>();
        content.forEach((c) -> list.add(c.convert()));
        Timestamp now = new Timestamp(System.currentTimeMillis());
        return new Card(getId(), getCardName(), now, list);
    }

    public Card ofUpdate(String id) {
        List<CardContent> list = new ArrayList<>();
        content.forEach((c) -> list.add(c.convert()));
        return new Card(id, getCardName(), null, list);
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
