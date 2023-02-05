package class101.back.io;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {

  private final RabbitTemplate rabbitTemplate;
  private static String createPostQueueName = "CREATE_POST_QUEUE";

  public void sendTo(String message) {
    this.rabbitTemplate.convertAndSend(createPostQueueName, message);
  }

}
