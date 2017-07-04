package com.apps911.brunotrovo.androidcustomdialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.apps911.brunotrovo.androidcustomdialogs.dialog.DialogFactory;
import com.apps911.brunotrovo.androidcustomdialogs.dialog.OneButtonDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_success)
    public void onBtnSuccessClicked() {
        OneButtonDialog oneButtonDialog =
               DialogFactory.makeSuccessDialog(this,
                       R.string.success_title,
                       R.string.success_message,
                       R.string.success_button_text);
        oneButtonDialog.show(getSupportFragmentManager(), OneButtonDialog.TAG);
    }

    @OnClick(R.id.btn_error)
    public void onBtnErrorClicked() {
        OneButtonDialog oneButtonDialog =
                DialogFactory.makeErrorDialog(this,
                        R.string.error_title,
                        R.string.error_message,
                        R.string.error_button_text);
        oneButtonDialog.show(getSupportFragmentManager(), OneButtonDialog.TAG);
    }

}
