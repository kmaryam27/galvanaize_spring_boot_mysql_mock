package com.galvanize.gitarsapi.repositories;

import com.galvanize.gitarsapi.entities.Gitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitarRepository extends JpaRepository<Gitar, Long> {
}
