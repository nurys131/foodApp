package kul.view.mainWindow;

import javafx.stage.Stage;

public class StartViewFactory {
    public StartView create(StartViewModel viewModel, Stage stage) {
        return new StartView(viewModel, stage);
    }

    public StartView create(Stage primaryStage) {
        StartViewModel viewModel = new StartViewModel();

        return new StartView(viewModel, primaryStage);
    }
}
