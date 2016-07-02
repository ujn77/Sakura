package ru.lexxer.sakura;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyAsyncTask MyAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyAsyncTask = new MyAsyncTask(this);

        // находим вьюхи
        Button buttonGetGoods = (Button) findViewById(R.id.butttonGetGoods);
        ListView listGoods = (ListView) findViewById(R.id.listGoods);

        buttonGetGoods.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MyAsyncTask.execute();
    }
}
