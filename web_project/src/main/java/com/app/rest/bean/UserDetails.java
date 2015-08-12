package com.app.rest.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rajdeep siddhapura.
 */

@XmlRootElement(name = "user_details")
public class UserDetails
{

	@XmlElement(name = "user_id")
    private Long userId;
    private String email;
    private String password;
    private String mobile;
	@XmlElement(name = "auth_token")
    private String authToken;
	@XmlElement (name = "first_name")
    private String firstName;
	@XmlElement (name = "last_name")
    private String lastName;
    private Byte gender;

	public UserDetails() {
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        if (mobile != null) {
            this.mobile = mobile.toLowerCase();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	public Byte getGender()
	{
		return gender;
	}

	public void setGender(Byte gender)
	{
		this.gender = gender;
	}

}
