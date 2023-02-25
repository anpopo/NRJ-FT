package anpopo.naranji.ft.naranjift.domains.btc.domain.repository;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Topic;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Optional<Topic> findByTopicSeqAndNowUsingTrue(Long topicSeq);
}
