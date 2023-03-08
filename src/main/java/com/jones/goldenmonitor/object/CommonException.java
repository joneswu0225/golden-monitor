package com.jones.goldenmonitor.object;



public class CommonException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 457106199811190700L;
	private ErrorCode code;

	public CommonException() {
		super(ErrorCode.INTERNAL_ERROR.description);
		this.code = ErrorCode.INTERNAL_ERROR;
	}

	public CommonException(String msg) {
		super(msg);
		this.code = ErrorCode.INTERNAL_ERROR;
	}

	/**
	 * @param code 错误代码
	 */
	public CommonException(ErrorCode code) {
		super(code.description);
		this.code = code;
	}

	/**
	 * @param code 错误代码
	 * @param message 错误消息
	 */
	public CommonException(ErrorCode code, String message) {
		super(message);
		this.code = code;
	}

	/**
	 * @param code 错误代码
	 * @param cause 导致错误的异常
	 */
	public CommonException(ErrorCode code, Throwable cause) {
		super(cause);
		this.code = code;
	}


	/**
	 * @param code 错误代码
	 * @param message 错误消息
	 * @param cause 导致错误的异常
	 */
	public CommonException(ErrorCode code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ErrorCode getCode() {
		return this.code;
	}

}
