package cn.jeefast.system.service;

import java.util.Set;

import cn.jeefast.system.entity.SysUser;
import cn.jeefast.system.entity.SysUserToken;

/**
 * shiro相关接口
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017-06-06 8:49
 */
public interface ShiroService {
    /**
     * 获取用户权限列表
     */
    Set<String> getUserPermissions(long userId);

    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     * @param userId
     */
    SysUser queryUser(Long userId);
}
