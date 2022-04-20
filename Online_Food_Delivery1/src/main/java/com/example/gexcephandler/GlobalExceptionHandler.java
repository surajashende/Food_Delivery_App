package com.example.gexcephandler;

	import java.time.LocalDateTime;

	import org.springframework.dao.EmptyResultDataAccessException;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.MethodArgumentNotValidException;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.context.request.WebRequest;
	import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.custom_exception.UserHandlingException;
import com.example.dto.*;

	
	@ControllerAdvice
	public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
		
		@ExceptionHandler(EmptyResultDataAccessException.class)
		public ResponseEntity<?> handleEmptyDataException(EmptyResultDataAccessException e){
			System.out.println("in handle run time exeception "+e);
			com.example.dto.ErrorResponse resp = new ErrorResponse(e.getMessage(),LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
			
		}

		@ExceptionHandler(RuntimeException.class)
		public ResponseEntity<?> handleRuntimeException(RuntimeException e){
			System.out.println("in handle run time exeception "+e);
			ErrorResponse resp = new ErrorResponse("Adding user failed!!! ",LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
			
		}
		
		@ExceptionHandler(UserHandlingException.class)
		public ResponseEntity<?> handleUserHandlingExceptin(UserHandlingException e){
			System.out.println("in handle user exeception "+e);
			ErrorResponse resp = new ErrorResponse(e.getMessage(),LocalDateTime.now());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
			
		}

		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
				HttpHeaders headers, HttpStatus status, WebRequest request) {
				System.out.println("in handle invalid method args");
				System.out.println(ex.getBindingResult().getFieldErrors());
				StringBuilder sb = new StringBuilder("validation Errors: ");
				ex.getBindingResult().getFieldErrors().forEach(e->sb.append(e.getDefaultMessage()+" "));
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ErrorResponse(sb.toString(),LocalDateTime.now()));
		}
		
	}



