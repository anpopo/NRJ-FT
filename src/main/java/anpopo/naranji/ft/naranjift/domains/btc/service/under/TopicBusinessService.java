package anpopo.naranji.ft.naranjift.domains.btc.service.under;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.domain.BoardPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.TopicPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Topic;
import anpopo.naranji.ft.naranjift.domains.btc.exception.NRJCommonException;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateTopicResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateTopicResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TopicBusinessService {

    private final BoardPersistence boardPersistence;
    private final TopicPersistence topicPersistence;

    @Transactional
    public CreateTopicResponseModel createTopic(CreateTopicRequestModel createTopicRequestModel) {
        Topic topic = boardPersistence.findByBoardSeqAndNowUsingTrue(createTopicRequestModel.getBoardSeq())
            .map(board -> topicPersistence.save(
                Topic.builder()
                    .boardSeq(board.getBoardSeq())
                    .name(createTopicRequestModel.getName())
                    .build()))
            .orElseThrow(() -> new NRJCommonException(
                NRJResponseStatus.ERROR_NOT_FOUND,
                String.format("%d - 존재하지 않는 보드",
                    createTopicRequestModel.getBoardSeq())
            ));

        return CreateTopicResponseModel.builder()
            .topicSeq(topic.getTopicSeq())
            .name(topic.getName())
            .build();
    }

    @Transactional
    public UpdateTopicResponseModel updateTopic(UpdateTopicRequestModel updateTopicRequestModel) {
        Topic updatedTopic = topicPersistence.findByBoardSeqAndTopicSeqAndNowUsingTrue(
                updateTopicRequestModel.getBoardSeq(), updateTopicRequestModel.getTopicSeq())
            .map(topic -> {
                topic.updateTopicName(updateTopicRequestModel.getName());
                return topic;
            })
            .orElseThrow(() -> new NRJCommonException(
                NRJResponseStatus.ERROR_NOT_FOUND,
                String.format("%d - 존재하지 않는 토픽",
                    updateTopicRequestModel.getTopicSeq())
            ));

        return UpdateTopicResponseModel.builder()
            .topicSeq(updatedTopic.getTopicSeq())
            .name(updatedTopic.getName())
            .updatedAt(updatedTopic.getUpdatedAt())
            .build();
    }
}
