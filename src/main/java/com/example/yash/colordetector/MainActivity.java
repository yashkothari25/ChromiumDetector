package com.example.yash.colordetector;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
public class MainActivity extends AppCompatActivity  {


    TextView mResultView;
    View mColorView;
    Bitmap bitmap;
    private Uri file;

    private Button takePictureButton;
    private ImageView imageView;
     HashMap<Integer,String>map=new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map.put(1,"Quantity of Cr:0gm, Not Harmful");
        map.put(2,"Quantity of Cr:0.628gm, Not Harmful");
        map.put(3,"Quantity of Cr:1.25gm, Not Harmful");
        map.put(4,"Quantity of Cr:1.89gm, Not Harmful");
        map.put(5,"Quantity of Cr:2.52gm, Harmful");
        map.put(6,"Quantity of Cr:3.78gm, Harmful");
        map.put(7,"Quantity of Cr:4.36gm, Harmful");
        map.put(8,"Quantity of Cr:6.34gm, Harmful");
        map.put(9,"Quantity of Cr:8.8gm, Harmful");
        map.put(10,"Quantity of Cr:12.6gm, Harmful");
        map.put(11,"Quantity of Cr:16.35gm, Harmful");
        map.put(12,"Quantity of Cr:17gm, Harmful");
        map.put(13,"Quantity of Cr:20gm, Harmful");
        map.put(14,"Quantity of Cr:21.4gm, Harmful");
        map.put(15,"Quantity of Cr:25gm, Harmful");

        takePictureButton = (Button) findViewById(R.id.button_image);
        imageView = (ImageView) findViewById(R.id.imageview);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            takePictureButton.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());


        mResultView=findViewById(R.id.resultView);
        mColorView=findViewById(R.id.colorView);
//        imageView.setDrawingCacheEnabled(true);
        imageView.setEnabled(false);
//        imageView.buildDrawingCache(true);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                    bitmap = imageView.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    String hex = Integer.toHexString(pixel);
                    String fhex="#"+hex.substring(2);
                    String nhex=hex.substring(2);
                    int decimal=Integer.parseInt(nhex,16);
                    if (decimal>=12802902 && decimal<=148230300){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(1) );
                    }
                    else if (decimal>=11902639 && decimal<=12802901){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(2) );
                    }
                    else if (decimal>=11842748&& decimal<=11902638){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(3) );
                    }
                    else if (decimal>=11410747 && decimal<=11842747){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(4) );
                    }
                    else if (decimal>=11017030 && decimal<=11410746){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(5) );
                    }
                    else if (decimal>=10586529 && decimal<=11017029){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(6) );
                    }
                    else if (decimal>=9179960 && decimal<=10586519){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(7) );
                    }
                    else if (decimal>=8722218 && decimal<=9179959){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(8) );
                    }
                    else if (decimal>=7734835 && decimal<=8722217){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(9) );
                    }else if (decimal>=7080743 && decimal<=7734834){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(10) );
                    }else if (decimal>=7079202 && decimal<=7080742){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(11) );
                    }else if (decimal>=6948387 && decimal<=7079201){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(12) );
                    }else if (decimal>=5638152 && decimal<=6948386){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(13) );
                    }else if (decimal>=3540741 && decimal<=5638151){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(14 ));
                    }else if (decimal==40740){
                        mColorView.setBackgroundColor(Color.rgb(r, g, b));
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ " Decimal: "+String.valueOf(decimal)+ "\n "+map.get(15));
                    }
                    else{
                        //set Background Color
                        mColorView.setBackgroundColor(Color.rgb(0, 0, 0));
                        //set hex and rgb
                        mResultView.setText("RGB: " + r + ", " + g + ", " + b + "\nHEX: " + fhex+ "\n Incorrect Color! Can't decide. ");

                    }




                }
                return true;
            }
        });
    }




    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                takePictureButton.setEnabled(true);
                Toast.makeText(getApplicationContext(),"button enabled",Toast.LENGTH_SHORT);
            }
        }
    }

    public void takePicture(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, 100);
    }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == 100) {
                if (resultCode == RESULT_OK) {
                    imageView.setImageURI(file);
                    imageView.setEnabled(true);
                    imageView.setDrawingCacheEnabled(true);
                    imageView.buildDrawingCache(true);

                }
            }
        }
    }