# jkm-SpringCloud1


基于Spring Cloud实现的一个简单的数据库增删查改系统，包含以下微服务：

1. Eureka Server 服务注册中心
2. 操作数据库CRUD的模块
3. 提供RESTful API的模块
4. 路由网关

用户的请求均发送至路由网关，再由路由网关将请求发送至模块3，模块3调用模块2提供的服务实现具体的操作。
