package tw.com.ktv.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Excel Sheet 資訊註釋
 * 
 * @author chrisryo
 * @since 2015-03-28
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SheetInfo {
    
    /** Sheet Name */
    String name();
    
    /** 是否使用dto自定義SheetNme */
    boolean isUseDtoSheetNme()  default false;;
}
