package com.example.recyclerviewkotlin.flowerList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.example.recyclerviewkotlin.data.Flower
import com.example.recyclerviewkotlin.databinding.FragmentFlowerListBinding

class FlowerListFragment : Fragment() {
    private var _binding: FragmentFlowerListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFlowerListBinding.inflate(inflater, container, false)
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

        /* Instantiates headerAdapter and flowersAdapter. Both adapters are added to concatAdapter.
        which displays the contents sequentially */
        val headerAdapter = HeaderAdapter()
        val flowersAdapter = FlowersAdapter { flower -> adapterOnClick(flower) }

        binding.recyclerView.apply {
            adapter = ConcatAdapter(headerAdapter, flowersAdapter)
        }

        flowersListViewModel.flowersLiveData.observe(viewLifecycleOwner) {
            it?.let {
                flowersAdapter.submitList(it)
                headerAdapter.updateFlowerCount(it.size)
            }
        }

        binding.fab.setOnClickListener {
            fabOnClick()
        }

    }

    /* Opens FlowerDetailActivity when RecyclerView item is clicked. */
    private fun adapterOnClick(flower: Flower) = findNavController().navigate(
            FlowerListFragmentDirections.actionToFlowerDetailFragment(flower.id))


    /* Adds flower to flowerList when FAB is clicked. */
    private fun fabOnClick() = findNavController().navigate(
            FlowerListFragmentDirections.actionToAddFlowerFragment())

}