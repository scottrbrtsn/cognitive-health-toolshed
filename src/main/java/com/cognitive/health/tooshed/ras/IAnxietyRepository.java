package com.cognitive.health.tooshed.ras;

import com.cognitive.health.tooshed.domain.surveys.Anxiety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAnxietyRepository extends JpaRepository<Anxiety, String> {

    List<Anxiety> findByUserName(String userName);

}