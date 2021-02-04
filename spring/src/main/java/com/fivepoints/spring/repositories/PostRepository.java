package com.fivepoints.spring.repositories;

import com.fivepoints.spring.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
        //   get Posts By Titre
        public List<Post> getPostsByTitre(String titre);
        //    get Posts by Titre and Description
        public List<Post> getPostsByTitreAndDescription(String titre, String description);
        // Custum SQL Query


}
