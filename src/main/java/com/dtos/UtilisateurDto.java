package com.dtos;

import lombok.Data;

@Data
public class UtilisateurDto {

    private Long id;
    private String login;
    private String nom;
    private String prenom;
    private String mail;

}
