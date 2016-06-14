# AutoLayout
傻瓜式编写布局，不用进行各种适配了，直接照着设计图即可编写
# 效果图

看下不同分辨率下的效果：</br>

左为：1080 * 1920 ; 右为：768 * 1280
第一组图片是设计图在720 * 1280的基础上显示的</br>
第二组图片是设计图在1080 * 1920的基础上显示的</br>


![github](https://github.com/heavenxue/AutoLayout/raw/master/doc/1.png "github")
![github](https://github.com/heavenxue/AutoLayout/raw/master/doc/1-.png "github")

感谢![](https://github.com/hongyangAndroid/AndroidAutoLayout)

## 所做的修改

* 去掉支持库
* 加入开关
* 增加(768 * 1280分辨率)demo，做了很多测试

## Log开关

```java
L.debug = true;
```