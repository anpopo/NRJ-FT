package anpopo.naranji.ft.naranjift.domains.btc.web.model.res;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateTopicResponseDto {
    private Long topicSeq;
    private String name;
    private LocalDateTime updatedAt;
}
