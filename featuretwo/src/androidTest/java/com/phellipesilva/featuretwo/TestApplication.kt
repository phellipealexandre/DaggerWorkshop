package com.phellipesilva.featuretwo

import android.app.Application
import com.phellipesilva.featuretwo.di.DaggerTestFeatureTwoComponent
import com.phellipesilva.featuretwo.di.FeatureTwoComponent
import com.phellipesilva.featuretwo.di.FeatureTwoComponentProvider
import com.phellipesilva.featuretwo.view.FeatureTwoActivity

class TestApplication: Application(), FeatureTwoComponentProvider {

    override fun providesFeatureTwoComponent(featureTwoActivity: FeatureTwoActivity): FeatureTwoComponent {
        return DaggerTestFeatureTwoComponent
            .builder()
            .featureTwoActivity(featureTwoActivity)
            .context(this)
            .build()
    }
}