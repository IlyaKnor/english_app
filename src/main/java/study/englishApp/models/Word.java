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
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "word")
    private String word;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "lang_id", referencedColumnName = "id")
    private Language lang;

    public Word(String word, Language lang) {
        this.word = word;
        this.lang = lang;
    }
}
