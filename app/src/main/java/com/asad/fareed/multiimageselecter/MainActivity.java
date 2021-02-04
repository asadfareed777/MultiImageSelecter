package com.asad.fareed.multiimageselecter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.asadfareed.multimager.activities.GalleryActivity;
import com.asadfareed.multimager.utils.Constants;
import com.asadfareed.multimager.utils.Image;
import com.asadfareed.multimager.utils.Params;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startPicking();
    }

    private void startPicking() {
        Intent intent = new Intent(this, GalleryActivity.class);
        Params params = new Params();
        params.setCaptureLimit(2);
        params.setPickerLimit(2);
        intent.putExtra(Constants.KEY_PARAMS, params);
        startActivityForResult(intent, Constants.TYPE_MULTI_PICKER);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case Constants.TYPE_MULTI_CAPTURE:
            case Constants.TYPE_MULTI_PICKER:
                ArrayList<Image> imagesList = intent.getParcelableArrayListExtra(Constants.KEY_BUNDLE_LIST);
                Toast.makeText(this, "size: "+imagesList.size(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}