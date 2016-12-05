package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.service.ItemParamService;
@Service
public class ItemParamServiceImpl implements ItemParamService {
	
	@Autowired
	private TbItemParamMapper paramMapper;
	
	
	/**
	 * 商品规格参数查询
	 */
	@Override
	public EasyUIDateGridResult getItemParam(int page, int rows) {
		//查询商品规格列表
		TbItemParamExample example = new TbItemParamExample();
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = paramMapper.selectByExampleWithBLOBs(example);
		//创建一个返回值对象
		EasyUIDateGridResult result = new EasyUIDateGridResult();
		result.setRows(list);
		//取page总条数
		PageInfo<TbItemParam> pageinfo = new PageInfo<>(list);
		result.setTotal((int) pageinfo.getTotal());
		return result;
	}

}
