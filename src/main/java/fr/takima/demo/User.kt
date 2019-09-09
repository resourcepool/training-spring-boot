package fr.takima.demo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

/**
 *
 */
@Entity(name = "users")
data class User(@Id var id: Long?,
                @Column(name = "first_name") var firstName: String?,
                @Column(name = "last_name") var lastName: String?,
                @Column(name = "age") var age: Int?) {
    constructor() : this(null, null, null, null)

}
