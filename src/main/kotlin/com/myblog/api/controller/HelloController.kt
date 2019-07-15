package com.myblog.api.controller

import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/hello")
class HellorController() {

    @GetMapping
    fun getHello(httpServletRequest: HttpServletRequest): String {
        return "Hello MyBlog!!!"
    }
}
