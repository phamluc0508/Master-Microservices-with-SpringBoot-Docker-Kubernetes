package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.dto.CustomerDetailDto;
import com.eazybytes.accounts.dto.ErrorResponseDto;
import com.eazybytes.accounts.service.ICustomersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = (MediaType.APPLICATION_JSON_VALUE))
@RequiredArgsConstructor
@Validated
@Tag(
        name = "CRUD Rest Apis for Customer in EazyBank",
        description = "Rest Apis in Eazy Bank to Fetch customer Details"
)
@Slf4j
public class CustomerController {

    private final ICustomersService iCustomersService;

    @Operation(
            summary = "Fetch Customer Details Rest Api",
            description = "Rest Api to fetch customer detail based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailDto> fetchCustomerDetails(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestParam
            @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
            String mobileNumber) {
        log.debug("fetchCustomerDetails() method start");
        CustomerDetailDto customerDetailDto = iCustomersService.fetchCustomerDetails(mobileNumber, correlationId);
        log.debug("fetchCustomerDetails() method end");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerDetailDto);
    }
}
