package com.discord.utilities.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import java.io.Closeable;
import kotlin.Metadata;

/* compiled from: ToastManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0011J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0017¢\u0006\u0004\b\b\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/view/ToastManager;", "Ljava/io/Closeable;", "Landroid/content/Context;", "context", "", "stringRes", "duration", "", "show", "(Landroid/content/Context;II)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "(Landroid/content/Context;Ljava/lang/CharSequence;I)V", "Landroid/widget/Toast;", "newToast", "(Landroid/widget/Toast;)V", "close", "()V", "toast", "Landroid/widget/Toast;", "<init>", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class ToastManager implements Closeable {
    private Toast toast;

    public static /* synthetic */ void show$default(ToastManager toastManager, Context context, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        toastManager.show(context, i, i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Toast toast = this.toast;
        if (toast != null) {
            toast.cancel();
        }
        this.toast = null;
    }

    @MainThread
    public final void show(Context context, @StringRes int i) {
        show$default(this, context, i, 0, 4, (Object) null);
    }

    @MainThread
    public final void show(Context context, @StringRes int stringRes, int duration) {
        Intrinsics3.checkNotNullParameter(context, "context");
        show(context, context.getString(stringRes), duration);
    }

    @SuppressLint({"ShowToast"})
    @MainThread
    public void show(Context context, CharSequence text, int duration) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Toast toastMakeText = Toast.makeText(context, text, duration);
        Intrinsics3.checkNotNullExpressionValue(toastMakeText, "Toast.makeText(context, text, duration)");
        show(toastMakeText);
    }

    public static /* synthetic */ void show$default(ToastManager toastManager, Context context, CharSequence charSequence, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            toastManager.show(context, charSequence, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
    }

    @MainThread
    public void show(Toast newToast) {
        Intrinsics3.checkNotNullParameter(newToast, "newToast");
        Toast toast = this.toast;
        if (toast != null) {
            toast.cancel();
        }
        newToast.show();
        this.toast = newToast;
    }
}
