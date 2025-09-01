package com.discord.widgets.guilds.join;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreInviteSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildJoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0011\u0012\b\b\u0003\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0013\u001a\u00020\u000e8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildJoin;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "handleGuildJoin", "()V", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "Lcom/discord/databinding/WidgetGuildJoinBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildJoinBinding;", "binding", "", "contentResId", "<init>", "(I)V", "Companion", "ToolbarButton", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class WidgetGuildJoin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildJoin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetGuildJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildJoin$Companion;", "", "Landroid/content/Context;", "context", "", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "", "show", "(Landroid/content/Context;Ljava/lang/String;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, String location) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            AnalyticsTracker.openModal$default("Join Guild", location, null, 4, null);
            AppScreen2.e(context, ToolbarButton.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/guilds/join/WidgetGuildJoin$ToolbarButton;", "Lcom/discord/widgets/guilds/join/WidgetGuildJoin;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ToolbarButton extends WidgetGuildJoin {
        public ToolbarButton() {
            super(0, 1, null);
        }

        @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
        public void onViewBound(View view) {
            Window window;
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewBound(view);
            AnalyticsTracker.INSTANCE.joinGuildViewed();
            AppActivity appActivity = getAppActivity();
            if (appActivity == null || (window = appActivity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(36);
        }
    }

    /* compiled from: WidgetGuildJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/widget/TextView;", "it", "", "invoke", "(Landroid/widget/TextView;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildJoin$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetGuildJoin.this.handleGuildJoin();
        }
    }

    /* compiled from: WidgetGuildJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.join.WidgetGuildJoin$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildJoin.this.handleGuildJoin();
        }
    }

    public WidgetGuildJoin() {
        this(0, 1, null);
    }

    public WidgetGuildJoin(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildJoin2.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetGuildJoin3.INSTANCE, 3);
    }

    public final WidgetGuildJoinBinding getBinding() {
        return (WidgetGuildJoinBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleGuildJoin() {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (textOrEmpty.length() > 0) {
            Intent intentSelectInvite = IntentUtils.RouteBuilders.INSTANCE.selectInvite(textOrEmpty, StoreInviteSettings.LOCATION_JOIN);
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildJoinInvite");
            Context context = textInputLayout2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.guildJoinInvite.context");
            IntentUtils.consumeRoutingIntent$default(intentUtils, intentSelectInvite, context, null, 4, null);
        }
    }

    @Override // com.discord.app.AppFragment
    @CallSuper
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass1(), 1, null);
        getBinding().f2423b.setOnClickListener(new AnonymousClass2());
    }

    public /* synthetic */ WidgetGuildJoin(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_guild_join : i);
    }
}
