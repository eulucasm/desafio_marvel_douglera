package br.com.lucaopoletis.marveapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucaopoletis.marveapp.data.model.comic.ComicModelResponse
import br.com.lucaopoletis.marveapp.repository.MarvelRepository
import br.com.lucaopoletis.marveapp.ui.state.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailsCharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
) : ViewModel() {

    private val _details =
        MutableStateFlow<ResourceState<ComicModelResponse>>(ResourceState.Loading())
    val details: StateFlow<ResourceState<ComicModelResponse>> = _details

    fun fetch(characterId: Int) = viewModelScope.launch {
        safeFetch(characterId)
    }

    private suspend fun safeFetch(characterId: Int) {
        _details.value = ResourceState.Loading()
        try {
            val response = repository.getComics(characterId)
            _details.value = handleResponse(response)
        } catch (t: Throwable) {
            when (t) {
                is IOException -> _details.value = ResourceState.Error("Erro na conexao com a internet")
                else -> _details.value = ResourceState.Error("Falha na converção")
            }
        }
    }

    private fun handleResponse(response: Response<ComicModelResponse>): ResourceState<ComicModelResponse> {
        if (response.isSuccessful) {
            response.body()?.let {
                return ResourceState.Success(it)
            }
        }
        return ResourceState.Error(response.message())
    }
}