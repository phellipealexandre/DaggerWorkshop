package com.phellipesilva.featuretwo.business

class BusinessClassB(private val helperClass: HelperClass) {
    fun doNothing(number: Int): Int = number
    fun returnTrue() = true
}