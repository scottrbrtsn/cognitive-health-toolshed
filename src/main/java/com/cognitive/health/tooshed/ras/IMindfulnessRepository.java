package com.cognitive.health.tooshed.ras;

import com.cognitive.health.tooshed.domain.surveys.Mindfulness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMindfulnessRepository extends JpaRepository<Mindfulness, String> {

    List<Mindfulness> findByUserName(String userName);

}