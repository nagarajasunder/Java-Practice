import java.security.SecureRandom

fun main() {
    getRandomPassword()
}

fun getRandomPassword() {

    val passwordChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~"

    val password = StringBuilder()
    val secureRandom = SecureRandom()

    while (password.length < 50) {
        val index = (secureRandom.nextFloat() * passwordChars.length).toInt()
        password.append(passwordChars[index])
    }

    println(password.toString())
}
