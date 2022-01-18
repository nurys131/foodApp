package kul.view;

import javafx.stage.Stage;
import kul.view.mainWindow.StartViewFactory;

public class Navigator {
    private Stage primaryStage;
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void showMainWindowView() {
        new StartViewFactory().create(primaryStage);
    }

}
