package uz.isystem.currency.moduls

data class CurrencyData(

//    val id:Int,
    val Ccy: String,
//    val CcyNm_RU:String,
    val CcyNm_UZ: String,
//    val CcyNm_UZC:String,
    val CcyNm_EN: String,
    val Rate: String,
    val Diff: String,
//    val Data:String

) : BaseData() {
    override fun getType(): Int = TYPE_APPS
}
