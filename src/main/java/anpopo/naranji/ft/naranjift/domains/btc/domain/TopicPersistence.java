package anpopo.naranji.ft.naranjift.domains.btc.domain;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Topic;
import anpopo.naranji.ft.naranjift.domains.btc.domain.repository.TopicRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TopicPersistence {
    private final TopicRepository topicRepository;

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Optional<Topic> findByTopicSeqAndNowUsingTrue(Long topicSeq) {
        return topicRepository.findByTopicSeqAndNowUsingTrue(topicSeq);
    }

    public Optional<Topic> findByBoardSeqAndTopicSeqAndNowUsingTrue(Long boardSeq, Long topicSeq) {
        return topicRepository.findByBoardSeqAndTopicSeqAndNowUsingTrue(boardSeq, topicSeq);
    }
}
