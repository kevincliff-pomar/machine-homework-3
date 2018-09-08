package com.arielmagbanua.userinterface_inputcontrols;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    //variable declaration....
    private CheckBox pineappleCheckbox = null;
    private CheckBox sausageCheckBox = null;
    private CheckBox baconCheckBox = null;
    private CheckBox peperoniCheckBox = null;
    private boolean pineappleCheckBoxValue = false;
    private boolean sausageCheckBoxValue = false;
    private boolean baconCheckBoxValue = false;
    private boolean peperoniCheckBoxValue = false;

    public final static String EXTRA_MESSAGE = "com.arielmagbanua.userinterface_inputcontrols.MESSAGE";
    public String PIZZA_FLAVOR = "NO FLAVOR";
    public String PIZZA_ADDON = "NO ADDON";

    private FloatingActionButton orderFab;
    //variable declaration....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Pizza Order Menu");

        //item/view initialization....
        RadioGroup flavorGroup = findViewById(R.id.flavor_group);

        pineappleCheckbox = findViewById(R.id.pineapple_checkBox);
        sausageCheckBox = findViewById(R.id.sausage_checkBox);
        baconCheckBox = findViewById(R.id.bacon_checkBox);
        peperoniCheckBox = findViewById(R.id.peperoni_checkBox);
        orderFab = findViewById(R.id.order_fab);
        //item/view initialization....

        //RadioButtonGroup Button Listener Code Start....
        flavorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.hawaian_radioButton:
                        PIZZA_FLAVOR = "Hawaian";
                        Toast.makeText(MainActivity.this, "Hawaian!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.peperoni_radioButton:
                        PIZZA_FLAVOR = "Peperoni";
                        Toast.makeText(MainActivity.this, "Peperoni!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.meatlovers_radioButton:
                        PIZZA_FLAVOR = "Meat Lovers";
                        Toast.makeText(MainActivity.this, "Meat Lovers!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.stuffedcrust_radioButton:
                        PIZZA_FLAVOR = "Stuffed Crust";
                        Toast.makeText(MainActivity.this, "Stuffed Crust!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //RadioButtonGroup Button Listener Code End....


        //FabCart Button Listener Code Start....
        orderFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayOrderActivity.class);
                String message = PIZZA_FLAVOR;
                intent.putExtra(EXTRA_MESSAGE, message);
                //intent.putExtra(NUMBER_EXTRA, 1000);
                startActivity(intent);
            }
        });
        //FabCart Button Listener Code End....

        pineappleCheckbox.setOnCheckedChangeListener(this);
        sausageCheckBox.setOnCheckedChangeListener(this);
        baconCheckBox.setOnCheckedChangeListener(this);
        peperoniCheckBox.setOnCheckedChangeListener(this);
    }

    //CheckBox Listener Code Start....
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = "";
        int id = buttonView.getId();

        switch (id){
            case R.id.pineapple_checkBox:
                PIZZA_ADDON = "Pineapple";
                message = isChecked ? "Pineapple is chosen!" : "";
                break;

            case R.id.sausage_checkBox:
                PIZZA_ADDON = "Sausage";
                message = isChecked ? "Sausage is chosen!" : "";
                break;

            case R.id.bacon_checkBox:
                PIZZA_ADDON = "Bacon";
                message = isChecked ? "Bacon is chosen!" : "";
                break;

            case R.id.peperoni_checkBox:
                PIZZA_ADDON = "Peperoni";
                message = isChecked ? "Peperoni is chosen!" : "";
                break;
        }

        if(!message.isEmpty()){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
    //CheckBox Listener Code End....

    /*
    public void sendMessage(View FloatingActionButton) {

        Intent intent = new Intent(this, DisplayOrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, PIZZA_FLAVOR);
        //intent.putExtra(NUMBER_EXTRA, 1000);

        startActivity(intent);
    }
    */
}

