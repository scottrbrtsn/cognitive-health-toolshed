package com.cognitive.health.toolshed.ras;

import com.cognitive.health.toolshed.domain.surveys.Anxiety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnxietyRepository extends JpaRepository<Anxiety, String> {

    List<Anxiety> findByUserName(String userName);

}