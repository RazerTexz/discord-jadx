package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetCreateChannelAddMemberBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.permissions.ChannelPermissionsAddMemberUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetCreateChannelAddMember.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R!\u0010\u0016\u001a\u00060\bj\u0002`\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\u00020 8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetCreateChannelAddMember;", "Lcom/discord/app/AppFragment;", "Lcom/discord/api/channel/Channel;", "channel", "", "configureUI", "(Lcom/discord/api/channel/Channel;)V", "", "", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "selected", "addPermissionOverwrites", "(Ljava/util/Map;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "Lcom/discord/primitives/ChannelId;", "channelId$delegate", "Lkotlin/Lazy;", "getChannelId", "()J", "channelId", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragment;", "fragment", "Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsAddMemberFragment;", "Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", "binding", "Lcom/discord/app/LoggingConfig;", "loggingConfig", "Lcom/discord/app/LoggingConfig;", "getLoggingConfig", "()Lcom/discord/app/LoggingConfig;", "<init>", "()V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCreateChannelAddMember.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetChannelSettingsAddMemberFragment fragment;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetCreateChannelAddMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/channels/permissions/WidgetCreateChannelAddMember$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "create", "(Landroid/content/Context;J)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            AppScreen2.d(context, WidgetCreateChannelAddMember.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreateChannelAddMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Ljava/lang/Void;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$addPermissionOverwrites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Void>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Void> list) {
            invoke2((List<Void>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            FragmentActivity activity = WidgetCreateChannelAddMember.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetCreateChannelAddMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "channel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetCreateChannelAddMember.access$configureUI(WidgetCreateChannelAddMember.this, channel);
        }
    }

    /* compiled from: WidgetCreateChannelAddMember.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/api/permission/PermissionOverwrite$Type;", "kotlin.jvm.PlatformType", "selected", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Map<Long, ? extends PermissionOverwrite.Type>, Unit> {

        /* compiled from: WidgetCreateChannelAddMember.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
            public final /* synthetic */ Map $selected;

            public AnonymousClass1(Map map) {
                this.$selected = map;
            }

            @Override // rx.functions.Action2
            public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
                call2(menuItem, context);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_continue) {
                    return;
                }
                WidgetCreateChannelAddMember widgetCreateChannelAddMember = WidgetCreateChannelAddMember.this;
                Map map = this.$selected;
                Intrinsics3.checkNotNullExpressionValue(map, "selected");
                WidgetCreateChannelAddMember.access$addPermissionOverwrites(widgetCreateChannelAddMember, map);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite.Type> map) {
            invoke2(map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, ? extends PermissionOverwrite.Type> map) {
            AppFragment.setActionBarOptionsMenu$default(WidgetCreateChannelAddMember.this, R.menu.menu_add_member_continue, new AnonymousClass1(map), null, 4, null);
        }
    }

    public WidgetCreateChannelAddMember() {
        super(R.layout.widget_create_channel_add_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateChannelAddMember2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetCreateChannelAddMember3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetCreateChannelAddMember4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$addPermissionOverwrites(WidgetCreateChannelAddMember widgetCreateChannelAddMember, Map map) {
        widgetCreateChannelAddMember.addPermissionOverwrites(map);
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateChannelAddMember widgetCreateChannelAddMember, Channel channel) {
        widgetCreateChannelAddMember.configureUI(channel);
    }

    private final void addPermissionOverwrites(Map<Long, ? extends PermissionOverwrite.Type> selected) {
        if (!selected.isEmpty()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ChannelPermissionsAddMemberUtils.INSTANCE.addPermissionOverwrites(getChannelId(), selected, 20971536L), this, null, 2, null), WidgetCreateChannelAddMember.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void configureUI(Channel channel) {
        if (channel != null) {
            setActionBarSubtitle(channel.getName());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final WidgetCreateChannelAddMemberBinding getBinding() {
        return (WidgetCreateChannelAddMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.fragment = WidgetChannelSettingsAddMemberFragment.INSTANCE.create(getChannelId(), true);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().f2356b;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.content");
        int id2 = fragmentContainerView.getId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment2 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        fragmentTransactionBeginTransaction.replace(id2, widgetChannelSettingsAddMemberFragment, widgetChannelSettingsAddMemberFragment2.getClass().getSimpleName()).commit();
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.channel_permissions_add_moderator_title);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()), this, null, 2, null), WidgetCreateChannelAddMember.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment3 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment3.getSelectedItemsSubject();
        Intrinsics3.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(selectedItemsSubject, this, null, 2, null), WidgetCreateChannelAddMember.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
