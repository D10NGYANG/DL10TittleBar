package com.dlong.rep.dltittlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自定义TittleBar
 * @author  dlong
 * created at 2019/3/19 10:50 AM
 */
public class DLTittleBar extends RelativeLayout {
    /** 声明控件 */
    private RelativeLayout mTittleBar, mLeftBtnRL, mRight1BtnRL, mRight2BtnRL;
    private TextView mTittleTxt, mLeftBtnTxt, mRight1BtnTxt, mRight2BtnTxt;
    private ImageView mLeftBtnImg, mRight1BtnImg, mRight2BtnImg;

    /** 声明属性 */
    private String mTittleMsg;  // 标题文本
    private int mTittleColor;  // 标题颜色
    private float mTittleSize;  // 标题字体大小
    private Drawable mTittleBackground;  // 标题背景

    private Drawable mBarBackground;  // 整个bar背景

    private boolean mLeftBtnVisible;  // 左边按钮是否可见
    private String mLeftBtnMsg;  // 左边按钮文本
    private int mLeftBtnColor;  // 左边按钮颜色
    private float mLeftBtnSize;  // 左边按钮字体大小
    private Drawable mLeftBtnPic;  // 左边按钮图片

    private boolean mRight1BtnVisible;  // 右边按钮1是否可见
    private String mRight1BtnMsg;  // 右边按钮1文本
    private int mRight1BtnColor;  // 右边按钮1颜色
    private float mRight1BtnSize;  // 右边按钮1字体大小
    private Drawable mRight1BtnPic;  // 右边按钮1图片

    private boolean mRight2BtnVisible;  // 右边按钮2是否可见
    private String mRight2BtnMsg;  // 右边按钮2文本
    private int mRight2BtnColor;  // 右边按钮2颜色
    private float mRight2BtnSize;  // 右边按钮2字体大小
    private Drawable mRight2BtnPic;  // 右边按钮2图片

    /** 上下文 */
    private Context mContext;

    /** 声明点击监听 */
    private TittleBarBtnsOnClickListener mListener;

    /** 创建一个监听点击的接口 */
    public interface TittleBarBtnsOnClickListener{
        void OnClick(View view);
    }

    /** 向外提供一个设置监听的方法 */
    public void setOnTittleBarBtnsClick(TittleBarBtnsOnClickListener listener){
        this.mListener = listener;
        mTittleTxt.setOnClickListener(onClickListener);
        mLeftBtnImg.setOnClickListener(onClickListener);
        mLeftBtnTxt.setOnClickListener(onClickListener);
        mRight1BtnImg.setOnClickListener(onClickListener);
        mRight1BtnTxt.setOnClickListener(onClickListener);
        mRight2BtnImg.setOnClickListener(onClickListener);
        mRight2BtnTxt.setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            mListener.OnClick(v);
        }
    };
    
    public DLTittleBar(Context context) {
        super(context);
        mContext = context;
        init(null);
    }

    public DLTittleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init(attrs);
    }

    /**
     * 初始化
     * @param attrs
     */
    private void init(AttributeSet attrs) {
        // 加载布局
        LayoutInflater.from(mContext).inflate(R.layout.tittle_bar, this, true);
        // 加载控件
        mTittleBar = findViewById(R.id.tittleBar);
        mLeftBtnRL = findViewById(R.id.leftBtnRL);
        mRight1BtnRL = findViewById(R.id.right1BtnRL);
        mRight2BtnRL = findViewById(R.id.right2BtnRL);
        mTittleTxt = findViewById(R.id.titleTxt);
        mLeftBtnTxt = findViewById(R.id.leftBtnTxt);
        mRight1BtnTxt = findViewById(R.id.right1BtnTxt);
        mRight2BtnTxt = findViewById(R.id.right2BtnTxt);
        mLeftBtnImg = findViewById(R.id.leftBtnImg);
        mRight1BtnImg = findViewById(R.id.right1BtnImg);
        mRight2BtnImg = findViewById(R.id.right2BtnImg);
        // 读取属性
        if (null != attrs){
            TypedArray mTypedArray = mContext.obtainStyledAttributes(attrs, R.styleable.DLTittleBar);
            if (null != mTypedArray){
                mTittleMsg = mTypedArray.getString(R.styleable.DLTittleBar_tittleTxt);
                mTittleColor = mTypedArray.getColor(R.styleable.DLTittleBar_tittleColor, 0xff666666);
                mTittleSize = mTypedArray.getDimension(R.styleable.DLTittleBar_tittleSize, 16);
                mTittleBackground = mTypedArray.getDrawable(R.styleable.DLTittleBar_tittleBackground);
                mBarBackground = mTypedArray.getDrawable(R.styleable.DLTittleBar_barBackground);
                mLeftBtnVisible = mTypedArray.getBoolean(R.styleable.DLTittleBar_leftBtnVisible, false);
                mLeftBtnMsg = mTypedArray.getString(R.styleable.DLTittleBar_leftBtnTxt);
                mLeftBtnColor = mTypedArray.getColor(R.styleable.DLTittleBar_leftBtnColor, 0xff666666);
                mLeftBtnSize = mTypedArray.getDimension(R.styleable.DLTittleBar_leftBtnSize, 16);
                mLeftBtnPic = mTypedArray.getDrawable(R.styleable.DLTittleBar_leftBtnImage);
                mRight1BtnVisible = mTypedArray.getBoolean(R.styleable.DLTittleBar_right1BtnVisible, false);
                mRight1BtnMsg = mTypedArray.getString(R.styleable.DLTittleBar_right1BtnTxt);
                mRight1BtnColor = mTypedArray.getColor(R.styleable.DLTittleBar_right1BtnColor, 0xff666666);
                mRight1BtnSize = mTypedArray.getDimension(R.styleable.DLTittleBar_right1BtnSize, 16);
                mRight1BtnPic = mTypedArray.getDrawable(R.styleable.DLTittleBar_right1BtnImage);
                mRight2BtnVisible = mTypedArray.getBoolean(R.styleable.DLTittleBar_right2BtnVisible, false);
                mRight2BtnMsg = mTypedArray.getString(R.styleable.DLTittleBar_right2BtnTxt);
                mRight2BtnColor = mTypedArray.getColor(R.styleable.DLTittleBar_right2BtnColor, 0xff666666);
                mRight2BtnSize = mTypedArray.getDimension(R.styleable.DLTittleBar_right2BtnSize, 16);
                mRight2BtnPic = mTypedArray.getDrawable(R.styleable.DLTittleBar_right2BtnImage);
                // 释放资源，回收资源
                mTypedArray.recycle();
            }
        }
        // 设置bar参数
        mTittleBar.setBackground(mBarBackground);
        // 设置标题参数
        mTittleTxt.setText(mTittleMsg);
        mTittleTxt.setTextColor(mTittleColor);
        mTittleTxt.setTextSize(mTittleSize);
        mTittleTxt.setBackground(mTittleBackground);
        // 设置左侧按钮参数
        if (mLeftBtnVisible){
            mLeftBtnRL.setVisibility(VISIBLE);
            mLeftBtnTxt.setText(mLeftBtnMsg);
            mLeftBtnTxt.setTextColor(mLeftBtnColor);
            mLeftBtnTxt.setTextSize(mLeftBtnSize);
            mLeftBtnImg.setImageDrawable(mLeftBtnPic);
        }else {
            mLeftBtnRL.setVisibility(INVISIBLE);
        }
        // 设置右侧按钮1参数
        if (mRight1BtnVisible){
            mRight1BtnRL.setVisibility(VISIBLE);
            mRight1BtnTxt.setText(mRight1BtnMsg);
            mRight1BtnTxt.setTextColor(mRight1BtnColor);
            mRight1BtnTxt.setTextSize(mRight1BtnSize);
            mRight1BtnImg.setImageDrawable(mRight1BtnPic);
        }else {
            mRight1BtnRL.setVisibility(INVISIBLE);
        }
        // 设置右侧按钮2参数
        if (mRight2BtnVisible){
            mRight2BtnRL.setVisibility(VISIBLE);
            mRight2BtnTxt.setText(mRight2BtnMsg);
            mRight2BtnTxt.setTextColor(mRight2BtnColor);
            mRight2BtnTxt.setTextSize(mRight2BtnSize);
            mRight2BtnImg.setImageDrawable(mRight2BtnPic);
        }else {
            mRight2BtnRL.setVisibility(INVISIBLE);
        }
    }

    /**
     * 获得控件
     * @return
     */
    public RelativeLayout getTittleBar() {
        return mTittleBar;
    }

    public RelativeLayout getLeftBtnRL() {
        return mLeftBtnRL;
    }

    public RelativeLayout getRight1BtnRL() {
        return mRight1BtnRL;
    }

    public RelativeLayout getRight2BtnRL() {
        return mRight2BtnRL;
    }

    public TextView getTittleTxt() {
        return mTittleTxt;
    }

    public TextView getLeftBtnTxt() {
        return mLeftBtnTxt;
    }

    public TextView getRight1BtnTxt() {
        return mRight1BtnTxt;
    }

    public TextView getRight2BtnTxt() {
        return mRight2BtnTxt;
    }

    public ImageView getLeftBtnImg() {
        return mLeftBtnImg;
    }

    public ImageView getRight1BtnImg() {
        return mRight1BtnImg;
    }

    public ImageView getRight2BtnImg() {
        return mRight2BtnImg;
    }

    /**
     * 修改属性
     */
    public void setTittleMsg(String tittleMsg) {
        this.mTittleMsg = tittleMsg;
        this.invalidate();
    }

    public void setTittleColor(int tittleColor) {
        this.mTittleColor = tittleColor;
        this.invalidate();
    }

    public void setTittleSize(float tittleSize) {
        this.mTittleSize = tittleSize;
        this.invalidate();
    }

    public void setTittleBackground(Drawable tittleBackground) {
        this.mTittleBackground = tittleBackground;
        this.invalidate();
    }

    public void setBarBackground(Drawable barBackground) {
        this.mBarBackground = barBackground;
        this.invalidate();
    }

    public void setLeftBtnVisible(boolean leftBtnVisible) {
        this.mLeftBtnVisible = leftBtnVisible;
        this.invalidate();
    }

    public void setLeftBtnMsg(String leftBtnMsg) {
        this.mLeftBtnMsg = leftBtnMsg;
        this.invalidate();
    }

    public void setLeftBtnColor(int leftBtnColor) {
        this.mLeftBtnColor = leftBtnColor;
        this.invalidate();
    }

    public void setLeftBtnSize(float leftBtnSize) {
        this.mLeftBtnSize = leftBtnSize;
        this.invalidate();
    }

    public void setLeftBtnPic(Drawable leftBtnPic) {
        this.mLeftBtnPic = leftBtnPic;
        this.invalidate();
    }

    public void setRight1BtnVisible(boolean right1BtnVisible) {
        this.mRight1BtnVisible = right1BtnVisible;
        this.invalidate();
    }

    public void setRight1BtnMsg(String right1BtnMsg) {
        this.mRight1BtnMsg = right1BtnMsg;
        this.invalidate();
    }

    public void setRight1BtnColor(int right1BtnColor) {
        this.mRight1BtnColor = right1BtnColor;
        this.invalidate();
    }

    public void setRight1BtnSize(float right1BtnSize) {
        this.mRight1BtnSize = right1BtnSize;
        this.invalidate();
    }

    public void setRight1BtnPic(Drawable right1BtnPic) {
        this.mRight1BtnPic = right1BtnPic;
        this.invalidate();
    }

    public void setRight2BtnVisible(boolean right2BtnVisible) {
        this.mRight2BtnVisible = right2BtnVisible;
        this.invalidate();
    }

    public void setRight2BtnMsg(String right2BtnMsg) {
        this.mRight2BtnMsg = right2BtnMsg;
        this.invalidate();
    }

    public void setRight2BtnColor(int right2BtnColor) {
        this.mRight2BtnColor = right2BtnColor;
        this.invalidate();
    }

    public void setRight2BtnSize(float right2BtnSize) {
        this.mRight2BtnSize = right2BtnSize;
        this.invalidate();
    }

    public void setRight2BtnPic(Drawable right2BtnPic) {
        this.mRight2BtnPic = right2BtnPic;
        this.invalidate();
    }
}
