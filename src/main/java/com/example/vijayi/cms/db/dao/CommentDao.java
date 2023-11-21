package com.example.vijayi.cms.db.dao;

import com.example.vijayi.cms.api.resources.CommentDto;
import com.example.vijayi.cms.db.model.Comment;
import com.example.vijayi.ums.db.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends CrudRepository<Comment, Long>
{

//    @Query(value = "select new com.example.vijayi.cms.api.resources.CommentDto(c)" +
//            "from Comment c where c.userId=:id")
//    public List<CommentDto> findCommentByUserId(Long id);

    @Query("SELECT NEW com.example.vijayi.cms.api.resources.CommentDto(c.message) FROM Comment c WHERE c.user.id = :id")
    public List<CommentDto> findCommentByUserId(Long id);

}
