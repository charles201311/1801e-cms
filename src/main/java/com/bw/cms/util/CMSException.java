package com.bw.cms.util;

/**
 * 
 * @ClassName: CMSException
 * @Description: cms异常
 * @author: charles
 * @date: 2020年5月8日 下午3:50:59
 */
public class CMSException extends RuntimeException {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public CMSException() {
		super();
	}

	public CMSException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
