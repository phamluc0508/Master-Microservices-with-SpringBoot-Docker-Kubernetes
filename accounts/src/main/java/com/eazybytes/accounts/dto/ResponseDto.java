package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {

    @Schema(
            description = "Status code of the response",
            example = "200"
    )
    private String statusCode;

    @Schema(
            description = "Status message of the response",
            example = "Request processed successfully"
    )
    private String statusMsg;
}
