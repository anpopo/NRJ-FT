package anpopo.naranji.ft.naranjift.domains.btc.service;

import anpopo.naranji.ft.naranjift.domains.btc.service.annotation.FirstServiceLayer;
import anpopo.naranji.ft.naranjift.domains.btc.service.mapper.BoardDtoMapper;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateBoardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.under.CreateBoardService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateBoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@FirstServiceLayer
public class BoardService {

    private final CreateBoardService boardCreateService;
    private final BoardDtoMapper boardDtoMapper;

    @Transactional
    public CreateBoardResponseDto createBoard(CreateBoardRequestDto createBoardRequestDto) {
        CreateBoardRequestModel createBoardRequestModel = boardDtoMapper.toCreateBoardRequestModel(createBoardRequestDto);
        CreateBoardResponseModel board = boardCreateService.createBoard(createBoardRequestModel);
        return boardDtoMapper.toCreateBoardResponseDto(board);
    }
}
