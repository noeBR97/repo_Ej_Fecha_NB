package org.example

class Fecha(private val dia: Int, private val mes: Int, private val anio: Int) {


    fun valida(): Boolean {
        var esValida=false
        if ((dia < 1 || dia > 31) && (mes < 1 || mes > 12)){
            var diaMes = diadelMes(mes)
            esValida = dia<=diaMes
        }
        return esValida
    } // … más métodos

    private fun diadelMes(mes: Int): Int {
        var diasMes = 0
        when (mes) {
            1, 3, 5, 7, 8, 10, 12 -> diasMes = 31
            4, 6, 9, 11 -> diasMes = 30
            2 -> diasMes = if (esBisiesto(anio)) 29 else 28
        }
        return diasMes
    }

    private fun esBisiesto(anio: Int) = anio % 400 == 0 || anio % 4 == 0 && anio % 100 != 0
}