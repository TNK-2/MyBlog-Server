package com.myblog.api.domain.repository

import com.myblog.api.domain.entity.EntryEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EntryRepository : JpaRepository<EntryEntity, Int> {
    fun findByIdAndDeleteFlagFalse(id: Int): EntryEntity?
    fun findByDeleteFlagFalse(): List<EntryEntity>
}