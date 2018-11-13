package com.hdgk.library.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hdgk.library.R;


public class ToastUtil {

    public static void show(Context context, CharSequence msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void show(Context context, CharSequence msg, int duration) {
        Toast.makeText(context, msg, duration).show();
    }

    public static void show(Context context, @StringRes int stringId) {
        Toast.makeText(context, stringId, Toast.LENGTH_LONG).show();
    }

    public static void show(View view, CharSequence msg) {
        show(view.getContext(), msg);
    }

    public static void show(View view, @StringRes int stringId) {
        show(view.getContext(), stringId);
    }

    public static void showCenter(Context context, CharSequence msg) {
        Toast toast = new Toast(context);
        TextView layout = (TextView) View.inflate(context, R.layout.view_toast, null);
        layout.setText(msg);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void showCenter(Context context, int resourceId, CharSequence msg) {
        Toast toast = new Toast(context);
        TextView layout = (TextView) View.inflate(context, R.layout.view_toast, null);
        Drawable drawable = context.getResources().getDrawable(resourceId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        layout.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        layout.setCompoundDrawablePadding(DensityUtil.dp2px(context,7));
        layout.setText(msg);
        TextPaint tp = layout.getPaint();
        tp.setFakeBoldText(true);
        toast.setView(layout);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

}
