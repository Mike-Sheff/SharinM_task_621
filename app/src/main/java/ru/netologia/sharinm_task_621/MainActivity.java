package ru.netologia.sharinm_task_621;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Lifecycle";

    private Integer activityNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button ForwardButton = findViewById(R.id.ForwardButton);
        final Button BackwardsButton = findViewById(R.id.BackwardsButton);
        final TextView RandomTextView = findViewById(R.id.RandomTextView);

        Random r = new Random();
        activityNumber = r.nextInt(100);
        RandomTextView.setText(Integer.toString(activityNumber));

        outputMessage(getString(R.string.textMessageOnCreate));

        ForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        BackwardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        outputMessage(getString(R.string.textMessageOnStart));
    }

    @Override
    protected void onResume() {
        super.onResume();

        outputMessage(getString(R.string.textMessageOnResume));
    }

    @Override
    protected void onPause() {
        super.onPause();

        outputMessage(getString(R.string.textMessageOnPause));
    }

    @Override
    protected void onStop() {
        super.onStop();

        outputMessage(getString(R.string.textMessageOnStop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        outputMessage(getString(R.string.textMessageOnDestroy));
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        outputMessage(getString(R.string.textMessageOnRestart));
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);

        outputMessage(getString(R.string.textMessageOnPostCreate));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        outputMessage(getString(R.string.textMessageOnPostResume));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        outputMessage(getString(R.string.textMessageOnKeyDown));

        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        outputMessage(getString(R.string.textMessageOnKeyLongPress));

        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        outputMessage(getString(R.string.textMessageOnBackPressed));
    }

    private void outputMessage(String text){
        text = getString(R.string.textMessage, activityNumber.toString(), text, this);
        Log.d(TAG, text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
