package andrew.developer.demorxjavaapplication.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> AppCompatActivity.observe(data: LiveData<T>, eventCallback: (T) -> Unit){
    data.observe(this, Observer { event ->
        event?.let {
            eventCallback(event)
        }
    })
}

fun <T> Fragment.observe(data: LiveData<T>, eventCallback: (T) -> Unit){
    data.observe(viewLifecycleOwner, Observer { event ->
        event?.let {
            eventCallback(event)
        }
    })
}