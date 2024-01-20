/*
 * Muhammad Qazi
 * Java 605.201.81 Fall
 * Module 13 - Project Three - Loan-Payments Calculator
*/

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import java.util.Scanner;
import javafx.event.*;

public class FinancesCalculator extends Application
{
    private Button aButton;
    private TextField monthlyPayment;
    private TextField totalPayment;
    private TextField first;
    private TextField second;
    private TextField third;
    public void start( Stage myStage ) // This sets the start method for the stage.
    {
        myStage.setTitle( "Loan Calculator" ); // Set the title of the loan-calculator window.
        GridPane rootNode = new GridPane(); // Develop the grid-pane for the calculator stage and scene.
        rootNode.setPadding( new Insets( 30 ) );
        rootNode.setHgap( 5 );
        rootNode.setVgap( 5 );
        rootNode.setAlignment( Pos.CENTER ); // These settings adjust the layout of the data.
        Scene myScene = new Scene( rootNode, 300, 200 ); // Develop the scene that contains all of the data, eventually displayed within the stage.
        
        rootNode.add( new Label( "Annual Interest Rate:" ), 0, 0 ); // Set the first label, used for the first value of the annual interest rate.
        first = new TextField();
        rootNode.add( first, 1, 0 ); // Set the text field for the first value.
        rootNode.add( new Label( "Number of Years:" ), 0, 1 ); // Set the second label, used for the second value of the terms of the loan.
        second = new TextField();
        rootNode.add( second, 1, 1 ); // Set the text field for the second value.
        rootNode.add( new Label( "Loan Amount:" ), 0, 2 ); // Set the third label, used for the third value of the principal amount of the loan.
        third = new TextField();
        rootNode.add( third, 1, 2 ); // Set the text field for the third value.
        
        rootNode.add( new Label( "Monthly Payment:" ), 0, 3 );
        monthlyPayment = new TextField();
        monthlyPayment.setEditable( false );
        rootNode.add( monthlyPayment, 1, 3 );
        rootNode.add( new Label( "Total Payment:" ), 0, 4 );
        totalPayment = new TextField();
        totalPayment.setEditable( false );
        rootNode.add( totalPayment, 1, 4 );
        
        aButton = new Button( "Calculate" ); // This implements a button to calculate the data.
        rootNode.add( aButton, 1, 5 ); // This places the button under the text field of the total payment.
        rootNode.setHalignment( aButton, HPos.RIGHT ); // Allow for the right-placement of the button area.
        aButton.setOnAction( new ButtonHandler() );
        
        myStage.setScene( myScene );
        myStage.show(); // Set the scene into the stage, followed with an eventual display of the stage.
    }
    class ButtonHandler implements EventHandler<ActionEvent> // This class implements the actions, events, and signals of the button.
    {
        public void handle( ActionEvent e ) // This method handles everything entailed within.
        {
            String annualRate = first.getText().toString(); // Convert the annual interest rate input into a string.
            double annualRateInteger = Double.valueOf(annualRate); // Convert the string into a double-value.
            String numberYears = second.getText().toString(); // Convert the loan terms input into a string.
            double numberYearsInteger = Double.valueOf(numberYears); // Convert the string into a double-value.
            String loanPrincipal = third.getText().toString(); // Convert the principal loan amount into a string.
            double loanPrincipalInteger = Double.valueOf(loanPrincipal); // Convert the string into a double-value.

            double compoundedMonthlyPeriods = numberYearsInteger * 12; // Start the calculation of the formula, converting the amount of years into months.
            double periodicInterestRate = ( annualRateInteger / 100 ) / 12; // Convert the annual interest rate into a periodic-value.
            double temporary1 = 1 + periodicInterestRate; // Start the (1 + i)^-n process for the formula, split into three temporary values. For this part, equate 1 + i, equating to temporary1.
            double temporary2 = Math.pow(temporary1, compoundedMonthlyPeriods); // Set (1 + i)^n, equating to temporary2.
            double temporary3 = 1 / temporary2; // Calculate 1 / temporary2 to account for the negative exponent.
            double monthlyPaymentValue = ( loanPrincipalInteger * periodicInterestRate ) / ( 1 - ( temporary3 ) ); // Finish the rest of the formula, equating into the monthly-payment value.
            double totalPaymentValue = monthlyPaymentValue * compoundedMonthlyPeriods; // Calculate the total-payment value, dependent on the terms of the loan and total months referenced for the loan.
            String final1 = String.valueOf(monthlyPaymentValue); // Convert both final answers into strings.
            String final2 = String.valueOf(totalPaymentValue);
            
            monthlyPayment.setText( final1 ); // Reference the final strings for both answers.
            totalPayment.setText( final2 );
        }
    }
    public static void main( String [] args )
    {
        launch( args ); // This main method here exists as an extra measure for certain IDE-software. I personally tested this code in both the command prompt and Visual Studio Code for both Module 12 and Module 13.
    }
}