/*
 * Copyright 2018 Google LLC.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tivi.settings

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class TiviPreferences @Inject constructor(
    @Named("app") private val sharedPreferences: SharedPreferences
) {
    companion object {
        const val KEY_UI_THEME = "pref_ui_theme"
    }

    enum class UiTheme(val value: String) {
        LIGHT("light"),
        DARK("dark"),
        SYSTEM("system")
    }

    val uiThemePreference: UiTheme
        get() = uiThemeFromPref(sharedPreferences.getString(KEY_UI_THEME, null))

    private fun uiThemeFromPref(value: String?): UiTheme {
        return UiTheme.values().firstOrNull { it.value == value } ?: UiTheme.SYSTEM
    }
}
