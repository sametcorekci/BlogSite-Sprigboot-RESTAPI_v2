package repository;
import model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    void deleteById(Long id);
    boolean existsByEmail(String email);
    void deleteByEmail(String email);

}



