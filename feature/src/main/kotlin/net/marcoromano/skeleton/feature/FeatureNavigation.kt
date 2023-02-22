package net.marcoromano.skeleton.feature

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable

public object FeatureNavigation {
  public const val route: String = "feature"

  @OptIn(ExperimentalAnimationApi::class)
  public fun navGraphBuilder(navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
      route = route,
    ) {
      FeatureScreen()
    }
  }

  public fun navigate(navController: NavController) {
    navController.navigate(route)
  }
}
