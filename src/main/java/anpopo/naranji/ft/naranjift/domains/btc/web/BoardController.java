package anpopo.naranji.ft.naranjift.domains.btc.web;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponse;
import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.service.BoardService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.UpdateBoardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateBoardResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.UpdateBoardResponseDto;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NRJResponse<CreateBoardResponseDto>> createBoard(
        @RequestBody CreateBoardRequestDto createBoardRequestDto
    ) {
        CreateBoardResponseDto board = boardService.createBoard(createBoardRequestDto);
        return ResponseEntity
            .created(URI.create(String.format("/boards/%d", board.getBoardSeq())))
            .body(NRJResponse.ok(board, NRJResponseStatus.SUCCESS_CREATE));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{boardSeq}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NRJResponse<UpdateBoardResponseDto>> updateBoard(
        @PathVariable("boardSeq") Long boardSeq,
        @RequestBody UpdateBoardRequestDto updateBoardRequestDto
    ) {
        UpdateBoardResponseDto board = boardService.updateBoard(boardSeq, updateBoardRequestDto);
        return ResponseEntity
            .ok(NRJResponse.ok(board));
    }
}
