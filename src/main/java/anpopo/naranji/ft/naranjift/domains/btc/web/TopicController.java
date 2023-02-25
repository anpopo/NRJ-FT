package anpopo.naranji.ft.naranjift.domains.btc.web;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponse;
import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.service.TopicService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateTopicResponseDto;
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
@RequestMapping("/topics")
@RestController
public class TopicController {

    private final TopicService topicService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<NRJResponse<CreateTopicResponseDto>> createTopic(
        @RequestBody CreateTopicRequestDto createTopicRequestDto
    ) {
        CreateTopicResponseDto topic = topicService.createTopic(createTopicRequestDto);
        return ResponseEntity
            .created(URI.create(String.format("/topics/%d", topic.getTopicSeq())))
            .body(NRJResponse.ok(topic, NRJResponseStatus.SUCCESS_CREATE));
    }
}
