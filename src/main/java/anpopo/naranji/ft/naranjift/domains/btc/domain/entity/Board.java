package anpopo.naranji.ft.naranjift.domains.btc.domain.entity;

import anpopo.naranji.ft.naranjift.domains.btc.common.BaseAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
@Table(name = "boards")
@Entity
public class Board extends BaseAuditEntity {

    @Id
    @Column(name = "board_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "now_using", nullable = false)
    @ColumnDefault("true")
    private boolean nowUsing;

    @Builder
    public Board(String title) {
        this.title = title;
        this.nowUsing = true;
    }
}
