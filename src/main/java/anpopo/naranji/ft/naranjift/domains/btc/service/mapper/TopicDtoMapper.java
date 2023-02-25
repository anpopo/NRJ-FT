package anpopo.naranji.ft.naranjift.domains.btc.service.mapper;

import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateTopicRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateTopicResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateTopicResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TopicDtoMapper {
    CreateTopicRequestModel toCreateTopicRequestModel(CreateTopicRequestDto createTopicRequestDto);

    CreateTopicResponseDto toCreateTopicResponseDto(CreateTopicResponseModel topic);
}
