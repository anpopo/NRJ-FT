package anpopo.naranji.ft.naranjift.domains.btc.service.under;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.domain.CardPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.TopicPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Card;
import anpopo.naranji.ft.naranjift.domains.btc.exception.NRJCommonException;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateCardResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCardService {

    private final TopicPersistence topicPersistence;
    private final CardPersistence cardPersistence;

    public CreateCardResponseModel createCard(CreateCardRequestModel createCardRequestModel) {
        String cardImageUrl = null;
        if (createCardRequestModel.getCardImage() != null) {
            // todo image upload
        }

        Card card = topicPersistence.findByTopicSeqAndNowUsingTrue(createCardRequestModel.getTopicSeq())
            .map(topic -> cardPersistence.save(
                Card.builder()
                    .cardName(createCardRequestModel.getCardName())
                    .cardContent(createCardRequestModel.getCardContent())
                    .cardImageUrl(cardImageUrl)
                    .build()))
            .orElseThrow(() -> new NRJCommonException(
                NRJResponseStatus.ERROR_NOT_FOUND,
                String.format("%d - 존재하지 않는 토픽", createCardRequestModel.getTopicSeq())
            ));

        return CreateCardResponseModel.builder()
            .cardSeq(card.getCardSeq())
            .cardName(card.getCardName())
            .cardContent(card.getCardContent())
            .cardImageUrl(card.getCardImageUrl())
            .updatedAt(card.getUpdatedAt())
            .build();
    }
}
