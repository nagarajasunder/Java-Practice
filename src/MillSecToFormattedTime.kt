import java.text.SimpleDateFormat
import java.util.*

fun main() {
    val timeInMsBefore = 1646752740184 //before
    val timeInMsAfter = 1646752740184 //after
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss a")

    println(sdf.format(timeInMsBefore))
    println(sdf.format(timeInMsAfter))
}