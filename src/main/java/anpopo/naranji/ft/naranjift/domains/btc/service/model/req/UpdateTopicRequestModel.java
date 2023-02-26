package anpopo.naranji.ft.naranjift.domains.btc.service.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateTopicRequestModel {
    private Long boardSeq;
    private Long topicSeq;
    private String name;

    public void setTopicSeq(Long topicSeq) {
        this.topicSeq = topicSeq;
    }
}
