package com.xsc.exception;

import java.io.EOFException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.SocketException;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class InvokeExceptionMapper extends RuntimeException {

	/**
	 * the serialVersionUID
	 */
	private static final long serialVersionUID = -4756698547529912289L;

	private static final Logger LOGGER = Logger
			.getLogger(InvokeExceptionMapper.class);

	public String message;
	public String status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public InvokeExceptionMapper(Throwable cause) {
		super(cause);
		String code = ExceptionCode.INTERNAL_SERVER_ERROR;

		// 处理checked exception
		if (cause instanceof BaseException) {
			BaseException baseException = (BaseException) cause;
			code = baseException.getCode();
		} else if (cause instanceof NullPointerException) {
			code = ExceptionCode.NULL_POINTER_ERROR;
		} else if (cause instanceof ArithmeticException) {
			code = ExceptionCode.ARITHMETIC_ERROR;
		} else if (cause instanceof ArrayStoreException) {
			code = ExceptionCode.ARRAY_STORE_ERROR;
		} else if (cause instanceof ClassCastException) {
			code = ExceptionCode.CLASS_CAST_ERROR;
		} else if (cause instanceof IndexOutOfBoundsException) {
			code = ExceptionCode.INDEX_OUTOFBOUNDS_ERROR;
		} else if (cause instanceof SQLException) {
			code = ExceptionCode.DAO_ERROR;
		} else if (cause instanceof EOFException) {
			code = ExceptionCode.NETWORK_CONNECT_FAILED;
		} else if (cause instanceof ConnectException) {
			code = ExceptionCode.NETWORK_CONNECT_FAILED;
		} else if (cause instanceof SocketException) {
			code = ExceptionCode.NETWORK_CONNECT_FAILED;
		} else if (cause instanceof BindException) {
			code = ExceptionCode.NETWORK_CONNECT_FAILED;
		}
		LOGGER.error(code, cause);

		try {
			ReadExceptionCode jc = new ReadExceptionCode();
			String str = jc.ReadProperties(code);
			this.message = str;
			this.status = "500";
		} catch (Exception ex) {
			if (ex instanceof BaseException) {
				BaseException baseException = (BaseException) ex;
				String c = baseException.getCode();
				LOGGER.error(c, cause);
			}
		}
	}
}
