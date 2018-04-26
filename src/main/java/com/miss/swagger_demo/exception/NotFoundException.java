package com.miss.swagger_demo.exception;

/**
 * 异常：无法找到某个实体对象
 * 
 * @author miss
 *
 */
public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
        super(message);
    }
}
