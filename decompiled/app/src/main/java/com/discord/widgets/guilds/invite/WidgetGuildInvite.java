package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInvitePageBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.GuildInviteViewModel;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.google.android.material.button.MaterialButton;
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

/* compiled from: WidgetGuildInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u00020\u001e8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInvite;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loaded;", "viewState", "", "configureLoadedUI", "(Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState$Loaded;)V", "Lcom/discord/utilities/error/Error;", "e", "configureUIFailure", "(Lcom/discord/utilities/error/Error;)V", "Lcom/discord/models/domain/ModelInvite;", "invite", "trackAndConsumeDynamicLinkCache", "(Lcom/discord/models/domain/ModelInvite;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "configureUI", "(Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;)V", "Lcom/discord/widgets/guilds/invite/GuildInviteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guilds/invite/GuildInviteViewModel;", "viewModel", "Lcom/discord/databinding/WidgetGuildInvitePageBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildInvitePageBinding;", "binding", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "inviteCode", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildInvite extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInvite.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInvitePageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CODE = "EXTRA_CODE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StoreInviteSettings.InviteCode inviteCode;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetGuildInvite$Companion;", "", "Landroid/content/Context;", "context", "Lcom/discord/stores/StoreInviteSettings$InviteCode;", "inviteCode", "", "launch", "(Landroid/content/Context;Lcom/discord/stores/StoreInviteSettings$InviteCode;)V", "", WidgetGuildInvite.EXTRA_CODE, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, StoreInviteSettings.InviteCode inviteCode) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
            Intent intent = new Intent();
            intent.putExtra(WidgetGuildInvite.EXTRA_CODE, inviteCode);
            AppScreen2.d(context, WidgetGuildInvite.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws Exception {
            AppActivity appActivity = WidgetGuildInvite.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* compiled from: WidgetGuildInvite.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/guilds/invite/GuildInviteViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildInviteViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildInviteViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildInviteViewModel.ViewState viewState) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGuildInvite.this.configureUI(viewState);
        }
    }

    public WidgetGuildInvite() {
        super(R.layout.widget_guild_invite_page);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInvite2.INSTANCE, null, 2, null);
        WidgetGuildInvite4 widgetGuildInvite4 = new WidgetGuildInvite4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildInviteViewModel.class), new WidgetGuildInvite$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInvite4));
        this.inviteCode = (StoreInviteSettings.InviteCode) getMostRecentIntent().getParcelableExtra(EXTRA_CODE);
    }

    public static final /* synthetic */ void access$configureUIFailure(WidgetGuildInvite widgetGuildInvite, Error error) {
        widgetGuildInvite.configureUIFailure(error);
    }

    private final void configureLoadedUI(GuildInviteViewModel.ViewState.Loaded viewState) throws Resources.NotFoundException {
        boolean z2;
        GuildScheduledEventModel model;
        ModelInvite invite = viewState.getInvite();
        getBinding().d.configureUI(invite, new WidgetGuildInvite3(this, invite));
        GuildScheduledEventItemView guildScheduledEventItemView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildInviteEventInfo");
        GuildScheduledEvent guildScheduledEvent = invite.getGuildScheduledEvent();
        if (guildScheduledEvent == null || (model = GuildScheduledEventModel2.toModel(guildScheduledEvent)) == null) {
            z2 = false;
        } else {
            getBinding().c.configureAsPreview(model, invite.getChannel(), GuildScheduledEventUtilities5.getCreatorUserGuildMember$default(model, (StoreGuilds) null, (StoreUser) null, 3, (Object) null));
            z2 = true;
        }
        guildScheduledEventItemView.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f2416b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteCancel");
        materialButton.setVisibility(8);
    }

    private final void configureUIFailure(Error e) {
        MaterialButton materialButton = getBinding().f2416b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteCancel");
        materialButton.setVisibility(0);
        getBinding().d.configureUIFailure(e);
        trackAndConsumeDynamicLinkCache(null);
    }

    private final WidgetGuildInvitePageBinding getBinding() {
        return (WidgetGuildInvitePageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildInviteViewModel getViewModel() {
        return (GuildInviteViewModel) this.viewModel.getValue();
    }

    private final void trackAndConsumeDynamicLinkCache(ModelInvite invite) {
        String source;
        String inviteCode;
        String source2;
        StoreStream.INSTANCE.getInviteSettings().clearInviteCode();
        if (getViewModel().getInviteResolved()) {
            return;
        }
        getViewModel().setInviteResolved(true);
        String str = "";
        if (invite == null) {
            StoreInviteSettings.InviteCode inviteCode2 = this.inviteCode;
            String str2 = (inviteCode2 == null || (inviteCode = inviteCode2.getInviteCode()) == null) ? "" : inviteCode;
            StoreInviteSettings.InviteCode inviteCode3 = this.inviteCode;
            AnalyticsTracker.inviteResolveFailed$default(str2, (inviteCode3 == null || (source = inviteCode3.getSource()) == null) ? "" : source, null, null, 12, null);
            return;
        }
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreInviteSettings.InviteCode inviteCode4 = this.inviteCode;
        if (inviteCode4 != null && (source2 = inviteCode4.getSource()) != null) {
            str = source2;
        }
        analyticsTracker.inviteResolved(invite, str);
    }

    public final void configureUI(GuildInviteViewModel.ViewState viewState) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState instanceof GuildInviteViewModel.ViewState.Invalid) {
            configureUIFailure(null);
        } else if (viewState instanceof GuildInviteViewModel.ViewState.Loaded) {
            GuildInviteViewModel.ViewState.Loaded loaded = (GuildInviteViewModel.ViewState.Loaded) viewState;
            trackAndConsumeDynamicLinkCache(loaded.getInvite());
            configureLoadedUI(loaded);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
        analyticsTracker.impressionInviteAccept(inviteCode != null ? inviteCode.getInviteCode() : null);
        getBinding().f2416b.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getViewModel().fetchInviteIfNotLoaded();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildInvite.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
