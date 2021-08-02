package com.example.exception.advice;

import com.example.exception.controller.ApiController;
import com.example.exception.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

// 글로벌하게 예외처리를 해주는 클래스
// 범위를 제한할 수도 있다.
@RestControllerAdvice(basePackageClasses = ApiController.class) // json 형태로 결과 반환
//@ControllerAdvice // 뷰 리졸버로 결과 반환
public class GlobalControllerAdvice {

    // 모든 예외를 다잡는다.
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println("exception");
        System.out.println(e.getClass().getName());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }

    // 특정 예외를 잡는다.
    // @Valid의 경우 바인딩이 실패가되면 MethodArgumentNotValidException 을 발생
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        System.out.println("MethodArgumentNotValidException");
        List<Error> errorList = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(error -> {
            FieldError field = (FieldError) error;
            String name = field.getField();
            String message = field.getDefaultMessage();
            String value = field.getRejectedValue().toString();

            Error errorMessage = new Error();
            errorMessage.setField(name);
            errorMessage.setMessage(message);
            errorMessage.setInvalidValue(value);
            errorList.add(errorMessage);
        });

//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseAction(errorList, request));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }
}
