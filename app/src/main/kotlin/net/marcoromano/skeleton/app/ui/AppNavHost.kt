package net.marcoromano.skeleton.app.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import net.marcoromano.skeleton.feature.FeatureNavigation

@Composable
fun AppNavHost() {
  val navController = rememberNavController()
  NavHost(
    navController = navController,
    startDestination = FeatureNavigation.ROUTE,
    modifier = Modifier.fillMaxSize(),
    route = "mainGraph",
  ) {
    FeatureNavigation.navGraphBuilder(this)
  }
}
