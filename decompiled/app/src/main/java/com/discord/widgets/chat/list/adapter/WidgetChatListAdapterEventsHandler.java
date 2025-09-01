package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageClicked;
import com.discord.analytics.generated.events.TrackRoleSubscriptionPurchaseSystemMessageCtaClicked;
import com.discord.analytics.generated.events.TrackWelcomeCtaClicked;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityActionConfirmation;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.Message;
import com.discord.api.message.MessageReference;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.sticker.StickerType;
import com.discord.api.user.User;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.user.CoreUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.guilds.PublicGuildUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.guilds.profile.WidgetPublicAnnouncementProfileSheet;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUrlUtils;
import com.discord.widgets.stickers.WidgetGuildStickerSheet;
import com.discord.widgets.stickers.WidgetStickerSheet;
import com.discord.widgets.stickers.WidgetUnknownStickerSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetStartCallSheet;
import d0.Tuples;
import d0.t.CollectionsJVM;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorThrottleFirst2;
import j0.p.Schedulers2;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* compiled from: WidgetChatListAdapterEventsHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002¤\u0001B\u0090\u0001\u0012\u0007\u0010\u0087\u0001\u001a\u00020r\u0012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001\u0012\n\b\u0002\u0010\u009a\u0001\u001a\u00030\u0099\u0001\u0012\b\b\u0002\u0010\u007f\u001a\u00020~\u0012\n\b\u0002\u0010\u009d\u0001\u001a\u00030\u009c\u0001\u0012\n\b\u0002\u0010\u0091\u0001\u001a\u00030\u0090\u0001\u0012\n\b\u0002\u0010 \u0001\u001a\u00030\u009f\u0001\u0012\n\b\u0002\u0010\u0097\u0001\u001a\u00030\u0096\u0001\u0012\n\b\u0002\u0010\u0094\u0001\u001a\u00030\u0093\u0001\u0012\b\b\u0002\u0010|\u001a\u00020{\u0012\n\b\u0002\u0010\u0082\u0001\u001a\u00030\u0081\u0001\u0012\n\b\u0002\u0010\u0085\u0001\u001a\u00030\u0084\u0001¢\u0006\u0006\b¢\u0001\u0010£\u0001JK\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJa\u0010\u0018\u001a\u00020\u000b2\n\u0010\b\u001a\u00060\u0002j\u0002`\u000e2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000f2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J'\u0010$\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\n\u0010#\u001a\u00060\u0002j\u0002`\u0011H\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010*\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J#\u0010,\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u000fH\u0016¢\u0006\u0004\b,\u0010-J'\u00100\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\u0006\u0010/\u001a\u00020.2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\tH\u0016¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b5\u00106J#\u00107\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u000fH\u0016¢\u0006\u0004\b7\u0010-J'\u00108\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u000fH\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b:\u00106J?\u0010?\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020(H\u0016¢\u0006\u0004\b?\u0010@J;\u0010A\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u000f2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00112\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\bA\u0010BJ'\u0010D\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\bD\u0010EJ?\u0010G\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u000f2\n\u0010;\u001a\u00060\u0002j\u0002`F2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0011H\u0016¢\u0006\u0004\bG\u0010HJ\u001f\u0010L\u001a\u00020(2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\tH\u0016¢\u0006\u0004\bL\u0010MJK\u0010U\u001a\u00020\u000b2\n\u0010N\u001a\u00060\u0002j\u0002`F2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00112\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q2\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u000bH\u0016¢\u0006\u0004\bW\u0010XJ#\u0010\\\u001a\u00020\u000b2\n\u0010Y\u001a\u00060\u0002j\u0002`\u00102\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\b\\\u0010]J\u001f\u0010`\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\u0006\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\b`\u0010aJ+\u0010d\u001a\u00020\u000b2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\u0006\u0010b\u001a\u00020\u00132\u0006\u0010_\u001a\u00020cH\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bf\u00106J\u0017\u0010g\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bg\u00106J\u001f\u0010j\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020h2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\bj\u0010kJ'\u0010l\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020^H\u0016¢\u0006\u0004\bl\u0010mJ3\u0010t\u001a\u00020\u000b2\u0006\u0010o\u001a\u00020n2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020h0p2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020r0pH\u0016¢\u0006\u0004\bt\u0010uJG\u0010w\u001a\u00020\u000b2\u0006\u0010v\u001a\u00020\u00022\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u000f2\n\u0010C\u001a\u00060\u0002j\u0002`F2\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u00102\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0011H\u0016¢\u0006\u0004\bw\u0010xR\u0016\u0010i\u001a\u00020h8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR\u0016\u0010|\u001a\u00020{8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u007f\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001a\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u0087\u0001\u001a\u00020r8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001a\u0010\u008c\u0001\u001a\u00030\u0089\u00018B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001a\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0096\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001a\u0010 \u0001\u001a\u00030\u009f\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001¨\u0006¥\u0001"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter$EventHandler;", "", "interactionId", "guildId", "channelId", "messageId", "interactionUserId", "applicationId", "", "messageNonce", "", "onCommandClicked", "(JLjava/lang/Long;JJJJLjava/lang/String;)V", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/primitives/GuildId;", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/MessageId;", "messageFlags", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "Lcom/discord/restapi/RestAPIParams$ComponentInteractionData;", "componentSendData", "onBotUiComponentClicked", "(JLjava/lang/Long;JJLjava/lang/Long;ILcom/discord/restapi/RestAPIParams$ComponentInteractionData;)V", "Lcom/discord/api/channel/Channel;", "channel", "onThreadClicked", "(Lcom/discord/api/channel/Channel;)V", "onThreadLongClicked", "Lcom/discord/stores/StoreChat$InteractionState;", "interactionState", "onInteractionStateUpdated", "(Lcom/discord/stores/StoreChat$InteractionState;)V", "oldestMessageId", "onOldestMessageId", "(JJ)V", "Lcom/discord/models/message/Message;", "message", "", "isThreadStarterMessage", "onMessageClicked", "(Lcom/discord/models/message/Message;Z)V", "onMessageAuthorAvatarClicked", "(Lcom/discord/models/message/Message;J)V", "", "formattedMessage", "onMessageLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/CharSequence;Z)V", "url", "onUrlLongClicked", "(Ljava/lang/String;)V", "onOpenPinsClicked", "(Lcom/discord/models/message/Message;)V", "onMessageAuthorNameClicked", "onMessageAuthorLongClicked", "(Lcom/discord/models/message/Message;Ljava/lang/Long;)V", "onMessageBlockedGroupClicked", "myUserId", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "canAddReactions", "onReactionClicked", "(JJJJLcom/discord/api/message/reaction/MessageReaction;Z)V", "onReactionLongClicked", "(JJJLcom/discord/api/message/reaction/MessageReaction;)V", "userId", "onUserMentionClicked", "(JJJ)V", "Lcom/discord/primitives/UserId;", "onQuickAddReactionClicked", "(JJJJ)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "fileName", "onQuickDownloadClicked", "(Landroid/net/Uri;Ljava/lang/String;)Z", "authorId", "Lcom/discord/api/message/activity/MessageActivityType;", "actionType", "Lcom/discord/api/activity/Activity;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Lcom/discord/api/application/Application;", "application", "onUserActivityAction", "(JJJLcom/discord/api/message/activity/MessageActivityType;Lcom/discord/api/activity/Activity;Lcom/discord/api/application/Application;)V", "onListClicked", "()V", "voiceChannelId", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;", "callStatus", "onCallMessageClicked", "(JLcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemCallMessage$CallStatus;)V", "Lcom/discord/api/sticker/BaseSticker;", "sticker", "onStickerClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/sticker/BaseSticker;)V", "channelType", "Lcom/discord/api/sticker/Sticker;", "onSendGreetMessageClicked", "(JILcom/discord/api/sticker/Sticker;)V", "onDismissClicked", "onDismissLocalMessageClicked", "Landroid/content/Context;", "context", "onReportIssueWithAutoMod", "(Landroid/content/Context;Lcom/discord/models/message/Message;)V", "onSystemMessageCtaClicked", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/api/sticker/BaseSticker;)V", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "Ljava/lang/ref/WeakReference;", "weakContext", "Lcom/discord/app/AppFragment;", "weakFragment", "onShareButtonClick", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Ljava/lang/ref/WeakReference;Ljava/lang/ref/WeakReference;)V", "roleSubscriptionListingId", "onRoleSubscriptionPurchaseTierClick", "(JJJJJ)V", "getContext", "()Landroid/content/Context;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;", "userReactionHandler", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "analyticsTracker", "Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;", "host", "Lcom/discord/app/AppFragment;", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "flexInputViewModel", "Lcom/discord/widgets/chat/input/AppFlexInputViewModel;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/utilities/channel/ChannelSelector;", "channelSelector", "Lcom/discord/utilities/channel/ChannelSelector;", "Lcom/discord/widgets/chat/MessageManager;", "messageManager", "Lcom/discord/widgets/chat/MessageManager;", "Lcom/discord/stores/StoreChat;", "storeChat", "Lcom/discord/stores/StoreChat;", "Lcom/discord/stores/StorePendingReplies;", "storePendingReplies", "Lcom/discord/stores/StorePendingReplies;", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lcom/discord/stores/StoreEmoji;", "<init>", "(Lcom/discord/app/AppFragment;Lcom/discord/widgets/chat/input/AppFlexInputViewModel;Lcom/discord/stores/StoreChat;Lcom/discord/stores/StoreMessages;Lcom/discord/stores/StorePendingReplies;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreEmoji;Lcom/discord/widgets/chat/MessageManager;Lcom/discord/utilities/channel/ChannelSelector;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;Lcom/discord/stores/StoreChannels;Lcom/discord/utilities/analytics/AnalyticsUtils$Tracker;)V", "UserReactionHandler", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterEventsHandler implements WidgetChatListAdapter.EventHandler {
    private final AnalyticsUtils.Tracker analyticsTracker;
    private final ChannelSelector channelSelector;
    private final StoreChannels channelStore;
    private final AppFlexInputViewModel flexInputViewModel;
    private final AppFragment host;
    private final MessageManager messageManager;
    private final StoreChat storeChat;
    private final StoreEmoji storeEmoji;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreUser storeUser;
    private final UserReactionHandler userReactionHandler;

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\n2\n\u0010\r\u001a\u00060\tj\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\u0010\r\u001a\u00060\tj\u0002`\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00040\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001b¨\u0006*"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler;", "", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;", "updateRequest", "", "requestReactionUpdate", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;)V", "Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "addNewReaction", "(Lcom/discord/models/domain/emoji/Emoji;JJ)V", "userId", "Lcom/discord/api/message/reaction/MessageReaction;", "reaction", "toggleReaction", "(JJJLcom/discord/api/message/reaction/MessageReaction;)V", "Lrx/subjects/Subject;", "requestStream", "Lrx/subjects/Subject;", "Lkotlin/Function1;", "Lcom/discord/api/message/reaction/MessageReactionUpdate;", "commitReactionRemove", "Lkotlin/jvm/functions/Function1;", "Lcom/discord/app/AppFragment;", "host", "Lcom/discord/app/AppFragment;", "Lcom/discord/stores/StoreMessages;", "storeMessages", "Lcom/discord/stores/StoreMessages;", "Lcom/discord/stores/StoreEmoji;", "storeEmoji", "Lcom/discord/stores/StoreEmoji;", "commitReactionAdd", "<init>", "(Lcom/discord/app/AppFragment;Lcom/discord/stores/StoreMessages;Lcom/discord/stores/StoreEmoji;)V", "Companion", "UpdateRequest", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class UserReactionHandler {
        private static final long REQUEST_RATE_LIMIT_MILLIS = 250;
        private final Function1<MessageReactionUpdate, Unit> commitReactionAdd;
        private final Function1<MessageReactionUpdate, Unit> commitReactionRemove;
        private final AppFragment host;
        private final Subject<UpdateRequest, UpdateRequest> requestStream;
        private final StoreEmoji storeEmoji;
        private final StoreMessages storeMessages;

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$UserReactionHandler$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<UpdateRequest, Unit> {
            public AnonymousClass1(UserReactionHandler userReactionHandler) {
                super(1, userReactionHandler, UserReactionHandler.class, "requestReactionUpdate", "requestReactionUpdate(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UpdateRequest updateRequest) {
                invoke2(updateRequest);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UpdateRequest updateRequest) {
                Intrinsics3.checkNotNullParameter(updateRequest, "p1");
                UserReactionHandler.access$requestReactionUpdate((UserReactionHandler) this.receiver, updateRequest);
            }
        }

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\n\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u000e\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\b\u0012\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b#\u0010$J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0014\u0010\t\u001a\u00060\u0002j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0011\u001a\u00020\u00002\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\u000e\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\b2\b\b\u0002\u0010\u0010\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0010\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\u001d\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0005R\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\u0005R\u001d\u0010\u000e\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b\"\u0010\u0005¨\u0006%"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()J", "Lcom/discord/primitives/ChannelId;", "component2", "Lcom/discord/primitives/MessageId;", "component3", "Lcom/discord/api/message/reaction/MessageReaction;", "component4", "()Lcom/discord/api/message/reaction/MessageReaction;", "userId", "channelId", "messageId", "reaction", "copy", "(JJJLcom/discord/api/message/reaction/MessageReaction;)Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$UserReactionHandler$UpdateRequest;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/message/reaction/MessageReaction;", "getReaction", "J", "getUserId", "getMessageId", "getChannelId", "<init>", "(JJJLcom/discord/api/message/reaction/MessageReaction;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class UpdateRequest {
            private final long channelId;
            private final long messageId;
            private final MessageReaction reaction;
            private final long userId;

            public UpdateRequest(long j, long j2, long j3, MessageReaction messageReaction) {
                Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
                this.userId = j;
                this.channelId = j2;
                this.messageId = j3;
                this.reaction = messageReaction;
            }

            public static /* synthetic */ UpdateRequest copy$default(UpdateRequest updateRequest, long j, long j2, long j3, MessageReaction messageReaction, int i, Object obj) {
                return updateRequest.copy((i & 1) != 0 ? updateRequest.userId : j, (i & 2) != 0 ? updateRequest.channelId : j2, (i & 4) != 0 ? updateRequest.messageId : j3, (i & 8) != 0 ? updateRequest.reaction : messageReaction);
            }

            /* renamed from: component1, reason: from getter */
            public final long getUserId() {
                return this.userId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component4, reason: from getter */
            public final MessageReaction getReaction() {
                return this.reaction;
            }

            public final UpdateRequest copy(long userId, long channelId, long messageId, MessageReaction reaction) {
                Intrinsics3.checkNotNullParameter(reaction, "reaction");
                return new UpdateRequest(userId, channelId, messageId, reaction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateRequest)) {
                    return false;
                }
                UpdateRequest updateRequest = (UpdateRequest) other;
                return this.userId == updateRequest.userId && this.channelId == updateRequest.channelId && this.messageId == updateRequest.messageId && Intrinsics3.areEqual(this.reaction, updateRequest.reaction);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final MessageReaction getReaction() {
                return this.reaction;
            }

            public final long getUserId() {
                return this.userId;
            }

            public int hashCode() {
                int iA = (b.a(this.messageId) + ((b.a(this.channelId) + (b.a(this.userId) * 31)) * 31)) * 31;
                MessageReaction messageReaction = this.reaction;
                return iA + (messageReaction != null ? messageReaction.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("UpdateRequest(userId=");
                sbU.append(this.userId);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", reaction=");
                sbU.append(this.reaction);
                sbU.append(")");
                return sbU.toString();
            }
        }

        public UserReactionHandler(AppFragment appFragment, StoreMessages storeMessages, StoreEmoji storeEmoji) {
            Intrinsics3.checkNotNullParameter(appFragment, "host");
            Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
            Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
            this.host = appFragment;
            this.storeMessages = storeMessages;
            this.storeEmoji = storeEmoji;
            PublishSubject publishSubjectK0 = PublishSubject.k0();
            Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
            this.requestStream = publishSubjectK0;
            this.commitReactionAdd = new WidgetChatListAdapterEventsHandler3(this);
            this.commitReactionRemove = new WidgetChatListAdapterEventsHandler4(this);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Objects.requireNonNull(publishSubjectK0);
            Observable observableH0 = Observable.h0(new OnSubscribeLift(publishSubjectK0.j, new OperatorThrottleFirst2(REQUEST_RATE_LIMIT_MILLIS, timeUnit, Schedulers2.a())));
            Intrinsics3.checkNotNullExpressionValue(observableH0, "requestStream\n          …S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableH0, appFragment.getClass(), appFragment.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 60, (Object) null);
        }

        public static final /* synthetic */ StoreEmoji access$getStoreEmoji$p(UserReactionHandler userReactionHandler) {
            return userReactionHandler.storeEmoji;
        }

        public static final /* synthetic */ StoreMessages access$getStoreMessages$p(UserReactionHandler userReactionHandler) {
            return userReactionHandler.storeMessages;
        }

        public static final /* synthetic */ void access$requestReactionUpdate(UserReactionHandler userReactionHandler, UpdateRequest updateRequest) {
            userReactionHandler.requestReactionUpdate(updateRequest);
        }

        private final void requestReactionUpdate(UpdateRequest updateRequest) {
            String name;
            long userId = updateRequest.getUserId();
            long channelId = updateRequest.getChannelId();
            long messageId = updateRequest.getMessageId();
            MessageReaction reaction = updateRequest.getReaction();
            MessageReactionUpdate messageReactionUpdate = new MessageReactionUpdate(userId, channelId, messageId, reaction.getEmoji());
            if (reaction.getEmoji().e()) {
                name = reaction.getEmoji().getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + reaction.getEmoji().getId();
            } else {
                name = reaction.getEmoji().getName();
                if (name == null) {
                    name = "";
                }
            }
            Observable<Void> observableRemoveSelfReaction = reaction.getMe() ? RestAPI.INSTANCE.getApi().removeSelfReaction(channelId, messageId, name) : RestAPI.INSTANCE.getApi().addReaction(channelId, messageId, name);
            Function1<MessageReactionUpdate, Unit> function1 = reaction.getMe() ? this.commitReactionRemove : this.commitReactionAdd;
            Function1<MessageReactionUpdate, Unit> function12 = reaction.getMe() ? this.commitReactionAdd : this.commitReactionRemove;
            function1.invoke(messageReactionUpdate);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableRemoveSelfReaction, false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, new WidgetChatListAdapterEventsHandler6(function12, messageReactionUpdate), (Function0) null, (Function0) null, new WidgetChatListAdapterEventsHandler5(this, reaction), 52, (Object) null);
        }

        public final void addNewReaction(Emoji emoji, long channelId, long messageId) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            RestAPI api = RestAPI.INSTANCE.getApi();
            String reactionKey = emoji.getReactionKey();
            Intrinsics3.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(channelId, messageId, reactionKey), false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetChatListAdapterEventsHandler2.INSTANCE, 60, (Object) null);
        }

        public final void toggleReaction(long userId, long channelId, long messageId, MessageReaction reaction) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
            this.requestStream.onNext(new UpdateRequest(userId, channelId, messageId, reaction));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetChatListAdapterItemCallMessage.CallStatus.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[WidgetChatListAdapterItemCallMessage.CallStatus.ACTIVE_JOINED.ordinal()] = 1;
            iArr[WidgetChatListAdapterItemCallMessage.CallStatus.ACTIVE_UNJOINED.ordinal()] = 2;
            StickerType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[StickerType.STANDARD.ordinal()] = 1;
            iArr2[StickerType.GUILD.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onCallMessageClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $voiceChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$voiceChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), this.$voiceChannelId, true, null, null, 24, null);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/chat/list/adapter/WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1$1", "Lcom/discord/widgets/chat/input/emoji/EmojiPickerListener;", "Lcom/discord/models/domain/emoji/Emoji;", "emoji", "", "onEmojiPicked", "(Lcom/discord/models/domain/emoji/Emoji;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickAddReactionClicked$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02661 implements EmojiPickerListener {
            public C02661() {
            }

            @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
            public void onEmojiPicked(Emoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                UserReactionHandler userReactionHandlerAccess$getUserReactionHandler$p = WidgetChatListAdapterEventsHandler.access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler.this);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                userReactionHandlerAccess$getUserReactionHandler$p.addNewReaction(emoji, anonymousClass1.$channelId, anonymousClass1.$messageId);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            EmojiPickerNavigator.launchBottomSheet$default(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this), new C02661(), EmojiPickerContextType.Chat.INSTANCE, null, 8, null);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $fileName;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ WeakReference $weakContext;

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "savedFileName", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02671 extends Lambda implements Function1<String, Unit> {
            public C02671() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Context context = (Context) AnonymousClass1.this.$weakContext.get();
                if (context != null) {
                    AppToast.h(context, FormatUtils.h(context, R.string.download_file_complete, new Object[]{str}, null, 4), 0, null, 12);
                }
            }
        }

        /* compiled from: WidgetChatListAdapterEventsHandler.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "error", "", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onQuickDownloadClicked$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Throwable, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics3.checkNotNullParameter(th, "error");
                AppLog.i("Could not download attachment due to:  \n" + th);
                Context context = (Context) AnonymousClass1.this.$weakContext.get();
                if (context != null) {
                    AppToast.h((Context) AnonymousClass1.this.$weakContext.get(), context.getString(R.string.download_failed), 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Uri uri, String str, WeakReference weakReference) {
            super(0);
            this.$uri = uri;
            this.$fileName = str;
            this.$weakContext = weakReference;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            NetworkUtils.downloadFile(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), this.$uri, this.$fileName, null, new C02671(), new AnonymousClass2());
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onReactionClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ long $myUserId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, long j3, MessageReaction messageReaction) {
            super(0);
            this.$myUserId = j;
            this.$channelId = j2;
            this.$messageId = j3;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatListAdapterEventsHandler.access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler.this).toggleReaction(this.$myUserId, this.$channelId, this.$messageId, this.$reaction);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onReactionLongClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReaction messageReaction) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetManageReactions.INSTANCE.create(this.$channelId, this.$messageId, WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), this.$reaction);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/message/Message;", "it", "", "invoke", "(Lcom/discord/api/message/Message;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onSendGreetMessageClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Message, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            Intrinsics3.checkNotNullParameter(message, "it");
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/channel/Channel;", "defaultChannel", "", "invoke", "(Lcom/discord/api/channel/Channel;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onShareButtonClick$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ long $guildEventId;
        public final /* synthetic */ WeakReference $weakFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WeakReference weakReference, Channel channel, long j) {
            super(1);
            this.$weakFragment = weakReference;
            this.$channel = channel;
            this.$guildEventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            AppFragment appFragment = (AppFragment) this.$weakFragment.get();
            if (appFragment != null) {
                ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(appFragment, "fragment");
                Channel channel2 = this.$channel;
                ChannelInviteLaunchUtils.inviteToChannel$default(channelInviteLaunchUtils, appFragment, channel2 != null ? channel2 : channel, GuildScheduledEventUtilities.ANALYTICS_SOURCE, Long.valueOf(this.$guildEventId), null, 16, null);
            }
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/sticker/BaseSticker;", "fetchedSticker", "", "invoke", "(Lcom/discord/api/sticker/BaseSticker;)V", "handleFullStickerClicked"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<BaseSticker, Unit> {
        public final /* synthetic */ com.discord.models.message.Message $message;
        public final /* synthetic */ BaseSticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BaseSticker baseSticker, com.discord.models.message.Message message) {
            super(1);
            this.$sticker = baseSticker;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(BaseSticker baseSticker) {
            invoke2(baseSticker);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(BaseSticker baseSticker) {
            if (baseSticker == null) {
                baseSticker = this.$sticker;
            }
            if (baseSticker instanceof StickerPartial) {
                return;
            }
            Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
            Sticker sticker = (Sticker) baseSticker;
            int iOrdinal = sticker.getType().ordinal();
            if (iOrdinal == 1) {
                WidgetStickerSheet.INSTANCE.show(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this), sticker, this.$message.getChannelId());
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                WidgetGuildStickerSheet.INSTANCE.show(WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this), sticker);
            }
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ BaseSticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(BaseSticker baseSticker) {
            super(1);
            this.$sticker = baseSticker;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetUnknownStickerSheet.Companion companion = WidgetUnknownStickerSheet.INSTANCE;
            FragmentManager fragmentManagerAccess$getFragmentManager$p = WidgetChatListAdapterEventsHandler.access$getFragmentManager$p(WidgetChatListAdapterEventsHandler.this);
            BaseSticker baseSticker = this.$sticker;
            Objects.requireNonNull(baseSticker, "null cannot be cast to non-null type com.discord.api.sticker.StickerPartial");
            companion.show(fragmentManagerAccess$getFragmentManager$p, (StickerPartial) baseSticker);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/sticker/Sticker;", "fetchedSticker", "", "invoke", "(Lcom/discord/api/sticker/Sticker;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onStickerClicked$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Sticker, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleFullStickerClicked$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$handleFullStickerClicked$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Sticker sticker) {
            invoke2(sticker);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Sticker sticker) {
            this.$handleFullStickerClicked$1.invoke2((BaseSticker) sticker);
        }
    }

    /* compiled from: WidgetChatListAdapterEventsHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/activity/ActivityActionConfirmation;", "<name for destructuring parameter 0>", "", "invoke", "(Lcom/discord/api/activity/ActivityActionConfirmation;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler$onUserActivityAction$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ActivityActionConfirmation, Unit> {
        public final /* synthetic */ Application $application;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Application application) {
            super(1);
            this.$application = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ActivityActionConfirmation activityActionConfirmation) {
            invoke2(activityActionConfirmation);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ActivityActionConfirmation activityActionConfirmation) {
            Intrinsics3.checkNotNullParameter(activityActionConfirmation, "<name for destructuring parameter 0>");
            try {
                Intent intentJoin = IntentUtils.RouteBuilders.SDK.join(this.$application.a(), this.$application.getId(), activityActionConfirmation.getSecret());
                intentJoin.addFlags(268435456);
                WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this).startActivity(intentJoin);
            } catch (ActivityNotFoundException unused) {
                AppToast.h(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), FormatUtils.h(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), R.string.user_activity_not_detected, new Object[]{this.$application.getName()}, null, 4), 0, null, 12);
                String str = (String) _Collections.firstOrNull((List) this.$application.d());
                if (str != null) {
                    UriHandler.directToPlayStore$default(WidgetChatListAdapterEventsHandler.access$getContext$p(WidgetChatListAdapterEventsHandler.this), str, null, 4, null);
                }
            }
        }
    }

    public WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, UserReactionHandler userReactionHandler, StoreChannels storeChannels, AnalyticsUtils.Tracker tracker) {
        Intrinsics3.checkNotNullParameter(appFragment, "host");
        Intrinsics3.checkNotNullParameter(appFlexInputViewModel, "flexInputViewModel");
        Intrinsics3.checkNotNullParameter(storeChat, "storeChat");
        Intrinsics3.checkNotNullParameter(storeMessages, "storeMessages");
        Intrinsics3.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
        Intrinsics3.checkNotNullParameter(userReactionHandler, "userReactionHandler");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        Intrinsics3.checkNotNullParameter(tracker, "analyticsTracker");
        this.host = appFragment;
        this.flexInputViewModel = appFlexInputViewModel;
        this.storeChat = storeChat;
        this.storeMessages = storeMessages;
        this.storePendingReplies = storePendingReplies;
        this.storeUser = storeUser;
        this.storeEmoji = storeEmoji;
        this.messageManager = messageManager;
        this.channelSelector = channelSelector;
        this.userReactionHandler = userReactionHandler;
        this.channelStore = storeChannels;
        this.analyticsTracker = tracker;
    }

    public static final /* synthetic */ Context access$getContext$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.getContext();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.getFragmentManager();
    }

    public static final /* synthetic */ UserReactionHandler access$getUserReactionHandler$p(WidgetChatListAdapterEventsHandler widgetChatListAdapterEventsHandler) {
        return widgetChatListAdapterEventsHandler.userReactionHandler;
    }

    private final Context getContext() {
        return this.host.requireContext();
    }

    private final FragmentManager getFragmentManager() {
        FragmentManager parentFragmentManager = this.host.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "host.parentFragmentManager");
        return parentFragmentManager;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
        Intrinsics3.checkNotNullParameter(componentSendData, "componentSendData");
        StoreStream.INSTANCE.getInteractions().sendComponentInteraction(applicationId, guildId, channelId, messageId, componentIndex, componentSendData, messageFlags);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
        Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0) {
            AnimatableValueParser.S1(this.host, null, new AnonymousClass1(voiceChannelId), 1, null);
        } else if (iOrdinal != 1) {
            WidgetStartCallSheet.INSTANCE.show(voiceChannelId, getFragmentManager());
        } else {
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, getContext(), voiceChannelId, false, null, null, 28, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        WidgetApplicationCommandBottomSheet.Companion companion = WidgetApplicationCommandBottomSheet.INSTANCE;
        FragmentManager childFragmentManager = this.host.getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "host.childFragmentManager");
        companion.show(childFragmentManager, interactionId, messageId, channelId, guildId, interactionUserId, applicationId, messageNonce);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onDismissClicked(com.discord.models.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.storeMessages.deleteMessage(message);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onDismissLocalMessageClicked(com.discord.models.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        String nonce = message.getNonce();
        if (nonce != null) {
            this.storeMessages.deleteLocalMessage(message.getChannelId(), nonce);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
        Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
        this.storeChat.setInteractionState(interactionState);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onListClicked() {
        AppFragment.hideKeyboard$default(this.host, null, 1, null);
        this.flexInputViewModel.hideExpressionTray();
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorAvatarClicked(com.discord.models.message.Message message, long guildId) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message) || message.isCrosspost()) {
            onMessageAuthorNameClicked(message, guildId);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorLongClicked(com.discord.models.message.Message message, Long guildId) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (message.isWebhook()) {
            AppToast.g(getContext(), R.string.user_profile_failure_to_open_message, 0, null, 8);
            return;
        }
        User author = message.getAuthor();
        if (author != null) {
            WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, author.getId(), Long.valueOf(message.getChannelId()), getFragmentManager(), guildId, null, null, null, 112, null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageAuthorNameClicked(com.discord.models.message.Message message, long guildId) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message)) {
            WidgetPublicAnnouncementProfileSheet.INSTANCE.show(getFragmentManager());
            return;
        }
        if (!message.isCrosspost() || message.getMessageReference() == null) {
            StoreChat storeChat = this.storeChat;
            User author = message.getAuthor();
            Intrinsics3.checkNotNull(author);
            storeChat.appendMention(new CoreUser(author), guildId);
            return;
        }
        MessageReference messageReference = message.getMessageReference();
        Long channelId = messageReference != null ? messageReference.getChannelId() : null;
        MessageReference messageReference2 = message.getMessageReference();
        Long guildId2 = messageReference2 != null ? messageReference2.getGuildId() : null;
        if (guildId2 == null || channelId == null) {
            return;
        }
        WidgetGuildProfileSheet.Companion.show$default(WidgetGuildProfileSheet.INSTANCE, getFragmentManager(), false, guildId2.longValue(), channelId.longValue(), false, 16, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageBlockedGroupClicked(com.discord.models.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        this.storeChat.toggleBlockedMessageGroup(message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageClicked(com.discord.models.message.Message message, boolean isThreadStarterMessage) {
        Intrinsics3.checkNotNullParameter(message, "message");
        if (isThreadStarterMessage) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onMessageLongClicked(com.discord.models.message.Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
        if (isThreadStarterMessage) {
            return;
        }
        WidgetChatListActions.INSTANCE.showForChat(getFragmentManager(), message.getChannelId(), message.getId(), formattedMessage);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onOldestMessageId(long channelId, long oldestMessageId) {
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onOpenPinsClicked(com.discord.models.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        WidgetChannelPinnedMessages.INSTANCE.show(getContext(), message.getChannelId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(channelId, messageId), 32, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public boolean onQuickDownloadClicked(Uri uri, String fileName) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(fileName, "fileName");
        this.host.requestMediaDownload(new AnonymousClass1(uri, fileName, new WeakReference(getContext())));
        return true;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        if (canAddReactions) {
            MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(myUserId, channelId, messageId, reaction), 32, null);
        } else {
            AppToast.g(getContext(), R.string.archived_thread_reactions_disabled_toast, 0, null, 8);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, getContext(), getFragmentManager(), guildId, Traits.Location.Section.EMOJI_PICKER_POPOUT, null, null, new AnonymousClass1(channelId, messageId, reaction), 32, null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onReportIssueWithAutoMod(Context context, com.discord.models.message.Message message) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(message, "message");
        WidgetReportIssueWithAutoMod.INSTANCE.launch(context, message.getChannelId(), message.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId) {
        WidgetGuildRoleSubscriptionEntryPoint.INSTANCE.launch(getContext(), guildId, "Role Subscriptions Tab");
        AnalyticsUtils.Tracker tracker = this.analyticsTracker;
        TrackRoleSubscriptionPurchaseSystemMessageClicked trackRoleSubscriptionPurchaseSystemMessageClicked = new TrackRoleSubscriptionPurchaseSystemMessageClicked(Long.valueOf(messageId), Long.valueOf(roleSubscriptionListingId));
        trackRoleSubscriptionPurchaseSystemMessageClicked.f(new TrackChannel(Long.valueOf(channelId), null, null, null, null, null, 62));
        trackRoleSubscriptionPurchaseSystemMessageClicked.c(new TrackGuild(Long.valueOf(guildId), null, null, null, null, null, null, null, null, null, null, null, 4094));
        trackRoleSubscriptionPurchaseSystemMessageClicked.e(new TrackBase(null, null, null, null, null, Long.valueOf(userId), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -33, -1, 2047));
        tracker.track(trackRoleSubscriptionPurchaseSystemMessageClicked);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker) {
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        AnalyticsTracker.INSTANCE.getTracker().track("dm_empty_action", Maps6.mutableMapOf(Tuples.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channelId)), Tuples.to("channel_type", Integer.valueOf(channelType)), Tuples.to("source", "Wave"), Tuples.to("type", "Send wave")));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().sendGreetMessage(channelId, new RestAPIParams.GreetMessage(CollectionsJVM.listOf(Long.valueOf(sticker.getId())))), false, 1, null), this.host, null, 2, null), this.host.getClass(), this.host.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 60, (Object) null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        Intrinsics3.checkNotNullParameter(weakContext, "weakContext");
        Intrinsics3.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent$default = GuildScheduledEventUtilities.Companion.canShareEvent$default(GuildScheduledEventUtilities.INSTANCE, channelId, guildId, null, null, null, null, 60, null);
        if (channelId != null) {
            channel = this.channelStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent$default) {
            Observable<Channel> observableZ = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).z();
            Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe$default(observableZ, WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(weakFragment, channel, id2), 62, (Object) null);
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppToast.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onStickerClicked(com.discord.models.message.Message message, BaseSticker sticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(sticker, message);
        this.flexInputViewModel.hideKeyboard();
        if (sticker instanceof Sticker) {
            anonymousClass1.invoke2(sticker);
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StickerUtils.INSTANCE.getGuildOrStandardSticker(sticker.getId(), true), this.host, null, 2, null), WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, new AnonymousClass2(sticker), (Function0) null, (Function0) null, new AnonymousClass3(anonymousClass1), 54, (Object) null);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onSystemMessageCtaClicked(com.discord.models.message.Message message, Channel channel, BaseSticker sticker) {
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(sticker, "sticker");
        this.storePendingReplies.onCreatePendingReply(channel, message, true, true);
        MessageManager.sendMessage$default(this.messageManager, null, null, null, null, CollectionsJVM.listOf(sticker), false, null, null, null, 495, null);
        Integer type = message.getType();
        if (type != null && type.intValue() == 7) {
            AnalyticsUtils.Tracker tracker = this.analyticsTracker;
            Boolean bool = Boolean.TRUE;
            String strValueOf = String.valueOf(sticker.getId());
            User author = message.getAuthor();
            tracker.track(new TrackWelcomeCtaClicked(bool, strValueOf, author != null ? Long.valueOf(author.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId())));
            return;
        }
        if (type != null && type.intValue() == 25) {
            AnalyticsUtils.Tracker tracker2 = this.analyticsTracker;
            String strValueOf2 = String.valueOf(sticker.getId());
            User author2 = message.getAuthor();
            TrackRoleSubscriptionPurchaseSystemMessageCtaClicked trackRoleSubscriptionPurchaseSystemMessageCtaClicked = new TrackRoleSubscriptionPurchaseSystemMessageCtaClicked(Long.valueOf(message.getId()), strValueOf2, author2 != null ? Long.valueOf(author2.getId()) : null, Long.valueOf(this.storeUser.getMeSnapshot().getId()));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.c(new TrackGuild(Long.valueOf(channel.getGuildId()), null, null, null, null, null, null, null, null, null, null, null, 4094));
            trackRoleSubscriptionPurchaseSystemMessageCtaClicked.e(new TrackChannel(Long.valueOf(channel.getId()), null, null, null, null, null, 62));
            tracker2.track(trackRoleSubscriptionPurchaseSystemMessageCtaClicked);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onThreadClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.channelSelector.selectChannel(channel, Long.valueOf(channel.getParentId()), StoreChannelsSelected3.EMBED);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onThreadLongClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        WidgetChannelsListItemThreadActions.INSTANCE.show(getFragmentManager(), channel.getId());
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUrlLongClicked(String url) {
        Intrinsics3.checkNotNullParameter(url, "url");
        WidgetUrlActions.INSTANCE.launch(getFragmentManager(), url);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
        Intrinsics3.checkNotNullParameter(actionType, "actionType");
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(application, "application");
        Long applicationId = activity.getApplicationId();
        String sessionId = activity.getSessionId();
        if (applicationId == null || sessionId == null || actionType != MessageActivityType.JOIN) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userActivityActionJoin(authorId, applicationId.longValue(), sessionId, Long.valueOf(channelId), Long.valueOf(messageId)), false, 1, null), this.host, null, 2, null), WidgetChatListAdapterEventsHandler.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(application), 62, (Object) null);
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
    public void onUserMentionClicked(long userId, long channelId, long guildId) {
        WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, userId, Long.valueOf(channelId), getFragmentManager(), Long.valueOf(guildId), null, null, null, 112, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChatListAdapterEventsHandler(AppFragment appFragment, AppFlexInputViewModel appFlexInputViewModel, StoreChat storeChat, StoreMessages storeMessages, StorePendingReplies storePendingReplies, StoreUser storeUser, StoreEmoji storeEmoji, MessageManager messageManager, ChannelSelector channelSelector, UserReactionHandler userReactionHandler, StoreChannels storeChannels, AnalyticsUtils.Tracker tracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChat chat = (i & 4) != 0 ? StoreStream.INSTANCE.getChat() : storeChat;
        StoreMessages messages = (i & 8) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages;
        StorePendingReplies pendingReplies = (i & 16) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreEmoji emojis = (i & 64) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        this(appFragment, appFlexInputViewModel, chat, messages, pendingReplies, users, emojis, (i & 128) != 0 ? new MessageManager(appFragment.requireContext(), null, null, null, null, null, null, null, null, 510, null) : messageManager, (i & 256) != 0 ? ChannelSelector.INSTANCE.getInstance() : channelSelector, (i & 512) != 0 ? new UserReactionHandler(appFragment, messages, emojis) : userReactionHandler, (i & 1024) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2048) != 0 ? AnalyticsUtils.Tracker.INSTANCE.getInstance() : tracker);
    }
}
