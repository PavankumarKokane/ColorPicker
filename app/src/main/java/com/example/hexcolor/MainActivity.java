package com.example.hexcolor;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private ClipboardManager myClipboard;
    private ClipData myClip;
    private CardView c1;
    private String hexColor;
    private int selectedcolor;
    boolean clicked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        final CardView c1=findViewById(R.id.cv);
        Button bt=findViewById(R.id.tv);

        c1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                final ColorPicker cp1= new ColorPicker(MainActivity.this,0,0,0);
                cp1.show();

                Button btn=cp1.findViewById(R.id.okColorButton);

                btn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v)
                    {

                        selectedcolor = cp1.getColor();
                        c1.setBackgroundColor(selectedcolor);
                        clicked=true;
                        cp1.dismiss();

                    }
                });

            }

        });

    }
    public void funcpy(View v){

        if(clicked)
        {
            String hexColor = "#" + Integer.toHexString(selectedcolor).substring(2);
            hexColor=hexColor.toUpperCase();
            myClip = ClipData.newPlainText("text", hexColor);
            myClipboard.setPrimaryClip(myClip);
            Toast.makeText(getApplicationContext(), "Color Code Copied "+hexColor, Toast.LENGTH_SHORT).show();
        }
        else {
            hexColor="#00E676";
            myClip = ClipData.newPlainText("text", hexColor);
            myClipboard.setPrimaryClip(myClip);
            Toast.makeText(getApplicationContext(), "Color Code Copied "+hexColor, Toast.LENGTH_SHORT).show();
        }

    }
}
