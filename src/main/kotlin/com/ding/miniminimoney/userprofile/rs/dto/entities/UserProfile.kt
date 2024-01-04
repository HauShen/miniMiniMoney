package com.ding.miniminimoney.userprofile.rs.dto.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.ding.miniminimoney.wallet.persistence.entities.Wallet
import jakarta.persistence.*
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
        val name: String,

        @JsonIgnoreProperties
        @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinColumn(name = "wallet_id", referencedColumnName = "oid")
        val wallet: Wallet? = null,

        @Column(name="birthday")
        val birthday: LocalDate? = null,

        @Column(name="created_at")
        val createdAt: Instant? = Instant.now(),

        @Column(name="created_by")
        val createdBy: String? = null,

        @Column(name="updated_at")
        val updatedAt: Instant? = null,

        @Column(name="updated_by")
        val updatedBy: String? = null,
){
}