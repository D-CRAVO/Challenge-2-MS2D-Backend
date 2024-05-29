package fr.davidcravo.challenge_2_MS2D.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LearnerDTO {

    /**
     * Identifiant de l'apprenant
     */
    private Long id;

    /**
     * Prénom de l'apprenant
     */
    private String firstname;

    /**
     * Nom de l'apprenant
     */
    private String lastname;

    /**
     * Groupe auquel l'apprenant appartient
     */
    //private GroupDTO groupDTO;
}
