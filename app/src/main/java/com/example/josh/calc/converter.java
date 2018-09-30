package com.example.josh.calc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class converter extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_converter, container, false);


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText cm,cm2, in,in2;
        Button convert,convert2,change;
        final Toast t = null;

        cm = view.findViewById(R.id.cm);
        in = view.findViewById(R.id.in);
        cm2 = view.findViewById(R.id.cm2);
        in2 = view.findViewById(R.id.in2);
        convert = view.findViewById(R.id.convert);
        convert2=view.findViewById(R.id.convert2);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in.getText().toString()==""|cm.getText().toString()==""){
                    in.setText("0.0");
                    cm.setText("0.0");
                }
                double centimeters=0.0;
                if (cm.getText().toString() != "") {

                        centimeters = (Double.parseDouble(cm.getText().toString()) * (0.3937));
                        in.setText(String.valueOf(centimeters));

                }



            }
        });

        convert2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in2.getText().toString()==""|cm2.getText().toString()==""){
                    in2.setText("0.0");
                    cm2.setText("0.0");
                }
                double inches=0.0;
                if (in2.getText().toString() != "") {

                        inches = (Double.parseDouble(in2.getText().toString()) * (2.54));
                        cm2.setText(String.valueOf(inches));

                }

            }
        });
    }
}

