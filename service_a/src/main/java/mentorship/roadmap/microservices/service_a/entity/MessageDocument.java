package mentorship.roadmap.microservices.service_a.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDocument {
    @Id
    private Long id;
    private String type;
    private String content;
}