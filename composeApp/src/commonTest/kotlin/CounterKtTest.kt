import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class CounterKtTest {

    @Test
    fun testCountingUp() = runComposeUiTest {
        setContent {
            Counter()
        }

        onNodeWithText("0").assertExists()
        onNodeWithText("1").assertDoesNotExist()

        onNodeWithText("Increment").performClick()
        onNodeWithText("0").assertDoesNotExist()
        onNodeWithText("1").assertExists()
    }
}