package anpopo.naranji.ft.naranjift.domains.btc.service.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class CreateBoardResponseModel {
    private Long boardSeq;
    private String title;
}
