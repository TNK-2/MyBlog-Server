package com.myblog.api.service

import com.myblog.api.domain.dto.request.CreateEntryForm
import com.myblog.api.domain.entity.EntryEntity
import com.myblog.api.domain.exception.NotFoundException
import com.myblog.api.domain.repository.EntryRepository
import org.springframework.stereotype.Service

@Service
class EntryService(
    private val entryRepository: EntryRepository
)
{
    fun getAllEntry(): List<EntryEntity> {
        return entryRepository.findByDeleteFlagFalse();
    }

    fun getEntryById(id: Int): EntryEntity {
        return entryRepository.findByIdAndDeleteFlagFalse(id) ?: throw NotFoundException("エントリーが見つかりませんでした。");
    }

    fun createEntry(form: CreateEntryForm): EntryEntity {
        val newEntry = EntryEntity(
            form.id,
            form.title,
            form.content
        );
        return entryRepository.save(newEntry);
    }

    fun updateEntry(id: Int, form: CreateEntryForm): EntryEntity {
        val entry = entryRepository.findByIdAndDeleteFlagFalse(id) ?: throw NotFoundException("エントリーが見つかりませんでした。");
        entry.id = form.id;
        entry.title = form.title;
        entry.content = form.content;
        return entryRepository.save(entry);
    }

    fun deleteEntry(id: Int) {
        val entry = entryRepository.findByIdAndDeleteFlagFalse(id) ?: throw NotFoundException("エントリーが見つかりませんでした。")
        entry.deleteFlag = true;
        entryRepository.save(entry);
    }
}