package com.gudeng.commerce.gd.task.service;

import java.util.List;

import com.gudeng.commerce.gd.exception.ServiceException;
import com.gudeng.commerce.gd.order.dto.TaskDTO;

/**
 * @Description: TODO(任务服务接口)
 * @author mpan
 * @date 2015年12月8日 下午3:05:49
 */
public interface TaskToolService {
	

	
	/** 
	 * 添加任务
	 */
	public Integer addTask(TaskDTO taskInfo) throws ServiceException;
	
	/** 
	 * 添加定时任务
	 */
	public Integer addTimeTask(TaskDTO taskInfo) throws ServiceException;
	
	/** 
	 * 更新任务
	 */
	public Integer updateTask(TaskDTO taskInfo) throws ServiceException;
	
	/** 
	 * 取出任务
	 */
	public List<TaskDTO> takeOutTask(TaskDTO queryVO) throws ServiceException;
	
	/** 
	 * 查询任务
	 */
	public TaskDTO queryTask(Long taskId) throws ServiceException;



}
