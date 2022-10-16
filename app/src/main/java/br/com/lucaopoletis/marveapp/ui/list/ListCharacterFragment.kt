package br.com.lucaopoletis.marveapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import br.com.lucaopoletis.marveapp.databinding.FragmentListCharacterBinding
import br.com.lucaopoletis.marveapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCharacterFragment : BaseFragment<FragmentListCharacterBinding, ListCharacterViewModel>() {

    override val viewModel: ListCharacterViewModel by viewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentListCharacterBinding = FragmentListCharacterBinding.inflate(
        inflater,
        container,
        false
    )

}