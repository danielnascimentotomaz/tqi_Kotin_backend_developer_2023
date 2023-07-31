package juMarket.com.sistema.autoatendimento.exception

import java.time.LocalDate

class ExeceptionDetails(
    val title:String,
    val timestamp: LocalDate,
    val status: Int,
    val exception: String,
    val details: MutableMap<String,String?>) {
}