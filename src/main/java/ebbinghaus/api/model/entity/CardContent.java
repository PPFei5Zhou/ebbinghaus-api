package ebbinghaus.api.model.entity;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Entity for card_content.
 *
 * @author Easy
 */
@Embeddable
public class CardContent {
    private String content;

    public CardContent(String content) {
        this.content = content;
    }

    @PersistenceConstructor
    protected CardContent() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CardContent)) {
            return false;
        }
        CardContent that = (CardContent) o;
        return Objects.equals(getContent(), that.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CardContent.class.getSimpleName() + "[", "]")
                .add("content='" + content + "'")
                .toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
