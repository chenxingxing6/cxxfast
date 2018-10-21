package cn.jeefast.common.annotation;

import java.lang.annotation.*;

/**
 * 数据过滤
 *
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017/10/17 14:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataFilter {
    /**  表的别名 */
    String tableAlias() default  "";

    /**  true：没有本部门数据权限，也能查询本人数据 */
    boolean user() default true;
}
