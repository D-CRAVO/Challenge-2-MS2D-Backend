package fr.davidcravo.challenge_2_MS2D.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.davidcravo.challenge_2_MS2D.DTO.LearnerDTO;
import fr.davidcravo.challenge_2_MS2D.service.LearnerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@CrossOrigin(origins = "*")
@RestController
public class LearnerController {
    
    @Autowired
    private LearnerService learnerService;

    @RequestMapping(value = "/learner/{id}", method = RequestMethod.GET)
    public LearnerDTO getLearner(@PathVariable Long id){
        return learnerService.getLearner(id);
    }

    @RequestMapping(value = "/learners", method = RequestMethod.GET)
    public List<LearnerDTO> getAllLearners(){
        return learnerService.getAllLearners();
    }
    
    @RequestMapping(value = "/learners", method = RequestMethod.POST)
    public void addLearner(@RequestBody LearnerDTO learnerDTO){
        learnerService.addLearner(learnerDTO);
    }

    @RequestMapping(value = "/learner/{id}", method = RequestMethod.DELETE)
    public void deleteLearner(@PathVariable Long id){
        learnerService.deleteLearner(id);
    }
}
