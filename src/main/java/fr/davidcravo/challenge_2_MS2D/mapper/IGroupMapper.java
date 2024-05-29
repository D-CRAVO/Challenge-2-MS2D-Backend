package fr.davidcravo.challenge_2_MS2D.mapper;

import java.util.List;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import fr.davidcravo.challenge_2_MS2D.DTO.GroupDTO;
import fr.davidcravo.challenge_2_MS2D.model.Group;
import fr.davidcravo.challenge_2_MS2D.model.Learner;

import static fr.davidcravo.challenge_2_MS2D.common.ListUtils.safe;

@Mapper(uses = {Learner.class})
public interface IGroupMapper {

    /**
     * Converti la liste de group en liste de groupDTO
     * @param groups
     * @return La liste des GroupDTO
     */
    List<GroupDTO> map(List<Group> groups);

    //@Mapping(source = "learners", target = "learners")
    GroupDTO map(Group group);

    Group update(GroupDTO groupDTO);

    // @AfterMapping
    // default void afterUpdate(@MappingTarget Group group){
    //     safe(group.getLearners()).forEach(learner -> learner.setGroup(group));
    // }
}
