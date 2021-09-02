
package com.example.cardview

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.example.cardview.databinding.FragmentCardViewBinding

/**
 * @ClassName CardViewFragment
 * @Description TODO
 * @Author Carl
 * @Date 2021/9/2 9:25 上午
 * @Version 1.0
 */

class CardViewFragment : BaseFragment<FragmentCardViewBinding>(FragmentCardViewBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cardviewRadiusSeekbar.setOnSeekBarChangeListener(object :OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    cardview.radius = p1.toFloat()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) = Unit

                override fun onStopTrackingTouch(p0: SeekBar?) = Unit
            })
            cardviewElevationSeekbar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    cardview.elevation = p1.toFloat()
                }

                override fun onStartTrackingTouch(p0: SeekBar?) = Unit

                override fun onStopTrackingTouch(p0: SeekBar?) = Unit
            })
        }
    }

}