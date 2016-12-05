package com.taotao.service;

import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {
	
	EasyUIDateGridResult getContentByCatrgoryId(long categoryId,int page,int rows);
	
	
	TaotaoResult insertContent(TbContent content);
	
}
