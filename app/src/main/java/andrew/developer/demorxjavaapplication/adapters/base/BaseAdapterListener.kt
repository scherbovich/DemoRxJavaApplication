package andrew.developer.demorxjavaapplication.adapters.base

import android.view.View

interface BaseAdapterListener<T> {
    fun onItemClick(model: T, view: View)
    fun onLongClick(model: T, view: View): Boolean
}
