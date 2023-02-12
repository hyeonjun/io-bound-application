package class101.back.io;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostCacheService {

//  private final PostRepository postRepository;
//
//  private Page<Post> firtPostPage;
//
//  @Scheduled(cron = "* * * * * *")
//  public void updateFirstPostPage() {
//    firtPostPage = postRepository.findAll(
//      PageRequest.of(0, 20, Sort.by("id").descending()));
//  }
//
//  public Page<Post> getFirstPostPage() {
//    return this.firtPostPage;
//  }
}
