package ebbinghaus.api.model.response.card;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CardResponse implements Serializable {
    private String id;
    private String cardName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createAt;
    private List<Content> content;

    public CardResponse(String id, String cardName, Timestamp createAt, List<Content> content) {
        this.id = id;
        this.cardName = cardName;
        this.createAt = createAt;
        this.content = content;
    }

    public static CardResponse build(ebbinghaus.api.model.entity.Card card) {
        List<Content> content = new ArrayList<>();
        if (card.getContent() != null && !card.getContent().isEmpty()) {
            card.getContent().forEach((c) -> content.add(new Content(c.getContent())));
        }
        return new CardResponse(card.getId(), card.getCardName(), card.getCreateAt(), content);
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
