package com.lishibook.output;

import java.io.Serializable;

/**
 * 如果只用返回执行成功与否的基本信息，使用该类
 * @author mengtao
 *
 */
public class BaseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;// 返回 -1：失败；1：成功

	private String message;// 错误时消息

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
