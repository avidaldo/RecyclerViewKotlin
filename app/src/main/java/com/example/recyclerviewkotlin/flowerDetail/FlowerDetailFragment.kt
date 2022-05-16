package com.example.recyclerviewkotlin.flowerDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recyclerviewkotlin.R
import com.example.recyclerviewkotlin.data.IMAGE_NO_AVALIABLE_RESOURCE
import com.example.recyclerviewkotlin.databinding.FragmentFlowerDetailBinding
import com.example.recyclerviewkotlin.flowerList.FlowersListViewModel
import com.example.recyclerviewkotlin.flowerList.FlowersListViewModelFactory
import java.lang.RuntimeException


class FlowerDetailFragment : Fragment() {

    private var _binding: FragmentFlowerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlowerDetailBinding.inflate(inflater, container, false)
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

        flowersListViewModel.getFlowerFromId(
            FlowerDetailFragmentArgs.fromBundle(requireArguments()).flowerId
        )?.let { flower ->
            binding.flowerDetailName.text = flower.name
            binding.flowerDetailImage.setImageResource(flower.image ?: IMAGE_NO_AVALIABLE_RESOURCE)
            binding.flowerDetailDescription.text = flower.description

            binding.removeButton.setOnClickListener {
                flowersListViewModel.removeFlower(flower)
                findNavController().navigate(FlowerDetailFragmentDirections.actionToFlowerListFragment())
            }

        }  // TODO: ?:


    }

}