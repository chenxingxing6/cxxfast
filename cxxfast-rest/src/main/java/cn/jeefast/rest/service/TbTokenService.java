package cn.jeefast.rest.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import cn.jeefast.rest.entity.TbToken;

/**
 * <p>
 * 用户Token 服务类
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
public interface TbTokenService extends IService<TbToken> {
	
	TbToken queryByUserId(Long userId);

	TbToken queryByToken(String token);
	
	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token相关信息
	 */
	Map<String, Object> createToken(long userId);
	
}
