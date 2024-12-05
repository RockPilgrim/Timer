package my.rockpilgrim.timerforall;

import android.app.Application;

import my.rockpilgrim.timerforall.model.dagger.AppComponent;
import my.rockpilgrim.timerforall.model.dagger.AppModule;
import my.rockpilgrim.timerforall.model.dagger.DaggerAppComponent;

public class App extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = initComponent();
    }

    private AppComponent initComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }

}
