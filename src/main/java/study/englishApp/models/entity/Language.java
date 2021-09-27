package study.englishApp.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "language")
    private String language;

    @Override
    public String toString() {
        return "Language{" +
                "language='" + language + '\'' +
                '}';
    }
}
