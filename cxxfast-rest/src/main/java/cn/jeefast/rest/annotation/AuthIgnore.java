package cn.jeefast.rest.annotation;

import java.lang.annotation.*;

/**
 * api接口，忽略Token验证
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017-10-23 15:44
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthIgnore {

}
