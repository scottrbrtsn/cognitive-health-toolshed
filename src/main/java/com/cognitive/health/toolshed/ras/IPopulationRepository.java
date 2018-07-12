package com.cognitive.health.toolshed.ras;

import com.cognitive.health.toolshed.domain.Population;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPopulationRepository extends JpaRepository<Population, String> {
}
