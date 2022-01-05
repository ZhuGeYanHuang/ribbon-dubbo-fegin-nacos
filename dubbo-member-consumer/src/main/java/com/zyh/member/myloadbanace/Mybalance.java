package com.zyh.member.myloadbanace;


import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Qualifier //限定符，只有标注了这个标记的，才生效
public @interface Mybalance {
}
