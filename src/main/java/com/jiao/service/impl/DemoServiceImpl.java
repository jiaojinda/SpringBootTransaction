package com.jiao.service.impl;

import com.jiao.Person;
import com.jiao.PersonRepository;
import com.jiao.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/2/26.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("jiao")) {
            throw new IllegalArgumentException("jiao 已存在，数据将回滚");
        }
        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    @Override
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if (person.getName().equals("jiao")) {
            throw new IllegalArgumentException("jiao已存在，但数据不会回滚");
        }
        return p;
    }
}