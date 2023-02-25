package anpopo.naranji.ft.naranjift.domains.btc.web.model.res;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateCardResponseDto {
    private Long cardSeq;
    private String cardName;
    private String cardContent;
    private String cardImageUrl;
    private LocalDateTime updatedAt;
}
