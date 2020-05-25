package com.steven.library;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Steven.zhao
 * email:hongtu.zhao@goodwinsoft.net
 * date:2019/6/15
 * desc: 注解工具类
 */
public class XViewUtils implements ViewInjector{

    private static final Object lock = new Object();
    private static volatile XViewUtils instance;

    private XViewUtils() {
    }

    public static XViewUtils instance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new XViewUtils();
                }
            }
        }
        return instance;
    }

    @Override
    public void inject(Activity activity) {
        //绑定控件
        try {
            bindView(activity, new ViewFinder(activity));
            bindOnClick(activity, new ViewFinder(activity));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inject(Fragment fragment) {
        //绑定控件
        try {
            bindView(fragment, new ViewFinder(fragment));
            bindOnClick(fragment, new ViewFinder(fragment));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inject(View view) {
        //绑定控件
        try {
            bindView(view, new ViewFinder(view));
            bindOnClick(view, new ViewFinder(view));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void bindView(Object handle, ViewFinder viewFinder) throws IllegalAccessException {
        final Class clazz = handle.getClass();

        /*
         * 获取用户所有的字段
         * */
        final Field[] fields = clazz.getDeclaredFields();

        /*
         * 遍历字段找到想要的字段，只有注解字段
         * */
        for (Field field : fields) {
            if (isFilter(field)) {
                continue;
            }
            final ViewInject viewInject = field.getAnnotation(ViewInject.class);

            if (viewInject != null) {
                /*
                 * 获取当前注解的值
                 * */
                final int resId = viewInject.value();

                /*
                 * 通过调用activity的findViewById
                 * */
                View view = viewFinder.findViewById(resId);

                /*
                 * 将当前的view设置给当前的field
                 * */
                field.setAccessible(true);

                field.set(handle, view);
            }
        }
    }

    private static void bindOnClick(final Object handle, ViewFinder viewFinder) {
        /*
         * 获取字节码
         * */
        final Class clazz = handle.getClass();

        /*
         * 获取字节码中当前所有的方法
         * */
        final Method[] declaredMethods = clazz.getDeclaredMethods();

        /*
         * 找出方法中声明了OnClick的注解的方法
         * */
        for (final Method declaredMethod : declaredMethods) {
            /*
             * 获取当前方法上的注解
             * */
            final OnClick onClick = declaredMethod.getAnnotation(OnClick.class);

            if (onClick != null) {
                /*
                 * 获取注解中的值
                 * */
                final int resId = onClick.value();

                /*
                 * 获取resId中的view
                 * */
                final View view = viewFinder.findViewById(resId);

                /*
                 * 给当前view绑定点击事件
                 * */
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /*
                         * 8.通过反射调用户的方法
                         * */
                        declaredMethod.setAccessible(true);
                        try {
                            declaredMethod.invoke(handle, view);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private static boolean isFilter(Field field) {
        Class<?> fieldType = field.getType();
        return Modifier.isStatic(field.getModifiers()) ||
                Modifier.isFinal(field.getModifiers()) ||
                fieldType.isPrimitive() ||
                fieldType.isArray();
    }
}
