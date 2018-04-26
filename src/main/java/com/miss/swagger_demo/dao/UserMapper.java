package com.miss.swagger_demo.dao;

import com.miss.swagger_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/19
 */
@Mapper
@Repository
public interface UserMapper {

    @Insert("INSERT INTO user (name,pwd) VALUES (#{name},#{pwd})")
    void addUser(User user);

    @Select("SELECT * FROM user")
    List<User> getUsers();

    @Select("SELECT * FROM user WHERE name = #{name}")
    User getUserByName(@Param("name") String name);
}
