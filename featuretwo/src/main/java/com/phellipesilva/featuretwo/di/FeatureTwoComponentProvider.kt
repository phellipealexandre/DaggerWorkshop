package com.phellipesilva.featuretwo.di

import com.phellipesilva.featuretwo.view.FeatureTwoActivity

interface FeatureTwoComponentProvider {
    fun providesFeatureTwoComponent(featureTwoActivity: FeatureTwoActivity): FeatureTwoComponent
}