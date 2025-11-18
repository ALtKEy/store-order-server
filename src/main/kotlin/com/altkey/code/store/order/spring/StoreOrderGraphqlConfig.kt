package com.altkey.code.store.order.spring

import graphql.scalars.ExtendedScalars
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer


@Configuration
class StoreOrderGraphqlConfig {
    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiringConfigurer {
        return RuntimeWiringConfigurer { wiringBuilder ->
            wiringBuilder
                .scalar(ExtendedScalars.GraphQLLong)
        }
    }
}