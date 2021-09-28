package com.hafidrf.awesomeappassessment.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.hafidrf.awesomeappassessment.core.repository.ImageRepository

class MainViewModel(imageRepository: ImageRepository): ViewModel() {

    val imageList = imageRepository.getImageList().cachedIn(viewModelScope)
}
