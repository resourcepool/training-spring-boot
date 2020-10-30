package io.takima.demo

import javax.persistence.*

/**
 *
 */
@Entity(name = "users")
data class User(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var uid: String?,
        @Column(name = "display_name") var displayName: String?,
        @Column(name = "email") var email: String?,
        @Column(name = "photo_url") var photoUrl: String?) {
    constructor() : this(null, null, null, null)

}
