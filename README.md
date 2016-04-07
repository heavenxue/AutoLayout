# AutoLayout
Android屏幕适配方案，直接填写设计图上的像素尺寸即可完成适配，最大限度解决适配问题。
# 效果图

看下不同分辨率下的效果：</br>

左为：1080 * 1920 ; 右为：768 * 1280

![github](https://github.com/heavenxue/AutoLayout/raw/master/doc/1.png "github")
![github](https://github.com/heavenxue/AutoLayout/raw/master/doc/1-.png "github")
![github](https://github.com/heavenxue/AutoLayout/raw/master/doc/2.png "github")
![github](https://github.com/heavenxue/AutoLayout/raw/master/doc/2-.png "github")

    上述两个机器的分辨率差距挺大了，但是完美实现了适配，最为重要的是：</br>
    
    * 再也不用拿着设计稿去想这控件的宽高到底取多少dp
    * 再也不用去为多个屏幕去写多个dimens
    * 再也不用去计算百分比了（如果使用百分比控件完成适配）
    * 再也不用去跟UI MM去解释什么是dp了
    
    你所要做的就是抄抄设计稿上面的px，直接写入布局文件。</br>
    
    还有很多好处，比如上面的Item里面元素比较多，如果标识的比较全面，一个FrameLayout，里面的View填写各种marginLeft,marginTop就能完美实现，几乎不需要嵌套了。
    
# 用法
## 第一步
在你的项目的AndroidManifest中注明你的设计稿的尺寸。
    <meta-data android:name="design_width" android:value="768">
    </meta-data>
    <meta-data android:name="design_height" android:value="1280">
    </meta-data>
    ## 第二步
    让你的Activity继承自AutoLayoutActivity.
    
    非常简单的两个步骤，你就可以开始愉快的编写布局了，详细可以参考sample。
## 第三步
如果你不希望继承AutoLayoutActivity，可以在编写布局文件时，将
    
    LinearLayout -> AutoLinearLayout
    RelativeLayout -> AutoRelativeLayout
    FrameLayout -> AutoFrameLayout
    这样也可以完成适配。
# 支持的属性
* layout_width
* layout_height
* layout_margin(left,top,right,bottom)
* pading(left,top,right,bottom)
* textSize
* maxWidth, minWidth, maxHeight, minHeight
# 配置
默认使用的高度是设备的可用高度，也就是不包括状态栏和底部的操作栏的，如果你希望拿设备的物理高度进行百分比化：

可以在Application的onCreate方法中进行设置:
    public class UseDeviceSizeApplication extends Application
    {
        @Override
        public void onCreate()
        {
            super.onCreate();
            AutoLayoutConifg.getInstance().useDeviceSize();
        }
    }

# 扩展

对于其他继承系统的FrameLayout、LinearLayout、RelativeLayout的控件，比如CardView，如果希望再其内部直接支持"px"百分比化，可以自己扩展，扩展方式为下面的代码

    public class AutoCardView extends CardView {
        private final AutoLayoutHelper mHelper = new AutoLayoutHelper(this);
    
        public AutoCardView(Context context) {
            super(context);
        }
    
        public AutoCardView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }
    
        public AutoCardView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }
    
        @Override
        public AutoFrameLayout.LayoutParams generateLayoutParams(AttributeSet attrs) {
            return new AutoFrameLayout.LayoutParams(getContext(), attrs);
        }
    
        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            if (!isInEditMode()) {
                mHelper.adjustChildren();
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    
    
    }
# 注意

## ListView、RecyclerView类的Item的适配
### sample中包含ListView、RecyclerView例子，具体查看sample
* 对于ListView
  对于ListView这类控件的item，默认根局部写“px”进行适配是无效的，因为外层非AutoXXXLayout，而是ListView。但是，不用怕，一行代码就可以支持了：
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;
        if (convertView == null)
        {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            convertView.setTag(holder);
            //对于listview，注意添加这一行，即可在item上使用高度
            AutoUtils.autoSize(convertView);
        } else
        {
            holder = (ViewHolder) convertView.getTag();
        }
    
        return convertView;
    }

注意AutoUtils.autoSize(convertView);这行代码的位置即可。demo中也有相关实例。
* 对于RecyclerView
    public ViewHolder(View itemView)
    {
          super(itemView);
          AutoUtils.autoSize(itemView);
    }
    
    //...
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
         View convertView = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item, parent, false);
         return new ViewHolder(convertView);
    }

一定要记得LayoutInflater.from(mContext).inflate使用三个参数的方法！
## 指定设置的值参考宽度或者高度
    由于该库的特点，布局文件中宽高上的1px是不相等的，于是如果需要宽高保持一致的情况，布局中使用属性：
    
    app:layout_auto_basewidth="height"，代表height上编写的像素值参考宽度。
    
    app:layout_auto_baseheight="width"，代表width上编写的像素值参考高度。
    
    如果需要指定多个值参考宽度即：
    
    app:layout_auto_basewidth="height|padding"
    
    用|隔开，类似gravity的用法，取值为：
    
    width,height
    margin,marginLeft,marginTop,marginRight,marginBottom
    padding,paddingLeft,paddingTop,paddingRight,paddingBottom
    textSize.
## TextView的高度问题

设计稿一般只会标识一个字体的大小，比如你设置textSize="20px"，实际上TextView所占据的高度肯定大于20px，字的上下都会有一定的建议，所以一定要灵活去写字体的高度，比如对于text上下的margin可以选择尽可能小一点。或者选择别的约束条件去定位（比如上例，选择了marginBottom）
