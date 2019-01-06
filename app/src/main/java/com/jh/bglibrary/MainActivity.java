package com.jh.bglibrary;


import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.noober.background.BackgroundLibrary;
import com.noober.background.drawable.DrawableCreator;

/**
 * BackgroudLibrary
 * https://github.com/JavaNoober/BackgroundLibrary
 * <p>
 * A framework for directly generating shape through Tags, no need to write shape.xml again
 * （通过标签直接生成shape，无需再写shape.xml）
 *
 * 使用方法
 * 1、在BaseActivity中的super.onCreate之前调用。如果minSdkVersion < 16:bl_gradient_angle, bl_gradient_startColor, bl_gradient_centerColor, bl_gradient_endColor会失效，其他正常
 *
 * BackgroundLibrary.inject(context);
 * 2、在layout中直接添加属性即可。
 *
 *
 * 缺点: 不能实时显示在xml中！
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BackgroundLibrary.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, new BlankFragment()).commitAllowingStateLoss();

        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

        Drawable drawable = new DrawableCreator.Builder().setCornersRadius(30)
                .setSolidColor(Color.parseColor("#FFFFFF"))
                .setStrokeColor(Color.parseColor("#FFFFFF"))
                .setStrokeWidth(10)
                .build();
        TextView tvTest1 = findViewById(R.id.tvTest1);
        tvTest1.setClickable(true);
        ColorStateList colors = new DrawableCreator.Builder().setPressedTextColor(Color.RED).setUnPressedTextColor(Color.BLUE).buildTextColor();
        tvTest1.setTextColor(colors);

        Button btnTest2 = findViewById(R.id.btnTest2);
//        Drawable drawable = new DrawableCreator.Builder().setCornersRadius(dip2px(20))
//                .setGradientAngle(0).setGradientColor(Color.parseColor("#63B8FF"), Color.parseColor("#4F94CD")).build();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            btnTest2.setBackground(drawable);
        }else {
            btnTest2.setBackgroundDrawable(drawable);
        }


        Button btnTest3 = findViewById(R.id.btnTest3);
        Drawable drawable3 = new DrawableCreator.Builder().setCornersRadius(dip2px(20))
                .setRipple(true, Color.parseColor("#71C671"))
                .setSolidColor(Color.parseColor("#7CFC00"))
                .setStrokeColor(Color.parseColor("#8c6822"))
                .setStrokeWidth(dip2px(2))
                .build();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            btnTest3.setBackground(drawable3);
        }else {
            btnTest3.setBackgroundDrawable(drawable3);
        }


        TextView tvTest4 = findViewById(R.id.tvTest4);
        Drawable drawable4 = new DrawableCreator.Builder().setCornersRadius(dip2px(20))
                .setPressedDrawable(ContextCompat.getDrawable(this, R.drawable.circle_like_pressed))
                .setUnPressedDrawable(ContextCompat.getDrawable(this, R.drawable.circle_like_normal))
                .build();
        tvTest4.setClickable(true);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            tvTest4.setBackground(drawable4);
        }else {
            tvTest4.setBackgroundDrawable(drawable4);
        }
    }

    public int dip2px(float dipValue) {
        float scale = getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5F);
    }

}
