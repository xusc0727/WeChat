package com.xsc.exception;

public class FileException extends BaseException {

	/**
	 * @param code  错误代码
	 */
	public FileException(String code) {
		super(code, null, code, null);
	}

	/**
	 * @param cause
	 *            异常接口
	 * @param code
	 *            错误代码
	 */
	public FileException(Throwable cause, String code) {
		super(code, cause, code, null);
	}

	/**
	 * @param code
	 *            错误代码
	 * @param values
	 *            一组异常信息待定参数
	 */
	public FileException(String code, Object[] values) {
		super(code, null, code, values);
	}

	/**
	 * @param cause
	 *            异常接口
	 * @param code
	 *            错误代码
	 * @param values
	 *            一组异常信息待定参数
	 */
	public FileException(Throwable cause, String code, Object[] values) {
		super(code, null, code, values);
	}

	private static final long serialVersionUID = -3711290613973933714L;
}
