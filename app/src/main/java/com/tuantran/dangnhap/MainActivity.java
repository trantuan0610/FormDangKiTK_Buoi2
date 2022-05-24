package com.tuantran.dangnhap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tendangnhap , matkhau1,matkhau2;
    Button tieptuc;
    TextView error, error2;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tendangnhap = findViewById(R.id.edtTentaikhoan);
        matkhau1 = findViewById(R.id.edtMatkhau);
        matkhau2 = findViewById(R.id.edtMatkhau2);
        tieptuc = findViewById(R.id.btnTieptuc);
        error =  findViewById(R.id.txtError);
        error2 =  findViewById(R.id.txtError2);


        tieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = tendangnhap.getText().toString();
                String Pass = matkhau1.getText().toString();
                String Pass2 = matkhau2.getText().toString();
                String Er = error.getText().toString();
                String Er2 = error2.getText().toString();
                if(Name.length() < 6){
                    error.setText("Tên tài khoản phải dài hơn 6 kí tự");
                    tendangnhap.setBackgroundColor(getColor(R.color.red2));

                }else if (Name.length() >= 6){
                    int count = 0;
                    for(int i=0;i<Name.length();i++){
                        String s =Name.trim();
                        char kytu = s.charAt(i);
                        if (Character.isSpace(kytu)){
                            count++;
                        }
                    }
                    if(count>0){

                        error.setText("Tên đăng nhập không được chứa khoảng trắng");
                        tendangnhap.setBackgroundColor(getColor(R.color.red2));
                    }else {
                        error.setText(" ");
                        tendangnhap.setBackgroundColor(getColor(R.color.graylight));
                    }

                }


                if(Pass.length() < 8){
                    error2.setText("Mật Khẩu Phải nhiều hơn 8 kí tự");
                    matkhau1.setBackgroundColor(getColor(R.color.red2));
                }else
                    if (!Pass.equals(Pass2)){
                    error2.setText("Mật khẩu không trùng khớp");
                        matkhau1.setBackgroundColor(getColor(R.color.red2));
                        matkhau2.setBackgroundColor(getColor(R.color.red2));
                }else
                {

                    error.setText(" ");
                    error2.setText(" ");
                    matkhau1.setBackgroundColor(getColor(R.color.graylight));
                    matkhau2.setBackgroundColor(getColor(R.color.graylight));
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}