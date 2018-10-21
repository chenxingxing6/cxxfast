package cn.jeefast.modules.platform.service;

import cn.jeefast.modules.platform.entity.PfNotice;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author theodo
 * @since 2017-12-18
 */
public interface PfNoticeService extends IService<PfNotice> {

	Page<PfNotice> queryPageList(Page<PfNotice> pageUtil, Map<String, Object> map);

	void deleteBatch(Long[] noticeIds);
	
}
