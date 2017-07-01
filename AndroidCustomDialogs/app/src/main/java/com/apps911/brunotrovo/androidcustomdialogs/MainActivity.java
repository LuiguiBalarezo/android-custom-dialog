package com.apps911.brunotrovo.androidcustomdialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.apps911.brunotrovo.androidcustomdialogs.dialog.BaseDialog;
import com.apps911.brunotrovo.androidcustomdialogs.dialog.DialogFactory;
import com.apps911.brunotrovo.androidcustomdialogs.dialog.TwoButtonsDialog;

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
        BaseDialog oneButtonDialog =
               DialogFactory.makeSuccessDialog(this,
                       R.string.success_title,
                       R.string.success_message,
                       R.string.success_button_text);
        oneButtonDialog.show(getSupportFragmentManager(), BaseDialog.TAG);
    }

    @OnClick(R.id.btn_error)
    public void onBtnErrorClicked() {
        BaseDialog oneButtonDialog =
                DialogFactory.makeErrorDialog(this,
                        R.string.error_title,
                        R.string.error_message,
                        R.string.error_button_text);
        oneButtonDialog.show(getSupportFragmentManager(), BaseDialog.TAG);
    }

    @OnClick(R.id.btn_yesno)
    public void onBtnChoiceClicked() {

        BaseDialog twoButtonsDialog = DialogFactory.makeConfirmationDialog(this,
                R.string.choice_title,
                R.string.choice_message,
                R.string.choice_positive_button_text,
                R.string.choice_negative_button_text,
                new TwoButtonsDialog.OnTwoButtonsDialogAction() {
                    @Override
                    public void onPositiveButtonClicked() {
                        Toast.makeText(MainActivity.this, "Positive Action", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNegativeButtonClicked() {
                        Toast.makeText(MainActivity.this, "Negative Action", Toast.LENGTH_SHORT).show();
                    }
                });
        twoButtonsDialog.show(getSupportFragmentManager(), BaseDialog.TAG);

    }

}
