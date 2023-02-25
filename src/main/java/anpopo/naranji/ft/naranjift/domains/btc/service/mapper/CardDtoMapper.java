package anpopo.naranji.ft.naranjift.domains.btc.service.mapper;

import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateCardResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardDtoMapper {
    CreateCardRequestModel toCreateCardRequestModel(CreateCardRequestDto createCardRequestDto);

    CreateCardResponseDto toCreateCardResponseDto(CreateCardResponseModel card);
}
