package com.cognitive.health.toolshed.ras;

import com.cognitive.health.toolshed.domain.surveys.Depression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepressionRepository extends JpaRepository<Depression, String> {

    List<Depression> findByUserName(String userName);

}