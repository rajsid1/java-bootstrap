package com.app.rest.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.app.util.constants.Constant;

/**
 * Created by rajdeep siddhapura.
 */
@XmlRootElement
public class StringResponse {

    private int code;
    private String message;

	public StringResponse()
	{
		this.setCode(Constant.NO_ERROR);
	}

	public StringResponse(String msg)
	{
		this();
		this.setMessage(msg);
	}

	@XmlElement
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
