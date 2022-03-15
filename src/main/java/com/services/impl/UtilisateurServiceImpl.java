package com.services.impl;

import com.dtos.DogDto;
import com.dtos.UtilisateurDto;
import com.entities.Dog;
import com.entities.Utilisateur;
import com.repositories.DogRepository;
import com.repositories.UtilisateurRepository;
import com.services.UtilisateurService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("utilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) { this.utilisateurRepository = utilisateurRepository; }

    @Override
    public UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto) {
        //convert dto to entity
        Utilisateur utilisateur = utilisateurDtoToEntity(utilisateurDto);
        //save utilisateur
        utilisateur = utilisateurRepository.save(utilisateur);
        //return new dto
        return utilisateurEntityToDto(utilisateur);
    }

    @Override
    public UtilisateurDto getUtilisateurById(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        return utilisateurEntityToDto(utilisateur);
    }

    public boolean deleteUtilisateur(Long utilisateurId) {
        utilisateurRepository.deleteById(utilisateurId);
        return true;
    }

    @Override
    public List<UtilisateurDto> getAllUtilisateurs() {
        List<UtilisateurDto> utilisateurDtos = new ArrayList<>();
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        utilisateurs.forEach(utilisateur -> {
            utilisateurDtos.add(utilisateurEntityToDto(utilisateur));
        });
        return utilisateurDtos;
    }

    /**
     * map utilisateur dto vers utilisateur entity
     */
    private UtilisateurDto utilisateurEntityToDto(Utilisateur utilisateur){
        UtilisateurDto utilisateurDto = new UtilisateurDto();
        utilisateurDto.setId(utilisateur.getId());
        utilisateurDto.setLogin(utilisateur.getLogin());
        utilisateurDto.setNom(utilisateur.getNom());
        utilisateurDto.setPrenom(utilisateur.getPrenom());
        utilisateurDto.setMail(utilisateur.getMail());
        return utilisateurDto;
    }

    /**
     * map utilisateur vers utilisateur dto
     */
    private Utilisateur utilisateurDtoToEntity(UtilisateurDto utilisateurDto){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setLogin(utilisateurDto.getLogin());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMail(utilisateurDto.getMail());
        return utilisateur;
    }
}
