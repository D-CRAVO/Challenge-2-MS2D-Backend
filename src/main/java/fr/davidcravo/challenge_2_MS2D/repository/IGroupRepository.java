package fr.davidcravo.challenge_2_MS2D.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import fr.davidcravo.challenge_2_MS2D.model.Group;

@Repository
public interface IGroupRepository extends ListCrudRepository<Group, Long>{

}
