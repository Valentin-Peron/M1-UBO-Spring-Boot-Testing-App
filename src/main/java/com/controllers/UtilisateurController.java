package com.controllers;

import com.dtos.UtilisateurDto;
import org.springframework.web.bind.annotation.*;

import com.services.impl.UtilisateurServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurServiceImpl utilisateurService;

    public UtilisateurController(UtilisateurServiceImpl utilisateurService) { this.utilisateurService = utilisateurService; }

    /**
     * <p>Get all utilisateurs</p>
     * @return List<UtilisateurDto>
     */
    @GetMapping
    public List<UtilisateurDto> getUtilisateurs() { return utilisateurService.getAllUtilisateurs(); }

    /**
     * Get utilisateur by Id
     */
    @GetMapping("/{id}")
    public UtilisateurDto getUtilisateurById(@PathVariable Long id){
        return utilisateurService.getUtilisateurById(id);
    }

    /**
     * Create a new utilisateur in the system
     */
    @PostMapping
    public UtilisateurDto saveUtilisateur(final @RequestBody UtilisateurDto utilisateurDto){
        return utilisateurService.saveUtilisateur(utilisateurDto);
    }

    /**
     * Delete a utilisateur by it's id
     */
    @DeleteMapping("/{id}")
    public Boolean deleteUtilisateur(@PathVariable Long id){
        return utilisateurService.deleteUtilisateur(id);
    }
}
