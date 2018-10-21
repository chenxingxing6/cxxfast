package cn.jeefast.rest.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.jeefast.rest.dao.TbTokenDao;
import cn.jeefast.rest.entity.TbToken;
import cn.jeefast.rest.service.TbTokenService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户Token 服务实现类
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
@Service
public class TbTokenServiceImpl extends ServiceImpl<TbTokenDao, TbToken> implements TbTokenService {

	@Autowired
	private TbTokenDao tokenDao;
	//12小时后过期
	private final static int EXPIRE = 3600 * 12;
	
	@Override
	public TbToken queryByUserId(Long userId) {
		return tokenDao.queryByUserId(userId);
	}

	@Override
	public TbToken queryByToken(String token) {
		return tokenDao.queryByToken(token);
	}

	@Override
	public Map<String, Object> createToken(long userId) {
		//生成一个token
		String token = UUID.randomUUID().toString();
		//当前时间
		Date now = new Date();

		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		TbToken tokenEntity = queryByUserId(userId);
		if(tokenEntity == null){
			tokenEntity = new TbToken();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			tokenDao.insert(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//更新token
			tokenDao.updateById(tokenEntity);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("token", token);
		map.put("expire", EXPIRE);

		return map;
	}
	
}
