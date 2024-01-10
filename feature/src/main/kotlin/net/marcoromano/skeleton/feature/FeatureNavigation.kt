package net.marcoromano.skeleton.feature

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

public object FeatureNavigation {
  public const val ROUTE: String = "feature"

  public fun navGraphBuilder(navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
      route = ROUTE,
    ) {
      FeatureScreen()
    }
  }

  public fun navigate(navController: NavController) {
    navController.navigate(ROUTE)
  }
}
