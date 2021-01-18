package andrew.developer.demorxjavaapplication.ui.main.di

import andrew.developer.demorxjavaapplication.di.FragmentScope
import andrew.developer.demorxjavaapplication.di.ViewModelKey
import andrew.developer.demorxjavaapplication.di.ViewModelModule
import andrew.developer.demorxjavaapplication.ui.main.MainViewModel
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainViewModelModule: ViewModelModule {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(viewModel: MainViewModel): ViewModel
}