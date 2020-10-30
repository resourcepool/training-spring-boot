package io.takima.demo.security

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "firebase")
class FirebaseProperties {
    var databaseUrl: String? = null
}
