package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

/**
 * 测试ftp服务器
 * <p>Title FTPClientTest</p>
 * @author liubin
 * @date 2016年3月17日下午3:03:15
 */
public class FTPClientTest {
	@Test
	public void testFtp()throws Exception{
		//连接ftp服务器  
		FTPClient client = new FTPClient();
		client.connect("192.168.209.129", 21);
		//登陆ftp服务器
		client.login("ftpuser", "ftpuser");
		//读取本地文件
		FileInputStream in = new FileInputStream(new File("C:\\图片\\123.jpg"));
		/**
		 * 上传文件
		 */
		//上传指定目录
		client.changeWorkingDirectory("/home/ftpuser/www/images/2015");
		//修改文件上传格式
		client.setFileType(FTP.BINARY_FILE_TYPE);
		//指定文件类型 ，第二个参数是文件流
		client.storeFile("hello.jpg", in);
		//退出登陆
		client.logout();
	}
	
	@Test
	public void testa(){
		
		
		            for (int a = 0; a < 100000;a++) {
		                if (a % 2 == 1 && a % 3 == 0 && a % 4 == 1 && a % 5 == 1 && a % 6 == 3 && a % 7 == 0 && a % 8 == 1 && a % 9 == 0) {
		                    System.out.println(a + "======");
		                }
		            }
		       
	}
}
