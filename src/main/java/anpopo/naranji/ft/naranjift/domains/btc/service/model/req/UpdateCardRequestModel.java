package anpopo.naranji.ft.naranjift.domains.btc.service.model.req;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class UpdateCardRequestModel {
    private Long topicSeq;
    private Long cardSeq;
    private String cardName;
    private String cardContent;
    private MultipartFile cardImage;

    public void setCardSeq(Long cardSeq) {
        this.cardSeq = cardSeq;
    }

    public void setCardImage(MultipartFile cardImage) {
        this.cardImage = cardImage;
    }
}
