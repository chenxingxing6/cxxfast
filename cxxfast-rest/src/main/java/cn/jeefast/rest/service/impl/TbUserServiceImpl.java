package cn.jeefast.rest.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.jeefast.common.exception.RRException;
import cn.jeefast.common.validator.Assert;
import cn.jeefast.rest.dao.TbUserDao;
import cn.jeefast.rest.entity.TbUser;
import cn.jeefast.rest.service.TbUserService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author theodo
 * @since 2017-10-28
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUser> implements TbUserService {

	@Autowired
	private TbUserDao userDao;
	
	@Override
	public TbUser queryByMobile(String mobile) {
		return userDao.queryByMobile(mobile);
	}

	@Override
	public void deleteBatch(Long[] userIds) {
		List<Long> idsList = Arrays.stream(userIds).collect(Collectors.toList());  
		userDao.deleteBatchIds(idsList);
	}

	@Override
	public long login(String mobile, String password) {
		TbUser user = queryByMobile(mobile);
		Assert.isNull(user, "手机号或密码错误");

		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(password))){
			throw new RRException("手机号或密码错误");
		}

		return user.getUserId();
	}

	@Override
	public void save(String mobile, String password) {
		TbUser user = new TbUser();
		user.setMobile(mobile);
		user.setUsername(mobile);
		user.setPassword(DigestUtils.sha256Hex(password));
		user.setCreateTime(new Date());
		userDao.insert(user);
	}
	
}
