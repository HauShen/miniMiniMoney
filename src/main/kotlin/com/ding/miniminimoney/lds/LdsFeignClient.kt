import com.ding.miniminimoney.lds.FeignConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.multipart.MultipartFile

@FeignClient(
        name = "lds",
        url = "0uuiqy3tr2.execute-api.ap-southeaste-1.amazonaws.com",
        configuration = [FeignConfig::class]
        )

interface LdsFeignClient {

    @PostMapping("/langdetect/pdf")
    fun getLangByDocument(
            @RequestPart("files", required = false)
            file: MultipartFile
    ): String

}