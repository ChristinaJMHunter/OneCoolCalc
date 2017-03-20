package com.example.chunt.onecoolcalc;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import static java.lang.Math.sqrt;
/*
Android Calculator by Christina Hunter
Purpose to mimic windows standard calculator on android
difference from windows standard calculator replace 1/x with mod
*/
public class MainActivity extends AppCompatActivity implements OnClickListener
{
    //define variables to hold input and output
    public double toNum1 = 0;
    public double toNum2 = 0;
    public double result = 0;
    public String num1 = "";
    public String num2 = "";
    public String operation = "";
    public String clear = "";
    public String answer = "";
    int zero = 0;
    //define buttons
    Button divBtn;
    Button addBtn;
    Button modBtn;
    Button prcntBtn;
    Button sqrRtBtn;
    Button sqrBtn;
    Button bckSpcBtn;
    Button cBtn;
    Button ceBtn;
    Button multiplyBtn;
    Button subBtn;
    Button equalsBtn;
    Button changeSgnBtn;
    Button decimalBtn;
    Button oneBtn;
    Button twoBtn;
    Button threeBtn;
    Button zeroBtn;
    Button fourBtn;
    Button fiveBtn;
    Button sixBtn;
    Button sevenBtn;
    Button eightBtn;
    Button nineBtn;
    //define textview for output
    TextView numInOut;
    /*
    onCreate takes parameter savedInstanceState
    it is called when the activity is created
    */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find buttons
        addBtn = (Button) findViewById(R.id.addBtn);
        modBtn = (Button) findViewById(R.id.modBtn);
        divBtn = (Button) findViewById(R.id.divBtn);
        prcntBtn = (Button) findViewById(R.id.prcntBtn);
        sqrRtBtn = (Button) findViewById(R.id.sqrRtBtn);
        sqrBtn = (Button) findViewById(R.id.sqrBtn);
        bckSpcBtn = (Button) findViewById(R.id.bckSpcBtn);
        cBtn = (Button) findViewById(R.id.cBtn);
        ceBtn = (Button) findViewById(R.id.ceBtn);
        multiplyBtn = (Button) findViewById(R.id.multiplyBtn);
        subBtn = (Button) findViewById(R.id.subBtn);
        equalsBtn = (Button) findViewById(R.id.equalsBtn);
        changeSgnBtn = (Button) findViewById(R.id.changeSgnBtn);
        decimalBtn = (Button) findViewById(R.id.decimalBtn);
        oneBtn = (Button) findViewById(R.id.oneBtn);
        twoBtn = (Button) findViewById(R.id.twoBtn);
        threeBtn = (Button) findViewById(R.id.threeBtn);
        zeroBtn = (Button) findViewById(R.id.zeroBtn);
        fourBtn = (Button) findViewById(R.id.fourBtn);
        fiveBtn = (Button) findViewById(R.id.fiveBtn);
        sixBtn = (Button) findViewById(R.id.sixBtn);
        sevenBtn = (Button) findViewById(R.id.sevenBtn);
        eightBtn = (Button) findViewById(R.id.eightBtn);
        nineBtn = (Button) findViewById(R.id.nineBtn);
        //find textview for output
        numInOut = (TextView) findViewById(R.id.numInOut);
        //set button clicks
        addBtn.setOnClickListener((OnClickListener) this);
        modBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        prcntBtn.setOnClickListener(this);
        sqrRtBtn.setOnClickListener(this);
        bckSpcBtn.setOnClickListener(this);
        cBtn.setOnClickListener(this);
        ceBtn.setOnClickListener(this);
        multiplyBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        equalsBtn.setOnClickListener(this);
        changeSgnBtn.setOnClickListener(this);
        decimalBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        zeroBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);
        sqrBtn.setOnClickListener(this);
        //show zero at start
        numInOut.setText(clear.valueOf(zero));
    }
    /*
    onClick method takes parameter View V and
    uses a switch statement to determine which
    action to take based on which button was clicked
    */
    @Override
    public void onClick(View v)
    {
        //handle the buttons
        switch (v.getId())
        {
            case R.id.addBtn:
                setOperation("+");
                break;
            case R.id.modBtn:
                setOperation("mod");
                break;
            case R.id.divBtn:
                setOperation("/");
                break;
            case R.id.prcntBtn:
                makePercent();
                break;
            case R.id.multiplyBtn:
                setOperation("*");
                break;
            case R.id.sqrRtBtn:
                makeSqrRt();
                break;
            case R.id.bckSpcBtn:
                goBackOne();
                break;
            case R.id.cBtn:
                clear();
                break;
            case R.id.ceBtn:
                clearEntry();
                break;
            case R.id.subBtn:
                setOperation("-");
                break;
            case R.id.equalsBtn:
                equals();
                break;
            case R.id.changeSgnBtn:
                changeSign();
                break;
            case R.id.decimalBtn:
                setNumber(".");
                break;
            case R.id.oneBtn:
                setNumber("1");
                break;
            case R.id.twoBtn:
                setNumber("2");
                break;
            case R.id.threeBtn:
                setNumber("3");
                break;
            case R.id.zeroBtn:
                setNumber("0");
                break;
            case R.id.fourBtn:
                setNumber("4");
                break;
            case R.id.fiveBtn:
                setNumber("5");
                break;
            case R.id.sixBtn:
                setNumber("6");
                break;
            case R.id.sevenBtn:
                setNumber("7");
                break;
            case R.id.eightBtn:
                setNumber("8");
                break;
            case R.id.nineBtn:
                setNumber("9");
                break;
            case R.id.sqrBtn:
                makeSqr();
                break;
            default:
                break;
        }
    }
    /*
    setOperation sets the String operation to the appropriate
    operand if this is the second operation the method
    calls compute to perform the appropriate computation
    of the already entered num1 and num2 and places the
    result into num1 and clears num2 making it ready to
    perform another operation and take another number
    this allows for multiple operations to be performed
    before equals is clicked
    */
    public void setOperation(String op)
    {
        if (operation.equals(""))
        {
            operation = op;
        }
        else
        {
            num1 = compute();
            operation = "";
            operation = op;
            num2 = "";
        }
    }
    /*
    setNumber adds the number clicked into
    the appropriate entry and displays it
    */
    public void setNumber(String num)
    {
        if (operation.equals(""))
        {
            num1 += num;
            numInOut.setText(num1);
        }
        else
        {
            num2 += num;
            numInOut.setText(num2);
        }
    }
    /*
    makeSqrRt computes the square root of a number
    by using the sqrt method from Math and places it back into the
    appropriate number entry
    */
    public void makeSqrRt()
    {
        if (operation.equals(""))
        {
            toNum1 = Double.parseDouble(num1);
            toNum1 = sqrt(toNum1);
            num1 = String.valueOf(toNum1);
            numInOut.setText(printString(num1));
        }
        else
        {
            toNum2 = Double.parseDouble(num2);
            toNum2 = sqrt(toNum2);
            num2 = String.valueOf(toNum2);
            numInOut.setText(printString(num2));
        }
    }
    /*
    makeSqr computes the square of a number
    and places it back into the appropriate number entry
    displays entry
    */
    public void makeSqr()
    {
        if (operation.equals(""))
        {
            toNum1 = Double.parseDouble(num1);
            toNum1 = (toNum1 * toNum1);
            num1 = String.valueOf(toNum1);
            numInOut.setText(printString(num1));
        }
        else
        {
            toNum2 = Double.parseDouble(num2);
            toNum2 = (toNum2 * toNum2);
            num2 = String.valueOf(toNum2);
            numInOut.setText(printString(num2));
        }
    }
    /*
    goBackOne removes one char from the last entry
    using String methods substring and length
    and displays modified entry
    */
    public void goBackOne()
    {
        if (operation.equals(""))
        {
            String newNum1 = num1.substring(0, (num1.length() - 1));
            num1 = "";
            num1 = newNum1;
            numInOut.setText(num1);
        }
        else
        {
            String newNum2 = num2.substring(0, (num2.length() - 1));
            num2 = "";
            num2 = newNum2;
            numInOut.setText(num2);
        }
    }
    /*
    clear makes all variables empty or 0 to mimic
    the clear function on a calculator and displays a zero
    */
    public void clear()
    {
        num1 = "";
        num2 = "";
        operation = "";
        result = 0;
        toNum1 = 0;
        toNum2 = 0;
        numInOut.setText(clear.valueOf(zero));
    }
    /*
    clearEntry removes the last entry and sets it to empty
    to mimic the clearEntry function on a calculator
    displays zero for last entry
    */
    public void clearEntry()
    {
        if (operation.equals(""))
        {
            num1 = "";
            numInOut.setText(clear.valueOf(zero));
        }
        else
        {
            num2 = "";
            numInOut.setText(clear.valueOf(zero));
        }
    }
    /*
    makePercent convert the appropriate entry into a
    decimal equivalent of a percent and stores it back
    into the appropriate entry for later calculations
    */
    public void makePercent()
    {
        if (operation.equals(""))
        {
            toNum1 = Double.parseDouble(num1);
            toNum1 = (toNum1 / 100);
            num1 = String.valueOf(toNum1);
            numInOut.setText(printString(num1));
        }
        else
        {
            toNum2 = Double.parseDouble(num2);
            toNum2 = (toNum2 / 100);
            num2 = String.valueOf(toNum2);
            numInOut.setText(printString(num2));
        }
    }
    /*
    changeSign changes the sign on the appropriate entry
    by using (-)
    */
    public void changeSign()
    {
        if (operation.equals(""))
        {
            toNum1 = Double.parseDouble(num1);
            toNum1 = (-toNum1);
            num1 = String.valueOf(toNum1);
            numInOut.setText(printString(num1));
        }
        else
        {
            toNum2 = Double.parseDouble(num2);
            toNum2 = (-toNum2);
            num2 = String.valueOf(toNum2);
            numInOut.setText(printString(num2));
        }
    }
    /*
    equals checks for division by zero and outputs an error message
    if no operation is indicated outputs current number
    otherwise it calls the compute method
    and outputs the appropriate computation result
    */
    public void equals()
    {
        if (operation.equals(""))
        {
            numInOut.setText(num1);
        }
        if (operation.equals("/"))
        {
            if (num2.equals("") || num2.equals("0"))
            {
                numInOut.setText("Cannot divide by zero");
            }
            else
            {
                numInOut.setText(compute());
            }
        }
        else
        {
            numInOut.setText(compute());
        }
    }
    /*
    printString takes a string and formats it removing excess trailing zeros,
    it returns a niceString to be printed
    this resource helped: http://stackoverflow.com/questions/703396/how-to-nicely-format-
    floating-numbers-to-string-without-unnecessary-decimal-0
    */
    public String printString(String niceString)
    {
        double convert = 0.0;
        convert = Double.parseDouble(niceString);
        if (convert % 1.0 != 0)
        {
            return niceString.format("%s", convert);
        }
        else
        {
            return niceString.format("%.0f", convert);
        }
    }
    /*
    compute performs the appropriate computation based on the
    string stored in operation and returns
    a string worthy of printing
    if numbers are not input sets empty strings to "0"
    */
    public String compute()
    {
        String final_answer = "";
        if (num1.equals(""))
        {
            num1 = "0";
        }
        if (num2.equals(""))
        {
            num2 = "0";
        }
        toNum1 = Double.parseDouble(num1);
        toNum2 = Double.parseDouble(num2);
        if (operation.equals("+"))
        {
            result = (toNum1 + toNum2);
        }
        else if (operation.equals("-"))
        {
            result = (toNum1 - toNum2);
        }
        else if (operation.equals("*"))
        {
            result = (toNum1 * toNum2);
        }
        else if (operation.equals("/"))
        {
            result = (toNum1 / toNum2);
        }
        else if (operation.equals("mod"))
        {
            result = (toNum1 % toNum2);
        }
        else
        {
            final_answer = "Error";
        }
        if (final_answer.equals(""))
        {
            final_answer = String.valueOf(result);
        }
        return printString(final_answer);
    }
}
