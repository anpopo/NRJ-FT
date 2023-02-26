package anpopo.naranji.ft.naranjift.domains.btc.service.model.res;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class SingleCardResponseModel {
    private String cardName;
    private String cardContent;
    private String cardImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
