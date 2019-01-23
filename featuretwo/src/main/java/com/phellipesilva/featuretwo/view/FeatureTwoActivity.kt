package com.phellipesilva.featuretwo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phellipesilva.featuretwo.R
import com.phellipesilva.featuretwo.presenter.FeatureTwoPresenter
import kotlinx.android.synthetic.main.activity_feature_two.*

class FeatureTwoActivity : AppCompatActivity() {

    private lateinit var featureTwoPresenter: FeatureTwoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_two)

        featureTwoPresenter = FeatureTwoPresenter(this)

        val username = intent.getStringExtra("user")
        val id = intent.getIntExtra("id", 0)
        textView.text = "$username with id $id"
    }
}
