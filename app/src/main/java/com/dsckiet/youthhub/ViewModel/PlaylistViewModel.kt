package com.dsckiet.youthhub.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsckiet.youthhub.model.Item
import com.dsckiet.youthhub.model.Playlist
import com.dsckiet.youthhub.model.PlaylistDataClass
import com.dsckiet.youthhub.model.Snippet
import com.example.youthhub.Repo.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class PlaylistViewModel (private val repository: Repository): ViewModel() {

    var PlaylistshowProgress: LiveData<Boolean>
    var playlist: MutableLiveData<Response<Playlist>>

    init {
        this.PlaylistshowProgress=repository.cityshowprogress
        this.playlist= MutableLiveData()
    }

    fun getPlaylist(part:String,id:String){
        viewModelScope.launch {
            val SearchRes=repository.getPlaylistItem(part,id)
            playlist.value=SearchRes
            Log.e("Searched",SearchRes.toString())
        }
    }
}