package com.app.util.constants;

/**
 * Created by rajdeep siddhapura.
 */
public interface Constant {

    int STATUS_CODE = 200;

    // Server errors 100 - 199
    int SERVER_ERROR = 100;
    int NO_ERROR = 110;

    interface AuthToken {
        int INVALID_AUTHTOKEN = 300;
        int AUTHTOKEN_NOT_FOUND = 301;
    }

	public interface Json {
		int INVALID_NODE_VALUE = 600;
	}
}
