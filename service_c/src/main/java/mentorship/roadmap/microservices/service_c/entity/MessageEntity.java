package mentorship.roadmap.microservices.service_c.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "messages")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessageEntity {
    @Id
    private Long id;
    private String type;
    private String content;
    private Instant createdAt;
}
