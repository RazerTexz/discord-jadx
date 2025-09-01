package com.discord.widgets.chat.pins;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelPinnedMessages.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0003\u001c\u001b\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001d\u0010\u0019\u001a\u00020\u00148B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages;", "Lcom/discord/app/AppFragment;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "", "addThreadSpineItemDecoration", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;", "model", "configureUI", "(Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;)V", "Landroid/view/View;", "view", "onViewBound", "(Landroid/view/View;)V", "onViewBoundOrOnResume", "()V", "onPause", "onDestroy", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", "binding$delegate", "Lcom/discord/utilities/viewbinding/FragmentViewBindingDelegate;", "getBinding", "()Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", "binding", "<init>", "Companion", "ChannelPinnedMessagesAdapterEventHandler", ExifInterface.TAG_MODEL, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelPinnedMessages.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private WidgetChatListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChannelPinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$ChannelPinnedMessagesAdapterEventHandler;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "Lcom/discord/models/message/Message;", "message", "", "isThreadStarterMessage", "", "onMessageClicked", "(Lcom/discord/models/message/Message;Z)V", "", "formattedMessage", "onMessageLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;Z)V", "Lcom/discord/api/channel/Channel;", "channel", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "", "url", "onUrlLongClicked", "(Ljava/lang/String;)V", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "onStickerClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/discord/utilities/channel/ChannelSelector;", "channelSelector", "Lcom/discord/utilities/channel/ChannelSelector;", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/channel/ChannelSelector;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ChannelPinnedMessagesAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Context context;
        private final FragmentManager fragmentManager;

        public ChannelPinnedMessagesAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
            Intrinsics3.checkNotNullParameter(componentInteractionData, "componentSendData");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, componentInteractionData);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long j, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCallMessageClicked(this, j, callStatus);
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
            WidgetChatListAdapter.EventHandler.DefaultImpls.onInteractionStateUpdated(this, interactionState);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onListClicked(this);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long j) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorAvatarClicked(this, message, j);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long l) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorLongClicked(this, message, l);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long j) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorNameClicked(this, message, j);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageBlockedGroupClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            AppScreen2.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
            WidgetChatListActions.INSTANCE.showForPin(this.fragmentManager, message.getChannelId(), message.getId(), formattedMessage);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long j, long j2) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onOldestMessageId(this, j, j2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onOpenPinsClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long j, long j2, long j3, long j4) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onQuickAddReactionClicked(this, j, j2, j3, j4);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String str) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(str, "fileName");
            return WidgetChatListAdapter.EventHandler.DefaultImpls.onQuickDownloadClicked(this, uri, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReactionClicked(this, j, j2, j3, j4, messageReaction, z2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long j, long j2, long j3, MessageReaction messageReaction) {
            Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReactionLongClicked(this, j, j2, j3, messageReaction);
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
            AppScreen2.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onThreadLongClicked(this, channel);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            Intrinsics3.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
            Intrinsics3.checkNotNullParameter(messageActivityType, "messageActivityType");
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(application, "application");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserActivityAction(this, j, j2, j3, messageActivityType, activity, application);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long j, long j2, long j3) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserMentionClicked(this, j, j2, j3);
        }
    }

    /* compiled from: WidgetChannelPinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Companion;", "", "Landroid/content/Context;", "context", "", "channelId", "", "show", "(Landroid/content/Context;J)V", "", WidgetChannelPinnedMessages.INTENT_EXTRA_CHANNEL_ID, "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetChannelPinnedMessages.INTENT_EXTRA_CHANNEL_ID, channelId);
            AppScreen2.d(context, WidgetChannelPinnedMessages.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0082\b\u0018\u0000 F2\u00020\u0001:\u0001FB\u0083\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0013\u0012\b\b\u0002\u0010#\u001a\u00020\b\u0012\b\b\u0002\u0010$\u001a\u00020\b\u0012\b\b\u0002\u0010%\u001a\u00020\b\u0012\b\b\u0002\u0010&\u001a\u00020\b\u0012\b\b\u0002\u0010'\u001a\u00020\u001a¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0017\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0018\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0098\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001f\u001a\u00020\b2\u0014\b\u0002\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010-\u001a\u00020,HÖ\u0001¢\u0006\u0004\b-\u0010.J\u001a\u00101\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b4\u0010\u0007R\u001c\u0010#\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b6\u0010\nR\u001c\u0010$\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b7\u0010\nR\u001c\u0010'\u001a\u00020\u001a8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u00108\u001a\u0004\b'\u0010\u001cR\u0019\u0010\u001d\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010\u0004R\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010;\u001a\u0004\b<\u0010\u0015R\u001c\u0010\u001f\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b=\u0010\nR\u001c\u0010%\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b>\u0010\nR\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010?\u001a\u0004\b@\u0010\u0012R\u001c\u0010&\u001a\u00020\b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\bA\u0010\nR(\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010B\u001a\u0004\bC\u0010\u000e¨\u0006G"}, d2 = {"Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$Data;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "", "component3", "()J", "", "", "component4", "()Ljava/util/Map;", "", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "component5", "()Ljava/util/List;", "", "component6", "()Ljava/util/Set;", "component7", "component8", "component9", "component10", "", "component11", "()Z", "channel", "guild", "userId", "channelNames", "list", "myRoleIds", "channelId", "guildId", "oldestMessageId", "newMessagesMarkerMessageId", "isSpoilerClickAllowed", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;JLjava/util/Map;Ljava/util/List;Ljava/util/Set;JJJJZ)Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/guild/Guild;", "getGuild", "J", "getChannelId", "getGuildId", "Z", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/util/Set;", "getMyRoleIds", "getUserId", "getOldestMessageId", "Ljava/util/List;", "getList", "getNewMessagesMarkerMessageId", "Ljava/util/Map;", "getChannelNames", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;JLjava/util/Map;Ljava/util/List;Ljava/util/Set;JJJJZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final long userId;

        /* compiled from: WidgetChannelPinnedMessages.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model$Companion;", "", "Landroid/content/Context;", "context", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;", "get", "(Landroid/content/Context;J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Context context, long channelId) {
                Intrinsics3.checkNotNullParameter(context, "context");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Channel channelFindChannelById = companion.getChannels().findChannelById(channelId);
                if (channelFindChannelById != null) {
                    Observable observableY = companion.getPinnedMessages().observeForChannel(channelId).Y(new WidgetChannelPinnedMessages2(channelFindChannelById, context));
                    Intrinsics3.checkNotNullExpressionValue(observableY, "getPinnedMessages().obse…              }\n        }");
                    return observableY;
                }
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
                return scalarSynchronousObservable;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, Guild guild, long j, Map<Long, String> map, List<? extends ChatListEntry> list, Set<Long> set, long j2, long j3, long j4, long j5, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(set, "myRoleIds");
            this.channel = channel;
            this.guild = guild;
            this.userId = j;
            this.channelNames = map;
            this.list = list;
            this.myRoleIds = set;
            this.channelId = j2;
            this.guildId = j3;
            this.oldestMessageId = j4;
            this.newMessagesMarkerMessageId = j5;
            this.isSpoilerClickAllowed = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.channel : channel, (i & 2) != 0 ? model.getGuild() : guild, (i & 4) != 0 ? model.getUserId() : j, (i & 8) != 0 ? model.getChannelNames() : map, (i & 16) != 0 ? model.getList() : list, (i & 32) != 0 ? model.getMyRoleIds() : set, (i & 64) != 0 ? model.getChannelId() : j2, (i & 128) != 0 ? model.getGuildId() : j3, (i & 256) != 0 ? model.getOldestMessageId() : j4, (i & 512) != 0 ? model.getNewMessagesMarkerMessageId() : j5, (i & 1024) != 0 ? model.getIsSpoilerClickAllowed() : z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final long component10() {
            return getNewMessagesMarkerMessageId();
        }

        public final boolean component11() {
            return getIsSpoilerClickAllowed();
        }

        public final Guild component2() {
            return getGuild();
        }

        public final long component3() {
            return getUserId();
        }

        public final Map<Long, String> component4() {
            return getChannelNames();
        }

        public final List<ChatListEntry> component5() {
            return getList();
        }

        public final Set<Long> component6() {
            return getMyRoleIds();
        }

        public final long component7() {
            return getChannelId();
        }

        public final long component8() {
            return getGuildId();
        }

        public final long component9() {
            return getOldestMessageId();
        }

        public final Model copy(Channel channel, Guild guild, long userId, Map<Long, String> channelNames, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long channelId, long guildId, long oldestMessageId, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
            return new Model(channel, guild, userId, channelNames, list, myRoleIds, channelId, guildId, oldestMessageId, newMessagesMarkerMessageId, isSpoilerClickAllowed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(getGuild(), model.getGuild()) && getUserId() == model.getUserId() && Intrinsics3.areEqual(getChannelNames(), model.getChannelNames()) && Intrinsics3.areEqual(getList(), model.getList()) && Intrinsics3.areEqual(getMyRoleIds(), model.getMyRoleIds()) && getChannelId() == model.getChannelId() && getGuildId() == model.getGuildId() && getOldestMessageId() == model.getOldestMessageId() && getNewMessagesMarkerMessageId() == model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == model.getIsSpoilerClickAllowed();
        }

        public final Channel getChannel() {
            return this.channel;
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

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = getGuild();
            int iA = (b.a(getUserId()) + ((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iHashCode2 = (iA + (channelNames != null ? channelNames.hashCode() : 0)) * 31;
            List<ChatListEntry> list = getList();
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            int iA2 = (b.a(getNewMessagesMarkerMessageId()) + ((b.a(getOldestMessageId()) + ((b.a(getGuildId()) + ((b.a(getChannelId()) + ((iHashCode3 + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
            boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
            int i = isSpoilerClickAllowed;
            if (isSpoilerClickAllowed) {
                i = 1;
            }
            return iA2 + i;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(getGuild());
            sbU.append(", userId=");
            sbU.append(getUserId());
            sbU.append(", channelNames=");
            sbU.append(getChannelNames());
            sbU.append(", list=");
            sbU.append(getList());
            sbU.append(", myRoleIds=");
            sbU.append(getMyRoleIds());
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(", guildId=");
            sbU.append(getGuildId());
            sbU.append(", oldestMessageId=");
            sbU.append(getOldestMessageId());
            sbU.append(", newMessagesMarkerMessageId=");
            sbU.append(getNewMessagesMarkerMessageId());
            sbU.append(", isSpoilerClickAllowed=");
            sbU.append(getIsSpoilerClickAllowed());
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ Model(Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, guild, j, map, list, set, (i & 64) != 0 ? channel.getId() : j2, (i & 128) != 0 ? channel.getGuildId() : j3, (i & 256) != 0 ? 0L : j4, (i & 512) != 0 ? 0L : j5, (i & 1024) != 0 ? false : z2);
        }
    }

    /* compiled from: WidgetChannelPinnedMessages.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;", "model", "", "invoke", "(Lcom/discord/widgets/chat/pins/WidgetChannelPinnedMessages$Model;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetChannelPinnedMessages.access$configureUI(WidgetChannelPinnedMessages.this, model);
        }
    }

    public WidgetChannelPinnedMessages() {
        super(R.layout.widget_channel_pinned_messages);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelPinnedMessages3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelPinnedMessages widgetChannelPinnedMessages, Model model) {
        widgetChannelPinnedMessages.configureUI(model);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f2265b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureUI(Model model) {
        if (model == null) {
            requireActivity().finish();
            return;
        }
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
    }

    private final WidgetChannelPinnedMessagesBinding getBinding() {
        return (WidgetChannelPinnedMessagesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.pinned_messages);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2265b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelPinnedMessagesRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new ChannelPinnedMessagesAdapterEventHandler(contextRequireContext, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get(requireContext(), getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, 0L)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Model\n        .get(requi…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelPinnedMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
