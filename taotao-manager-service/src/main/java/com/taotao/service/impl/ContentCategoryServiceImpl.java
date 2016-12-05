package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.EasyUIDateGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EUTreeNode> getContentCategory(long parentId) {
		//根据parentId查询节点信息
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list2 = contentCategoryMapper.selectByExample(example);
		//创建返回对象
		List<EUTreeNode> list = new ArrayList<EUTreeNode>();
		EUTreeNode node = null;
		for (TbContentCategory contentCategory : list2) {
			//创建一个节点
			node = new EUTreeNode();
			node.setId(contentCategory.getId());
			node.setText(contentCategory.getName());
			node.setState(contentCategory.getIsParent()?"closed":"open");
			list.add(node);
		}
		return list;
	}

	@Override
	public TaotaoResult createContentCategory(long parentId, String name) {
		//创建一个pojo
		TbContentCategory category = new TbContentCategory();
		category.setCreated(new Date());
		category.setUpdated(new Date());
		category.setName(name);
		category.setParentId(parentId);
		//状态。可选值:1(正常),2(删除)',
		category.setStatus(1);
		//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数',
		category.setSortOrder(1);
		category.setIsParent(false);
		//添加记录
		contentCategoryMapper.insert(category);
		//查看父节点的isparent是否为true,如果不是true 改为true
		TbContentCategory selectByPrimaryKey = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为true
		if (!selectByPrimaryKey.getIsParent()) {
			selectByPrimaryKey.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(selectByPrimaryKey);
		}
		return TaotaoResult.ok(category);
	}

	@Override
	public TaotaoResult updateContentCategory(long id, String name) {
		TbContentCategory contentCategory = contentCategoryMapper.selectByPrimaryKey(id);
		contentCategory.setName(name);
		contentCategoryMapper.updateByPrimaryKey(contentCategory);
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public TaotaoResult deleteContentCategory(long id) {
		//根据id查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		if (!CollectionUtils.isEmpty(list)) {
			contentCategoryMapper.deleteByPrimaryKey(id);
		}
		return TaotaoResult.ok();
	}

}
