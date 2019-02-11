package com.phellipesilva.daggerworkshop.business

import com.phellipesilva.daggerworkshop.database.User
import com.phellipesilva.featuretwo.business.HelperClass
import javax.inject.Inject

class BusinessClassA @Inject constructor(private val helperClass: HelperClass) {
    fun generateNumberFromUser(user: User): Int = user.hashCode()
}