package com.example.university.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT ,reason = ("Taki student juz istnieje"))
public class StudentEmailException extends RuntimeException{
}
