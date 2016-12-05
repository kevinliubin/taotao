package com.taotao.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 商品管理Service
 */
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemExample;
import com.taotao.pojo.TbItemExample.Criteria;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper descMapper;
	
	
	@Override
	public TbItem getItemId(long ItemId) {
		TbItemExample example = new TbItemExample();
		//创建查询条件
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(ItemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null && list.size()>0){
			TbItem item = list.get(0);
			return item ;
		}
		return null;
	}
	
	/**
	 * 商品列表查询
	 */
	@Override
	public EasyUIDateGridResult getItemList(int page, int rows) {
		//查询为商品列表
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EasyUIDateGridResult result = new EasyUIDateGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItem> pageinfo = new PageInfo<>(list);
		result.setTotal((int)pageinfo.getTotal());
		return result;
	}
	/**
	 * 商品的添加
	 * 补全表单没有的字段
	 */
	@Override
	public TaotaoResult createTbitem(TbItem item,String desc) throws Exception{
		//生成商品Id
		Long itemId = IDUtils.genItemId();
		//补全id
		item.setId(itemId);
		//商品状态，1-正常，2-下架，3-删除',
		item.setStatus((byte) 1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		//把数据插入到数据库
		itemMapper.insert(item);
		TaotaoResult result = insertItemDesc(itemId, desc);
		if(result.getStatus() != 200){
			throw new Exception();
		}
		return TaotaoResult.ok();
	}

	/**
	 * 商品描述的添加
	 */
	public TaotaoResult insertItemDesc(Long itemId,String desc){
		TbItemDesc itemdesc = new TbItemDesc();
		itemdesc.setItemId(itemId);
		itemdesc.setItemDesc(desc);
		itemdesc.setCreated(new Date());
		itemdesc.setUpdated(new Date());
		descMapper.insert(itemdesc);
		return TaotaoResult.ok();
	}
	
	
}
