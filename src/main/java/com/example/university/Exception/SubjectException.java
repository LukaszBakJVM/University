package com.example.university.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT ,reason = ("Taki przedmiot już jest na liście"))

public class SubjectException extends RuntimeException{
}
