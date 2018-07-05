package com.cognitive.health.tooshed.ras;

import com.cognitive.health.tooshed.domain.surveys.Flow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFlowRepository extends JpaRepository<Flow, String> {

    List<Flow> findByUserName(String userName);

}
