package com.apps911.brunotrovo.androidcustomdialogs.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.apps911.brunotrovo.androidcustomdialogs.R;

/**
 * Created by bruno.trovo on 28/06/2017.
 */

public class DialogFactory {

    private DialogFactory() { }

    private static OneButtonDialog makeSuccessDialog(String title,
                                                     String message,
                                                     String buttonText) {

        return OneButtonDialog.newInstance(title,
                message,
                buttonText,
                R.drawable.ic_checked,
                R.color.green_500);

    }

    public static OneButtonDialog makeSuccessDialog(@NonNull Context context,
                                                    @StringRes int titleId,
                                                    @StringRes int messageId,
                                                    @StringRes int buttonTextId) {

        return makeSuccessDialog(context.getResources().getString(titleId),
                context.getString(messageId),
                context.getString(buttonTextId));

    }


    private static OneButtonDialog makeErrorDialog(String title,
                                                   String message,
                                                   String buttonText) {

        return OneButtonDialog.newInstance(title,
                message,
                buttonText,
                R.drawable.ic_close,
                R.color.red_500);

    }

    public static OneButtonDialog makeErrorDialog(@NonNull Context context,
                                                  @StringRes int titleId,
                                                  @StringRes int messageId,
                                                  @StringRes int buttonTextId) {

        return makeErrorDialog(context.getResources().getString(titleId),
                context.getString(messageId),
                context.getString(buttonTextId));

    }

}