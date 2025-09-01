package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetFatalCrash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/debugging/WidgetFatalCrash;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/databinding/WidgetFatalCrashBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetFatalCrashBinding;", "binding", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetFatalCrash extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetFatalCrash.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFatalCrashBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CRASH_SOURCE = "INTENT_EXTRA_CRASH_SOURCE";
    private static final String INTENT_EXTRA_CRASH_TIME = "INTENT_EXTRA_CRASH_TIME";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetFatalCrash.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/discord/widgets/debugging/WidgetFatalCrash$Companion;", "", "", "source", "Landroid/content/Intent;", "createIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", "context", "", "throwable", "crashSource", "", "launch", "(Landroid/content/Context;Ljava/lang/Throwable;Ljava/lang/String;)V", WidgetFatalCrash.INTENT_EXTRA_CRASH_SOURCE, "Ljava/lang/String;", WidgetFatalCrash.INTENT_EXTRA_CRASH_TIME, "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @SuppressLint({"SimpleDateFormat"})
        private final Intent createIntent(String source) {
            Bundle bundle = new Bundle();
            bundle.putString(WidgetFatalCrash.INTENT_EXTRA_CRASH_SOURCE, source);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            bundle.putString(WidgetFatalCrash.INTENT_EXTRA_CRASH_TIME, simpleDateFormat.format(new Date()) + " GMT");
            Intent intentPutExtras = new Intent().putExtras(bundle);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtras, "Intent().putExtras(extras)");
            return intentPutExtras;
        }

        public final void launch(Context context, Throwable throwable, String crashSource) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(throwable, "throwable");
            Intrinsics3.checkNotNullParameter(crashSource, "crashSource");
            AppLog appLog = AppLog.g;
            String simpleName = WidgetFatalCrash.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "WidgetFatalCrash::class.java.simpleName");
            Logger.e$default(appLog, simpleName, new Throwable(crashSource, throwable), null, 4, null);
            AppScreen2.d(context, WidgetFatalCrash.class, createIntent(crashSource));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetFatalCrash() {
        super(R.layout.widget_fatal_crash);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFatalCrash2.INSTANCE, null, 2, null);
    }

    private final WidgetFatalCrashBinding getBinding() {
        return (WidgetFatalCrashBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, Throwable th, String str) {
        INSTANCE.launch(context, th, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.fatalCrashTestersInvite");
        linkifiedTextView.setText(FormatUtils.k(this, R.string.crash_testers_invite, new Object[]{"https://discord.gg/discord-testers"}, null, 4));
        Bundle extras = getMostRecentIntent().getExtras();
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.fatalCrashSource");
        Object[] objArr = new Object[1];
        objArr[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_SOURCE, getString(R.string.status_unknown)) : null;
        textView.setText(FormatUtils.k(this, R.string.crash_source, objArr, null, 4));
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.fatalCrashTime");
        Object[] objArr2 = new Object[1];
        objArr2[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_TIME) : null;
        textView2.setText(FormatUtils.k(this, R.string.crash_timestamp, objArr2, null, 4));
        TextView textView3 = getBinding().f2384b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.fatalCrashAppVersion");
        textView3.setText(FormatUtils.k(this, R.string.crash_app_version, new Object[]{BuildConfig.VERSION_NAME}, null, 4));
        TextView textView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.fatalCrashOsVersion");
        textView4.setText(FormatUtils.k(this, R.string.crash_device_version, new Object[]{String.valueOf(Build.VERSION.SDK_INT)}, null, 4));
        TextView textView5 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.fatalCrashDevice");
        textView5.setText(FormatUtils.k(this, R.string.crash_device, new Object[]{Build.MODEL + ' ' + Build.PRODUCT}, null, 4));
    }
}
