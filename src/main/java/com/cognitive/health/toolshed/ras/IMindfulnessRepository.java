package com.cognitive.health.toolshed.ras;

import com.cognitive.health.toolshed.domain.surveys.Mindfulness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMindfulnessRepository extends JpaRepository<Mindfulness, String> {

    List<Mindfulness> findByUserName(String userName);

}