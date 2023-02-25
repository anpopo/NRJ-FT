package anpopo.naranji.ft.naranjift.domains.btc.service.under;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.domain.BoardPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.TopicPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Topic;
import anpopo.naranji.ft.naranjift.domains.btc.exception.NRJCommonException;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateTopicResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTopicService {

    private final BoardPersistence boardPersistence;
    private final TopicPersistence topicPersistence;

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
}
