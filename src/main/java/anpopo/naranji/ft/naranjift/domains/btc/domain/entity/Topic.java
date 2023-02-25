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
@Table(name = "topics")
@Entity
public class Topic extends BaseAuditEntity {

    @Id
    @Column(name = "topic_seq", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicSeq;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "board_seq", nullable = false)
    private Long boardSeq;

    @Column(name = "use", nullable = false)
    @ColumnDefault("true")
    private boolean isUse;

    @Builder
    public Topic(String name, Long boardSeq) {
        this.name = name;
        this.boardSeq = boardSeq;
        isUse = true;
    }
}
