package com.free.m3javacompose;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.free.m3javacompose.components.Column;
import com.free.m3javacompose.components.FloatingButton;
import com.free.m3javacompose.components.Image;
import com.free.m3javacompose.components.Row;
import com.free.m3javacompose.components.Screen;
import com.free.m3javacompose.components.SearchBar;
import com.free.m3javacompose.components.Text;
import com.free.m3javacompose.components.Button;
import com.free.m3javacompose.ui.Color;
import com.free.m3javacompose.ui.Theme;
import com.free.m3javacompose.ui.Typography;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Screen screen;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Theme.init(this);

        screen = new Screen();
        screen.setInAnimation(this, android.R.anim.fade_in);
        screen.setOutAnimation(this, android.R.anim.fade_out);

        setContentView(screen);
        obtainPermission();
    }

    private void obtainPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            contacts = getContacts();
            screen.show(contactsScreen());
        } else {
            screen.show(permissionsScreen(), true);
        }
    }

    private Column permissionsScreen() {
        Column display = new Column().layout(-1,-1,0f);

        display.child(
                new Text("Please provide contacts permission")
                        .style(Typography.HEADING)
                        .gravity(Gravity.CENTER)
        ).child(
                new Text("Contacts permission is required to read and write contacts")
                        .style(Typography.SUBHEADING)
                        .gravity(Gravity.CENTER)
        ).child(
                new Button("Ask permission")
                        .onClick(v ->
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.READ_CONTACTS,
                                                Manifest.permission.WRITE_CONTACTS},
                                        1))
                        .margin(12,12,12,12)
        ).gravity(Gravity.CENTER);
        return display;
    }

    private Column contactsScreen() {
        Column display = new Column().layout(-1,-1,0f);

        display.child(
                new Text("Contacts")
                        .style(Typography.HEADING)
                        .margin(16, 120,0,0)
                        .onClick(v -> Log.d("Logger", "Screen childrens : " + screen.getChildCount()))
        ).child(
                new SearchBar().hint("Search contacts").elevation(0f)
        );

        Column list = new Column().layout(-1,-1,0).padding(12,0,12,0);

        for (Contact c:contacts) {
            Row contactItem = new Row().layout(-1,-2,0);
            contactItem.padding(4,4,4,4).gravity(Gravity.CENTER_VERTICAL);

            Image image = new Image().layout(Theme.px(50),Theme.px(50),0).margin(0, 0, 8,0);

            if (c.uri != null) {
                Glide.with(this)
                        .load(c.uri)
                        .transform(new CircleCrop())
                        .into(image);
                contactItem.child(image);

            } else {

                String firstLetter = c.name.substring(0, 1).toUpperCase();
                contactItem.child(image.image(generateAvatar(firstLetter, Color.mainColor())));

            }

            contactItem.child(new Text(c.name).style(Typography.BODY))
                    .allowClick()
                    .onClick(v -> screen.show(contactDetailsScreen(c), true));

            list.child(contactItem);
        }

        FloatingButton fab = new FloatingButton(R.drawable.add)
                                    .elevation(0f)
                                    .margin(24,24,24,24);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.addView(list.allowScroll());
        frameLayout.addView(fab);

        display.child(frameLayout);
        return display;
    }

    private Column contactDetailsScreen(Contact c) {
        Column display = new Column().layout(-1,-1,0f).padding(12,12,12,12);

        Cursor contactDetailsCursor = getContentResolver().query(
                ContactsContract.Data.CONTENT_URI,
                null,
                ContactsContract.Data.CONTACT_ID + " = ?",
                new String[]{c.id},
                null
        );

        if (contactDetailsCursor != null) {

            Image image = new Image()
                    .layout(Theme.px(80),Theme.px(80),0)
                    .margin(0, 60, 0,0)
                    .gravity(Gravity.CENTER);

            if (c.uri != null) {
                Glide.with(this)
                        .load(c.uri)
                        .transform(new CircleCrop())
                        .into(image);
            } else {
                String firstLetter = c.name.substring(0, 1).toUpperCase();
                image.image(generateAvatar(firstLetter, Color.mainColor()));
            }

            display.child(image)
                    .child(new Text(c.name)
                            .style(Typography.HEADING)
                            .gravity(Gravity.CENTER));

            Column list = new Column();

            while (contactDetailsCursor.moveToNext()) {
                String mimeType = contactDetailsCursor.getString(contactDetailsCursor.getColumnIndex(ContactsContract.Data.MIMETYPE));
                String detailData = contactDetailsCursor.getString(contactDetailsCursor.getColumnIndex(ContactsContract.Data.DATA1));

                list
                        .child(
                                new Text(mimeType).style(Typography.BODY)
                        )
                        .child(
                                new Text(detailData)
                        );
            }

            display.child(list.allowScroll());
            contactDetailsCursor.close();
        }
        return display;
    }

    @Override
    public void onBackPressed() {
        if (!screen.back()) {
            super.onBackPressed();
        }
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        String[] projection = {
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.PHOTO_URI,
        };

        Cursor cursor =  getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                projection,
                null,
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " ASC"
        );

        while (cursor.moveToNext()) {
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String photoUri = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));

            Contact c = new Contact();
            c.id = contactId;
            c.name = contactName;
            c.uri = photoUri;

            contacts.add(c);
        }

        return contacts;
    }

    public static Bitmap generateAvatar(String initial, int bgColor) {
        int width = 100;
        int height = 100;
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        Paint paint = new Paint();
        paint.setColor(bgColor);
        canvas.drawCircle(width / 2f, height / 2f, width / 2f, paint);

        paint.setColor(Color.textColor());
        paint.setTextSize(40);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(initial, width / 2f, height / 2f + 15, paint);

        return bitmap;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                contacts = getContacts();
                screen.show(contactsScreen());
            } else {
                Toast.makeText(this, "Contacts permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}