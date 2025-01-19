package com.abaza_vg.binlist.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abaza_vg.binlist.domain.CardInfo
import com.abaza_vg.binlist.domain.GetCardInfoUseCase
import com.abaza_vg.binlist.domain.GetHistoryUseCase
import com.abaza_vg.binlist.domain.SaveCardInfoToHistoryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCardInfoUseCase: GetCardInfoUseCase,
    private val saveCardInfoToHistoryUseCase: SaveCardInfoToHistoryUseCase,
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo: LiveData<CardInfo> = _cardInfo

    private val _cardInfoHistory = getHistoryUseCase.getHistory()
    val cardInfoHistory: LiveData<List<CardInfo>> = _cardInfoHistory

    private val _requestError = MutableLiveData<Exception>()
    val requestError: LiveData<Exception> = _requestError

    var bin by mutableStateOf("")
        private set

    fun updateBin(input: String) {
        bin = input
    }

    fun getCardInfo(bin: String) {
        viewModelScope.launch {
            try {
                _cardInfo.postValue(getCardInfoUseCase.getCardInfo(bin))
            } catch (e: Exception) {
                _requestError.postValue(e)
            }
        }
    }

    fun saveCardInfoToHistory() {
        viewModelScope.launch {
            cardInfo.value?.let {
                saveCardInfoToHistoryUseCase.saveCardInfoToHistory(it)
            }
        }
    }
}