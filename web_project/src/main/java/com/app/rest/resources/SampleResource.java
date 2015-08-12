package com.app.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.rest.bean.UserDetails;

/**
 * Created by rajdeep siddhapura.
 */

@Path("sample")
public class SampleResource
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleResource.class);

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UserDetails getSample() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserId(23l);
        userDetails.setEmail("rajdeep.siddhapura@gmail.com");
        userDetails.setPassword("foobar");
        return userDetails;
    }

}
