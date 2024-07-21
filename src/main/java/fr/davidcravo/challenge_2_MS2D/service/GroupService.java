package fr.davidcravo.challenge_2_MS2D.service;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.davidcravo.challenge_2_MS2D.DTO.GroupDTO;
import fr.davidcravo.challenge_2_MS2D.mapper.IGroupMapper;
import fr.davidcravo.challenge_2_MS2D.model.Group;
import fr.davidcravo.challenge_2_MS2D.model.Learner;
import fr.davidcravo.challenge_2_MS2D.repository.IGroupRepository;
import fr.davidcravo.challenge_2_MS2D.repository.ILearnerRepository;

@Service
public class GroupService {

    @Autowired
    IGroupRepository groupRepository;

    @Autowired
    ILearnerRepository learnerRepository;

    private static IGroupMapper groupMapper = (IGroupMapper) Mappers.getMapper(IGroupMapper.class);
    
    

    /**
     * Récupère la liste des groupes
     * @return
     */
    public List<GroupDTO> getAllGroups(){
        return groupMapper.map(groupRepository.findAll());
    }

    /**
     * Supprime tous les groupes
     */
    public void deleteAllGroups(){
        groupRepository.deleteAll();
    }


    public void createAllGroups(int numberOfGroups){

        /**
         *On supprime tous les groupes de la base de données
         */
        groupRepository.deleteAll();

        
        /**
         * On récupère le liste des apprenants que l'on stocke dans learners
         */
        List<Learner> learners = learnerRepository.findAll();

        /**
         * On récupère le nombre d'apprenants que l'on stocke dans numberOfLearners
         */
        int numberOfLearners = (int) learnerRepository.count();
        System.out.println(numberOfGroups);
        System.out.println(numberOfLearners);

        /**
         * On calcule le nombre d'apprenants par groupe en prenant l'entier inférieur
         * à la division du nombre d'apprenants par le nombre de groupes
         * que l'on stocke dans numberOfLearnersByGroup
         */
        int numberOfLearnersByGroup = (int) Math.ceil((double)numberOfLearners/numberOfGroups);
        System.out.println(numberOfLearnersByGroup);


        int j = 1;

        List<Group> groups = new ArrayList<>();

        for (int i = 0; i < numberOfLearners; i+= numberOfLearnersByGroup) {

            

            /**
             * On détermine le nombre effectif d'apprenants pouvant être ajoutés dans le groupe
             * Si le nombre total d'apprenants est inférieur au nombre d'apprenants que l'on peut techniquement
             * stocker, le nombre retenu pour la suite du traitement sera le nombre total d'apprenants 
             */
            //int numberOfEffectiveLearners = Math.min(i + numberOfLearnersByGroup, numberOfLearners);

            /**
             * On extrait une partie de la liste des apprenants en fonction du nombre d'apprenants restant
             * que l'on stocke dans groupOfLearners
             */
            // List<Learner> groupOfLearners = learners.subList(i, numberOfEffectiveLearners);
            List<Learner> groupOfLearners = learners.subList(i, numberOfLearners);

            /**
             * On détermine le nom du groupe en fonction de l'itérateur j incrémenté à chaque création de groupe
             */
            StringBuilder sb = new StringBuilder();
            String nameOfGroup = sb.append("Groupe ").append(j).toString();
            //String nameOfGroup = "essai";

            /**
             * On crée un nouveau groupe avec son nom créé précédemment
             * ainsi que la liste des apprenants appartenant à ce groupe
             */
            Group group = new Group(nameOfGroup, groupOfLearners);


            /**
             * On met à jour le nouveau groupe auquel il appartient maintenant pour chaque apprenant
             */
            for (Learner learner : groupOfLearners){
                learner.setGroup(group);
            }

            /**
             * On ajoute le group fraichement créé à une liste de groupe
             * créée pour la future sauvegarde
             */
            groups.add(group);

            /**
             * On incrémente j pour modifier le nom du prochain groupe
             */
            j++;
        }

        

        
        /**
         * On sauvegarde l'ensemble des groupes dans la base de données
         */
        groupRepository.saveAll(groups);
    }
}
