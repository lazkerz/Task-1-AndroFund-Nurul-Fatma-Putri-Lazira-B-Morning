package com.example.daftarpengunjung.ui.tambah

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daftarpengunjung.databinding.FragmentTambahBinding
import java.util.*

class TambahFragment : Fragment() {

private var _binding: FragmentTambahBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentTambahBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.txttambah
      val Tgl = binding.tgl
      Tgl.setOnClickListener {
          // Mendapatkan tanggal saat ini
          val calendar = Calendar.getInstance()
          val year = calendar.get(Calendar.YEAR)
          val month = calendar.get(Calendar.MONTH)
          val day = calendar.get(Calendar.DAY_OF_MONTH)

          // Membuat DatePickerDialog
          val datePickerDialog = DatePickerDialog(
              requireContext(),
              DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                  // Mengatur tanggal yang dipilih pada TextView
                  val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                  textView.text = "Tanggal yang dipilih: $selectedDate"
              },
              year, month, day
          )

          // Menampilkan DatePickerDialog
          datePickerDialog.show()
      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}