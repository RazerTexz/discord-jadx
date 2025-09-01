package com.discord.widgets.chat.list.utils;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;

/* compiled from: EmbeddedMessageParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/chat/list/utils/EmbeddedMessageParser;", "", "Lcom/discord/widgets/chat/list/utils/EmbeddedMessageParser$ParserData;", "parserData", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "getMessageRenderContext", "(Lcom/discord/widgets/chat/list/utils/EmbeddedMessageParser$ParserData;)Lcom/discord/utilities/textprocessing/MessageRenderContext;", "", "userId", "Lcom/discord/models/message/Message;", "message", "Lcom/discord/stores/StoreMessageState$State;", "messageState", "", "maxNodes", "Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "getMessagePreprocessor", "(JLcom/discord/models/message/Message;Lcom/discord/stores/StoreMessageState$State;Ljava/lang/Integer;)Lcom/discord/utilities/textprocessing/MessagePreprocessor;", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "parse", "(Lcom/discord/widgets/chat/list/utils/EmbeddedMessageParser$ParserData;)Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "<init>", "()V", "ParserData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class EmbeddedMessageParser {
    public static final EmbeddedMessageParser INSTANCE = new EmbeddedMessageParser();

    /* compiled from: EmbeddedMessageParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u0012\u0016\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\u0006\u0010\u001f\u001a\u00020\r\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0010\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\"\u001a\u00020\u0016\u0012\u0006\u0010#\u001a\u00020\u0019¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ \u0010\f\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\tJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0082\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00022\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u00052\b\b\u0002\u0010\u001f\u001a\u00020\r2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\"\u001a\u00020\u00162\b\b\u0002\u0010#\u001a\u00020\u0019HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010!\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b.\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010/\u001a\u0004\b0\u0010\u0004R)\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u000b0\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\tR'\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00101\u001a\u0004\b3\u0010\tR\u0019\u0010#\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b#\u00104\u001a\u0004\b5\u0010\u001bR\u001b\u0010 \u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b7\u0010\u0012R\u0019\u0010\u001f\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00108\u001a\u0004\b9\u0010\u000fR\u0019\u0010\"\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010:\u001a\u0004\b;\u0010\u0018¨\u0006>"}, d2 = {"Lcom/discord/widgets/chat/list/utils/EmbeddedMessageParser$ParserData;", "", "Landroid/content/Context;", "component1", "()Landroid/content/Context;", "", "", "Lcom/discord/api/role/GuildRole;", "component2", "()Ljava/util/Map;", "Lcom/discord/primitives/UserId;", "", "component3", "", "component4", "()Z", "Lcom/discord/stores/StoreMessageState$State;", "component5", "()Lcom/discord/stores/StoreMessageState$State;", "", "component6", "()Ljava/lang/Integer;", "Lcom/discord/models/message/Message;", "component7", "()Lcom/discord/models/message/Message;", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "component8", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "context", "roleMentions", "nickOrUsernames", "animateEmojis", "messageState", "maxNodes", "message", "adapter", "copy", "(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;ZLcom/discord/stores/StoreMessageState$State;Ljava/lang/Integer;Lcom/discord/models/message/Message;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)Lcom/discord/widgets/chat/list/utils/EmbeddedMessageParser$ParserData;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getMaxNodes", "Landroid/content/Context;", "getContext", "Ljava/util/Map;", "getNickOrUsernames", "getRoleMentions", "Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;", "getAdapter", "Lcom/discord/stores/StoreMessageState$State;", "getMessageState", "Z", "getAnimateEmojis", "Lcom/discord/models/message/Message;", "getMessage", "<init>", "(Landroid/content/Context;Ljava/util/Map;Ljava/util/Map;ZLcom/discord/stores/StoreMessageState$State;Ljava/lang/Integer;Lcom/discord/models/message/Message;Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ParserData {
        private final WidgetChatListAdapter adapter;
        private final boolean animateEmojis;
        private final Context context;
        private final Integer maxNodes;
        private final Message message;
        private final StoreMessageState.State messageState;
        private final Map<Long, String> nickOrUsernames;
        private final Map<Long, GuildRole> roleMentions;

        public ParserData(Context context, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, StoreMessageState.State state, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
            this.context = context;
            this.roleMentions = map;
            this.nickOrUsernames = map2;
            this.animateEmojis = z2;
            this.messageState = state;
            this.maxNodes = num;
            this.message = message;
            this.adapter = widgetChatListAdapter;
        }

        public static /* synthetic */ ParserData copy$default(ParserData parserData, Context context, Map map, Map map2, boolean z2, StoreMessageState.State state, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter, int i, Object obj) {
            return parserData.copy((i & 1) != 0 ? parserData.context : context, (i & 2) != 0 ? parserData.roleMentions : map, (i & 4) != 0 ? parserData.nickOrUsernames : map2, (i & 8) != 0 ? parserData.animateEmojis : z2, (i & 16) != 0 ? parserData.messageState : state, (i & 32) != 0 ? parserData.maxNodes : num, (i & 64) != 0 ? parserData.message : message, (i & 128) != 0 ? parserData.adapter : widgetChatListAdapter);
        }

        /* renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        public final Map<Long, GuildRole> component2() {
            return this.roleMentions;
        }

        public final Map<Long, String> component3() {
            return this.nickOrUsernames;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        /* renamed from: component5, reason: from getter */
        public final StoreMessageState.State getMessageState() {
            return this.messageState;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getMaxNodes() {
            return this.maxNodes;
        }

        /* renamed from: component7, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component8, reason: from getter */
        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final ParserData copy(Context context, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, StoreMessageState.State messageState, Integer maxNodes, Message message, WidgetChatListAdapter adapter) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(adapter, "adapter");
            return new ParserData(context, roleMentions, nickOrUsernames, animateEmojis, messageState, maxNodes, message, adapter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParserData)) {
                return false;
            }
            ParserData parserData = (ParserData) other;
            return Intrinsics3.areEqual(this.context, parserData.context) && Intrinsics3.areEqual(this.roleMentions, parserData.roleMentions) && Intrinsics3.areEqual(this.nickOrUsernames, parserData.nickOrUsernames) && this.animateEmojis == parserData.animateEmojis && Intrinsics3.areEqual(this.messageState, parserData.messageState) && Intrinsics3.areEqual(this.maxNodes, parserData.maxNodes) && Intrinsics3.areEqual(this.message, parserData.message) && Intrinsics3.areEqual(this.adapter, parserData.adapter);
        }

        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Context getContext() {
            return this.context;
        }

        public final Integer getMaxNodes() {
            return this.maxNodes;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final StoreMessageState.State getMessageState() {
            return this.messageState;
        }

        public final Map<Long, String> getNickOrUsernames() {
            return this.nickOrUsernames;
        }

        public final Map<Long, GuildRole> getRoleMentions() {
            return this.roleMentions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Context context = this.context;
            int iHashCode = (context != null ? context.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.roleMentions;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.nickOrUsernames;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            StoreMessageState.State state = this.messageState;
            int iHashCode4 = (i2 + (state != null ? state.hashCode() : 0)) * 31;
            Integer num = this.maxNodes;
            int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            Message message = this.message;
            int iHashCode6 = (iHashCode5 + (message != null ? message.hashCode() : 0)) * 31;
            WidgetChatListAdapter widgetChatListAdapter = this.adapter;
            return iHashCode6 + (widgetChatListAdapter != null ? widgetChatListAdapter.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ParserData(context=");
            sbU.append(this.context);
            sbU.append(", roleMentions=");
            sbU.append(this.roleMentions);
            sbU.append(", nickOrUsernames=");
            sbU.append(this.nickOrUsernames);
            sbU.append(", animateEmojis=");
            sbU.append(this.animateEmojis);
            sbU.append(", messageState=");
            sbU.append(this.messageState);
            sbU.append(", maxNodes=");
            sbU.append(this.maxNodes);
            sbU.append(", message=");
            sbU.append(this.message);
            sbU.append(", adapter=");
            sbU.append(this.adapter);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Landroid/content/Context;", "clickContext", "", "url", "mask", "", "invoke", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$1, reason: invalid class name */
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

    /* compiled from: EmbeddedMessageParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "url", "", "invoke", "(Ljava/lang/String;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "url");
            this.$parserData.getAdapter().getEventHandler().onUrlLongClicked(str);
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "userId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = this.$parserData.getAdapter().getData();
            this.$parserData.getAdapter().getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* compiled from: EmbeddedMessageParser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "channelId", "", "invoke", "(J)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$parserData.getContext(), j);
        }
    }

    private EmbeddedMessageParser() {
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState, Integer maxNodes) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, false, maxNodes);
    }

    private final MessageRenderContext getMessageRenderContext(ParserData parserData) {
        return new MessageRenderContext(parserData.getContext(), parserData.getAdapter().getData().getUserId(), parserData.getAnimateEmojis(), parserData.getNickOrUsernames(), parserData.getAdapter().getData().getChannelNames(), parserData.getRoleMentions(), R.attr.colorTextLink, AnonymousClass1.INSTANCE, new AnonymousClass2(parserData), ColorCompat.getThemedColor(parserData.getContext(), R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(parserData.getContext(), R.attr.theme_chat_spoiler_bg_visible), null, new AnonymousClass3(parserData), new AnonymousClass4(parserData));
    }

    public final DraweeSpanStringBuilder parse(ParserData parserData) {
        Intrinsics3.checkNotNullParameter(parserData, "parserData");
        MessageRenderContext messageRenderContext = getMessageRenderContext(parserData);
        User author = parserData.getMessage().getAuthor();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(author != null ? author.getId() : 0L, parserData.getMessage(), parserData.getMessageState(), parserData.getMaxNodes());
        String content = parserData.getMessage().getContent();
        if (content == null) {
            content = "";
        }
        Context context = parserData.getContext();
        String property = System.getProperty("line.separator");
        Objects.requireNonNull(property);
        Intrinsics3.checkNotNullExpressionValue(property, "Objects.requireNonNull(S…operty(\"line.separator\"))");
        return DiscordParser.parseChannelMessage(context, new Regex(property).replace(content, " "), messageRenderContext, messagePreprocessor, DiscordParser.ParserOptions.REPLY, false);
    }
}
