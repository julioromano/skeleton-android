package net.marcoromano.skeleton.feature

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

internal class FeatureScreenIntegrationTest {

  @get:Rule
  internal val rule = createComposeRule()

  @Test
  internal fun buttonSendsTextFieldContentToGreetHandler() {
    rule.setContent {
      FeatureScreen()
    }

    rule.onNodeWithContentDescription("Insert name")
      .performTextInput("Mario")
    rule.onNodeWithContentDescription("Greet button")
      .performClick()
    rule.onNodeWithContentDescription("Greeting")
      .assertTextEquals("Hello, Mario")
  }
}
