package com.myblog.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api/hello")
class EntryController() {

    @GetMapping
    fun getAllEntries(httpServletRequest: HttpServletRequest): String {
        return "Hello MyBlog!!!"
    }

    @GetMapping
    fun getEntry(httpServletRequest: HttpServletRequest): String {
        return ""
    }

    @PostMapping
    fun addEntry() {

    }

    @PostMapping
    fun editEntry() {

    }

    @PostMapping
    fun deleteEntry(httpServletRequest: HttpServletRequest) {

    }
}