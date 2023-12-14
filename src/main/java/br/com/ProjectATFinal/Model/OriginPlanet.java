package br.com.ProjectATFinal.Model;

import lombok.Data;

@Data
public class OriginPlanet {
    private int id;
    private String name;
    private Boolean isDestroyed;
    private String description;
    private String image;
    private String deletedAt = null;



}
