package pt.isel.leic.ps.qless.webapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QlessApplication

fun main(args: Array<String>) {
	runApplication<QlessApplication>(*args)
}
