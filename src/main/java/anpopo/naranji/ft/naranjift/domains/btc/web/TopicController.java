package anpopo.naranji.ft.naranjift.domains.btc.web;

import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponse;
import anpopo.naranji.ft.naranjift.domains.btc.common.NRJResponseStatus;
import anpopo.naranji.ft.naranjift.domains.btc.service.TopicService;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.CreateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.req.UpdateTopicRequestDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.CreateTopicResponseDto;
import anpopo.naranji.ft.naranjift.domains.btc.web.model.res.UpdateTopicResponseDto;
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
@RequestMapping("/topics")
@RestController
public class TopicController {

    private final TopicService topicService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NRJResponse<CreateTopicResponseDto>> createTopic(
        @RequestBody CreateTopicRequestDto createTopicRequestDto
    ) {
        CreateTopicResponseDto topic = topicService.createTopic(createTopicRequestDto);
        return ResponseEntity
            .created(URI.create(String.format("/topics/%d", topic.getTopicSeq())))
            .body(NRJResponse.ok(topic, NRJResponseStatus.SUCCESS_CREATE));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/{topicSeq}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NRJResponse<UpdateTopicResponseDto>> updateTopic(
        @PathVariable("topicSeq") Long topicSeq,
        @RequestBody UpdateTopicRequestDto updateTopicRequestDto
    ) {
        UpdateTopicResponseDto updatedTopic = topicService.updateTopic(topicSeq, updateTopicRequestDto);
        return ResponseEntity
            .ok(NRJResponse.ok(updatedTopic));
    }
}
