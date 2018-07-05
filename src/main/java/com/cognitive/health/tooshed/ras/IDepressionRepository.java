package com.cognitive.health.tooshed.ras;

import com.cognitive.health.tooshed.domain.surveys.Depression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepressionRepository extends JpaRepository<Depression, String> {

    List<Depression> findByUserName(String userName);

}