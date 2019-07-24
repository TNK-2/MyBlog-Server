package com.myblog.api.domain.entity

import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "entry", schema = "myblog")
class EntryEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int,

    @Basic
    @Column(name = "title", nullable = false, length = 128)
    var title: String,

    @Basic
    @Column(name = "content", nullable = false, length = 2000)
    var content: String,

    @Basic
    @Column(name = "delete_flag", nullable = false)
    var deleteFlag: Boolean = false,

    @Basic
    @Column(name = "created_at", nullable = false)
    var createdAt: Timestamp = Timestamp(Date().time)
)
{}