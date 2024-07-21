package fr.davidcravo.challenge_2_MS2D.service;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.davidcravo.challenge_2_MS2D.DTO.LearnerDTO;
import fr.davidcravo.challenge_2_MS2D.mapper.ILearnerMapper;
import fr.davidcravo.challenge_2_MS2D.repository.ILearnerRepository;

@Service
public class LearnerService {

    @Autowired
    private ILearnerRepository learnerRepository;

    private final ILearnerMapper learnerMapper = (ILearnerMapper) Mappers.getMapper(ILearnerMapper.class);

    /**
     * Récupère la liste de tous les apprenants 
     * @return La liste de tous les apprenants
     */
    public List<LearnerDTO> getAllLearners(){
        return learnerMapper.map(learnerRepository.findAll());
    }

    /**
     * Récupère un apprenant d'après son identifiant
     * @param id Identifiant de l'apprenant
     * @return Un apprenant
     */
    public LearnerDTO getLearner(Long id){
        return learnerMapper.map(learnerRepository.findById(id).orElse(null));
    }

    /**
     * Ajoute un apprenant
     * @param learnerDTO
     */
    public void addLearner(LearnerDTO learnerDTO){
        learnerRepository.save(learnerMapper.update(learnerDTO));
    }

    /**
     * Supprime un apprenant d'après son identifiant
     * @param id Identifiant de l'apprenant
     */
    public void deleteLearner(Long id){
        learnerRepository.deleteById(id);
    }
}
