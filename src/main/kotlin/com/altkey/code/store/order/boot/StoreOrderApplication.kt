package com.altkey.code.store.order.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.io.File

@SpringBootApplication
//@ComponentScan(basePackages = ["com.altkey.code"])
//@EntityScan(basePackages = ["com.altkey.code.context.store.order.entity"])
//@EnableJpaRepositories(basePackages = ["com.altkey.code.store.order.repository"])
class StoreOrderApplication

fun main(args: Array<String>) {
	//
	System.setProperty("spring.profiles.active", System.getProperty("spring.profiles.active", "local"))

	System.setProperty("module.name", "storeorder")
	System.setProperty("module.home", System.getProperty("user.dir"))
	System.setProperty("module.config", System.getProperty("user.dir") + File.separator + "config" + File.separator)

	runApplication<StoreOrderApplication>(*args)
}