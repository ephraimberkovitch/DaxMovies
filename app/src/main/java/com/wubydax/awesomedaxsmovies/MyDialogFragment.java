package com.wubydax.awesomedaxsmovies;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialogFragment extends DialogFragment {
    AlertDialog.Builder mBuilder;


    public MyDialogFragment() {
        // Required empty public constructor
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context c = getActivity();
        Bundle params = getArguments();
        String mContent = params.getString("content", null);
        mBuilder = new AlertDialog.Builder(c);
        switch(mContent){
            case("NoConnection"):
               buildDialog(c.getString(R.string.device_offline_title), c.getString(R.string.device_offline_message));
                break;
            case("NoData"):
                buildDialog(c.getString(R.string.no_data_title), c.getString(R.string.no_data_message));
                break;


        }

        AlertDialog dialog = mBuilder.create();
        return dialog;
    }

    private void buildDialog(String title, String message){
        mBuilder.setTitle(title)
                .setMessage(message)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getActivity().finish();
                    }
                });
    }

}
