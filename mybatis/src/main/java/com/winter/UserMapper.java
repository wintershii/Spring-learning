package com.winter;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<Person> findAll(int id);
    List<Person> selectSingle(@Param("name") String name, @Param("age") int age);

    int insert(Person person);
    int updateById(Person person);
    int deleteById(int id);
}
