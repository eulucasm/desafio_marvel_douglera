package br.com.lucaopoletis.marveapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.lucaopoletis.marveapp.databinding.FragmentSearchCharacterBinding
import br.com.lucaopoletis.marveapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchCharacterFragment :
    BaseFragment<FragmentSearchCharacterBinding, SearchCharacterViewModel>() {

    override val viewModel: SearchCharacterViewModel by viewModels()


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentSearchCharacterBinding = FragmentSearchCharacterBinding.inflate(
        inflater,
        container,
        false
    )

}