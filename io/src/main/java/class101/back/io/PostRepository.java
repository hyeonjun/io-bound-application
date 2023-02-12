package class101.back.io;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// extends JpaRepository<Post, Long>
public interface PostRepository extends ElasticsearchRepository<Post, String> {

//  List<Post> findAllByContentContains(String content);
  List<Post> findByContent(String content);
}
