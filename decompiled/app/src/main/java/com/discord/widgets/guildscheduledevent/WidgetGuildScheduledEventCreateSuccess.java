package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.experiments.domain.Experiment;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.GuildInviteUiHelper;
import com.discord.widgets.guilds.invite.WidgetInviteModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccessViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\u0004\u0018\u00010\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0016\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0019\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0015R\u001d\u0010\u001e\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\n !*\u0004\u0018\u00010 0 *\u0004\u0018\u00010\u001f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001d\u0010*\u001a\u00020%8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccess;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "viewState", "", "configureUI", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onResume", "()V", "", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()Ljava/lang/Long;", "channelId", "guildScheduledEventId$delegate", "getGuildScheduledEventId", "()J", "guildScheduledEventId", "guildId$delegate", "getGuildId", "guildId", "Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel;", "viewModel", "Lcom/discord/models/domain/ModelInvite;", "", "kotlin.jvm.PlatformType", "getInviteLink", "(Lcom/discord/models/domain/ModelInvite;)Ljava/lang/String;", "inviteLink", "Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", "binding", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventCreateSuccess.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: guildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy guildScheduledEventId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u00072\n\u0010\n\u001a\u00060\u0004j\u0002`\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccess$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "guildScheduledEventId", "", "launch", "(Landroid/content/Context;Ljava/lang/Long;JJ)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, Long channelId, long guildId, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", guildScheduledEventId);
            AppScreen2.d(context, WidgetGuildScheduledEventCreateSuccess.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass1(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildInviteUiHelper.copyLinkClick(outline.x(view, "it", "it.context"), this.$invite, WidgetGuildScheduledEventCreateSuccess.this.getMostRecentIntent());
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Experiment $inviteExperiment;
        public final /* synthetic */ WidgetInviteModel $widgetInviteModel;

        public AnonymousClass2(WidgetInviteModel widgetInviteModel, Experiment experiment) {
            this.$widgetInviteModel = widgetInviteModel;
            this.$inviteExperiment = experiment;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i;
            WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(WidgetGuildScheduledEventCreateSuccess.this).d.toggle();
            ModelInvite.Settings settings = this.$widgetInviteModel.getSettings();
            if (settings != null) {
                WidgetGuildScheduledEventCreateSuccessViewModel widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p = WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess.this);
                CheckedSetting checkedSetting = WidgetGuildScheduledEventCreateSuccess.access$getBinding$p(WidgetGuildScheduledEventCreateSuccess.this).d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
                if (checkedSetting.isChecked()) {
                    i = 0;
                } else {
                    Experiment experiment = this.$inviteExperiment;
                    i = (experiment == null || experiment.getBucket() != 1) ? 86400 : ModelInvite.Settings.SEVEN_DAYS;
                }
                ModelInvite.Settings settingsMergeMaxAge = settings.mergeMaxAge(i);
                Intrinsics3.checkNotNullExpressionValue(settingsMergeMaxAge, "settings.mergeMaxAge(\n  …          }\n            )");
                widgetGuildScheduledEventCreateSuccessViewModelAccess$getViewModel$p.updateInviteSettings(settingsMergeMaxAge);
            }
            Channel targetChannel = this.$widgetInviteModel.getTargetChannel();
            if (targetChannel != null) {
                WidgetGuildScheduledEventCreateSuccess.access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess.this).generateInviteLink(Long.valueOf(Long.valueOf(targetChannel.getId()).longValue()));
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetGuildScheduledEventCreateSuccess.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ModelInvite $invite;

        public AnonymousClass4(ModelInvite modelInvite) {
            this.$invite = modelInvite;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelInvite modelInvite = this.$invite;
            if (modelInvite != null) {
                GuildInviteUiHelper.shareLinkClick(WidgetGuildScheduledEventCreateSuccess.this.getContext(), modelInvite);
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;", "viewState", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventCreateSuccessViewModel$ViewState$Loaded;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetGuildScheduledEventCreateSuccess.access$configureUI(WidgetGuildScheduledEventCreateSuccess.this, loaded);
        }
    }

    public WidgetGuildScheduledEventCreateSuccess() {
        super(R.layout.widget_guild_scheduled_event_create_success);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventCreateSuccess2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess3(this));
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess4(this));
        this.guildScheduledEventId = LazyJVM.lazy(new WidgetGuildScheduledEventCreateSuccess5(this));
        WidgetGuildScheduledEventCreateSuccess6 widgetGuildScheduledEventCreateSuccess6 = new WidgetGuildScheduledEventCreateSuccess6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildScheduledEventCreateSuccessViewModel.class), new WidgetGuildScheduledEventCreateSuccess$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventCreateSuccess6));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess, WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded loaded) {
        widgetGuildScheduledEventCreateSuccess.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventCreateSuccessBinding access$getBinding$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getBinding();
    }

    public static final /* synthetic */ Long access$getChannelId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildScheduledEventId$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getGuildScheduledEventId();
    }

    public static final /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel access$getViewModel$p(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        return widgetGuildScheduledEventCreateSuccess.getViewModel();
    }

    private final void configureUI(WidgetGuildScheduledEventCreateSuccessViewModel.ViewState.Loaded viewState) {
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().c.setOnClickListener(new AnonymousClass1(invite));
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        boolean z2 = settings != null && settings.getMaxAge() == 0;
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.guildInviteNeverExpire");
        checkedSetting.setChecked(z2);
        Experiment defaultInviteExperiment = getViewModel().getDefaultInviteExperiment();
        CheckedSetting.i(getBinding().d, GuildInviteUiHelper.getInviteLinkText(requireContext(), defaultInviteExperiment), false, 2);
        getBinding().d.e(new AnonymousClass2(widgetInviteModel, defaultInviteExperiment));
        getBinding().f2442b.setOnClickListener(new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4(invite));
    }

    private final WidgetGuildScheduledEventCreateSuccessBinding getBinding() {
        return (WidgetGuildScheduledEventCreateSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getChannelId() {
        return (Long) this.channelId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildScheduledEventId() {
        return ((Number) this.guildScheduledEventId.getValue()).longValue();
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildScheduledEventCreateSuccessViewModel getViewModel() {
        return (WidgetGuildScheduledEventCreateSuccessViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<R> observableG = getViewModel().observeViewState().y(WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildScheduledEventCreateSuccess$onResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), WidgetGuildScheduledEventCreateSuccess.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getViewModel().generateInviteLink(getChannelId());
    }
}
