package com.ding.miniminimoney.userprofile.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.ding.miniminimoney.wallet.entities.Wallet
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import org.apache.commons.lang3.builder.ToStringExclude
import java.time.LocalDate
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "user_profile")
data class UserProfile (
        @Id
        @SequenceGenerator(allocationSize = 1, name = "UserIdSequenceGenerator", sequenceName = "s_user_profile" )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdSequenceGenerator")
        @Column(name="oid")
        val oid: Long = 0,

        @Column(name="user_id")
        var userId: String = UUID.randomUUID().toString(),

        @Column(name="name")
        var name: String,

        @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
        @JoinColumn(name= "wallet_oid")
        var wallet: Wallet? = null,

        @Column(name="birthday")
        var birthday: LocalDate? = null,

        @Column(name="created_at")
        val createdAt: Instant? = Instant.now(),

        @Column(name="created_by")
        val createdBy: String? = null,

        @Column(name="updated_at")
        var updatedAt: Instant? = null,

        @Column(name="updated_by")
        val updatedBy: String? = null,
){

}