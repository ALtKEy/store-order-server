package com.altkey.code.store.order.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.io.File

@SpringBootApplication(scanBasePackages = ["com.altkey.code.store.order"])
class StoreOrderApplication

fun main(args: Array<String>) {
	//
	System.setProperty("module.name", "store-order")
	System.setProperty("module.home", System.getProperty("user.dir"))
	System.setProperty("config.home", System.getProperty("user.dir") + File.separator + "config" + File.separator)
	runApplication<StoreOrderApplication>(*args)
}