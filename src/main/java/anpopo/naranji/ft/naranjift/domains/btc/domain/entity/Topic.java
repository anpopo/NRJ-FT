package anpopo.naranji.ft.naranjift.domains.btc.domain.entity;

import anpopo.naranji.ft.naranjift.domains.btc.common.BaseAuditEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Table(name = "topics", indexes = {
        @Index(name = "idx_topics_board_seq", columnList = "board_seq")
})
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

    @Column(name = "now_using", nullable = false)
    @ColumnDefault("true")
    private boolean nowUsing;

    @Builder
    public Topic(String name, Long boardSeq) {
        this.name = name;
        this.boardSeq = boardSeq;
        this.nowUsing = true;
    }

    public void updateTopicName(String name) {
        this.name = name;
    }
}
