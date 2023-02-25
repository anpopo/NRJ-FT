package anpopo.naranji.ft.naranjift.domains.btc.domain;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Board;
import anpopo.naranji.ft.naranjift.domains.btc.domain.repository.BoardRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardPersistence {

    private final BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    public Optional<Board> findByBoardSeqAndNowUsingTrue(Long boardSeq) {
        return boardRepository.findByBoardSeqAndNowUsingTrue(boardSeq);
    }
}
