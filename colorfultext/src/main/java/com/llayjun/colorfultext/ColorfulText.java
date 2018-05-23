package com.llayjun.colorfultext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * 文字的多样化
 */
public class ColorfulText extends TextView {

    private Context context;

    public ColorfulText(Context context) {
        this(context, null);
    }

    public ColorfulText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorfulText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this.context = context;
        setHighlightColor(Color.TRANSPARENT);
        setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * 文字，颜色，大小
     */
    public ColorfulText appendText(String text, int textcolor, int textsize) {
        if (TextUtils.isEmpty(text)) return null;
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(textcolor);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(dp2sp(textsize));
        spannableString.setSpan(foregroundColorSpan, 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(absoluteSizeSpan, 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        append(spannableString);
        return this;
    }

    /**
     * 文字，颜色，大小，是否加粗
     */
    public ColorfulText appendText(String text, int textcolor, int textsize, boolean blod) {
        if (TextUtils.isEmpty(text)) return null;
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(textcolor);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(dp2sp(textsize));
        StyleSpan styleSpan = new StyleSpan(blod ? Typeface.BOLD : Typeface.NORMAL);
        spannableString.setSpan(foregroundColorSpan, 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(absoluteSizeSpan, 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(styleSpan, 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        append(spannableString);
        return this;
    }

    /**
     * 添加空格
     */
    public ColorfulText appendSpace() {
        append(" ");
        return this;
    }

    public int dp2sp(float dpVal) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal,
                context.getResources().getDisplayMetrics()));
    }

}
