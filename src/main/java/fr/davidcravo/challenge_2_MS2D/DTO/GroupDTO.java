package fr.davidcravo.challenge_2_MS2D.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GroupDTO {

    /**
     * Identifiant du groupe
     */
    private Long id;

    /**
     * Nom du groupe
     */
    private String name;

    /** 
     * Liste des apprenants du groupe
     */
    private List<LearnerDTO> learners;
}
