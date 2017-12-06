package com.wrpys.app.vo;

/**
 * 资源管理基础响应VO对象
 * @author zkq
 * @param <T>
 */
public class BasicResponseContentVo<T> extends BasicResponseVo {
	private T content;

	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
}
