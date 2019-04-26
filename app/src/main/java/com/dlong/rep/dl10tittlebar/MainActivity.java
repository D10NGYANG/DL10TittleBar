package com.dlong.rep.dl10tittlebar;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.dlong.rep.dltittlebar.DLTittleBar;

public class MainActivity extends AppCompatActivity {
    private Context mContext = this;
    private DLTittleBar tittleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tittleBar = findViewById(R.id.tittle);
        tittleBar.setOnTittleBarBtnsClick(new DLTittleBar.TittleBarBtnsOnClickListener() {
            @Override
            public void OnClick(View view) {
                switch (view.getId()){
                    case R.id.titleTxt:
                        Toast.makeText(mContext, "tittle", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.leftBtnImg:
                        Toast.makeText(mContext, "leftBtn", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.right1BtnTxt:
                        Toast.makeText(mContext, "right1Btn", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.right2BtnImg:
                        Toast.makeText(mContext, "right2Btn", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
