package controller;

import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts-api")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/creted")
    public ResponseEntity<List<Post>> createPost(@RequestBody List<Post> postCreated) {
        List<Post> savedPost = postService.createPost(postCreated);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }

    @PutMapping("/update-post/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @DeleteMapping("/post-deleted/{id}")
    public ResponseEntity<String> deleteByIDWhichPost(@PathVariable Long id) {
        return postService.deleteById(id);
    }

    @DeleteMapping("/delete-by-email/{email}")
    public ResponseEntity<String> deleteByEmail(@PathVariable String email) {
        return postService.deleteByEmail(email);
    }

    @GetMapping("/get-all-post")
    public ResponseEntity<List<Post>> findAll() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/like/{id}")
    public ResponseEntity<String> likePost(@PathVariable Long id) {
        return postService.likePost(id);
    }

    @PutMapping("/unlike/{id}")
    public ResponseEntity<String> unlikePost(@PathVariable Long id) {
        return postService.unlikePost(id);
    }


}