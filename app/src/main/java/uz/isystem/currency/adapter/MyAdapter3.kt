package uz.isystem.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.isystem.currency.databinding.ItemSquareBinding
import uz.isystem.currency.moduls.CurrencyData

class MyAdapter3 : RecyclerView.Adapter<MyAdapter3.ViewHolder>() {

    var data = ArrayList<CurrencyData>()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(field.size - value.size, value.size)
        }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemSquareBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(currencyData: CurrencyData) {
            val a: Int = 0
            if (currencyData.Diff > a.toString()) {
                binding.itemTitleEng.text = "${currencyData.CcyNm_UZ}"
                binding.itemTitleUzb.text = " So'm ${currencyData.Rate}  \uD83C\uDDFA\uD83C\uDDFF"
                binding.itemTitleDifference.text = " Oshdi \uD83D\uDCC9 ${currencyData.Diff}"
                binding.itemTitleDate.text = " ${currencyData.Ccy}"
            } else {
                binding.itemTitleEng.text = "${currencyData.CcyNm_UZ}"
                binding.itemTitleUzb.text = " So'm ${currencyData.Rate}  \uD83C\uDDFA\uD83C\uDDFF"
                binding.itemTitleDifference.text = " Tushdi \uD83D\uDCC8${currencyData.Diff}"
                binding.itemTitleDate.text = " ${currencyData.Ccy}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemSquareBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.binData(data[position])

    override fun getItemCount(): Int = data.size
}
