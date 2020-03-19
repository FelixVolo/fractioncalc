import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Exercise;
import model.Fraction;

import java.util.Random;

public class Fractionuicontroller {

    private Fraction a;
    private Fraction b;
    private Exercise exercise;

    @FXML
    private Label Counter1;

    @FXML
    private Label Numerator1;

    @FXML
    private Label Counter2;

    @FXML
    private Label Numerator2;

    @FXML
    private TextField Counter3;

    @FXML
    private TextField Numerator3;

    @FXML
    private Label Exercisetext;

    @FXML
    private Label Operator;


    private void createNewExcercise()
    {
        Random r = new Random();
        a = new Fraction(r.nextInt(98) + 2, r.nextInt(98) + 2);
        b = new Fraction(r.nextInt(98) + 2, r.nextInt(98) + 2);
        exercise = new Exercise(r.nextInt(8), a, b);
        Exercisetext.setText(exercise.getText());
        Operator.setText(exercise.getOperator());
        Counter1.setText(Integer.toString(a.getCounter()));
        Counter2.setText(Integer.toString(b.getCounter()));
        Numerator1.setText(Integer.toString(a.getNumerator()));
        Numerator2.setText(Integer.toString(b.getNumerator()));
    }

    @FXML
    public void initialize()
    {
        createNewExcercise();
    }

    public void pressCheckButton(ActionEvent event)
    {
        int counter3 = Integer.parseInt(Counter3.getText());
        int numerator3 = Integer.parseInt(Numerator3.getText());
        Fraction c = new Fraction(counter3, numerator3);
        if(exercise.checkSolution(c))
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Richtig!");
            alert.setContentText("Du hast die Aufgabe richtig gelöst! Als Belohnung gibt es eine neue!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                    Counter3.setText("");
                    Numerator3.setText("");
                }
            });
            createNewExcercise();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falsch!");
            alert.setContentText("Du hast die Aufgabe anscheinend nicht richtig berechnet! Versuche es nochmal.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }
    }

}
