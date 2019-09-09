package fr.takima.demo

/**
 *
 */
data class User(var id: Long?, var firstName: String?, var lastName: String?, var age: Int?) {
    constructor() : this(null, null, null, null)

}
