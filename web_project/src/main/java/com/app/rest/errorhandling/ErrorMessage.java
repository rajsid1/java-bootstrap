package com.app.rest.errorhandling;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rajdeep siddhapura.
 */
@XmlRootElement
public class ErrorMessage {
    private int status;
    private int code;
    private String message;
    private String developerMessage;

    public ErrorMessage() {
    }

    public ErrorMessage(AppException appException) {
        setStatus(appException.getStatus());
        setCode(appException.getCode());
        setMessage(appException.getMessage());
        setDeveloperMessage(appException.getDeveloperMessage());
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    @XmlElement
    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
