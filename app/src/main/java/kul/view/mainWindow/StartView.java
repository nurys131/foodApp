package kul.view.mainWindow;

import com.sun.javafx.scene.control.IntegerField;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import kul.view.secondWindow.SecondViewFactory;
import kul.view.secondWindow.SecondViewModel;

public class StartView {
    private final StartViewModel viewModel;

    public StartView(StartViewModel viewModel, Stage stage) {
        this.viewModel = viewModel;

        TextField transferNameTextField = new TextField();
        transferNameTextField.setText(viewModel.getEnteredName());
        transferNameTextField.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredName(newValue));

        TextField transferSurnameField = new TextField();
        transferSurnameField.setText(viewModel.getEnteredSurname());
        transferSurnameField.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredSurname(newValue));

        TextField transferTownField = new TextField();
        transferTownField.setText(viewModel.getEnteredTown());
        transferTownField.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredTown(newValue));
        transferTownField.disableProperty().bind(viewModel.canEnteredTown);

        TextField transferHomeNumberField = new TextField();
        transferHomeNumberField.setText(viewModel.getEnteredHomeNumber());
        transferHomeNumberField.textProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredHomeNumber(newValue));
        transferHomeNumberField.disableProperty().bind(viewModel.canEnteredHomeNumber);

        IntegerField pizzaAmountField = new IntegerField();
        pizzaAmountField.setValue(viewModel.getEnteredPizzas());
        pizzaAmountField.setMaxValue(100);
        pizzaAmountField.valueProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredPizzas(newValue));
        pizzaAmountField.disableProperty().bind(viewModel.cannotEnteredPizzaProperty);

        IntegerField burgerAmountField = new IntegerField();
        burgerAmountField.setValue(viewModel.getEnteredBurgers());
        burgerAmountField.setMaxValue(100);
        burgerAmountField.valueProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredBurgers(newValue));
        burgerAmountField.disableProperty().bind(viewModel.cannotEnteredBurgerProperty);

        IntegerField saladAmountField = new IntegerField();
        saladAmountField.setValue(viewModel.getEnteredSalads());
        saladAmountField.setMaxValue(100);
        saladAmountField.valueProperty().addListener((observable, oldValue, newValue) -> viewModel.setEnteredSalads(newValue));
        saladAmountField.disableProperty().bind(viewModel.cannotEnteredSaladProperty);

        Button buttonSubmit = new Button("Zamow");
        buttonSubmit.disableProperty().bind(viewModel.cannotSubmitProperty);
        buttonSubmit.setOnAction(e -> new SecondViewFactory().create(stage));

        ToggleGroup orderSelectedGroup = new ToggleGroup();
        ToggleGroup pizzaGroup = new ToggleGroup();
        ToggleGroup burgerGroup = new ToggleGroup();
        ToggleGroup saladGroup = new ToggleGroup();
        RadioButton radioButtonPickup = new RadioButton("Odbior osobisty");
        RadioButton radioButtonDelivery = new RadioButton("Dostawa");
        RadioButton radioButtonPizza = new RadioButton();
        RadioButton radioButtonBurger = new RadioButton();
        RadioButton radioButtonSalad = new RadioButton();
        RadioButton radioButtonPizzaOff = new RadioButton();
        RadioButton radioButtonBurgerOff = new RadioButton();
        RadioButton radioButtonSaladOff = new RadioButton();
        radioButtonPickup.setToggleGroup(orderSelectedGroup);
        radioButtonDelivery.setToggleGroup(orderSelectedGroup);
        radioButtonPizza.setToggleGroup(pizzaGroup);
        radioButtonPizzaOff.setToggleGroup(pizzaGroup);
        radioButtonBurger.setToggleGroup(burgerGroup);
        radioButtonBurgerOff.setToggleGroup(burgerGroup);
        radioButtonSalad.setToggleGroup(saladGroup);
        radioButtonSaladOff.setToggleGroup(saladGroup);

        orderSelectedGroup.selectToggle(viewModel.getOrderSelected() ? radioButtonPickup : radioButtonDelivery);
        orderSelectedGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setOrderSelected(newValue == radioButtonDelivery);
        });

        pizzaGroup.selectToggle(viewModel.getPizzaSelected() ? radioButtonPizza : radioButtonPizzaOff);
        pizzaGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setPizzaSelected(newValue == radioButtonPizza);
        });

        burgerGroup.selectToggle(viewModel.getBurgerSelected()? radioButtonBurger : radioButtonBurgerOff);
        burgerGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setBurgerSelected(newValue == radioButtonBurger);
        });
        saladGroup.selectToggle(viewModel.getSaladSelected() ? radioButtonSalad : radioButtonSaladOff);
        saladGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            viewModel.setSaladSelected(newValue == radioButtonSalad);
        });


        // Binding z danymi z ViewModelu


        // Layout i ustawienie
        GridPane formLayout = new GridPane();
        HBox paymentVBox = new HBox(
                radioButtonPickup,
                radioButtonDelivery
        );

        HBox pizzaHBox = new HBox(
                radioButtonPizza,
                radioButtonPizzaOff,
                pizzaAmountField
        );

        HBox burgerHBox = new HBox(
                radioButtonBurger,
                radioButtonBurgerOff,
                burgerAmountField
        );

        HBox saladHBox = new HBox(
                radioButtonSalad,
                radioButtonSaladOff,
                saladAmountField
        );
        paymentVBox.setSpacing(5);
        pizzaHBox.setSpacing(5);
        burgerHBox.setSpacing(5);
        saladHBox.setSpacing(5);

        formLayout.addRow(formLayout.getRowCount(), new Label("Odbior:"), paymentVBox);
        formLayout.addRow(formLayout.getRowCount(), new Label("Imie:"), transferNameTextField);
        formLayout.addRow(formLayout.getRowCount(), new Label("Nazwisko:"), transferSurnameField);
        formLayout.addRow(formLayout.getRowCount(), new Label("Miejscowosc:"), transferTownField);
        formLayout.addRow(formLayout.getRowCount(), new Label("Numer domu:"), transferHomeNumberField);
        formLayout.addRow(formLayout.getRowCount(), new Text("Wybierz jedzenie:"), new Text("Tak/Nie Ilosc:"));
        formLayout.addRow(formLayout.getRowCount(), new Label("Pizza:"), pizzaHBox);
        formLayout.addRow(formLayout.getRowCount(), new Label("Burger:"), burgerHBox);
        formLayout.addRow(formLayout.getRowCount(), new Label("Salatka:"), saladHBox);
        formLayout.addRow(formLayout.getRowCount(), buttonSubmit);

        formLayout.setHgap(10);
        formLayout.setVgap(3);


        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHalignment(HPos.RIGHT);
        formLayout.getColumnConstraints().addAll(leftColumn);
        GridPane.setHgrow(transferNameTextField, Priority.ALWAYS);
        GridPane.setHgrow(transferSurnameField, Priority.ALWAYS);
        GridPane.setHgrow(transferTownField, Priority.ALWAYS);
        GridPane.setHgrow(transferHomeNumberField, Priority.ALWAYS);
        GridPane.setHgrow(pizzaAmountField, Priority.ALWAYS);
        // Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(1);
        layout.getChildren().addAll(formLayout);

        stage.setScene(new Scene(layout));
        stage.show();
    }
}
