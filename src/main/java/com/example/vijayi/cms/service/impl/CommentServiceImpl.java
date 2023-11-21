package com.example.vijayi.cms.service.impl;

import com.example.vijayi.cms.api.resources.CommentDto;
import com.example.vijayi.cms.api.resources.UserCommentDto;
import com.example.vijayi.cms.db.dao.CommentDao;
import com.example.vijayi.cms.db.model.Comment;
import com.example.vijayi.cms.service.CommentService;
import com.example.vijayi.ums.db.dao.UserDao;
import com.example.vijayi.ums.db.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService
{
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private UserDao userDao;


    @Override
    public boolean createComment(UserCommentDto userCommentDto) {
        User user = new User();
        Comment comment = new Comment();
        if(userCommentDto.getCommentTo()!=null)
        {
            user.setCommentTo(userCommentDto.getCommentTo());
        }
        if(userCommentDto.getCommentFrom()!=null)
        {
            user.setCommentFrom(userCommentDto.getCommentFrom());
        }
        if(userCommentDto.getMessage()!=null)
        {
            comment.setMessage(userCommentDto.getMessage());
        }
        if(userCommentDto.getCommentTo()!=null)
        {
            List<User> userList = userDao.findByUserName(userCommentDto.getCommentTo());
            if(userList.isEmpty())
            {
                User user1 = userDao.save(user);
                comment.setUser(new User(user1.getId()));
                commentDao.save(comment);
            }
            else{
               User user2 = userList.get(0);
               comment.setUser(new User(user2.getId()));
               commentDao.save(comment);
            }
        }

        return true;
    }

    @Override
    public List<CommentDto> getCommentForUserName(String userName)
    {
        Long userId = userDao.findIdByUserName(userName);
        return commentDao.findCommentByUserId(userId);
    }
}
