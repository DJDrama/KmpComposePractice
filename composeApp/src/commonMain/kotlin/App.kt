import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kmpcomposepractice.composeapp.generated.resources.Res
import kmpcomposepractice.composeapp.generated.resources.hello_world
import kmpcomposepractice.composeapp.generated.resources.ic_android_black_24dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // put image into composeResources >> drawable and "rebuild"
            Image(painterResource(Res.drawable.ic_android_black_24dp), null)
            Text(
                text = stringResource(Res.string.hello_world)
            )
        }
    }
}