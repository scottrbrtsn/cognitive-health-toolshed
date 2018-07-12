package com.cognitive.health.toolshed.ras;

import com.cognitive.health.toolshed.domain.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIndividualRepository extends JpaRepository<Individual, String> {
}
