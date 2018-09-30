package com.example.josh.calc;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.String;
import java.util.Random;

import static com.example.josh.calc.R.id.mainLayout;
import static com.example.josh.calc.R.id.t1;

public class Calculator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    TextView op, res, operation;
    Button zero, one, two, three, four, five, six, seven, eight, nine;
    Button add, mul, eq, div, sub;
    Button clear, delete, dec;
    RelativeLayout layout;


    private double num1 = Double.NaN;
    private double num2;
    char action, sym;
    final char addition = '+';
    final char subtraction = '-';
    final char division = '/';
    final char multiplication = '*';
    final char equal = '=';

    private boolean mToolBarNavigationListenerIsRegistered = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        setButtons();

        drawer = findViewById(R.id.drawer_lay);
        NavigationView nav = findViewById(R.id.nav_view);
        nav.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = op.getText().toString();
                if (op.getText().length() < 19) op.setTextSize(30);
                else op.setTextSize(20);

                if (str.contains(".")) {

                } else {
                    op.setText(op.getText().toString() + ".");
                }
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(zero);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(one);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(two);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(three);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(four);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(five);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(six);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(seven);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(eight);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setValue(nine);
            }
        });


        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.getText() == "+") action = addition;
                if (operation.getText() == "-") action = subtraction;
                if (operation.getText() == "*") action = multiplication;
                if (operation.getText() == "/") action = division;

                if (op.getText().toString() == "" && res.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "Insert a Number",
                            Toast.LENGTH_SHORT).show();
                } else if (op.getText().toString() == "") {

                } else if (res.getText().toString() == "") {
                        /*res.setText("Ans");
                        operation.setText(null);
                        Cal();
                        res.setText(res.getText().toString() +operation.getText().toString()+ "=" + String.valueOf(num1));
                        op.setText(null);*/
                } else {
                    if (op.getText().toString() == "-") {
                        op.setText("-0");
                    }
                    if (operation.getText().toString() != "") {
                        Cal();
                        res.setText(res.getText().toString() + operation.getText().toString() + String.valueOf(num2) + "=" + String.valueOf(num1));
                        op.setText(null);
                    } else {
                        num1 = 0;
                        res.setText(null);
                    }
                }

                operation.setText(null);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = res.getText().toString();
                if (str.contains("=")) {

                    res.setText(String.valueOf(num1));

                }

                operation.setText("+");
                if (op.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "Insert a Number",
                            Toast.LENGTH_SHORT).show();
                } else if (op.getText().toString() == "-") {
                    op.setText(null);
                } else {
                    action = addition;
                    Cal();
                    res.setText(String.valueOf(num1));
                    op.setText(null);
                }

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = res.getText().toString();
                if (str.contains("=")) {

                    res.setText(String.valueOf(num1));

                }
                operation.setText("-");
                if (op.getText().toString() == "" | op.getText().toString() == "-") {

                    op.setText("-");
                } else {
                    action = subtraction;
                    Cal();
                    res.setText(String.valueOf(num1));
                    op.setText(null);
                }
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = res.getText().toString();
                if (str.contains("=")) {

                    res.setText(String.valueOf(num1));

                }
                operation.setText("*");
                if (op.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "Insert a Number",
                            Toast.LENGTH_SHORT).show();
                } else if (op.getText().toString() == "-") {
                    op.setText(null);
                } else {
                    action = multiplication;
                    Cal();
                    res.setText(String.valueOf(num1));
                    op.setText(null);
                }
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = res.getText().toString();
                if (str.contains("=")) {

                    res.setText(String.valueOf(num1));

                }
                operation.setText("/");
                if (op.getText().toString() == "") {
                    Toast.makeText(getApplicationContext(), "Insert a Number",
                            Toast.LENGTH_SHORT).show();
                } else if (op.getText().toString() == "-") {
                    op.setText(null);
                } else {
                    action = division;
                    Cal();
                    res.setText(String.valueOf(num1));
                    op.setText(null);
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op.setTextSize(30);
                res.setText(null);
                op.setText(null);
                num1 = Double.NaN;
                num2 = Double.NaN;
                operation.setText(null);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (op.getText().length() < 19) op.setTextSize(30);
                else op.setTextSize(20);
                int length = String.valueOf(num1).length();
                if (length > 0) {
                    String val = op.getText().toString();
                    String blank = "";
                    for (int i = 0; i < val.length() - 1; i++) {
                        blank += val.charAt(i);
                    }
                    op.setText(blank);
                }
            }
        });


    }

    private void enableViews(boolean enable) {

        if (enable) {
            drawer.setDrawerLockMode(drawer.LOCK_MODE_LOCKED_CLOSED);
            toggle.setDrawerIndicatorEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (!mToolBarNavigationListenerIsRegistered) {
                toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        enableViews(false);
                        onBackPressed();
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }

        } else {
            drawer.setDrawerLockMode(drawer.LOCK_MODE_UNLOCKED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            toggle.setDrawerIndicatorEnabled(true);
            toggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        Fragment frag = null;
        switch (menuItem.getItemId()) {
            case R.id.converter:
                enableViews(true);
                frag = new converter();
                drawer.closeDrawers();
                onBackPressed();
                getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.Fragment_Container, frag).commit();
                break;

            case R.id.chat1:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "jf0273@gmail.com"));
                startActivity(intent);
                break;

            case R.id.send1:
                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.setPackage("com.whatsapp");
                startActivity(intent1);
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_lay);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        final RelativeLayout layout = findViewById(R.id.mainLayout);
        final FrameLayout layout1 = findViewById(R.id.Fragment_Container);
        final MenuItem toggle = menu.findItem(R.id.switchTheme);
        Switch actionView = (Switch) MenuItemCompat.getActionView(toggle);
        actionView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    layout.setBackgroundResource(R.drawable.gradient);
                    layout1.setBackgroundResource(R.drawable.gradient);
                    changeButtonColor();
                } else {
                    layout.setBackgroundResource(R.drawable.cal_grad);
                    layout1.setBackgroundResource(R.drawable.gradient);
                    revertButtonColor();
                }
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        final RelativeLayout layout = findViewById(R.id.mainLayout);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        switch (item.getItemId()) {
            case R.id.t1:
                layout.setBackgroundColor(color);
                toolbar.setBackgroundColor(color);
                return true;
            case R.id.t2:
                devInfo();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void changeButtonColor() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#6C5B7B"));
        clear.setBackgroundColor(Color.parseColor("#C06C84"));
        delete.setBackgroundColor(Color.parseColor("#C06C84"));
        add.setBackgroundColor(Color.parseColor("#C06C84"));
        sub.setBackgroundColor(Color.parseColor("#C06C84"));
        mul.setBackgroundColor(Color.parseColor("#C06C84"));
        div.setBackgroundColor(Color.parseColor("#C06C84"));
    }

    public void revertButtonColor() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#3f2b96"));
        clear.setBackgroundColor(R.drawable.rippleac);
        delete.setBackgroundColor(R.drawable.opertationripple);
        add.setBackgroundColor(R.drawable.opertationripple);
        sub.setBackgroundColor(R.drawable.opertationripple);
        mul.setBackgroundColor(R.drawable.opertationripple);
        div.setBackgroundColor(R.drawable.opertationripple);
    }

    private void Cal() {
        if (!Double.isNaN(num1)) {
            num2 = Double.parseDouble(op.getText().toString());


            switch (action) {
                case addition:
                    num1 = num1 + num2;
                    break;
                case subtraction:
                    num1 = num1 - num2;
                    break;
                case division:
                    num1 = num1 / num2;
                    break;
                case multiplication:
                    num1 = num1 * num2;
                    break;
                case equal:
                    break;
            }
        } else {
            num1 = Double.parseDouble(op.getText().toString());
        }

    }

    private void setButtons() {
        dec = findViewById(R.id.dec);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        // eq=findViewById(R.id.eq);
        clear = findViewById(R.id.clear);
        delete = findViewById(R.id.del);
        op = findViewById(R.id.op);
        res = findViewById(R.id.res);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        zero = findViewById(R.id.btn0);
        operation = findViewById(R.id.operation);
        eq = findViewById(R.id.eq1);
    }

    private void setValue(final Button val) {
        if (op.getText().length() < 19) op.setTextSize(30);
        else op.setTextSize(20);
        op.setText(op.getText().toString() + val.getText());

    }

    public void devInfo() {
        Intent intent = new Intent(this, developerInfo.class);
        startActivity(intent);
    }


}
