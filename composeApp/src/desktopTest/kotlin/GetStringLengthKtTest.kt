import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlin.test.Test

class GetStringLengthKtTest {
    @Test
    fun testGetStringLength() {
        val string = "abc"
        assertThat(getStringLength(string)).isEqualTo(3)
    }

}