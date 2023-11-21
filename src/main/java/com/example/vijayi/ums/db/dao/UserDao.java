package com.example.vijayi.ums.db.dao;

import com.example.vijayi.ums.db.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long>
{
    @Query(value ="SELECT u FROM User u  WHERE (u.commentTo = :username)")
    public List<User> findByUserName(String username);
    @Query(value ="SELECT u.id FROM User u  WHERE (u.commentTo = :username)")
    public Long findIdByUserName(String username);
}
