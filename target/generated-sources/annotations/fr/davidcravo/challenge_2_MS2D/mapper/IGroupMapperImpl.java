package fr.davidcravo.challenge_2_MS2D.mapper;

import fr.davidcravo.challenge_2_MS2D.DTO.GroupDTO;
import fr.davidcravo.challenge_2_MS2D.DTO.LearnerDTO;
import fr.davidcravo.challenge_2_MS2D.model.Group;
import fr.davidcravo.challenge_2_MS2D.model.Learner;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T12:22:28+0200",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240620-1855, environment: Java 17.0.11 (Eclipse Adoptium)"
)
public class IGroupMapperImpl implements IGroupMapper {

    private final Learner learner = new Learner();

    @Override
    public List<GroupDTO> map(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDTO> list = new ArrayList<GroupDTO>( groups.size() );
        for ( Group group : groups ) {
            list.add( map( group ) );
        }

        return list;
    }

    @Override
    public GroupDTO map(Group group) {
        if ( group == null ) {
            return null;
        }

        Long id = null;
        List<LearnerDTO> learners = null;
        String name = null;

        id = group.getId();
        learners = learnerListToLearnerDTOList( group.getLearners() );
        name = group.getName();

        GroupDTO groupDTO = new GroupDTO( id, name, learners );

        return groupDTO;
    }

    @Override
    public Group update(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group group = learner.getGroup();

        group.setId( groupDTO.getId() );
        group.setLearners( learnerDTOListToLearnerList( groupDTO.getLearners() ) );
        group.setName( groupDTO.getName() );

        return group;
    }

    protected LearnerDTO learnerToLearnerDTO(Learner learner) {
        if ( learner == null ) {
            return null;
        }

        String firstname = null;
        Long id = null;
        String lastname = null;

        firstname = learner.getFirstname();
        id = learner.getId();
        lastname = learner.getLastname();

        LearnerDTO learnerDTO = new LearnerDTO( id, firstname, lastname );

        return learnerDTO;
    }

    protected List<LearnerDTO> learnerListToLearnerDTOList(List<Learner> list) {
        if ( list == null ) {
            return null;
        }

        List<LearnerDTO> list1 = new ArrayList<LearnerDTO>( list.size() );
        for ( Learner learner : list ) {
            list1.add( learnerToLearnerDTO( learner ) );
        }

        return list1;
    }

    protected Learner learnerDTOToLearner(LearnerDTO learnerDTO) {
        if ( learnerDTO == null ) {
            return null;
        }

        Learner learner = new Learner();

        learner.setFirstname( learnerDTO.getFirstname() );
        learner.setId( learnerDTO.getId() );
        learner.setLastname( learnerDTO.getLastname() );

        return learner;
    }

    protected List<Learner> learnerDTOListToLearnerList(List<LearnerDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Learner> list1 = new ArrayList<Learner>( list.size() );
        for ( LearnerDTO learnerDTO : list ) {
            list1.add( learnerDTOToLearner( learnerDTO ) );
        }

        return list1;
    }
}
