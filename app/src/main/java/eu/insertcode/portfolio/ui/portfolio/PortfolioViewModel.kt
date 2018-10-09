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

package eu.insertcode.portfolio.ui.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import eu.insertcode.portfolio.data.Resource
import eu.insertcode.portfolio.data.model.ProjectsList
import eu.insertcode.portfolio.repository.ProjectRepository

/**
 * Created by maartendegoede on 11/09/2018.
 * Copyright © 2018 insertCode.eu. All rights reserved.
 */
class PortfolioViewModel : ViewModel() {

    val projects: LiveData<Resource<ProjectsList, Exception>> =
            ProjectRepository.projects

    init {
        ProjectRepository.loadProjects()
    }

    fun retry() {
        ProjectRepository.loadProjects()
    }


}