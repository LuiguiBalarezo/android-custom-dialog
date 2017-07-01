package com.apps911.brunotrovo.androidcustomdialogs.dialog;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps911.brunotrovo.androidcustomdialogs.R;

import butterknife.BindView;

/**
 * Created by bruno.trovo on 28/06/2017.
 */

public class TwoButtonsDialog extends BaseDialog {

    private static final String ARG_POSITIVE_BUTTON_TEXT = "ARG_POSITIVE_BUTTON_TEXT";
    private static final String ARG_NEGATIVE_BUTTON_TEXT = "ARG_NEGATIVE_BUTTON_TEXT";

    @BindView(R.id.dlg_two_buttons_iv_icon)
    ImageView ivDialogIcon;

    @BindView(R.id.dlg_two_buttons_tv_title)
    TextView tvTitle;

    @BindView(R.id.dlg_two_buttons_tv_message)
    TextView tvMessage;

    @BindView(R.id.dlg_two_buttons_btn_negative)
    Button btnNegative;

    @BindView(R.id.dlg_two_buttons_btn_positive)
    Button btnPositive;

    private OnTwoButtonsDialogAction onTwoButtonsDialogAction;

    public static TwoButtonsDialog newInstance(String title,
                                               String message,
                                               @DrawableRes int imageResId,
                                               String positiveButtonText,
                                               String negativeButtonText,
                                               OnTwoButtonsDialogAction onTwoButtonsDialogAction) {

        TwoButtonsDialog twoButtonsDialog = new TwoButtonsDialog();
        twoButtonsDialog.onTwoButtonsDialogAction = onTwoButtonsDialogAction;

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_POSITIVE_BUTTON_TEXT, positiveButtonText);
        args.putString(ARG_NEGATIVE_BUTTON_TEXT, negativeButtonText);
        args.putInt(ARG_IMAGE_RESOURCE_ID, imageResId);
        twoButtonsDialog.setArguments(args);

        return twoButtonsDialog;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String title = getArguments().getString(ARG_TITLE, "");
        String message = getArguments().getString(ARG_MESSAGE, "");
        String positiveButtonText = getArguments().getString(ARG_POSITIVE_BUTTON_TEXT, "");
        String negativeButtonText = getArguments().getString(ARG_NEGATIVE_BUTTON_TEXT, "");
        int image = getArguments().getInt(ARG_IMAGE_RESOURCE_ID);

        tvTitle.setText(title);
        tvMessage.setText(message);
        ivDialogIcon.setImageResource(image);

        btnNegative.setText(negativeButtonText);
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
                onTwoButtonsDialogAction.onNegativeButtonClicked();
            }
        });

        btnPositive.setText(positiveButtonText);
        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDialog();
                onTwoButtonsDialogAction.onPositiveButtonClicked();
            }
        });

    }

    @Override
    Boolean getCanceledOnTouchOutside() {
        return false;
    }

    @Override
    protected int getContentView() {
        return R.layout.dialog_two_buttons;
    }

    public interface OnTwoButtonsDialogAction {
        void onPositiveButtonClicked();

        void onNegativeButtonClicked();
    }

}