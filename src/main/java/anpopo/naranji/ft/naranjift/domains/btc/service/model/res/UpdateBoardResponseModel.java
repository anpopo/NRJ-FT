package anpopo.naranji.ft.naranjift.domains.btc.service.model.res;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class UpdateBoardResponseModel {
    private Long boardSeq;
    private String title;
    private LocalDateTime updatedAt;
}
