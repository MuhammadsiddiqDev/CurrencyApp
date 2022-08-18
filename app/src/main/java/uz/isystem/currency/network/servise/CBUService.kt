package uz.isystem.currency.network.servise

import retrofit2.Call
import retrofit2.http.GET
import uz.isystem.currency.moduls.CurrencyData

interface CBUService {

    //   https://cbu.uz/uz/arkhiv-kursov-valyut/json/
    @GET("uz/arkhiv-kursov-valyut/json/")
    fun getLatestData(): Call<List<CurrencyData>>

}