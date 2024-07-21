package fr.davidcravo.challenge_2_MS2D.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.davidcravo.challenge_2_MS2D.DTO.GroupDTO;
import fr.davidcravo.challenge_2_MS2D.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@CrossOrigin(origins = "*")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public List<GroupDTO> getAllGroups(){
        return groupService.getAllGroups();
    }
    
    @RequestMapping(value = "/create-groups", method = RequestMethod.POST)
    public void createAllGroups(@RequestBody int nb){
        groupService.createAllGroups(nb);
    }
}
