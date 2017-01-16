package com.ar.callmanager.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ar.callmanager.R;
import com.ar.callmanager.database.BlackManager;
import com.ar.callmanager.database.ContactManager;
import com.ar.callmanager.database.WhiteManager;


public class AddContactFragment extends DialogFragment {
    private EditText name;
    private EditText number;
    private Button add;
    Fragment fragment;
    private WhiteManager whiteManager;
    private BlackManager blackManager;
    private ContactManager contactManager;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Contact");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_add,null);
        builder.setView(view);
        builder.setCancelable(true);
        whiteManager = new WhiteManager(getActivity());
        blackManager = new BlackManager(getActivity());
        contactManager = new ContactManager(getActivity());
        fragment = getActivity().getFragmentManager().findFragmentById(R.id.frame);
        name = (EditText) view.findViewById(R.id.name);
        number = (EditText) view.findViewById(R.id.number);
        add = (Button) view.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if(fragment instanceof ContactFragment){
                    contactManager.writeContacts(name.getText().toString(),number.getText().toString());
                    Toast.makeText(getActivity(),"ContactFragment",Toast.LENGTH_LONG).show();
                }else if(fragment instanceof WhiteFragment){
                    whiteManager.writeWhiteData(name.getText().toString(),number.getText().toString());
                    Toast.makeText(getActivity(),"WhiteFragment",Toast.LENGTH_LONG).show();
                }else if(fragment instanceof BlackFragment){
                    blackManager.writeBlackData(name.getText().toString(),number.getText().toString());
                    Toast.makeText(getActivity(),"BlackFragment",Toast.LENGTH_LONG).show();
                }
            }
        });
        return builder.create();
    }

}
