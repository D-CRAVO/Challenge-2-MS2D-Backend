package fr.davidcravo.challenge_2_MS2D.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import fr.davidcravo.challenge_2_MS2D.model.Learner;

@Repository
public interface ILearnerRepository extends ListCrudRepository<Learner, Long>{

}
