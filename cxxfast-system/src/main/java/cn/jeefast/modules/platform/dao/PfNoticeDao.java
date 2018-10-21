package cn.jeefast.modules.platform.dao;

import cn.jeefast.modules.platform.entity.PfNotice;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author theodo
 * @since 2017-12-18
 */
public interface PfNoticeDao extends BaseMapper<PfNotice> {

	List<PfNotice> queryPageList(Page<PfNotice> page, Map<String, Object> map);

	void deleteBatch(Long[] noticeIds);
		
}