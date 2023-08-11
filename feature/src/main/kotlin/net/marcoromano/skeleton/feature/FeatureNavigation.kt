package net.marcoromano.skeleton.feature

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

public object FeatureNavigation {
  public const val route: String = "feature"

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
