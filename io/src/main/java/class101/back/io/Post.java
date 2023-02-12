package class101.back.io;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Entity(name = "post")
@Document(indexName = "post")
public class Post {
//  @Id
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_seq")
//  @SequenceGenerator(name="post_id_seq", sequenceName = "post_id_seq", allocationSize = 1)
//  private Long id;

  @Id
  private String id;
  private String content;
}
