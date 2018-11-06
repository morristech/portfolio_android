/*
 *    Copyright 2018 Maarten de Goede
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package eu.insertcode.portfolio.anim

import android.animation.Animator
import android.animation.ObjectAnimator
import android.util.Property
import android.view.View
import android.view.ViewGroup
import androidx.transition.Transition
import androidx.transition.TransitionValues


/**
 * Created by maartendegoede on 06/11/2018.
 * Copyright © 2018 insetCode.eu. All rights reserved.
 */
class ElevationTransition : Transition() {
    companion object {
        private const val ELEVATION = "ElevationTransition:elevation"

        private val PROPERTY = object : Property<View, Float>(Float::class.java, null) {

            override fun set(view: View?, value: Float) {
                view?.elevation = value
            }

            override fun get(view: View): Float {
                return view.elevation
            }
        }
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    private fun captureValues(transitionValues: TransitionValues) {
        transitionValues.values[ELEVATION] = transitionValues.view.elevation
    }

    override fun createAnimator(
            sceneRoot: ViewGroup,
            startValues: TransitionValues?,
            endValues: TransitionValues?
    ): Animator? {
        if (startValues != null && endValues != null) {
            val view = endValues.view
            val start = startValues.values[ELEVATION] as Float
            val end = endValues.values[ELEVATION] as Float

            if (start != end) {
                view.elevation = start
                return ObjectAnimator.ofFloat(view, PROPERTY, end)
            }
        }
        return null
    }
}