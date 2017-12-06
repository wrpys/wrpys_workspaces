package com.wrpys.app.vo;

import java.io.Serializable;

/**
*
* 用户响应报文头
*
* @since 1.0.0-SNAPSHOT
* @author Li Siqi
*/
public class ResponseHeaderVo implements Serializable{
	private static final long serialVersionUID = 7046521551342735174L;
	private String respDesc;     // 结果描述
	private String respCode;     // 应答结果编码，成功则返回0，异常则参看返回错误代码定义
	private String requestSeq;   // 请求序列号
	private String responseTime; // 应答时间，格式：’yyyymmddhh24miss

	public String getRespDesc() {
		return respDesc;
	}

	public void setRespDesc(String respDesc) {
		this.respDesc = respDesc;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(String requestSeq) {
		this.requestSeq = requestSeq;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

}
