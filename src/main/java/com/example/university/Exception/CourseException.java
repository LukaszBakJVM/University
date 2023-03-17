package com.example.university.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT ,reason = ("Taki kierunek już jest na liście"))
public class CourseException extends RuntimeException{
}
