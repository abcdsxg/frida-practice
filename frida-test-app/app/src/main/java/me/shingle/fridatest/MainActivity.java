package me.shingle.fridatest;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText et_num1;
    EditText et_num2;
    TextView tv_result;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvents();
    }


    private void initView() {
        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);
        tv_result = findViewById(R.id.tv_result);
        btn_add = findViewById(R.id.btn_add);
    }

    private void initEvents() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1, num2;
                try {
                    num1 = Integer.valueOf(et_num1.getText().toString());
                } catch (Exception e) {
                    num1 = 0;
                }

                try {
                    num2 = Integer.valueOf(et_num2.getText().toString());
                } catch (Exception e) {
                    num2 = 0;
                }

                int result = Add(num1, num2);
                showSucceed(num1,num2,result);
                tv_result.setText(String.valueOf(result));

            }
        });
    }

    private int Add(int num1, int num2) {
        return num1 + num2;
    }

    private void showSucceed(int num1, int num2,int result){
        Toast.makeText(this,String.format("%d+%d=%d",num1,num2,result),Toast.LENGTH_SHORT).show();
    }
}
