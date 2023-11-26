package com.example.vijayi;

import com.example.vijayi.cms.api.resources.UserCommentDto;
import com.example.vijayi.exception.InvalidInputException;
import com.example.vijayi.ums.api.resources.UserDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidationService
{
    public static Boolean userNameValidation(String name)
    {
        if (containsSpecialCharacter(name))
        {
            throw new InvalidInputException("Invalid Request",400);
        }
        return true;
    }

    public static Boolean containsSpecialCharacter(String name)
    {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        Matcher matcher = pattern.matcher(name);

        return !matcher.matches();
    }
    public static void performUserValidations(UserCommentDto userCommentDto) throws InvalidInputException{
        userNameValidation(userCommentDto.getCommentFrom());
        userNameValidation(userCommentDto.getCommentTo());
    }

}
