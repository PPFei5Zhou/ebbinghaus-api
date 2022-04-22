package ebbinghaus.api.repository;

import ebbinghaus.api.core.JpaRepositoryTest;
import ebbinghaus.api.model.entity.Tag;
import ebbinghaus.api.model.response.TagResponse;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@JpaRepositoryTest
class TagRepositoryTest {
    @Resource
    private EntityManager manager;

    @Resource
    private TagRepository repository;

    private final Tag parent = new Tag(
            "F6636F1d-941F-94C8-7b03-247e45c31C94",
            "花计量海",
            "B4bBAE2E-735c-0fAe-6eF7-7cA735A9bB52",
            null
    );

    private final Tag child = new Tag(
            "8743e75c-C8bb-eFb5-bde9-DDfc51DdFBBA",
            "外活单节",
            "B4bBAE2E-735c-0fAe-6eF7-7cA735A9bB52",
            new Tag("F6636F1d-941F-94C8-7b03-247e45c31C94", null, null, null)
    );

    @Test
    void repository_crud() {
        var saved = repository.saveAndFlush(parent);
        manager.detach(saved);
        manager.detach(repository.saveAndFlush(child));
        assertSameTag(parent, saved);
        var find = repository.findById(parent.getId()).orElseThrow(AssertionError::new);
        find.setTagName("update tag name");
        var updated = repository.saveAndFlush(find);
        assertSameTag(updated, find);
        manager.detach(updated);
        repository.delete(updated);
        var noExit = repository.findById(updated.getId()).orElse(null);
        assertThat(noExit, is(nullValue()));
        System.out.println(repository.findById(child.getId()).orElseThrow(AssertionError::new).getParent());
    }

    @Test
    void build_tag_menu_list() {
        List<Tag> root = repository.findAllByParentId(null);
        List<TagResponse> list = new ArrayList<>();
        for (Tag tag : root) {
            list.add(TagResponse.create(tag));
        }
        list.forEach(System.out::println);
    }

    private void assertSameTag(Tag expected, Tag actual) {
        assertThat(expected.getId(), equalTo(actual.getId()));
        assertThat(expected.getTagName(), equalTo(actual.getTagName()));
        assertThat(expected.getUserId(), equalTo(actual.getUserId()));
    }
}