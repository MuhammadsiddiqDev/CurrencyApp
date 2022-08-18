package uz.isystem.currency.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.isystem.currency.databinding.FragmentExchangeBinding

class ExchangeFragment : Fragment() {
    private var _binding: FragmentExchangeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExchangeBinding.inflate(inflater, container, false)
        return binding.root
    }
}