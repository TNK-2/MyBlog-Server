package com.myblog.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/hello")
class HelloController {
    @GetMapping
    fun getHello(httpServletRequest: HttpServletRequest): String {
        return "Hello MyBlog!!!"
    }
}