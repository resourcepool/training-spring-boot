package io.takima.demo

import javax.persistence.*

/**
 *
 */
@Entity(name = "books")
data class Book(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id var id: Long?,
        @Column(name = "borrower_id") var borrowerId: String?,
        @Column(name = "author") var author: String?,
        @Column(name = "title") var title: String?) {
    constructor() : this(null, null, null, null)

}
