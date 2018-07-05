package com.cognitive.health.tooshed.ras;

import com.cognitive.health.tooshed.domain.surveys.Personality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonalityRepository extends JpaRepository<Personality, String> {

    List<Personality> findByUserName(String userName);

}