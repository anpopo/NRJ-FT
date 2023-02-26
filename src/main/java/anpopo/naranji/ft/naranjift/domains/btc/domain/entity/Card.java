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
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
@DynamicUpdate
@Table(name = "cards")
@Entity
public class Card extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardSeq;

    @Column(name = "card_name", nullable = false)
    private String cardName;

    @Column(name = "card_content", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String cardContent;

    @Column(name = "card_image_url")
    private String cardImageUrl;

    @Column(name = "topic_seq", nullable = false)
    private Long topicSeq;

    @Builder
    public Card(String cardName, String cardContent, String cardImageUrl, Long topicSeq) {
        this.cardName = cardName;
        this.cardContent = cardContent;
        this.cardImageUrl = cardImageUrl;
        this.topicSeq = topicSeq;
    }

    public void updateCard(String cardName, String cardContent, String cardImageUrl) {
        this.cardName = cardName;
        this.cardContent = cardContent;
        if (StringUtils.hasText(cardImageUrl)) {
            this.cardImageUrl = cardImageUrl;
        }
    }
}
