package com.miss.swagger_demo;

import com.miss.swagger_demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SplitTest {

    @Test
    public void testString() {
        String taskIds = "1;2;3";
//        if (taskIds.endsWith(";")) {
//
//            taskIds = taskIds.substring(0, taskIds.length()-1);
//            System.out.println("jinlaile");
//        }
//        System.out.println(taskIds);

        String taskId[] = taskIds.split(";");


//        User user = new User();
//        user.setName("");
//        int i = 0;
//        for(String taskid : taskId)
//        {
//            user.setName(taskid+";"+user.getName());
//            System.out.println(i+"**"+taskid);
//        }
//        System.out.println(user.getName());
    }

}
