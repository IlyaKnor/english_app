package study.englishApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
