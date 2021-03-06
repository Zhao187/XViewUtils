package com.steven.library;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Steven.zhao
 * email:hongtu.zhao@goodwinsoft.net
 * date:2019/6/15
 * desc:点击事件
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface OnClick {
    int value();
}
