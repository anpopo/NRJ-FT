package anpopo.naranji.ft.naranjift.domains.btc.service;

import anpopo.naranji.ft.naranjift.domains.btc.service.mapper.TopicDtoMapper;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateTopicResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateTopicResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.under.TopicBusinessService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.UpdateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateTopicResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.UpdateTopicResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TopicService {
    private final TopicBusinessService topicBusinessService;
    private final TopicDtoMapper topicDtoMapper;


    public CreateTopicResponseDto createTopic(CreateTopicRequestDto createTopicRequestDto) {
        CreateTopicRequestModel createTopicRequestModel = topicDtoMapper.toCreateTopicRequestModel(createTopicRequestDto);
        CreateTopicResponseModel topic = topicBusinessService.createTopic(createTopicRequestModel);
        return topicDtoMapper.toCreateTopicResponseDto(topic);
    }

    public UpdateTopicResponseDto updateTopic(Long topicSeq, UpdateTopicRequestDto updateTopicRequestDto) {
        UpdateTopicRequestModel updateTopicRequestModel = topicDtoMapper.toUpdateTopicRequestModel(updateTopicRequestDto);
        updateTopicRequestModel.setTopicSeq(topicSeq);
        UpdateTopicResponseModel updatedTopic = topicBusinessService.updateTopic(updateTopicRequestModel);
        return topicDtoMapper.toUpdateTopicResponseDto(updatedTopic);
    }
}
