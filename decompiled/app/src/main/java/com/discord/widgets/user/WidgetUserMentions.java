package com.discord.widgets.user;

import a0.a.a.b;
import android.content.Context;
import android.net.Uri;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMentionsBinding;
import com.discord.databinding.WidgetUserMentionsFilterBinding;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.fragment.FragmentExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.views.CheckedSetting;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.search.WidgetGlobalSearchDismissModel;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.p.Schedulers2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action2;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetUserMentions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0004?@ABB\u0007¢\u0006\u0004\b>\u0010\u001fJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u001fJ\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u001fR\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010&\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010-\u001a\u00020(8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001d\u0010/\u001a\u00020\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b/\u0010\fR\u001d\u00105\u001a\u0002008B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001d\u0010:\u001a\u0002068B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010*\u001a\u0004\b8\u00109R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/tabs/OnTabSelectedListener;", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", "observeModel", "()Lrx/Observable;", "", "configureUI", "(Lcom/discord/widgets/user/WidgetUserMentions$Model;)V", "", "isOnMentionsTab", "()Z", "", "guildName", "configureToolbar", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lcom/discord/stores/StoreChat$InteractionState;", "onInteractionStateUpdated", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "createAdapter", "(Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "addThreadSpineItemDecoration", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "onPause", "onDestroy", "onTabSelected", "Lcom/discord/stores/StoreTabsNavigation;", "storeTabsNavigation", "Lcom/discord/stores/StoreTabsNavigation;", "mentionsAdapter", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lcom/discord/widgets/user/WidgetUserMentionsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/discord/widgets/user/WidgetUserMentionsViewModel;", "viewModel", "isEmbedded$delegate", "isEmbedded", "Lcom/discord/databinding/WidgetUserMentionsBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserMentionsBinding;", "binding", "Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "dismissViewModel$delegate", "getDismissViewModel", "()Lcom/discord/widgets/user/search/WidgetGlobalSearchDismissModel;", "dismissViewModel", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader;", "mentionsLoader", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader;", "<init>", "Companion", ExifInterface.TAG_MODEL, "UserMentionsAdapterEventHandler", "WidgetUserMentionFilter", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserMentions extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserMentions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_IS_EMBEDDED = "EXTRA_HIDE_TITLE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;

    /* renamed from: isEmbedded$delegate, reason: from kotlin metadata */
    private final Lazy isEmbedded;
    private WidgetChatListAdapter mentionsAdapter;
    private final Model.MessageLoader mentionsLoader;
    private final StoreTabsNavigation storeTabsNavigation;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Companion;", "", "", "isEmbedded", "Lcom/discord/widgets/user/WidgetUserMentions;", "create", "(Z)Lcom/discord/widgets/user/WidgetUserMentions;", "", "EXTRA_IS_EMBEDDED", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetUserMentions create$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.create(z2);
        }

        public final WidgetUserMentions create(boolean isEmbedded) {
            WidgetUserMentions widgetUserMentions = new WidgetUserMentions();
            widgetUserMentions.setArguments(Bundle2.bundleOf(Tuples.to(WidgetUserMentions.EXTRA_IS_EMBEDDED, Boolean.valueOf(isEmbedded))));
            return widgetUserMentions;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0002QRB¥\u0001\u0012\n\u0010$\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010%\u001a\u00060\u0002j\u0002`\u0006\u0012\b\u0010&\u001a\u0004\u0018\u00010\b\u0012\n\u0010'\u001a\u00060\u0002j\u0002`\u000b\u0012\u0016\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\u0010)\u001a\u00060\u0002j\u0002`\u0011\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\n\u0010,\u001a\u00060\u0002j\u0002`\u0011\u0012\b\b\u0002\u0010-\u001a\u00020\u001b\u0012\u0006\u0010.\u001a\u00020\u001b\u0012\b\u0010/\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u00100\u001a\u00020!¢\u0006\u0004\bO\u0010PJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\u0005J \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0012\u001a\u00060\u0002j\u0002`\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u001a\u001a\u00060\u0002j\u0002`\u0011HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0005J\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÆ\u0003¢\u0006\u0004\b\"\u0010#JÆ\u0001\u00101\u001a\u00020\u00002\f\b\u0002\u0010$\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010%\u001a\u00060\u0002j\u0002`\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\f\b\u0002\u0010'\u001a\u00060\u0002j\u0002`\u000b2\u0018\b\u0002\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r2\f\b\u0002\u0010)\u001a\u00060\u0002j\u0002`\u00112\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00172\f\b\u0002\u0010,\u001a\u00060\u0002j\u0002`\u00112\b\b\u0002\u0010-\u001a\u00020\u001b2\b\b\u0002\u0010.\u001a\u00020\u001b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u00100\u001a\u00020!HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b3\u0010 J\u0010\u00105\u001a\u000204HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00109\u001a\u00020\u001b2\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b9\u0010:R,\u0010(\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010;\u001a\u0004\b<\u0010\u0010R\u0019\u0010.\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010=\u001a\u0004\b>\u0010\u001dR\"\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010?\u001a\u0004\b@\u0010\u0019R \u0010%\u001a\u00060\u0002j\u0002`\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010\u0005R \u0010$\u001a\u00060\u0002j\u0002`\u00038\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bC\u0010\u0005R\u001e\u0010&\u001a\u0004\u0018\u00010\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010\nR\u0019\u00100\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010F\u001a\u0004\bG\u0010#R \u0010)\u001a\u00060\u0002j\u0002`\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010A\u001a\u0004\bH\u0010\u0005R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010I\u001a\u0004\bJ\u0010\u0016R\u001c\u0010-\u001a\u00020\u001b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010=\u001a\u0004\b-\u0010\u001dR \u0010'\u001a\u00060\u0002j\u0002`\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010A\u001a\u0004\bK\u0010\u0005R \u0010,\u001a\u00060\u0002j\u0002`\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010A\u001a\u0004\bL\u0010\u0005R\u001b\u0010/\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010M\u001a\u0004\bN\u0010 ¨\u0006S"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/primitives/GuildId;", "component4", "", "", "component5", "()Ljava/util/Map;", "Lcom/discord/primitives/MessageId;", "component6", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "component7", "()Ljava/util/List;", "", "component8", "()Ljava/util/Set;", "component9", "", "component10", "()Z", "component11", "component12", "()Ljava/lang/String;", "Lcom/discord/widgets/tabs/NavigationTab;", "component13", "()Lcom/discord/widgets/tabs/NavigationTab;", "userId", "channelId", "guild", "guildId", "channelNames", "oldestMessageId", "list", "myRoleIds", "newMessagesMarkerMessageId", "isSpoilerClickAllowed", "animateEmojis", "guildName", "selectedTab", "copy", "(JJLcom/discord/models/guild/Guild;JLjava/util/Map;JLjava/util/List;Ljava/util/Set;JZZLjava/lang/String;Lcom/discord/widgets/tabs/NavigationTab;)Lcom/discord/widgets/user/WidgetUserMentions$Model;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannelNames", "Z", "getAnimateEmojis", "Ljava/util/Set;", "getMyRoleIds", "J", "getChannelId", "getUserId", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/widgets/tabs/NavigationTab;", "getSelectedTab", "getOldestMessageId", "Ljava/util/List;", "getList", "getGuildId", "getNewMessagesMarkerMessageId", "Ljava/lang/String;", "getGuildName", "<init>", "(JJLcom/discord/models/guild/Guild;JLjava/util/Map;JLjava/util/List;Ljava/util/Set;JZZLjava/lang/String;Lcom/discord/widgets/tabs/NavigationTab;)V", "Companion", "MessageLoader", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean animateEmojis;
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final String guildName;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final NavigationTab selectedTab;
        private final long userId;

        /* compiled from: WidgetUserMentions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$Companion;", "", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader;", "messageLoader", "Lcom/discord/widgets/tabs/NavigationTab;", "selectedTab", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", "get", "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader;Lcom/discord/widgets/tabs/NavigationTab;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final Observable<Model> get(MessageLoader messageLoader, NavigationTab selectedTab) {
                Intrinsics3.checkNotNullParameter(messageLoader, "messageLoader");
                Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
                Observable<R> observableY = messageLoader.getMentionsLoadingStateSubject().Y(new WidgetUserMentions$Model$Companion$get$1(selectedTab));
                Observable<Model> observableR = Observable.h0(new OnSubscribeLift(observableY.j, new LeadingEdgeThrottle(300L, TimeUnit.MILLISECONDS, Schedulers2.a()))).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "messageLoader\n          …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetUserMentions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002ABB\u000f\u0012\u0006\u00103\u001a\u000202¢\u0006\u0004\b?\u0010@J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0019\u001a\u00020\u00052\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001bR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R&\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00030!j\b\u0012\u0004\u0012\u00020\u0003`\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010,R$\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u00178\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R*\u00108\u001a\u0002072\u0006\u0010-\u001a\u0002078\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010>¨\u0006C"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader;", "", "", "Lcom/discord/models/message/Message;", "messages", "", "handleLoaded", "(Ljava/util/List;)V", "handleLoadError", "()V", "Lkotlin/Function0;", "retryAction", "retry", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "setInteractionState", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "", "isFocused", "setIsFocused", "(Z)V", "Lkotlin/Function1;", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "loadingStateUpdater", "tryLoad", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function0;", "Lrx/subjects/BehaviorSubject;", "mentionsLoadingStateSubject", "Lrx/subjects/BehaviorSubject;", "getMentionsLoadingStateSubject", "()Lrx/subjects/BehaviorSubject;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mentions", "Ljava/util/ArrayList;", "Lrx/Subscription;", "loadSubscription", "Lrx/Subscription;", "", "mentionLimit", "I", "retrySubscription", "Z", "value", "mentionsLoadingState", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "setMentionsLoadingState", "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;)V", "", "retryDelayMs", "J", "loadBeforeMessageId", "Ljava/lang/Long;", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "filters", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "getFilters", "()Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "setFilters", "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;)V", "Lcom/discord/stores/StoreChat$InteractionState;", "<init>", "(J)V", "Filters", "LoadingState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class MessageLoader {
            private StoreChat.InteractionState interactionState;
            private boolean isFocused;
            private Long loadBeforeMessageId;
            private Subscription loadSubscription;
            private final BehaviorSubject<LoadingState> mentionsLoadingStateSubject;
            private Function0<Unit> retryAction;
            private final long retryDelayMs;
            private Subscription retrySubscription;
            private final ArrayList<Message> mentions = new ArrayList<>();
            private final int mentionLimit = 25;
            private LoadingState mentionsLoadingState = new LoadingState(false, false, null, 7, null);
            private Filters filters = new Filters(0, false, false, false, 15, null);

            /* compiled from: WidgetUserMentions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ<\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001c\u0010\bR\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001f\u0010\b¨\u0006\""}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "", "component2", "()Z", "component3", "component4", "guildId", "allGuilds", "includeEveryone", "includeRoles", "copy", "(JZZZ)Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getIncludeEveryone", "getIncludeRoles", "J", "getGuildId", "getAllGuilds", "<init>", "(JZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class Filters {
                private final boolean allGuilds;
                private final long guildId;
                private final boolean includeEveryone;
                private final boolean includeRoles;

                public Filters() {
                    this(0L, false, false, false, 15, null);
                }

                public Filters(long j, boolean z2, boolean z3, boolean z4) {
                    this.guildId = j;
                    this.allGuilds = z2;
                    this.includeEveryone = z3;
                    this.includeRoles = z4;
                }

                public static /* synthetic */ Filters copy$default(Filters filters, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                    if ((i & 1) != 0) {
                        j = filters.guildId;
                    }
                    long j2 = j;
                    if ((i & 2) != 0) {
                        z2 = filters.allGuilds;
                    }
                    boolean z5 = z2;
                    if ((i & 4) != 0) {
                        z3 = filters.includeEveryone;
                    }
                    boolean z6 = z3;
                    if ((i & 8) != 0) {
                        z4 = filters.includeRoles;
                    }
                    return filters.copy(j2, z5, z6, z4);
                }

                /* renamed from: component1, reason: from getter */
                public final long getGuildId() {
                    return this.guildId;
                }

                /* renamed from: component2, reason: from getter */
                public final boolean getAllGuilds() {
                    return this.allGuilds;
                }

                /* renamed from: component3, reason: from getter */
                public final boolean getIncludeEveryone() {
                    return this.includeEveryone;
                }

                /* renamed from: component4, reason: from getter */
                public final boolean getIncludeRoles() {
                    return this.includeRoles;
                }

                public final Filters copy(long guildId, boolean allGuilds, boolean includeEveryone, boolean includeRoles) {
                    return new Filters(guildId, allGuilds, includeEveryone, includeRoles);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Filters)) {
                        return false;
                    }
                    Filters filters = (Filters) other;
                    return this.guildId == filters.guildId && this.allGuilds == filters.allGuilds && this.includeEveryone == filters.includeEveryone && this.includeRoles == filters.includeRoles;
                }

                public final boolean getAllGuilds() {
                    return this.allGuilds;
                }

                public final long getGuildId() {
                    return this.guildId;
                }

                public final boolean getIncludeEveryone() {
                    return this.includeEveryone;
                }

                public final boolean getIncludeRoles() {
                    return this.includeRoles;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public int hashCode() {
                    int iA = b.a(this.guildId) * 31;
                    boolean z2 = this.allGuilds;
                    int i = z2;
                    if (z2 != 0) {
                        i = 1;
                    }
                    int i2 = (iA + i) * 31;
                    boolean z3 = this.includeEveryone;
                    int i3 = z3;
                    if (z3 != 0) {
                        i3 = 1;
                    }
                    int i4 = (i2 + i3) * 31;
                    boolean z4 = this.includeRoles;
                    return i4 + (z4 ? 1 : z4 ? 1 : 0);
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Filters(guildId=");
                    sbU.append(this.guildId);
                    sbU.append(", allGuilds=");
                    sbU.append(this.allGuilds);
                    sbU.append(", includeEveryone=");
                    sbU.append(this.includeEveryone);
                    sbU.append(", includeRoles=");
                    return outline.O(sbU, this.includeRoles, ")");
                }

                public /* synthetic */ Filters(long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
                }
            }

            /* compiled from: WidgetUserMentions.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\n\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u000b\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "", "", "component1", "()Z", "component2", "", "Lcom/discord/models/message/Message;", "component3", "()Ljava/util/List;", "isLoading", "isAllLoaded", "mentions", "copy", "(ZZLjava/util/List;)Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$LoadingState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMentions", "Z", "<init>", "(ZZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class LoadingState {
                private final boolean isAllLoaded;
                private final boolean isLoading;
                private final List<Message> mentions;

                public LoadingState() {
                    this(false, false, null, 7, null);
                }

                public LoadingState(boolean z2, boolean z3, List<Message> list) {
                    Intrinsics3.checkNotNullParameter(list, "mentions");
                    this.isLoading = z2;
                    this.isAllLoaded = z3;
                    this.mentions = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ LoadingState copy$default(LoadingState loadingState, boolean z2, boolean z3, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = loadingState.isLoading;
                    }
                    if ((i & 2) != 0) {
                        z3 = loadingState.isAllLoaded;
                    }
                    if ((i & 4) != 0) {
                        list = loadingState.mentions;
                    }
                    return loadingState.copy(z2, z3, list);
                }

                /* renamed from: component1, reason: from getter */
                public final boolean getIsLoading() {
                    return this.isLoading;
                }

                /* renamed from: component2, reason: from getter */
                public final boolean getIsAllLoaded() {
                    return this.isAllLoaded;
                }

                public final List<Message> component3() {
                    return this.mentions;
                }

                public final LoadingState copy(boolean isLoading, boolean isAllLoaded, List<Message> mentions) {
                    Intrinsics3.checkNotNullParameter(mentions, "mentions");
                    return new LoadingState(isLoading, isAllLoaded, mentions);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof LoadingState)) {
                        return false;
                    }
                    LoadingState loadingState = (LoadingState) other;
                    return this.isLoading == loadingState.isLoading && this.isAllLoaded == loadingState.isAllLoaded && Intrinsics3.areEqual(this.mentions, loadingState.mentions);
                }

                public final List<Message> getMentions() {
                    return this.mentions;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v1, types: [int] */
                /* JADX WARN: Type inference failed for: r0v6 */
                /* JADX WARN: Type inference failed for: r0v7 */
                public int hashCode() {
                    boolean z2 = this.isLoading;
                    ?? r0 = z2;
                    if (z2) {
                        r0 = 1;
                    }
                    int i = r0 * 31;
                    boolean z3 = this.isAllLoaded;
                    int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                    List<Message> list = this.mentions;
                    return i2 + (list != null ? list.hashCode() : 0);
                }

                public final boolean isAllLoaded() {
                    return this.isAllLoaded;
                }

                public final boolean isLoading() {
                    return this.isLoading;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("LoadingState(isLoading=");
                    sbU.append(this.isLoading);
                    sbU.append(", isAllLoaded=");
                    sbU.append(this.isAllLoaded);
                    sbU.append(", mentions=");
                    return outline.L(sbU, this.mentions, ")");
                }

                public /* synthetic */ LoadingState(boolean z2, boolean z3, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? Collections2.emptyList() : list);
                }
            }

            public MessageLoader(long j) {
                this.retryDelayMs = j;
                BehaviorSubject<LoadingState> behaviorSubjectL0 = BehaviorSubject.l0(this.mentionsLoadingState);
                Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(mentionsLoadingState)");
                this.mentionsLoadingStateSubject = behaviorSubjectL0;
            }

            public static final /* synthetic */ Subscription access$getLoadSubscription$p(MessageLoader messageLoader) {
                return messageLoader.loadSubscription;
            }

            public static final /* synthetic */ Subscription access$getRetrySubscription$p(MessageLoader messageLoader) {
                return messageLoader.retrySubscription;
            }

            public static final /* synthetic */ void access$handleLoadError(MessageLoader messageLoader) {
                messageLoader.handleLoadError();
            }

            public static final /* synthetic */ void access$handleLoaded(MessageLoader messageLoader, List list) {
                messageLoader.handleLoaded(list);
            }

            public static final /* synthetic */ void access$setLoadSubscription$p(MessageLoader messageLoader, Subscription subscription) {
                messageLoader.loadSubscription = subscription;
            }

            public static final /* synthetic */ void access$setRetrySubscription$p(MessageLoader messageLoader, Subscription subscription) {
                messageLoader.retrySubscription = subscription;
            }

            @MainThread
            private final void handleLoadError() {
                retry(new WidgetUserMentions$Model$MessageLoader$handleLoadError$1(this));
            }

            @MainThread
            private final void handleLoaded(List<Message> messages) {
                boolean z2 = messages.isEmpty() || messages.size() < this.mentionLimit;
                Message message = (Message) _Collections.lastOrNull((List) messages);
                this.loadBeforeMessageId = message != null ? Long.valueOf(message.getId()) : null;
                this.mentions.addAll(messages);
                setMentionsLoadingState(LoadingState.copy$default(this.mentionsLoadingState, false, false, new ArrayList(this.mentions), 3, null));
                retry(new WidgetUserMentions$Model$MessageLoader$handleLoaded$1(this, z2));
            }

            private final void retry(Function0<Unit> retryAction) {
                Subscription subscription = this.retrySubscription;
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.retryAction = retryAction;
                Observable<Long> observableD0 = Observable.d0(this.retryDelayMs, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(retryDe…s, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableD0), MessageLoader.class, (Context) null, new WidgetUserMentions$Model$MessageLoader$retry$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetUserMentions$Model$MessageLoader$retry$2(retryAction), 58, (Object) null);
            }

            private final void setMentionsLoadingState(LoadingState loadingState) {
                if (Intrinsics3.areEqual(this.mentionsLoadingState, loadingState)) {
                    return;
                }
                this.mentionsLoadingState = loadingState;
                this.mentionsLoadingStateSubject.onNext(loadingState);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ void tryLoad$default(MessageLoader messageLoader, Function1 function1, int i, Object obj) {
                if ((i & 1) != 0) {
                    function1 = WidgetUserMentions$Model$MessageLoader$tryLoad$1.INSTANCE;
                }
                messageLoader.tryLoad(function1);
            }

            public final Filters getFilters() {
                return this.filters;
            }

            public final BehaviorSubject<LoadingState> getMentionsLoadingStateSubject() {
                return this.mentionsLoadingStateSubject;
            }

            @MainThread
            public final void setFilters(Filters filters) {
                Intrinsics3.checkNotNullParameter(filters, "value");
                if (!Intrinsics3.areEqual(this.filters, filters)) {
                    this.filters = filters;
                    Subscription subscription = this.loadSubscription;
                    if (subscription != null) {
                        subscription.unsubscribe();
                    }
                    this.loadBeforeMessageId = null;
                    this.mentions.clear();
                    tryLoad(WidgetUserMentions$Model$MessageLoader$filters$1.INSTANCE);
                }
            }

            @MainThread
            public final void setInteractionState(StoreChat.InteractionState interactionState) {
                Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
                this.interactionState = interactionState;
                tryLoad$default(this, null, 1, null);
            }

            @MainThread
            public final void setIsFocused(boolean isFocused) {
                this.isFocused = isFocused;
                tryLoad$default(this, null, 1, null);
            }

            @MainThread
            public final void tryLoad(Function1<? super LoadingState, LoadingState> loadingStateUpdater) {
                StoreChat.InteractionState interactionState;
                Intrinsics3.checkNotNullParameter(loadingStateUpdater, "loadingStateUpdater");
                setMentionsLoadingState(loadingStateUpdater.invoke(this.mentionsLoadingState));
                if (this.mentionsLoadingState.isLoading() || this.mentionsLoadingState.isAllLoaded() || (interactionState = this.interactionState) == null || !interactionState.isAtTopIgnoringTouch() || !this.isFocused) {
                    return;
                }
                setMentionsLoadingState(LoadingState.copy$default(this.mentionsLoadingState, true, false, null, 6, null));
                Observable observableG = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getMentions(this.mentionLimit, this.filters.getIncludeRoles(), this.filters.getIncludeEveryone(), Long.valueOf(this.filters.getAllGuilds() ? 0L : this.filters.getGuildId()), this.loadBeforeMessageId), false, 1, null)).G(WidgetUserMentions$Model$MessageLoader$tryLoad$2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "RestAPI\n            .api…messages.map(::Message) }");
                ObservableExtensionsKt.appSubscribe$default(observableG, MessageLoader.class, (Context) null, new WidgetUserMentions$Model$MessageLoader$tryLoad$5(this), new WidgetUserMentions$Model$MessageLoader$tryLoad$3(this), (Function0) null, (Function0) null, new WidgetUserMentions$Model$MessageLoader$tryLoad$4(this), 50, (Object) null);
            }
        }

        public Model(long j, long j2, Guild guild, long j3, Map<Long, String> map, long j4, List<ChatListEntry> list, Set<Long> set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab) {
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(set, "myRoleIds");
            Intrinsics3.checkNotNullParameter(navigationTab, "selectedTab");
            this.userId = j;
            this.channelId = j2;
            this.guild = guild;
            this.guildId = j3;
            this.channelNames = map;
            this.oldestMessageId = j4;
            this.list = list;
            this.myRoleIds = set;
            this.newMessagesMarkerMessageId = j5;
            this.isSpoilerClickAllowed = z2;
            this.animateEmojis = z3;
            this.guildName = str;
            this.selectedTab = navigationTab;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.getUserId() : j, (i & 2) != 0 ? model.getChannelId() : j2, (i & 4) != 0 ? model.getGuild() : guild, (i & 8) != 0 ? model.getGuildId() : j3, (i & 16) != 0 ? model.getChannelNames() : map, (i & 32) != 0 ? model.getOldestMessageId() : j4, (i & 64) != 0 ? model.getList() : list, (i & 128) != 0 ? model.getMyRoleIds() : set, (i & 256) != 0 ? model.getNewMessagesMarkerMessageId() : j5, (i & 512) != 0 ? model.getIsSpoilerClickAllowed() : z2, (i & 1024) != 0 ? model.animateEmojis : z3, (i & 2048) != 0 ? model.guildName : str, (i & 4096) != 0 ? model.selectedTab : navigationTab);
        }

        public final long component1() {
            return getUserId();
        }

        public final boolean component10() {
            return getIsSpoilerClickAllowed();
        }

        /* renamed from: component11, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        /* renamed from: component12, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component13, reason: from getter */
        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        public final long component2() {
            return getChannelId();
        }

        public final Guild component3() {
            return getGuild();
        }

        public final long component4() {
            return getGuildId();
        }

        public final Map<Long, String> component5() {
            return getChannelNames();
        }

        public final long component6() {
            return getOldestMessageId();
        }

        public final List<ChatListEntry> component7() {
            return getList();
        }

        public final Set<Long> component8() {
            return getMyRoleIds();
        }

        public final long component9() {
            return getNewMessagesMarkerMessageId();
        }

        public final Model copy(long userId, long channelId, Guild guild, long guildId, Map<Long, String> channelNames, long oldestMessageId, List<ChatListEntry> list, Set<Long> myRoleIds, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed, boolean animateEmojis, String guildName, NavigationTab selectedTab) {
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
            Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
            return new Model(userId, channelId, guild, guildId, channelNames, oldestMessageId, list, myRoleIds, newMessagesMarkerMessageId, isSpoilerClickAllowed, animateEmojis, guildName, selectedTab);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return getUserId() == model.getUserId() && getChannelId() == model.getChannelId() && Intrinsics3.areEqual(getGuild(), model.getGuild()) && getGuildId() == model.getGuildId() && Intrinsics3.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && Intrinsics3.areEqual(getList(), model.getList()) && Intrinsics3.areEqual(getMyRoleIds(), model.getMyRoleIds()) && getNewMessagesMarkerMessageId() == model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == model.getIsSpoilerClickAllowed() && this.animateEmojis == model.animateEmojis && Intrinsics3.areEqual(this.guildName, model.guildName) && Intrinsics3.areEqual(this.selectedTab, model.selectedTab);
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public List<ChatListEntry> getList() {
            return this.list;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Set<Long> getMyRoleIds() {
            return this.myRoleIds;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getNewMessagesMarkerMessageId() {
            return this.newMessagesMarkerMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getOldestMessageId() {
            return this.oldestMessageId;
        }

        public final NavigationTab getSelectedTab() {
            return this.selectedTab;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            int iA = (b.a(getChannelId()) + (b.a(getUserId()) * 31)) * 31;
            Guild guild = getGuild();
            int iA2 = (b.a(getGuildId()) + ((iA + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iA3 = (b.a(getOldestMessageId()) + ((iA2 + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            List<ChatListEntry> list = getList();
            int iHashCode = (iA3 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            int iA4 = (b.a(getNewMessagesMarkerMessageId()) + ((iHashCode + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31;
            boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
            int i = isSpoilerClickAllowed;
            if (isSpoilerClickAllowed) {
                i = 1;
            }
            int i2 = (iA4 + i) * 31;
            boolean z2 = this.animateEmojis;
            int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            String str = this.guildName;
            int iHashCode2 = (i3 + (str != null ? str.hashCode() : 0)) * 31;
            NavigationTab navigationTab = this.selectedTab;
            return iHashCode2 + (navigationTab != null ? navigationTab.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(userId=");
            sbU.append(getUserId());
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(", guild=");
            sbU.append(getGuild());
            sbU.append(", guildId=");
            sbU.append(getGuildId());
            sbU.append(", channelNames=");
            sbU.append(getChannelNames());
            sbU.append(", oldestMessageId=");
            sbU.append(getOldestMessageId());
            sbU.append(", list=");
            sbU.append(getList());
            sbU.append(", myRoleIds=");
            sbU.append(getMyRoleIds());
            sbU.append(", newMessagesMarkerMessageId=");
            sbU.append(getNewMessagesMarkerMessageId());
            sbU.append(", isSpoilerClickAllowed=");
            sbU.append(getIsSpoilerClickAllowed());
            sbU.append(", animateEmojis=");
            sbU.append(this.animateEmojis);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", selectedTab=");
            sbU.append(this.selectedTab);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ Model(long j, long j2, Guild guild, long j3, Map map, long j4, List list, Set set, long j5, boolean z2, boolean z3, String str, NavigationTab navigationTab, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, guild, j3, map, j4, list, set, j5, (i & 512) != 0 ? false : z2, z3, str, navigationTab);
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010P\u001a\u00020\u000b\u0012\u0006\u0010N\u001a\u00020M\u0012\u0012\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040R¢\u0006\u0004\bU\u0010VJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u0018H\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0019\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001f\u0010\u0006J#\u0010#\u001a\u00020\u00042\n\u0010!\u001a\u00060\u0017j\u0002` 2\u0006\u0010\"\u001a\u00020\u0017H\u0016¢\u0006\u0004\b#\u0010$JO\u0010,\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010&\u001a\u00060\u0017j\u0002`%2\n\u0010!\u001a\u00060\u0017j\u0002` 2\n\u0010(\u001a\u00060\u0017j\u0002`'2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000bH\u0016¢\u0006\u0004\b,\u0010-J;\u0010.\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010!\u001a\u00060\u0017j\u0002` 2\n\u0010(\u001a\u00060\u0017j\u0002`'2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b.\u0010/J?\u00100\u001a\u00020\u00042\n\u0010\u0019\u001a\u00060\u0017j\u0002`\u00182\n\u0010&\u001a\u00060\u0017j\u0002`%2\n\u0010!\u001a\u00060\u0017j\u0002` 2\n\u0010(\u001a\u00060\u0017j\u0002`'H\u0016¢\u0006\u0004\b0\u00101J\u001f\u00106\u001a\u00020\u000b2\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b8\u0010\u0006JK\u0010@\u001a\u00020\u00042\n\u00109\u001a\u00060\u0017j\u0002`%2\n\u0010!\u001a\u00060\u0017j\u0002` 2\n\u0010(\u001a\u00060\u0017j\u0002`'2\u0006\u0010;\u001a\u00020:2\u0006\u0010=\u001a\u00020<2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010CJ#\u0010G\u001a\u00020\u00042\n\u0010D\u001a\u00060\u0017j\u0002` 2\u0006\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010K\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040R8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$UserMentionsAdapterEventHandler;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "Lcom/discord/models/message/Message;", "message", "", "jumpToMessage", "(Lcom/discord/models/message/Message;)V", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "onInteractionStateUpdated", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "", "isThreadStarterMessage", "onMessageClicked", "(Lcom/discord/models/message/Message;Z)V", "Lcom/discord/api/channel/Channel;", "channel", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "", "formattedMessage", "onMessageLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;Z)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "onMessageAuthorNameClicked", "(Lcom/discord/models/message/Message;J)V", "onMessageAuthorAvatarClicked", "onMessageAuthorLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/Long;)V", "onMessageBlockedGroupClicked", "Lcom/discord/primitives/ChannelId;", "channelId", "oldestMessageId", "onOldestMessageId", "(JJ)V", "Lcom/discord/primitives/UserId;", "myUserId", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "canAddReactions", "onReactionClicked", "(JJJJLcom/discord/api/message/reaction/MessageReaction;Z)V", "onReactionLongClicked", "(JJJLcom/discord/api/message/reaction/MessageReaction;)V", "onQuickAddReactionClicked", "(JJJJ)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "", "fileName", "onQuickDownloadClicked", "(Landroid/net/Uri;Ljava/lang/String;)Z", "onOpenPinsClicked", "authorId", "Lcom/discord/api/message/activity/MessageActivityType;", "actionType", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/application/Application;", "application", "onUserActivityAction", "(JJJLcom/discord/api/message/activity/MessageActivityType;Lcom/discord/api/activity/Activity;Lcom/discord/api/application/Application;)V", "onListClicked", "()V", "voiceChannelId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "callStatus", "onCallMessageClicked", "(JLcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;)V", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "onStickerClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "Lcom/discord/utilities/channel/ChannelSelector;", "channelSelector", "Lcom/discord/utilities/channel/ChannelSelector;", "isEmbedded", "Z", "Lkotlin/Function1;", "interactionStateUpdated", "Lkotlin/jvm/functions/Function1;", "<init>", "(ZLcom/discord/utilities/channel/ChannelSelector;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UserMentionsAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Function1<StoreChat.InteractionState, Unit> interactionStateUpdated;
        private final boolean isEmbedded;

        /* JADX WARN: Multi-variable type inference failed */
        public UserMentionsAdapterEventHandler(boolean z2, ChannelSelector channelSelector, Function1<? super StoreChat.InteractionState, Unit> function1) {
            Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
            Intrinsics3.checkNotNullParameter(function1, "interactionStateUpdated");
            this.isEmbedded = z2;
            this.channelSelector = channelSelector;
            this.interactionStateUpdated = function1;
        }

        private final void jumpToMessage(Message message) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            companion.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            companion.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, this.isEmbedded);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
            Intrinsics3.checkNotNullParameter(componentInteractionData, "componentSendData");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, componentInteractionData);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long j, Long l, long j2, long j3, long j4, long j5, String str) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCommandClicked(this, j, l, j2, j3, j4, j5, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
            this.interactionStateUpdated.invoke(interactionState);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToMessage(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String fileName) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(fileName, "fileName");
            return false;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            Intrinsics3.checkNotNullParameter(weakReference, "weakContext");
            Intrinsics3.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, StoreChannelsSelected3.EMBED, 2, null);
            StoreStream.INSTANCE.getTabsNavigation().selectHomeTab(StoreNavigation.PanelAction.CLOSE, this.isEmbedded);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onThreadLongClicked(this, channel);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String str) {
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUrlLongClicked(this, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            Intrinsics3.checkNotNullParameter(actionType, "actionType");
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long j, long j2, long j3) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserMentionClicked(this, j, j2, j3);
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$WidgetUserMentionFilter;", "Lcom/discord/app/AppBottomSheet;", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "filters", "", "updateFilters", "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;)V", "Lkotlinx/coroutines/Job;", "delayedDismiss", "()Lkotlinx/coroutines/Job;", "", "getContentViewResId", "()I", "onResume", "()V", "onPause", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "", "guildName", "Ljava/lang/String;", "Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", "binding", "Lkotlin/Function1;", "onFiltersUpdated", "Lkotlin/jvm/functions/Function1;", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class WidgetUserMentionFilter extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserMentionFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMentionsFilterBinding;", 0)};

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;
        private Model.MessageLoader.Filters filters;
        private String guildName;
        private Function1<? super Model.MessageLoader.Filters, Unit> onFiltersUpdated;

        /* compiled from: WidgetUserMentions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$WidgetUserMentionFilter$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "guildName", "Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "filters", "Lkotlin/Function1;", "", "onFiltersUpdated", "Lcom/discord/widgets/user/WidgetUserMentions$WidgetUserMentionFilter;", "show", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;Lkotlin/jvm/functions/Function1;)Lcom/discord/widgets/user/WidgetUserMentions$WidgetUserMentionFilter;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final WidgetUserMentionFilter show(FragmentManager fragmentManager, String guildName, Model.MessageLoader.Filters filters, Function1<? super Model.MessageLoader.Filters, Unit> onFiltersUpdated) {
                Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
                Intrinsics3.checkNotNullParameter(filters, "filters");
                Intrinsics3.checkNotNullParameter(onFiltersUpdated, "onFiltersUpdated");
                WidgetUserMentionFilter widgetUserMentionFilter = new WidgetUserMentionFilter();
                WidgetUserMentionFilter.access$setOnFiltersUpdated$p(widgetUserMentionFilter, onFiltersUpdated);
                WidgetUserMentionFilter.access$setFilters$p(widgetUserMentionFilter, filters);
                WidgetUserMentionFilter.access$setGuildName$p(widgetUserMentionFilter, guildName);
                widgetUserMentionFilter.show(fragmentManager, WidgetUserMentionFilter.class.getName());
                return widgetUserMentionFilter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public WidgetUserMentionFilter() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserMentions$WidgetUserMentionFilter$binding$2.INSTANCE, null, 2, null);
        }

        public static final /* synthetic */ Job access$delayedDismiss(WidgetUserMentionFilter widgetUserMentionFilter) {
            return widgetUserMentionFilter.delayedDismiss();
        }

        public static final /* synthetic */ WidgetUserMentionsFilterBinding access$getBinding$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            return widgetUserMentionFilter.getBinding();
        }

        public static final /* synthetic */ Model.MessageLoader.Filters access$getFilters$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            Model.MessageLoader.Filters filters = widgetUserMentionFilter.filters;
            if (filters == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            return filters;
        }

        public static final /* synthetic */ String access$getGuildName$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            return widgetUserMentionFilter.guildName;
        }

        public static final /* synthetic */ Function1 access$getOnFiltersUpdated$p(WidgetUserMentionFilter widgetUserMentionFilter) {
            Function1<? super Model.MessageLoader.Filters, Unit> function1 = widgetUserMentionFilter.onFiltersUpdated;
            if (function1 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("onFiltersUpdated");
            }
            return function1;
        }

        public static final /* synthetic */ void access$setFilters$p(WidgetUserMentionFilter widgetUserMentionFilter, Model.MessageLoader.Filters filters) {
            widgetUserMentionFilter.filters = filters;
        }

        public static final /* synthetic */ void access$setGuildName$p(WidgetUserMentionFilter widgetUserMentionFilter, String str) {
            widgetUserMentionFilter.guildName = str;
        }

        public static final /* synthetic */ void access$setOnFiltersUpdated$p(WidgetUserMentionFilter widgetUserMentionFilter, Function1 function1) {
            widgetUserMentionFilter.onFiltersUpdated = function1;
        }

        public static final /* synthetic */ void access$updateFilters(WidgetUserMentionFilter widgetUserMentionFilter, Model.MessageLoader.Filters filters) {
            widgetUserMentionFilter.updateFilters(filters);
        }

        private final Job delayedDismiss() {
            CoroutineScope coroutineScope;
            View view = getView();
            if (view == null || (coroutineScope = ViewCoroutineScope.getCoroutineScope(view)) == null) {
                return null;
            }
            return f.H0(coroutineScope, null, null, new WidgetUserMentions$WidgetUserMentionFilter$delayedDismiss$1(this, null), 3, null);
        }

        private final WidgetUserMentionsFilterBinding getBinding() {
            return (WidgetUserMentionsFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        private final void updateFilters(Model.MessageLoader.Filters filters) {
            this.filters = filters;
            Function1<? super Model.MessageLoader.Filters, Unit> function1 = this.onFiltersUpdated;
            if (function1 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("onFiltersUpdated");
            }
            function1.invoke(filters);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return R.layout.widget_user_mentions_filter;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onPause() {
            dismissAllowingStateLoss();
            super.onPause();
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            CheckedSetting checkedSetting = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterThisServer");
            if (this.filters == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting.setChecked(!r2.getAllGuilds());
            String str = this.guildName;
            if (str == null || StringsJVM.isBlank(str)) {
                CheckedSetting checkedSetting2 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.userMentionsFilterThisServer");
                checkedSetting2.setVisibility(8);
            } else {
                CheckedSetting checkedSetting3 = getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.userMentionsFilterThisServer");
                checkedSetting3.setVisibility(0);
                CheckedSetting checkedSetting4 = getBinding().d;
                Context context = getContext();
                checkedSetting4.setText(context != null ? FormatUtils.h(context, R.string.this_server_named, new Object[]{this.guildName}, null, 4) : null);
                getBinding().d.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$1(this));
            }
            CheckedSetting checkedSetting5 = getBinding().f2683b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.userMentionsFilterIncludeEveryone");
            Model.MessageLoader.Filters filters = this.filters;
            if (filters == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting5.setChecked(filters.getIncludeEveryone());
            getBinding().f2683b.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$2(this));
            CheckedSetting checkedSetting6 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.userMentionsFilterIncludeRoles");
            Model.MessageLoader.Filters filters2 = this.filters;
            if (filters2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("filters");
            }
            checkedSetting6.setChecked(filters2.getIncludeRoles());
            getBinding().c.setOnCheckedListener(new WidgetUserMentions$WidgetUserMentionFilter$onResume$3(this));
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "menuItem", "Landroid/content/Context;", "<anonymous parameter 1>", "", NotificationCompat.CATEGORY_CALL, "(Landroid/view/MenuItem;Landroid/content/Context;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$configureToolbar$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ String $guildName;

        /* compiled from: WidgetUserMentions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;", "filters", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserMentions$Model$MessageLoader$Filters;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.user.WidgetUserMentions$configureToolbar$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03501 extends Lambda implements Function1<Model.MessageLoader.Filters, Unit> {
            public C03501() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Model.MessageLoader.Filters filters) {
                invoke2(filters);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Model.MessageLoader.Filters filters) {
                Intrinsics3.checkNotNullParameter(filters, "filters");
                WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this).setFilters(filters);
            }
        }

        public AnonymousClass1(String str) {
            this.$guildName = str;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() == R.id.menu_user_mentions_filter) {
                WidgetUserMentionFilter.Companion companion = WidgetUserMentionFilter.INSTANCE;
                FragmentManager parentFragmentManager = WidgetUserMentions.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, this.$guildName, WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this).getFilters(), new C03501());
            }
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/widgets/tabs/NavigationTab;", "kotlin.jvm.PlatformType", "selectedTab", "Lrx/Observable;", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/tabs/NavigationTab;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$observeModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<NavigationTab, Observable<? extends Model>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Model> call(NavigationTab navigationTab) {
            return call2(navigationTab);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Model> call2(NavigationTab navigationTab) {
            if (navigationTab == NavigationTab.MENTIONS) {
                return Model.INSTANCE.get(WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this), navigationTab);
            }
            Model.Companion companion = Model.INSTANCE;
            Model.MessageLoader messageLoaderAccess$getMentionsLoader$p = WidgetUserMentions.access$getMentionsLoader$p(WidgetUserMentions.this);
            Intrinsics3.checkNotNullExpressionValue(navigationTab, "selectedTab");
            return companion.get(messageLoaderAccess$getMentionsLoader$p, navigationTab).Z(1);
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserMentions.access$getDismissViewModel$p(WidgetUserMentions.this).dismiss();
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreChat$InteractionState;", "p1", "", "invoke", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<StoreChat.InteractionState, Unit> {
        public AnonymousClass2(Model.MessageLoader messageLoader) {
            super(1, messageLoader, Model.MessageLoader.class, "setInteractionState", "setInteractionState(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.InteractionState interactionState) {
            invoke2(interactionState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "p1");
            ((Model.MessageLoader) this.receiver).setInteractionState(interactionState);
        }
    }

    /* compiled from: WidgetUserMentions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentions$Model;", "it", "", "invoke", "(Lcom/discord/widgets/user/WidgetUserMentions$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.WidgetUserMentions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetUserMentions.access$configureUI(WidgetUserMentions.this, model);
        }
    }

    public WidgetUserMentions() {
        super(R.layout.widget_user_mentions);
        this.isEmbedded = FragmentExtensions.booleanExtra$default(this, EXTRA_IS_EMBEDDED, false, 2, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserMentions$binding$2.INSTANCE, null, 2, null);
        this.mentionsLoader = new Model.MessageLoader(1000L);
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetUserMentions$$special$$inlined$activityViewModels$1(this), new WidgetUserMentions$$special$$inlined$activityViewModels$2(this));
        WidgetUserMentions$viewModel$2 widgetUserMentions$viewModel$2 = WidgetUserMentions$viewModel$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserMentionsViewModel.class), new WidgetUserMentions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserMentions$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMentions widgetUserMentions, Model model) {
        widgetUserMentions.configureUI(model);
    }

    public static final /* synthetic */ WidgetGlobalSearchDismissModel access$getDismissViewModel$p(WidgetUserMentions widgetUserMentions) {
        return widgetUserMentions.getDismissViewModel();
    }

    public static final /* synthetic */ Model.MessageLoader access$getMentionsLoader$p(WidgetUserMentions widgetUserMentions) {
        return widgetUserMentions.mentionsLoader;
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().c.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureToolbar(String guildName) {
        AppFragment.bindToolbar$default(this, null, 1, null);
        String string = this.mentionsLoader.getFilters().getAllGuilds() ? getString(R.string.all_servers) : guildName;
        if (isEmbedded()) {
            setActionBarTitle(string);
        } else {
            setActionBarSubtitle(string);
        }
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_user_mentions, new AnonymousClass1(guildName), null, 4, null);
    }

    private final void configureUI(Model model) {
        boolean allGuilds = model.getGuildId() > 0 ? this.mentionsLoader.getFilters().getAllGuilds() : true;
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
        Model.MessageLoader messageLoader = this.mentionsLoader;
        messageLoader.setFilters(Model.MessageLoader.Filters.copy$default(messageLoader.getFilters(), model.getGuildId(), allGuilds, false, false, 12, null));
        this.mentionsLoader.setIsFocused(model.getSelectedTab() == NavigationTab.MENTIONS);
        if (isEmbedded() || isOnMentionsTab()) {
            configureToolbar(model.getGuildName());
        }
        getViewModel().setModel$app_productionGoogleRelease(model);
    }

    private final WidgetChatListAdapter createAdapter(Function1<? super StoreChat.InteractionState, Unit> onInteractionStateUpdated) {
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userMentionsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new UserMentionsAdapterEventHandler(isEmbedded(), ChannelSelector.INSTANCE.getInstance(), onInteractionStateUpdated), null, null, 48, null);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        return widgetChatListAdapter;
    }

    private final WidgetUserMentionsBinding getBinding() {
        return (WidgetUserMentionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final WidgetUserMentionsViewModel getViewModel() {
        return (WidgetUserMentionsViewModel) this.viewModel.getValue();
    }

    private final boolean isEmbedded() {
        return ((Boolean) this.isEmbedded.getValue()).booleanValue();
    }

    private final boolean isOnMentionsTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.MENTIONS;
    }

    private final Observable<Model> observeModel() {
        if (isEmbedded()) {
            return Model.INSTANCE.get(this.mentionsLoader, NavigationTab.MENTIONS);
        }
        Observable observableY = StoreStream.INSTANCE.getTabsNavigation().observeSelectedTab().Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream.getTabsNavig…          }\n            }");
        return observableY;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        Model model$app_productionGoogleRelease = getViewModel().getModel();
        if (model$app_productionGoogleRelease != null) {
            configureToolbar(model$app_productionGoogleRelease.getGuildName());
        }
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        LinearLayoutManager layoutManager;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (isEmbedded()) {
            onTabSelected();
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            getBinding().f2682b.setNavigationOnClickListener(new AnonymousClass1());
        } else {
            setActionBarTitle(R.string.recent_mentions);
        }
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) MGRecyclerAdapter.INSTANCE.configure(createAdapter(new AnonymousClass2(this.mentionsLoader)));
        this.mentionsAdapter = widgetChatListAdapter;
        if (widgetChatListAdapter != null && (layoutManager = widgetChatListAdapter.getLayoutManager()) != null) {
            layoutManager.setSmoothScrollbarEnabled(true);
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.mentionsAdapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.setMentionMeMessageLevelHighlighting(false);
        }
        Fragment parentFragment = getParentFragment();
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) (parentFragment instanceof WidgetTabsHost ? parentFragment : null);
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.MENTIONS, this);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observeModel()), this, null, 2, null), WidgetUserMentions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.mentionsAdapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
        Model.MessageLoader.tryLoad$default(this.mentionsLoader, null, 1, null);
    }
}
