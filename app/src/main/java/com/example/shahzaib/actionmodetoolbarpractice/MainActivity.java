package com.example.shahzaib.actionmodetoolbarpractice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    ActionMode actionMode;
    ActionModeCallback actionModeCallback;
    int count = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Normal Toolbar");
        actionModeCallback = new ActionModeCallback();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.normal_toolbar_menu,menu);
        return true;
    }



    public void switchToNormalToolbar(View view)
    {
//        Toast.makeText(this, "Normal Button Pressed", Toast.LENGTH_SHORT).show();

        if(actionMode!=null)
        {
            actionMode.finish();
            actionMode = null;
        }
        else
        {
            getSupportActionBar().setTitle(""+ (++count));
        }

    }



    public void switchToActionToolbar(View view)
    {
//        Toast.makeText(this, "Action Button Pressed", Toast.LENGTH_SHORT).show();
        if(actionMode==null)
        {
            actionMode = startSupportActionMode(actionModeCallback);
            count = 0;
        }
        else
        {
            actionMode.setTitle(""+ (++count));
        }

    }
















    private class ActionModeCallback implements ActionMode.Callback
    {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.action_toolbar_menu,menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
            getSupportActionBar().setTitle("");
            count = 0;
        }
    }

}
