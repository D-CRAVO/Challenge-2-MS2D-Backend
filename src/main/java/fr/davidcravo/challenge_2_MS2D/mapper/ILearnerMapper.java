package fr.davidcravo.challenge_2_MS2D.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.davidcravo.challenge_2_MS2D.DTO.LearnerDTO;
import fr.davidcravo.challenge_2_MS2D.model.Learner;

@Mapper
//(uses = {Group.class})
public interface ILearnerMapper {

    /**
     * Converti le learner en learnerDTO
     * @param learner
     * @return LearnerDTO
     */
    //@Mapping(source = "group", target = "groupDTO")
    LearnerDTO map(Learner learner);

    /**
     * Converti la liste de learner en liste de learnerDTO
     * @param learners
     * @return La liste des LearnerDTO
     */
    //@Mapping(source = "groups", target = "groupDTOs")
    List<LearnerDTO> map(List<Learner> learners);

    /**
     * Met à jour le learner à partir du learnerDTO
     * @param learnerDTO
     * @return
     */
    //@Mapping(source = "groupDTO", target = "group")
    Learner update(LearnerDTO learnerDTO);

    //@Mapping(source = "groupDTOs", target = "groups")
    List<Learner> update(List<LearnerDTO> learnerDTOs);
}
