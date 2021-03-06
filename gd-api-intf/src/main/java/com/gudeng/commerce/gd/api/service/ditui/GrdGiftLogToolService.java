package com.gudeng.commerce.gd.api.service.ditui;

import com.gudeng.commerce.gd.api.service.BaseToolService;
import com.gudeng.commerce.gd.promotion.dto.GrdGiftLogDTO;
import com.gudeng.commerce.gd.promotion.entity.GrdGiftLogEntity;

public interface GrdGiftLogToolService extends BaseToolService<GrdGiftLogDTO> {
	public Long insert(GrdGiftLogEntity entity) throws Exception;
	
}