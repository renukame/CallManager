package com.ar.callmanager.activity;

import android.app.FragmentManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.ar.callmanager.R;
import com.ar.callmanager.database.BlackManager;
import com.ar.callmanager.database.ContactManager;
import com.ar.callmanager.database.WhiteManager;
import com.ar.callmanager.fragment.AddContactFragment;
import com.ar.callmanager.fragment.BlackFragment;
import com.ar.callmanager.fragment.ContactFragment;
import com.ar.callmanager.fragment.WhiteFragment;

import static com.ar.callmanager.R.id.fab;

public class MainActivity extends AppCompatActivity {

    private ContactManager contactManager;
    private WhiteManager whiteManager;
    private BlackManager blackManager;
    private BottomNavigationView bottomNavigationView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        contactManager = new ContactManager(getApplicationContext());
        whiteManager = new WhiteManager(getApplicationContext());
        blackManager = new BlackManager(getApplicationContext());
        getContactData();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_contacts  :
                        getFragmentManager().beginTransaction().replace(R.id.frame,new ContactFragment()).commit();
                        break;
                    case R.id.action_black :
                        getFragmentManager().beginTransaction().replace(R.id.frame,new BlackFragment()).commit();
                        break;
                    case R.id.action_white :
                        getFragmentManager().beginTransaction().replace(R.id.frame,new WhiteFragment()).commit();
                        break;
                }

                return false;
            }
        });
        floatingActionButton = (FloatingActionButton) findViewById(fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                AddContactFragment addDialog = new AddContactFragment();
                addDialog.setRetainInstance(true);
                addDialog.show(fm, "fragment_name");
        }
        });
        getFragmentManager().beginTransaction().add(R.id.frame,new ContactFragment()).commit();
    }

    public void getContactData(){
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactManager.writeContacts(phoneNumber,name);
        }
        phones.close();
    }

}
