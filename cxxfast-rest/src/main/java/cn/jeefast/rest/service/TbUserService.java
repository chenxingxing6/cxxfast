package cn.jeefast.rest.service;

import com.baomidou.mybatisplus.service.IService;

import cn.jeefast.rest.entity.TbUser;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
public interface TbUserService extends IService<TbUser> {
	
	TbUser queryByMobile(String mobile);
	
	void deleteBatch(Long[] userIds);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);

	void save(String mobile, String password);
	
}
