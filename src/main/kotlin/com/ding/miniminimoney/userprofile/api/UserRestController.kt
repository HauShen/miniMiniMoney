package com.ding.miniminimoney.userprofile.api

import com.ding.miniminimoney.userprofile.rs.dto.UserRequestBody
import com.ding.miniminimoney.userprofile.rs.dto.UserResponseBody
import com.ding.miniminimoney.userprofile.services.UserService
import com.ding.miniminimoney.lds.LdsService
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping(
    "/users"
)
class UserRestController (
        private val userService: UserService,
        private val ldsService: LdsService
){
    @GetMapping("/get/{userId}")
    fun getUser(
        @PathVariable("userId") userId: String
    ): ResponseEntity<UserResponseBody> {
        val user = userService.getUserByUserId(userId)
        return ResponseEntity.ok(user)
    }


    @PostMapping("/create")
    fun createUser(
            @RequestBody
            createUserRequestBody: UserRequestBody
    ): ResponseEntity<UserResponseBody> {
        val userCreated = userService.createUser(createUserRequestBody)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .allow(HttpMethod.GET)
                .body(userCreated)
    }

    @PostMapping("/create")
    fun uploadDoc(
            @RequestPart("file", required = false)
            file: MultipartFile
    ): ResponseEntity<String> {
        val lang = ldsService.getDetectedLanguage(file)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .allow(HttpMethod.GET)
                .body(lang)
    }



}