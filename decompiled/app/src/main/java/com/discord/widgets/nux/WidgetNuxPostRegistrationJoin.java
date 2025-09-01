package com.discord.widgets.nux;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import com.discord.R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetNuxPostRegistrationJoin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/widgets/nux/WidgetNuxPostRegistrationJoin;", "Lcom/discord/widgets/guilds/join/WidgetGuildJoin;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin extends WidgetGuildJoin {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NUX_FLOW_TYPE = "Mobile NUX Post Reg";
    private static final String NUX_STEP = "Ask to join";

    /* compiled from: WidgetNuxPostRegistrationJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/discord/widgets/nux/WidgetNuxPostRegistrationJoin$Companion;", "", "Landroid/content/Context;", "context", "", "show", "(Landroid/content/Context;)V", "", "NUX_FLOW_TYPE", "Ljava/lang/String;", "NUX_STEP", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetNuxPostRegistrationJoin.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNuxPostRegistrationJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $startTimeMs;

        public AnonymousClass1(long j) {
            this.$startTimeMs = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetNuxPostRegistrationJoin.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
            if (StringsJVM.isBlank(ViewExtensions.getTextOrEmpty(textInputLayout))) {
                AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Friend List", Long.valueOf(this.$startTimeMs), true);
                FragmentActivity activity = WidgetNuxPostRegistrationJoin.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                    return;
                }
                return;
            }
            AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Accept Instant Invite", Long.valueOf(this.$startTimeMs), false);
            WidgetNuxPostRegistrationJoin.access$handleGuildJoin(WidgetNuxPostRegistrationJoin.this);
            FragmentActivity activity2 = WidgetNuxPostRegistrationJoin.this.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    /* compiled from: WidgetNuxPostRegistrationJoin.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetNuxPostRegistrationJoin.this.getBinding().f2423b.setText(StringsJVM.isBlank(editable) ? R.string.nux_post_reg_join_server_skip : R.string.join);
        }
    }

    public WidgetNuxPostRegistrationJoin() {
        super(R.layout.widget_nux_post_registration);
    }

    public static final /* synthetic */ void access$handleGuildJoin(WidgetNuxPostRegistrationJoin widgetNuxPostRegistrationJoin) {
        widgetNuxPostRegistrationJoin.handleGuildJoin();
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, NUX_FLOW_TYPE, GuildTemplateAnalytics.STEP_REGISTRATION, NUX_STEP, null, false, 24, null);
        getBinding().f2423b.setOnClickListener(new AnonymousClass1(ClockFactory.get().currentTimeMillis()));
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
    }
}
