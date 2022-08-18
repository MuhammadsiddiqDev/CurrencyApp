package uz.isystem.currency.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.isystem.currency.adapter.MyAdapter3
import uz.isystem.currency.databinding.FragmentDifferenceBinding
import uz.isystem.currency.moduls.CurrencyData
import uz.isystem.currency.network.servise.CBUService
import uz.isystem.currency.network.servise.connection.NetworkConnection

class DifferenceFragment : Fragment() {

    //    lateinit var layoutManager: LinearLayoutManager
    lateinit var staggeredGridLayoutManager: StaggeredGridLayoutManager
    lateinit var adapter: MyAdapter3

    private var _binding: FragmentDifferenceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDifferenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        layoutManager = LinearLayoutManager(binding.groupListPage2.context)
        staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter = MyAdapter3()

        val connection = NetworkConnection.getRetrofit()
        val service: CBUService = connection.create(CBUService::class.java)

        val result = service.getLatestData()
        result.enqueue(object : Callback<List<CurrencyData>> {
            override fun onResponse(
                call: Call<List<CurrencyData>>,
                response: Response<List<CurrencyData>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d(ContentValues.TAG, "OnResponse: $data")
                    adapter.data = data as ArrayList<CurrencyData>
                }
            }

            override fun onFailure(call: Call<List<CurrencyData>>, t: Throwable) {
                Log.d(ContentValues.TAG, "onFailure: ${t}")
            }

        })
        binding.groupListPage2.adapter = adapter
        binding.groupListPage2.layoutManager = staggeredGridLayoutManager


    }
}