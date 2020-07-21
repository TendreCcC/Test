package com.itheima.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.Service.RouteService;
import com.itheima.dao.RouteDao;
import com.itheima.entity.Route;
import com.itheima.utils.DaoInstanceFactory;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao= DaoInstanceFactory.getBean(RouteDao.class);
    @Override
    public PageInfo findListByPage(int page,String rname) {
        int size=5;
        PageHelper.startPage(page,size);
        List<Route> routes = routeDao.findListByPage(rname);
        PageInfo pageInfo = new PageInfo (routes);
        return pageInfo;
    }

    @Override
    public void deleteByRid(int rid) {
        int row = routeDao.deleteByRid(rid);
    }
}
