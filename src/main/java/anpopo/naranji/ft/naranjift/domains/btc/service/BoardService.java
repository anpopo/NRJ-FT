package anpopo.naranji.ft.naranjift.domains.btc.service;

import anpopo.naranji.ft.naranjift.domains.btc.service.mapper.BoardDtoMapper;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateBoardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateBoardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.under.BoardBusinessService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.UpdateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateBoardResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.UpdateBoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardBusinessService boardBusinessService;
    private final BoardDtoMapper boardDtoMapper;


    public CreateBoardResponseDto createBoard(CreateBoardRequestDto createBoardRequestDto) {
        CreateBoardRequestModel createBoardRequestModel = boardDtoMapper.toCreateBoardRequestModel(createBoardRequestDto);
        CreateBoardResponseModel board = boardBusinessService.createBoard(createBoardRequestModel);
        return boardDtoMapper.toCreateBoardResponseDto(board);
    }

    public UpdateBoardResponseDto updateBoard(Long boardSeq, UpdateBoardRequestDto updateBoardRequestDto) {
        UpdateBoardRequestModel updateBoardRequestModel = boardDtoMapper.toUpdateBoardRequestModel(updateBoardRequestDto);
        updateBoardRequestModel.setBoardSeq(boardSeq);
        UpdateBoardResponseModel updatedBoard = boardBusinessService.updateBoard(updateBoardRequestModel);
        return boardDtoMapper.toUpdateBoardResponseDto(updatedBoard);
    }
}
