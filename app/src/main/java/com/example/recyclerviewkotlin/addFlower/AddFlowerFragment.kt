package com.example.recyclerviewkotlin.addFlower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerviewkotlin.databinding.FragmentAddFlowerBinding

class AddFlowerFragment : Fragment() {
    private var _binding: FragmentAddFlowerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddFlowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /***********************************************************/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doneButton.setOnClickListener {
            if (binding.addFlowerName.text.isNullOrEmpty() || binding.addFlowerDescription.text.isNullOrEmpty()) {
                // Error
            }
            else {
                // Devolver datos para añadir flor

            }
        }


    }

}