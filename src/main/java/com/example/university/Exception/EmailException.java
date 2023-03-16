package com.example.university.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT ,reason = ("Taka osoba jest już zapisana"))
public class EmailException extends RuntimeException{
}
