package com.example.myapplication;

//import static com.example.myapplication.CSVReaderHelper.readHeartRateCSV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    //Button blthOn, blthOff, blthShow;
    //TextView blthList;
    //Set<BluetoothDevice> ad;
//    public static final int REQUEST_ENABLE_BLUETOOTH = 2, BLUETOOTH_PERMISSION_REQUEST = 1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        blthOn = (Button) findViewById(R.id.blthOn);
//        blthOff = (Button) findViewById(R.id.blthOff);
//        blthList = (TextView) findViewById(R.id.blthList);
//        blthShow = (Button) findViewById(R.id.blthShowLst);
//
//        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED ||
//                ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
//            // Request permissions if they are not granted
//            ActivityCompat.requestPermissions(this, new String[]{
//                    android.Manifest.permission.BLUETOOTH,
//                    android.Manifest.permission.BLUETOOTH_ADMIN,
//                    android.Manifest.permission.BLUETOOTH_CONNECT
//            }, BLUETOOTH_PERMISSION_REQUEST);
//        }
//        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
//
//        if (adapter == null)
//            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_LONG).show();
//        blthOn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!adapter.isEnabled()) {
//                    Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//                    startActivityForResult(i, REQUEST_ENABLE_BLUETOOTH);
//                }
//            }
//        });
//
//        blthOff.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                adapter.disable();
//            }
//        });
//
//        blthShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StringBuilder sb = new StringBuilder();
////                ad = adapter.getBondedDevices();
////                for(BluetoothDevice temp: ad){
////                    sb.append("\n" + temp.getName() + "\n");
////                }
////                blthList.setText(sb.toString());
//                String fileName = "HEARTRATE_1699365827468.csv";
//
//                //CSVReaderHelper csvReaderHelper=new CSVReaderHelper("/CSVFiles/HEARTRATE_1699365827468.csv");
//                String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CSVFiles/HEARTRATE_1699365827468.csv";
//                CSVReaderHelper csvReaderHelper = new CSVReaderHelper( filePath);
//                List<HeartRace> list = readHeartRateCSV(MainActivity.this.getApplicationContext(),fileName);
//                for(HeartRace temp: list){
//                    sb.append("\n" + temp.getHeartRace().toString() + "   " + temp.getData() + "\n");
//                }
//
//            }
//        });
//
//    }
}