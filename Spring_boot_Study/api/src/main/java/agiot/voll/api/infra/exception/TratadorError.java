package agiot.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorError {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return  ResponseEntity.notFound().build();
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity error404(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();


        return ResponseEntity.badRequest().body(errors.stream().map(DadosErrorVAlidacao::new).toList());
    }

    private record DadosErrorVAlidacao(String campo,String mensagem){
           public DadosErrorVAlidacao(FieldError error){
               this(error.getField(), error.getDefaultMessage());
           }
    }


}
