package cn.jeefast.modules.platform.controller;

import java.util.Date;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;

import cn.jeefast.common.annotation.Log;
import cn.jeefast.common.base.BaseController;
import cn.jeefast.common.utils.Query;
import cn.jeefast.common.utils.R;
import cn.jeefast.common.validator.ValidatorUtils;
import cn.jeefast.common.validator.group.AddGroup;
import cn.jeefast.common.validator.group.UpdateGroup;
import cn.jeefast.modules.platform.entity.PfNotice;
import cn.jeefast.modules.platform.service.PfNoticeService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author theodo
 * @since 2017-12-18
 */
@RestController
@RequestMapping("/platform/notice")
public class PfNoticeController extends BaseController {
	@Autowired
	private PfNoticeService pfNoticeService;
	
	/**
	 * 所有系统通知列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("platform:notice:list")
	public R list(@RequestParam Map<String, Object> params){
		Query query = new Query(params);
		Page<PfNotice> pageUtil = new Page<PfNotice>(query.getPage(), query.getLimit());
		Page<PfNotice> page = pfNoticeService.queryPageList(pageUtil,query);
		return R.ok().put("page", page);
	}
	
	/**
	 * 通知信息
	 */
	@RequestMapping("/info/{noticeId}")
	@RequiresPermissions("platform:notice:info")
	public R info(@PathVariable("noticeId") Long noticeId){
		PfNotice notice = pfNoticeService.selectById(noticeId);
		
		return R.ok().put("notice", notice);
	}
	
	/**
	 * 保存通知
	 */
	@Log("保存通知")
	@RequestMapping("/save")
	@RequiresPermissions("platform:notice:save")
	public R save(@RequestBody PfNotice notice){
		ValidatorUtils.validateEntity(notice, AddGroup.class);
		
		notice.setPublishTime(new Date());
		notice.setCreater(getUserId());
		pfNoticeService.insert(notice);
		
		return R.ok();
	}
	
	/**
	 * 修改通知
	 */
	@Log("修改通知")
	@RequestMapping("/update")
	@RequiresPermissions("platform:notice:update")
	public R update(@RequestBody PfNotice notice){
		ValidatorUtils.validateEntity(notice, UpdateGroup.class);
		
		notice.setCreater(getUserId());
		pfNoticeService.updateById(notice);
		
		return R.ok();
	}
	
	/**
	 * 删除通知
	 */
	@Log("删除通知")
	@RequestMapping("/delete")
	@RequiresPermissions("platform:notice:delete")
	public R delete(@RequestBody Long[] noticeIds){
		
		pfNoticeService.deleteBatch(noticeIds);
		
		return R.ok();
	}
	
}
