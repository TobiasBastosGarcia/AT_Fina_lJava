package br.com.ProjectATFinal.Model;

import lombok.Data;

import java.util.List;

    @Data
public class Personagem {
    private int id;
    private String name;
    private String ki;
    private String maxKi;
    private String race;
    private String gender;
    private String description;
    private String image;
    private String affiliation;
    private String deletedAt = null;
    private List<Object> transformations;
    private OriginPlanet originPlanet;

}
