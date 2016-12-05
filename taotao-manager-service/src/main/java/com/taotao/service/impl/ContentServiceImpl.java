package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.pojo.TbContentExample.Criteria;
import com.taotao.service.ContentService;
@Service
public class ContentServiceImpl implements ContentService{
	
	@Autowired
	private TbContentMapper contentMapper;
	
	
	@Override
	public EasyUIDateGridResult getContentByCatrgoryId(long categoryId, int page, int rows) {
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		if (0!=categoryId) {
			criteria.andCategoryIdEqualTo(categoryId);
		}
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExample(example);
		//创建一个返回值对象
		EasyUIDateGridResult result = new EasyUIDateGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		result.setTotal((int)pageInfo.getTotal());
		return result;
	}


	@Override
	public TaotaoResult insertContent(TbContent content) {
		
		return null;
	}
	
}
