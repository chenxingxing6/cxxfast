package cn.jeefast.modules.job.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.jeefast.modules.job.dao.ScheduleJobLogDao;
import cn.jeefast.modules.job.entity.ScheduleJobLog;
import cn.jeefast.modules.job.service.ScheduleJobLogService;

@Service("scheduleJobLogService")
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogDao, ScheduleJobLog> implements ScheduleJobLogService {
	@Autowired
	private ScheduleJobLogDao scheduleJobLogDao;

	@Override
	public Page<ScheduleJobLog> queryPageList(Page<ScheduleJobLog> page, Map<String, Object> map) {
		page.setRecords(scheduleJobLogDao.queryPageList(page, map));
		return page;
	}
	
	
}
