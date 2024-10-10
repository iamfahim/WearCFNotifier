package com.mif.wearcfnotifierapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mif.wearcfnotifierapp.presentation.model.ItemData
import com.mif.wearcfnotifierapp.presentation.model.ItemDataRepository
import kotlinx.coroutines.launch

class ContestItemViewModel : ViewModel() {
    private val contestItemRepository : ItemDataRepository = ItemDataRepository()

    private val contestItemDataLiveData = MutableLiveData<List<ItemData>>()
    val contestItemData : LiveData<List<ItemData>> = contestItemDataLiveData

    private val _isLoading = MutableLiveData(false)
    val isLoading = _isLoading
    fun getContestItemData() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val contestItemDataList = contestItemRepository.fetchContestItemData()
            contestItemDataLiveData.postValue(contestItemDataList)
            _isLoading.postValue(false)
        }
    }
}