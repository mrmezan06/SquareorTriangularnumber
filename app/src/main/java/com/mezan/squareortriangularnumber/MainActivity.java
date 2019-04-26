package com.mezan.squareortriangularnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    EditText Input;
    Button checker;
    TextView Res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Input=(EditText)findViewById(R.id.input);
        checker=(Button)findViewById(R.id.btnCheck);
        Res=(TextView) findViewById(R.id.res);
        checker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Number Mnumber=new Number();
                    Mnumber.number= Integer.parseInt(Input.getText().toString());
                    boolean isSQ=Mnumber.isSquare();
                    boolean isTr=Mnumber.isTriangular();

                    if(isTr){
                        if(isSQ){
                            Res.setText("Number is triangular and square both!");
                        }else {
                            Res.setText("Number is triangular");
                        }
                    }else {
                        if(isSQ){
                            Res.setText("Number is square");
                        }else {
                            Res.setText("Number is not square and nor triangular");
                        }
                    }

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Please input number",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
class Number{
    int number;
    public boolean isSquare(){
        double squareroot=Math.sqrt(number);
        if(squareroot==Math.floor(squareroot)){
            return true;
        }else {
            return false;
        }
    }
    public boolean isTriangular(){
        int x=1;
        int triangularNumber=1;
        while (triangularNumber<number){
            x++;
            triangularNumber=triangularNumber+x;
        }
        if(triangularNumber==number){
            return true;
        }else{
            return false;
        }
    }

}
