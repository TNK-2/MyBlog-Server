package com.myblog.api.controller

import com.myblog.api.domain.dto.request.CreateEntryForm
import com.myblog.api.domain.entity.EntryEntity
import com.myblog.api.domain.exception.AuthenticationException
import com.myblog.api.domain.exception.ValidationException
import com.myblog.api.service.AuthService
import com.myblog.api.service.EntryService
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

@RestController
@RequestMapping("/api/entry")
class EntryController(
    private val authService: AuthService,
    private val entryService: EntryService
) {

    @GetMapping
    fun getAllEntries (
    ): ResponseEntity<List<EntryEntity>> {
        return ResponseEntity.ok(entryService.getAllEntry());
    }

    @GetMapping("/{id:[0-9]{1,10}}")
    fun getEntry (
        @PathVariable id: Int
    ): ResponseEntity<EntryEntity> {
        return ResponseEntity.ok(entryService.getEntryById(id));
    }

    @PostMapping
    fun createEntry (
        @RequestBody @Valid form: CreateEntryForm,
        result: BindingResult,
        httpServletRequest: HttpServletRequest
    ): ResponseEntity<EntryEntity> {
        if (authService.isAuthenticated(httpServletRequest.getParameter("accessToken")))
            throw AuthenticationException("not authenticated")
        if (result.hasErrors())
            throw ValidationException(result.fieldErrors)
        return ResponseEntity.ok(entryService.createEntry(form));
    }

    @PutMapping("/{id:[0-9]{1,10}}")
    fun updateEntry (
        @PathVariable id: Int,
        @RequestBody @Valid form: CreateEntryForm,
        result: BindingResult,
        httpServletRequest: HttpServletRequest
    ): ResponseEntity<EntryEntity> {
        if (authService.isAuthenticated(httpServletRequest.getParameter("accessToken")))
            throw AuthenticationException("not authenticated")
        if (result.hasErrors())
            throw ValidationException(result.fieldErrors)
        return ResponseEntity.ok(entryService.updateEntry(id, form));
    }

    @DeleteMapping("/{id:[0-9]{1,10}}")
    fun deleteEntry (
        @PathVariable id: Int,
        httpServletRequest: HttpServletRequest
    ) {
        if (authService.isAuthenticated(httpServletRequest.getParameter("accessToken")))
            throw AuthenticationException("not authenticated")
        entryService.deleteEntry(id);
        return;
    }
}