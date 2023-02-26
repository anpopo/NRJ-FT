package anpopo.naranji.ft.naranjift.domains.btc.service.model.res;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UpdateTopicResponseModel {
    private Long topicSeq;
    private String name;
    private LocalDateTime updatedAt;
}
