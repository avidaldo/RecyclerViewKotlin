package com.example.recyclerviewkotlin.addFlower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewkotlin.databinding.FragmentAddFlowerBinding
import com.example.recyclerviewkotlin.flowerList.FlowersListViewModel
import com.example.recyclerviewkotlin.flowerList.FlowersListViewModelFactory

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


    private val flowersListViewModel by activityViewModels<FlowersListViewModel> {
        FlowersListViewModelFactory(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.doneButton.setOnClickListener {
            if (binding.addFlowerName.text!!.isNotBlank() && binding.addFlowerDescription.text!!.isNotBlank()) {
                flowersListViewModel.addFlower(
                    binding.addFlowerName.text.toString(),
                    null,
                    binding.addFlowerDescription.text.toString()
                )
            }
            findNavController().navigate(AddFlowerFragmentDirections.actionToFlowerListFragment())
        }


    }

}