package com.cognitive.health.tooshed.ras;

import com.cognitive.health.tooshed.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Models the database itself. This interface is automatically implemented by Spring, filling in the signatures with implementations based on the names
 * @author scottrobertson
 *
 */
@Repository
public interface IUserInfoRepository extends JpaRepository<UserInfo, String> {
    List<UserInfo> findByName(String name);

    List<UserInfo> findById(long id);

}
