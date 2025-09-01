package com.discord.widgets.notice;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetNoticeDialogBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetNoticeDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 12\u00020\u0001:\u0003231B\u0007¢\u0006\u0004\b/\u00100J)\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\n¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR<\u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\"\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/discord/widgets/notice/WidgetNoticeDialog;", "Lcom/discord/app/AppDialog;", "Landroid/os/Bundle;", "", "key", "", "index", "insertLayoutInBundle", "(Landroid/os/Bundle;Ljava/lang/String;I)Ljava/lang/Integer;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "logOnStartError", "(Ljava/lang/Exception;)V", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "Lcom/discord/databinding/WidgetNoticeDialogBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetNoticeDialogBinding;", "binding", "", "Lkotlin/Function1;", "listenerMap", "Ljava/util/Map;", "getListenerMap", "()Ljava/util/Map;", "setListenerMap", "(Ljava/util/Map;)V", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnDismiss", "()Lkotlin/jvm/functions/Function0;", "setOnDismiss", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "Companion", "ActionLinkMovementMethod", "Builder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNoticeDialog extends AppDialog {
    private static final String ARG_ABOVE_LAYOUT_ID = "above_layout_id";
    private static final String ARG_BELOW_LAYOUT_ID = "below_layout_id";
    private static final String ARG_BODY_TEXT = "body_text";
    private static final String ARG_BODY_TEXT_ALIGNMENT = "body_text_alignment";
    private static final String ARG_CANCELABLE = "cancelable";
    private static final String ARG_CANCEL_TEXT = "cancel_text";
    private static final String ARG_HEADER_TEXT = "header_text";
    private static final String ARG_NOTICE_TYPE = "notice_type";
    private static final String ARG_OK_TEXT = "ok_text";
    private static final String ARG_STACK_TRACE_CALLER_FRAME = "stack_trace_caller_frame";
    private static final String ARG_THEME_ID = "theme_id";
    public static final int CANCEL_BUTTON = 2131364550;
    public static final int OK_BUTTON = 2131364555;
    public static final int ON_SHOW = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Map<Integer, ? extends Function1<? super View, Unit>> listenerMap;
    private Function0<Unit> onDismiss;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNoticeDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetNoticeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/discord/widgets/notice/WidgetNoticeDialog$ActionLinkMovementMethod;", "Landroid/text/method/LinkMovementMethod;", "Landroid/widget/TextView;", "widget", "Landroid/text/Spannable;", "buffer", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z", "Lkotlin/Function0;", "", "linkAction", "Lkotlin/jvm/functions/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ActionLinkMovementMethod extends LinkMovementMethod {
        private final Function0<Unit> linkAction;

        public ActionLinkMovementMethod(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "linkAction");
            this.linkAction = function0;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            Intrinsics3.checkNotNullParameter(widget, "widget");
            Intrinsics3.checkNotNullParameter(buffer, "buffer");
            Intrinsics3.checkNotNullParameter(event, "event");
            boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
            if (event.getAction() == 1) {
                this.linkAction.invoke();
            }
            return zOnTouchEvent;
        }
    }

    /* compiled from: WidgetNoticeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b1\u00102J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ+\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\b\b\u0001\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\bJ+\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\n2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0015\u0010\u0010J-\u0010\u0015\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0019\u0010&\u001a\u00020%8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\"R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010+R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010.R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010.R\u0016\u0010/\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "setTitle", "(Ljava/lang/CharSequence;)Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "", "stringResId", "(I)Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "setMessage", "", "Lkotlin/Function1;", "Landroid/view/View;", "", "onConfirm", "setPositiveButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "(ILkotlin/jvm/functions/Function1;)Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "theme", "setDialogAttrTheme", "onCancel", "setNegativeButton", "tag", "setTag", "(Ljava/lang/String;)Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "", WidgetNoticeDialog.ARG_CANCELABLE, "setCancelable", "(Z)Lcom/discord/widgets/notice/WidgetNoticeDialog$Builder;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "show", "(Landroidx/fragment/app/FragmentManager;)V", "message", "Ljava/lang/CharSequence;", "themeId", "Ljava/lang/Integer;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "title", "Ljava/lang/String;", "confirmText", "cancelText", "Lkotlin/jvm/functions/Function1;", "isCancelable", "Z", "<init>", "(Landroid/content/Context;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        private String cancelText;
        private String confirmText;
        private final Context context;
        private boolean isCancelable;
        private CharSequence message;
        private Function1<? super View, Unit> onCancel;
        private Function1<? super View, Unit> onConfirm;
        private String tag;
        private Integer themeId;
        private CharSequence title;

        public Builder(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            this.context = context;
            this.title = "";
            this.message = "";
            this.confirmText = "";
            this.cancelText = "";
            this.onConfirm = WidgetNoticeDialog$Builder$onConfirm$1.INSTANCE;
            this.onCancel = WidgetNoticeDialog$Builder$onCancel$1.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setNegativeButton$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setNegativeButton$1.INSTANCE;
            }
            return builder.setNegativeButton(str, (Function1<? super View, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setPositiveButton$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setPositiveButton$1.INSTANCE;
            }
            return builder.setPositiveButton(str, (Function1<? super View, Unit>) function1);
        }

        public final Context getContext() {
            return this.context;
        }

        public final Builder setCancelable(boolean cancelable) {
            this.isCancelable = cancelable;
            return this;
        }

        public final Builder setDialogAttrTheme(@AttrRes int theme) {
            this.themeId = Integer.valueOf(theme);
            return this;
        }

        public final Builder setMessage(CharSequence text) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.message = text;
            return this;
        }

        public final Builder setNegativeButton(String text, Function1<? super View, Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(onCancel, "onCancel");
            this.cancelText = text;
            this.onCancel = onCancel;
            return this;
        }

        public final Builder setPositiveButton(String text, Function1<? super View, Unit> onConfirm) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(onConfirm, "onConfirm");
            this.confirmText = text;
            this.onConfirm = onConfirm;
            return this;
        }

        public final Builder setTag(String tag) {
            Intrinsics3.checkNotNullParameter(tag, "tag");
            this.tag = tag;
            return this;
        }

        public final Builder setTitle(CharSequence text) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.title = text;
            return this;
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Companion.show$default(WidgetNoticeDialog.INSTANCE, fragmentManager, this.title, this.message, this.confirmText, this.cancelText, Maps6.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), this.onConfirm), Tuples.to(Integer.valueOf(R.id.notice_cancel), this.onCancel)), null, null, null, this.themeId, null, null, 0, null, 15808, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setNegativeButton$default(Builder builder, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setNegativeButton$2.INSTANCE;
            }
            return builder.setNegativeButton(i, (Function1<? super View, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setPositiveButton$default(Builder builder, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setPositiveButton$2.INSTANCE;
            }
            return builder.setPositiveButton(i, (Function1<? super View, Unit>) function1);
        }

        public final Builder setMessage(@StringRes int stringResId) {
            this.message = FormatUtils.h(this.context, stringResId, new Object[0], null, 4);
            return this;
        }

        public final Builder setTitle(@StringRes int stringResId) {
            String string = this.context.getString(stringResId);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
            this.title = string;
            return this;
        }

        public final Builder setNegativeButton(@StringRes int stringResId, Function1<? super View, Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(onCancel, "onCancel");
            String string = this.context.getString(stringResId);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
            this.cancelText = string;
            this.onCancel = onCancel;
            return this;
        }

        public final Builder setPositiveButton(@StringRes int stringResId, Function1<? super View, Unit> onConfirm) {
            Intrinsics3.checkNotNullParameter(onConfirm, "onConfirm");
            String string = this.context.getString(stringResId);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
            this.confirmText = string;
            this.onConfirm = onConfirm;
            return this;
        }
    }

    /* compiled from: WidgetNoticeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b8\u00109JÉ\u0001\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0018\u001a\u00020\n2\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0085\u0001\u0010&\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0 2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00192\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0010\u001a\u00020$2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010%\u001a\u00020\u0014¢\u0006\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010)R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010)R\u0016\u0010.\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010)R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00100\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010)R\u0016\u00101\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010)R\u0016\u00102\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010)R\u0016\u00103\u001a\u00020\u00168\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010)R\u0016\u00104\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u00107\u001a\u00020\n8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u00105¨\u0006:"}, d2 = {"Lcom/discord/widgets/notice/WidgetNoticeDialog$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "headerText", "bodyText", "goText", "cancelText", "", "", "Lkotlin/Function1;", "Landroid/view/View;", "", "listenerMap", "Lcom/discord/stores/StoreNotices$Dialog$Type;", "type", "aboveLayoutId", "belowLayoutId", "dialogTheme", "", WidgetNoticeDialog.ARG_CANCELABLE, "", "tag", "bodyTextAlignment", "Lkotlin/Function0;", "onDismiss", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/util/Map;Lcom/discord/stores/StoreNotices$Dialog$Type;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "Lcom/discord/app/AppActivity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "hintText", "Lkotlin/Function2;", "Landroid/content/Context;", "onOKClicked", "onCancelClicked", "Lcom/discord/stores/StoreNotices$InputDialog$Type;", "shouldHideKeyboard", "showInputModal", "(Lcom/discord/app/AppActivity;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Ljava/lang/Boolean;Lcom/discord/stores/StoreNotices$InputDialog$Type;Ljava/lang/CharSequence;Z)V", "ARG_ABOVE_LAYOUT_ID", "Ljava/lang/String;", "ARG_BELOW_LAYOUT_ID", "ARG_BODY_TEXT", "ARG_BODY_TEXT_ALIGNMENT", "ARG_CANCELABLE", "ARG_CANCEL_TEXT", "ARG_HEADER_TEXT", "ARG_NOTICE_TYPE", "ARG_OK_TEXT", "ARG_STACK_TRACE_CALLER_FRAME", "ARG_THEME_ID", "CANCEL_BUTTON", "I", "OK_BUTTON", "ON_SHOW", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, StoreNotices.Dialog.Type type, Integer num, Integer num2, Integer num3, Boolean bool, String str, int i, Function0 function0, int i2, Object obj) {
            companion.show(fragmentManager, (i2 & 2) != 0 ? null : charSequence, charSequence2, charSequence3, (i2 & 16) != 0 ? null : charSequence4, (i2 & 32) != 0 ? null : map, (i2 & 64) != 0 ? null : type, (i2 & 128) != 0 ? null : num, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : num3, (i2 & 1024) != 0 ? null : bool, (i2 & 2048) != 0 ? null : str, (i2 & 4096) != 0 ? 2 : i, (i2 & 8192) != 0 ? null : function0);
        }

        public static /* synthetic */ void showInputModal$default(Companion companion, AppActivity appActivity, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function2 function2, Function0 function0, Boolean bool, StoreNotices.InputDialog.Type type, CharSequence charSequence4, boolean z2, int i, Object obj) {
            companion.showInputModal(appActivity, charSequence, charSequence2, charSequence3, function2, (i & 32) != 0 ? null : function0, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? StoreNotices.InputDialog.Type.PASSWORD : type, (i & 256) != 0 ? null : charSequence4, (i & 512) != 0 ? false : z2);
        }

        public final void show(FragmentManager fragmentManager, CharSequence headerText, CharSequence bodyText, CharSequence goText, CharSequence cancelText, Map<Integer, ? extends Function1<? super View, Unit>> listenerMap, StoreNotices.Dialog.Type type, @LayoutRes Integer aboveLayoutId, @LayoutRes Integer belowLayoutId, Integer dialogTheme, Boolean cancelable, String tag, int bodyTextAlignment, Function0<Unit> onDismiss) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(bodyText, "bodyText");
            WidgetNoticeDialog widgetNoticeDialog = new WidgetNoticeDialog();
            widgetNoticeDialog.setListenerMap(listenerMap);
            widgetNoticeDialog.setOnDismiss(onDismiss);
            Bundle bundle = new Bundle();
            bundle.putCharSequence(WidgetNoticeDialog.ARG_HEADER_TEXT, headerText);
            bundle.putCharSequence(WidgetNoticeDialog.ARG_BODY_TEXT, bodyText);
            bundle.putCharSequence(WidgetNoticeDialog.ARG_OK_TEXT, goText);
            bundle.putCharSequence(WidgetNoticeDialog.ARG_CANCEL_TEXT, cancelText);
            if (type != null) {
                bundle.putString(WidgetNoticeDialog.ARG_NOTICE_TYPE, type.name());
            }
            if (aboveLayoutId != null) {
                bundle.putInt(WidgetNoticeDialog.ARG_ABOVE_LAYOUT_ID, aboveLayoutId.intValue());
            }
            if (belowLayoutId != null) {
                bundle.putInt(WidgetNoticeDialog.ARG_BELOW_LAYOUT_ID, belowLayoutId.intValue());
            }
            if (dialogTheme != null) {
                bundle.putInt(WidgetNoticeDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            if (cancelable != null) {
                bundle.putBoolean(WidgetNoticeDialog.ARG_CANCELABLE, cancelable.booleanValue());
            }
            bundle.putInt(WidgetNoticeDialog.ARG_BODY_TEXT_ALIGNMENT, bodyTextAlignment);
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
            StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
            String string = stackTrace.length > 4 ? stackTrace[4].toString() : "";
            Intrinsics3.checkNotNullExpressionValue(string, "if (stacktrace.size > 4)…ace[4].toString() else \"\"");
            bundle.putString(WidgetNoticeDialog.ARG_STACK_TRACE_CALLER_FRAME, string);
            widgetNoticeDialog.setArguments(bundle);
            if (tag == null) {
                tag = WidgetNoticeDialog.class.getSimpleName();
            }
            widgetNoticeDialog.show(fragmentManager, tag);
        }

        public final void showInputModal(AppActivity activity, CharSequence headerText, CharSequence bodyText, CharSequence hintText, Function2<? super Context, ? super String, Unit> onOKClicked, Function0<Unit> onCancelClicked, Boolean cancelable, StoreNotices.InputDialog.Type type, CharSequence goText, boolean shouldHideKeyboard) {
            CharSequence charSequence;
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            Intrinsics3.checkNotNullParameter(bodyText, "bodyText");
            Intrinsics3.checkNotNullParameter(hintText, "hintText");
            Intrinsics3.checkNotNullParameter(onOKClicked, "onOKClicked");
            Intrinsics3.checkNotNullParameter(type, "type");
            HashMap map = new HashMap();
            map.put(Integer.valueOf(R.id.notice_ok), new WidgetNoticeDialog$Companion$showInputModal$1(onOKClicked, shouldHideKeyboard));
            if (onCancelClicked != null) {
                map.put(Integer.valueOf(R.id.notice_cancel), new WidgetNoticeDialog$Companion$showInputModal$2(onCancelClicked, shouldHideKeyboard));
            }
            map.put(0, new WidgetNoticeDialog$Companion$showInputModal$3(hintText));
            boolean z2 = type == StoreNotices.InputDialog.Type.PASSWORD;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Integer numValueOf = Integer.valueOf(z2 ? R.layout.view_input_modal_password : R.layout.view_input_modal_text_no_suggestions);
            if (goText != null) {
                charSequence = goText;
            } else {
                String string = activity.getString(R.string.confirm);
                Intrinsics3.checkNotNullExpressionValue(string, "activity.getString(R.string.confirm)");
                charSequence = string;
            }
            show$default(this, supportFragmentManager, headerText, bodyText, charSequence, activity.getString(R.string.cancel), map, null, null, numValueOf, null, cancelable, null, 0, null, 15040, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNoticeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.WidgetNoticeDialog$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetNoticeDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetNoticeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.WidgetNoticeDialog$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetNoticeDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.notice.WidgetNoticeDialog$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetNoticeDialog.this.dismiss();
        }
    }

    public WidgetNoticeDialog() {
        super(R.layout.widget_notice_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoticeDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeDialogBinding getBinding() {
        return (WidgetNoticeDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Integer insertLayoutInBundle(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(bundle.getInt(str));
        if (!(numValueOf.intValue() != 0)) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        getBinding().f2500b.addView(getLayoutInflater().inflate(numValueOf.intValue(), (ViewGroup) getBinding().f2500b, false), i);
        return numValueOf;
    }

    public static /* synthetic */ Integer insertLayoutInBundle$default(WidgetNoticeDialog widgetNoticeDialog, Bundle bundle, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return widgetNoticeDialog.insertLayoutInBundle(bundle, str, i);
    }

    public static final void show(FragmentManager fragmentManager, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map<Integer, ? extends Function1<? super View, Unit>> map, StoreNotices.Dialog.Type type, @LayoutRes Integer num, @LayoutRes Integer num2, Integer num3, Boolean bool, String str, int i, Function0<Unit> function0) {
        INSTANCE.show(fragmentManager, charSequence, charSequence2, charSequence3, charSequence4, map, type, num, num2, num3, bool, str, i, function0);
    }

    public final Map<Integer, Function1<View, Unit>> getListenerMap() {
        return this.listenerMap;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void logOnStartError(Exception exception) {
        Intrinsics3.checkNotNullParameter(exception, "exception");
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(ARG_STACK_TRACE_CALLER_FRAME) : null;
        Logger.e$default(AppLog.g, "failed to start WidgetNoticeDialog from " + serializable, exception, null, 4, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources.Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        super.onDismiss(dialog);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Map<Integer, ? extends Function1<? super View, Unit>> map;
        Function1<? super View, Unit> function1;
        String string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        setCancelable(arguments != null ? arguments.getBoolean(ARG_CANCELABLE, true) : true);
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(ARG_NOTICE_TYPE)) != null) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            Intrinsics3.checkNotNullExpressionValue(string, "it");
            notices.markDialogSeen(string);
        }
        Bundle arguments3 = getArguments();
        CharSequence charSequence = arguments3 != null ? arguments3.getCharSequence(ARG_HEADER_TEXT) : null;
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        textView.setText(charSequence);
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility((charSequence == null || StringsJVM.isBlank(charSequence)) ^ true ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        Bundle arguments4 = getArguments();
        linkifiedTextView.setText(arguments4 != null ? arguments4.getCharSequence(ARG_BODY_TEXT) : null);
        if (isCancelable()) {
            LinkifiedTextView linkifiedTextView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
            linkifiedTextView2.setMovementMethod(new ActionLinkMovementMethod(new AnonymousClass2()));
        }
        LinkifiedTextView linkifiedTextView3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.noticeBodyText");
        Bundle arguments5 = getArguments();
        linkifiedTextView3.setTextAlignment(arguments5 != null ? arguments5.getInt(ARG_BODY_TEXT_ALIGNMENT) : 2);
        MaterialButton materialButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        Bundle arguments6 = getArguments();
        ViewExtensions.setTextAndVisibilityBy(materialButton, arguments6 != null ? arguments6.getCharSequence(ARG_OK_TEXT) : null);
        Bundle arguments7 = getArguments();
        CharSequence charSequence2 = arguments7 != null ? arguments7.getCharSequence(ARG_CANCEL_TEXT) : null;
        MaterialButton materialButton2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, charSequence2);
        Bundle arguments8 = getArguments();
        if (arguments8 != null) {
            insertLayoutInBundle(arguments8, ARG_ABOVE_LAYOUT_ID, 0);
        }
        Bundle arguments9 = getArguments();
        if (arguments9 != null) {
            LinearLayout linearLayout2 = getBinding().f2500b;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.noticeBodyContainer");
            insertLayoutInBundle(arguments9, ARG_BELOW_LAYOUT_ID, linearLayout2.getChildCount());
        }
        getBinding().g.setOnClickListener(new AnonymousClass4());
        getBinding().d.setOnClickListener(new AnonymousClass5());
        Map<Integer, ? extends Function1<? super View, Unit>> map2 = this.listenerMap;
        if (map2 != null) {
            for (Map.Entry<Integer, ? extends Function1<? super View, Unit>> entry : map2.entrySet()) {
                View viewFindViewById = view.findViewById(entry.getKey().intValue());
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(new WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1(entry, this, view));
                }
            }
        }
        if (getContext() == null || (map = this.listenerMap) == null || (function1 = map.get(0)) == null) {
            return;
        }
        function1.invoke(view);
    }

    public final void setListenerMap(Map<Integer, ? extends Function1<? super View, Unit>> map) {
        this.listenerMap = map;
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }
}
