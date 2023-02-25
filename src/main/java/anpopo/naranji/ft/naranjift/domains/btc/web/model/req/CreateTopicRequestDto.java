package anpopo.naranji.ft.naranjift.domains.btc.web.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateTopicRequestDto {
    private Long boardSeq;
    private Long name;
}
