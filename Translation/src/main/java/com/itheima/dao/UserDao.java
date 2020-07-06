package com.itheima.dao;

import com.itheima.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    /**
     * 添加的方法
     * @param user
     */
@Insert("insert into tab_user values (null,#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email})")
   int addUser(User user);

    /**
     *根据用户名查找
     * @param username
     * @return user
     */
    @Select("select * from tab_user where username=#{username}")
   User  findUserByName(String username);

}
