import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class GetInitialsKtTest {


    @Test
    fun testGetInitials() {
        val fullName = "Dongjun Lee"

        assertThat(actual = getInitials(fullName = fullName)).isEqualTo(other = "DL")
    }
}