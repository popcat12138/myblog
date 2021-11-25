## JAVAWEB多人博客系统
使用mysql数据库，数据库文件Blog.sql，导入脚本创建数据库blog
项目连接数据库blog，密码password
MVC结构
# 网站：www.zifeiwo.com

# Java企业级开发与实践项目内容
   使用课堂所学知识完成一个简单博客网站的分析、设计和编程实现。要求完成整个Web应用的前端编程和后端服务器编程，实现一个完整的基于Web的信息系统。
   博客网站中个人用户即普通用户，可以自己注册一个博客用户，注册时登记自己的一些基本信息和用户的一个简单描述，并设置登录的用户名和密码；注册用户登录网站后，可以修改自己注册时填写的用户信息，也可以修改自己的密码；可以发表、修改和删除自己的博客文章；用户可以添加自己的文章类型、修改类型和删除类型；删除文章类型时，如果文章类型已经被文章使用，则不能删除；在发表文章时必须选择一个自己添加过的文章类型；用户只能使用和管理自己添加的文章类型，不和其它用户共享文章类型。
   网站的管理员可以管理网站上的所有用户（包括普通用户和管理员用户），可以查看和检索各个用户的信息，可以添加这两类用户，也可以修改用户信息，也可以为用户设置一个新密码，可以禁用一个用户，禁用后，此用户就不能再登录网站。管理员用户不能自己注册，只能别的管理员添加；管理员禁用管理员用户时，不能禁用自己（这里还有漏洞）。管理员禁用和启用用户时、设置用户密码时，需要记录操作日志（至少要记录操作类型、操作人、操作日期），并可以按用户查询操作日志和查询全部操作日志。
   访客不用登录就可以查看所有用户发表的文章，但是只能查看不能修改，可以按文章名称模糊查询所有用户的文章，可以按日期查看最近发表的文章，可以按用户名字和用户的描述信息搜索用户，然后访问这个用户发表的文章，可以查看选定用户的所有文章，也可以按他自己的分类查看各类文章，可以浏览每篇文章的具体内容。访客的功能其他用户也可以使用。
   登录用户在浏览别人的文章时，可以发表评论，也可以回复别人的评论。管理员可查看所有用户的评论，并可以删除（禁用方式）评论，禁用的评论不能在出现在普通客户的显示界面中，但可以出现在管理员查看评论的界面上。
   用户登录成功和失败时，均记录登录日志，管理员后台可查询登录日志。
   用户的信息至少包括，用户的登录名、密码、用户的姓名、性别、出生日期、手机、Email、微信号、描述信息、注册日期、最后修改日期等。
   文章信息至少包括：文章的ID，文章标题，文章类型，文章内容，发表日期，最后修改日期等信息。
选做功能：
1. 登录时添加图片验证码；
2. 文章内容的输入使用富文本组件；
3. 修改密码使用Ajax方式；
4. 个人信息里添加上传头像功能；

# 数据库结构
![image](https://user-images.githubusercontent.com/80198566/143457064-70a3a4b1-fc41-4485-acc0-eba0a0ac5eb3.png)
![image](https://user-images.githubusercontent.com/80198566/143457155-b36c4626-0fed-48ed-bd72-1d645c9ec037.png)
![image](https://user-images.githubusercontent.com/80198566/143457217-0a66dc01-5f8d-4c01-94a0-cf9efccce67c.png)
![image](https://user-images.githubusercontent.com/80198566/143457271-8199a695-0896-4f3d-9677-45382973b32d.png)

