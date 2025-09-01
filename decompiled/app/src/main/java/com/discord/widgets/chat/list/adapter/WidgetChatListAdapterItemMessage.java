package com.discord.widgets.chat.list.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.LeadingMarginSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.interaction.Interaction;
import com.discord.api.message.LocalAttachment;
import com.discord.api.permission.Permission;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.PublicGuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.node.SpoilerNode;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.FailedUploadList;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.chat.list.ChatListItemMessageAccessibilityDelegate;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.utils.EmbeddedMessageParser;
import com.discord.widgets.roles.RoleIconView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: WidgetChatListAdapterItemMessage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B\u001c\u0012\b\b\u0001\u0010~\u001a\u00020\u0010\u0012\u0007\u0010\u0080\u0001\u001a\u00020\u007f¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u0018J\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b \u0010\u001cJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\"\u0010#J)\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b,\u0010\u001cJ!\u00101\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-2\b\b\u0002\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u00103\u001a\u00020\u0012H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00107\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b9\u0010:J9\u0010A\u001a\u00020@2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u001f\u001a\u00020\u00192\u0018\u0010?\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030>\u0012\u0004\u0012\u00020\u0007\u0018\u00010=H\u0002¢\u0006\u0004\bA\u0010BJ)\u0010G\u001a\u00020F2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\b\u0010E\u001a\u0004\u0018\u00010DH\u0002¢\u0006\u0004\bG\u0010HJ\u001f\u0010K\u001a\u00020\u00072\u0006\u0010J\u001a\u00020I2\u0006\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\bK\u0010LJ)\u0010M\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030>\u0012\u0004\u0012\u00020\u0007\u0018\u00010=2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\bM\u0010NJ\u0019\u0010O\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\bO\u0010PJ\u0019\u0010R\u001a\u00020\u00102\b\u0010Q\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\bR\u0010SJ\u001f\u0010U\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010T\u001a\u00020\u0012H\u0002¢\u0006\u0004\bU\u00105J\u001f\u0010Y\u001a\u00020\u00072\u0006\u0010V\u001a\u00020\u00102\u0006\u0010X\u001a\u00020WH\u0014¢\u0006\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010]R\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010h\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010]R\u0018\u0010i\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bi\u0010bR\u0018\u0010j\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010]R\u0016\u0010k\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010_R\u0018\u0010q\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010bR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010u\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010bR\u0018\u0010v\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010lR\u0018\u0010w\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010bR\u0018\u0010x\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010_R\u0018\u0010y\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010_R\u0018\u0010z\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010]R\u0018\u0010{\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010bR\u0018\u0010|\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010_R\u0018\u0010}\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010]¨\u0006\u0084\u0001"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemMessage;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListItem;", "Lcom/discord/models/member/GuildMember;", "guildMember", "", "Lcom/discord/api/permission/PermissionBit;", "permissionsForChannel", "", "configureCommunicationDisabled", "(Lcom/discord/models/member/GuildMember;Ljava/lang/Long;)V", "Lcom/discord/models/user/User;", "messageAuthor", "configureReplyAvatar", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "", "originalAuthorName", "", ModelAuditLogEntry.CHANGE_KEY_COLOR, "", "didMention", "configureReplyName", "(Ljava/lang/String;IZ)V", "stringResourceId", "configureReplyContentWithResourceId", "(I)V", "Lcom/discord/widgets/chat/list/entries/MessageEntry;", "repliedMessageEntry", "configureReplySystemMessageUserJoin", "(Lcom/discord/widgets/chat/list/entries/MessageEntry;)V", "configureReplySystemMessageRoleSubscriptionPurchase", "configureReplySystemMessage", "messageEntry", "configureReplyInteraction", "Landroid/widget/TextView;", "configureInteractionMessage", "(Lcom/discord/widgets/chat/list/entries/MessageEntry;)Landroid/widget/TextView;", "replyAuthor", "replyGuildMember", "configureReplyAuthor", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;Lcom/discord/widgets/chat/list/entries/MessageEntry;)V", "Lcom/discord/models/message/Message;", "message", "shouldShowInteractionMessage", "(Lcom/discord/models/message/Message;)Z", "configureReplyPreview", "Landroid/text/Spannable;", "content", "", Key.ALPHA, "configureReplyText", "(Landroid/text/Spannable;F)V", "isThreadStarterMessage", "configureThreadSpine", "(Lcom/discord/models/message/Message;Z)V", "Landroid/text/style/LeadingMarginSpan;", "getLeadingEdgeSpan", "()Landroid/text/style/LeadingMarginSpan;", "configureReplyLayoutDirection", "()V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "spoilerClickHandler", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "getMessageRenderContext", "(Landroid/content/Context;Lcom/discord/widgets/chat/list/entries/MessageEntry;Lkotlin/jvm/functions/Function1;)Lcom/discord/utilities/textprocessing/MessageRenderContext;", "userId", "Lcom/discord/stores/StoreMessageState$State;", "messageState", "Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "getMessagePreprocessor", "(JLcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;)Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;", "textView", "processMessageText", "(Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;Lcom/discord/widgets/chat/list/entries/MessageEntry;)V", "getSpoilerClickHandler", "(Lcom/discord/models/message/Message;)Lkotlin/jvm/functions/Function1;", "shouldLinkify", "(Ljava/lang/String;)Z", "member", "getAuthorTextColor", "(Lcom/discord/models/member/GuildMember;)I", "isGuildForumPostAuthor", "configureItemTag", ModelAuditLogEntry.CHANGE_KEY_POSITION, "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "data", "onConfigure", "(ILcom/discord/widgets/chat/list/entries/ChatListEntry;)V", "Landroid/widget/ImageView;", "sendError", "Landroid/widget/ImageView;", "itemTimestamp", "Landroid/widget/TextView;", "Landroid/view/View;", "backgroundHighlight", "Landroid/view/View;", "replyName", "itemAvatar", "Lcom/discord/views/FailedUploadList;", "failedUploadList", "Lcom/discord/views/FailedUploadList;", "replyAvatar", "replyLinkItem", "communicationDisabledIcon", "itemText", "Lcom/discord/utilities/view/text/SimpleDraweeSpanTextView;", "Lcom/discord/views/typing/TypingDots;", "loadingDots", "Lcom/discord/views/typing/TypingDots;", "itemAlertText", "replyLeadingViewsHolder", "Lcom/discord/widgets/roles/RoleIconView;", "itemRoleIcon", "Lcom/discord/widgets/roles/RoleIconView;", "gutterHighlight", "replyText", "replyHolder", "itemTag", "itemLoadingText", "replyIcon", "threadStarterMessageHeader", "itemName", "threadEmbedSpine", "layout", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "adapter", "<init>", "(ILcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemMessage extends WidgetChatListItem {
    private static final int MAX_REPLY_AST_NODES = 50;
    private final View backgroundHighlight;
    private final ImageView communicationDisabledIcon;
    private final FailedUploadList failedUploadList;
    private final View gutterHighlight;
    private final TextView itemAlertText;
    private final ImageView itemAvatar;
    private final TextView itemLoadingText;
    private final TextView itemName;
    private final RoleIconView itemRoleIcon;
    private final TextView itemTag;
    private final SimpleDraweeSpanTextView itemText;
    private final TextView itemTimestamp;
    private final TypingDots loadingDots;
    private final ImageView replyAvatar;
    private final View replyHolder;
    private final ImageView replyIcon;
    private final View replyLeadingViewsHolder;
    private final View replyLinkItem;
    private final TextView replyName;
    private final SimpleDraweeSpanTextView replyText;
    private final ImageView sendError;
    private final ImageView threadEmbedSpine;
    private final View threadStarterMessageHeader;

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyInteraction$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Message $message;

        public AnonymousClass1(Message message) {
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorAvatarClicked(this.$message, WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$configureReplyPreview$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Message $repliedMessage;

        public AnonymousClass1(Message message) {
            this.$repliedMessage = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(this.$repliedMessage.getChannelId(), this.$repliedMessage.getId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "clickContext", "", "url", "mask", "", "invoke", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function3<Context, String, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "clickContext");
            Intrinsics3.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "url", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(str, "url");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onUrlLongClicked(str);
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "userId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData();
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "channelId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getMessageRenderContext$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$context, j);
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/textprocessing/node/SpoilerNode;", "spoilerNode", "", "invoke", "(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$getSpoilerClickHandler$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<SpoilerNode<?>, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
            invoke2(spoilerNode);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SpoilerNode<?> spoilerNode) {
            Intrinsics3.checkNotNullParameter(spoilerNode, "spoilerNode");
            StoreStream.INSTANCE.getMessageState().revealSpoiler(this.$message.getId(), spoilerNode.getId());
            WidgetChatListAdapterItemMessage.this.itemView.sendAccessibilityEvent(16);
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Message $message;

        public AnonymousClass1(Message message) {
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorNameClicked(this.$message, WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorLongClicked(this.$message, Long.valueOf(WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId()));
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ boolean $isThreadStarterMessage;
        public final /* synthetic */ Message $message;

        public AnonymousClass3(Message message, boolean z2) {
            this.$message = message;
            this.$isThreadStarterMessage = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageClicked(this.$message, this.$isThreadStarterMessage);
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ boolean $isThreadStarterMessage;
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Message message, boolean z2) {
            super(1);
            this.$message = message;
            this.$isThreadStarterMessage = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageLongClicked(this.$message, WidgetChatListAdapterItemMessage.access$getItemText$p(WidgetChatListAdapterItemMessage.this).getText().subSequence(0, Math.max(WidgetChatListAdapterItemMessage.access$getItemText$p(WidgetChatListAdapterItemMessage.this).getText().length() - 1, 0)), this.$isThreadStarterMessage);
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Message $message;

        public AnonymousClass5(Message message) {
            this.$message = message;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorAvatarClicked(this.$message, WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId());
        }
    }

    /* compiled from: WidgetChatListAdapterItemMessage.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemMessage$onConfigure$6, reason: invalid class name */
    public static final class AnonymousClass6 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getEventHandler().onMessageAuthorLongClicked(this.$message, Long.valueOf(WidgetChatListAdapterItemMessage.access$getAdapter$p(WidgetChatListAdapterItemMessage.this).getData().getGuildId()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemMessage(@LayoutRes int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View viewFindViewById = this.itemView.findViewById(R.id.chat_list_adapter_item_text);
        Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "itemView.findViewById(R.…t_list_adapter_item_text)");
        this.itemText = (SimpleDraweeSpanTextView) viewFindViewById;
        this.itemAvatar = (ImageView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_avatar);
        this.itemName = (TextView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_name);
        this.itemRoleIcon = (RoleIconView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_role_icon);
        this.itemTag = (TextView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_tag);
        this.replyHolder = this.itemView.findViewById(R.id.chat_list_adapter_item_text_decorator);
        this.replyLinkItem = this.itemView.findViewById(R.id.chat_list_adapter_item_text_decorator_reply_link_icon);
        this.replyLeadingViewsHolder = this.itemView.findViewById(R.id.chat_list_adapter_item_reply_leading_views);
        this.replyName = (TextView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_decorator_reply_name);
        this.replyIcon = (ImageView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_decorator_reply_icon);
        this.replyAvatar = (ImageView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_decorator_avatar);
        this.replyText = (SimpleDraweeSpanTextView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_reply_content);
        this.itemTimestamp = (TextView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_timestamp);
        this.failedUploadList = (FailedUploadList) this.itemView.findViewById(R.id.chat_list_adapter_item_failed_upload_list);
        this.itemAlertText = (TextView) this.itemView.findViewById(R.id.chat_list_adapter_item_alert_text);
        this.itemLoadingText = (TextView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_loading);
        this.backgroundHighlight = this.itemView.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
        this.gutterHighlight = this.itemView.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        this.loadingDots = (TypingDots) this.itemView.findViewById(R.id.chat_overlay_typing_dots);
        this.sendError = (ImageView) this.itemView.findViewById(R.id.chat_list_adapter_item_text_error);
        this.threadEmbedSpine = (ImageView) this.itemView.findViewById(R.id.chat_list_adapter_item_thread_embed_spine);
        this.threadStarterMessageHeader = this.itemView.findViewById(R.id.thread_starter_message_header);
        this.communicationDisabledIcon = (ImageView) this.itemView.findViewById(R.id.chat_list_adapter_item_communication_disabled_icon);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemMessage.adapter;
    }

    public static final /* synthetic */ SimpleDraweeSpanTextView access$getItemText$p(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage) {
        return widgetChatListAdapterItemMessage.itemText;
    }

    public static final /* synthetic */ SimpleDraweeSpanTextView access$getReplyText$p(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage) {
        return widgetChatListAdapterItemMessage.replyText;
    }

    private final void configureCommunicationDisabled(GuildMember guildMember, Long permissionsForChannel) {
        boolean z2 = false;
        boolean zIsCommunicationDisabled = guildMember != null ? guildMember.isCommunicationDisabled() : false;
        boolean z3 = PermissionUtils.can(Permission.MODERATE_MEMBERS, permissionsForChannel) || PermissionUtils.can(8L, permissionsForChannel);
        if (zIsCommunicationDisabled && z3) {
            z2 = true;
        }
        ImageView imageView = this.communicationDisabledIcon;
        if (imageView != null) {
            ViewKt.setVisible(imageView, z2);
        }
        ImageView imageView2 = this.itemAvatar;
        if (imageView2 != null) {
            imageView2.setAlpha(z2 ? 0.5f : 1.0f);
        }
    }

    private final TextView configureInteractionMessage(MessageEntry messageEntry) {
        int themedColor;
        Message message = messageEntry.getMessage();
        boolean zShouldShowInteractionMessage = shouldShowInteractionMessage(message);
        TypingDots typingDots = this.loadingDots;
        if (typingDots != null) {
            ViewKt.setVisible(typingDots, zShouldShowInteractionMessage);
        }
        if (zShouldShowInteractionMessage) {
            TypingDots typingDots2 = this.loadingDots;
            if (typingDots2 != null) {
                int i = TypingDots.j;
                typingDots2.a(false);
            }
        } else {
            TypingDots typingDots3 = this.loadingDots;
            if (typingDots3 != null) {
                typingDots3.c();
            }
        }
        TextView textView = this.itemLoadingText;
        if (textView != null) {
            ViewKt.setVisible(textView, zShouldShowInteractionMessage);
        }
        this.itemText.setVisibility(zShouldShowInteractionMessage ^ true ? 0 : 8);
        ImageView imageView = this.sendError;
        if (imageView != null) {
            ViewKt.setVisible(imageView, false);
        }
        if (!zShouldShowInteractionMessage) {
            return this.itemText;
        }
        TextView textView2 = this.itemTag;
        if (textView2 != null) {
            ViewKt.setVisible(textView2, true);
        }
        if (message.isFailed()) {
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            themedColor = ColorCompat.getThemedColor(view, R.attr.colorError);
        } else {
            View view2 = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
            themedColor = ColorCompat.getThemedColor(view2, R.attr.colorTextMuted);
        }
        TextView textView3 = this.itemLoadingText;
        if (textView3 != null) {
            textView3.setTextColor(themedColor);
        }
        if (message.isLocalApplicationCommand() && message.isLoading()) {
            TextView textView4 = this.itemLoadingText;
            if (textView4 != null) {
                Context context = this.itemText.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "itemText.context");
                Object[] objArr = new Object[1];
                Map<Long, String> nickOrUsernames = messageEntry.getNickOrUsernames();
                User author = message.getAuthor();
                objArr[0] = nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null);
                textView4.setText(FormatUtils.h(context, R.string.application_command_waiting, objArr, null, 4));
            }
            ImageView imageView2 = this.sendError;
            if (imageView2 != null) {
                ViewKt.setVisible(imageView2, false);
            }
        } else if (message.isLocalApplicationCommand() && message.isFailed()) {
            TextView textView5 = this.itemLoadingText;
            if (textView5 != null) {
                textView5.setText(R.string.application_command_failed);
            }
            ImageView imageView3 = this.sendError;
            if (imageView3 != null) {
                ViewKt.setVisible(imageView3, true);
            }
            TypingDots typingDots4 = this.loadingDots;
            if (typingDots4 != null) {
                ViewKt.setInvisible(typingDots4, true);
            }
            TypingDots typingDots5 = this.loadingDots;
            if (typingDots5 != null) {
                typingDots5.c();
            }
        } else if (message.isLocalApplicationCommand()) {
            TextView textView6 = this.itemLoadingText;
            if (textView6 != null) {
                textView6.setText(R.string.application_command_sending);
            }
            ImageView imageView4 = this.sendError;
            if (imageView4 != null) {
                ViewKt.setVisible(imageView4, false);
            }
        }
        TextView textView7 = this.itemLoadingText;
        return textView7 != null ? textView7 : this.itemText;
    }

    private final void configureItemTag(Message message, boolean isGuildForumPostAuthor) {
        if (this.itemTag != null) {
            User author = message.getAuthor();
            Intrinsics3.checkNotNull(author);
            CoreUser coreUser = new CoreUser(author);
            boolean zIsPublicGuildSystemMessage = PublicGuildUtils.INSTANCE.isPublicGuildSystemMessage(message);
            Integer type = message.getType();
            boolean z2 = true;
            boolean z3 = (type == null || type.intValue() != 0 || message.getMessageReference() == null) ? false : true;
            TextView textView = this.itemTag;
            if (!coreUser.getIsBot() && !coreUser.getIsSystemUser() && !zIsPublicGuildSystemMessage && !z3 && !isGuildForumPostAuthor) {
                z2 = false;
            }
            textView.setVisibility(z2 ? 0 : 8);
            this.itemTag.setText((coreUser.getIsSystemUser() || zIsPublicGuildSystemMessage) ? R.string.system_dm_tag_system : z3 ? R.string.bot_tag_server : isGuildForumPostAuthor ? R.string.bot_tag_forum_original_poster : R.string.bot_tag_bot);
            this.itemTag.setCompoundDrawablesWithIntrinsicBounds(UserUtils.INSTANCE.isVerifiedBot(coreUser) ? R.drawable.ic_verified_10dp : 0, 0, 0, 0);
        }
    }

    private final void configureReplyAuthor(com.discord.models.user.User replyAuthor, GuildMember replyGuildMember, MessageEntry messageEntry) {
        configureReplyAvatar(replyAuthor, replyGuildMember != null ? replyGuildMember : messageEntry.getAuthor());
        String username = (String) outline.f(replyAuthor, messageEntry.getNickOrUsernames());
        if (username == null) {
            username = replyAuthor.getUsername();
        }
        boolean z2 = false;
        List<User> mentions = messageEntry.getMessage().getMentions();
        if (mentions != null) {
            Iterator<T> it = mentions.iterator();
            while (it.hasNext()) {
                if (((User) it.next()).getId() == replyAuthor.getId()) {
                    z2 = true;
                }
            }
        }
        configureReplyName(username, getAuthorTextColor(replyGuildMember), z2);
    }

    private final void configureReplyAvatar(com.discord.models.user.User messageAuthor, GuildMember guildMember) {
        ImageView imageView = this.replyIcon;
        if (imageView == null || this.replyAvatar == null) {
            return;
        }
        if (messageAuthor == null) {
            imageView.setVisibility(0);
            this.replyAvatar.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            this.replyAvatar.setVisibility(0);
            IconUtils.setIcon$default(this.replyAvatar, messageAuthor, R.dimen.avatar_size_reply, null, null, guildMember, 24, null);
        }
    }

    private final void configureReplyContentWithResourceId(int stringResourceId) {
        if (this.replyText != null) {
            Context context = this.replyText.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "replyText.context");
            SpannableString spannableString = new SpannableString(context.getResources().getString(stringResourceId));
            spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            configureReplyText(spannableString, 0.64f);
        }
    }

    private final void configureReplyInteraction(MessageEntry messageEntry) {
        User user;
        Message message = messageEntry.getMessage();
        Interaction interaction = message.getInteraction();
        if (interaction == null || (user = interaction.getUser()) == null) {
            return;
        }
        GuildMember interactionAuthor = messageEntry.getInteractionAuthor();
        CoreUser coreUser = new CoreUser(user);
        configureReplyAvatar(new CoreUser(user), messageEntry.getAuthor());
        configureReplyAuthor(coreUser, interactionAuthor, messageEntry);
        TextView textView = this.replyName;
        if (textView != null) {
            textView.setOnClickListener(new AnonymousClass1(message));
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.replyText;
        if (simpleDraweeSpanTextView != null) {
            MovementMethod linkMovementMethod = LinkMovementMethod.getInstance();
            if (linkMovementMethod == null) {
                return;
            } else {
                simpleDraweeSpanTextView.setMovementMethod(linkMovementMethod);
            }
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.replyText;
        CharSequence charSequenceD = simpleDraweeSpanTextView2 != null ? FormatUtils.d(simpleDraweeSpanTextView2, R.string.system_message_application_command_reply, new Object[]{interaction.getName()}, new WidgetChatListAdapterItemMessage2(this, interaction, message, user)) : null;
        if (charSequenceD != null) {
            SpannableString spannableStringValueOf = SpannableString.valueOf(charSequenceD);
            Intrinsics3.checkNotNullExpressionValue(spannableStringValueOf, "valueOf(this)");
            configureReplyText(spannableStringValueOf, 1.0f);
        }
    }

    private final void configureReplyLayoutDirection() {
        if (this.replyHolder == null || this.replyText == null) {
            return;
        }
        this.replyHolder.setLayoutDirection(BidiFormatter.getInstance().isRtl(this.replyText.getText()) ? 1 : 0);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureReplyName(String originalAuthorName, int color, boolean didMention) {
        if (this.replyName != null) {
            if (originalAuthorName == null || originalAuthorName.length() == 0) {
                this.replyName.setVisibility(8);
                return;
            }
            String str = didMention ? "@" : "";
            this.replyName.setVisibility(0);
            this.replyName.setText(str + originalAuthorName);
            this.replyName.setTextColor(color);
        }
    }

    private final void configureReplyPreview(MessageEntry messageEntry) {
        Integer type;
        if (this.replyHolder == null || this.replyLinkItem == null) {
            return;
        }
        Message message = messageEntry.getMessage();
        MessageEntry.ReplyData replyData = messageEntry.getReplyData();
        boolean zIsInteraction = message.isInteraction();
        if (!zIsInteraction && (replyData == null || (type = messageEntry.getMessage().getType()) == null || type.intValue() != 19)) {
            this.replyHolder.setVisibility(8);
            this.replyLinkItem.setVisibility(8);
            return;
        }
        this.replyHolder.setVisibility(0);
        this.replyLinkItem.setVisibility(0);
        if (zIsInteraction) {
            configureReplyInteraction(messageEntry);
            return;
        }
        if (replyData == null) {
            return;
        }
        MessageEntry messageEntry2 = replyData.getMessageEntry();
        StoreMessageReplies.MessageState messageState = replyData.getMessageState();
        if (replyData.isRepliedUserBlocked()) {
            configureReplySystemMessage(R.string.reply_quote_message_blocked);
            return;
        }
        if (messageState instanceof StoreMessageReplies.MessageState.Unloaded) {
            configureReplySystemMessage(R.string.reply_quote_message_not_loaded);
            return;
        }
        if (messageState instanceof StoreMessageReplies.MessageState.Deleted) {
            configureReplySystemMessage(R.string.reply_quote_message_deleted);
            return;
        }
        if (!(messageState instanceof StoreMessageReplies.MessageState.Loaded) || messageEntry2 == null) {
            return;
        }
        Message message2 = messageEntry2.getMessage();
        this.replyHolder.setOnClickListener(new AnonymousClass1(message2));
        Integer type2 = message2.getType();
        if (type2 != null && type2.intValue() == 7) {
            configureReplySystemMessageUserJoin(messageEntry2);
            return;
        }
        Integer type3 = message2.getType();
        if (type3 != null && type3.intValue() == 25) {
            configureReplySystemMessageRoleSubscriptionPurchase(messageEntry2);
            return;
        }
        User author = message2.getAuthor();
        Intrinsics3.checkNotNull(author);
        configureReplyAuthor(new CoreUser(author), messageEntry2.getAuthor(), messageEntry2);
        if (this.replyText == null || this.replyLeadingViewsHolder == null) {
            return;
        }
        String content = message2.getContent();
        if (content == null) {
            content = "";
        }
        if (!(content.length() == 0)) {
            Context context = this.replyText.getContext();
            EmbeddedMessageParser embeddedMessageParser = EmbeddedMessageParser.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilder draweeSpanStringBuilder = embeddedMessageParser.parse(new EmbeddedMessageParser.ParserData(context, messageEntry2.getRoles(), messageEntry2.getNickOrUsernames(), messageEntry2.getAnimateEmojis(), new StoreMessageState.State(null, null, 3, null), 50, message2, (WidgetChatListAdapter) this.adapter));
            draweeSpanStringBuilder.setSpan(getLeadingEdgeSpan(), 0, draweeSpanStringBuilder.length(), 33);
            this.replyText.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
            configureReplyLayoutDirection();
            return;
        }
        if (message2.hasStickers()) {
            configureReplyContentWithResourceId(R.string.reply_quote_sticker_mobile);
            return;
        }
        if (message2.hasAttachments() || message2.shouldShowReplyPreviewAsAttachment() || message2.hasEmbeds()) {
            configureReplyContentWithResourceId(R.string.reply_quote_no_text_content_mobile);
            return;
        }
        Logger.e$default(AppLog.g, "Unhandled reply preview: " + messageEntry2, null, null, 6, null);
    }

    private final void configureReplySystemMessage(int stringResourceId) {
        configureReplyAvatar(null, null);
        configureReplyName("", 0, false);
        configureReplyContentWithResourceId(stringResourceId);
    }

    private final void configureReplySystemMessageRoleSubscriptionPurchase(MessageEntry repliedMessageEntry) {
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.replyText;
        if (simpleDraweeSpanTextView == null) {
            return;
        }
        Context context = simpleDraweeSpanTextView.getContext();
        configureReplyAvatar(null, null);
        configureReplyName("", 0, false);
        MessageUtils messageUtils = MessageUtils.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(((WidgetChatListAdapter) this.adapter).getData().getGuildId());
        String name = guild != null ? guild.getName() : null;
        Map<Long, String> nickOrUsernames = repliedMessageEntry.getNickOrUsernames();
        User author = repliedMessageEntry.getMessage().getAuthor();
        configureReplyText(new SpannableString(MessageUtils.getSystemMessageRoleSubscriptionPurchase$default(messageUtils, context, name, nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null), repliedMessageEntry.getMessage().getRoleSubscriptionData(), null, 8, null).toString()), 0.64f);
    }

    private final void configureReplySystemMessageUserJoin(MessageEntry repliedMessageEntry) {
        ImageView imageView = this.replyIcon;
        if (imageView == null || this.replyAvatar == null || this.replyText == null) {
            return;
        }
        imageView.setVisibility(8);
        this.replyAvatar.setVisibility(0);
        this.replyAvatar.setImageResource(R.drawable.ic_group_join);
        configureReplyName("", 0, false);
        Context context = this.replyText.getContext();
        Map<Long, String> nickOrUsernames = repliedMessageEntry.getNickOrUsernames();
        User author = repliedMessageEntry.getMessage().getAuthor();
        String str = nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null);
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        configureReplyText(new SpannableString(FormatUtils.h(context, MessageUtils.INSTANCE.getSystemMessageUserJoin(context, repliedMessageEntry.getMessage().getId()), new Object[]{str}, null, 4).toString()), 0.64f);
    }

    private final void configureReplyText(Spannable content, float alpha) {
        if (this.replyText == null || this.replyLeadingViewsHolder == null) {
            return;
        }
        content.setSpan(getLeadingEdgeSpan(), 0, content.length(), 33);
        this.replyText.setAlpha(alpha);
        this.replyText.setText(content);
        configureReplyLayoutDirection();
    }

    public static /* synthetic */ void configureReplyText$default(WidgetChatListAdapterItemMessage widgetChatListAdapterItemMessage, Spannable spannable, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        widgetChatListAdapterItemMessage.configureReplyText(spannable, f);
    }

    private final void configureThreadSpine(Message message, boolean isThreadStarterMessage) {
        ImageView imageView = this.threadEmbedSpine;
        if (imageView != null) {
            ViewKt.setVisible(imageView, message.hasThread() && !isThreadStarterMessage);
        }
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), R.attr.colorHeaderPrimary));
    }

    private final LeadingMarginSpan getLeadingEdgeSpan() {
        int measuredWidth;
        View view = this.replyLeadingViewsHolder;
        if (view != null) {
            view.measure(0, 0);
            measuredWidth = this.replyLeadingViewsHolder.getMeasuredWidth();
        } else {
            measuredWidth = 0;
        }
        return new LeadingMarginSpan.Standard(measuredWidth, 0);
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, true, (Integer) null);
    }

    private final MessageRenderContext getMessageRenderContext(Context context, MessageEntry messageEntry, Function1<? super SpoilerNode<?>, Unit> spoilerClickHandler) {
        return new MessageRenderContext(context, ((WidgetChatListAdapter) this.adapter).getData().getUserId(), messageEntry.getAnimateEmojis(), messageEntry.getNickOrUsernames(), ((WidgetChatListAdapter) this.adapter).getData().getChannelNames(), messageEntry.getRoles(), R.attr.colorTextLink, AnonymousClass1.INSTANCE, new AnonymousClass2(), ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_bg_visible), spoilerClickHandler, new AnonymousClass3(), new AnonymousClass4(context));
    }

    private final Function1<SpoilerNode<?>, Unit> getSpoilerClickHandler(Message message) {
        if (((WidgetChatListAdapter) this.adapter).getData().getIsSpoilerClickAllowed()) {
            return new AnonymousClass1(message);
        }
        return null;
    }

    private final void processMessageText(SimpleDraweeSpanTextView textView, MessageEntry messageEntry) throws Resources.NotFoundException {
        String content;
        Integer type;
        Context context = textView.getContext();
        Message message = messageEntry.getMessage();
        boolean zIsWebhook = message.isWebhook();
        UtcDateTime editedTimestamp = message.getEditedTimestamp();
        boolean z2 = (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0;
        if (message.isSourceDeleted()) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            content = context.getResources().getString(R.string.source_message_deleted);
        } else {
            content = message.getContent();
            if (content == null) {
                content = "";
            }
        }
        Intrinsics3.checkNotNullExpressionValue(content, "if (message.isSourceDele…ssage.content ?: \"\"\n    }");
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(((WidgetChatListAdapter) this.adapter).getData().getUserId(), message, messageEntry.getMessageState());
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content, getMessageRenderContext(context, messageEntry, getSpoilerClickHandler(message)), messagePreprocessor, messageEntry.isGuildForumPostFirstMessage() ? DiscordParser.ParserOptions.FORUM_POST_FIRST_MESSAGE : zIsWebhook ? DiscordParser.ParserOptions.ALLOW_MASKED_LINKS : DiscordParser.ParserOptions.DEFAULT, z2);
        textView.setAutoLinkMask((messagePreprocessor.isLinkifyConflicting() || !shouldLinkify(message.getContent())) ? 0 : 6);
        textView.setVisibility(channelMessage.length() > 0 ? 0 : 8);
        textView.setDraweeSpanStringBuilder(channelMessage);
        Integer type2 = messageEntry.getMessage().getType();
        textView.setAlpha(((type2 != null && type2.intValue() == -1) || ((type = messageEntry.getMessage().getType()) != null && type.intValue() == -6)) ? 0.5f : 1.0f);
    }

    private final boolean shouldLinkify(String content) {
        if (content == null) {
            return false;
        }
        if (content.length() < 200) {
            return true;
        }
        int length = content.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (content.charAt(i2) == '.' && (i = i + 1) >= 50) {
                return false;
            }
        }
        return true;
    }

    private final boolean shouldShowInteractionMessage(Message message) {
        return message.isLocalApplicationCommand() || message.isLoading();
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) throws Resources.NotFoundException {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014e  */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onConfigure(int position, ChatListEntry data) throws Resources.NotFoundException {
        TextView textView;
        List<Long> listEmptyList;
        NullSerializable<String> nullSerializableA;
        View view;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        if (((WidgetChatListAdapter) this.adapter).getData().getUserId() == 0) {
            return;
        }
        Message message = messageEntry.getMessage();
        boolean zIsThreadStarterMessage = messageEntry.isThreadStarterMessage();
        configureItemTag(message, messageEntry.isGuildForumPostAuthor());
        View view2 = this.backgroundHighlight;
        if (view2 != null && (view = this.gutterHighlight) != null) {
            configureCellHighlight(message, view2, view);
        }
        TextView textView2 = this.itemName;
        if (textView2 != null) {
            Map<Long, String> nickOrUsernames = messageEntry.getNickOrUsernames();
            User author = message.getAuthor();
            textView2.setText(nickOrUsernames.get(author != null ? Long.valueOf(author.getId()) : null));
            this.itemName.setTextColor(getAuthorTextColor(messageEntry.getAuthor()));
            this.itemName.setOnClickListener(new AnonymousClass1(message));
            ViewExtensions.setOnLongClickListenerConsumeClick(this.itemName, new AnonymousClass2(message));
        }
        TextView textView3 = this.itemTimestamp;
        if (textView3 != null) {
            Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
            UtcDateTime timestamp = message.getTimestamp();
            textView3.setText(TimeUtils.toReadableTimeString$default(contextX, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        }
        configureInteractionMessage(messageEntry);
        if (!shouldShowInteractionMessage(message) || (textView = this.itemLoadingText) == null) {
            processMessageText(this.itemText, messageEntry);
            textView = this.itemText;
        }
        ViewCompat.setAccessibilityDelegate(this.itemView, new ChatListItemMessageAccessibilityDelegate(textView, this.itemName, this.itemTag, this.itemTimestamp));
        View view3 = this.threadStarterMessageHeader;
        if (view3 != null) {
            ViewKt.setVisible(view3, zIsThreadStarterMessage);
        }
        this.itemView.setOnClickListener(new AnonymousClass3(message, zIsThreadStarterMessage));
        View view4 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view4, "itemView");
        ViewExtensions.setOnLongClickListenerConsumeClick(view4, new AnonymousClass4(message, zIsThreadStarterMessage));
        configureReplyPreview(messageEntry);
        ImageView imageView = this.itemAvatar;
        if (imageView != null) {
            imageView.setOnClickListener(new AnonymousClass5(message));
            ViewExtensions.setOnLongClickListenerConsumeClick(this.itemAvatar, new AnonymousClass6(message));
            User author2 = message.getAuthor();
            String strA = (author2 == null || (nullSerializableA = author2.a()) == null) ? null : nullSerializableA.a();
            if (message.getApplicationId() == null) {
                ImageView imageView2 = this.itemAvatar;
                User author3 = message.getAuthor();
                Intrinsics3.checkNotNull(author3);
                IconUtils.setIcon$default(imageView2, new CoreUser(author3), R.dimen.avatar_size_chat, null, null, messageEntry.getAuthor(), 24, null);
            } else {
                if ((!Intrinsics3.areEqual(message.getAuthor() != null ? r4.getBot() : null, Boolean.TRUE)) && strA != null) {
                    IconUtils.setIcon$default(this.itemAvatar, IconUtils.getApplicationIcon$default(message.getApplicationId().longValue(), strA, 0, 4, (Object) null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
                }
            }
        }
        if (this.itemRoleIcon != null) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Channel channel = companion.getChannels().getChannel(messageEntry.getMessage().getChannelId());
            GuildMember.Companion companion2 = GuildMember.INSTANCE;
            GuildMember author4 = messageEntry.getAuthor();
            if (author4 == null || (listEmptyList = author4.getRoles()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            this.itemRoleIcon.setRole(companion2.getHighestRoleIconRole(listEmptyList, companion.getGuilds().getRoles().get(channel != null ? Long.valueOf(channel.getGuildId()) : null)), channel != null ? Long.valueOf(channel.getGuildId()) : null);
        }
        if (this.failedUploadList != null) {
            List<LocalAttachment> localAttachments = message.getLocalAttachments();
            if (message.isFailed() && localAttachments != null && (!localAttachments.isEmpty())) {
                this.failedUploadList.setVisibility(0);
                this.failedUploadList.setUp(localAttachments);
            } else {
                this.failedUploadList.setVisibility(8);
            }
        }
        if (this.itemAlertText != null) {
            if (message.isFailed()) {
                this.itemAlertText.setVisibility(0);
                Integer type = message.getType();
                this.itemAlertText.setText(type != null && type.intValue() == -3 ? R.string.invalid_attachments_failure : R.string.send_message_failure);
            } else {
                this.itemAlertText.setVisibility(8);
            }
        }
        configureThreadSpine(message, zIsThreadStarterMessage);
        configureCommunicationDisabled(messageEntry.getAuthor(), messageEntry.getPermissionsForChannel());
    }
}
