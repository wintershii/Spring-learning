package com.winter.service;

import com.winter.domain.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    private static Map<Integer, Person> map = new HashMap<Integer, Person>();

    private static Integer id = 1;

    static {
        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.setId(id++);
            p.setAge(10 + i);
            p.setName("shidongxuan" + i);
            map.put(i,p);
        }
    }

    //获取人员列表
    public List<Person> findAll() {
        return new ArrayList<Person>(map.values());
    }

    //新增人员信息
    public void insert(Person p) {
        id++;
        p.setId(id);
        map.put(id,p);
    }
}
