# SessionControlPro
test
test
SessionControl控制<br>
启动方式:运行app.java<br>
项目git地址https://github.com/windbyzkl/SessionControlPro<br>
使用spring boot框架写的简单模拟会话的项目<br>
大致完成了4个基本要求 也实现了 <br>
支持动态调整并发参数， <br>
支持动态调整所有session时长<br>
可优雅停止(比如等所有session stop后再退出<br>
不过xml格式的body类的规范看的不是很懂 自己写了个自己理解的类<br>
大致设计思路就是通过map的存储功能去实现的 以SessionId为K 对应HttpBody中的action为value<br>
在请求时就创建一个HttpBody对象 并存入map中 在一定时间后自动删除(默认10秒)可访问/nbi/setLimitTime?limitTime重新设置会话时间<br>
基本信息通过流的方式记录在log.log文件中<br>
ip地址本来需要通过HttpServletRequest request去获取的 因为是本地项目就写死ip了。<br>
一些地方还是需要改善的。<br>
