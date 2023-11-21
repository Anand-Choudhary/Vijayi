package com.example.vijayi.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class InvalidInputException extends RuntimeException
{
    HttpStatus status;
    String message;

    public InvalidInputException(String invalidRequest, int i)
    {
        this.message=invalidRequest;
        this.status= HttpStatus.valueOf(i);
    }

    public String toString() {
        return String.format("Status : %s  message : %s errors : %s ",status.toString(), message);
    }

}
