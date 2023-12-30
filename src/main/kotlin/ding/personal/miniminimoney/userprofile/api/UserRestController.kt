package ding.personal.miniminimoney.userprofile.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(
    "/users"
)
internal class UserRestController (
){
    @GetMapping("/get/{userId}")
    fun getUser(
        @PathVariable("userId") userId: String
    ):String{
        print(userId)
        return userId
    }

}