package service;

import jakarta.transaction.Transactional;
import model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> createPost(List<Post> post) {
        return postRepository.saveAll(post);
    }

    public ResponseEntity<String> updatePost(Long id, Post post) {
        return postRepository.findById(id)
                .map(existingPost -> {
                    existingPost.setName(post.getName());
                    existingPost.setSurname(post.getSurname());
                    existingPost.setContent(post.getContent());
                    existingPost.setEmail(post.getEmail());
                    postRepository.save(existingPost);
                    return ResponseEntity.ok("Post başarıyla güncellendi.");
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post ID: " + id + " veritabanında bulunamadı."));
    }

    public ResponseEntity<String> deleteById(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return ResponseEntity.ok("Post ID: " + id + " başarıyla silindi.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post ID: " + id + " bulunamadı.");
        }
    }

    @Transactional
    public ResponseEntity<String> deleteByEmail(String email) {
        if (postRepository.existsByEmail(email)) {
            postRepository.deleteByEmail(email);
            return ResponseEntity.ok("Post e-posta: " + email + " başarıyla silindi.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Post e-posta: " + email + " bulunamadı.");
        }
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public ResponseEntity<String> likePost(Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    post.like();
                    postRepository.save(post); // Güncel beğeni sayısını kaydet
                    return ResponseEntity.ok("Post ID: " + id + " beğenildi. Toplam beğeni: " + post.getLikeCount());
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Post ID: " + id + " bulunamadı."));
    }
    public ResponseEntity<String> unlikePost(Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    post.unLike();
                    postRepository.save(post); // Güncel beğeni sayısını kaydet
                    return ResponseEntity.ok("Post ID: " + id + " beğenme geri alındı. Toplam beğeni: " + post.getLikeCount());
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Post ID: " + id + " bulunamadı."));
    }
}