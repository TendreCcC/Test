package com.itheima.Service;

import com.github.pagehelper.PageInfo;
import com.itheima.entity.Route;

import java.util.List;

public interface RouteService {
    PageInfo findListByPage(int page,String rname);

    public void deleteByRid(int rid);
}
