package com.example.vijayi.cms.service;

import com.example.vijayi.cms.api.resources.CommentDto;
import com.example.vijayi.cms.api.resources.UserCommentDto;
import com.example.vijayi.cms.db.model.Comment;

import java.util.List;

public interface CommentService
{
    boolean createComment(UserCommentDto userCommentDto);

    List<CommentDto> getCommentForUserName (String userName);
}
