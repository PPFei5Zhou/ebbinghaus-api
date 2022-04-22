package ebbinghaus.api.controller;

import ebbinghaus.api.model.entity.Tag;
import ebbinghaus.api.model.request.TagBody;
import ebbinghaus.api.model.response.TagResponse;
import ebbinghaus.api.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Tag controller.
 *
 * @author Easy
 */
@RestController
@RequestMapping("api/tag")
public class TagController {
    @Resource
    private TagService service;

    @PostMapping()
    public ResponseEntity<TagResponse> insert(@RequestBody TagBody body) {
        Tag tag = service.insert(body.ofInsert());
        return ResponseEntity.ok(TagResponse.create(tag));
    }

    @PutMapping("{id}")
    public ResponseEntity<TagResponse> update(@PathVariable String id, @RequestBody TagBody body) {
        Tag tag = service.update(body.ofUpdate(id));
        return ResponseEntity.ok(TagResponse.create(tag));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBatchById(@RequestBody String[] ids) {
        service.deleteBatchById(ids);
        return ResponseEntity.ok().build();
    }

    @GetMapping("userTagList")
    public ResponseEntity<List<TagResponse>> userTagList() {
        var list = service.userTagList("ef12fC6F-7DbF-A372-fDE7-CfaC9Cc66BeF");
        List<TagResponse> result = new ArrayList<>(list.size());
        for (Tag tag : list) {
            result.add(TagResponse.create(tag));
        }
        return ResponseEntity.ok(result);
    }
}
