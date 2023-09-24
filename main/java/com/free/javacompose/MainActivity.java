package com.free.javacompose;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Theme.init(getApplicationContext());

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(Color.backgroundColor());
        window.setStatusBarColor(Color.backgroundColor());

        Column column =
                new Column()
                        .padding(12, 12, 12, 0)
                        .child(
                                new Text("Contacts")
                                .style(Typography.HEADING)
                                .margin(0,120, 0, 0)
                        );

        for (int i = 1; i <= 5; i++) {
            column.child(
                    new Row()
                            .child(
                                    new Text("Index "+i)
                                            .margin(4,4,4,4)
                                            .color(Color.mainColor())
                            )
                            .child(
                                    new Text("Index "+i)
                                            .margin(4,4,4,4)
                                            .color(Color.complementColor())
                            )
                    );
        }

        column.child(
        new Button("Confirm")
                .gravity(Gravity.CENTER)
                .size(16)
                .icon(R.drawable.baseline_auto_awesome_24)
        );

        setContentView(column);
    }
}