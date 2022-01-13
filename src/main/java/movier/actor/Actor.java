package movier.actor;

import lombok.*;
import movier.moviecharacter.MovieCharacter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    //private String birthplace;
    //private Date birthdate;
    private String imageUrl;
    private String biography;

    @OneToMany(mappedBy = "actor")
    private List<MovieCharacter> movieCharacters;
}
