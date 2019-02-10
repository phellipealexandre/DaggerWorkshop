package com.phellipesilva.daggerworkshop.di

import com.phellipesilva.daggerworkshop.business.BusinessClassA
import com.phellipesilva.daggerworkshop.interactor.MainInteractor
import com.phellipesilva.daggerworkshop.navigation.Navigator
import com.phellipesilva.featuretwo.business.BusinessClassB
import dagger.Component

@Component(modules = [MainModule::class])
interface MainComponent {
    fun getMainInteractor(): MainInteractor
    fun getNavigator(): Navigator
    fun getBusinessClassA(): BusinessClassA
    fun getBusinessClassB(): BusinessClassB
}
