package com.example.mvvm

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mvvm.databinding.FragmentButtonsBinding

class ButtonsFragment : Fragment() {
    lateinit var binding: FragmentButtonsBinding

    lateinit var viewModel: ViewModelExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.run {
            viewModel = ViewModelProviders.of(this).get(ViewModelExample::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_buttons, container, false
        )

        val view = binding.root
        binding.viewModel = viewModel
        binding.executePendingBindings()

        (view.findViewById(R.id.debit_btn) as Button).setOnClickListener {
            viewModel.setPayment("Débito")
        }

        (view.findViewById(R.id.credit_btn) as Button).setOnClickListener {
            viewModel.setPayment("Crédito")
        }

        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            ButtonsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
