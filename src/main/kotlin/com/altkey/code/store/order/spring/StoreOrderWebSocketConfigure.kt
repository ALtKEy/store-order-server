package com.altkey.code.store.order.spring

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

/**
 * Spring WebSocket 설정
 *
 * @author Kim Jung-tae(altkey)
 * @since 2025-04-07
 */
@Configuration
@EnableWebSocketMessageBroker
class StoreOrderWebSocketConfigure : WebSocketMessageBrokerConfigurer {
    //
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
       registry.enableSimpleBroker("/topic")
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws/order").addInterceptors().setAllowedOrigins("*")
    }
}