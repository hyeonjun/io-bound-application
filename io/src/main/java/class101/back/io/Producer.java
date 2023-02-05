package class101.back.io;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

  private final RabbitTemplate rabbitTemplate;
  private static String createPostQueueName = "CREATE_POST_QUEUE";

  public void sendTo(String message) {
    log.info("data send to queue: {}", message);
    this.rabbitTemplate.convertAndSend(createPostQueueName, message);
  }

}
