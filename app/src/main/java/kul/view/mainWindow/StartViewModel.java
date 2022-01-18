package kul.view.mainWindow;

import javafx.beans.property.*;

public class StartViewModel {
    private boolean nameIsValid;
    private boolean surnameIsValid;
    private boolean townIsValid;
    private boolean homeNumberIsValid;
    private boolean pizzasIsValid;
    private boolean burgersIsValid;
    private boolean saladsIsValid;


    private final StringProperty enteredName = new SimpleStringProperty();
    private final StringProperty enteredSurname = new SimpleStringProperty();
    private final StringProperty enteredTown = new SimpleStringProperty();
    private final StringProperty enteredHomeNumber = new SimpleStringProperty();
    private final SimpleIntegerProperty enteredPizzas = new SimpleIntegerProperty();
    private final SimpleIntegerProperty enteredBurgers = new SimpleIntegerProperty();
    private final SimpleIntegerProperty enteredSalads = new SimpleIntegerProperty();
    private Boolean pizzaSelected = false;
    private Boolean burgerSelected = false;
    private Boolean saladSelected = false;
    private Boolean orderSelected = false;
    public final BooleanProperty cannotSubmitProperty = new SimpleBooleanProperty(true);
    public final BooleanProperty cannotEnteredPizzaProperty = new SimpleBooleanProperty(true);
    public final BooleanProperty cannotEnteredBurgerProperty = new SimpleBooleanProperty(true);
    public final BooleanProperty cannotEnteredSaladProperty = new SimpleBooleanProperty(true);
    public final BooleanProperty canEnteredHomeNumber = new SimpleBooleanProperty(false);
    public final BooleanProperty canEnteredTown = new SimpleBooleanProperty(false);


    public StartViewModel() {
    }

    public void setEnteredName(String enteredName) {
        if (!enteredName.isEmpty())
            nameIsValid = true;
        else
            nameIsValid = false;
        submitChecker();
    }

    public void setEnteredSurname(String enteredSurname) {
        if (!enteredSurname.isEmpty())
            surnameIsValid = true;
        else
            surnameIsValid = false;
        submitChecker();
    }

    public void setEnteredTown(String enteredTown) {
        if (!enteredTown.isEmpty())
            townIsValid = true;
        else
            townIsValid = false;
        submitChecker();
        //
    }

    public void setEnteredHomeNumber(String enteredHomeNumber) {
        if (!enteredHomeNumber.isEmpty())
            homeNumberIsValid = true;
        else
            homeNumberIsValid = false;
        submitChecker();
        //
        //
    }

    public void setEnteredPizzas(Number enteredPizzas) {
        if ((Integer) enteredPizzas > 0) {
            pizzasIsValid = true;
        } else
            pizzasIsValid = false;
        submitChecker();
    }

    public void setEnteredBurgers(Number enteredBurgers) {
        if ((Integer) enteredBurgers > 0)
            burgersIsValid = true;
        else
            burgersIsValid = false;
        submitChecker();
    }

    public void setEnteredSalads(Number enteredSalads) {
        if ((Integer) enteredSalads > 0)
            saladsIsValid = true;
        else
            saladsIsValid = false;
        submitChecker();
    }

    public void setPizzaSelected(Boolean pizzaSelected) {
        this.pizzaSelected = pizzaSelected;
        if (pizzaSelected) {
            cannotEnteredPizzaProperty.setValue(false);
            return;
        }
        cannotEnteredPizzaProperty.setValue(true);
        submitChecker();
    }

    public void setSaladSelected(Boolean saladSelected) {
        this.saladSelected = saladSelected;
        if (saladSelected) {
            cannotEnteredSaladProperty.setValue(false);
            return;
        }
        cannotEnteredSaladProperty.setValue(true);
        submitChecker();
    }

    public void setBurgerSelected(Boolean burgerSelected) {
        this.burgerSelected = burgerSelected;
        if (burgerSelected) {
            cannotEnteredBurgerProperty.setValue(false);
            return;
        }
        cannotEnteredBurgerProperty.setValue(true);
        submitChecker();
    }

    public void setOrderSelected(Boolean orderSelected) {
        this.orderSelected = orderSelected;
        if (orderSelected) {
            canEnteredTown.setValue(false);
            canEnteredHomeNumber.setValue(false);
            townIsValid = true;
            homeNumberIsValid = true;
            submitChecker();
            return;
        }
        canEnteredTown.setValue(true);
        canEnteredHomeNumber.setValue(true);
//        townIsValid = true;
//        homeNumberIsValid = true;
        submitChecker();
    }

    //&& townIsValid && homeNumberIsValid
    //&& (pizzasIsValid || burgersIsValid || saladsIsValid)
    void submitChecker() {
        if (nameIsValid && surnameIsValid && townIsValid && homeNumberIsValid && (pizzasIsValid || burgersIsValid || saladsIsValid) && (pizzaSelected || burgerSelected || saladSelected))
            cannotSubmitProperty.setValue(false);
        else
            cannotSubmitProperty.setValue(true);
    }


    public String getEnteredSurname() {
        return enteredSurname.get();
    }

    public StringProperty enteredSurnameProperty() {
        return enteredSurname;
    }

    public String getEnteredTown() {
        return enteredTown.get();
    }

    public StringProperty enteredTownProperty() {
        return enteredTown;
    }

    public String getEnteredHomeNumber() {
        return enteredHomeNumber.get();
    }

    public StringProperty enteredHomeNumberProperty() {
        return enteredHomeNumber;
    }

    public String getEnteredName() {
        return enteredName.get();
    }

    public StringProperty enteredNameProperty() {
        return enteredName;
    }

    public int getEnteredPizzas() {
        return enteredPizzas.get();
    }

    public SimpleIntegerProperty enteredPizzasProperty() {
        return enteredPizzas;
    }

    public int getEnteredBurgers() {
        return enteredBurgers.get();
    }

    public SimpleIntegerProperty enteredBurgersProperty() {
        return enteredBurgers;
    }

    public int getEnteredSalads() {
        return enteredSalads.get();
    }

    public SimpleIntegerProperty enteredSaladsProperty() {
        return enteredSalads;
    }

    public Boolean getPizzaSelected() {
        return pizzaSelected;
    }

    public Boolean getBurgerSelected() {
        return burgerSelected;
    }


    public Boolean getSaladSelected() {
        return saladSelected;
    }


    public Boolean getOrderSelected() {
        return orderSelected;
    }


}
