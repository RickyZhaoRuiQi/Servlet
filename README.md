# Servlet

---

- 什么是Servlet
	- Servlet是在服务器上运行的小程序。一个Servlet就是一个Java类，并且可以通过“请求-响应”编程模型来访问这个驻留在服务器内存里的Servlet程序。
	
- Tomcat容器等级
	- Tomcat的容器分为四个等级，Servlet的容器管理Centext容器，一个Context对应一个Web工程。
	
- 手工编写一个Servlet
	1. 继承HttpServlet
	2. 重写doGet()或者goPost()方法
	3. 在web.xml中注册Servlet
	
- 使用idea编写Servlet
    1. src->new->Servlet
    2. 重写doGet()或者dPost()方法
    3. 部署运行
    
- Servlet生命周期
    1. 初始化阶段，调用init()方法。
    2. 响应客户端请求阶段，调用service()方法。由service()方法根据提交的方式选择执行doGet()或者doPost()方法。
    3. 终止阶段，调用destroy()方法。
    - 在下列时刻Servlet容器装载Servlet
        1. Servlet容器启动时自动装载某些Servlet，实现它只需要在web.xml文件中的<Servlet></Servlet>之间添加：<loadon-startup>1</loadon-startup>数字越小表示优先级越高。
        2. 在Servlet容器启动后，客户首次向Servlet发送请求。
        3. Servlet类被更新后，重新装载Servlet。
        4. Servlet被装载后，Servlet容器创建一个Servlet实例并且调用Servlet的init()方法进行初始化。在Servlet的整个生命周期内，init()方法只被调用一次。
      
- Servlet路径跳转
    - 绝对路径：放之四海而皆准的路径。
    - 相对路径：相对于当前资源的路径。
    