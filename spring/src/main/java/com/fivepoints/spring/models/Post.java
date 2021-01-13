package com.fivepoints.spring.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titre;
    private String description;

 public Post(){}

  public Post(String titre, String description) {

      this.titre = titre;
      this.description = description;
  }
    public Long getId() {
        return this.id;
    }

    public String getTitre() {
        return this.titre;
    }

    public String getDescription() {
        return this.description;
    }


    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
