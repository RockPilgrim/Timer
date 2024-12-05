package my.rockpilgrim.timerforall.model.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import my.rockpilgrim.timerforall.model.Model;
import my.rockpilgrim.timerforall.presenter.timer.TimerHandler;

@Module
public class AppModule {
    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Model provideModel() {
        return new Model();
    }
    @Provides
    @Singleton
    TimerHandler provideTimerHandler(Model model) {
        return new TimerHandler(model);
    }
}
