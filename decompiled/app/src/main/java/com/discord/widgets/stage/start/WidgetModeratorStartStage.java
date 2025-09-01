package com.discord.widgets.stage.start;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import com.discord.widgets.stage.start.ModeratorStartStageViewModel;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
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

/* compiled from: WidgetModeratorStartStage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001b\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u000e\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R$\u0010*\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010(0(0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00100\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/discord/widgets/stage/start/WidgetModeratorStartStage;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;)V", "configureToolbar", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "item", "handleListItemClick", "(Lcom/discord/widgets/stage/start/ModeratorStartStageItem;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "launchStageCall", "(J)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "guildId$delegate", "Lkotlin/Lazy;", "getGuildId", "()J", "guildId", "channelId$delegate", "getChannelId", "Lcom/discord/widgets/stage/start/ModeratorStartStageAdapter;", "adapter", "Lcom/discord/widgets/stage/start/ModeratorStartStageAdapter;", "Lcom/discord/databinding/WidgetModeratorStartStageBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetModeratorStartStageBinding;", "binding", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "previewLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel;", "viewModel", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetModeratorStartStage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetModeratorStartStage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ModeratorStartStageAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetModeratorStartStage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\b\u001a\u00060\u0004j\u0002`\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/stage/start/WidgetModeratorStartStage$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/GuildId;", "guildId", "", "launch", "(Landroid/content/Context;JJ)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetModeratorStartStage.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$handleListItemClick$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetModeratorStartStage widgetModeratorStartStage = WidgetModeratorStartStage.this;
            WidgetModeratorStartStage.access$launchStageCall(widgetModeratorStartStage, WidgetModeratorStartStage.access$getChannelId$p(widgetModeratorStartStage));
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "p1", "", "invoke", "(Lcom/discord/widgets/stage/start/ModeratorStartStageItem;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModeratorStartStageItem, Unit> {
        public AnonymousClass1(WidgetModeratorStartStage widgetModeratorStartStage) {
            super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "handleListItemClick", "handleListItemClick(Lcom/discord/widgets/stage/start/ModeratorStartStageItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageItem moderatorStartStageItem) {
            invoke2(moderatorStartStageItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModeratorStartStageItem moderatorStartStageItem) {
            Intrinsics3.checkNotNullParameter(moderatorStartStageItem, "p1");
            WidgetModeratorStartStage.access$handleListItemClick((WidgetModeratorStartStage) this.receiver, moderatorStartStageItem);
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetModeratorStartStage.access$getViewModel$p(WidgetModeratorStartStage.this).disconnectFromStage();
            FragmentActivity activity = WidgetModeratorStartStage.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModeratorStartStageViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetModeratorStartStage widgetModeratorStartStage) {
            super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "configureUi", "configureUi(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModeratorStartStageViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetModeratorStartStage.access$configureUi((WidgetModeratorStartStage) this.receiver, viewState);
        }
    }

    public WidgetModeratorStartStage() {
        super(R.layout.widget_moderator_start_stage);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetModeratorStartStage2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetModeratorStartStage3(this));
        this.guildId = LazyJVM.lazy(new WidgetModeratorStartStage4(this));
        WidgetModeratorStartStage6 widgetModeratorStartStage6 = new WidgetModeratorStartStage6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ModeratorStartStageViewModel.class), new WidgetModeratorStartStage$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetModeratorStartStage6));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetModeratorStartStage5(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetModeratorStartStage widgetModeratorStartStage, ModeratorStartStageViewModel.ViewState viewState) {
        widgetModeratorStartStage.configureUi(viewState);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetModeratorStartStage widgetModeratorStartStage) {
        return widgetModeratorStartStage.getChannelId();
    }

    public static final /* synthetic */ ModeratorStartStageViewModel access$getViewModel$p(WidgetModeratorStartStage widgetModeratorStartStage) {
        return widgetModeratorStartStage.getViewModel();
    }

    public static final /* synthetic */ void access$handleListItemClick(WidgetModeratorStartStage widgetModeratorStartStage, ModeratorStartStageItem moderatorStartStageItem) {
        widgetModeratorStartStage.handleListItemClick(moderatorStartStageItem);
    }

    public static final /* synthetic */ void access$launchStageCall(WidgetModeratorStartStage widgetModeratorStartStage, long j) {
        widgetModeratorStartStage.launchStageCall(j);
    }

    private final void configureToolbar(ModeratorStartStageViewModel.ViewState viewState) {
        CallEventsButtonView callEventsButtonView = getBinding().d;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        callEventsButtonView.a(parentFragmentManager, getGuildId(), getChannelId(), viewState.getChannelEvents());
    }

    private final void configureUi(ModeratorStartStageViewModel.ViewState viewState) {
        if (viewState.getChannelEventActive()) {
            launchStageCall(getChannelId());
            return;
        }
        configureToolbar(viewState);
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        moderatorStartStageAdapter.setData(viewState.getItems());
    }

    private final WidgetModeratorStartStageBinding getBinding() {
        return (WidgetModeratorStartStageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ModeratorStartStageViewModel getViewModel() {
        return (ModeratorStartStageViewModel) this.viewModel.getValue();
    }

    private final void handleListItemClick(ModeratorStartStageItem item) {
        if (item instanceof ModeratorStartStageItem.ListItem.StaticOption.StartStage) {
            WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, getChannelId(), new AnonymousClass1());
            return;
        }
        if (item instanceof ModeratorStartStageItem.ListItem.StaticOption.ScheduleEvent) {
            WidgetGuildScheduledEventLocationSelect.INSTANCE.launch(requireContext(), getGuildId(), Long.valueOf(getChannelId()));
            return;
        }
        if (!(item instanceof ModeratorStartStageItem.ListItem.Event)) {
            if (item instanceof ModeratorStartStageItem.Continue) {
                launchStageCall(getChannelId());
            }
        } else {
            ModeratorStartStageItem.ListItem.Event event = (ModeratorStartStageItem.ListItem.Event) item;
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(WidgetPreviewGuildScheduledEvent.INSTANCE, requireContext(), GuildScheduledEventModel2.toModel(event.getEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(event.getEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), this.previewLauncher, false, 16, null);
        }
    }

    private final void launchStageCall(long channelId) {
        WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), channelId, true, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = new ModeratorStartStageAdapter(recyclerView, new AnonymousClass1(this));
        RecyclerView recyclerView2 = getBinding().c;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(moderatorStartStageAdapter);
        getBinding().f2497b.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetModeratorStartStage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
