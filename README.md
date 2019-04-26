# DL10TittleBar
android 一款自定义Tittle Bar

说明链接：https://blog.csdn.net/sinat_38184748/article/details/88662476
# 效果图
![](img/demo.png)
# 使用方法
添加依赖

Step 1. Add it in your root build.gradle at the end of repositories:

```java
    allprojects {
    	repositories {
    		...
    		maven { url 'https://jitpack.io' }
    	}
    }
```

Step 2. Add the dependency
```java
	dependencies {
	        implementation 'com.github.D10NGYANG:DL10TittleBar:1.0.2'
	}
```
在布局上使用
```java
<com.dlong.rep.dltittlebar.DLTittleBar
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="5dp"
        app:barBackground="@color/colorPrimary"
        app:leftBtnImage="@drawable/back"
        app:leftBtnVisible="true"
        app:right1BtnTxt="消息"
        app:right1BtnVisible="true"
        app:right2BtnImage="@drawable/add"
        app:right2BtnVisible="true"
        app:tittleColor="#666666"
        app:tittleTxt="首页">

    </com.dlong.rep.dltittlebar.DLTittleBar>
```
点击事件处理

```java
public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private DLTittleBar tittleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tittleBar = findViewById(R.id.tittle);
        tittleBar.setOnTittleBarBtnsClick(new DLTittleBar.TittleBarBtnsOnClickListener() {
            @Override
            public void OnClick(View view) {
                switch (view.getId()){
                    case R.id.titleTxt:
                        Toast.makeText(mContext, "tittle", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.leftBtnImg:
                        Toast.makeText(mContext, "leftBtn", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.right1BtnTxt:
                        Toast.makeText(mContext, "right1Btn", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.right2BtnImg:
                        Toast.makeText(mContext, "right2Btn", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
```
