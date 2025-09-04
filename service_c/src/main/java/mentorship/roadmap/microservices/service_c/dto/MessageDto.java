package mentorship.roadmap.microservices.service_c.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {
    @NotNull private Long id;
    @NotBlank private String type;
    @NotBlank private String content;
    @NotNull private Instant createdAt;
}
