package com.services;

import com.dtos.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {
    /**
     * insérer un utilisateur
     */
    UtilisateurDto saveUtilisateur(UtilisateurDto utilisateurDto);

    /**
     * retourner un utilisateur
     */
    UtilisateurDto getUtilisateurById(Long utilisateurId);

    /**
     * supprimer un utilisateur
     */
    boolean deleteUtilisateur(Long utilisateurId);

    /**
     * retourner tous les utilisateurs
     */
    List<UtilisateurDto> getAllUtilisateurs();
}
