package net.marcoromano.skeleton.feature

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun FeatureScreen() {
  val vm = hiltViewModel<FeatureViewModel>()
  val state by vm.state.collectAsStateWithLifecycle()
  FeatureScreen(
    state = state,
    greet = vm::greet,
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FeatureScreen(state: FeatureState, greet: (name: String) -> Unit) {
  Scaffold(
    topBar = {
      TopAppBar(title = { Text(text = stringResource(R.string.greeter)) })
    },
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .padding(paddingValues)
        .fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      var text by rememberSaveable { mutableStateOf("") }
      Text(text = stringResource(R.string.insert_name))
      TextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.semantics {
          contentDescription = "Insert name"
        },
      )
      Button(
        onClick = { greet(text) },
        modifier = Modifier.semantics {
          contentDescription = "Greet button"
        },
      ) {
        Text(text = stringResource(R.string.greet))
      }
      Text(
        text = state.greeting,
        modifier = Modifier.semantics {
          contentDescription = "Greeting"
        },
      )
    }
  }
}

@Preview(name = "Day mode")
@Preview(name = "Night mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() {
  FeatureScreen(
    state = FeatureState(),
    greet = {},
  )
}
