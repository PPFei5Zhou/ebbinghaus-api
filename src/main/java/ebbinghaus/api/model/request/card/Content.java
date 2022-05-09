package ebbinghaus.api.model.request.card;

import ebbinghaus.api.model.entity.CardContent;

public class Content {
    private String content;

    public CardContent convert() {
        return new CardContent(getContent());
    }

    public String getContent() {
        return content;
    }
}
