package anpopo.naranji.ft.naranjift.domains.btc.domain.repository;

import anpopo.naranji.ft.naranjift.domains.btc.domain.entity.Board;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findByBoardSeqAndUseTrue(Long boardSeq);
}
