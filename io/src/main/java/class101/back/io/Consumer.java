package class101.back.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Consumer {

  private final PostRepository postRepository;
  private final ObjectMapper objectMapper;

  // CREATE_POST_QUEUE라는 큐에 Consume하도록 하는 것
  // 큐에 메시지가 들어오면 해당 메소드가 호출된다.
  // message는 json 형태로 되어 있는데 이를 읽어서, Post 클래스 타입으로 변경
  // 이후 만들어진 Post를 DB에 저장
  @RabbitListener(queues = "CREATE_POST_QUEUE")
  public void handler(String message) throws JsonProcessingException {
    Post post = objectMapper.readValue(message, Post.class);
    log.info("get message and insert db: {}", post);
    postRepository.save(post);
  }

}
