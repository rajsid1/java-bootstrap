package com.app.rest.errorhandling;

import java.text.MessageFormat;

import com.app.rest.response.ResponseEnum;
import com.app.util.constants.Constant;

/**
 * Created by rajdeep siddhapura.
 */
public class AppException extends Exception {

    private int status;
    private int code;
    private String message;
    private String developerMessage;

    public AppException(int status, int code, String message, String developerMessage) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.developerMessage = developerMessage;
    }

	public AppException(int status, int code, String message)
	{
		this(status, code, message, message);
	}

	public AppException(int code, String message)
	{
		this(Constant.STATUS_CODE, code, message);
	}

    public AppException(ResponseEnum responseEnum)
    {
		this((responseEnum == null ? ResponseEnum.SERVER_ERROR : responseEnum).getCode(), (responseEnum == null ? ResponseEnum.SERVER_ERROR : responseEnum).getMsg());
    }

	public AppException(ResponseEnum responseEnum, Object[] values)
	{
		this(responseEnum.getCode(), MessageFormat.format(responseEnum.getMsg(), values));
	}

	public AppException(ResponseEnum responseEnum, Object value)
	{
		this(responseEnum, new Object[]{value});
	}

	public AppException() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
