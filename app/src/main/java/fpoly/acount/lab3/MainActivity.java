package fpoly.acount.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4;
Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btnDemo1);
        btn2 = findViewById(R.id.btnDemo2);
        btn3 = findViewById(R.id.btnDemo3);
        btn4 = findViewById(R.id.btnDemo4);

        btn1.setOnClickListener(v -> {
            //1.1 Tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            //1.2 Them cac thanh phan cho builder
            builder.setTitle("Thong bao");
            builder.setMessage("noi dung can thong bao");
            //1.3 Them button ok, cancle
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban dong y", Toast.LENGTH_LONG).show();
                }
            });
            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban da cancle", Toast.LENGTH_LONG).show();
                }
            });
            //1.4 tao dialog dua tren builder
            AlertDialog alertDialog = builder.create();
            //1.5 hien thi dialog
            alertDialog.show();
        });


        //Single choice
        btn2.setOnClickListener(v -> {
            //B1: lay nguon du lieu
            String[] arr = {"mau xanh", "mau do", "mau tim", "mau vang"};
            //B2: tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            //B3: tao cac thanh phan cho builder
            builder.setTitle("Tieu de");
            //B4: set single choice cho alert
            builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Ban chon: " + arr[which],Toast.LENGTH_LONG).show();
                }
            });
            //B5: tao dialog tu builder
            AlertDialog alertDialog = builder.create();
            //B6: hien thi builder
            alertDialog.show();
        });

        //Multiple choice
        btn3.setOnClickListener(v -> {
            //B1: lay nguon du lieu
            String[] arr = {"mau xanh", "mau do", "mau tim", "mau vang"};
            //B2: tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            //B3: tao cac thanh phan cho builder
            builder.setTitle("Tieu de");
            //B4: set single choice cho alert

            builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                    Toast.makeText(getApplicationContext(),"Ban chon: " + arr[which], Toast.LENGTH_LONG).show();
                }
            });
            //B5: tao dialog tu builder
            AlertDialog alertDialog = builder.create();
            //B6: hien thi builder
            alertDialog.show();
        });

        // Dang nhap = dialog
        btn4.setOnClickListener(v -> {
            //B1: tao builder
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            //B2: gan layout
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.dialog_dangnhap, null);
            builder.setView(view);
            //anh xa cac thanh phan
            final EditText edtUser = (EditText) view.findViewById(R.id.edtUsername);
            final EditText edtPass = (EditText) view.findViewById(R.id.edtPass);
            //B4: them cac thanh phan khac cho form: ok, cancle, title,..
            builder.setTitle("Login form");
            builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),"Xin chao " + edtUser.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });

            builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_LONG).show();
                }
            });

            //B5: tao dialog tu builder
            AlertDialog alertDialog = builder.create();
            //B6: hien thi dialog
            alertDialog.show();

        });
    }
}