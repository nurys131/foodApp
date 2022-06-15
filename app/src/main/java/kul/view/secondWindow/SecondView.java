package kul.view.secondWindow;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class SecondView {
    private final SecondViewModel viewModel;

    public SecondView(SecondViewModel viewModel, Stage stage) {
        this.viewModel = viewModel;

        TextField transferNameTextField = new TextField();
        TextField transferSurnameField = new TextField();



        // Binding z danymi z ViewModelu


        // Layout i ustawienie
        // new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date())
        GridPane formLayout = new GridPane();
        String format = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new Date());
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(30);
        formLayout.addRow(formLayout.getRowCount(), new Text("Twoje zamowienie zostalo zaakceptowane!"));
        formLayout.addRow(formLayout.getRowCount(), new Text("Szacowany czas przygotowania zamowienia: " + LocalDate.now() + " " + LocalTime.now().plusMinutes(30).format(DateTimeFormatter.ofPattern("HH:mm"))));

        formLayout.setHgap(10);
        formLayout.setVgap(3);


        ColumnConstraints leftColumn = new ColumnConstraints();
        leftColumn.setHalignment(HPos.RIGHT);
        formLayout.getColumnConstraints().addAll(leftColumn);
        GridPane.setHgrow(transferNameTextField, Priority.ALWAYS);
        GridPane.setHgrow(transferSurnameField, Priority.ALWAYS);

        // Layout
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setSpacing(1);
        layout.getChildren().addAll(formLayout);

        stage.setScene(new Scene(layout));
        stage.show();
    }
}
