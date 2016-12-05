package com.taotao.service;

import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {
	TbItem getItemId(long ItemId);
	EasyUIDateGridResult getItemList(int page,int rows);
	TaotaoResult createTbitem(TbItem item,String desc) throws Exception;
	
}
