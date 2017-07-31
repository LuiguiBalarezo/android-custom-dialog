package com.apps911.brunotrovo.androidcustomdialogs;

import android.support.annotation.StringRes;

/**
 * Created by bruno.trovo on 28/06/2017.
 */

class DialogFactory {

    private DialogFactory() {
    }

    static OneButtonDialog makeSuccessDialog(@StringRes int titleId,
                                             @StringRes int messageId,
                                             @StringRes int buttonTextId,
                                             OneButtonDialog.ButtonDialogAction action) {
        return OneButtonDialog.newInstance(titleId,
                messageId,
                buttonTextId,
                R.drawable.ic_checked,
                R.color.green_500,
                action);
    }

    static OneButtonDialog makeErrorDialog(@StringRes int titleId,
                                           @StringRes int messageId,
                                           @StringRes int buttonTextId,
                                           OneButtonDialog.ButtonDialogAction action) {
        return OneButtonDialog.newInstance(titleId,
                messageId,
                buttonTextId,
                R.drawable.ic_close,
                R.color.red_500,
                action);
    }

}