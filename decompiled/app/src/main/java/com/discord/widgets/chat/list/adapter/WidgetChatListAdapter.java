package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
import com.discord.app.AppFragment;
import com.discord.app.AppPermissions2;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.entries.NewMessagesEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import d0.Result3;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.functions.Action0;

/* compiled from: WidgetChatListAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0092\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0010\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001BC\b\u0007\u0012\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001\u0012\u0006\u0010{\u001a\u00020z\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010q\u001a\u00020p\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010f\u0012\b\b\u0002\u0010l\u001a\u00020k¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0005J!\u0010\r\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\r\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0017\u0010\u0005J)\u0010\u001c\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!J!\u0010#\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\u00032\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\b%\u0010&J=\u0010/\u001a\u00020\u00032\n\u0010(\u001a\u00060\bj\u0002`'2\n\u0010\n\u001a\u00060\bj\u0002`\t2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u001d\u00105\u001a\u00020\u00032\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J1\u0010>\u001a\u00020\u00032\u0006\u00108\u001a\u0002072\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<09¢\u0006\u0004\b>\u0010?JC\u0010G\u001a\u00020\u00032\n\u0010A\u001a\u00060\bj\u0002`@2\n\u0010\n\u001a\u00060\bj\u0002`\t2\b\u0010B\u001a\u0004\u0018\u00010\b2\n\u0010D\u001a\u00060\u0011j\u0002`C2\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ!\u0010J\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\b2\n\u0010\n\u001a\u00060\bj\u0002`\t¢\u0006\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010S\u001a\u00020R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Z\u001a\u00060YR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0015\u0010_\u001a\u0004\u0018\u00010\\8F@\u0006¢\u0006\u0006\u001a\u0004\b]\u0010^R\u001a\u0010a\u001a\u00060`R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u001a\u0010d\u001a\u00060cR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001b\u0010g\u001a\u0004\u0018\u00010f8\u0006@\u0006¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u0019\u0010l\u001a\u00020k8\u0006@\u0006¢\u0006\f\n\u0004\bl\u0010m\u001a\u0004\bn\u0010oR\u0019\u0010q\u001a\u00020p8\u0006@\u0006¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0019\u0010v\u001a\u00020u8\u0006@\u0006¢\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0019\u0010{\u001a\u00020z8\u0006@\u0006¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R2\u0010\u0081\u0001\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u007f8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010MR\u001c\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u009a\u0001"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "publishInteractionState", "()V", "setHandlers", "disposeHandlers", "", "Lcom/discord/primitives/MessageId;", "messageId", "Lrx/functions/Action0;", "onCompleted", "scrollToMessageId", "(JLrx/functions/Action0;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onResume", "onPause", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "", "canAddReactions", "onReactionClicked", "(JLcom/discord/api/message/reaction/MessageReaction;Z)V", "Lcom/discord/api/channel/Channel;", "channel", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "onThreadLongClicked", "onReactionLongClicked", "(JLcom/discord/api/message/reaction/MessageReaction;)V", "onQuickAddReactionClicked", "(J)V", "Lcom/discord/primitives/UserId;", "authorId", "Lcom/discord/api/message/activity/MessageActivityType;", "messageActivityType", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/application/Application;", "application", "onUserActivityAction", "(JJLcom/discord/api/message/activity/MessageActivityType;Lcom/discord/api/activity/Activity;Lcom/discord/api/application/Application;)V", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "onStickerClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildEvent", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "weakContext", "Lcom/discord/app/AppFragment;", "weakFragment", "onShareButtonClick", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "Lcom/discord/primitives/ApplicationId;", "applicationId", "messageFlags", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "componentSendData", "onBotUiComponentClicked", "(JJLjava/lang/Long;ILcom/discord/restapi/RestAPIParams$ComponentInteractionData;)V", "roleSubscriptionListingId", "onRoleSubscriptionPurchaseSystemMessageClicked", "(JJ)V", "mentionMeMessageLevelHighlighting", "Z", "getMentionMeMessageLevelHighlighting", "()Z", "setMentionMeMessageLevelHighlighting", "(Z)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfTouches;", "handlerOfTouches", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfTouches;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfUpdates;", "handlerOfUpdates", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfUpdates;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfScrolls;", "handlerOfScrolls", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfScrolls;", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "getFlexInputViewModel", "()Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "getClock", "()Lcom/discord/utilities/time/Clock;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "eventHandler", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "getEventHandler", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "Lcom/discord/widgets/botuikit/ComponentProvider;", "botUiComponentProvider", "Lcom/discord/widgets/botuikit/ComponentProvider;", "getBotUiComponentProvider", "()Lcom/discord/widgets/botuikit/ComponentProvider;", "Lcom/discord/app/AppPermissionsRequests;", "appPermissionsRequests", "Lcom/discord/app/AppPermissionsRequests;", "getAppPermissionsRequests", "()Lcom/discord/app/AppPermissionsRequests;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "value", "data", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "getData", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "setData", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;)V", "isTouchedSinceLastJump", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$ScrollToWithHighlight;", "scrollToWithHighlight", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$ScrollToWithHighlight;", "Lkotlinx/coroutines/Job;", "lastUpdateJob", "Lkotlinx/coroutines/Job;", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/discord/app/AppPermissionsRequests;Landroidx/fragment/app/FragmentManager;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;Lcom/discord/widgets/chat/input/AppFlexInputViewModel;Lcom/discord/utilities/time/Clock;)V", "Companion", "Data", "EmptyData", "EventHandler", "HandlerOfScrolls", "HandlerOfTouches", "HandlerOfUpdates", "ScrollToWithHighlight", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapter extends MGRecyclerAdapterSimple<ChatListEntry> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NEW_MESSAGES_MAX_SCROLLBACK_COUNT = 30;
    private static final int NEW_MESSAGES_MIN_SCROLLBACK_COUNT = 10;
    private final AppPermissions2 appPermissionsRequests;
    private final ComponentProvider botUiComponentProvider;
    private final Clock clock;
    private Data data;
    private final EventHandler eventHandler;
    private final AppFlexInputViewModel flexInputViewModel;
    private FragmentManager fragmentManager;
    private final HandlerOfScrolls handlerOfScrolls;
    private final HandlerOfTouches handlerOfTouches;
    private final HandlerOfUpdates handlerOfUpdates;
    private boolean isTouchedSinceLastJump;
    private Job lastUpdateJob;
    private boolean mentionMeMessageLevelHighlighting;
    private ScrollToWithHighlight scrollToWithHighlight;

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Companion;", "", "", "numKnownMessages", "findBestNewMessagesPosition", "(I)I", "NEW_MESSAGES_MAX_SCROLLBACK_COUNT", "I", "NEW_MESSAGES_MIN_SCROLLBACK_COUNT", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$findBestNewMessagesPosition(Companion companion, int i) {
            return companion.findBestNewMessagesPosition(i);
        }

        private final int findBestNewMessagesPosition(int numKnownMessages) {
            if (-1 <= numKnownMessages && 10 > numKnownMessages) {
                return -1;
            }
            if (10 <= numKnownMessages && 30 > numKnownMessages) {
                return numKnownMessages;
            }
            return 30;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\t\u001a\u00060\u0005j\u0002`\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\f\u001a\u00060\u0005j\u0002`\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00130\u00128&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\u00060\u0005j\u0002`\u00178&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\bR\u001a\u0010\u001b\u001a\u00060\u0005j\u0002`\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR&\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\n\u0012\u0004\u0012\u00020!0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010'\u001a\u00060\u0005j\u0002`%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\b¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "", "", "isSpoilerClickAllowed", "()Z", "", "Lcom/discord/primitives/MessageId;", "getOldestMessageId", "()J", "oldestMessageId", "Lcom/discord/primitives/ChannelId;", "getChannelId", "channelId", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "getList", "()Ljava/util/List;", "list", "", "Lcom/discord/primitives/RoleId;", "getMyRoleIds", "()Ljava/util/Set;", "myRoleIds", "Lcom/discord/primitives/GuildId;", "getGuildId", "guildId", "getNewMessagesMarkerMessageId", "newMessagesMarkerMessageId", "Lcom/discord/models/guild/Guild;", "getGuild", "()Lcom/discord/models/guild/Guild;", "guild", "", "", "getChannelNames", "()Ljava/util/Map;", "channelNames", "Lcom/discord/primitives/UserId;", "getUserId", "userId", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface Data {
        long getChannelId();

        Map<Long, String> getChannelNames();

        Guild getGuild();

        long getGuildId();

        List<ChatListEntry> getList();

        Set<Long> getMyRoleIds();

        long getNewMessagesMarkerMessageId();

        long getOldestMessageId();

        long getUserId();

        /* renamed from: isSpoilerClickAllowed */
        boolean getIsSpoilerClickAllowed();
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R \u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\r\u001a\u00060\u0006j\u0002`\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR&\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00100\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u00060\u0006j\u0002`\u001a8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R,\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\f\u0012\u0004\u0012\u00020$0#8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R \u0010)\u001a\u00060\u0006j\u0002`\u00078\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000bR \u0010,\u001a\u00060\u0006j\u0002`+8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000b¨\u00060"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EmptyData;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "", "isSpoilerClickAllowed", "Z", "()Z", "", "Lcom/discord/primitives/MessageId;", "oldestMessageId", "J", "getOldestMessageId", "()J", "Lcom/discord/primitives/ChannelId;", "channelId", "getChannelId", "", "Lcom/discord/primitives/RoleId;", "myRoleIds", "Ljava/util/Set;", "getMyRoleIds", "()Ljava/util/Set;", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/models/guild/Guild;", "getGuild", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/primitives/UserId;", "userId", "getUserId", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "", "", "channelNames", "Ljava/util/Map;", "getChannelNames", "()Ljava/util/Map;", "newMessagesMarkerMessageId", "getNewMessagesMarkerMessageId", "Lcom/discord/primitives/GuildId;", "guildId", "getGuildId", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class EmptyData implements Data {
        private final long channelId;
        private final Guild guild;
        private final long guildId;
        private final boolean isSpoilerClickAllowed;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final long userId;
        private final Map<Long, String> channelNames = Maps6.emptyMap();
        private final List<ChatListEntry> list = Collections2.emptyList();
        private final Set<Long> myRoleIds = Sets5.emptySet();

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

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010\u000b\u001a\u00060\u0007j\u0002`\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b!\u0010\"J#\u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010$\u001a\u00060\u0007j\u0002`#H\u0016¢\u0006\u0004\b%\u0010&J#\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010$\u001a\u00060\u0007j\u0002`#H\u0016¢\u0006\u0004\b'\u0010&J'\u0010(\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010$\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`#H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b*\u0010\"JO\u00101\u001a\u00020\u00042\n\u0010$\u001a\u00060\u0007j\u0002`#2\n\u0010,\u001a\u00060\u0007j\u0002`+2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\n2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b1\u00102J;\u00103\u001a\u00020\u00042\n\u0010$\u001a\u00060\u0007j\u0002`#2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\n2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b3\u00104J3\u00106\u001a\u00020\u00042\n\u00105\u001a\u00060\u0007j\u0002`+2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010$\u001a\u00060\u0007j\u0002`#H\u0016¢\u0006\u0004\b6\u00107J?\u00108\u001a\u00020\u00042\n\u0010$\u001a\u00060\u0007j\u0002`#2\n\u0010,\u001a\u00060\u0007j\u0002`+2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\nH\u0016¢\u0006\u0004\b8\u00109J\u001f\u0010=\u001a\u00020\u00102\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u001dH\u0016¢\u0006\u0004\b=\u0010>JK\u0010F\u001a\u00020\u00042\n\u0010?\u001a\u00060\u0007j\u0002`+2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\n2\u0006\u0010A\u001a\u00020@2\u0006\u0010C\u001a\u00020B2\u0006\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0004H\u0016¢\u0006\u0004\bH\u0010IJ#\u0010M\u001a\u00020\u00042\n\u0010J\u001a\u00060\u0007j\u0002`\b2\u0006\u0010L\u001a\u00020KH\u0016¢\u0006\u0004\bM\u0010NJ\u001f\u0010Q\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ+\u0010V\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010T\u001a\u00020S2\u0006\u0010P\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\bX\u0010\"J\u0017\u0010Y\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\bY\u0010\"J\u001f\u0010\\\u001a\u00020\u00042\u0006\u0010[\u001a\u00020Z2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\\\u0010]JK\u0010b\u001a\u00020\u00042\u0006\u0010^\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u00072\u0006\u0010`\u001a\u00020\u00072\b\u0010a\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\bb\u0010cJa\u0010j\u001a\u00020\u00042\n\u0010`\u001a\u00060\u0007j\u0002`d2\u000e\u0010$\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`#2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\n2\b\u0010e\u001a\u0004\u0018\u00010\u00072\n\u0010g\u001a\u00060Sj\u0002`f2\u0006\u0010i\u001a\u00020hH\u0016¢\u0006\u0004\bj\u0010kJ'\u0010l\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bl\u0010mJ3\u0010t\u001a\u00020\u00042\u0006\u0010o\u001a\u00020n2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020Z0p2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020r0pH\u0016¢\u0006\u0004\bt\u0010uJG\u0010w\u001a\u00020\u00042\u0006\u0010v\u001a\u00020\u00072\n\u0010$\u001a\u00060\u0007j\u0002`#2\n\u00105\u001a\u00060\u0007j\u0002`+2\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\nH\u0016¢\u0006\u0004\bw\u0010x¨\u0006y"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "", "onInteractionStateUpdated", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "oldestMessageId", "onOldestMessageId", "(JJ)V", "Lcom/discord/models/message/Message;", "message", "", "isThreadStarterMessage", "onMessageClicked", "(Lcom/discord/models/message/Message;Z)V", "Lcom/discord/api/channel/Channel;", "channel", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "onThreadLongClicked", "", "formattedMessage", "onMessageLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;Z)V", "", "url", "onUrlLongClicked", "(Ljava/lang/String;)V", "onOpenPinsClicked", "(Lcom/discord/models/message/Message;)V", "Lcom/discord/primitives/GuildId;", "guildId", "onMessageAuthorNameClicked", "(Lcom/discord/models/message/Message;J)V", "onMessageAuthorAvatarClicked", "onMessageAuthorLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/Long;)V", "onMessageBlockedGroupClicked", "Lcom/discord/primitives/UserId;", "myUserId", "messageId", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "canAddReactions", "onReactionClicked", "(JJJJLcom/discord/api/message/reaction/MessageReaction;Z)V", "onReactionLongClicked", "(JJJLcom/discord/api/message/reaction/MessageReaction;)V", "userId", "onUserMentionClicked", "(JJJ)V", "onQuickAddReactionClicked", "(JJJJ)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "fileName", "onQuickDownloadClicked", "(Landroid/net/Uri;Ljava/lang/String;)Z", "authorId", "Lcom/discord/api/message/activity/MessageActivityType;", "messageActivityType", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/application/Application;", "application", "onUserActivityAction", "(JJJLcom/discord/api/message/activity/MessageActivityType;Lcom/discord/api/activity/Activity;Lcom/discord/api/application/Application;)V", "onListClicked", "()V", "voiceChannelId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "callStatus", "onCallMessageClicked", "(JLcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;)V", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "onStickerClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "", "channelType", "Lcom/discord/api/sticker/Sticker;", "onSendGreetMessageClicked", "(JILcom/discord/api/sticker/Sticker;)V", "onDismissClicked", "onDismissLocalMessageClicked", "Landroid/content/Context;", "context", "onReportIssueWithAutoMod", "(Landroid/content/Context;Lcom/discord/models/message/Message;)V", "interactionId", "interactionUserId", "applicationId", "messageNonce", "onCommandClicked", "(JLjava/lang/Long;JJJJLjava/lang/String;)V", "Lcom/discord/primitives/ApplicationId;", "messageFlags", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "componentSendData", "onBotUiComponentClicked", "(JLjava/lang/Long;JJLjava/lang/Long;ILcom/discord/restapi/RestAPIParams$ComponentInteractionData;)V", "onSystemMessageCtaClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/api/sticker/BaseSticker;)V", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildEvent", "Ljava/lang/ref/WeakReference;", "weakContext", "Lcom/discord/app/AppFragment;", "weakFragment", "onShareButtonClick", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "roleSubscriptionListingId", "onRoleSubscriptionPurchaseTierClick", "(JJJJJ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public interface EventHandler {

        /* compiled from: WidgetChatListAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static final class DefaultImpls {
            public static void onBotUiComponentClicked(EventHandler eventHandler, long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
                Intrinsics3.checkNotNullParameter(componentInteractionData, "componentSendData");
            }

            public static void onCallMessageClicked(EventHandler eventHandler, long j, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
                Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
            }

            public static void onCommandClicked(EventHandler eventHandler, long j, Long l, long j2, long j3, long j4, long j5, String str) {
            }

            public static void onDismissClicked(EventHandler eventHandler, Message message) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onDismissLocalMessageClicked(EventHandler eventHandler, Message message) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onInteractionStateUpdated(EventHandler eventHandler, StoreChat.InteractionState interactionState) {
                Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
            }

            public static void onListClicked(EventHandler eventHandler) {
            }

            public static void onMessageAuthorAvatarClicked(EventHandler eventHandler, Message message, long j) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onMessageAuthorLongClicked(EventHandler eventHandler, Message message, Long l) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onMessageAuthorNameClicked(EventHandler eventHandler, Message message, long j) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onMessageBlockedGroupClicked(EventHandler eventHandler, Message message) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onMessageClicked(EventHandler eventHandler, Message message, boolean z2) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onMessageLongClicked(EventHandler eventHandler, Message message, CharSequence charSequence, boolean z2) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(charSequence, "formattedMessage");
            }

            public static void onOldestMessageId(EventHandler eventHandler, long j, long j2) {
            }

            public static void onOpenPinsClicked(EventHandler eventHandler, Message message) {
                Intrinsics3.checkNotNullParameter(message, "message");
            }

            public static void onQuickAddReactionClicked(EventHandler eventHandler, long j, long j2, long j3, long j4) {
            }

            public static boolean onQuickDownloadClicked(EventHandler eventHandler, Uri uri, String str) {
                Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                Intrinsics3.checkNotNullParameter(str, "fileName");
                return false;
            }

            public static void onReactionClicked(EventHandler eventHandler, long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
                Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
            }

            public static void onReactionLongClicked(EventHandler eventHandler, long j, long j2, long j3, MessageReaction messageReaction) {
                Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
            }

            public static void onReportIssueWithAutoMod(EventHandler eventHandler, Context context, Message message) {
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(message, "message");
                WidgetReportIssueWithAutoMod.INSTANCE.launch(context, message.getChannelId(), message.getId());
            }

            public static void onRoleSubscriptionPurchaseTierClick(EventHandler eventHandler, long j, long j2, long j3, long j4, long j5) {
            }

            public static void onSendGreetMessageClicked(EventHandler eventHandler, long j, int i, Sticker sticker) {
                Intrinsics3.checkNotNullParameter(sticker, "sticker");
            }

            public static void onShareButtonClick(EventHandler eventHandler, GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildEvent");
                Intrinsics3.checkNotNullParameter(weakReference, "weakContext");
                Intrinsics3.checkNotNullParameter(weakReference2, "weakFragment");
            }

            public static void onStickerClicked(EventHandler eventHandler, Message message, BaseSticker baseSticker) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            }

            public static void onSystemMessageCtaClicked(EventHandler eventHandler, Message message, Channel channel, BaseSticker baseSticker) {
                Intrinsics3.checkNotNullParameter(message, "message");
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            }

            public static void onThreadClicked(EventHandler eventHandler, Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
            }

            public static void onThreadLongClicked(EventHandler eventHandler, Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
            }

            public static void onUrlLongClicked(EventHandler eventHandler, String str) {
                Intrinsics3.checkNotNullParameter(str, "url");
            }

            public static void onUserActivityAction(EventHandler eventHandler, long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
                Intrinsics3.checkNotNullParameter(messageActivityType, "messageActivityType");
                Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                Intrinsics3.checkNotNullParameter(application, "application");
            }

            public static void onUserMentionClicked(EventHandler eventHandler, long j, long j2, long j3) {
            }
        }

        void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData);

        void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus);

        void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce);

        void onDismissClicked(Message message);

        void onDismissLocalMessageClicked(Message message);

        void onInteractionStateUpdated(StoreChat.InteractionState interactionState);

        void onListClicked();

        void onMessageAuthorAvatarClicked(Message message, long guildId);

        void onMessageAuthorLongClicked(Message message, Long guildId);

        void onMessageAuthorNameClicked(Message message, long guildId);

        void onMessageBlockedGroupClicked(Message message);

        void onMessageClicked(Message message, boolean isThreadStarterMessage);

        void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage);

        void onOldestMessageId(long channelId, long oldestMessageId);

        void onOpenPinsClicked(Message message);

        void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId);

        boolean onQuickDownloadClicked(Uri uri, String fileName);

        void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions);

        void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction);

        void onReportIssueWithAutoMod(Context context, Message message);

        void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId);

        void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker);

        void onShareButtonClick(GuildScheduledEvent guildEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment);

        void onStickerClicked(Message message, BaseSticker sticker);

        void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker sticker);

        void onThreadClicked(Channel channel);

        void onThreadLongClicked(Channel channel);

        void onUrlLongClicked(String url);

        void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType messageActivityType, Activity activity, Application application);

        void onUserMentionClicked(long userId, long channelId, long guildId);
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfScrolls;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "scrollState", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "I", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class HandlerOfScrolls extends RecyclerView.OnScrollListener {
        private long channelId;
        private int scrollState;

        public HandlerOfScrolls() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, scrollState);
            if (this.scrollState == scrollState && WidgetChatListAdapter.this.getData().getChannelId() == this.channelId) {
                return;
            }
            this.scrollState = scrollState;
            this.channelId = WidgetChatListAdapter.this.getData().getChannelId();
            WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfTouches;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Landroid/view/GestureDetector;", "tapGestureDetector", "Landroid/view/GestureDetector;", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class HandlerOfTouches implements View.OnTouchListener {
        private final GestureDetector tapGestureDetector;

        public HandlerOfTouches() {
            this.tapGestureDetector = new GestureDetector(WidgetChatListAdapter.this.getContext(), new WidgetChatListAdapter2(this));
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            boolean z2 = event != null && event.getAction() == 2;
            if (!WidgetChatListAdapter.access$isTouchedSinceLastJump$p(WidgetChatListAdapter.this) && z2) {
                WidgetChatListAdapter.access$setTouchedSinceLastJump$p(WidgetChatListAdapter.this, true);
                WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
            }
            return this.tapGestureDetector.onTouchEvent(event);
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0007\u001a\u00060\u0005j\u0002`\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00060\u0005j\u0002`\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$HandlerOfUpdates;", "Ljava/lang/Runnable;", "", "run", "()V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "J", "Lcom/discord/primitives/MessageId;", "oldestMessageId", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class HandlerOfUpdates implements Runnable {
        private long channelId;
        private long oldestMessageId;

        public HandlerOfUpdates() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.channelId != WidgetChatListAdapter.this.getData().getChannelId()) {
                boolean z2 = this.channelId != 0;
                this.channelId = WidgetChatListAdapter.this.getData().getChannelId();
                if (z2) {
                    WidgetChatListAdapter.this.scrollToMessageId(0L, WidgetChatListAdapter3.INSTANCE);
                }
                WidgetChatListAdapter.access$setTouchedSinceLastJump$p(WidgetChatListAdapter.this, false);
            }
            if (this.oldestMessageId != WidgetChatListAdapter.this.getData().getOldestMessageId()) {
                this.oldestMessageId = WidgetChatListAdapter.this.getData().getOldestMessageId();
                WidgetChatListAdapter.this.getEventHandler().onOldestMessageId(this.channelId, this.oldestMessageId);
            }
            WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c¢\u0006\u0004\b!\u0010\"J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007R\u0016\u0010\u000f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u00060\u0011j\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$ScrollToWithHighlight;", "Ljava/lang/Runnable;", "Landroid/view/View;", "", "animateHighlight", "(Landroid/view/View;)V", "scheduleRetry", "()V", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "getNewMessageEntryIndex", "(Ljava/util/List;)I", "cancel", "run", "attempts", "I", "", "Lcom/discord/primitives/MessageId;", "messageId", "J", "getMessageId", "()J", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "getAdapter", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lkotlin/Function0;", "onCompleted", "Lkotlin/jvm/functions/Function0;", "getOnCompleted", "()Lkotlin/jvm/functions/Function0;", "<init>", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;JLkotlin/jvm/functions/Function0;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ScrollToWithHighlight implements Runnable {
        private final WidgetChatListAdapter adapter;
        private int attempts;
        private final long messageId;
        private final Function0<Unit> onCompleted;

        public ScrollToWithHighlight(WidgetChatListAdapter widgetChatListAdapter, long j, Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
            Intrinsics3.checkNotNullParameter(function0, "onCompleted");
            this.adapter = widgetChatListAdapter;
            this.messageId = j;
            this.onCompleted = function0;
            widgetChatListAdapter.getRecycler().post(this);
        }

        private final void animateHighlight(View view) {
            view.setBackgroundResource(R.drawable.drawable_bg_highlight);
            Drawable background = view.getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
            TransitionDrawable transitionDrawable = (TransitionDrawable) background;
            transitionDrawable.startTransition(500);
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(view);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetChatListAdapter4(transitionDrawable, null), 3, null);
            }
        }

        private final int getNewMessageEntryIndex(List<? extends ChatListEntry> list) {
            long jLongValue = this.messageId;
            boolean z2 = jLongValue == 0;
            if (jLongValue == 1) {
                return 0;
            }
            Integer num = null;
            if (jLongValue == 0) {
                Long lValueOf = Long.valueOf(this.adapter.getData().getNewMessagesMarkerMessageId());
                if (!(lValueOf.longValue() > 0)) {
                    lValueOf = null;
                }
                if (lValueOf == null) {
                    return 0;
                }
                jLongValue = lValueOf.longValue();
            }
            int iAccess$findBestNewMessagesPosition = -1;
            if (jLongValue <= 0) {
                return -1;
            }
            Iterator<? extends ChatListEntry> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatListEntry next = it.next();
                if ((next instanceof MessageEntry) && ((MessageEntry) next).getMessage().getId() <= jLongValue) {
                    iAccess$findBestNewMessagesPosition = i;
                    break;
                }
                i++;
            }
            if (iAccess$findBestNewMessagesPosition < 0 && z2) {
                iAccess$findBestNewMessagesPosition = Companion.access$findBestNewMessagesPosition(WidgetChatListAdapter.INSTANCE, Collections2.getLastIndex(list));
            }
            Iterator<Integer> it2 = _Ranges.downTo(iAccess$findBestNewMessagesPosition, 0).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Integer next2 = it2.next();
                ChatListEntry chatListEntry = list.get(next2.intValue());
                if ((chatListEntry instanceof NewMessagesEntry) && ((NewMessagesEntry) chatListEntry).getMessageId() == jLongValue) {
                    num = next2;
                    break;
                }
            }
            Integer num2 = num;
            return num2 != null ? num2.intValue() : iAccess$findBestNewMessagesPosition;
        }

        private final void scheduleRetry() {
            int i = this.attempts;
            if (i >= 20) {
                this.onCompleted.invoke();
                return;
            }
            this.attempts = i + 1;
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(this.adapter.getRecycler());
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetChatListAdapter5(this, null), 3, null);
            }
        }

        public final void cancel() {
            this.adapter.getRecycler().removeCallbacks(this);
        }

        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final Function0<Unit> getOnCompleted() {
            return this.onCompleted;
        }

        @Override // java.lang.Runnable
        public void run() {
            Data data = this.adapter.getData();
            View viewFindViewByPosition = null;
            if (!(data instanceof WidgetChatListModel)) {
                data = null;
            }
            WidgetChatListModel widgetChatListModel = (WidgetChatListModel) data;
            if (widgetChatListModel != null && widgetChatListModel.isLoadingMessages()) {
                scheduleRetry();
                return;
            }
            int newMessageEntryIndex = getNewMessageEntryIndex(this.adapter.getData().getList());
            if (newMessageEntryIndex < 0) {
                scheduleRetry();
                return;
            }
            int height = (int) (this.adapter.getRecycler().getHeight() / 2.0f);
            LinearLayoutManager layoutManager = this.adapter.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPositionWithOffset(newMessageEntryIndex, height);
                viewFindViewByPosition = layoutManager.findViewByPosition(newMessageEntryIndex);
            }
            if (viewFindViewByPosition == null) {
                scheduleRetry();
                return;
            }
            if (!(newMessageEntryIndex < this.adapter.getData().getList().size() && (this.adapter.getData().getList().get(newMessageEntryIndex) instanceof NewMessagesEntry))) {
                animateHighlight(viewFindViewByPosition);
            }
            this.onCompleted.invoke();
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(Ljava/util/List;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$disposeHandlers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<List<? extends ChatListEntry>, List<? extends ChatListEntry>, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            invoke2(list, list2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$scrollToMessageId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Action0 $onCompleted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Action0 action0) {
            super(0);
            this.$onCompleted = action0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatListAdapter.access$setScrollToWithHighlight$p(WidgetChatListAdapter.this, null);
            WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
            this.$onCompleted.call();
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(Ljava/util/List;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$setHandlers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<List<? extends ChatListEntry>, List<? extends ChatListEntry>, Unit> {

        /* compiled from: WidgetChatListAdapter.kt */
        @DebugMetadata(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$setHandlers$1$1", f = "WidgetChatListAdapter.kt", l = {118}, m = "invokeSuspend")
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$setHandlers$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02651 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public C02651(Continuation continuation) {
                super(2, continuation);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C02651(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02651) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(250L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetChatListAdapter.access$getHandlerOfUpdates$p(WidgetChatListAdapter.this).run();
                return Unit.a;
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            invoke2(list, list2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
            Job jobAccess$getLastUpdateJob$p = WidgetChatListAdapter.access$getLastUpdateJob$p(WidgetChatListAdapter.this);
            if (jobAccess$getLastUpdateJob$p != null) {
                f.t(jobAccess$getLastUpdateJob$p, null, 1, null);
            }
            WidgetChatListAdapter widgetChatListAdapter = WidgetChatListAdapter.this;
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(widgetChatListAdapter.getRecycler());
            WidgetChatListAdapter.access$setLastUpdateJob$p(widgetChatListAdapter, coroutineScope != null ? f.H0(coroutineScope, null, null, new C02651(null), 3, null) : null);
            WidgetChatListAdapter.this.getRecycler().setOnTouchListener(WidgetChatListAdapter.access$getHandlerOfTouches$p(WidgetChatListAdapter.this));
            WidgetChatListAdapter.this.getRecycler().removeOnScrollListener(WidgetChatListAdapter.access$getHandlerOfScrolls$p(WidgetChatListAdapter.this));
            WidgetChatListAdapter.this.getRecycler().addOnScrollListener(WidgetChatListAdapter.access$getHandlerOfScrolls$p(WidgetChatListAdapter.this));
        }
    }

    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissions2 appPermissions2, FragmentManager fragmentManager, EventHandler eventHandler) {
        this(recyclerView, appPermissions2, fragmentManager, eventHandler, null, null, 48, null);
    }

    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissions2 appPermissions2, FragmentManager fragmentManager, EventHandler eventHandler, AppFlexInputViewModel appFlexInputViewModel) {
        this(recyclerView, appPermissions2, fragmentManager, eventHandler, appFlexInputViewModel, null, 32, null);
    }

    public /* synthetic */ WidgetChatListAdapter(RecyclerView recyclerView, AppPermissions2 appPermissions2, FragmentManager fragmentManager, EventHandler eventHandler, AppFlexInputViewModel appFlexInputViewModel, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, appPermissions2, fragmentManager, eventHandler, (i & 16) != 0 ? null : appFlexInputViewModel, (i & 32) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ HandlerOfScrolls access$getHandlerOfScrolls$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfScrolls;
    }

    public static final /* synthetic */ HandlerOfTouches access$getHandlerOfTouches$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfTouches;
    }

    public static final /* synthetic */ HandlerOfUpdates access$getHandlerOfUpdates$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfUpdates;
    }

    public static final /* synthetic */ Job access$getLastUpdateJob$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.lastUpdateJob;
    }

    public static final /* synthetic */ ScrollToWithHighlight access$getScrollToWithHighlight$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.scrollToWithHighlight;
    }

    public static final /* synthetic */ boolean access$isTouchedSinceLastJump$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.isTouchedSinceLastJump;
    }

    public static final /* synthetic */ void access$publishInteractionState(WidgetChatListAdapter widgetChatListAdapter) {
        widgetChatListAdapter.publishInteractionState();
    }

    public static final /* synthetic */ void access$setLastUpdateJob$p(WidgetChatListAdapter widgetChatListAdapter, Job job) {
        widgetChatListAdapter.lastUpdateJob = job;
    }

    public static final /* synthetic */ void access$setScrollToWithHighlight$p(WidgetChatListAdapter widgetChatListAdapter, ScrollToWithHighlight scrollToWithHighlight) {
        widgetChatListAdapter.scrollToWithHighlight = scrollToWithHighlight;
    }

    public static final /* synthetic */ void access$setTouchedSinceLastJump$p(WidgetChatListAdapter widgetChatListAdapter, boolean z2) {
        widgetChatListAdapter.isTouchedSinceLastJump = z2;
    }

    private final void publishInteractionState() {
        Data data = this.data;
        if (!(data instanceof WidgetChatListModel)) {
            data = null;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) data;
        this.eventHandler.onInteractionStateUpdated(new StoreChat.InteractionState(this.data.getChannelId(), widgetChatListModel != null ? widgetChatListModel.getNewestKnownMessageId() : 0L, this.isTouchedSinceLastJump, getLayoutManager()));
    }

    public final void disposeHandlers() {
        setOnUpdated(AnonymousClass1.INSTANCE);
        Job job = this.lastUpdateJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        getRecycler().setOnTouchListener(null);
        getRecycler().removeOnScrollListener(this.handlerOfScrolls);
        this.eventHandler.onInteractionStateUpdated(new StoreChat.InteractionState(this.data.getChannelId(), 0L, this.isTouchedSinceLastJump, (LinearLayoutManager) null));
    }

    public final AppPermissions2 getAppPermissionsRequests() {
        return this.appPermissionsRequests;
    }

    public final ComponentProvider getBotUiComponentProvider() {
        return this.botUiComponentProvider;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final Data getData() {
        return this.data;
    }

    public final EventHandler getEventHandler() {
        return this.eventHandler;
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final LinearLayoutManager getLayoutManager() {
        RecyclerView.LayoutManager layoutManager = getRecycler().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        return (LinearLayoutManager) layoutManager;
    }

    public final boolean getMentionMeMessageLevelHighlighting() {
        return this.mentionMeMessageLevelHighlighting;
    }

    public final void onBotUiComponentClicked(long applicationId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
        Intrinsics3.checkNotNullParameter(componentSendData, "componentSendData");
        EventHandler eventHandler = this.eventHandler;
        Guild guild = this.data.getGuild();
        eventHandler.onBotUiComponentClicked(applicationId, guild != null ? Long.valueOf(guild.getId()) : null, this.data.getChannelId(), messageId, messageFlags, componentIndex, componentSendData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onPause() {
        int childCount = getRecycler().getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childViewHolder = getRecycler().getChildViewHolder(getRecycler().getChildAt(i));
            if (childViewHolder instanceof FragmentLifecycleListener) {
                ((FragmentLifecycleListener) childViewHolder).onPause();
            }
        }
    }

    public final void onQuickAddReactionClicked(long messageId) {
        this.eventHandler.onQuickAddReactionClicked(this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId);
    }

    public final void onReactionClicked(long messageId, MessageReaction reaction, boolean canAddReactions) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        this.eventHandler.onReactionClicked(this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId, reaction, canAddReactions);
    }

    public final void onReactionLongClicked(long messageId, MessageReaction reaction) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        this.eventHandler.onReactionLongClicked(this.data.getGuildId(), this.data.getChannelId(), messageId, reaction);
    }

    public final void onResume() {
        int childCount = getRecycler().getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childViewHolder = getRecycler().getChildViewHolder(getRecycler().getChildAt(i));
            if (childViewHolder instanceof FragmentLifecycleListener) {
                ((FragmentLifecycleListener) childViewHolder).onResume();
            }
        }
    }

    public final void onRoleSubscriptionPurchaseSystemMessageClicked(long roleSubscriptionListingId, long messageId) {
        this.eventHandler.onRoleSubscriptionPurchaseTierClick(roleSubscriptionListingId, this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId);
    }

    public final void onShareButtonClick(GuildScheduledEvent guildEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        Intrinsics3.checkNotNullParameter(guildEvent, "guildEvent");
        Intrinsics3.checkNotNullParameter(weakContext, "weakContext");
        Intrinsics3.checkNotNullParameter(weakFragment, "weakFragment");
        this.eventHandler.onShareButtonClick(guildEvent, weakContext, weakFragment);
    }

    public final void onStickerClicked(Message message, BaseSticker sticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        this.eventHandler.onStickerClicked(message, sticker);
    }

    public final void onThreadClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.eventHandler.onThreadClicked(channel);
    }

    public final void onThreadLongClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.eventHandler.onThreadLongClicked(channel);
    }

    public final void onUserActivityAction(long authorId, long messageId, MessageActivityType messageActivityType, Activity activity, Application application) {
        Intrinsics3.checkNotNullParameter(messageActivityType, "messageActivityType");
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(application, "application");
        this.eventHandler.onUserActivityAction(authorId, this.data.getChannelId(), messageId, messageActivityType, activity, application);
    }

    public final void scrollToMessageId(long messageId, Action0 onCompleted) {
        Intrinsics3.checkNotNullParameter(onCompleted, "onCompleted");
        ScrollToWithHighlight scrollToWithHighlight = this.scrollToWithHighlight;
        if (scrollToWithHighlight != null && scrollToWithHighlight.getMessageId() > 0 && messageId <= 0) {
            onCompleted.call();
            return;
        }
        this.isTouchedSinceLastJump = false;
        ScrollToWithHighlight scrollToWithHighlight2 = this.scrollToWithHighlight;
        if (scrollToWithHighlight2 != null) {
            scrollToWithHighlight2.cancel();
        }
        this.scrollToWithHighlight = new ScrollToWithHighlight(this, messageId, new AnonymousClass1(onCompleted));
    }

    public final void setData(Data data) {
        Intrinsics3.checkNotNullParameter(data, "value");
        this.data = data;
        setData(data.getList());
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "<set-?>");
        this.fragmentManager = fragmentManager;
    }

    public final void setHandlers() {
        setOnUpdated(new AnonymousClass1());
    }

    public final void setMentionMeMessageLevelHighlighting(boolean z2) {
        this.mentionMeMessageLevelHighlighting = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissions2 appPermissions2, FragmentManager fragmentManager, EventHandler eventHandler, AppFlexInputViewModel appFlexInputViewModel, Clock clock) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(appPermissions2, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.appPermissionsRequests = appPermissions2;
        this.fragmentManager = fragmentManager;
        this.eventHandler = eventHandler;
        this.flexInputViewModel = appFlexInputViewModel;
        this.clock = clock;
        Context context = recyclerView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "recycler.context");
        this.botUiComponentProvider = new ComponentProvider(context);
        this.data = new EmptyData();
        this.mentionMeMessageLevelHighlighting = true;
        this.handlerOfTouches = new HandlerOfTouches();
        this.handlerOfScrolls = new HandlerOfScrolls();
        this.handlerOfUpdates = new HandlerOfUpdates();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> onCreateViewHolder(ViewGroup parent, int viewType) {
        MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> widgetChatListAdapterItemGuildWelcome;
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
            case 32:
                return new WidgetChatListAdapterItemMessage(R.layout.widget_chat_list_adapter_item_text, this);
            case 1:
                return new WidgetChatListAdapterItemMessage(R.layout.widget_chat_list_adapter_item_minimal, this);
            case 2:
                return new WidgetChatListItem(R.layout.widget_chat_list_adapter_item_loading, this);
            case 3:
                return new WidgetChatListAdapterItemStart(this);
            case 4:
                return new WidgetChatListAdapterItemReactions(this);
            case 5:
                return new WidgetChatListAdapterItemSystemMessage(this);
            case 6:
                return new WidgetChatListAdapterItemUploadProgress(this);
            case 7:
                return new WidgetChatListItem(R.layout.widget_chat_list_adapter_item_spacer, this);
            case 8:
                return new WidgetChatListAdapterItemNewMessages(this);
            case 9:
                return new WidgetChatListAdapterItemTimestamp(this);
            case 10:
                return new WidgetChatListAdapterItemBlocked(this);
            case 11:
                return new WidgetChatListAdapterItemSearchResultCount(this);
            case 12:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_search_indexing, this);
            case 13:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_search_empty, this);
            case 14:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_search_error, this);
            case 15:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_divider, this);
            case 16:
                return new WidgetChatListAdapterItemEmptyPins(this);
            case 17:
                return new WidgetChatListAdapterItemMessageHeader(this);
            case 18:
                return new WidgetChatListAdapterItemMentionFooter(this);
            case 19:
                return new WidgetChatListAdapterItemCallMessage(this);
            case 20:
                return new WidgetChatListAdapterItemMessage(R.layout.widget_chat_list_adapter_item_failed, this);
            case 21:
                return new WidgetChatListAdapterItemEmbed(this);
            case 22:
                return new WidgetChatListAdapterItemGameInvite(this);
            case 23:
                return new WidgetChatListAdapterItemSpotifyListenTogether(this);
            case 24:
                return new WidgetChatListAdapterItemInvite(this);
            case 25:
                widgetChatListAdapterItemGuildWelcome = new WidgetChatListAdapterItemGuildWelcome(this, null, 2, null);
                break;
            case 26:
                return new WidgetChatListAdapterItemGift(this);
            case 27:
            default:
                throw invalidViewTypeException(viewType);
            case 28:
                return new WidgetChatListAdapterItemAttachment(this);
            case 29:
                return new WidgetChatListAdapterItemPrivateChannelStart(this);
            case 30:
                return new WidgetChatListAdapterItemGuildTemplate(this);
            case 31:
                return new WidgetChatListAdapterItemSticker(this);
            case 33:
                return new WidgetChatListAdapterItemApplicationCommand(this);
            case 34:
                return new WidgetChatListAdapterItemEphemeralMessage(this);
            case 35:
                return new WidgetChatListAdapterItemThreadEmbed(this);
            case 36:
                return new WidgetChatListAdapterItemBotComponentRow(this);
            case 37:
                return new WidgetChatListAdapterItemThreadDraftForm(this, this.flexInputViewModel);
            case 38:
                return new WidgetChatListAdapterItemGuildInviteReminder(this);
            case 39:
                return new WidgetChatListAdapterItemStageInvite(this);
            case 40:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_thread_starter_divider, this);
            case 41:
                return new WidgetChatListAdapterItemStickerGreet(this);
            case 42:
                return new WidgetChatListAdapterItemStickerGreetCompact(this);
            case 43:
                widgetChatListAdapterItemGuildWelcome = new WidgetChatListAdapterItemGuildScheduledEventInvite(this, null, 2, null);
                break;
            case 44:
                return new WidgetChatListAdapterItemAutoModBlocked(this);
            case 45:
                return new WidgetChatListAdapterItemAutoModSystemMessageEmbed(this);
        }
        return widgetChatListAdapterItemGuildWelcome;
    }
}
