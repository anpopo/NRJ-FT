package anpopo.naranji.ft.naranjift.domains.btc.service.mapper;

import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateBoardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateBoardResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardDtoMapper {

    CreateBoardRequestModel toCreateBoardRequestModel(CreateBoardRequestDto createBoardRequestDto);

    CreateBoardResponseDto toCreateBoardResponseDto(CreateBoardResponseModel board);
}
