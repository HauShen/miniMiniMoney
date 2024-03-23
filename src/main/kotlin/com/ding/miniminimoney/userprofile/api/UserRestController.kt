package com.ding.miniminimoney.userprofile.api

import com.ding.miniminimoney.userprofile.services.UserService
import com.ding.miniminimoney.scheduler.lds.LdsService
import com.ding.miniminimoney.userprofile.rs.dto.*
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

@RestController
@RequestMapping(
    "/user"
)
class UserRestController (
        private val userService: UserService,
        private val ldsService: LdsService,
){

    @GetMapping("/get/{userId}")
    fun getUser(
        @PathVariable("userId") userId: String
    ): ResponseEntity<UserResponseBody> {
        val user = userService.getUserByUserIdOrThrow(userId)
        return ResponseEntity.ok(user.toUserResponseBody())
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

    @GetMapping("/speak")
    fun speak(
    ): ResponseEntity<String> {
        return ResponseEntity.ok(LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + UUID.randomUUID().toString())
    }

    @PutMapping("/update/{userId}")
    fun updateUser(

            @PathVariable("userId") userId: String,

            @RequestBody
            updateuserRequestBody: UserUpdateRequestBody

    ): ResponseEntity<UserResponseBody> {
        val userCreated = userService.updateUser(updateuserRequestBody, userId)
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .allow(HttpMethod.GET)
                .body(userCreated)
    }

    @PostMapping("/someString")
    fun detectLanguage(
            @RequestPart("file", required = false)
            file: MultipartFile
    ): ResponseEntity<String> {
        val userCreated = ldsService.getDetectedLanguage(file.bytes)
        return ResponseEntity.ok(userCreated)
    }
}