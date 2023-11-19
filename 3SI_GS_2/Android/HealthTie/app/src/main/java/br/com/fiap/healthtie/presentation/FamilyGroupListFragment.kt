package br.com.fiap.healthtie.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import br.com.fiap.healthtie.databinding.FragmentFamilyGroupListBinding
import kotlinx.coroutines.launch

class FamilyGroupListFragment : Fragment() {
    private lateinit var binding: FragmentFamilyGroupListBinding
    private val viewModel: FamilyGroupListViewModel by viewModels()

    private val familyGroupAdapter by lazy {
        FamilyGroupAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFamilyGroupListBinding.inflate(
            inflater,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        getDataFromDataBase()
        setObservers()
    }

    private fun getDataFromDataBase() {
        lifecycleScope.launch {
            viewModel.selectGroupFamily()
        }
    }

    private fun setupViews() {
        binding.familyGroupListRecycler.setHasFixedSize(true)
        binding.familyGroupListRecycler.adapter = familyGroupAdapter
    }

    private fun setObservers() {
        viewModel.groupFamily.observe(
            viewLifecycleOwner,
            Observer {
                familyGroupAdapter.setData(it)
            }
        )
    }
}