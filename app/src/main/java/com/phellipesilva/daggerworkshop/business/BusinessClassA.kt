package com.phellipesilva.daggerworkshop.business

import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.featuretwo.business.HelperClass

class BusinessClassA(private val helperClass: HelperClass) {
    fun generateNumberFromUser(user: User): Int = user.hashCode()
}