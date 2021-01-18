package andrew.developer.demorxjavaapplication.api

import andrew.developer.demorxjavaapplication.data.entity.AlbumsItem
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("/albums")
    fun getAlbums(): Single<ArrayList<AlbumsItem>>

    @GET("/albums")
    suspend fun getSortedAlbums(@Query("userId") userId: Int): ArrayList<AlbumsItem>

    @GET("/albums/{id}")
    suspend fun getAlbum(@Path(value = "id") albumId: Int): AlbumsItem

    @POST("/albums")
    suspend fun uploadAlbum(@Body album: AlbumsItem): Response<AlbumsItem>
}