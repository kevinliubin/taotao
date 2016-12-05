package com.taotao.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
/**
 * 商品查询
 * <p>Title ItemController</p>
 * @author liubin
 * @date 2016年3月14日上午9:50:51
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{ItemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long ItemId){
		TbItem item = itemService.getItemId(ItemId);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDateGridResult getItemById(int page,int rows){
		EasyUIDateGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult addItem(TbItem item,String desc) throws Exception{
		TaotaoResult result = itemService.createTbitem(item,desc);
		return result;
	}
	
	
	
}
