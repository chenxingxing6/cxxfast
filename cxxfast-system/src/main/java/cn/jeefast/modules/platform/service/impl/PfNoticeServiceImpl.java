package cn.jeefast.modules.platform.service.impl;

import cn.jeefast.modules.platform.entity.PfNotice;
import cn.jeefast.modules.platform.dao.PfNoticeDao;
import cn.jeefast.modules.platform.service.PfNoticeService;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author theodo
 * @since 2017-12-18
 */
@Service
public class PfNoticeServiceImpl extends ServiceImpl<PfNoticeDao, PfNotice> implements PfNoticeService {

	@Autowired
	private PfNoticeDao pfNoticeDao;
	
	@Override
	public Page<PfNotice> queryPageList(Page<PfNotice> page, Map<String, Object> map) {
		page.setRecords(pfNoticeDao.queryPageList(page, map));
		return page;
	}

	@Override
	public void deleteBatch(Long[] noticeIds) {
		pfNoticeDao.deleteBatch(noticeIds);
	}
	
}
