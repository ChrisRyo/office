package tw.com.ktv.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import tw.com.ktv.enums.DateStyle;

/**
 * Excel Cell 資訊註釋
 * 
 * @author chrisryo
 * @since 2015-03-28
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CellInfo {

    /** 列位子 */
    int index();

    /** 第一列名稱 */
    String columnName();

    /** 欄寬 */
    int width() default 20;

    /** 是否隱藏只留後四碼 (只支援String型態) */
    boolean isMask() default false;

    /** 位置(左,中,右) */
    short alignment() default -1;

    /** format格式 */
    DateStyle dateStyle() default DateStyle.YYYY_MM_DD_HH_MM_SS;
    
    /** 用格式化中文的枚舉類 class */
    Class<?> formatEnums() default CellInfo.class;
    
    /** 自定義[字形]效果 class */
    Class<?> formatFontStyle() default CellInfo.class;
}