package anpopo.naranji.ft.naranjift.domains.btc.domain.repository;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Card;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByTopicSeqAndCardSeq(Long topicSeq, Long cardSeq);

    Optional<Card> findByCardSeq(Long cardSeq);
}
