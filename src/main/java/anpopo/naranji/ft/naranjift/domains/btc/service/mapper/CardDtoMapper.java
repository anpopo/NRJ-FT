package anpopo.naranji.ft.naranjift.domains.btc.service.mapper;

import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.SingleCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.UpdateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateCardResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.SingleCardResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.UpdateCardResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardDtoMapper {
    CreateCardRequestModel toCreateCardRequestModel(CreateCardRequestDto createCardRequestDto);

    CreateCardResponseDto toCreateCardResponseDto(CreateCardResponseModel card);

    UpdateCardRequestModel toUpdateCardRequestModel(UpdateCardRequestDto updateCardRequestDto);

    UpdateCardResponseDto toUpdateCardResponseDto(UpdateCardResponseModel createCardResponseModel);

    SingleCardResponseDto toSingleCardResponseDto(SingleCardResponseModel singleCardResponseModel);
}
