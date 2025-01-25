package org.example.Repository;

import org.example.Entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
