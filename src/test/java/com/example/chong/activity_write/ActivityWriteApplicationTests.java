package com.example.chong.activity_write;

import com.example.chong.activity_write.service.IActivityService;
import com.example.chong.activity_write.service.IPetCircleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ActivityWriteApplicationTests {

    @Autowired
    IActivityService activityService;

    @Autowired
    IPetCircleService petCircleService;


    @Test
    void contextLoads(){

    }

}
