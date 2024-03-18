package uz.pdp.springbootstart.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.pdp.springbootstart.dto.response.ErrorDto;
import uz.pdp.springbootstart.exception.QovunAuthException;



@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(QovunAuthException.class)
    public ResponseEntity<ErrorDto> qovunAuthExceptionHandler(QovunAuthException e) {
        log.warn("Authorization exception");
          return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                  .body(new ErrorDto(e.getMessage(), 401));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ErrorDto> qovunAuthExceptionHandler(BindException e) {
        StringBuilder errors = new StringBuilder();
        e.getAllErrors().forEach(error -> {
            errors.append(error.getDefaultMessage()).append("\n");
        });
        log.warn("Authorization exception");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(errors.toString(), 400));
    }
}
