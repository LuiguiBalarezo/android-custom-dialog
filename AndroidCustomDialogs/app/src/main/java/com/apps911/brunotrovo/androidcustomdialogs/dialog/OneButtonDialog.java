package com.apps911.brunotrovo.androidcustomdialogs.dialog;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps911.brunotrovo.androidcustomdialogs.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by bruno.trovo on 28/06/2017.
 */

public class OneButtonDialog extends BaseDialog {

    protected static final String ARG_BUTTON_TEXT = "ARG_BUTTON_TEXT";
    protected static final String ARG_COLOR_RESOURCE_ID = "ARG_COLOR_RESOURCE_ID";


    @BindView(R.id.dlg_one_button_iv_icon)
    ImageView ivDialogIcon;

    @BindView(R.id.dlg_one_button_tv_title)
    TextView tvTitle;

    @BindView(R.id.dlg_one_button_tv_message)
    TextView tvMessage;

    @BindView(R.id.dlg_one_button_btn_neutral)
    Button btnNeutral;

    @Override
    protected int getContentView() {
        return R.layout.dialog_one_button;
    }

    public static OneButtonDialog newInstance(String title,
                                              String message,
                                              String buttonText,
                                              @DrawableRes int imageResId,
                                              @ColorRes int colorResId) {
        OneButtonDialog oneButtonDialog = new OneButtonDialog();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_BUTTON_TEXT, buttonText);
        args.putInt(ARG_IMAGE_RESOURCE_ID, imageResId);
        args.putInt(ARG_COLOR_RESOURCE_ID, colorResId);
        oneButtonDialog.setArguments(args);
        return oneButtonDialog;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String title = getArguments().getString(ARG_TITLE, "");
        String message = getArguments().getString(ARG_MESSAGE, "");
        String buttonText = getArguments().getString(ARG_BUTTON_TEXT, "");
        int image = getArguments().getInt(ARG_IMAGE_RESOURCE_ID);
        int color = getArguments().getInt(ARG_COLOR_RESOURCE_ID);

        tvTitle.setText(title);
        tvTitle.setTextColor(getResources().getColor(color));
        tvMessage.setText(message);
        btnNeutral.setText(buttonText);
        ivDialogIcon.setImageResource(image);

    }

    @Override
    Boolean getCanceledOnTouchOutside() {
        return true;
    }

    @OnClick(R.id.dlg_one_button_btn_neutral)
    public void onNeutralButtonClicked() {
        closeDialog();
    }

}
