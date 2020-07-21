package com.itheima.dao;

import com.itheima.entity.Route;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface RouteDao {


    /**
     * 查询所有线路的详情按照rid降序
     * * @return
     */
   //@Select("select * from tab_route order by rid desc")
   List<Route>findListByPage(@Param("rname") String rname);


   @Delete("delete from tab_route where rid=#{rid}")
   int deleteByRid(int rid);
}
