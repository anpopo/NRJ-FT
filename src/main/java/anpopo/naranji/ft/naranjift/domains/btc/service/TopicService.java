package anpopo.naranji.ft.naranjift.domains.btc.service;

import anpopo.naranji.ft.naranjift.domains.btc.service.annotation.FirstServiceLayer;
import anpopo.naranji.ft.naranjift.domains.btc.service.mapper.TopicDtoMapper;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateTopicResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.under.CreateTopicService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateTopicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@FirstServiceLayer
public class TopicService {
    private final CreateTopicService createTopicService;
    private final TopicDtoMapper topicDtoMapper;

    @Transactional
    public CreateTopicResponseDto createTopic(CreateTopicRequestDto createTopicRequestDto) {
        CreateTopicRequestModel createTopicRequestModel = topicDtoMapper.toCreateTopicRequestModel(createTopicRequestDto);
        CreateTopicResponseModel topic = createTopicService.createTopic(createTopicRequestModel);
        return topicDtoMapper.toCreateTopicResponseDto(topic);
    }
}
