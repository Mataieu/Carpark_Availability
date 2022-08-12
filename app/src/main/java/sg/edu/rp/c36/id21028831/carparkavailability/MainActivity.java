package sg.edu.rp.c36.id21028831.carparkavailability;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvAvailability;
    AsyncHttpClient client;

    ArrayAdapter<Availability> aaAvailability;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAvailability=findViewById(R.id.lvAvailability);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Availability> alWeather = new ArrayList();
        aaAvailability=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alWeather);

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            int total_lots;
            String lot_type;
            int lots_available;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");

                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrData = firstObj.getJSONArray("carpark_data");

                    for(int i = 0; i < jsonArrData.length(); i++) {
                        JSONObject secondObj = jsonArrData.getJSONObject(i);
                        JSONArray jsonArrData2 = secondObj.getJSONArray("carpark_info");
                        JSONObject jsonObjAvailability = jsonArrData2.getJSONObject(0);
                        total_lots = jsonObjAvailability.getInt("total_lots");
                        lot_type = jsonObjAvailability.getString("lot_type");
                        lots_available = jsonObjAvailability.getInt("lots_available");
                        Availability availability = new Availability(total_lots, lot_type, lots_available);
                        alWeather.add(availability);
                    }
                }
                catch(JSONException e){

                }

                lvAvailability.setAdapter(aaAvailability);

            }//end onSuccess
        });
    }//end onResume
}