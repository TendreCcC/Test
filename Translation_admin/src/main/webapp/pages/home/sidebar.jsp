<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<base href="${pageContext.request.contextPath}/">
<aside class="main-sidebar">
    <section class="sidebar">

        <div class="user-panel">
            <div class="pull-left image">
                <img src="img/avatar5.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>管理员</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <!-- Optionally, you can add icons to the links -->
            <li class="active"><a href="index.jsp" onclick="setSidebarActive(this)"><i class="fa fa-link"></i> <span>首页</span></a></li>
            <li><a href="#"><i class="fa fa-link"></i> <span>分类管理</span></a></li>
            <li class="treeview">
                <a href="#"><i class="fa fa-link"></i> <span>线路管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/route?action=listByPage&page=1" onclick="setSidebarActive(this)" target="iframe">线路查询</a></li>
                    <li><a href="pages/route/route_add.jsp" onclick="setSidebarActive(this)" target="iframe">线路添加</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
