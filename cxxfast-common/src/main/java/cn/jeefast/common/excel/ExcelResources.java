package cn.jeefast.common.excel;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Excel工具类-用来在对象的get方法上加入的annotation，通过该annotation说明某个属性所对应的标题
 * 
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017年11月26日 上午10:40:10
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelResources {
    /**
     * 属性的标题名称
     * @return
     */
    String title();
    /**
     * 在excel的顺序
     * @return
     */
    int order() default 9999;
}
