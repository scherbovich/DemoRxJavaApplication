package andrew.developer.demorxjavaapplication.ui.main.di

import andrew.developer.demorxjavaapplication.di.AppComponent
import andrew.developer.demorxjavaapplication.di.FragmentScope
import andrew.developer.demorxjavaapplication.ui.main.MainFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [AppComponent::class],
    modules = [MainViewModelModule::class, MainModule::class]
)
interface MainComponent {
    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        fun appComponent(appComponent: AppComponent): Builder

        fun build(): MainComponent
    }

    companion object {
        fun init(appComponent: AppComponent): MainComponent{
            return DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
        }
    }
}