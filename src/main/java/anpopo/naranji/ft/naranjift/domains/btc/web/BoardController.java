package anpopo.naranji.ft.naranjift.domains.btc.web;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponse;
import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.service.BoardService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateBoardResponseDto;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

    private final BoardService boardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<NRJResponse<CreateBoardResponseDto>> createBoard(
        @RequestBody CreateBoardRequestDto createBoardRequestDto
    ) {
        CreateBoardResponseDto board = boardService.createBoard(createBoardRequestDto);
        return ResponseEntity
            .created(URI.create(String.format("/boards/%d", board.getBoardSeq())))
            .body(NRJResponse.ok(board, NRJResponseStatus.SUCCESS_CREATE));
    }
}
