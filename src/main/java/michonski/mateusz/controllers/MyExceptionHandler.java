package michonski.mateusz.controllers;

import michonski.mateusz.exceptions.MyException;
import michonski.mateusz.exceptions.MyExceptionMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(MyException.class)
    public MyExceptionMessage myExceptionHandler(MyException e) {
        return e.getMyExceptionMessage();
    }
}
