package fr.davidcravo.challenge_2_MS2D.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
@NoArgsConstructor
@Table(name = "groupe")
public class Group {

    public Group(String nameOfGroup, List<Learner> learners) {
        this.name = nameOfGroup;
        this.learners = learners;
    }

    public Group(String nameOfGroup) {
        this.name = nameOfGroup;
    }

    /**
     * Identifiant du groupe
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Nom du groupe
     */
    @NotNull
    private String name;

    /**
     * Liste des apprenants du groupe
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private List<Learner> learners;
}
