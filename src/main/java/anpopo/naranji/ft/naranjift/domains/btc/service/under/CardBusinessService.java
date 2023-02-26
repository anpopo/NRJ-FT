package anpopo.naranji.ft.naranjift.domains.btc.service.under;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.domain.CardPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.TopicPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Card;
import anpopo.naranji.ft.naranjift.domains.btc.exception.NRJCommonException;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.SingleCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateCardResponseModel;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CardBusinessService {

    private final TopicPersistence topicPersistence;
    private final CardPersistence cardPersistence;

    @Transactional
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
                    .topicSeq(topic.getTopicSeq())
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

    @Transactional
    public UpdateCardResponseModel updateCard(UpdateCardRequestModel updateCardRequestModel) {

        String cardImageUrl = null;
        if (updateCardRequestModel.getCardImage() != null) {
            // todo image update
        }

        Card updatedCard = cardPersistence.findByTopicSeqAndCardSeq(updateCardRequestModel.getTopicSeq(),
                updateCardRequestModel.getCardSeq())
            .map(card -> {
                card.updateCard(
                    updateCardRequestModel.getCardName(),
                    updateCardRequestModel.getCardContent(),
                    cardImageUrl
                );

                return card;
            })
            .orElseThrow(() -> new NRJCommonException(
                NRJResponseStatus.ERROR_NOT_FOUND,
                String.format("%d - 존재하지 않는 카드", updateCardRequestModel.getCardSeq())
            ));

        return UpdateCardResponseModel.builder()
            .cardSeq(updatedCard.getCardSeq())
            .cardName(updatedCard.getCardName())
            .cardContent(updatedCard.getCardContent())
            .updatedAt(updatedCard.getUpdatedAt())
            .cardImageUrl(Objects.requireNonNullElseGet(cardImageUrl, updatedCard::getCardImageUrl))
            .build();
    }

    @Transactional(readOnly = true)
    public SingleCardResponseModel getSingleCard(Long cardSeq) {
        return cardPersistence.findByCardSeq(cardSeq)
            .map(card ->
                SingleCardResponseModel.builder()
                    .cardName(card.getCardName())
                    .cardContent(card.getCardContent())
                    .cardImageUrl(card.getCardImageUrl())
                    .createdAt(card.getCreatedAt())
                    .updatedAt(card.getUpdatedAt())
                    .build())
            .orElseThrow(() -> new NRJCommonException(
                NRJResponseStatus.ERROR_NOT_FOUND,
                String.format("%d - 존재하지 않는 카드", cardSeq)
            ));
    }
}
