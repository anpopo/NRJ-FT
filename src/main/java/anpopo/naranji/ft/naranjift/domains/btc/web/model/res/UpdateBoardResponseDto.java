package anpopo.naranji.ft.naranjift.domains.btc.web.model.res;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateBoardResponseDto {
    private Long boardSeq;
    private String title;
    private LocalDateTime updatedAt;
}
