package com.oslaman.adhan.ui.prayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oslaman.adhan.repository.LocationsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
/*class PrayersViewModel @Inject constructor(
    private val locationsRepository: LocationsRepository
) : ViewModel() {

    var uiState by mutableStateOf(PrayersUiState())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            locationsRepository.refreshPrayers()
            locationsRepository.prayers.collect { list ->
                uiState = if (list.isNullOrEmpty()) {
                    uiState.copy()
                } else {
                    uiState.copy(
                        list = list,
                    )
                }
            }
        }
    }
}*/