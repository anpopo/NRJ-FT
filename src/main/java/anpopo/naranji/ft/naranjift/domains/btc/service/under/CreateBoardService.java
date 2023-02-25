package anpopo.naranji.ft.naranjift.domains.btc.service.under;

import anpopo.naranji.ft.naranjift.domains.btc.domain.BoardPersistence;
import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Board;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateBoardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateBoardResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateBoardService {

    private final BoardPersistence boardPersistence;

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
}
