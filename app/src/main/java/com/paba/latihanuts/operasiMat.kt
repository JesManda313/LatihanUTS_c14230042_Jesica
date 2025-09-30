package com.paba.latihanuts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [operasiMat.newInstance] factory method to
 * create an instance of this fragment.
 */
class operasiMat : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_operasi_mat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val buttonMultiply: Button = view.findViewById(R.id.btnKali)
        val buttonDivide: Button = view.findViewById(R.id.btnBagi)

        buttonMultiply.setOnClickListener {
            mainActivity.performOperation("*")
        }

        buttonDivide.setOnClickListener {
            mainActivity.performOperation("/")
        }
    }

        private fun hitungDanTampilkan(operator: String, tvOperasi: TextView) {
            val angka1 = (activity?.findViewById<EditText>(R.id.editAngka1)?.text?.toString()?.toIntOrNull()) ?: 0
            val angka2 = (activity?.findViewById<EditText>(R.id.editAngka2)?.text?.toString()?.toIntOrNull()) ?: 0

            val hasil = when (operator) {
                "*" -> angka1 * angka2
                "/" -> if (angka2 != 0) angka1 / angka2 else 0
                else -> 0
            }

            tvOperasi.text = "Operasi Matematika\n$angka1 $operator $angka2 = $hasil"
            activity?.findViewById<TextView>(R.id.tvHasil)?.text = "HASIL = $hasil"
        }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment operasiMat.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            operasiMat().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}