# 生鲜商店

[[DEMO](https://fs.zinglix.xyz)] [[Docker Hub](https://hub.docker.com/r/zinglix/freshfoodstore)] [[前端](https://github.com/ZingLix/FreshFoodStore-frontend)]

这是一个在线购物系统的后端部分，以生鲜作为主题，支持

- [x] 买家购物
- [x] 卖家库存管理
- [x] 卖家进货
- [x] 采买基地供货
- [x] 资金系统

## 如何安装

首先你需要一个 `application.properties` 以控制程序相关设置，如下是示例

```
spring.datasource.url=jdbc:mysql://mysql:3306/FreshFoodStore?useSSL=false&serverTimezone=UTC    # 数据库链接，请确保存在该库
spring.datasource.username=root                 # 数据库登录用户名
spring.datasource.password=password             # 密码
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver    # driver 类型，示例为 mysql 
# server.port = 8080                            # 服务器端口，默认8080
spring.jpa.properties.hibernate.hbm2ddl.auto=update     # spring 对于数据库的处理，无需更改
xyz.zinglix.freshfoodstore.imgpath= /img/               # 上传图片的存储文件夹，请确保该路径可被正确分发，使用 docker 构建则使用该路径
```

之后提供了两种构建方式

### Maven

将 `application.properties` 放至根目录后运行

```
mvn spring-boot:run
```

之后后端服务器就会运行在 8080 端口（或根据配置中的设定）上。

### Docker

本项目还支持 Docker 方式构建。

如下为 `docker-compose.yml` 样例

```
version: "3"
services:
  store:
    image: zinglix/freshfoodstore:latest
    volumes:
      - /home/user/img:/img           # 将本机图片目录映射至 /img
      - ./application.properties:/config/application.properties      # 映射配置文件
    container_name: freshfoodstore
    ports: 
      - "8080:8080"           # 映射端口
    networks:
      - mysql_default
networks:
  mysql_default:              # 处理数据库连接
    external: true
```

之后运行 `docker-compose up -d` 即可。如果你需要将前后端同时使用 Docker 构建，看[这里](https://github.com/ZingLix/FreshFoodStore/wiki/%E4%BD%BF%E7%94%A8-Docker-%E8%BF%90%E8%A1%8C%E6%95%B4%E4%B8%AA%E7%B3%BB%E7%BB%9F)。