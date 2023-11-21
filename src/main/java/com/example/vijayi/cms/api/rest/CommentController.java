package com.example.vijayi.cms.api.rest;

import com.example.vijayi.cms.api.manager.CommentManager;
import com.example.vijayi.cms.api.resources.CommentDto;
import com.example.vijayi.cms.api.resources.UserCommentDto;
import com.example.vijayi.controllers.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CommentController
{
    @Autowired
    private CommentManager commentManager;

    @PostMapping(value = "/add-comment")
    public ResponseDTO addComment (@RequestBody UserCommentDto userCommentDto)
    {
        return commentManager.createComment(userCommentDto);
    }

    @GetMapping(value = "/get-comment/{userName}")
    public ResponseDTO<CommentDto> getComment(@PathVariable(name = "userName") String userName)
    {
        return commentManager.getComment(userName);
    }
}
