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
    int check1 = 1,check2 = 1;
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

            validationTenDangNhap(tendangnhap);
            validationMK(matkhau1,matkhau2);
            if(check1 == 0 && check2 == 0){
                Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
            }
        });


    }
    private void validationTenDangNhap(EditText tendangnhap){
        String Name = tendangnhap.getText().toString();
        if(Name.length() < 6){
            error.setText("Tên tài khoản phải dài hơn 6 kí tự");

            tendangnhap.setBackground(getDrawable(R.drawable.botron_loi));
            check1 = 1;

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
                check1 =1;
                tendangnhap.setBackground(getDrawable(R.drawable.botron_loi));
            }else {
                error.setText("");
                tendangnhap.setBackground(getDrawable(R.drawable.botron));
                check1 = 0;
            }

        }
    }
    private void validationMK(EditText matkhau1,EditText matkhau2){
        String Pass = matkhau1.getText().toString();
        String Pass2 = matkhau2.getText().toString();

        if(Pass.length() < 8){
            error2.setText("Mật Khẩu Phải nhiều hơn 8 kí tự");
            check2 =1;
            matkhau1.setBackground(getDrawable(R.drawable.botron_loi));
        }else
        if (!Pass.equals(Pass2)){
            error2.setText("Mật khẩu không trùng khớp");
            check2 =1;
            matkhau1.setBackground(getDrawable(R.drawable.botron_loi));
            matkhau2.setBackground(getDrawable(R.drawable.botron_loi));

        }else {
            error2.setText("");
            matkhau1.setBackground(getDrawable(R.drawable.botron));
            matkhau1.setBackground(getDrawable(R.drawable.botron));
            check2 = 0;
        }

    }
}