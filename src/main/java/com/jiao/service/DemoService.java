package com.jiao.service;

import com.jiao.Person;

/**
 * Created by Administrator on 2018/2/26.
 */
public interface DemoService {
    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithoutRollBack(Person person);
}
