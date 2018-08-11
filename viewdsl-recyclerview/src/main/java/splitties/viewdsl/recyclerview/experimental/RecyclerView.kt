/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package splitties.viewdsl.recyclerview.experimental

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.StyleRes
import android.support.v7.widget.RecyclerView
import android.view.View
import splitties.viewdsl.core.NO_THEME
import splitties.viewdsl.core.Ui
import splitties.viewdsl.core.v
import splitties.viewdsl.recyclerview.R
import splitties.views.inflate

@Deprecated("Remove explicit RecyclerView and use wrapInRecyclerView(…) instead.")
fun RecyclerView.setSingleView(view: View) {
    val contentAdapter = SingleViewAdapter(view, vertical = true)
    layoutManager = contentAdapter.layoutManager
    adapter = contentAdapter
}

inline fun Context.recyclerView(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: RecyclerView.() -> Unit = {}
) = v({ it.inflate(R.layout.recyclerview_with_scrollbars) }, id, theme, initView)

inline fun View.recyclerView(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: RecyclerView.() -> Unit = {}
) = context.recyclerView(id, theme, initView)

inline fun Ui.recyclerView(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: RecyclerView.() -> Unit = {}
) = ctx.recyclerView(id, theme, initView)
