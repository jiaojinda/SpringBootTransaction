package com.jiao;

import com.jiao.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/2/26.
 */
    @RestController
    public class MyController {
        @Autowired
        private DemoService demoService;

    @RequestMapping("/norollback")
    public Person noRollback(Person person) {
        return demoService.savePersonWithoutRollBack(person);
    }

    @RequestMapping("/rollback")
    public Person rollback(Person person) {
        return demoService.savePersonWithRollBack(person);
    }
}