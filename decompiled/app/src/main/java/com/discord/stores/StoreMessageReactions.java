package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.outline;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.api.message.reaction.MessageReactionUpdate;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreMessageReactions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001=B!\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u00103\u001a\u000202\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\b;\u0010<J=\u0010\r\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0003¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000f\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0011\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0003¢\u0006\u0004\b\u0011\u0010\u0010J'\u0010\u0015\u001a\u00020\u00142\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\n\u0010\b\u001a\u00060\u0012j\u0002`\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00192\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001c\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u0010J9\u0010\u001f\u001a\u00020\f2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\u001e\u001a\u00060\u0002j\u0002`\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\fH\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b'\u0010&J\u0017\u0010(\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b(\u0010&J\u0017\u0010)\u001a\u00020\f2\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b)\u0010&J\u000f\u0010*\u001a\u00020\fH\u0017¢\u0006\u0004\b*\u0010\"R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R:\u00100\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140.0.j\u0002`/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R:\u00107\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0005\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\u0004\u0012\u00020\u00140505j\u0002`68\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/discord/stores/StoreMessageReactions;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "emoji", "", "Lcom/discord/models/user/User;", "reactionUsers", "", "handleReactionUsers", "(JJLcom/discord/api/message/reaction/MessageReactionEmoji;Ljava/util/List;)V", "handleLoadReactionUsersFailure", "(JJLcom/discord/api/message/reaction/MessageReactionEmoji;)V", "fetchReactions", "", "Lcom/discord/stores/EmojiKey;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "ensureReactionResults", "(JLjava/lang/String;)Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "getReactionEmojiRequestParam", "(Lcom/discord/api/message/reaction/MessageReactionEmoji;)Ljava/lang/String;", "Lrx/Observable;", "observeMessageReactions", "(JJLcom/discord/api/message/reaction/MessageReactionEmoji;)Lrx/Observable;", "forceRetryFetchReactions", "Lcom/discord/primitives/UserId;", "userId", "deleteEmoji", "(JJLcom/discord/api/message/reaction/MessageReactionEmoji;J)V", "handleConnectionOpen", "()V", "Lcom/discord/api/message/reaction/MessageReactionUpdate;", "update", "handleReactionAdd", "(Lcom/discord/api/message/reaction/MessageReactionUpdate;)V", "handleReactionRemove", "handleReactionRemoveEmoji", "handleReactionRemoveAll", "snapshotData", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "Lcom/discord/stores/MutableReactionsMap;", "reactions", "Ljava/util/Map;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "", "Lcom/discord/stores/ReactionsMap;", "reactionsSnapshot", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/StoreUser;Lcom/discord/stores/updates/ObservationDeck;)V", "EmojiResults", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMessageReactions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, Map<String, EmojiResults>> reactions;
    private Map<Long, ? extends Map<String, ? extends EmojiResults>> reactionsSnapshot;
    private final StoreUser userStore;

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "", "<init>", "()V", "Failure", "Loading", "Users", "Lcom/discord/stores/StoreMessageReactions$EmojiResults$Users;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults$Failure;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults$Loading;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class EmojiResults {

        /* compiled from: StoreMessageReactions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\f\u001a\u00060\u0002j\u0002`\u0006\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\f\b\u0002\u0010\f\u001a\u00060\u0002j\u0002`\u00062\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\nR\u001d\u0010\f\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005R\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001f\u0010\u0005¨\u0006\""}, d2 = {"Lcom/discord/stores/StoreMessageReactions$EmojiResults$Failure;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "component3", "()Lcom/discord/api/message/reaction/MessageReactionEmoji;", "channelId", "messageId", "emoji", "copy", "(JJLcom/discord/api/message/reaction/MessageReactionEmoji;)Lcom/discord/stores/StoreMessageReactions$EmojiResults$Failure;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "getEmoji", "J", "getMessageId", "getChannelId", "<init>", "(JJLcom/discord/api/message/reaction/MessageReactionEmoji;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Failure extends EmojiResults {
            private final long channelId;
            private final MessageReactionEmoji emoji;
            private final long messageId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
                super(null);
                Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
                this.channelId = j;
                this.messageId = j2;
                this.emoji = messageReactionEmoji;
            }

            public static /* synthetic */ Failure copy$default(Failure failure, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = failure.channelId;
                }
                long j3 = j;
                if ((i & 2) != 0) {
                    j2 = failure.messageId;
                }
                long j4 = j2;
                if ((i & 4) != 0) {
                    messageReactionEmoji = failure.emoji;
                }
                return failure.copy(j3, j4, messageReactionEmoji);
            }

            /* renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component2, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            /* renamed from: component3, reason: from getter */
            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final Failure copy(long channelId, long messageId, MessageReactionEmoji emoji) {
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                return new Failure(channelId, messageId, emoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failure)) {
                    return false;
                }
                Failure failure = (Failure) other;
                return this.channelId == failure.channelId && this.messageId == failure.messageId && Intrinsics3.areEqual(this.emoji, failure.emoji);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public int hashCode() {
                int iA = (b.a(this.messageId) + (b.a(this.channelId) * 31)) * 31;
                MessageReactionEmoji messageReactionEmoji = this.emoji;
                return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Failure(channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", emoji=");
                sbU.append(this.emoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreMessageReactions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreMessageReactions$EmojiResults$Loading;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends EmojiResults {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreMessageReactions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012*\u0010\u0013\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007`\b\u0012\n\u0010\u0014\u001a\u00060\u0005j\u0002`\u000b\u0012\n\u0010\u0015\u001a\u00060\u0005j\u0002`\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0010¢\u0006\u0004\b+\u0010,J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\t\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\f\u001a\u00060\u0005j\u0002`\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u000f\u001a\u00060\u0005j\u0002`\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jd\u0010\u0017\u001a\u00020\u00002,\b\u0002\u0010\u0013\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007`\b2\f\b\u0002\u0010\u0014\u001a\u00060\u0005j\u0002`\u000b2\f\b\u0002\u0010\u0015\u001a\u00060\u0005j\u0002`\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0010HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R=\u0010\u0013\u001a&\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u0004j\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\nR\u0019\u0010\u0016\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u0012R\u001d\u0010\u0015\u001a\u00060\u0005j\u0002`\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\rR\u001d\u0010\u0014\u001a\u00060\u0005j\u0002`\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b*\u0010\r¨\u0006-"}, d2 = {"Lcom/discord/stores/StoreMessageReactions$EmojiResults$Users;", "Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "deepCopy", "()Lcom/discord/stores/StoreMessageReactions$EmojiResults$Users;", "Ljava/util/LinkedHashMap;", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "Lkotlin/collections/LinkedHashMap;", "component1", "()Ljava/util/LinkedHashMap;", "Lcom/discord/primitives/ChannelId;", "component2", "()J", "Lcom/discord/primitives/MessageId;", "component3", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "component4", "()Lcom/discord/api/message/reaction/MessageReactionEmoji;", "users", "channelId", "messageId", "emoji", "copy", "(Ljava/util/LinkedHashMap;JJLcom/discord/api/message/reaction/MessageReactionEmoji;)Lcom/discord/stores/StoreMessageReactions$EmojiResults$Users;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/LinkedHashMap;", "getUsers", "Lcom/discord/api/message/reaction/MessageReactionEmoji;", "getEmoji", "J", "getMessageId", "getChannelId", "<init>", "(Ljava/util/LinkedHashMap;JJLcom/discord/api/message/reaction/MessageReactionEmoji;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Users extends EmojiResults {
            private final long channelId;
            private final MessageReactionEmoji emoji;
            private final long messageId;
            private final LinkedHashMap<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Users(LinkedHashMap<Long, User> linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
                super(null);
                Intrinsics3.checkNotNullParameter(linkedHashMap, "users");
                Intrinsics3.checkNotNullParameter(messageReactionEmoji, "emoji");
                this.users = linkedHashMap;
                this.channelId = j;
                this.messageId = j2;
                this.emoji = messageReactionEmoji;
            }

            public static /* synthetic */ Users copy$default(Users users, LinkedHashMap linkedHashMap, long j, long j2, MessageReactionEmoji messageReactionEmoji, int i, Object obj) {
                if ((i & 1) != 0) {
                    linkedHashMap = users.users;
                }
                if ((i & 2) != 0) {
                    j = users.channelId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = users.messageId;
                }
                long j4 = j2;
                if ((i & 8) != 0) {
                    messageReactionEmoji = users.emoji;
                }
                return users.copy(linkedHashMap, j3, j4, messageReactionEmoji);
            }

            public final LinkedHashMap<Long, User> component1() {
                return this.users;
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
            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final Users copy(LinkedHashMap<Long, User> users, long channelId, long messageId, MessageReactionEmoji emoji) {
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(emoji, "emoji");
                return new Users(users, channelId, messageId, emoji);
            }

            public final Users deepCopy() {
                return new Users(new LinkedHashMap(this.users), this.channelId, this.messageId, this.emoji);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Users)) {
                    return false;
                }
                Users users = (Users) other;
                return Intrinsics3.areEqual(this.users, users.users) && this.channelId == users.channelId && this.messageId == users.messageId && Intrinsics3.areEqual(this.emoji, users.emoji);
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final MessageReactionEmoji getEmoji() {
                return this.emoji;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final LinkedHashMap<Long, User> getUsers() {
                return this.users;
            }

            public int hashCode() {
                LinkedHashMap<Long, User> linkedHashMap = this.users;
                int iA = (b.a(this.messageId) + ((b.a(this.channelId) + ((linkedHashMap != null ? linkedHashMap.hashCode() : 0) * 31)) * 31)) * 31;
                MessageReactionEmoji messageReactionEmoji = this.emoji;
                return iA + (messageReactionEmoji != null ? messageReactionEmoji.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Users(users=");
                sbU.append(this.users);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                sbU.append(this.messageId);
                sbU.append(", emoji=");
                sbU.append(this.emoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private EmojiResults() {
        }

        public /* synthetic */ EmojiResults(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReactions$deleteEmoji$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/user/User;", "reactionUsers", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends com.discord.api.user.User>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessageReactions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01531 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $reactionUsers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01531(List list) {
                super(0);
                this.$reactionUsers = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreMessageReactions storeMessageReactions = StoreMessageReactions.this;
                long j = anonymousClass1.$channelId;
                long j2 = anonymousClass1.$messageId;
                MessageReactionEmoji messageReactionEmoji = anonymousClass1.$emoji;
                List list = this.$reactionUsers;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CoreUser((com.discord.api.user.User) it.next()));
                }
                StoreMessageReactions.access$handleReactionUsers(storeMessageReactions, j, j2, messageReactionEmoji, arrayList);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.user.User> list) {
            invoke2((List<com.discord.api.user.User>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.api.user.User> list) {
            Intrinsics3.checkNotNullParameter(list, "reactionUsers");
            StoreMessageReactions.access$getDispatcher$p(StoreMessageReactions.this).schedule(new C01531(list));
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessageReactions.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreMessageReactions$fetchReactions$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreMessageReactions.access$handleLoadReactionUsersFailure(StoreMessageReactions.this, anonymousClass2.$channelId, anonymousClass2.$messageId, anonymousClass2.$emoji);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreMessageReactions.access$getDispatcher$p(StoreMessageReactions.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReactions$forceRetryFetchReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, MessageReactionEmoji messageReactionEmoji, long j2) {
            super(0);
            this.$messageId = j;
            this.$emoji = messageReactionEmoji;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreMessageReactions.access$getReactions$p(StoreMessageReactions.this).get(Long.valueOf(this.$messageId));
            if (map != null) {
            }
            StoreMessageReactions.access$fetchReactions(StoreMessageReactions.this, this.$channelId, this.$messageId, this.$emoji);
            StoreMessageReactions.this.markChanged();
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReactions$observeMessageReactions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, MessageReactionEmoji messageReactionEmoji) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageReactions.access$fetchReactions(StoreMessageReactions.this, this.$channelId, this.$messageId, this.$emoji);
        }
    }

    /* compiled from: StoreMessageReactions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "invoke", "()Lcom/discord/stores/StoreMessageReactions$EmojiResults;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreMessageReactions$observeMessageReactions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<EmojiResults> {
        public final /* synthetic */ MessageReactionEmoji $emoji;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, MessageReactionEmoji messageReactionEmoji) {
            super(0);
            this.$messageId = j;
            this.$emoji = messageReactionEmoji;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ EmojiResults invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EmojiResults invoke() {
            EmojiResults emojiResults;
            Map map = (Map) StoreMessageReactions.access$getReactionsSnapshot$p(StoreMessageReactions.this).get(Long.valueOf(this.$messageId));
            return (map == null || (emojiResults = (EmojiResults) map.get(this.$emoji.c())) == null) ? EmojiResults.Loading.INSTANCE : emojiResults;
        }
    }

    public /* synthetic */ StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ void access$fetchReactions(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        storeMessageReactions.fetchReactions(j, j2, messageReactionEmoji);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.dispatcher;
    }

    public static final /* synthetic */ Map access$getReactions$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.reactions;
    }

    public static final /* synthetic */ Map access$getReactionsSnapshot$p(StoreMessageReactions storeMessageReactions) {
        return storeMessageReactions.reactionsSnapshot;
    }

    public static final /* synthetic */ void access$handleLoadReactionUsersFailure(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji) {
        storeMessageReactions.handleLoadReactionUsersFailure(j, j2, messageReactionEmoji);
    }

    public static final /* synthetic */ void access$handleReactionUsers(StoreMessageReactions storeMessageReactions, long j, long j2, MessageReactionEmoji messageReactionEmoji, List list) {
        storeMessageReactions.handleReactionUsers(j, j2, messageReactionEmoji, list);
    }

    public static final /* synthetic */ void access$setReactionsSnapshot$p(StoreMessageReactions storeMessageReactions, Map map) {
        storeMessageReactions.reactionsSnapshot = map;
    }

    @Store3
    private final EmojiResults ensureReactionResults(long messageId, String emoji) {
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map == null) {
            map = new HashMap<>();
        }
        EmojiResults emojiResults = map.get(emoji);
        if (emojiResults == null) {
            emojiResults = EmojiResults.Loading.INSTANCE;
        }
        map.put(emoji, emojiResults);
        this.reactions.put(Long.valueOf(messageId), map);
        return emojiResults;
    }

    @Store3
    private final void fetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        if ((ensureReactionResults(messageId, emoji.c()) instanceof EmojiResults.Users) && (!((EmojiResults.Users) r0).getUsers().isEmpty())) {
            return;
        }
        String reactionEmojiRequestParam = getReactionEmojiRequestParam(emoji);
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), EmojiResults.Loading.INSTANCE);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getReactionUsers(channelId, messageId, reactionEmojiRequestParam, 100), false, 1, null), StoreMessageReactions.class, (Context) null, (Function1) null, new AnonymousClass2(channelId, messageId, emoji), (Function0) null, (Function0) null, new AnonymousClass1(channelId, messageId, emoji), 54, (Object) null);
    }

    private final String getReactionEmojiRequestParam(MessageReactionEmoji emoji) {
        if (!emoji.e()) {
            String name = emoji.getName();
            return name != null ? name : "";
        }
        return emoji.getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR + emoji.getId();
    }

    @Store3
    private final void handleLoadReactionUsersFailure(long channelId, long messageId, MessageReactionEmoji emoji) {
        ensureReactionResults(messageId, emoji.c());
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new EmojiResults.Failure(channelId, messageId, emoji));
        }
        markChanged();
    }

    @Store3
    private final void handleReactionUsers(long channelId, long messageId, MessageReactionEmoji emoji, List<? extends User> reactionUsers) {
        ensureReactionResults(messageId, emoji.c());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : reactionUsers) {
            linkedHashMap.put(Long.valueOf(((User) obj).getId()), obj);
        }
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.put(emoji.c(), new EmojiResults.Users(linkedHashMap, channelId, messageId, emoji));
        }
        markChanged();
    }

    public final void deleteEmoji(long channelId, long messageId, MessageReactionEmoji emoji, long userId) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeReaction(channelId, messageId, getReactionEmojiRequestParam(emoji), userId), false, 1, null), StoreMessageReactions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    public final void forceRetryFetchReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new AnonymousClass1(messageId, emoji, channelId));
    }

    @Store3
    public final void handleConnectionOpen() {
        if (!this.reactions.isEmpty()) {
            this.reactions.clear();
            markChanged();
        }
    }

    @Store3
    public final void handleReactionAdd(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        User user = this.userStore.getUsersInternal$app_productionGoogleRelease().get(Long.valueOf(update.getUserId()));
        if (user != null) {
            EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
            if (!(emojiResultsEnsureReactionResults instanceof EmojiResults.Users)) {
                emojiResultsEnsureReactionResults = null;
            }
            EmojiResults.Users users = (EmojiResults.Users) emojiResultsEnsureReactionResults;
            if (users != null) {
                users.getUsers().put(Long.valueOf(update.getUserId()), user);
                markChanged();
            }
        }
    }

    @Store3
    public final void handleReactionRemove(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        EmojiResults emojiResultsEnsureReactionResults = ensureReactionResults(update.getMessageId(), update.getEmoji().c());
        if (!(emojiResultsEnsureReactionResults instanceof EmojiResults.Users)) {
            emojiResultsEnsureReactionResults = null;
        }
        EmojiResults.Users users = (EmojiResults.Users) emojiResultsEnsureReactionResults;
        if (users != null) {
            users.getUsers().remove(Long.valueOf(update.getUserId()));
            markChanged();
        }
    }

    @Store3
    public final void handleReactionRemoveAll(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        this.reactions.remove(Long.valueOf(update.getMessageId()));
        markChanged();
    }

    @Store3
    public final void handleReactionRemoveEmoji(MessageReactionUpdate update) {
        Intrinsics3.checkNotNullParameter(update, "update");
        long messageId = update.getMessageId();
        String strC = update.getEmoji().c();
        ensureReactionResults(messageId, strC);
        Map<String, EmojiResults> map = this.reactions.get(Long.valueOf(messageId));
        if (map != null) {
            map.remove(strC);
        }
        markChanged();
    }

    public final Observable<EmojiResults> observeMessageReactions(long channelId, long messageId, MessageReactionEmoji emoji) {
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        this.dispatcher.schedule(new AnonymousClass1(channelId, messageId, emoji));
        Observable<EmojiResults> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(messageId, emoji), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap(this.reactions);
        for (Map.Entry<Long, Map<String, EmojiResults>> entry : this.reactions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            HashMap map2 = new HashMap(entry.getValue());
            map.put(Long.valueOf(jLongValue), map2);
            for (Map.Entry entry2 : map2.entrySet()) {
                String str = (String) entry2.getKey();
                Object objDeepCopy = (EmojiResults) entry2.getValue();
                if (objDeepCopy instanceof EmojiResults.Users) {
                    objDeepCopy = ((EmojiResults.Users) objDeepCopy).deepCopy();
                }
                map2.put(str, objDeepCopy);
            }
        }
        this.reactionsSnapshot = map;
    }

    public StoreMessageReactions(Dispatcher dispatcher, StoreUser storeUser, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.userStore = storeUser;
        this.observationDeck = observationDeck;
        this.reactions = new HashMap();
        this.reactionsSnapshot = new HashMap();
    }
}
