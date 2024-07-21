package fr.davidcravo.challenge_2_MS2D.mapper;

import fr.davidcravo.challenge_2_MS2D.DTO.LearnerDTO;
import fr.davidcravo.challenge_2_MS2D.model.Learner;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-21T16:39:31+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
public class ILearnerMapperImpl implements ILearnerMapper {

    @Override
    public LearnerDTO map(Learner learner) {
        if ( learner == null ) {
            return null;
        }

        Long id = null;
        String firstname = null;
        String lastname = null;

        id = learner.getId();
        firstname = learner.getFirstname();
        lastname = learner.getLastname();

        LearnerDTO learnerDTO = new LearnerDTO( id, firstname, lastname );

        return learnerDTO;
    }

    @Override
    public List<LearnerDTO> map(List<Learner> learners) {
        if ( learners == null ) {
            return null;
        }

        List<LearnerDTO> list = new ArrayList<LearnerDTO>( learners.size() );
        for ( Learner learner : learners ) {
            list.add( map( learner ) );
        }

        return list;
    }

    @Override
    public Learner update(LearnerDTO learnerDTO) {
        if ( learnerDTO == null ) {
            return null;
        }

        Learner learner = new Learner();

        learner.setId( learnerDTO.getId() );
        learner.setFirstname( learnerDTO.getFirstname() );
        learner.setLastname( learnerDTO.getLastname() );

        return learner;
    }

    @Override
    public List<Learner> update(List<LearnerDTO> learnerDTOs) {
        if ( learnerDTOs == null ) {
            return null;
        }

        List<Learner> list = new ArrayList<Learner>( learnerDTOs.size() );
        for ( LearnerDTO learnerDTO : learnerDTOs ) {
            list.add( update( learnerDTO ) );
        }

        return list;
    }
}
