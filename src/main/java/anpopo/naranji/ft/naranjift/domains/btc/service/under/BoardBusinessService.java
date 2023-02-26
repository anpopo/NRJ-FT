package anpopo.naranji.ft.naranjift.domains.btc.service.under;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.domain.BoardPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Board;
import anpopo.naranji.ft.naranjift.domains.btc.exception.NRJCommonException;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateBoardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateBoardResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardBusinessService {

    private final BoardPersistence boardPersistence;

    @Transactional
    public CreateBoardResponseModel createBoard(CreateBoardRequestModel createBoardRequestModel) {
        Board board = Board.builder()
            .title(createBoardRequestModel.getTitle())
            .build();

        Board createdBoard = boardPersistence.saveBoard(board);

        return CreateBoardResponseModel.builder()
            .boardSeq(createdBoard.getBoardSeq())
            .title(createdBoard.getTitle())
            .build();
    }

    @Transactional
    public UpdateBoardResponseModel updateBoard(UpdateBoardRequestModel updateBoardRequestModel) {
        Board updatedBoard = boardPersistence.findByBoardSeqAndNowUsingTrue(updateBoardRequestModel.getBoardSeq())
            .map(board -> {
                board.updateTitle(updateBoardRequestModel.getTitle());
                return board;
            })
            .orElseThrow(() -> new NRJCommonException(
                NRJResponseStatus.ERROR_NOT_FOUND,
                String.format("%d - 존재하지 않는 보드")
            ));

        return UpdateBoardResponseModel.builder()
            .boardSeq(updatedBoard.getBoardSeq())
            .title(updatedBoard.getTitle())
            .updatedAt(updatedBoard.getUpdatedAt())
            .build();
    }
}
