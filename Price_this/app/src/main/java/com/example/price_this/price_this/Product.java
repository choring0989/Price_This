package com.example.price_this.price_this;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Product extends AppCompatActivity {
    TextView txtView_productName;
    TextView txtView_avgPrice, txtView_regPrice, txtView_userPrice;
    TextView txtView_priceToRegister;
    TextView txtView_goodsTag;
    ImageView imgView_productImg;
    Button btn_register;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product);

        try{
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.app_banner));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        txtView_productName = findViewById(R.id.txtView_productName);
        txtView_avgPrice = findViewById(R.id.txtView_avgPrice);
        txtView_regPrice = findViewById(R.id.txtView_regPrice);
        txtView_userPrice = findViewById(R.id.txtView_userPrice);
        txtView_priceToRegister = findViewById(R.id.txtView_priceToRegister);
        txtView_goodsTag = findViewById(R.id.txtView_goodsTag);
        imgView_productImg = findViewById(R.id.imgView_productImg);
        btn_register = findViewById(R.id.btn_register);

        Intent intent = getIntent();
        txtView_productName.setText(intent.getStringExtra("name"));
        imgView_productImg.setImageResource(intent.getIntExtra("image", 0));
        txtView_avgPrice.setText(intent.getStringExtra("price"));
        //태그띄우기
        ArrayList<String> tags = intent.getStringArrayListExtra("Tags");
        if(tags!=null){
            for(int i=0; i<tags.size();i++) {
                txtView_goodsTag.append(tags.get(i));
                if (i != tags.size()-1){
                    txtView_goodsTag.append(", ");
                }
            }
        }

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}