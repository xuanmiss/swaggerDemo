package com.miss.swagger_demo.config;

import com.miss.swagger_demo.annotation.RestWrapper;
import com.miss.swagger_demo.exception.NotFoundException;
import com.miss.swagger_demo.exception.ServiceException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMappingJacksonResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author miss
 * <p>全局异常控制和结果封装
 * Created by miss on 2018/4/20
 */
@RestControllerAdvice
public class GlobalControllerAdvice extends AbstractMappingJacksonResponseBodyAdvice{


    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);

    /**
     * 默认异常处理，返回500错误
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseInfo<String> defaultExceptionHandler(HttpServletRequest req,
                                                        Exception e) {
        return getExpResponse(req, e);
    }

    /**
     * 无法找到映射handler的异常处理，返回404错误
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseInfo<String> NoHandlerFoundExceptionHandler(
            HttpServletRequest req, Exception e) {
        return getExpResponse(req, e);
    }

    /**
     * 无法找到实体，返回204
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseInfo<String> NotFoundExceptionHandler(
            HttpServletRequest req, Exception e) {
        return getExpResponse(req, e);
    }

    /**
     * 业务层异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseInfo<Object> ServiceExceptionHandler(HttpServletRequest req,
                                                        Exception e) {
        ServiceException es = (ServiceException) e;
        logger.error("请求:{}，传回的对象:{}", req.getRequestURL().toString(),
                es.getRspObj()); // 记录错误信息
        return new ResponseInfo<>("fail", es.getMessage(),null);
    }

    private ResponseInfo<String> getExpResponse(HttpServletRequest req,
                                                Exception e) {
        logger.error("异常", e);
        logger.error("请求:{}，发生异常:{}", req.getRequestURL().toString(),
                ExceptionUtils.getMessage(e)); // 记录错误信息
        return new ResponseInfo<>("fail", e.getMessage(), null);
    }

    @Override
    protected void beforeBodyWriteInternal(MappingJacksonValue bodyContainer,
                                           MediaType contentType, MethodParameter returnType,
                                           ServerHttpRequest request, ServerHttpResponse response) {
        if (returnType.getMethod().isAnnotationPresent(RestWrapper.class)) {
            // updated by zjq add returnType to the method getWrapperResponse
            bodyContainer.setValue(getWrapperResponse(returnType, request,
                    bodyContainer.getValue()));
        }
    }
        private ResponseInfo getWrapperResponse(MethodParameter returnType,
                ServerHttpRequest req,
                Object data) {
            RestWrapper wrapper=returnType.getMethod().getAnnotation(RestWrapper.class);

//        System.out.println("CODE:"+wrapper.code()+",MSG:"+wrapper.msg());

            return new ResponseInfo(wrapper.code(), wrapper.message(), data);
        }
}
