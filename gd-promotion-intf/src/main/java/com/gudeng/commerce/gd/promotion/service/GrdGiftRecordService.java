package com.gudeng.commerce.gd.promotion.service;

import java.util.List;
import java.util.Map;

import com.gudeng.commerce.gd.promotion.dto.GrdGiftRecordDTO;
import com.gudeng.commerce.gd.promotion.dto.GrdGiftRecordExportDTO;
import com.gudeng.commerce.gd.promotion.entity.GrdGiftRecordEntity;

public interface GrdGiftRecordService extends BaseService<GrdGiftRecordDTO> {
	public Long insert(GrdGiftRecordEntity entity) throws Exception;
	/** 根据查询条件获取数据。查询结果按id升序。
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<GrdGiftRecordDTO> queryBySearch(Map<String, Object> map) throws Exception; 
	public List<GrdGiftRecordExportDTO> queryBySearchExport(Map<String, Object> map) throws Exception; 
	public List<GrdGiftRecordExportDTO> queryBySearchGroup(Map<String, Object> map) throws Exception; 
	/**统计 根据查询条件得出的结果 总记录数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int countBySearch(Map<String, Object> map) throws Exception; 
	
	/** 动态更新。
	 *  NOTE：更新属性值不为null的数据。
	 * @param entity 
	 * @return
	 * @throws Exception
	 */
	public int dynamicUpdate(GrdGiftRecordEntity entity) throws Exception;

	/**
	 * 根据手机号和状态查找giftrecord记录
	 * 
	 * status=0,查询已经产生记录，但是未集中领取的记录
	 * status=1，查询已经领取礼品的记录。
	 * 
	 * status不传，则查询当前mobile下的所有的记录
	 * 
	 * */
	
	List<GrdGiftRecordDTO> getRecordByMemberIdAndStatus(Map queryMap) throws Exception;

	public int getRecordTotalByMemberIdAndStatus(Map queryMap);

	public Long addRecord(Map<String, Object> map) throws Exception;
	
	public Long addRecordNst(Map<String, Object> map) throws Exception;

	public int centralized(List<Map<String, Object>> list)throws Exception;
	
	/**根据礼品开单人或创建人统计
	 * @param userIds 用户id集合
	 * @return
	 */
	public int countByGrantOrCreateUserIds(List<String> userIds) throws Exception;
	/**根据地推人员id分页查询邀请注册的用户信息。查询结果用户注册时间倒序。
	 * @param param 参数集合，key包含有: 
	 * 					userId 地推人员id,
	 * 					startRow 起始索引行号,
	 * 					endRow  结束索引号
	 * @return
	 * @throws Exception
	 */
	public List<GrdGiftRecordDTO> queryInviteRegUserInfoByUserId(Map<String, Object> param) throws Exception;
	/**根据地推人员id统计邀请注册的用户信息。
	 * @param param 参数集合，key包含有: 
	 * 					userId 地推人员id,
	 * 					startRow 起始索引行号,
	 * 					endRow  结束索引号
	 * @return
	 * @throws Exception
	 */
	public int countInviteRegUserInfoByUserId(Map<String, Object> param) throws Exception;
	int countBySearchExport(Map<String, Object> map) throws Exception;
	
    /**根据市场ID查询所属仓库信息
	 * @return
	 * @throws Exception
	 */
	public List<GrdGiftRecordDTO> getChildStoreInfo(Map<String, Object> param)  throws Exception;
	

}