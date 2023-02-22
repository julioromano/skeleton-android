package net.marcoromano.skeleton.feature

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

internal class FeatureScreenUnitTest {

  @get:Rule
  internal val rule = createComposeRule()

  @Test
  internal fun greetingIsDisplayed() {
    rule.setContent {
      FeatureScreen(
        state = FeatureState(greeting = "SomeGreeting"),
        greet = {},
      )
    }

    rule.onNodeWithContentDescription("Greeting")
      .assertTextEquals("SomeGreeting")
  }

  @Test
  internal fun buttonSendsTextFieldContentToGreetHandler() {
    var text = ""
    rule.setContent {
      FeatureScreen(
        state = FeatureState(),
        greet = { text = it },
      )
    }

    rule.onNodeWithContentDescription("Insert name")
      .performTextInput("Mario")
    rule.onNodeWithContentDescription("Greet button")
      .performClick()
    assertEquals("Mario", text)
  }
}
