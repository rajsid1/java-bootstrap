package com.app.rest.bean;

import java.text.MessageFormat;

import javax.xml.bind.annotation.XmlElement;

import com.app.rest.response.ResponseEnum;

/**
 * Created by rajdeep siddhapura.
 */
public abstract class APIResponse {

    /**
     * The additional message regarding the status of the response
     */
    private String message;

    /**
     * The code which is set by server.
     */
    private int code;

	public APIResponse()
	{
	}

	public APIResponse(int code, String message)
	{
		this.code = code;
		this.message = message;
	}

	public APIResponse(ResponseEnum responseEnum)
	{
		this.code = responseEnum.getCode();
		this.message = responseEnum.getMsg();
	}

	public APIResponse(ResponseEnum responseEnum, Object[] values)
	{
		this.code = responseEnum.getCode();
		this.message = MessageFormat.format(responseEnum.getMsg(), values);
	}

	@XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void set(ResponseEnum responseEnum)
    {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMsg();
    }

	public void set(ResponseEnum responseEnum, Object[] values)
	{
		this.code = responseEnum.getCode();
		this.message = MessageFormat.format(responseEnum.getMsg(), values);
	}
}
