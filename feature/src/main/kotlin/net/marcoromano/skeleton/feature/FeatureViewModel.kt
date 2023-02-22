package net.marcoromano.skeleton.feature

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class FeatureViewModel @Inject constructor(
  private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

  private val _state = MutableStateFlow(FeatureState())
  val state = _state.asStateFlow()

  fun greet(name: String) {
    _state.update {
      it.copy(
        greeting = "Hello, $name",
      )
    }
  }
}
