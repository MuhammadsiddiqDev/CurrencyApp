package uz.isystem.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.isystem.currency.databinding.ItemLongBinding
import uz.isystem.currency.moduls.CurrencyData

class MyAdapter2 : RecyclerView.Adapter<MyAdapter2.ViewHolder>() {

    var data = ArrayList<CurrencyData>()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(field.size - value.size, value.size)
        }

    fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemLongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(currencyData: CurrencyData) {
            var a: Int = 0

            if (currencyData.Diff > a.toString()) {
                binding.itemTitleEng.text = "${currencyData.Ccy} \n 1.00"
                binding.itemTitleDifference.text = "Difference\n\uD83D\uDCC9${currencyData.Diff} "
                binding.itemTitleUzb.text = "So'm \n${currencyData.Rate}"
            } else {
                binding.itemTitleEng.text = "${currencyData.Ccy} \n 1.00"
                binding.itemTitleDifference.text = "Difference\n\uD83D\uDCC8${currencyData.Diff} "
                binding.itemTitleUzb.text = "So'm \n${currencyData.Rate}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemLongBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.binData(data[position])

    override fun getItemCount(): Int = data.size
}
