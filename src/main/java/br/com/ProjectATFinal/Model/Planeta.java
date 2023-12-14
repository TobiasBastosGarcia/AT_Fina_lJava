package br.com.ProjectATFinal.Model;
import lombok.Data;

import java.util.List;
@Data
public class Planeta {
    private int id;
    private String name;
    private Boolean isDestroyed;
    private String description;
    private String image;
    private String deletedAt;
    private List<Object> characters;

}
