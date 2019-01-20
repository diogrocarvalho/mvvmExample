package com.example.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm.databinding.FragmentTextBinding


class TextFragment : Fragment() {

    lateinit var binding: FragmentTextBinding
    lateinit var viewModel: ViewModelExample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // A mágica acontece aqui no lugar de let, usamos run e temos o mesmo viewModel
        // que a activity, enquanto a activity existir
        activity?.run {
            viewModel = ViewModelProviders.of(this).get(ViewModelExample::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_text, container, false
        )

        val view = binding.root
        binding.viewModel = viewModel
        binding.executePendingBindings()
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TextFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
