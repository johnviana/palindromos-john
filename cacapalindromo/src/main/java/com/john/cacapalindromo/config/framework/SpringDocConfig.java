package com.john.cacapalindromo.config.framework;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SpringDocConfig {

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Palindrome API").version("v1").description("Caça-palíndromo"))
                .components(new Components().responses(makeResponse()));
    }

    @Bean
    public OpenApiCustomizer openApiCustomizer() {
        return openApi -> {
            openApi.getPaths().values().forEach(path -> path.readOperationsMap().forEach((method, operation) -> {
                addDefaultApiResponses(operation.getResponses(), method);
            }));
        };
    }

    private void addDefaultApiResponses(ApiResponses responses, HttpMethod method) {
        responses.addApiResponse(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                new ApiResponse().$ref(HttpStatus.INTERNAL_SERVER_ERROR.name()));
        responses.addApiResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                new ApiResponse().$ref(HttpStatus.BAD_REQUEST.name()));
        responses.addApiResponse(String.valueOf(HttpStatus.NOT_FOUND.value()),
                new ApiResponse().$ref(HttpStatus.NOT_FOUND.name()));

        switch (method) {
            case GET, POST, PUT -> {
                responses.addApiResponse(String.valueOf(HttpStatus.NOT_ACCEPTABLE.value()),
                        new ApiResponse().$ref(HttpStatus.NOT_ACCEPTABLE.name()));
                responses.addApiResponse(String.valueOf(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()),
                        new ApiResponse().$ref(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name()));
            }
            case DELETE -> {
                responses.addApiResponse(String.valueOf(HttpStatus.NO_CONTENT.value()),
                        new ApiResponse().$ref(HttpStatus.NO_CONTENT.name()));
            }
        }
    }

    private Map<String, ApiResponse> makeResponse() {
        Map<String, ApiResponse> apiResponseMap = new HashMap<>();

        apiResponseMap.put(HttpStatus.INTERNAL_SERVER_ERROR.name(),
                new ApiResponse()
                        .description("A generic error message, given when no more specific message is suitable."));
        apiResponseMap.put(HttpStatus.BAD_REQUEST.name(), new ApiResponse()
                .description("The request cannot be fulfilled due to bad syntax (client problem)."));
        apiResponseMap.put(HttpStatus.NOT_FOUND.name(),
                new ApiResponse()
                        .description("The requested page could not be found but may be available again in the future."));
        apiResponseMap.put(HttpStatus.NO_CONTENT.name(),
                new ApiResponse()
                        .description("The request has been successfully processed, but is not returning any content."));
        apiResponseMap.put(HttpStatus.NOT_ACCEPTABLE.name(),
                new ApiResponse()
                        .description("The server can only generate a response that is not accepted by the client."));
        apiResponseMap.put(HttpStatus.UNSUPPORTED_MEDIA_TYPE.name(),
                new ApiResponse()
                        .description("The server will not accept the request, because the media type is not supported."));

        return apiResponseMap;
    }

}
