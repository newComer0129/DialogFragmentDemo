package com.why.dialogfragmentdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button btnShowDialog;
    ReminderDialog mReminderDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();

    }

    @Override
    protected void onResume() {
        super.onResume();
        initOnClickListener();
        btnShowDialog.setOnClickListener(mOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initButton(){
        btnShowDialog = (Button)findViewById(R.id.btn_show_dialog);
    }

    private void initOnClickListener(){
        mOnClickListener = new onClickListener();
    }

    private onClickListener mOnClickListener;
    class onClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.btn_show_dialog:
                    mReminderDialog = ReminderDialog.newInstence(getString(R.string.show_toast_message));
                    mReminderDialog.show(getFragmentManager().beginTransaction(), "ReminderDialog");
                    break;

            }
        }
    }
}
