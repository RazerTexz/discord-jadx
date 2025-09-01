package b.a.d;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.R;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;

/* compiled from: AppToast.kt */
/* renamed from: b.a.d.m, reason: use source file name */
/* loaded from: classes.dex */
public final class AppToast {
    public static final void a(Context context, CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        String string = context.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(toastResId)");
        b(context, charSequence, string);
    }

    public static final void b(Context context, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(charSequence2, "toastText");
        Object systemService = context.getSystemService("clipboard");
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        ClipData clipDataNewPlainText = ClipData.newPlainText("", charSequence);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        h(context, charSequence2, 0, null, 12);
    }

    public static /* synthetic */ void c(Context context, CharSequence charSequence, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = R.string.copied_text;
        }
        a(context, charSequence, i);
    }

    public static final void d(Context context, @StringRes int i, int i2, ToastManager toastManager) {
        e(context, context != null ? context.getString(i) : null, i2, toastManager);
    }

    public static final void e(Context context, CharSequence charSequence, int i, ToastManager toastManager) {
        TextView textView;
        if (context != null) {
            Toast toast = new Toast(context);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 2131952606);
            if (charSequence instanceof DraweeSpanStringBuilder) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = new SimpleDraweeSpanTextView(contextThemeWrapper);
                simpleDraweeSpanTextView.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) charSequence);
                textView = simpleDraweeSpanTextView;
            } else {
                TextView textView2 = new TextView(contextThemeWrapper);
                textView2.setText(charSequence);
                textView = textView2;
            }
            toast.setView(textView);
            toast.setDuration(i);
            if (toastManager != null) {
                toastManager.show(toast);
            } else {
                toast.show();
            }
        }
    }

    public static final void f(Fragment fragment, CharSequence charSequence, int i) {
        h(fragment != null ? fragment.getContext() : null, charSequence, i, null, 8);
    }

    public static /* synthetic */ void g(Context context, int i, int i2, ToastManager toastManager, int i3) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        int i4 = i3 & 8;
        d(context, i, i2, null);
    }

    public static /* synthetic */ void h(Context context, CharSequence charSequence, int i, ToastManager toastManager, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            toastManager = null;
        }
        e(context, charSequence, i, toastManager);
    }

    public static void i(Fragment fragment, int i, int i2, int i3) {
        Context context;
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        f(fragment, (fragment == null || (context = fragment.getContext()) == null) ? null : context.getString(i), i2);
    }

    public static /* synthetic */ void j(Fragment fragment, CharSequence charSequence, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        f(fragment, charSequence, i);
    }
}
