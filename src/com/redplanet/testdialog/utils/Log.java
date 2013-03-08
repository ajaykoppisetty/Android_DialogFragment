package com.redplanet.testdialog.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;

/**
 * The class is based on {@link android.util.Log} <br /> The order in terms of verbosity, from least
 * to most is ERROR, WARN, INFO, DEBUG, VERBOSE. Verbose should never be compiled into an
 * application except during development. Debug logs are compiled in but stripped at runtime. Error,
 * warning and info logs are always kept.
 * 
 * @author Megadarja <br /> <a
 * href="http://megadarja.blogspot.ru/2012/11/androidlogwrapper.html">http
 * ://megadarja.blogspot.ru/2012/11/androidlogwrapper.html</a>
 */
@SuppressLint("DefaultLocale")
@SuppressWarnings("unused")
public class Log {

    /*
     * If you want a tag is not to be logged, make it an empty string
     */
    private static final String TAG = "Test_Dialog";

    private static final boolean LOCATION_ENABLED = true;

    private static final int ERROR = android.util.Log.ERROR;
    private static final int WARN = android.util.Log.WARN;
    private static final int INFO = android.util.Log.INFO;
    private static final int DEBUG = android.util.Log.DEBUG;
    private static final int VERBOSE = android.util.Log.VERBOSE;

    private static final int LEVEL = VERBOSE;

    public static String tag(String tag) {
        return TAG + "-" + tag;
    }

    public static void vt(String tag, String format, Object... args) {
        if (LEVEL <= VERBOSE && !tag.isEmpty()) {
            android.util.Log.v(tag, getLocation() + String.format(format, args));
        }
    }

    public static void dt(String tag, String format, Object... args) {
        if (LEVEL <= DEBUG && !tag.isEmpty()) {
            android.util.Log.d(tag, getLocation() + String.format(format, args));
        }
    }

    /**
     * Show only the method name and the line where it was inserted. Uses {@link VERBOSE} level.
     * 
     * @param tag
     */
    public static void vmn(String tag) {
        if (LEVEL <= VERBOSE && !tag.isEmpty()) {
            android.util.Log.v(tag, getLocation());
        }
    }

    /**
     * @see Log#dmn(String). Uses {@link TAG} as log tag.
     */
    public static void vmn() {
        vmn(TAG);
    }

    /**
     * Show only the method name and the line where it was inserted. Uses {@link DEBUG} level.
     * 
     * @param tag
     */
    public static void dmn(String tag) {
        if (LEVEL <= DEBUG && !tag.isEmpty()) {
            android.util.Log.d(tag, getLocation());
        }
    }

    /**
     * @see Log#dmn(String). Uses {@link TAG} as log tag.
     */
    public static void dmn() {
        dmn(TAG);
    }

    /**
     * Show only the method name and the line where it was inserted. Uses {@link INFO} level.
     * 
     * @param tag
     */
    public static void imn(String tag) {
        if (LEVEL <= INFO && !tag.isEmpty()) {
            android.util.Log.d(tag, getLocation());
        }
    }

    /**
     * @see Log#imn(String). Uses {@link TAG} as log tag.
     */
    public static void imn() {
        imn(TAG);
    }

    public static void it(String tag, String format, Object... args) {
        if (LEVEL <= INFO && !tag.isEmpty()) {
            android.util.Log.i(tag, getLocation() + String.format(format, args));
        }
    }

    public static void wt(String tag, String format, Object... args) {
        if (LEVEL <= WARN && !tag.isEmpty()) {
            android.util.Log.w(tag, getLocation() + String.format(format, args));
        }
    }

    public static void wt(String tag, String message, Throwable e) {
        if (LEVEL <= WARN && !tag.isEmpty()) {
            android.util.Log.w(tag, getLocation() + message, e);
        }
    }

    public static void wt(String tag, Throwable e) {
        if (LEVEL <= WARN && !tag.isEmpty()) {
            android.util.Log.w(tag, e);
        }
    }

    public static void et(String tag, Throwable e) {
        if (LEVEL <= ERROR && !tag.isEmpty()) {
            android.util.Log.e(tag, getLocation() + e.getMessage(), e);
        }
    }

    public static void et(String tag, String format, Object... args) {
        if (LEVEL <= ERROR && !tag.isEmpty()) {
            android.util.Log.e(tag, getLocation() + String.format(format, args));
        }
    }

    public static void v(String format, Object... args) {
        vt(TAG, format, args);
    }

    public static void d(String format, Object... args) {
        dt(TAG, format, args);
    }

    public static void i(String format, Object... args) {
        it(TAG, format, args);
    }

    public static void w(String format, Object... args) {
        wt(TAG, format, args);
    }

    public static void w(String message, Throwable e) {
        wt(TAG, message, e);
    }

    public static void w(Throwable e) {
        wt(TAG, e);
    }

    public static void e(String format, Object... args) {
        et(TAG, format, args);
    }

    public static void e(Throwable e) {
        et(TAG, e);
    }

    public static void vtrace(int traceLength, String format, Object... args) {
        vtrace(TAG, traceLength, format, args);
    }

    public static void dtrace(int traceLength, String format, Object... args) {
        dtrace(TAG, traceLength, format, args);
    }

    public static void itrace(int traceLength, String format, Object... args) {
        itrace(TAG, traceLength, format, args);
    }

    public static void wtrace(int traceLength, String format, Object... args) {
        wtrace(TAG, traceLength, format, args);
    }

    public static void etrace(int traceLength, String format, Object... args) {
        etrace(TAG, traceLength, format, args);
    }

    public static void vtrace(String tag, int traceLength, String format, Object... args) {
        if (LEVEL <= VERBOSE && !tag.isEmpty()) {
            android.util.Log.v(tag, String.format(format, args) + getTrace(traceLength));
        }
    }

    public static void dtrace(String tag, int traceLength, String format, Object... args) {
        if (LEVEL <= DEBUG && !tag.isEmpty()) {
            android.util.Log.d(tag, String.format(format, args) + getTrace(traceLength));
        }
    }

    public static void itrace(String tag, int traceLength, String format, Object... args) {
        if (LEVEL <= INFO && !tag.isEmpty()) {
            android.util.Log.i(tag, String.format(format, args) + getTrace(traceLength));
        }
    }

    public static void wtrace(String tag, int traceLength, String format, Object... args) {
        if (LEVEL <= WARN && !tag.isEmpty()) {
            android.util.Log.w(tag, String.format(format, args) + getTrace(traceLength));
        }
    }

    public static void etrace(String tag, int traceLength, String format, Object... args) {
        if (LEVEL <= ERROR && !tag.isEmpty()) {
            android.util.Log.e(tag, String.format(format, args) + getTrace(traceLength));
        }
    }

    private static String getTrace(int length) {
        if (!LOCATION_ENABLED)
            return "";

        final String logClassName = Log.class.getName();
        final StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        int foundIndex = -1;

        for (int i = 0; i < traces.length; i++) {
            StackTraceElement trace = traces[i];

            if (trace.getClassName().startsWith(logClassName)) {
                foundIndex = i;
            } else {
                if (foundIndex > 0)
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = foundIndex + 1; i < foundIndex + length + 1; ++i) {
            if (i > traces.length)
                break;

            StackTraceElement trace = traces[i];
            sb.append(String.format("    at %s.%s:%s\n", trace.getClassName(),
                    trace.getMethodName(), trace.getLineNumber()));
        }
        sb.delete(sb.length() - 1, sb.length());
        return "\n" + sb.toString();
    }

    private static String getLocation() {
        if (!LOCATION_ENABLED)
            return "";

        final String logClassName = Log.class.getName();
        final StackTraceElement[] traces = Thread.currentThread().getStackTrace();
        boolean found = false;

        for (int i = 0; i < traces.length; i++) {
            StackTraceElement trace = traces[i];

            try {
                if (found) {
                    if (!trace.getClassName().startsWith(logClassName)) {
                        Class<?> clazz = Class.forName(trace.getClassName());

                        String clazzName = clazz.getSimpleName();
                        if (TextUtils.isEmpty(clazzName))
                            clazzName = clazz.getName();

                        return String.format("[%s.%s:%d] ", clazzName, trace.getMethodName(),
                                trace.getLineNumber());
                    }
                }
                else if (trace.getClassName().startsWith(logClassName)) {
                    found = true;
                }
            } catch (ClassNotFoundException e) {}
        }

        return "[] ";
    }
}
