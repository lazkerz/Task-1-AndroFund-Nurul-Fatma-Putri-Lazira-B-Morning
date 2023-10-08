package com.example.daftarpengunjung.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daftarpengunjung.R
import com.example.daftarpengunjung.databinding.FragmentHomeBinding
import com.example.daftarpengunjung.ui.viewmodels.DataViewModel

class HomeFragment : Fragment() {

  private lateinit var viewModel: DataViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
  }

private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textViewNama = root.findViewById<TextView>(R.id.nama)
    val textViewAlamat = root.findViewById<TextView>(R.id.alamat)
    val textViewTgl = root.findViewById<TextView>(R.id.tgl)

    textViewNama.text = "Nama: ${viewModel.nama}"
    textViewAlamat.text = "Alamat: ${viewModel.alamat}"
    textViewTgl.text = "Tanggal Masuk: ${viewModel.tgl}"

    val textView: TextView = binding.texthome
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}