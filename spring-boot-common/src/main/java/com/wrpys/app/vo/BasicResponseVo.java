package com.wrpys.app.vo;

import java.io.Serializable;

public class BasicResponseVo  implements Serializable {

	private static final long serialVersionUID = -2777012860114031718L;
	
	private ResponseHeaderVo header;

	public ResponseHeaderVo getHeader() {
		return header;
	}

	public void setHeader(ResponseHeaderVo header) {
		this.header = header;
	}
}
