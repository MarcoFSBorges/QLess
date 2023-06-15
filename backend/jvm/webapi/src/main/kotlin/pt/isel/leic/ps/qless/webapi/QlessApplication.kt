package pt.isel.leic.ps.qless.webapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])//(scanBasePackages = ["pt.isel.leic.ps.qless.webapi.api", "pt.isel.leic.ps.qless.webapi.model"])
class QlessApplication

fun main(args: Array<String>) {
	runApplication<QlessApplication>(*args)
}
