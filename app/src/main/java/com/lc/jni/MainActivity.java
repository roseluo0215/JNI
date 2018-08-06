package com.lc.jni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.tv_info).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        NativeMethod nativeMethod = new NativeMethod();
        String s = NativeMethod.add(34,2)+"";
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
