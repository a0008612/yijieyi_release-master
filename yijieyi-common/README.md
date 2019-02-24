com.marry包下
* config 存放redis的配置类
* fdfs 存放fastDFS的工具类
* entity 存放po对象
* util 相关工具类
* service 
    * studentClientService 定义了服务接口：
    * stundetClientFallbackFactory Fegin提供的断路器功能，用户微服务停掉之后,断路器打开,
    执行fallbackfactory 指定的类中方法