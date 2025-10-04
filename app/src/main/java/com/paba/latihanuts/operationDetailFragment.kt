package com.paba.latihanuts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private const val ARG_OPERATION_TEXT = "operation_text"

/**
 * A simple [Fragment] subclass.
 * Use the [operationDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class operationDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var operationText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            operationText = it.getString(ARG_OPERATION_TEXT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_operation_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textOperationDetail: TextView = view.findViewById(R.id.textOperationDetail)
        textOperationDetail.text = operationText ?: "gaada hasil"

        val btnkembali: Button = view.findViewById(R.id.btnkembali)
        btnkembali.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment operationDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(operationtext: String) =
            operationDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_OPERATION_TEXT,  operationtext)
                }
            }
    }
}