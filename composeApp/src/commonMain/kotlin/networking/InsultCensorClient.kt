package networking

import NetworkError
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import util.Result

class InsultCensorClient(
    private val httpClient: HttpClient
) {

    suspend fun censorWords(uncensored: String): Result<String, NetworkError> {
        val response = try {
            httpClient.get(
                urlString = "https://www.purgomalum.com/service/json"
            ) {
                parameter("text", uncensored)
            }
        } catch (e: UnresolvedAddressException) {
            return Result.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return Result.Error(NetworkError.SERIALIZATION)
        }

        return when (response.status.value) {
            in 200..299 -> {
                val censoredText = response.body<CensoredText>()
                Result.Success(censoredText.result)
            }

            401 -> {
                return Result.Error(NetworkError.UNAUTHORIZED)
            }

            408 -> {
                return Result.Error(NetworkError.REQUEST_TIMEOUT)
            }

            409 -> {
                return Result.Error(NetworkError.CONFLICT)
            }

            413 -> {
                return Result.Error(NetworkError.PAYLOAD_TOO_LARGE)
            }

            in 500..599 -> {
                return Result.Error(NetworkError.SERVER_ERROR)
            }

            else -> {
                return Result.Error(NetworkError.UNKNOWN)
            }
        }
    }
}