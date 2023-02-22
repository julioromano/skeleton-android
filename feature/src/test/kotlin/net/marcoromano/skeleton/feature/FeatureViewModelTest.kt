package net.marcoromano.skeleton.feature

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

internal class FeatureViewModelTest {
  @OptIn(ExperimentalCoroutinesApi::class)
  @Test
  fun `greets the person with their name`() = runTest {
    val vm = FeatureViewModel(SavedStateHandle())
    vm.state.test {
      assertEquals(FeatureState(), awaitItem())
      vm.greet("Mario")
      assertEquals(FeatureState(greeting = "Hello, Mario"), awaitItem())
    }
  }
}
