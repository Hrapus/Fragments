package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragments.databinding.Fragment1Binding


class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bSendToFrag2.setOnClickListener{
            dataModel.messageForFrag2.value = "Hello from fragment 1"
        }

        binding.bSendToActivity.setOnClickListener{
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }

        dataModel.messageForFrag1.observe(activity as LifecycleOwner) {
            binding.tvMess1.text = it
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}