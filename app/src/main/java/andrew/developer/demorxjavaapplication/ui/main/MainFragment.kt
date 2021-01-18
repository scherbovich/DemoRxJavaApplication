package andrew.developer.demorxjavaapplication.ui.main

import andrew.developer.demorxjavaapplication.App
import andrew.developer.demorxjavaapplication.R
import andrew.developer.demorxjavaapplication.adapters.AlbumsAdapter
import andrew.developer.demorxjavaapplication.ui.main.di.MainComponent
import andrew.developer.demorxjavaapplication.utils.observe
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val adapter = AlbumsAdapter()

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainComponent
                .init((requireActivity().application as App).appComponent)
                .inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupAdapter()
        srlRefresh.setColorSchemeResources(R.color.purple_700)
        srlRefresh.setOnRefreshListener { viewModel.onRefresh() }

        observe(viewModel.loading) {
            srlRefresh.isRefreshing = it
        }

        observe(viewModel.error) {
            Snackbar.make(view, getString(R.string.error_network), Snackbar.LENGTH_SHORT)
                    .show()
        }

        observe(viewModel.data) {
            adapter.setList(it)
        }
    }

    private fun setupAdapter(){
        rv_albums.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rv_albums.adapter = adapter
    }
}