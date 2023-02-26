package anpopo.naranji.ft.naranjift.domains.btc.domain;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Card;
import anpopo.naranji.ft.naranjift.domains.btc.domain.repository.CardRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CardPersistence {
    private final CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Optional<Card> findByTopicSeqAndCardSeq(Long topicSeq, Long cardSeq) {
        return cardRepository.findByTopicSeqAndCardSeq(topicSeq, cardSeq);
    }

    public Optional<Card> findByCardSeq(Long cardSeq) {
        return cardRepository.findByCardSeq(cardSeq);
    }
}
