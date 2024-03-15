package com.example.keeprunning;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView txtHello;
    public Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHello = findViewById(R.id.txtHello);
        btnChange = findViewById(R.id.btnChange);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHello.setText("Chuc mung nam moi 2024!");
                showPopup(MainActivity.this);
            }
        });
    }
    private void showPopup(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Thông báo");  // Tiêu đề của pop-up
        builder.setMessage("Đây là nội dung của pop-up."); // Nội dung của pop-up

        // Nút đồng ý
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xử lý khi người dùng chọn đồng ý
                dialog.dismiss(); // Đóng pop-up
            }
        });
        //  this is new context345345435345 ;

        // Nút hủy bỏ
        builder.setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Xử lý khi người dùng chọn hủy bỏ
                dialog.dismiss(); // Đóng pop-up
            }
        });

        // Tạo và hiển thị pop-up
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    @Override
    public void onPause(){
        super.onPause();
        txtHello.setText("onPause");
        Log.e("STATE", "onPause");
    }

    protected void onResume(){
        super.onResume();
        txtHello.setText("onResume");
        Log.e("STATE", "onResume!");
    }

    public void onStop(){
        super.onStop();
        Log.e("STATE", "onStop");
    }

}
