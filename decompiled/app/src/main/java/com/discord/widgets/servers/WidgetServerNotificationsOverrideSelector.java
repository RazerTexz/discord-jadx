package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerNotificationOverrideSelectorBinding;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.GuildChannelsInfo;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.google.android.material.textfield.TextInputLayout;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetServerNotificationsOverrideSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000e\u001a\u00020\t8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R:\u0010\u0015\u001a&\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013 \u0014*\u0012\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00120\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotificationsOverrideSelector;", "Lcom/discord/app/AppFragment;", "Landroid/view/View;", "view", "", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", "binding", "Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "channelsAdapter", "Lcom/discord/widgets/servers/SettingsChannelListAdapter;", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "filterPublisher", "Lrx/subjects/BehaviorSubject;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerNotificationsOverrideSelector extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerNotificationsOverrideSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerNotificationOverrideSelectorBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private SettingsChannelListAdapter channelsAdapter;
    private final BehaviorSubject<String> filterPublisher;

    /* compiled from: WidgetServerNotificationsOverrideSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014Je\u0010\f\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u000b*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t \u000b*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\n \u000b*\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\t\u0018\u00010\b0\b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/servers/WidgetServerNotificationsOverrideSelector$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/subjects/BehaviorSubject;", "", "filterPublisher", "Lrx/Observable;", "", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "kotlin.jvm.PlatformType", "get", "(JLrx/subjects/BehaviorSubject;)Lrx/Observable;", "Landroid/content/Context;", "context", "", "launch", "(Landroid/content/Context;J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$get(Companion companion, long j, BehaviorSubject behaviorSubject) {
            return companion.get(j, behaviorSubject);
        }

        private final Observable<List<CategoricalDragAndDropAdapter.Payload>> get(long guildId, BehaviorSubject<String> filterPublisher) {
            Observable observableI = Observable.i(StoreChannels.observeChannelsForGuild$default(StoreStream.INSTANCE.getChannels(), guildId, null, 2, null), GuildChannelsInfo.INSTANCE.get(guildId), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS), WidgetServerNotificationsOverrideSelector2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…              }\n        }");
            return ObservableExtensionsKt.computationBuffered(observableI).r();
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE….EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerNotificationsOverrideSelector.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerNotificationsOverrideSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
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
            WidgetServerNotificationsOverrideSelector.access$getFilterPublisher$p(WidgetServerNotificationsOverrideSelector.this).onNext(editable.toString());
        }
    }

    /* compiled from: WidgetServerNotificationsOverrideSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/ChannelId;", "channelId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            Context context = WidgetServerNotificationsOverrideSelector.this.getContext();
            if (context != null) {
                WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(context, "it");
                WidgetChannelNotificationSettings.Companion.launch$default(companion, context, j, false, 4, null);
            }
        }
    }

    /* compiled from: WidgetServerNotificationsOverrideSelector.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/utilities/mg_recycler/CategoricalDragAndDropAdapter$Payload;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.WidgetServerNotificationsOverrideSelector$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends CategoricalDragAndDropAdapter.Payload>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends CategoricalDragAndDropAdapter.Payload> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends CategoricalDragAndDropAdapter.Payload> list) {
            SettingsChannelListAdapter settingsChannelListAdapterAccess$getChannelsAdapter$p = WidgetServerNotificationsOverrideSelector.access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector.this);
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            settingsChannelListAdapterAccess$getChannelsAdapter$p.setData(_Collections.toMutableList((Collection) list));
        }
    }

    public WidgetServerNotificationsOverrideSelector() {
        super(R.layout.widget_server_notification_override_selector);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerNotificationsOverrideSelector3.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.l0("");
    }

    public static final /* synthetic */ SettingsChannelListAdapter access$getChannelsAdapter$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        SettingsChannelListAdapter settingsChannelListAdapter = widgetServerNotificationsOverrideSelector.channelsAdapter;
        if (settingsChannelListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        return settingsChannelListAdapter;
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector) {
        return widgetServerNotificationsOverrideSelector.filterPublisher;
    }

    public static final /* synthetic */ void access$setChannelsAdapter$p(WidgetServerNotificationsOverrideSelector widgetServerNotificationsOverrideSelector, SettingsChannelListAdapter settingsChannelListAdapter) {
        widgetServerNotificationsOverrideSelector.channelsAdapter = settingsChannelListAdapter;
    }

    private final WidgetServerNotificationOverrideSelectorBinding getBinding() {
        return (WidgetServerNotificationOverrideSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_overrides);
        setActionBarSubtitle(R.string.select_channel_or_category);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildNotificationsChannelSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass1());
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2537b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildNotificationsChannelList");
        SettingsChannelListAdapter settingsChannelListAdapter = (SettingsChannelListAdapter) companion.configure(new SettingsChannelListAdapter(recyclerView, false));
        this.channelsAdapter = settingsChannelListAdapter;
        if (settingsChannelListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("channelsAdapter");
        }
        settingsChannelListAdapter.setOnClickListener(new AnonymousClass2());
        RecyclerView recyclerView2 = getBinding().f2537b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildNotificationsChannelList");
        recyclerView2.setNestedScrollingEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        Companion companion = INSTANCE;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable observableAccess$get = Companion.access$get(companion, longExtra, behaviorSubject);
        Intrinsics3.checkNotNullExpressionValue(observableAccess$get, "get(guildId, filterPublisher)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableAccess$get, this, null, 2, null), WidgetServerNotificationsOverrideSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
