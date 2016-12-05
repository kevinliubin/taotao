package com.taotao.common.pojo;
/**
 * 根据parentId查询商品分类列表。
 * <p>Title EUTreeNode</p>
 * @author liubin
 * @date 2016年3月16日下午2:10:32
 */
public class EUTreeNode {
	
	private long id;
	private String text;
	private String state;
	
	
	
	public EUTreeNode() {
		super();
	}
	public EUTreeNode(long id, String text, String state) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
