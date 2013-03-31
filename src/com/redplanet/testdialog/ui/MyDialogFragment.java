package com.redplanet.testdialog.ui;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Space;
import android.widget.TextView;

import com.redplanet.testdialog.R;
import com.redplanet.testdialog.utils.Log;

public class MyDialogFragment extends DialogFragment implements OnClickListener, OnDismissListener,
        OnCancelListener {

    /**
     * arg1 and arg2 are lower-cost alternatives to using {@link #mDlgExtras} if you only need to
     * store a few integer values. Default value is -1.
     */
    public int arg1 = -1;
    /**
     * arg1 and arg2 are lower-cost alternatives to using {@link #mDlgExtras} if you only need to
     * store a few integer values. Default value is -1.
     */
    public int arg2 = -1;

    private Bundle mDlgExtras;

    public static final int BUTTON_NEGATIVE = 1;
    public static final int BUTTON_POSITIVE = 2;
    public static final int BUTTON_NEUTRAL = 4;

    /**
     * This value is an initial value of a resource ID. It is used to find out whether a title or
     * message will be used. If the resource id keeps this value, it will not be shown or processed.
     */
    public static final int RES_ID_INIT_VALUE = 0;

    private static float EMPTY_VIEW_WEIGHT = 0.1f;

    // These keys are used for extra arguments of the dialog.
    private static final String KEY_ARG_TITLE = "KEY_ARG_TITLE";
    private static final String KEY_ARG_TITLE_RES_ID = "KEY_ARG_TITLE_RES_ID";
    private static final String KEY_ARG_MSG = "KEY_ARG_MSG";
    private static final String KEY_ARG_MSG_RES_ID = "KEY_ARG_MSG_RES_ID";
    private static final String KEY_ARG_POS_TEXT = "KEY_ARG_POS_TEXT";
    private static final String KEY_ARG_NEG_TEXT = "KEY_ARG_NEG_TEXT";
    private static final String KEY_ARG_POS_RES_ID = "KEY_ARG_POS_RES_ID";
    private static final String KEY_ARG_NEG_RES_ID = "KEY_ARG_NEG_RES_ID";
    private static final String KEY_ARG_NEU_TEXT = "KEY_ARG_NEU_TEXT";
    private static final String KEY_ARG_NEU_RES_ID = "KEY_ARG_NEU_RES_ID";
    private static final String KEY_ARG_BUTTONS = "KEY_ARG_BUTTONS";
    private static final String KEY_ARG_MSG_ALIGN = "KEY_ARG_MSG_ALIGN";

    private OnClickListener mOnPosClickListener;
    private OnClickListener mOnNegClickListener;
    private OnClickListener mOnNeuClickListener;

    public interface OnClickListener {

        void onClick(DialogInterface dialog, String tag, int which, int arg1, int arg2,
                Bundle dlgExtras);
    }

    public interface OnDismissListener {

        void onDismiss(DialogInterface dialog, String tag, int arg1, int arg2, Bundle dlgExtras);
    }

    public interface OnCancelListener {

        void onCancel(DialogInterface dialog, String tag, int arg1, int arg2, Bundle dlgExtras);
    }

    public MyDialogFragment() {
        Log.dmn();
    }

    public static MyDialogFragment newInstance(int buttons) {
        return newInstance(RES_ID_INIT_VALUE, RES_ID_INIT_VALUE, buttons);
    }

    public static MyDialogFragment newInstance(int messageId, int buttons) {
        return newInstance(RES_ID_INIT_VALUE, messageId, buttons);
    }

    public static MyDialogFragment newInstance(String message, int buttons) {
        return newInstance(null, message, buttons);
    }

    public static MyDialogFragment newInstance(String title, String message, int buttons) {
        MyDialogFragment ecopsyDialog = new MyDialogFragment();

        Bundle args = new Bundle();
        if (title != null && title.length() != 0) {
            args.putString(KEY_ARG_TITLE, title);
        }
        if (message != null && message.length() != 0) {
            args.putString(KEY_ARG_MSG, message);
        }
        args.putInt(KEY_ARG_BUTTONS, buttons);
        args.putInt(KEY_ARG_MSG_ALIGN, Gravity.LEFT);
        ecopsyDialog.setArguments(args, false);

        return ecopsyDialog;
    }

    public static MyDialogFragment newInstance(int titleId, int messageId, int buttons) {
        MyDialogFragment myDialog = new MyDialogFragment();

        Bundle args = new Bundle();
        if (titleId != RES_ID_INIT_VALUE) {
            args.putInt(KEY_ARG_TITLE_RES_ID, titleId);
        }
        if (messageId != RES_ID_INIT_VALUE) {
            args.putInt(KEY_ARG_MSG_RES_ID, messageId);
        }
        args.putInt(KEY_ARG_BUTTONS, buttons);
        myDialog.setArguments(args, false);

        return myDialog;
    }

    /**
     * Puts a new value which will be used to align a message. Values from {@link Gravity} class are
     * used.
     * 
     * @param alignMessage
     */
    public void setMessageAlignment(int alignMessage) {
        getArguments().putInt(KEY_ARG_MSG_ALIGN, alignMessage);
    }

    public void setPositiveButtonText(int resId) {
        Bundle args = getArguments();
        args.putInt(KEY_ARG_POS_RES_ID, resId);
        args.remove(KEY_ARG_POS_TEXT);
    }

    public void setNegativeButtonText(int resId) {
        Bundle args = getArguments();
        args.putInt(KEY_ARG_NEG_RES_ID, resId);
        args.remove(KEY_ARG_NEG_TEXT);
    }

    public void setPositiveButtonText(String text) {
        Bundle args = getArguments();
        args.putString(KEY_ARG_POS_TEXT, text);
        args.remove(KEY_ARG_POS_RES_ID);
    }

    public void setNegativeButtonText(String text) {
        Bundle args = getArguments();
        args.putString(KEY_ARG_NEG_TEXT, text);
        args.remove(KEY_ARG_NEG_RES_ID);
    }

    public void setNeutralButtonText(String text) {
        Bundle args = getArguments();
        args.putString(KEY_ARG_NEU_TEXT, text);
        args.remove(KEY_ARG_NEU_RES_ID);
    }

    public void setNeutralButtonText(int resId) {
        Bundle args = getArguments();
        args.putInt(KEY_ARG_NEU_RES_ID, resId);
        args.remove(KEY_ARG_NEU_TEXT);
    }

    public void setTitle(int titleId) {
        Bundle args = getArguments();
        args.putInt(KEY_ARG_TITLE_RES_ID, titleId);
        args.remove(KEY_ARG_TITLE);
    }

    public void setMessage(int messageId) {
        Bundle args = getArguments();
        args.putInt(KEY_ARG_MSG_RES_ID, messageId);
        args.remove(KEY_ARG_MSG);
    }

    public void setTitle(String title) {
        Bundle args = getArguments();
        args.putString(KEY_ARG_TITLE, title);
        args.remove(KEY_ARG_TITLE_RES_ID);
    }

    public void setMessage(String message) {
        Bundle args = getArguments();
        args.putString(KEY_ARG_MSG, message);
        args.remove(KEY_ARG_MSG_RES_ID);
    }

    public void setOnPositiveClickListener(OnClickListener listener) {
        mOnPosClickListener = listener;
    }

    public void setOnNegativeClickListener(OnClickListener listener) {
        mOnNegClickListener = listener;
    }

    public void setOnNeutralClickListener(OnClickListener listener) {
        mOnNeuClickListener = listener;
    }

    private OnDismissListener mOnDismissListener;

    public void setOnDismissListener(OnDismissListener listener) {
        mOnDismissListener = listener;
    }

    private OnCancelListener mOnCancelListener;

    public void setOnCancelListener(OnCancelListener listener) {
        mOnCancelListener = listener;
    }

    /**
     * This method adds extended data which can be used when onClick of a button of the dialog is
     * called. Do not confuse with arguments of the dialog.
     * 
     * <br> <br> TODO: if you rotate a screen, will you lose it? It does not matter in this
     * application but makes sense on the whole.
     * 
     * @param extras Given extra data will be added
     */
    public void putExtras(Bundle extras) {
        if (mDlgExtras == null) {
            // Initialize if not initialized yet
            mDlgExtras = new Bundle();
        }
        mDlgExtras.putAll(extras);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.dmn();
        // When you call setStyle(int, int), a based on the style theme will be set
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
    }

    /**
     * This method should be used in this class. Do not use the default method
     * {@link #setArguments(Bundle)} when putting arguments such as {@link #KEY_ARG_BUTTONS}, etc.
     * TODO: it seems that it does not work
     * 
     * @param args
     * @param check
     */
    private void setArguments(Bundle args, boolean check) {
        if (check) {
            String caughtKey = checkArguments(args);
            if (caughtKey != null) {
                throw new IllegalArgumentException(caughtKey + " is reserved by "
                        + MyDialogFragment.class.getName()
                        + ". Please select another value for your key");
            }
        }
        super.setArguments(args);
    }

    @Override
    public void setArguments(Bundle args) {
        setArguments(args, true);
    }

    /**
     * Values {@link #KEY_ARG_TITLE_RES_ID}, {@link #KEY_ARG_TITLE_RES_ID} and other which start
     * with KEY here are reserved and must not be used in {@link #setArguments(Bundle)} when using.
     * 
     * @param args
     * @return
     */
    private String checkArguments(Bundle args) {
        if (args == null) {
            return null;
        }
        if (args.containsKey(KEY_ARG_BUTTONS)) {
            return KEY_ARG_BUTTONS;
        }
        if (args.containsKey(KEY_ARG_MSG)) {
            return KEY_ARG_MSG;
        }
        if (args.containsKey(KEY_ARG_MSG_ALIGN)) {
            return KEY_ARG_MSG_ALIGN;
        }
        if (args.containsKey(KEY_ARG_MSG_RES_ID)) {
            return KEY_ARG_MSG_RES_ID;
        }
        if (args.containsKey(KEY_ARG_NEG_RES_ID)) {
            return KEY_ARG_NEG_RES_ID;
        }
        if (args.containsKey(KEY_ARG_NEG_TEXT)) {
            return KEY_ARG_NEG_TEXT;
        }
        if (args.containsKey(KEY_ARG_POS_RES_ID)) {
            return KEY_ARG_POS_RES_ID;
        }
        if (args.containsKey(KEY_ARG_POS_TEXT)) {
            return KEY_ARG_POS_TEXT;
        }
        if (args.containsKey(KEY_ARG_TITLE)) {
            return KEY_ARG_TITLE;
        }
        if (args.containsKey(KEY_ARG_TITLE_RES_ID)) {
            return KEY_ARG_TITLE_RES_ID;
        }
        // TODO: add KEY_ARG_NEU*
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        Log.dmn();
        View dlgView = inflater.inflate(R.layout.dlg_view, container, false);
        Bundle args = getArguments();

        TextView mTvTitle = (TextView) dlgView.findViewById(R.id.dlgTitle);
        String title = args.getString(KEY_ARG_TITLE);
        if (title == null) {
            int msgId = args.getInt(KEY_ARG_TITLE_RES_ID);
            if (msgId != RES_ID_INIT_VALUE) {
                mTvTitle.setVisibility(View.VISIBLE);
                mTvTitle.setText(msgId);
            }
        } else {
            mTvTitle.setText(title);
            mTvTitle.setVisibility(View.VISIBLE);
        }

        TextView mTvMessage = (TextView) dlgView.findViewById(R.id.dlgMessage);
        String message = args.getString(KEY_ARG_MSG);
        if (message == null) {
            int msgId = args.getInt(KEY_ARG_MSG_RES_ID);
            if (msgId != RES_ID_INIT_VALUE) {
                mTvMessage.setText(msgId);
            }
        } else {
            mTvMessage.setText(message);
        }

        int gravity = args.getInt(KEY_ARG_MSG_ALIGN);
        mTvMessage.setGravity(gravity);

        int buttons = args.getInt(KEY_ARG_BUTTONS);
        switch (buttons) {
        case BUTTON_NEGATIVE:
        case BUTTON_NEUTRAL:
        case BUTTON_POSITIVE:
            Space spaceEmptyLeft = (Space) dlgView.findViewById(R.id.dlgSideViewLeft);
            Space spaceEmptyRight = (Space) dlgView.findViewById(R.id.dlgSideViewRight);
            LayoutParams params =
                    new LayoutParams(0, LayoutParams.MATCH_PARENT, EMPTY_VIEW_WEIGHT * 2.5f);
            spaceEmptyLeft.setLayoutParams(params);
            spaceEmptyRight.setLayoutParams(params);
            break;

        case BUTTON_NEGATIVE | BUTTON_NEUTRAL | BUTTON_POSITIVE:
            // TODO
            break;
        }

        if ((buttons & BUTTON_NEGATIVE) == BUTTON_NEGATIVE) {
            initButtonSnippet(dlgView, args, BUTTON_NEGATIVE);
        }
        if ((buttons & BUTTON_POSITIVE) == BUTTON_POSITIVE) {
            initButtonSnippet(dlgView, args, BUTTON_POSITIVE);
        }
        if ((buttons & BUTTON_NEUTRAL) == BUTTON_NEUTRAL) {
            initButtonSnippet(dlgView, args, BUTTON_NEUTRAL);
        }
        return dlgView;
    }

    private void initButtonSnippet(View dlgView, Bundle args, int buttonCode) {
        Button button = null;
        String text = null;
        int resId = RES_ID_INIT_VALUE;
        switch (buttonCode) {
        case BUTTON_NEGATIVE:
            button = (Button) dlgView.findViewById(R.id.dlgBtnNeg);
            text = args.getString(KEY_ARG_NEG_TEXT);
            resId = args.getInt(KEY_ARG_NEG_RES_ID);
            break;

        case BUTTON_POSITIVE:
            button = (Button) dlgView.findViewById(R.id.dlgBtnPos);
            text = args.getString(KEY_ARG_POS_TEXT);
            resId = args.getInt(KEY_ARG_POS_RES_ID);
            break;

        case BUTTON_NEUTRAL:
            button = (Button) dlgView.findViewById(R.id.dlgBtnNeu);
            text = args.getString(KEY_ARG_NEU_TEXT);
            resId = args.getInt(KEY_ARG_NEU_RES_ID);
            break;
        }
        button.setVisibility(View.VISIBLE);
        if (text == null) {
            if (resId != RES_ID_INIT_VALUE) {
                button.setText(resId);
            }
        } else {
            button.setText(text);
        }
        button.setOnClickListener(this);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mOnDismissListener != null) {
            Log.d("%s", "Calling custom part");
            mOnDismissListener.onDismiss(dialog, getTag(), arg1, arg2, mDlgExtras);
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.dmn();
        if (mOnCancelListener != null) {
            mOnCancelListener.onCancel(dialog, getTag(), arg1, arg2, mDlgExtras);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.dlgBtnNeg:
            Log.d("%s", "BUTTON_NEGATIVE, tag is " + getTag());
            if (mOnNegClickListener != null) {
                mOnNegClickListener.onClick(getDialog(), getTag(), BUTTON_NEGATIVE, arg1, arg2,
                        mDlgExtras);
            }
            break;

        case R.id.dlgBtnPos:
            Log.d("%s", "BUTTON_POSITIVE, tag is " + getTag());
            if (mOnPosClickListener != null) {
                mOnPosClickListener.onClick(getDialog(), getTag(), BUTTON_POSITIVE, arg1, arg2,
                        mDlgExtras);
            }
            break;

        case R.id.dlgBtnNeu:
            Log.d("%s", "BUTTON_NEUTRAL, tag is " + getTag());
            if (mOnNeuClickListener != null) {
                mOnNeuClickListener.onClick(getDialog(), getTag(), BUTTON_NEUTRAL, arg1, arg2,
                        mDlgExtras);
            }
        }
        if (isCancelable()) {
            // Otherwise, cancel yourself
            getDialog().cancel();
        }
    }
}
