package com.jinadam.jupiter.api.main.auth.resp;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author Adam
 * 2025-09-05 22:41
 */
@Builder
@Data
public class LoginResp {

    @Schema(description = "Token名")
    private String tokenName;

    @Schema(description = "Token值")
    private String tokenValue;

    @Schema(description = "有效时间")
    private String timeout;
}
