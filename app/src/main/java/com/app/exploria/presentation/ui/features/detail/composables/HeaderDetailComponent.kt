import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.app.exploria.presentation.ui.features.common.CustomButtonNavigation

@Composable
fun Toolbar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick =
        { navController.popBackStack() })
        {
            CustomButtonNavigation(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
            )
        }

        Row {
            IconButton(onClick = { /* TODO: Handle favorite action */ }) {
                CustomButtonNavigation(
                    icon = Icons.Default.FavoriteBorder,
                )
            }

            IconButton(onClick = { /* TODO: Handle add action */ }) {
                CustomButtonNavigation(
                    icon = Icons.Default.Share,
                )
            }
        }
    }
}
