package anpopo.naranji.ft.naranjift.domains.btc.service.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Getter
public class CreateCardRequestModel {
    private Long topicSeq;
    private String cardName;
    private String cardContent;
    private MultipartFile cardImage;

    public void setCardImage(MultipartFile cardImage) {
        this.cardImage = cardImage;
    }
}
