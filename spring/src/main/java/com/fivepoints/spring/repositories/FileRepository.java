package com.fivepoints.spring.repositories;

import com.fivepoints.spring.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Integer> {
}
