package com.miss.swagger_demo.exception;

/**
 * 业务异常捕获
 * @author miss
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends Exception{
	//异常返回的信息
	private Object rspObj; 
	
	public ServiceException(){

	}
	
	public ServiceException(Object rspObj){
		super();
		this.rspObj = rspObj;
	}

	public Object getRspObj() {
		return rspObj;
	}

	public void setRspObj(Object rspObj) {
		this.rspObj = rspObj;
	}

	
}
