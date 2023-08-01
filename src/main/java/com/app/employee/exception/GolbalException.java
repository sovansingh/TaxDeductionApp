package com.app.employee.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GolbalException {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleException(Exception exception){
		Map<String, Object> map = new HashMap<>();
		map.put("TimeStamp", new Date());
		map.put("Staus", HttpStatus.values());
		String errorMsg = null;
		if(exception.getMessage()!=null) {
			errorMsg = exception.getMessage();
		}else if (exception.getCause() != null) {
			errorMsg = exception.getCause().toString();
		}else if (exception != null) {
			errorMsg = exception.toString();
		}
		map.put("error", errorMsg);
		
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
}
