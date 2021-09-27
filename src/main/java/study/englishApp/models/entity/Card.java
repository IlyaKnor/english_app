package study.englishApp.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "card")
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "word_id", referencedColumnName = "id")
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private Word word;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "translation_id", referencedColumnName = "id")
    private Word translation;

}
