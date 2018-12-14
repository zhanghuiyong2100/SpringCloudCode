# SpringCloud 项目
## 大事记
### 2018年12月 启始

#### 2018-12-04 创建项目

1. 开始创建项目，一片空白

#### 2018-12-05 创建父项目及eureka子项目

1. 上传到GitHub,并新建README.MD文件，idea中安装Markdown Navigator便于编辑
2. 确定父工程管理子工程,创建父工程项目,经过对比,最后选择springBoot版本为2.0.7，springCloud版本为Finchley.SR2
3. 创建子项目eureka-server,作为服务注册中心
4. 补充父项目的文档说明:[1 创建父工程项目springcloud-project](http://note.youdao.com/noteshare?id=ef82aa4473d6b14f5a43a7ffe070bb88&sub=8FE577EF990943B9A0FA7F8EA4A56E4B)

#### 2018-12-06 服务提供以及消费者ribbon

1. 创建eureka-hello作为服务提供者（即生产者）
2. 为了进一步的高可用性,在eureka-server项目中添加peer1和peer2的配置文件，并分别启动，以达到类似集群的效果
3. 创建服务消费者ribbon项目;
4. 部分eureka-hello修改组件为eureka-client;
5. 修改配置文件的编码格式为UTF-8

#### 2018-12-10 项目整理

1. 对项目的一些内容进行了更好的了解，代码方面没有做更多的改动
2. 写了项目文档一篇：[2 创建服务管理项目Eureka](https://note.youdao.com/share/?id=bf22e8c2b01bff5bacced20a33229d9a&type=note#/)

#### 2018-12-11 Ribbon理论

1. 对ribbon有了理论的了解
2. 代码方面主要添加了ribbon-consumer项目中使用restTemplate的请求方式，主要是get,post;其中post请求需要注意的是发送需用使object对象。
3. ribbon解析同步书籍文章：[第4章 客户端负载均衡：Spring Cloud Ribbon](http://note.youdao.com/noteshare?id=d3cad9ceaf5741208445e5ad1442465e&sub=50C8BFC252B84B20ACED4E61888D2147)

#### 2018-12-12 断路由Hystrix,服务消费Feign

0. 今日知识点关键词汇:Hystrix,断路由,雪崩,Feign
1. 开启了断路由Hystrix的学习
2. 在ribbon-consumer项目中天下netfix-hystrix的依赖，并进行相关的配置,值得注意的是请求时间过长引起的保护机制
3. 相关内容的有道云笔记:[第四篇 断路器（Hystrix）](http://note.youdao.com/noteshare?id=0d720db065bc0c3db2553be4fb30c267&sub=EC7C1BC7B7DC452A8B99A52CD4E448DA)
4. 根据博文,完善服务消费Feign功能,并且发现貌似好像还更好用一点
5. 创建feign-service项目，并进行了相应的get,post请求，一点心得：post中接收数据最好一致
6. 相关内容有道云笔记：[第三篇 服务消费者（Feign）](http://note.youdao.com/noteshare?id=7ca6a23f108e607c56674165657d7674&sub=E98F372DC51A462CBD1A39EC044F194D)

#### 2018-12-13 路由网关zuul
0. 今日知识点关键词汇:Zuul,路由网关
1. 创建zuul-service项目

#### 2018-12-14 zuul过滤
0. 今日知识点关键词汇:过滤,config,动态配置，git
1. 昨天由于公司的项目没有继续下去,所以今天继续完善项目，添加了拦截器的功能MyFilter.java类
2. 相关内容笔记:[第五篇  路由网关(zuul)](http://note.youdao.com/noteshare?id=5a2fd632e830bff42958d8191ab6ca0f&sub=EF6F617BFE954F1582AD3A8D21C0CD22)
3. 创建config-server项目

