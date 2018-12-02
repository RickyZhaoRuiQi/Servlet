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
    
---

- 通过ServletConfig获取初始化参数
    - 在web.xml中赋予初始化参数，在servlet中通过getInitParameter()方法获取初始化参数
- MVC模式：MVC(Model,View,Controller)，是软件开发过程中比较流行的设计思想。旨在分离模型、控制、视图。是一种分层思想的体现
    - 一般->jsp（视图），servlet（控制），javabean（模型）
- model2
    - model1：JSP+JavaBeans+DB
    - model2：Model2开发模型就是MVC思想的体现，DB，JavaBean（M），Servlet（C），JSP（V）
    
---

- 使用Servlet技术实现购物车效果
    - MVC模型实现（Jsp+Servlet+dao）
        1. 创建购物车类
        2. 编写Servlet
        3. 创建页面层