package uz.isystem.currency.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.isystem.currency.databinding.FragmentDifferenceBinding
import uz.isystem.currency.databinding.ItemLongBinding
import uz.isystem.currency.moduls.BaseData
import uz.isystem.currency.moduls.CurrencyData

class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: ArrayList<CurrencyData> = ArrayList()
        set(value) {
            field.addAll(value)
            notifyItemRangeInserted(field.size - value.size, value.size)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            BaseData.TYPE_APPS -> {
                AppViewHolder(
                    ItemLongBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                BooksViewHolder(
                    FragmentDifferenceBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].getType()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BaseData.TYPE_APPS -> {
                val appsHolder = holder as AppViewHolder
                appsHolder.binData(data[position])
            }
            BaseData.TYPE_BOOKS -> {
                val booksHolder = holder as BooksViewHolder
                booksHolder.binData(data[position])
            }
        }
    }

    override fun getItemCount(): Int = data.size

    inner class BooksViewHolder(val binding: FragmentDifferenceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binData(booksData: CurrencyData) {

        }
    }

    inner class AppViewHolder(val binding: ItemLongBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binData(appData: CurrencyData) {


        }
    }

}