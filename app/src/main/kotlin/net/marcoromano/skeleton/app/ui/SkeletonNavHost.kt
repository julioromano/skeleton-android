package net.marcoromano.skeleton.app.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import net.marcoromano.skeleton.feature.FeatureNavigation

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SkeletonNavHost() {
  val navController = rememberAnimatedNavController()
  AnimatedNavHost(
    navController = navController,
    startDestination = FeatureNavigation.route,
    modifier = Modifier.fillMaxSize(),
    route = "mainGraph",
  ) {
    FeatureNavigation.navGraphBuilder(this)
  }
}
