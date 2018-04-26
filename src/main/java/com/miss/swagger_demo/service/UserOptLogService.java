package com.miss.swagger_demo.service;

import com.miss.swagger_demo.dao.UserOptLogMapper;
import com.miss.swagger_demo.entity.UserOptLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/20
 */
@Service
public class UserOptLogService {

    private static final Logger logger = LoggerFactory.getLogger(UserOptLogService.class);

    @Autowired
    private UserOptLogMapper userOptLogMapper;

    public void addUserOptLog(UserOptLog userOptLog) {
        userOptLogMapper.addUserOptLog(userOptLog);
    }

    public void doLog(String name, String content)
    {
        UserOptLog userOptLog = new UserOptLog();
        userOptLog.setContent(content);
        userOptLog.setUser(name);
        userOptLog.setTime(new Date());
        logger.info(userOptLog.toString());
        addUserOptLog(userOptLog);
    }
}
