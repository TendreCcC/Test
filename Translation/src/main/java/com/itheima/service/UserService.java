package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.entity.User;
import com.itheima.exception.CustomerErrorMsgException;
import com.itheima.utils.DaoInstanceFactory;
import com.itheima.utils.Md5Utils;

public class UserService {
    //获取实体类对象
    private UserDao userDao=DaoInstanceFactory.getBean(UserDao.class);

    /**
     *  通过传入的user添加
     * @param user
     * @return  row 返回添加的行数
     */
    public int register(User user) {
        String password = user.getPassword();
        String md5 = Md5Utils.getMd5(password);//通过Md5将密码加密
        user.setPassword(md5);
        int row = userDao.addUser(user);
        return row;//返回行数
    }

    /**
     * 根据所查询的username来进行判断用户是否存在
     * 存在返回用户不存在返回null
     * @param username
     * @return
     */
    public boolean isUserExists(String username){
      return userDao.findUserByName(username)!=null;
    }

    /**
     *  用户登录判断
     * @param username
     * @param password
     * @return
     * @throws CustomerErrorMsgException
     */
    public User login(String username,String password) throws CustomerErrorMsgException {
        //根据用户名在数据库里查找调用dao层里的方法
        User userByName = userDao.findUserByName(username);
        if(userByName==null){
            //做判断如果查询为空则抛出异常用户错误
            throw new CustomerErrorMsgException("用户名错误");
        }else {
            //不为空则进行密码的加密判断
            String md5 = Md5Utils.getMd5(password);
            String password1 = userByName.getPassword();
            if(!password1.equals(md5)){
                throw new CustomerErrorMsgException("密码错误");
            }
            return userByName;
        }
    }
}
