package com.discord.widgets.directories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.i.WidgetDirectoryChannelEmptyBinding;
import b.a.k.FormatUtils;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.models.guild.Guild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.discord.widgets.hubs.WidgetHubAddName;
import com.discord.widgets.hubs.WidgetHubAddNameViewModel3;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.google.android.material.tabs.TabLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetDirectoryChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\f\u001a\u00020\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001e\u001a\u00020\u00198F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R$\u0010$\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001d\u0010*\u001a\u00020&8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoryChannel;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "state", "", "configureUi", "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)V", "", "showTabLayout", "toggleHeaderMargins", "(Z)V", "Lcom/discord/databinding/WidgetDirectoryChannelBinding;", "binding", "onViewBindingDestroy", "(Lcom/discord/databinding/WidgetDirectoryChannelBinding;)V", "onViewBoundOrOnResume", "()V", "initializeUI", "bind", "bindGestureObservers", "(ZLcom/discord/databinding/WidgetDirectoryChannelBinding;)V", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetDirectoryChannelBinding;", "Lcom/discord/widgets/directories/WidgetDirectoriesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/directories/WidgetDirectoriesViewModel;", "viewModel", "hasBound", "Z", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "activityResult", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/widgets/directories/WidgetDirectoryChannelViewPagerAdapter;", "adapter$delegate", "getAdapter", "()Lcom/discord/widgets/directories/WidgetDirectoryChannelViewPagerAdapter;", "adapter", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDirectoryChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAB_LAYOUT_MARGINS = DimenUtils.dpToPixels(48);
    private final ActivityResultLauncher<Intent> activityResult;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean hasBound;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoryChannel$Companion;", "", "", "TAB_LAYOUT_MARGINS", "I", "getTAB_LAYOUT_MARGINS", "()I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final int getTAB_LAYOUT_MARGINS() {
            return WidgetDirectoryChannel.access$getTAB_LAYOUT_MARGINS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppScreen2.g.f(WidgetDirectoryChannel.this.requireContext(), WidgetDirectoryChannel.access$getActivityResult$p(WidgetDirectoryChannel.this), WidgetHubAddServer.class, null);
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/GuildId;", "guildId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            Guild guild;
            Context context;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            long selectedGuildId = companion.getGuildSelected().getSelectedGuildId();
            GuildMember member = companion.getGuilds().getMember(selectedGuildId, companion.getUsers().getMeSnapshot().getId());
            if (member == null || (guild = companion.getGuilds().getGuild(selectedGuildId)) == null || (context = WidgetDirectoryChannel.this.getContext()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@appSubscribe");
            if (WidgetDirectoryChannel.this.isVisible() && selectedGuildId == j && guild.isHub()) {
                String nick = member.getNick();
                if (!(nick == null || StringsJVM.isBlank(nick)) || companion.getDirectories().getAndSetSeenNamePrompt(selectedGuildId) || GrowthTeamFeatures.INSTANCE.isHubNameKillSwitchEnabled()) {
                    return;
                }
                AppScreen2.d(context, WidgetHubAddName.class, new WidgetHubAddNameViewModel3(guild.getId()));
            }
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<WidgetDirectoriesViewModel.ViewState, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(WidgetDirectoriesViewModel.ViewState viewState) {
            return Boolean.valueOf(viewState != null);
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel.this.initializeUI();
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements Func1<WidgetDirectoriesViewModel.ViewState, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(WidgetDirectoriesViewModel.ViewState viewState) {
            return Boolean.valueOf(viewState != null);
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lcom/discord/widgets/directories/WidgetDirectoriesViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel widgetDirectoryChannel = WidgetDirectoryChannel.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetDirectoryChannel.access$configureUi(widgetDirectoryChannel, viewState);
        }
    }

    public WidgetDirectoryChannel() {
        super(R.layout.widget_directory_channel);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetDirectoryChannel6.INSTANCE, new WidgetDirectoryChannel7(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new WidgetDirectoryChannel$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetDirectoryChannel8.INSTANCE));
        this.adapter = LazyJVM.lazy(new WidgetDirectoryChannel5(this));
        this.activityResult = HubUtils.getAddServerActivityResultHandler(this);
    }

    public static final /* synthetic */ void access$configureUi(WidgetDirectoryChannel widgetDirectoryChannel, WidgetDirectoriesViewModel.ViewState viewState) {
        widgetDirectoryChannel.configureUi(viewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetDirectoryChannel widgetDirectoryChannel) {
        return widgetDirectoryChannel.activityResult;
    }

    public static final /* synthetic */ int access$getTAB_LAYOUT_MARGINS$cp() {
        return TAB_LAYOUT_MARGINS;
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetDirectoryChannel widgetDirectoryChannel, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        widgetDirectoryChannel.onViewBindingDestroy(widgetDirectoryChannelBinding);
    }

    public static /* synthetic */ void bindGestureObservers$default(WidgetDirectoryChannel widgetDirectoryChannel, boolean z2, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding, int i, Object obj) {
        if ((i & 2) != 0) {
            widgetDirectoryChannelBinding = null;
        }
        widgetDirectoryChannel.bindGestureObservers(z2, widgetDirectoryChannelBinding);
    }

    private final void configureUi(WidgetDirectoriesViewModel.ViewState state) {
        Guild guild = state.getGuild();
        if (guild != null) {
            getBinding().f.d.setOnClickListener(new WidgetDirectoryChannel3(guild, this));
            TextView textView = getBinding().f.f100b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetDirectoryC….itemDirectoryEmptyHeader");
            textView.setText(FormatUtils.k(this, R.string.hub_directory_channel_empty_title, new Object[]{guild.getName()}, null, 4));
        }
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        serverDiscoveryHeader.setButtonOnClickListener(new WidgetDirectoryChannel2(serverDiscoveryHeader, state));
        List<DirectoryEntryGuild> listInvoke = state.getDirectories().invoke();
        boolean z2 = listInvoke != null && (listInvoke.isEmpty() ^ true);
        ServerDiscoveryHeader serverDiscoveryHeader2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryHeader2, "binding.header");
        serverDiscoveryHeader2.setVisibility(z2 ? 0 : 8);
        ViewPager2 viewPager2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setVisibility(z2 ? 0 : 8);
        WidgetDirectoryChannelEmptyBinding widgetDirectoryChannelEmptyBinding = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(widgetDirectoryChannelEmptyBinding, "binding.widgetDirectoryChannelEmpty");
        LinearLayout linearLayout = widgetDirectoryChannelEmptyBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.widgetDirectoryChannelEmpty.root");
        linearLayout.setVisibility(z2 ^ true ? 0 : 8);
        Map<Integer, Integer> mapInvoke = state.getTabs().invoke();
        boolean z3 = !(mapInvoke == null || mapInvoke.isEmpty());
        toggleHeaderMargins(z3);
        TabLayout tabLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        tabLayout.setVisibility(z3 ? 0 : 8);
        WidgetDirectoryChannelViewPagerAdapter adapter = getAdapter();
        List<Tuples2<DirectoryEntryCategory, Integer>> mappedTabs = state.getMappedTabs();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mappedTabs, 10));
        Iterator<T> it = mappedTabs.iterator();
        while (it.hasNext()) {
            arrayList.add((DirectoryEntryCategory) ((Tuples2) it.next()).getFirst());
        }
        adapter.setTabs(_Collections.toList(arrayList));
    }

    private final void onViewBindingDestroy(WidgetDirectoryChannelBinding binding) {
        bindGestureObservers(false, binding);
    }

    private final void toggleHeaderMargins(boolean showTabLayout) {
        int i = showTabLayout ? TAB_LAYOUT_MARGINS : 0;
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryHeader, "binding.header");
        ViewGroup.LayoutParams layoutParams = serverDiscoveryHeader.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = i;
        serverDiscoveryHeader.setLayoutParams(marginLayoutParams);
        Toolbar toolbar = getBinding().f2365b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        ViewGroup.LayoutParams layoutParams2 = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.bottomMargin = i;
        toolbar.setLayoutParams(marginLayoutParams2);
    }

    public final void bindGestureObservers(boolean bind, WidgetDirectoryChannelBinding binding) {
        if (binding == null) {
            binding = getBinding();
        }
        if (!this.hasBound && bind) {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
            TabLayout tabLayout = binding.d;
            Intrinsics3.checkNotNullExpressionValue(tabLayout, "nonNullBinding.tabs");
            panelsChildGestureRegionObserverA.b(tabLayout);
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA2 = PanelsChildGestureRegionObserver.b.a();
            ViewPager2 viewPager2 = binding.e;
            Intrinsics3.checkNotNullExpressionValue(viewPager2, "nonNullBinding.viewPager");
            panelsChildGestureRegionObserverA2.b(viewPager2);
            this.hasBound = true;
            return;
        }
        if (bind) {
            return;
        }
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA3 = PanelsChildGestureRegionObserver.b.a();
        TabLayout tabLayout2 = binding.d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout2, "nonNullBinding.tabs");
        panelsChildGestureRegionObserverA3.c(tabLayout2);
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA4 = PanelsChildGestureRegionObserver.b.a();
        ViewPager2 viewPager22 = binding.e;
        Intrinsics3.checkNotNullExpressionValue(viewPager22, "nonNullBinding.viewPager");
        panelsChildGestureRegionObserverA4.c(viewPager22);
        this.hasBound = false;
    }

    public final WidgetDirectoryChannelViewPagerAdapter getAdapter() {
        return (WidgetDirectoryChannelViewPagerAdapter) this.adapter.getValue();
    }

    public final WidgetDirectoryChannelBinding getBinding() {
        return (WidgetDirectoryChannelBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesViewModel getViewModel() {
        return (WidgetDirectoriesViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    public final void initializeUI() {
        getBinding().f.c.setOnClickListener(new AnonymousClass1());
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        serverDiscoveryHeader.setTitle(getString(R.string.hub_directory_search_title));
        serverDiscoveryHeader.setDescription(getString(R.string.hub_directory_search_subtitle));
        getBinding().e.setAdapter(getAdapter());
        TabLayout tabLayout = getBinding().d;
        ViewPager2 viewPager2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        ViewPager2Extensions.setUpWithViewPager2(tabLayout, viewPager2, new WidgetDirectoryChannel4(tabLayout, this));
        bindGestureObservers$default(this, true, null, 2, null);
        Observable<Long> observableR = StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableG), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel.ViewState> observableZ = getViewModel().observeViewState().y(AnonymousClass1.INSTANCE).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "viewModel\n        .obser…= null }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableZ, this, null, 2, null), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable<WidgetDirectoriesViewModel.ViewState> observableY = getViewModel().observeViewState().y(AnonymousClass3.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableY, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableY, this, null, 2, null), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
    }
}
