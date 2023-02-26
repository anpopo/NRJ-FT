package anpopo.naranji.ft.naranjift.domains.btc.service;

import anpopo.naranji.ft.naranjift.domains.btc.service.mapper.CardDtoMapper;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.CreateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.req.UpdateCardRequestModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.CreateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.SingleCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.model.res.UpdateCardResponseModel;
import anpopo.naranji.ft.naranjift.domains.btc.service.under.CardBusinessService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.UpdateCardRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateCardResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.SingleCardResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.UpdateCardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CardBusinessService cardBusinessService;
    private final CardDtoMapper cardDtoMapper;


    public CreateCardResponseDto createCard(CreateCardRequestDto createCardRequestDto, MultipartFile cardImage) {
        CreateCardRequestModel createCardRequestModel = cardDtoMapper.toCreateCardRequestModel(createCardRequestDto);
        createCardRequestModel.setCardImage(cardImage);

        CreateCardResponseModel createCardResponseModel = cardBusinessService.createCard(createCardRequestModel);
        return cardDtoMapper.toCreateCardResponseDto(createCardResponseModel);
    }

    public UpdateCardResponseDto updateCard(
        Long cardSeq, UpdateCardRequestDto updateCardRequestDto, MultipartFile cardImage) {
        UpdateCardRequestModel updateCardRequestModel = cardDtoMapper.toUpdateCardRequestModel(updateCardRequestDto);
        updateCardRequestModel.setCardSeq(cardSeq);
        updateCardRequestModel.setCardImage(cardImage);

        UpdateCardResponseModel createCardResponseModel = cardBusinessService.updateCard(updateCardRequestModel);
        return cardDtoMapper.toUpdateCardResponseDto(createCardResponseModel);
    }

    public SingleCardResponseDto getSingleCard(Long cardSeq) {
        SingleCardResponseModel singleCard = cardBusinessService.getSingleCard(cardSeq);
        return cardDtoMapper.toSingleCardResponseDto(singleCard);
    }
}
