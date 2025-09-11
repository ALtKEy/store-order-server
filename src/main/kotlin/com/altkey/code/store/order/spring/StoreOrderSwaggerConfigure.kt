package com.altkey.code.store.order.spring

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-09-10
 */
@Configuration
class StoreOrderSwaggerConfigure {
    //
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI().info(Info()
            .title("OrderSwagger API")
            .version("v25.9.0")
            .description("The API provided by the Order Swagger API")
        )
    }
}