package anpopo.naranji.ft.naranjift.domains.btc.web.model.req;

import lombok.Getter;

@Getter
public class UpdateCardRequestDto {
    private Long topicSeq;
    private String cardName;
    private String cardContent;
}
