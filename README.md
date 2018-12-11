# SpringCloud 项目
## 大事记
#### 2018年12月
```201812
2018-12-04
    1.开始创建项目，一片空白
2018-12-05
    1.上传到GitHub,并新建README.MD文件，idea中安装Markdown Navigator便于编辑
    2.确定父工程管理子工程,创建父工程项目,经过对比,最后选择springBoot版本为2.0.7，springCloud版本为Finchley.SR2
    3.创建子项目eureka-server,作为服务注册中心
2018-12-06
    1.创建eureka-hello作为服务提供者（即生产者）
    2.为了进一步的高可用性,在eureka-server项目中添加peer1和peer2的配置文件，并分别启动，以达到类似集群的效果
    3.创建服务消费者ribbon项目;
    4.部分eureka-hello修改组件为eureka-client;
    5.修改配置文件的编码格式为UTF-8
2018-12-10
    1.对项目的一些内容进行了更好的了解，代码方面没有做更多的改动
    2.写了项目文档一篇：http://note.youdao.com/noteshare?id=bf22e8c2b01bff5bacced20a33229d9a&sub=656C2FD7093642CEACC6D9010D2D8F8C
2018-12-11
    1.对ribbon有了理论的了解
    2.代码方面主要添加了ribbon-consumer项目中使用restTemplate的请求方式，主要是get,post;其中post请求需要注意的是发送需用使object对象。
    3.ribbon解析同步书籍文章：http://note.youdao.com/noteshare?id=d3cad9ceaf5741208445e5ad1442465e&sub=50C8BFC252B84B20ACED4E61888D2147
```
