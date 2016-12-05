package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**
 * 图片上传
 * <p>Title PictureController</p>
 * @author liubin
 * @date 2016年3月18日上午11:08:16
 */
@Controller
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile){
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证功能的兼容性 ，需要把result转换成json字符串
		String json = JsonUtils.objectToJson(result);
		return json;
	}	
}
