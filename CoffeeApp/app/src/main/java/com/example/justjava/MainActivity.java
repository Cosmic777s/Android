package com.example.justjava;



import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import org.w3c.dom.Text;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int count = 0;
    int price = 0;

    boolean whipCream = false;
    boolean chocolate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //emailPage();
       // map();
    }

    public void plus(View view){
        TextView plusTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(count == 100){
            count = 100;
        }else{
        count++;
        }
        plusTextView.setText(""+ count);
    }


    public void minus(View view) throws Exception{
        TextView minusTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(count - 1 < 0){
            System.err.println("error negative number not allowed");
            onBackPressed();
        } else{
            count--;
        }
        minusTextView.setText("" + count);
    }

    public void itemClicked(View v){
        CheckBox checkBox = (CheckBox) v;

        if(checkBox.isChecked()) {
            whipCream = true;
            TextView w = (TextView) findViewById(R.id.whip_c);
            w.setText("Added whipped cream");
        } else {
            TextView w = (TextView) findViewById(R.id.whip_c);
            w.setText("No Whipped Cream ");
        }
    }

    public void choc(View v){
        CheckBox checkBox = (CheckBox) v;

        if(checkBox.isChecked()){
            chocolate = true;
            TextView c = (TextView) findViewById(R.id.choco);
            c.setText("Added Chocolate");
        } else{
            TextView c = (TextView) findViewById(R.id.choco);
            c.setText("No Chocolate");
        }
    }

    public void addLatte(View view){
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()){
            TextView textView = (TextView)findViewById(R.id.coffeeName);
            textView.setText("Latte");
        }

    }
    public void addMocha(View view){
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()) {
            TextView textView = (TextView) findViewById(R.id.coffeeName);
            textView.setText("Mocha");
        }
    }

    public void addCappuccino(View view){
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()) {
                TextView textView = (TextView) findViewById(R.id.coffeeName);
                textView.setText("Cappuccino");
            }
    }
    public void sendName(){
        EditText editText = (EditText) findViewById(R.id.editTextPersonName);
        String message = editText.getText().toString();
        TextView textView = (TextView) findViewById(R.id.name);
        textView.setText(message);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String free = "Free";
        String th = "Thank you!";
        String nameView = "Evan";
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        //these two statements are remove because other methods now handle updating the count "plus" & "minus"
        quantityTextView.setText(""+ count);

        displayMessage(free,th, nameView);


        displayQ();
        displayPrice(count);

    }
    public void displayMessage(String message, String thanks,String name) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        TextView th = (TextView) findViewById(R.id.Thanks);

        sendName();

        priceTextView.setText(message);
        th.setText(thanks);
    }
    /*
    public void displayWhipAndChoco(){
        TextView wh = (TextView) findViewById(R.id.whip_c);
        wh.setText("No Whipped Cream ");
        TextView ch = (TextView) findViewById(R.id.choco);
        ch.setText("No Chocolate");
    }*/

    public void displayQ(){
        TextView q = (TextView) findViewById(R.id.quantity);
        q.setText("Quantity: "+ count);
    }



    //these two do the samething
    public void price(int price){
        TextView priceOfItem = (TextView) findViewById(R.id.price_text_view);
        this.price = price * 5;
        priceOfItem.setText("$"+ this.price);
    }

    private void displayPrice(int count) {

       // addWhiPrice();
        //addChoPrice();
        if(whipCream ){
            price = price + 1 ;
        }
        if(chocolate){
            price = price + 2;
        }


            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(((count * 5)+price)));
    }

    /*
    public void addWhiPrice(View view){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        CheckBox checkBox = (CheckBox) view;
        if(checkBox.isChecked()) {
            TextView pluTextView = (TextView) findViewById(R.id.price_text_view);
            this.price = this.price + 1;
            //priceTextView.setText(NumberFormat.getCurrencyInstance().format(count + price));
        }
    }
    public void addChoPrice(View view){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        CheckBox checkBox = (CheckBox) view;
        if (checkBox.isChecked()) {
            TextView pluTextView = (TextView) findViewById(R.id.price_text_view);
            this.price = this.price + 2;
           // priceTextView.setText(NumberFormat.getCurrencyInstance().format(count + price));
        }
    }
*/
    /**
     * This method displays the given quantity value on the screen.
     */

    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Negative number not allowed (continue?)");
        builder.setTitle("Alert");
        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

              //  finish();
                dialog.cancel();

            }
        });

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();

    }
/*
    public void emailPage(){
        Button button = (Button) findViewById(R.id.email);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, emailOrder.class);
                startActivity(intent);

                Toast.makeText(v.getContext(),
                        "Open email order",
                        Toast.LENGTH_SHORT).show();

            }
        });
    }
    */

/*
    public void map(){
        Button button = (Button) findViewById(R.id.map);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:47.6, -122.3"));
                //the following line of code is to check if the Intent can be handle
                //in other words it will crash otherwise
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
    */

}