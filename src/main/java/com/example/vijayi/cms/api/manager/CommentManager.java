package com.example.vijayi.cms.api.manager;

import com.example.vijayi.UserValidationService;
import com.example.vijayi.cms.api.resources.CommentDto;
import com.example.vijayi.cms.api.resources.UserCommentDto;
import com.example.vijayi.cms.service.CommentService;
import com.example.vijayi.controllers.ResponseDTO;
import com.example.vijayi.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CommentManager
{
    @Autowired
    private CommentService commentService;



    public ResponseDTO createComment(UserCommentDto userCommentDto) {
        try {
            log.info("inside comment manager create[userDto: {}]", userCommentDto);
            UserValidationService.performUserValidations(userCommentDto);
            boolean dto = commentService.createComment(userCommentDto);
            return new ResponseDTO("200", "SUCCESS", true, dto);
        }
        catch(InvalidInputException e)
        {
            return ResponseDTO.errorResponse("Invalid Request","400");
        }
        catch (Exception e) {
            log.error("Exception in comment manager create ,userDto: {}, error message: {}, trace: {}", userCommentDto, e.getMessage(), e.getStackTrace());
            throw e;
        }
    }

    public ResponseDTO getComment(String userName) {
        try {
            log.info("inside comment manager get comment[userDto: {}]", userName);
            List<CommentDto> commentDtoList = commentService.getCommentForUserName(userName);
            return new ResponseDTO("200", "SUCCESS", true, commentDtoList);
        }
        catch (Exception e) {
            log.error("Exception in comment manager get ,userName: {}, error message: {}, trace: {}", userName, e.getMessage(), e.getStackTrace());
            throw e;
        }
    }

}
