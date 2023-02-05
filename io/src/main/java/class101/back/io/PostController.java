package class101.back.io;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostRepository postRepository;

  // 1. 글을 작성한다.
  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return postRepository.save(post);
  }

  // 2-1. 글 목록을 조회한다.
  @GetMapping
  public List<Post> getPostList() {
    return postRepository.findAll();
  }

  // 2-2 글 목록을 페이징하여 반환

  // 3. 글 번호로 조회
  @GetMapping("/{id}")
  public Post getPost(@PathVariable(value = "id") Long postId) {
    return postRepository.findById(postId)
      .orElse(null);
  }

  // 4. 글 내용으로 검색 -> 해당 내용이 포함된 모든 글

}
