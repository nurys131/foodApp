package kul;

import javafx.application.Application;
import javafx.stage.Stage;
import kul.view.Navigator;

public class FxApplication extends Application {
    private final Navigator navigator;

    public FxApplication() {
        navigator = new Navigator();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        StartViewFactory startViewFactory = new StartViewFactory();
//        StartViewModel viewModel = new StartViewModel();
//
//        StartView startView = startViewFactory.create(viewModel, primaryStage);
        navigator.setPrimaryStage(primaryStage);
        navigator.showMainWindowView();
    }


}
