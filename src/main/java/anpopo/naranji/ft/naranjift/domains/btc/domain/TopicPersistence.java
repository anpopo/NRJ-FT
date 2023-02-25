package anpopo.naranji.ft.naranjift.domains.btc.domain;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Topic;
import anpopo.naranji.ft.naranjift.domains.btc.domain.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TopicPersistence {
    private final TopicRepository topicRepository;

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }
}
