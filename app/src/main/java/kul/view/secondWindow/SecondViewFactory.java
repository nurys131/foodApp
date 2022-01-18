package kul.view.secondWindow;

import javafx.stage.Stage;
import kul.view.mainWindow.StartView;
import kul.view.mainWindow.StartViewModel;

public class SecondViewFactory {
    public SecondView create(SecondViewModel viewModel, Stage stage) {
        return new SecondView(viewModel, stage);
    }

    public SecondView create(Stage primaryStage) {
        SecondViewModel viewModel = new SecondViewModel();

        return new SecondView(viewModel, primaryStage);
    }
}
