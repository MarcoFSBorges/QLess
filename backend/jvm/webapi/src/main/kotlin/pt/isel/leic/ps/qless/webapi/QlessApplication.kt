package pt.isel.leic.ps.qless.webapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication//(scanBasePackages = ["pt.isel.leic.ps.qless.webapi.api", "pt.isel.leic.ps.qless.webapi.model"])
class QlessApplication

fun main(args: Array<String>) {
	runApplication<QlessApplication>(*args)
}
