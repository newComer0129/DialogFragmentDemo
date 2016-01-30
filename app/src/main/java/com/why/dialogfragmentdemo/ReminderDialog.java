package com.why.dialogfragmentdemo;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * * Created by wei-houyu on 2015/12/26.
 */
public class ReminderDialog extends DialogFragment{

    private static final String KEY_HINT = "hint";
    private String mHint;
    static ReminderDialog newInstence(String hint){
        ReminderDialog dialog = new ReminderDialog();

        //you can pass some arguments here
        Bundle bundle = new Bundle();
        bundle.putString(KEY_HINT, hint);
        dialog.setArguments(bundle);

        return dialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.reminder_fragment, container, false );
        TextView tv = (TextView)view.findViewById(R.id.tv_hint);
        Button btn = (Button)view.findViewById(R.id.btn_ok);
        tv.setText(mHint);
        btn.setOnClickListener(new onClickListenter());
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //you can get some argument passed by newInstence
        mHint = getArguments().getString(KEY_HINT);
        super.onCreate(savedInstanceState);
    }

    class onClickListenter implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            dismiss();
        }
    }
}
