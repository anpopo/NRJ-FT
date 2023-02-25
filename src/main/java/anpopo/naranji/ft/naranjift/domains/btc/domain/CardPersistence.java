package anpopo.naranji.ft.naranjift.domains.btc.domain;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Card;
import anpopo.naranji.ft.naranjift.domains.btc.domain.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CardPersistence {
    private final CardRepository cardRepository;

    public Card save(Card card) {
        return cardRepository.save(card);
    }
}
