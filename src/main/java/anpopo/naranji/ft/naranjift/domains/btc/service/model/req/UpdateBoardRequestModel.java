package anpopo.naranji.ft.naranjift.domains.btc.service.model.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateBoardRequestModel {
    private Long boardSeq;
    private String title;

    public void setBoardSeq(Long boardSeq) {
        this.boardSeq = boardSeq;
    }
}
