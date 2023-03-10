package class101.back.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

  private final PostRepository postRepository;
  private final ObjectMapper objectMapper;
  private final Producer producer;
  private final PostCacheService postCacheService;
  private static Integer PAGE_SIZE = 20;

  // 1. 글을 작성한다.
//  @PostMapping
//  public Post createPost(@RequestBody Post post) {
//    return postRepository.save(post);
//  }
  @PostMapping
  public Post createPost(@RequestBody Post post) throws JsonProcessingException {
    String json = objectMapper.writeValueAsString(post);
    producer.sendTo(json);
    return post; // id는 null인 채로 돌아갈 것.
  }

//  // 2. 글 목록을 페이징하여 반환
//  @GetMapping
//  public Page<Post> getPostList(@RequestParam(defaultValue = "1") Integer page) {
//    if (page.equals(1)) {
//      return postCacheService.getFirstPostPage();
//    }
//    return postRepository.findAll(PageRequest.of(page-1, PAGE_SIZE,
//      Sort.by("id").descending()));
//  }
//
//  // 3. 글 번호로 조회
//  @GetMapping("/{id}")
//  public Post getPost(@PathVariable(value = "id") Long postId) {
//    return postRepository.findById(postId)
//      .orElse(null);
//  }

  // 4. 글 내용으로 검색 -> 해당 내용이 포함된 모든 글
  @GetMapping("/search")
  public List<Post> findPostsByContent(@RequestParam String content) {
//    return postRepository.findAllByContentContains(content);
    return postRepository.findByContent(content);
  }


}
