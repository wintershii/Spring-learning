package com.winter;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


public interface KidMapper {

    @Select({"SELECT id,name,num,birthDate FROM t_kids WHERE id = #{id}"})
    Kid selectById(Integer id);

    //不需要返回主键的insert
    @Insert({"INSERT INTO t_kids VALUES (DEFAULT, #{name}, #{num}, #{birthDate, jdbcType=DATE})"})
    int insert(Kid kid);


}
