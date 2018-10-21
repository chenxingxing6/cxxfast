package cn.jeefast.system.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

import cn.jeefast.system.entity.SysRole;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
public interface SysRoleService extends IService<SysRole> {
	
	Page<SysRole> queryPageList(Page<SysRole> pageUtil, Map<String, Object> map);
	List<SysRole> queryList(Map<String, Object> map);
	void deleteBatch(Long[] roleIds);
	void save(SysRole role);
	void update(SysRole role);
	
	
	
}
