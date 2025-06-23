package com.udistrital.configuration;

import com.udistrital.constants.OpenApiConstants;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Ecommerce API",
                version = "1.0",
                description = "Ecommerce API"
        ),
        security = {
                @SecurityRequirement(name = OpenApiConstants.API_KEY)
        }
)
@SecurityScheme(
        name = "Bearer Authentication",
        description = "JWT authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenAPIConfiguration {

}
