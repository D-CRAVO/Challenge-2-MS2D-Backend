package fr.davidcravo.challenge_2_MS2D.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Learner {
    /**
     * Identifiant de l'apprenant
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Prénom de l'apprenant
     */
    private String firstname;

    /**
     * Nom de l'apprenant
     */
    @NotNull
    private String lastname;

    /**
     * Groupe auquel l'apprenant appartient
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_id")
    private Group group;

    // public void SetGroupId(Long id){
    //     this.group.setId(id);
    // }
}
