package com.apps911.brunotrovo.androidcustomdialogs.dialog;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps911.brunotrovo.androidcustomdialogs.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bruno.trovo on 28/06/2017.
 */

public class OneButtonDialog extends DialogFragment {

    public static final String TAG = "OneButtonDialogTag";

    protected static final String ARG_BUTTON_TEXT = "ARG_BUTTON_TEXT";
    protected static final String ARG_COLOR_RESOURCE_ID = "ARG_COLOR_RESOURCE_ID";
    protected static final String ARG_TITLE = "ARG_TITLE";
    protected static final String ARG_MESSAGE = "ARG_MESSAGE";
    protected static final String ARG_IMAGE_RESOURCE_ID = "ARG_IMAGE_RESOURCE_ID";

    private static final double DIALOG_WINDOW_WIDTH = 0.85;

    @BindView(R.id.dlg_one_button_iv_icon)
    ImageView ivDialogIcon;

    @BindView(R.id.dlg_one_button_tv_title)
    TextView tvTitle;

    @BindView(R.id.dlg_one_button_tv_message)
    TextView tvMessage;

    @BindView(R.id.dlg_one_button_btn_neutral)
    Button btnNeutral;

    private int getContentView() {
        return R.layout.dialog_one_button;
    }

    private boolean getCanceledOnTouchOutside() {
        return true;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Window window = getDialog().getWindow();
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE);
        }

        View view = inflater.inflate(getContentView(), container, false);
        ButterKnife.bind(this, view);

        getDialog().setCanceledOnTouchOutside(getCanceledOnTouchOutside());

        return view;

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
    public void onStart() {
        super.onStart();
        setDialogWindowWidth(DIALOG_WINDOW_WIDTH);
    }

    private void setDialogWindowWidth(double width) {
        Window window = getDialog().getWindow();
        Point size = new Point();

        Display display;
        if (window != null) {
            display = window.getWindowManager().getDefaultDisplay();
            display.getSize(size);

            int maxWidth = size.x;

            window.setLayout((int) (maxWidth* width), WindowManager.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
        }

    }

    @OnClick(R.id.dlg_one_button_btn_neutral)
    public void onNeutralButtonClicked() {
        closeDialog();
    }

    public void closeDialog() {
        if (getDialog().isShowing()) {
            closeKeyboard();
            getDialog().dismiss();
        }
    }

    protected void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(
                getActivity().findViewById(android.R.id.content).getWindowToken(), 0);
    }

}
