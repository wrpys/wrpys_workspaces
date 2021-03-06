package com.wrpys.app.vo;

import java.io.Serializable;

/**
*
* 用户请求报文头
*
* @since 1.0.0-SNAPSHOT
* @author wrp
*/
public class RequestHeaderVo  implements Serializable {
	/**
	 * 用户令牌，每次登录的时候生成，登出时删除
	 */
	private String userToken;
	/**
	 * 请求序列号
	 */
	private String requestSeq;
	/**
	 * 请求时间，格式：’yyyymmddhh24miss’
	 */
	private String requestTime;
	/**
	 * 请求来源 web，service，app
	 */
	private String reqSource;
	/**
	 * 版本号
	 */
	private String appVersion;
	/**
	 * 用户ID，未登录则为空
	 */
	private String userId;

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getRequestSeq() {
		return requestSeq;
	}

	public void setRequestSeq(String requestSeq) {
		this.requestSeq = requestSeq;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestHeaderVo [userToken=");
		builder.append(userToken);
		builder.append(", requestSeq=");
		builder.append(requestSeq);
		builder.append(", requestTime=");
		builder.append(requestTime);
		builder.append(", reqSource=");
		builder.append(reqSource);
		builder.append(", appVersion=");
		builder.append(appVersion);
		builder.append(", userId=");
		builder.append(userId);
		builder.append("]");
		return builder.toString();
	}

	public String getReqSource() {
		return reqSource;
	}

	public void setReqSource(String reqSource) {
		this.reqSource = reqSource;
	}

}
