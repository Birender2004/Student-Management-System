package project.example.studentManagementSystem.exception;


import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class globalException{

    @ExceptionHandler(customException.class)
    public ResponseEntity<String> handleException(customException obj){
        return new ResponseEntity<>(obj.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> generalException(Exception obj){
        return new ResponseEntity<>("Error: " + obj.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(invalidInput.class)
    public ResponseEntity<String> handleInvalidInput(invalidInput obj){
        return new ResponseEntity<>("Invalid Input with error: "+obj.getMessage(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> getMessage(MethodArgumentNotValidException obj){
         String variable = obj.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

         return new ResponseEntity<>(variable, HttpStatus.BAD_REQUEST);
    }

}
