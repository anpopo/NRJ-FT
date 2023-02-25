package anpopo.naranji.ft.naranjift.domains.btc.web.model.res;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateBoardResponseDto {
    private Long boardSeq;
    private String title;
}
