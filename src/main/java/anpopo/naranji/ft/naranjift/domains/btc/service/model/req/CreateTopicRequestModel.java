package anpopo.naranji.ft.naranjift.domains.btc.service.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateTopicRequestModel {
    private Long boardSeq;
    private String name;
}
