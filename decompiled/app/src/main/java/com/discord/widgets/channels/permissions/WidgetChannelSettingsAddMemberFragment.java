package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b/\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJa\u0010\u000e\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f \r*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\n \r**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f \r*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\n\u0018\u00010\t0\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00108B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R:\u0010\u0017\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00160\u0016 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00160\u0016\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\"R!\u0010(\u001a\u00060\u000bj\u0002`$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020)8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b+\u0010,Rj\u0010.\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f \r*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\n \r**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f \r*\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n0\n\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0018¨\u00061"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragment;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;", "viewState", "", "configureUI", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;)V", "onViewBoundOrOnResume", "()V", "Lrx/subjects/BehaviorSubject;", "", "", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "kotlin.jvm.PlatformType", "getSelectedItemsSubject", "()Lrx/subjects/BehaviorSubject;", "", "showRolesWithGuildPermission$delegate", "Lkotlin/Lazy;", "getShowRolesWithGuildPermission", "()Z", "showRolesWithGuildPermission", "", "querySubject", "Lrx/subjects/BehaviorSubject;", "Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", "binding", "Lcom/discord/widgets/channels/permissions/AddMemberAdapter;", "adapter$delegate", "getAdapter", "()Lcom/discord/widgets/channels/permissions/AddMemberAdapter;", "adapter", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "getChannelId", "()J", "channelId", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel;", "viewModel", "selectedSubject", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsAddMemberFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION = "EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION";

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final BehaviorSubject<String> querySubject;
    private final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedSubject;

    /* renamed from: showRolesWithGuildPermission$delegate, reason: from kotlin metadata */
    private final Lazy showRolesWithGuildPermission;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragment$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "showRolesWithGuildPermission", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragment;", "create", "(JZ)Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragment;", "", "EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final WidgetChannelSettingsAddMemberFragment create(long channelId, boolean showRolesWithGuildPermission) {
            WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = new WidgetChannelSettingsAddMemberFragment();
            widgetChannelSettingsAddMemberFragment.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), Tuples.to(WidgetChannelSettingsAddMemberFragment.access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp(), Boolean.valueOf(showRolesWithGuildPermission))));
            return widgetChannelSettingsAddMemberFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModelAccess$getViewModel$p = WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(WidgetChannelSettingsAddMemberFragment.this);
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            widgetChannelSettingsAddMemberFragmentViewModelAccess$getViewModel$p.updateQuery(str);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetChannelSettingsAddMemberFragment.access$getQuerySubject$p(WidgetChannelSettingsAddMemberFragment.this).onNext(str);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ModelAuditLogEntry.CHANGE_KEY_ID, "Lcom/discord/api/permission/PermissionOverwrite$Type;", "type", "", "invoke", "(JLcom/discord/api/permission/PermissionOverwrite$Type;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, PermissionOverwrite.Type, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, PermissionOverwrite.Type type) {
            invoke(l.longValue(), type);
            return Unit.a;
        }

        public final void invoke(long j, PermissionOverwrite.Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(WidgetChannelSettingsAddMemberFragment.this).toggleItem(j, type);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;", "viewState", "", "invoke", "(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragmentViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsAddMemberFragment.access$configureUI(WidgetChannelSettingsAddMemberFragment.this, viewState);
            WidgetChannelSettingsAddMemberFragment.access$getSelectedSubject$p(WidgetChannelSettingsAddMemberFragment.this).onNext(viewState.getSelected());
        }
    }

    public WidgetChannelSettingsAddMemberFragment() {
        super(R.layout.widget_channel_settings_add_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsAddMemberFragment3.INSTANCE, null, 2, null);
        this.adapter = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment2(this));
        this.channelId = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment4(this));
        this.showRolesWithGuildPermission = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment5(this));
        WidgetChannelSettingsAddMemberFragment6 widgetChannelSettingsAddMemberFragment6 = new WidgetChannelSettingsAddMemberFragment6(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsAddMemberFragmentViewModel.class), new WidgetChannelSettingsAddMemberFragment$appViewModels$$inlined$viewModels$1(widgetChannelSettingsAddMemberFragment6), new AppViewModelDelegates5(new WidgetChannelSettingsAddMemberFragment7(this)));
        this.querySubject = BehaviorSubject.l0("");
        this.selectedSubject = BehaviorSubject.l0(Collections.emptyMap());
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment, WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
        widgetChannelSettingsAddMemberFragment.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberBinding access$getBinding$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getChannelId();
    }

    public static final /* synthetic */ String access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp() {
        return EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION;
    }

    public static final /* synthetic */ BehaviorSubject access$getQuerySubject$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.querySubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getSelectedSubject$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.selectedSubject;
    }

    public static final /* synthetic */ boolean access$getShowRolesWithGuildPermission$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getShowRolesWithGuildPermission();
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel access$getViewModel$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getViewModel();
    }

    private final void configureUI(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
        getAdapter().setData(viewState.getItems());
    }

    private final AddMemberAdapter getAdapter() {
        return (AddMemberAdapter) this.adapter.getValue();
    }

    private final WidgetChannelSettingsAddMemberBinding getBinding() {
        return (WidgetChannelSettingsAddMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final boolean getShowRolesWithGuildPermission() {
        return ((Boolean) this.showRolesWithGuildPermission.getValue()).booleanValue();
    }

    private final WidgetChannelSettingsAddMemberFragmentViewModel getViewModel() {
        return (WidgetChannelSettingsAddMemberFragmentViewModel) this.viewModel.getValue();
    }

    public final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> getSelectedItemsSubject() {
        return this.selectedSubject;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<String> observableR = this.querySubject.p(200L, TimeUnit.MILLISECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "querySubject\n        .de…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().c.setText(getViewModel().getQuery());
        getBinding().c.a(this, new AnonymousClass2());
        getAdapter().setOnClickListener(new AnonymousClass3());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
    }
}
