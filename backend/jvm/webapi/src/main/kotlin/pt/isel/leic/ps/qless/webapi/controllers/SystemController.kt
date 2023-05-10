package pt.isel.leic.ps.qless.webapi.controllers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class SystemController {
    @GetMapping("/webapi-health")
    fun webapiHealth() = System.currentTimeMillis().toString()
}