所有多线程编程样例代码的实现参考了[图解Java多线程设计模式](https://book.douban.com/subject/27116724/)中对多线程和并发编程设计模式的分类

先对业务进行抽象，根据抽象的结果选择合适的多线程模型来构造任务执行的顺序模型，选用编程语言（比如Java）提供的逐渐来具体实现。

> 第1章　　Single Threaded Execution模式——能通过这座桥的只有一个人
>
> 第2章　　Immutable模式——想破坏也破坏不了
>
> 第3章　　Guarded Suspension模式——等我准备好哦　
>
> 第4章　　Balking模式——不需要就算了
>
> 第5章　　Producer-Consumer模式——我来做，你来用
>
> 第6章　　Read-Write Lock模式——大家一起读没问题，但读的时候不要写哦
>
> 第7章　　Thread-Per-Message模式——这项工作就交给你了
>
> 第8章　　Worker Thread模式——工作没来就一直等，工作来了就干活
>
> 第9章　　Future模式——先给您提货单
>
> 第10章　　Two-Phase Termination模式——先收拾房间再睡觉　
>
> 第11章　　Thread-Specific Storage模式——一个线程一个储物柜
>
> 第12章　　Active Object模式——接收异步消息的主动对象

