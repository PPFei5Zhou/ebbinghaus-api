package ebbinghaus.api.model.response;

import ebbinghaus.api.model.entity.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Tag response.
 *
 * @author Easy
 */
public class TagResponse {
    public String tagId;
    public String tagName;
    public String parentId;
    public List<TagResponse> children;

    public TagResponse(String tagId, String tagName, String parentId) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "{", "}")
                .add("\"tagId\":\"" + tagId + "\"")
                .add("\"tagName\":\"" + tagName + "\"")
                .add("\"parentId\":\"" + parentId + "\"")
                .add("\"children\":" + children)
                .toString();
    }

    public static TagResponse create(Tag tag) {
        String parentId = tag.getParent() == null ? null : tag.getParent().getId();
        var response = new TagResponse(tag.getId(), tag.getTagName(), parentId);
        if (tag.getChildren() != null && tag.getChildren().size() > 0) {
            response.children = createChildren(tag.getChildren());
        }
        return response;
    }

    static List<TagResponse> createChildren(List<Tag> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        List<TagResponse> result = new ArrayList<>(list.size());
        for (Tag tag : list) {
            String parentId = tag.getParent() == null ? null : tag.getParent().getId();
            var content = new TagResponse(tag.getId(), tag.getTagName(), parentId);
            result.add(content);
            if (tag.getChildren() != null && tag.getChildren().size() > 0) {
                content.children = createChildren(tag.getChildren());
            }
        }
        return result;
    }
}