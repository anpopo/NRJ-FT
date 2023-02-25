package anpopo.naranji.ft.naranjift.domains.btc.web;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponse;
import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.service.CardService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateCardResponseDto;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/cards")
@RequiredArgsConstructor
@RestController
public class CardController {
    private final CardService cardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(
        consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<NRJResponse<CreateCardResponseDto>> createCard(
        @RequestPart(name = "createCardRequestDto") CreateCardRequestDto createCardRequestDto,
        @RequestPart(name = "cardImage", required = false) MultipartFile cardImage
    ) {
        CreateCardResponseDto card = cardService.createCard(createCardRequestDto, cardImage);
        return ResponseEntity
            .created(URI.create(String.format("/cards/%d", card.getCardSeq())))
            .body(NRJResponse.ok(card, NRJResponseStatus.SUCCESS_CREATE));
    }

}
