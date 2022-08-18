package uz.isystem.currency.fragment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.isystem.currency.adapter.MyAdapter2
import uz.isystem.currency.databinding.FragmentShortBinding
import uz.isystem.currency.moduls.CurrencyData
import uz.isystem.currency.network.servise.CBUService
import uz.isystem.currency.network.servise.connection.NetworkConnection

class shortFragment : Fragment() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyAdapter2

    private var _binding: FragmentShortBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentShortBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(binding.groupList.context)
        adapter = MyAdapter2()

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
                    Log.d(TAG, "OnResponse: $data")
                    adapter.data = data as ArrayList<CurrencyData>
                }
            }

            override fun onFailure(call: Call<List<CurrencyData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t}")
            }

        })
        binding.groupList.adapter = adapter
        binding.groupList.layoutManager = layoutManager
    }
}