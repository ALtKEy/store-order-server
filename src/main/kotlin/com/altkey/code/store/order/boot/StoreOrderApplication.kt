package com.altkey.code.store.order.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File

@SpringBootApplication
class StoreOrderApplication

fun main(args: Array<String>) {
	//
	System.setProperty("spring.profiles.active", System.getProperty("spring.profiles.active", "local"))

	System.setProperty("module.name", "storeorder")
	System.setProperty("module.home", System.getProperty("user.dir"))
	System.setProperty("module.config", System.getProperty("user.dir") + File.separator + "config" + File.separator)

	runApplication<StoreOrderApplication>(*args)
}