/*
 *    Copyright 2019 Maarten de Goede
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

package eu.insertcode.portfolio.main.data.models

import eu.insertcode.portfolio.main.data.models.ProjectType.*

/**
 * Created by maartendegoede on 2019-09-21.
 * Copyright © 2019 Maarten de Goede. All rights reserved.
 */
enum class ProjectType(val type: String) {
    APP("app"),
    GAME("game"),
    WEB("web"),
    WATCH("watch"),
    OTHER("other")
}

fun String.toProjectType() = when (this) {
    APP.type -> APP
    GAME.type -> GAME
    WEB.type -> WEB
    WATCH.type -> WATCH
    else -> OTHER
}