package com.myblog.api.domain.entity

import javax.persistence.*

@Entity
@Table(name = "user", schema = "myblog")
data class UserEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int,

    @Basic
    @Column(name = "name", nullable = false, length = 128)
    var name: String,

    @Basic
    @Column(name = "delete_flag", nullable = false)
    var deleteFlag: Boolean = false,

    @Basic
    @Column(name = "access_token", nullable = true, length = 128)
    var accessToken: String
)
{
}