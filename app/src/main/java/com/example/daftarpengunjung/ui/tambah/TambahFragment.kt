package com.example.daftarpengunjung.ui.tambah

import android.app.DatePickerDialog
import com.example.daftarpengunjung.ui.tambah.TambahFragment
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.daftarpengunjung.R
import com.example.daftarpengunjung.databinding.FragmentTambahBinding
import com.example.daftarpengunjung.ui.home.HomeFragment
import androidx.navigation.fragment.findNavController
import java.util.*

class TambahFragment : Fragment() {

    private var _binding: FragmentTambahBinding? = null
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
        val Btn = binding.btn

        Btn.setOnClickListener {
            val nama = binding.nama.text.toString()
            val alamat = binding.alamat.text.toString()
            val tgl = Tgl.text.toString()

            // Membuat bundle untuk mengirim data ke HomeFragment
            val bundle = Bundle()
            bundle.putString("nama", nama)
            bundle.putString("tanggal", tgl)
            bundle.putString("alamat", alamat)

            // Membuat objek HomeFragment dan mengirim data melalui bundle
            val homeFragment = HomeFragment()
            homeFragment.arguments = bundle

            // Menambahkan HomeFragment ke dalam tumpukan fragment
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.tambah, homeFragment) // Gantilah R.id.container dengan ID container fragment Anda
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

            val action = TambahFragment.actionNavigationTambahToNavigationHome()
            findNavController().navigate(action)
        }

        Tgl.setOnClickListener {
            // Mendapatkan tanggal saat ini
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Membuat DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // Mengatur tanggal yang dipilih pada TextView
                    val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                    Tgl.text = Editable.Factory.getInstance().newEditable(selectedDate)
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
