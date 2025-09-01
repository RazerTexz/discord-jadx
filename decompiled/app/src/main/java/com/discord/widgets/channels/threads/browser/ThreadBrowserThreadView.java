package com.discord.widgets.channels.threads.browser;

import a0.a.a.b;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.databinding.ThreadBrowserThreadViewBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome2;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ThreadBrowserThreadView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002*+B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0019\u001a\u00020\u00182\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00182\n\u0010\u0017\u001a\u00060\u0015j\u0002`\u0016H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006,"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView;", "Landroid/widget/FrameLayout;", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ActiveThread;", "threadData", "", "configureActiveThreadUI", "(Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ActiveThread;)V", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ArchivedThread;", "configureArchivedThreadUI", "(Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ArchivedThread;)V", "Lcom/discord/models/member/GuildMember;", "member", "", "Landroid/text/style/CharacterStyle;", "getMemberCharacterStyles", "(Lcom/discord/models/member/GuildMember;)Ljava/util/List;", "Lcom/discord/models/user/User;", "user", "guildMember", "configureAvatar", "(Lcom/discord/models/user/User;Lcom/discord/models/member/GuildMember;)V", "", "Lcom/discord/primitives/Timestamp;", "timestamp", "", "formatActivityTimestamp", "(J)Ljava/lang/CharSequence;", "formatDateTimestamp", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "setThreadData", "(Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;)V", "Lcom/discord/databinding/ThreadBrowserThreadViewBinding;", "binding", "Lcom/discord/databinding/ThreadBrowserThreadViewBinding;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ThreadData", "TimestampMode", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ThreadBrowserThreadView extends FrameLayout {
    private final ThreadBrowserThreadViewBinding binding;

    /* compiled from: ThreadBrowserThreadView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B3\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR,\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0002\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "", "Lcom/discord/models/user/User;", "owner", "Lcom/discord/models/user/User;", "getOwner", "()Lcom/discord/models/user/User;", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/api/channel/Channel;", "getChannel", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "Ljava/util/Map;", "getGuildMembers", "()Ljava/util/Map;", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/User;Ljava/util/Map;)V", "ActiveThread", "ArchivedThread", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ActiveThread;", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ArchivedThread;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ThreadData {
        private final Channel channel;
        private final Map<Long, GuildMember> guildMembers;
        private final User owner;

        /* compiled from: ThreadBrowserThreadView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\b\u0012\n\u0010\u001f\u001a\u00060\u000bj\u0002`\f\u0012\u0016\u0010 \u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0016\u0010!\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000f\u0012\u0016\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u000f\u0012\u0006\u0010#\u001a\u00020\u0019¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\r\u001a\u00060\u000bj\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0011\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0012J \u0010\u0018\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u000fHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0012J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0098\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\f\b\u0002\u0010\u001f\u001a\u00060\u000bj\u0002`\f2\u0018\b\u0002\u0010 \u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00100\u000f2\u0018\b\u0002\u0010!\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000f2\u0018\b\u0002\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u000f2\b\b\u0002\u0010#\u001a\u00020\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020(HÖ\u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\u00192\b\u0010,\u001a\u0004\u0018\u00010+HÖ\u0003¢\u0006\u0004\b-\u0010.R\u001b\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u0010\nR\u001c\u0010\u001c\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b2\u0010\u0004R)\u0010!\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0013\u0012\u0004\u0012\u00020\u00140\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u00103\u001a\u0004\b4\u0010\u0012R\u001d\u0010\u001f\u001a\u00060\u000bj\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b6\u0010\u000eR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u00107\u001a\u0004\b8\u0010\u0007R,\u0010 \u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00100\u000f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b9\u0010\u0012R)\u0010\"\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\u0016\u0012\u0004\u0012\u00020\u00170\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00103\u001a\u0004\b:\u0010\u0012R\u0019\u0010#\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010;\u001a\u0004\b#\u0010\u001b¨\u0006>"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ActiveThread;", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/user/User;", "component2", "()Lcom/discord/models/user/User;", "Lcom/discord/models/message/Message;", "component3", "()Lcom/discord/models/message/Message;", "", "Lcom/discord/primitives/UserId;", "component4", "()J", "", "Lcom/discord/models/member/GuildMember;", "component5", "()Ljava/util/Map;", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "component6", "Lcom/discord/primitives/ChannelId;", "", "component7", "", "component8", "()Z", "channel", "owner", "message", "myUserId", "guildMembers", "guildRoles", "channelNames", "isMessageBlocked", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/User;Lcom/discord/models/message/Message;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ActiveThread;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMessage", "Lcom/discord/api/channel/Channel;", "getChannel", "Ljava/util/Map;", "getGuildRoles", "J", "getMyUserId", "Lcom/discord/models/user/User;", "getOwner", "getGuildMembers", "getChannelNames", "Z", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/user/User;Lcom/discord/models/message/Message;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ActiveThread extends ThreadData {
            private final Channel channel;
            private final Map<Long, String> channelNames;
            private final Map<Long, GuildMember> guildMembers;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isMessageBlocked;
            private final Message message;
            private final long myUserId;
            private final User owner;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActiveThread(Channel channel, User user, Message message, long j, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, String> map3, boolean z2) {
                super(channel, user, map, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "guildMembers");
                Intrinsics3.checkNotNullParameter(map2, "guildRoles");
                Intrinsics3.checkNotNullParameter(map3, "channelNames");
                this.channel = channel;
                this.owner = user;
                this.message = message;
                this.myUserId = j;
                this.guildMembers = map;
                this.guildRoles = map2;
                this.channelNames = map3;
                this.isMessageBlocked = z2;
            }

            public static /* synthetic */ ActiveThread copy$default(ActiveThread activeThread, Channel channel, User user, Message message, long j, Map map, Map map2, Map map3, boolean z2, int i, Object obj) {
                return activeThread.copy((i & 1) != 0 ? activeThread.getChannel() : channel, (i & 2) != 0 ? activeThread.getOwner() : user, (i & 4) != 0 ? activeThread.message : message, (i & 8) != 0 ? activeThread.myUserId : j, (i & 16) != 0 ? activeThread.getGuildMembers() : map, (i & 32) != 0 ? activeThread.guildRoles : map2, (i & 64) != 0 ? activeThread.channelNames : map3, (i & 128) != 0 ? activeThread.isMessageBlocked : z2);
            }

            public final Channel component1() {
                return getChannel();
            }

            public final User component2() {
                return getOwner();
            }

            /* renamed from: component3, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            /* renamed from: component4, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            public final Map<Long, GuildMember> component5() {
                return getGuildMembers();
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Map<Long, String> component7() {
                return this.channelNames;
            }

            /* renamed from: component8, reason: from getter */
            public final boolean getIsMessageBlocked() {
                return this.isMessageBlocked;
            }

            public final ActiveThread copy(Channel channel, User owner, Message message, long myUserId, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, boolean isMessageBlocked) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                return new ActiveThread(channel, owner, message, myUserId, guildMembers, guildRoles, channelNames, isMessageBlocked);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ActiveThread)) {
                    return false;
                }
                ActiveThread activeThread = (ActiveThread) other;
                return Intrinsics3.areEqual(getChannel(), activeThread.getChannel()) && Intrinsics3.areEqual(getOwner(), activeThread.getOwner()) && Intrinsics3.areEqual(this.message, activeThread.message) && this.myUserId == activeThread.myUserId && Intrinsics3.areEqual(getGuildMembers(), activeThread.getGuildMembers()) && Intrinsics3.areEqual(this.guildRoles, activeThread.guildRoles) && Intrinsics3.areEqual(this.channelNames, activeThread.channelNames) && this.isMessageBlocked == activeThread.isMessageBlocked;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, String> getChannelNames() {
                return this.channelNames;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final Message getMessage() {
                return this.message;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public User getOwner() {
                return this.owner;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Channel channel = getChannel();
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                User owner = getOwner();
                int iHashCode2 = (iHashCode + (owner != null ? owner.hashCode() : 0)) * 31;
                Message message = this.message;
                int iA = (b.a(this.myUserId) + ((iHashCode2 + (message != null ? message.hashCode() : 0)) * 31)) * 31;
                Map<Long, GuildMember> guildMembers = getGuildMembers();
                int iHashCode3 = (iA + (guildMembers != null ? guildMembers.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, String> map2 = this.channelNames;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                boolean z2 = this.isMessageBlocked;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode5 + i;
            }

            public final boolean isMessageBlocked() {
                return this.isMessageBlocked;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ActiveThread(channel=");
                sbU.append(getChannel());
                sbU.append(", owner=");
                sbU.append(getOwner());
                sbU.append(", message=");
                sbU.append(this.message);
                sbU.append(", myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", guildMembers=");
                sbU.append(getGuildMembers());
                sbU.append(", guildRoles=");
                sbU.append(this.guildRoles);
                sbU.append(", channelNames=");
                sbU.append(this.channelNames);
                sbU.append(", isMessageBlocked=");
                return outline.O(sbU, this.isMessageBlocked, ")");
            }
        }

        /* compiled from: ThreadBrowserThreadView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0016\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0018\b\u0002\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\rR,\u0010\u0012\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b'\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ArchivedThread;", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData;", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "component2", "()Ljava/util/Map;", "Lcom/discord/models/user/User;", "component3", "()Lcom/discord/models/user/User;", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$TimestampMode;", "component4", "()Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$TimestampMode;", "channel", "guildMembers", "owner", "timestampMode", "copy", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/models/user/User;Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$TimestampMode;)Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$ThreadData$ArchivedThread;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getOwner", "Ljava/util/Map;", "getGuildMembers", "Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$TimestampMode;", "getTimestampMode", "Lcom/discord/api/channel/Channel;", "getChannel", "<init>", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Lcom/discord/models/user/User;Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$TimestampMode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ArchivedThread extends ThreadData {
            private final Channel channel;
            private final Map<Long, GuildMember> guildMembers;
            private final User owner;
            private final TimestampMode timestampMode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ArchivedThread(Channel channel, Map<Long, GuildMember> map, User user, TimestampMode timestampMode) {
                super(channel, user, map, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "guildMembers");
                Intrinsics3.checkNotNullParameter(timestampMode, "timestampMode");
                this.channel = channel;
                this.guildMembers = map;
                this.owner = user;
                this.timestampMode = timestampMode;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ArchivedThread copy$default(ArchivedThread archivedThread, Channel channel, Map map, User user, TimestampMode timestampMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = archivedThread.getChannel();
                }
                if ((i & 2) != 0) {
                    map = archivedThread.getGuildMembers();
                }
                if ((i & 4) != 0) {
                    user = archivedThread.getOwner();
                }
                if ((i & 8) != 0) {
                    timestampMode = archivedThread.timestampMode;
                }
                return archivedThread.copy(channel, map, user, timestampMode);
            }

            public final Channel component1() {
                return getChannel();
            }

            public final Map<Long, GuildMember> component2() {
                return getGuildMembers();
            }

            public final User component3() {
                return getOwner();
            }

            /* renamed from: component4, reason: from getter */
            public final TimestampMode getTimestampMode() {
                return this.timestampMode;
            }

            public final ArchivedThread copy(Channel channel, Map<Long, GuildMember> guildMembers, User owner, TimestampMode timestampMode) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(timestampMode, "timestampMode");
                return new ArchivedThread(channel, guildMembers, owner, timestampMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ArchivedThread)) {
                    return false;
                }
                ArchivedThread archivedThread = (ArchivedThread) other;
                return Intrinsics3.areEqual(getChannel(), archivedThread.getChannel()) && Intrinsics3.areEqual(getGuildMembers(), archivedThread.getGuildMembers()) && Intrinsics3.areEqual(getOwner(), archivedThread.getOwner()) && Intrinsics3.areEqual(this.timestampMode, archivedThread.timestampMode);
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Channel getChannel() {
                return this.channel;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public User getOwner() {
                return this.owner;
            }

            public final TimestampMode getTimestampMode() {
                return this.timestampMode;
            }

            public int hashCode() {
                Channel channel = getChannel();
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Map<Long, GuildMember> guildMembers = getGuildMembers();
                int iHashCode2 = (iHashCode + (guildMembers != null ? guildMembers.hashCode() : 0)) * 31;
                User owner = getOwner();
                int iHashCode3 = (iHashCode2 + (owner != null ? owner.hashCode() : 0)) * 31;
                TimestampMode timestampMode = this.timestampMode;
                return iHashCode3 + (timestampMode != null ? timestampMode.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ArchivedThread(channel=");
                sbU.append(getChannel());
                sbU.append(", guildMembers=");
                sbU.append(getGuildMembers());
                sbU.append(", owner=");
                sbU.append(getOwner());
                sbU.append(", timestampMode=");
                sbU.append(this.timestampMode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ThreadData(Channel channel, User user, Map<Long, GuildMember> map) {
            this.channel = channel;
            this.owner = user;
            this.guildMembers = map;
        }

        public Channel getChannel() {
            return this.channel;
        }

        public Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public User getOwner() {
            return this.owner;
        }

        public /* synthetic */ ThreadData(Channel channel, User user, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, user, map);
        }
    }

    /* compiled from: ThreadBrowserThreadView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/channels/threads/browser/ThreadBrowserThreadView$TimestampMode;", "", "<init>", "(Ljava/lang/String;I)V", "ArchivedAt", "CreatedAt", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum TimestampMode {
        ArchivedAt,
        CreatedAt
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            TimestampMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            TimestampMode timestampMode = TimestampMode.ArchivedAt;
            iArr[timestampMode.ordinal()] = 1;
            TimestampMode timestampMode2 = TimestampMode.CreatedAt;
            iArr[timestampMode2.ordinal()] = 2;
            TimestampMode.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[timestampMode.ordinal()] = 1;
            iArr2[timestampMode2.ordinal()] = 2;
        }
    }

    /* compiled from: ThreadBrowserThreadView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$setThreadData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ GuildMember $creatorMember;
        public final /* synthetic */ String $creatorName;

        /* compiled from: ThreadBrowserThreadView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/Hook;", "", "invoke", "(Lcom/discord/i18n/Hook;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$setThreadData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02511 extends Lambda implements Function1<Hook, Unit> {
            public C02511() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                hook.replacementText = anonymousClass1.$creatorName;
                hook.styles.addAll(ThreadBrowserThreadView.access$getMemberCharacterStyles(ThreadBrowserThreadView.this, anonymousClass1.$creatorMember));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, GuildMember guildMember) {
            super(1);
            this.$creatorName = str;
            this.$creatorMember = guildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("authorHook", new C02511());
        }
    }

    public ThreadBrowserThreadView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ThreadBrowserThreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ThreadBrowserThreadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ List access$getMemberCharacterStyles(ThreadBrowserThreadView threadBrowserThreadView, GuildMember guildMember) {
        return threadBrowserThreadView.getMemberCharacterStyles(guildMember);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureActiveThreadUI(ThreadData.ActiveThread threadData) {
        String str;
        DraweeSpanStringBuilder draweeSpanStringBuilderRender;
        Message message = threadData.getMessage();
        DraweeSpanStringBuilder draweeSpanStringBuilder = null;
        String content = message != null ? message.getContent() : null;
        if (message == null || content == null) {
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadTimestampSeparator");
            textView.setVisibility(8);
            TextView textView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.threadTimestamp");
            textView2.setVisibility(8);
            if (threadData.getOwner() == null) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadMessage");
                simpleDraweeSpanTextView.setText(getContext().getString(R.string.thread_browser_no_recent_messages));
                configureAvatar$default(this, null, null, 2, null);
                return;
            }
            return;
        }
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        MessageRenderContext messageRenderContext = new MessageRenderContext(context, threadData.getMyUserId(), true, MessageUtils.getNickOrUsernames$default(message, threadData.getChannel(), threadData.getGuildMembers(), null, 8, null), threadData.getChannelNames(), threadData.getGuildRoles(), 0, null, null, ColorCompat.getThemedColor(getContext(), R.attr.theme_chat_spoiler_inapp_bg), 0, null, null, null, 15808, null);
        com.discord.api.user.User author = threadData.getMessage().getAuthor();
        Intrinsics3.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        String string = threadData.isMessageBlocked() ? getContext().getString(R.string.reply_quote_message_blocked) : message.hasStickers() ? getContext().getString(R.string.reply_quote_sticker_mobile) : (message.hasAttachments() || message.hasEmbeds()) ? getContext().getString(R.string.reply_quote_no_text_content_mobile) : null;
        if (string == null) {
            if (!StringsJVM.isBlank(content)) {
                str = "binding.threadTimestamp";
                draweeSpanStringBuilderRender = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.INSTANCE.getInitialState(), null, 4, null), messageRenderContext);
            }
            if (draweeSpanStringBuilderRender != null) {
                GuildMember guildMember = threadData.getGuildMembers().get(Long.valueOf(coreUser.getId()));
                String nickOrUsername$default = GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, coreUser, guildMember, threadData.getChannel(), null, 8, null);
                draweeSpanStringBuilderRender.insert(0, (CharSequence) new SpannableStringBuilder(outline.w(nickOrUsername$default, ": ")));
                Iterator<T> it = getMemberCharacterStyles(guildMember).iterator();
                while (it.hasNext()) {
                    draweeSpanStringBuilderRender.setSpan((CharacterStyle) it.next(), 0, nickOrUsername$default.length(), 33);
                }
                this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
            }
            TextView textView3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.threadTimestampSeparator");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView4, str);
            textView4.setVisibility(0);
            configureAvatar(coreUser, threadData.getGuildMembers().get(Long.valueOf(coreUser.getId())));
            TextView textView5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView5, str);
            textView5.setText(formatActivityTimestamp((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
        }
        draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        draweeSpanStringBuilder.append((CharSequence) (string + (char) 160));
        draweeSpanStringBuilder.setSpan(new StyleSpan(2), 0, string.length(), 33);
        str = "binding.threadTimestamp";
        draweeSpanStringBuilderRender = draweeSpanStringBuilder;
        if (draweeSpanStringBuilderRender != null) {
        }
        TextView textView32 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView32, "binding.threadTimestampSeparator");
        textView32.setVisibility(0);
        TextView textView42 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView42, str);
        textView42.setVisibility(0);
        configureAvatar(coreUser, threadData.getGuildMembers().get(Long.valueOf(coreUser.getId())));
        TextView textView52 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView52, str);
        textView52.setText(formatActivityTimestamp((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
    }

    private final void configureArchivedThreadUI(ThreadData.ArchivedThread threadData) {
        long uTCDate;
        int i;
        ThreadMetadata threadMetadata = threadData.getChannel().getThreadMetadata();
        if (threadMetadata != null) {
            int iOrdinal = threadData.getTimestampMode().ordinal();
            if (iOrdinal == 0) {
                uTCDate = TimeUtils.parseUTCDate(threadMetadata.getArchiveTimestamp());
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                uTCDate = (threadData.getChannel().getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
            }
            int iOrdinal2 = threadData.getTimestampMode().ordinal();
            if (iOrdinal2 == 0) {
                i = R.string.thread_browser_archive_time;
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.thread_browser_creation_time;
            }
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadTimestamp");
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView.setText(FormatUtils.h(context, i, new Object[]{formatDateTimestamp(uTCDate)}, null, 4));
            User owner = threadData.getOwner();
            Map<Long, GuildMember> guildMembers = threadData.getGuildMembers();
            User owner2 = threadData.getOwner();
            configureAvatar(owner, guildMembers.get(owner2 != null ? Long.valueOf(owner2.getId()) : null));
        }
    }

    private final void configureAvatar(User user, GuildMember guildMember) {
        if (user == null) {
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.threadIcon");
            imageView.setVisibility(0);
            SimpleDraweeView simpleDraweeView = this.binding.f2161b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.threadAvatar");
            simpleDraweeView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.threadIcon");
        imageView2.setVisibility(8);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2161b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.threadAvatar");
        simpleDraweeView2.setVisibility(0);
        SimpleDraweeView simpleDraweeView3 = this.binding.f2161b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.threadAvatar");
        IconUtils.setIcon$default(simpleDraweeView3, user, R.dimen.avatar_size_small, null, null, guildMember, 24, null);
    }

    public static /* synthetic */ void configureAvatar$default(ThreadBrowserThreadView threadBrowserThreadView, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 2) != 0) {
            guildMember = null;
        }
        threadBrowserThreadView.configureAvatar(user, guildMember);
    }

    private final CharSequence formatActivityTimestamp(long timestamp) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - timestamp;
        if (jCurrentTimeMillis < 60000) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return FormatUtils.h(context, R.string.thread_browser_timestamp_minutes, new Object[]{1}, null, 4);
        }
        if (jCurrentTimeMillis < 3600000) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            return FormatUtils.h(context2, R.string.thread_browser_timestamp_minutes, new Object[]{Long.valueOf(jCurrentTimeMillis / 60000)}, null, 4);
        }
        if (jCurrentTimeMillis < 86400000) {
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            return FormatUtils.h(context3, R.string.thread_browser_timestamp_hours, new Object[]{Long.valueOf(jCurrentTimeMillis / 3600000)}, null, 4);
        }
        if (jCurrentTimeMillis < WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD) {
            Context context4 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context4, "context");
            return FormatUtils.h(context4, R.string.thread_browser_timestamp_days, new Object[]{Long.valueOf(jCurrentTimeMillis / 86400000)}, null, 4);
        }
        String string = getContext().getString(R.string.thread_browser_timestamp_more_than_month);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…imestamp_more_than_month)");
        return string;
    }

    private final CharSequence formatDateTimestamp(long timestamp) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - timestamp;
        if (jCurrentTimeMillis < 60000) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return FormatUtils.h(context, R.string.thread_browser_timestamp_minutes, new Object[]{1}, null, 4);
        }
        if (jCurrentTimeMillis < 3600000) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            return FormatUtils.h(context2, R.string.thread_browser_timestamp_minutes, new Object[]{Long.valueOf(jCurrentTimeMillis / 60000)}, null, 4);
        }
        if (jCurrentTimeMillis < 86400000) {
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            return FormatUtils.h(context3, R.string.thread_browser_timestamp_hours, new Object[]{Long.valueOf(jCurrentTimeMillis / 3600000)}, null, 4);
        }
        String dateTime = DateUtils.formatDateTime(getContext(), timestamp, 131076);
        Intrinsics3.checkNotNullExpressionValue(dateTime, "DateUtils.formatDateTime…teUtils.FORMAT_SHOW_YEAR)");
        return dateTime;
    }

    private final List<CharacterStyle> getMemberCharacterStyles(GuildMember member) {
        ArrayList arrayList = new ArrayList();
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
        if (themedFont != null) {
            arrayList.add(new TypefaceSpanCompat(themedFont));
        }
        if (member != null) {
            arrayList.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary))));
        }
        return arrayList;
    }

    public final void setThreadData(ThreadData threadData) {
        Intrinsics3.checkNotNullParameter(threadData, "threadData");
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadName");
        Channel channel = threadData.getChannel();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setText(ChannelUtils.d(channel, context, false));
        User owner = threadData.getOwner();
        if (owner == null) {
            owner = new CoreUser(threadData.getChannel().getOwnerId(), null, null, null, false, false, 0, null, 0, 0, null, null, 4094, null);
        }
        GuildMember guildMember = (GuildMember) outline.f(owner, threadData.getGuildMembers());
        String nickOrUsername$default = GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, owner, guildMember, threadData.getChannel(), null, 8, null);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadMessage");
        FormatUtils.m(simpleDraweeSpanTextView, R.string.thread_browser_started_by, new Object[0], new AnonymousClass1(nickOrUsername$default, guildMember));
        if (threadData instanceof ThreadData.ActiveThread) {
            configureActiveThreadUI((ThreadData.ActiveThread) threadData);
        } else if (threadData instanceof ThreadData.ArchivedThread) {
            configureArchivedThreadUI((ThreadData.ArchivedThread) threadData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.thread_browser_thread_view, this);
        int i2 = R.id.thread_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.thread_avatar);
        if (simpleDraweeView != null) {
            i2 = R.id.thread_icon;
            ImageView imageView = (ImageView) findViewById(R.id.thread_icon);
            if (imageView != null) {
                i2 = R.id.thread_image;
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.thread_image);
                if (frameLayout != null) {
                    i2 = R.id.thread_message;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.thread_message);
                    if (simpleDraweeSpanTextView != null) {
                        i2 = R.id.thread_name;
                        TextView textView = (TextView) findViewById(R.id.thread_name);
                        if (textView != null) {
                            i2 = R.id.thread_timestamp;
                            TextView textView2 = (TextView) findViewById(R.id.thread_timestamp);
                            if (textView2 != null) {
                                i2 = R.id.thread_timestamp_separator;
                                TextView textView3 = (TextView) findViewById(R.id.thread_timestamp_separator);
                                if (textView3 != null) {
                                    ThreadBrowserThreadViewBinding threadBrowserThreadViewBinding = new ThreadBrowserThreadViewBinding(this, simpleDraweeView, imageView, frameLayout, simpleDraweeSpanTextView, textView, textView2, textView3);
                                    Intrinsics3.checkNotNullExpressionValue(threadBrowserThreadViewBinding, "ThreadBrowserThreadViewB…ater.from(context), this)");
                                    this.binding = threadBrowserThreadViewBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
