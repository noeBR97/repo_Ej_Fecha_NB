package org.example

class Fecha(private val d: Int, private val m: Int, private val a: Int) {


    fun valida(): Boolean {

        if (d < 1 || d > 31) return false
        if (m < 1 || m > 12) return false

        // determinamos la cantidad de días del mes:
        return diaMes()
    } // … más métodos

    private fun diaMes(): Boolean {
        var diasMes = 0
        when (m) {
            1, 3, 5, 7, 8, 10, 12 -> diasMes = 31
            4, 6, 9, 11 -> diasMes = 30
            2 -> diasMes = if (esBisiesto(anio)) 29 else 28
        }
        return if (d > diasMes) false else true
    }

    private fun esBisiesto(anio: Int) = anio % 400 == 0 || anio % 4 == 0 && anio % 100 != 0
}