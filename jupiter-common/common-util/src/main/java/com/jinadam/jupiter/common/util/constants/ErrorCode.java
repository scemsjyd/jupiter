package com.jinadam.jupiter.common.util.constants;


/**
 * @author Adam
 * 2025-09-04 20:00
 */
public class ErrorCode {
    private ErrorCode() {
    }

    public static class COMMON {
        public static final String SUCCESS = "success";
        public static final String ERROR = "error";
    }

    public static class AUTH {
        // reset password
        public static final String NO_PASS = "auth.reset_password";
        public static final String FAIL = "auth.fail";
        public static final String NOT_PERMISSION = "auth.not_permission";
    }

    public static class BIZ {
        // reset password
        public static final String USERNAME_NOT_EXIST = "biz.username_not_exist";
    }


}
