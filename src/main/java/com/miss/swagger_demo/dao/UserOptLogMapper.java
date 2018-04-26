package com.miss.swagger_demo.dao;

import com.miss.swagger_demo.entity.UserOptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/20
 */
@Repository
@Mapper
public interface UserOptLogMapper {

    @Insert("INSERT INTO user_opt_log (user, time, content) VALUES (#{user},#{time},#{content})")
    void addUserOptLog(UserOptLog userOptLog);

}
