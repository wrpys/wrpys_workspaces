package com.wrpys.app.vo;

import java.io.Serializable;

public class BasicRequestVo  implements Serializable {

	private RequestHeaderVo header;

	public RequestHeaderVo getHeader() {
		return header;
	}

	public void setHeader(RequestHeaderVo header) {
		this.header = header;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicRequestVo [header=");
		builder.append(header);
		builder.append("]");
		return builder.toString();
	}
}
