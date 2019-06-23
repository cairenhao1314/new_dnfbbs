# dnfbbs
新DNF论坛系统
===
## 工具+环境
IDEA
JDK 1.8
Tomcat 8.0
## 技术
前端使用的是Springboot推荐的前端模板引擎Themeleaf,后端使用的是主流的Spring + SpringMVC + Mybatis 框架，数据库使用的是Mysql。通过LayUI使得本项目的用户交互性更人性化。
## 角色
* 游客
* 会员
* 版主
* 管理员
## 各个角色的权限
* 游客：具有看帖，注册为会员的功能。
* 会员：发帖，看帖，回帖，购买徽章，查看其它用户的个人信息、发表的帖子，点赞，回复楼中楼功能。
* 版主：板块帖子管理。
* 管理员：用户管理，查看网站近期数据统计。
## 项目展示
>>首页
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/index.png)  
>>主题板块
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/posts.png)  
>>发帖
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/post.png)  
>>主题帖子
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/theme_post.png)  
>>楼中楼
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/reply.png)  
>>回复楼中楼
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/reply_emji.png)  
>>其他用户的个人信息
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/otherinfo.png)  
>>其他用户的发帖纪录
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/other_posts.png)  
>>徽章页面
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/bandge.png)  
>>登录页面
![](https://github.com/cairenhao1314/new_dnfbbs/raw/master/show_img/login.png)  

## 本人负责
数据库的设计，前端页面后后台功能的实现。
## 不足和待改进的地方
网站管理员后台没有实现，应该可以统计网站相关的数据，比如网站的访问量，近期的注册用户，各个板块的发帖情况等等。
