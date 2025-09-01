package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventListBottomSheetBinding;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.voice.VoiceUtils;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b7\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\nJ!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010)R$\u0010.\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010,0,0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u00102R\u001f\u00106\u001a\u0004\u0018\u00010&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u00105¨\u00069"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventListBottomSheet;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;", "viewState", "", "configureUi", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;)V", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "item", "onJoinClicked", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", "onShareClicked", "onRsvpClicked", "onEventStartClicked", "onEventCardClicked", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "", "getContentViewResId", "()I", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel;", "viewModel", "Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", "binding", "", "guildId$delegate", "getGuildId", "()J", "guildId", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "previewLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListAdapter;", "adapter", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListAdapter;", "channelId$delegate", "getChannelId", "()Ljava/lang/Long;", "channelId", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventListBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GuildScheduledEventListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/WidgetGuildScheduledEventListBottomSheet$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "channelId", "", "show", "(Landroidx/fragment/app/FragmentManager;JLjava/lang/Long;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.show(fragmentManager, j, l);
        }

        public final void show(FragmentManager fragmentManager, long guildId, Long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet = new WidgetGuildScheduledEventListBottomSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (channelId != null) {
                bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            widgetGuildScheduledEventListBottomSheet.setArguments(bundleT);
            widgetGuildScheduledEventListBottomSheet.show(fragmentManager, WidgetGuildScheduledEventListBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$configureUi((WidgetGuildScheduledEventListBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onEventCardClicked", "onEventCardClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onEventCardClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass2(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onRsvpClicked", "onRsvpClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onRsvpClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass3(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onEventStartClicked", "onEventStartClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onEventStartClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass4(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onJoinClicked", "onJoinClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onJoinClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;", "p1", "", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass5(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onShareClicked", "onShareClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onShareClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventListBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launch(contextRequireContext, WidgetGuildScheduledEventListBottomSheet.access$getGuildId$p(WidgetGuildScheduledEventListBottomSheet.this), WidgetGuildScheduledEventListBottomSheet.access$getChannelId$p(WidgetGuildScheduledEventListBottomSheet.this));
        }
    }

    public WidgetGuildScheduledEventListBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventListBottomSheet2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventListBottomSheet4(this));
        this.channelId = LazyJVM.lazy(new WidgetGuildScheduledEventListBottomSheet3(this));
        WidgetGuildScheduledEventListBottomSheet6 widgetGuildScheduledEventListBottomSheet6 = new WidgetGuildScheduledEventListBottomSheet6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventListViewModel.class), new WidgetGuildScheduledEventListBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventListBottomSheet6));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventListBottomSheet5(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListViewModel.ViewState viewState) {
        widgetGuildScheduledEventListBottomSheet.configureUi(viewState);
    }

    public static final /* synthetic */ Long access$getChannelId$p(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        return widgetGuildScheduledEventListBottomSheet.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        return widgetGuildScheduledEventListBottomSheet.getGuildId();
    }

    public static final /* synthetic */ void access$onEventCardClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onEventCardClicked(event);
    }

    public static final /* synthetic */ void access$onEventStartClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onEventStartClicked(event);
    }

    public static final /* synthetic */ void access$onJoinClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onJoinClicked(event);
    }

    public static final /* synthetic */ void access$onRsvpClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onRsvpClicked(event);
    }

    public static final /* synthetic */ void access$onShareClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onShareClicked(event);
    }

    private final void configureUi(GuildScheduledEventListViewModel.ViewState viewState) {
        if (!(viewState instanceof GuildScheduledEventListViewModel.ViewState.Loaded)) {
            viewState = null;
        }
        GuildScheduledEventListViewModel.ViewState.Loaded loaded = (GuildScheduledEventListViewModel.ViewState.Loaded) viewState;
        if (loaded != null) {
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListToolbarTitle");
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(StringResourceUtils.getI18nPluralString(contextRequireContext, R.plurals.guild_events_plural_number, loaded.getGuildScheduledEvents().size(), Integer.valueOf(loaded.getGuildScheduledEvents().size())));
            GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
            if (guildScheduledEventListAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            guildScheduledEventListAdapter.setData(loaded.getGuildScheduledEvents());
            TextView textView2 = getBinding().f2446b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createEventButton");
            textView2.setVisibility(loaded.getCanCreateEvents() ? 0 : 8);
            ConstraintLayout constraintLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventListEmptyState");
            constraintLayout.setVisibility(loaded.getGuildScheduledEvents().isEmpty() ? 0 : 8);
        }
    }

    private final WidgetGuildScheduledEventListBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventListBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getChannelId() {
        return (Long) this.channelId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildScheduledEventListViewModel getViewModel() {
        return (GuildScheduledEventListViewModel) this.viewModel.getValue();
    }

    private final void onEventCardClicked(GuildScheduledEventListItem.Event item) {
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(parentFragmentManager, item.getEvent().getId());
    }

    private final void onEventStartClicked(GuildScheduledEventListItem.Event item) {
        if (item.getCanStartEvent()) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, contextRequireContext, GuildScheduledEventModel2.toModel(item.getEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(item.getEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), this.previewLauncher, false, 16, null);
        }
    }

    private final void onJoinClicked(GuildScheduledEventListItem.Event item) {
        Channel channel = item.getChannel();
        if (channel != null) {
            dismiss();
            VoiceUtils.handleCallChannel(channel, this);
        }
    }

    private final void onRsvpClicked(GuildScheduledEventListItem.Event item) {
        if (!item.isRsvped()) {
            AppToast.g(getContext(), R.string.guild_event_interested_notification, 0, null, 12);
        }
        getViewModel().toggleRsvp(item.getEvent());
    }

    private final void onShareClicked(GuildScheduledEventListItem.Event item) {
        getViewModel().onShareClicked(item.getEvent(), new WeakReference<>(requireContext()), new WeakReference<>(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_list_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventListBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventListRecyclerView");
        this.adapter = new GuildScheduledEventListAdapter(recyclerView, new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass1(this), new AnonymousClass4(this), new AnonymousClass5(this));
        RecyclerView recyclerView2 = getBinding().d;
        GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
        if (guildScheduledEventListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        Context context = recyclerView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        GuildScheduledEventListAdapter guildScheduledEventListAdapter2 = this.adapter;
        if (guildScheduledEventListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, guildScheduledEventListAdapter2, 0, 0, 24, null));
        recyclerView2.setItemAnimator(null);
        getBinding().f2446b.setOnClickListener(new AnonymousClass7());
    }
}
