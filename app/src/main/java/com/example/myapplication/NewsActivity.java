package com.example.myapplication;
//
//import static com.example.myapplication.WekaSVMExample.loadModel;
//import static com.example.myapplication.WekaSVMExample.predict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;

//import weka.classifiers.Classifier;
//import weka.core.Attribute;
//import weka.core.DenseInstance;
//import weka.core.Instance;
//import weka.core.Instances;


public class NewsActivity extends AppCompatActivity  {
    //public class NewsActivity extends AppCompatActivity implements ServerDiscovery.ServerDiscoveryListener {


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

            double[] newData = {3, 21, 22, 15, 15, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0};

            try {
                // Load model from file
                //Classifier svm = loadModel(this);

                // Make prediction
               // double prediction = predict(svm, newData);
                //Log.d("Prediction", "Prediction for new data: " + prediction);
                //showToast("Prediction for new data: " + prediction);

            } catch (Exception e) {
                e.printStackTrace();
            }        //sendPredictionRequest(data);
        //ServerDiscovery.discoverServer(this);

        //Toast.makeText(NewsActivity.this, "Trimisă cererea către server", Toast.LENGTH_SHORT).show();
    }
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
//    public Classifier loadModel(Context context) throws IOException, ClassNotFoundException {
//        InputStream is = context.getAssets().open("my_model1.model");
//        ObjectInputStream ois = new ObjectInputStream(is);
//        Classifier model = (Classifier) ois.readObject();
//        ois.close();
//        return model;
//    }

//    public double predict(Classifier model, double[] data) throws Exception {
//        Instances dataset = createDataset(data);
//        dataset.setClassIndex(dataset.numAttributes() - 1);
//        double prediction = model.classifyInstance(dataset.firstInstance());
//        return prediction;
//    }

//    public Instances createDataset(double[] data) {
//        ArrayList<Attribute> atts = new ArrayList<>();
//        ArrayList<String> classVal = new ArrayList<>();
//
//        // Define attributes
//        atts.add(new Attribute("school_year"));
//        atts.add(new Attribute("age"));
//        atts.add(new Attribute("gender"));
//        atts.add(new Attribute("bmi"));
//        atts.add(new Attribute("phq_score"));
//        atts.add(new Attribute("suicidal"));
//        atts.add(new Attribute("depression_diagnosis_0"));
//        atts.add(new Attribute("depression_diagnosis_1"));
//        atts.add(new Attribute("depression_treatment_0"));
//        atts.add(new Attribute("depression_treatment_1"));
//        atts.add(new Attribute("anxiousness"));
//        atts.add(new Attribute("anxiety_diagnosis_0"));
//        atts.add(new Attribute("anxiety_diagnosis_1"));
//        atts.add(new Attribute("anxiety_treatment_0"));
//        atts.add(new Attribute("anxiety_treatment_1"));
//        atts.add(new Attribute("gender_0"));
//        atts.add(new Attribute("gender_1"));
//        atts.add(new Attribute("gender_2"));
//
//        classVal.add("0");
//        classVal.add("1");
//        atts.add(new Attribute("depressiveness", classVal));
//
//        Instances dataset = new Instances("Test", atts, 0);
//        dataset.setClassIndex(dataset.numAttributes() - 1);
//
//        // Add instance
//        Instance instance = new DenseInstance(data.length + 1);
//        for (int i = 0; i < data.length; i++) {
//            instance.setValue(i, data[i]);
//        }
//        dataset.add(instance);
//
//        return dataset;
//    }

//    private void sendPredictionRequest(int[] data) {
//        String url = "http://192.168.0.101:8080/predict";
//        JSONObject jsonObject = new JSONObject();
//        JSONArray jsonArray = new JSONArray();
//        try {
//            for (int value : data) {
//                jsonArray.put(value);
//            }
//            jsonObject.put("data", jsonArray);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        new PredictionTask().execute(url, jsonObject.toString());
//    }
//
//    private class PredictionTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//            String urlString = params[0];
//            String data = params[1];
//
//            try {
//                URL url = new URL(urlString);
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setRequestMethod("POST");
//                urlConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//                urlConnection.setRequestProperty("Accept","application/json");
//                urlConnection.setDoOutput(true);
//                urlConnection.setDoInput(true);
//                OutputStream os = urlConnection.getOutputStream();
//                os.write(data.getBytes("UTF-8"));
//                os.close();
//
//                int responseCode = urlConnection.getResponseCode();
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        urlConnection.getInputStream()));
//                StringBuilder result = new StringBuilder();
//                String line;
//                while ((line = in.readLine()) != null) {
//                    result.append(line);
//                }
//                in.close();
//                urlConnection.disconnect();
//                return result.toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            if (result != null) {
//                // Utilizează rezultatul primit aici
//                Toast.makeText(NewsActivity.this, "Rezultat primit de la server: " + result, Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(NewsActivity.this, "Eroare în obținerea rezultatului", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        @Override
//        protected void onCancelled(String result) {
//            super.onCancelled(result);
//            Toast.makeText(NewsActivity.this, "Eroare în obținerea rezultatului", Toast.LENGTH_SHORT).show();
//        }
//    }
//public void onServerFound(String serverAddress) {
//    // Connect to the server using TCP
//    connectToServer(serverAddress);
//}
//
//    @Override
//    public void onNoServersFound() {
//        Log.d("NewsActivity", "No servers found.");
//    }

//    private void connectToServer(String serverAddress) {
//        new Thread(() -> {
//            try {
//                // Connect to the server using TCP
//                Socket serverSocket = new Socket(serverAddress, ServerDiscovery.SERVER_PORT);
//                Log.d("NewsActivity", "Connected to server at: " + serverSocket.getRemoteSocketAddress());
//
//                // Send a message to the server
//                serverSocket.getOutputStream().write("Hello, server!".getBytes());
//
//                // Receive a response from the server
//                byte[] buffer = new byte[1024];
//                int bytesRead = serverSocket.getInputStream().read(buffer);
//                String serverResponse = new String(buffer, 0, bytesRead);
//                Log.d("NewsActivity", "Server response: " + serverResponse);
//
//                // Close the connection
//                serverSocket.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }


