package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppHelpDesk;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableGuildCommunicationBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.duration.DurationUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetEnableGuildCommunication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u0014J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\n\u0010\n\u001a\u00060\u0002j\u0002`\t2\n\u0010\f\u001a\u00060\u0002j\u0002`\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/WidgetEnableGuildCommunication;", "Lcom/discord/app/AppDialog;", "", "communicationDisabledTimestampMs", "", "username", "", "configureCommunicationDisabledTimer", "(JLjava/lang/CharSequence;)V", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/UserId;", "userId", "handleEnableGuildCommunication", "(JJ)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onDestroy", "()V", "Lrx/Subscription;", "communicationDisabledCountdownSubscription", "Lrx/Subscription;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetEnableGuildCommunication extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableGuildCommunication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableGuildCommunicationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Clock clock;
    private Subscription communicationDisabledCountdownSubscription;

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guildcommunicationdisabled/start/WidgetEnableGuildCommunication$Companion;", "", "", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/primitives/GuildId;", "guildId", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "launch", "(JJLandroidx/fragment/app/FragmentManager;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long userId, long guildId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetEnableGuildCommunication widgetEnableGuildCommunication = new WidgetEnableGuildCommunication();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_USER_ID", userId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            widgetEnableGuildCommunication.setArguments(bundleT);
            widgetEnableGuildCommunication.show(fragmentManager, WidgetEnableGuildCommunication.class.getSimpleName());
            AnalyticsTracker.INSTANCE.viewedEnableCommunicationModal(guildId, userId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ long $communicationDisabledTimestampMs;
        public final /* synthetic */ CharSequence $username;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, CharSequence charSequence) {
            super(1);
            this.$communicationDisabledTimestampMs = j;
            this.$username = charSequence;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            long jMax = Math.max(this.$communicationDisabledTimestampMs - WidgetEnableGuildCommunication.access$getClock$p(WidgetEnableGuildCommunication.this).currentTimeMillis(), 0L);
            TextView textView = WidgetEnableGuildCommunication.access$getBinding$p(WidgetEnableGuildCommunication.this).d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
            Context contextRequireContext = WidgetEnableGuildCommunication.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            FormatUtils.n(textView, R.string.enable_guild_communication_body, new Object[]{this.$username, DurationUtils.humanizeCountdownDuration(contextRequireContext, jMax)}, null, 4);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lrx/Subscription;", Traits.Payment.Type.SUBSCRIPTION, "", "invoke", "(Lrx/Subscription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$configureCommunicationDisabledTimer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetEnableGuildCommunication.access$setCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication.this, subscription);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Ljava/lang/Void;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$handleEnableGuildCommunication$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(1);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Void r1) {
            return invoke2(r1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(Void r7) {
            return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(this.$guildId), Long.valueOf(this.$userId), null, null, null);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$handleEnableGuildCommunication$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r7) {
            WidgetEnableGuildCommunication.this.dismiss();
            Context context = WidgetEnableGuildCommunication.this.getContext();
            Context context2 = WidgetEnableGuildCommunication.this.getContext();
            AppToast.h(context, context2 != null ? FormatUtils.h(context2, R.string.guild_enable_communication_success, new Object[0], null, 4) : null, 0, null, 12);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetEnableGuildCommunication.access$getBinding$p(WidgetEnableGuildCommunication.this).e, "binding.enableGuildCommunicationBodyHelpText", "binding.enableGuildCommu…ationBodyHelpText.context"), AppHelpDesk.a.a(4413305239191L, null), false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableGuildCommunication.this.dismiss();
        }
    }

    /* compiled from: WidgetEnableGuildCommunication.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetEnableGuildCommunication$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        public AnonymousClass3(long j, long j2) {
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableGuildCommunication.access$handleEnableGuildCommunication(WidgetEnableGuildCommunication.this, this.$guildId, this.$userId);
        }
    }

    public WidgetEnableGuildCommunication() {
        super(R.layout.widget_enable_guild_communication);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableGuildCommunication2.INSTANCE, null, 2, null);
        this.clock = ClockFactory.get();
    }

    public static final /* synthetic */ WidgetEnableGuildCommunicationBinding access$getBinding$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.getBinding();
    }

    public static final /* synthetic */ Clock access$getClock$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.clock;
    }

    public static final /* synthetic */ Subscription access$getCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication) {
        return widgetEnableGuildCommunication.communicationDisabledCountdownSubscription;
    }

    public static final /* synthetic */ void access$handleEnableGuildCommunication(WidgetEnableGuildCommunication widgetEnableGuildCommunication, long j, long j2) {
        widgetEnableGuildCommunication.handleEnableGuildCommunication(j, j2);
    }

    public static final /* synthetic */ void access$setCommunicationDisabledCountdownSubscription$p(WidgetEnableGuildCommunication widgetEnableGuildCommunication, Subscription subscription) {
        widgetEnableGuildCommunication.communicationDisabledCountdownSubscription = subscription;
    }

    private final void configureCommunicationDisabledTimer(long communicationDisabledTimestampMs, CharSequence username) {
        if (this.communicationDisabledCountdownSubscription != null) {
            return;
        }
        Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableE, "Observable\n        .inte…0L, 1L, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableE, this, null, 2, null), WidgetEnableGuildCommunication.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(communicationDisabledTimestampMs, username), 58, (Object) null);
    }

    private final WidgetEnableGuildCommunicationBinding getBinding() {
        return (WidgetEnableGuildCommunicationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleEnableGuildCommunication(long guildId, long userId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().disableGuildCommunication(guildId, userId, new RestAPIParams.DisableGuildCommunication(null), null), false, 1, null), new AnonymousClass1(guildId, userId)), this, null, 2, null), WidgetEnableGuildCommunication.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 60, (Object) null);
    }

    public static final void launch(long j, long j2, FragmentManager fragmentManager) {
        INSTANCE.launch(j, j2, fragmentManager);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.communicationDisabledCountdownSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        long j = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j2 = getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_USER_ID", -1L);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreUser users = companion.getUsers();
        GuildMember member = companion.getGuilds().getMember(j, j2);
        User user = users.getUsers().get(Long.valueOf(j2));
        if (member == null || user == null || !member.isCommunicationDisabled()) {
            return;
        }
        CharSequence userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
        UtcDateTime communicationDisabledUntil = member.getCommunicationDisabledUntil();
        long dateTimeMillis = communicationDisabledUntil != null ? communicationDisabledUntil.getDateTimeMillis() : 0L;
        configureCommunicationDisabledTimer(dateTimeMillis, userNameWithDiscriminator$default);
        long jMax = Math.max(dateTimeMillis - this.clock.currentTimeMillis(), 0L);
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableGuildCommunicationBody");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FormatUtils.n(textView, R.string.enable_guild_communication_body, new Object[]{userNameWithDiscriminator$default, DurationUtils.humanizeCountdownDuration(contextRequireContext, jMax)}, null, 4);
        Context context = getContext();
        CharSequence charSequenceH = context != null ? FormatUtils.h(context, R.string.enable_guild_communication_body_help_text, new Object[]{AppHelpDesk.a.a(4413305239191L, null)}, null, 4) : null;
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.enableGuildCommunicationBodyHelpText");
        textView2.setText(charSequenceH);
        getBinding().e.setOnClickListener(new AnonymousClass1());
        getBinding().f2379b.setOnClickListener(new AnonymousClass2());
        getBinding().c.setOnClickListener(new AnonymousClass3(j, j2));
    }
}
