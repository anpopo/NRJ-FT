package anpopo.naranji.ft.naranjift.domains.btc.service;

import anpopo.naranji.ft.naranjift.domains.btc.service.mapper.CardDtoMapper;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.under.CreateCardService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateCardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CreateCardService createCardService;
    private final CardDtoMapper cardDtoMapper;

    @Transactional
    public CreateCardResponseDto createCard(CreateCardRequestDto createCardRequestDto, MultipartFile cardImage) {
        CreateCardRequestModel createCardRequestModel = cardDtoMapper.toCreateCardRequestModel(createCardRequestDto);
        createCardRequestModel.setCardImage(cardImage);

        CreateCardResponseModel createCardResponseModel = createCardService.createCard(createCardRequestModel);
        return cardDtoMapper.toCreateCardResponseDto(createCardResponseModel);
    }
}
