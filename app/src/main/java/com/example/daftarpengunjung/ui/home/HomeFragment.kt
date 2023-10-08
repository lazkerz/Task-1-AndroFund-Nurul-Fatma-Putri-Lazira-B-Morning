package com.example.daftarpengunjung.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daftarpengunjung.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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

      val nama = arguments?.getString("nama")
      val alamat = arguments?.getString("alamat")
      val tanggalMasuk = arguments?.getString("tanggalMasuk")

    val textView: TextView = binding.texthome
    val textViewNama: TextView = binding.nama
    val textViewAlamat: TextView = binding.alamat
    val textViewTanggalMasuk: TextView = binding.tanggalMasuk

    textViewNama.text = "Nama: $nama"
    textViewAlamat.text = "Alamat: $alamat"
    textViewTanggalMasuk.text = "Tanggal Masuk: $tanggalMasuk"
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}