package com.hafidrf.awesomeappassessment.util

import com.hafidrf.awesomeappassessment.core.model.Image

interface OnImageClick {
    fun goToDetail(image: Image)
}