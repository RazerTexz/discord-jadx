package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.api.guild.Guild;
import com.discord.api.guildhash.GuildHash;
import com.discord.api.guildhash.GuildHashes;
import com.discord.api.message.Message;
import com.discord.api.sticker.GuildStickersUpdate;
import com.discord.gateway.io.Outgoing2;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.guildhash.GuildHashUtils;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreClientDataState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001DB\u0011\u0012\b\b\u0002\u0010>\u001a\u00020=¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010 \u001a\u00020\u00042\n\u0010\u001d\u001a\u00060\u0007j\u0002`\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\"H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00042\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u0010\u0011R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001a\u00108\u001a\u00060\u0007j\u0002`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00107R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R&\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\u0007j\u0002`\u001c\u0012\u0004\u0012\u00020\u001e0@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010A¨\u0006E"}, d2 = {"Lcom/discord/stores/StoreClientDataState;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/guild/Guild;", "guild", "", "updateGuildHash", "(Lcom/discord/api/guild/Guild;)V", "", "Lcom/discord/primitives/MessageId;", "newMessageId", "updateHighestLastMessageId", "(J)V", "Lrx/Observable;", "Lcom/discord/stores/StoreClientDataState$ClientDataState;", "observeClientState", "()Lrx/Observable;", "clear", "()V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildAdd", "handleGuildRemove", "Lcom/discord/api/channel/Channel;", "channel", "handleChannelCreateOrUpdateOrDelete", "(Lcom/discord/api/channel/Channel;)V", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/guildhash/GuildHashes;", "guildHashes", "handleRoleAddOrRemove", "(JLcom/discord/api/guildhash/GuildHashes;)V", "Lcom/discord/api/emoji/GuildEmojisUpdate;", "handleEmojiUpdate", "(Lcom/discord/api/emoji/GuildEmojisUpdate;)V", "Lcom/discord/api/sticker/GuildStickersUpdate;", "handleStickersUpdate", "(Lcom/discord/api/sticker/GuildStickersUpdate;)V", "Lcom/discord/api/message/Message;", "message", "handleMessageCreate", "(Lcom/discord/api/message/Message;)V", "Lcom/discord/models/domain/ModelReadState;", "readState", "handleMessageAck", "(Lcom/discord/models/domain/ModelReadState;)V", "Lcom/discord/models/domain/ModelNotificationSettings;", "userGuildSettings", "handleGuildSettingUpdated", "(Lcom/discord/models/domain/ModelNotificationSettings;)V", "snapshotData", "", "readStateVersion", "I", "highestLastMessageId", "J", "userGuildSettingsVersion", "clientDataStateSnapshot", "Lcom/discord/stores/StoreClientDataState$ClientDataState;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "Ljava/util/Map;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "ClientDataState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreClientDataState extends StoreV2 {
    private ClientDataState clientDataStateSnapshot;
    private Map<Long, GuildHashes> guildHashes;
    private long highestLastMessageId;
    private final ObservationDeck observationDeck;
    private int readStateVersion;
    private int userGuildSettingsVersion;

    /* compiled from: StoreClientDataState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00020\n\u0012\f\b\u0002\u0010\u0017\u001a\u00060\u000bj\u0002`\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ \u0010\r\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00060\u000bj\u0002`\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014JL\u0010\u001a\u001a\u00020\u00002\u0018\b\u0002\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00020\n2\f\b\u0002\u0010\u0017\u001a\u00060\u000bj\u0002`\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0012HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0014J\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0019\u0010\u0018\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010\u0014R\u001d\u0010\u0017\u001a\u00060\u000bj\u0002`\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b&\u0010\u0011R\u0019\u0010\u0019\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b'\u0010\u0014R)\u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u000bj\u0002`\f\u0012\u0004\u0012\u00020\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u000e¨\u0006,"}, d2 = {"Lcom/discord/stores/StoreClientDataState$ClientDataState;", "", "Lcom/discord/api/guildhash/GuildHashes;", "", "", "toArray", "(Lcom/discord/api/guildhash/GuildHashes;)[Ljava/lang/String;", "Lcom/discord/gateway/io/OutgoingPayload$IdentifyClientState;", "toIdentifyData", "()Lcom/discord/gateway/io/OutgoingPayload$IdentifyClientState;", "", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/util/Map;", "Lcom/discord/primitives/MessageId;", "component2", "()J", "", "component3", "()I", "component4", "guildHashes", "highestLastMessageId", "readStateVersion", "userGuildSettingsVersion", "copy", "(Ljava/util/Map;JII)Lcom/discord/stores/StoreClientDataState$ClientDataState;", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getReadStateVersion", "J", "getHighestLastMessageId", "getUserGuildSettingsVersion", "Ljava/util/Map;", "getGuildHashes", "<init>", "(Ljava/util/Map;JII)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ClientDataState {
        private final Map<Long, GuildHashes> guildHashes;
        private final long highestLastMessageId;
        private final int readStateVersion;
        private final int userGuildSettingsVersion;

        public ClientDataState() {
            this(null, 0L, 0, 0, 15, null);
        }

        public ClientDataState(Map<Long, GuildHashes> map, long j, int i, int i2) {
            Intrinsics3.checkNotNullParameter(map, "guildHashes");
            this.guildHashes = map;
            this.highestLastMessageId = j;
            this.readStateVersion = i;
            this.userGuildSettingsVersion = i2;
        }

        public static /* synthetic */ ClientDataState copy$default(ClientDataState clientDataState, Map map, long j, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                map = clientDataState.guildHashes;
            }
            if ((i3 & 2) != 0) {
                j = clientDataState.highestLastMessageId;
            }
            long j2 = j;
            if ((i3 & 4) != 0) {
                i = clientDataState.readStateVersion;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                i2 = clientDataState.userGuildSettingsVersion;
            }
            return clientDataState.copy(map, j2, i4, i2);
        }

        private final String[] toArray(GuildHashes guildHashes) {
            GuildHash metadata = guildHashes.getMetadata();
            String hash = metadata != null ? metadata.getHash() : null;
            GuildHash channels = guildHashes.getChannels();
            String hash2 = channels != null ? channels.getHash() : null;
            GuildHash roles = guildHashes.getRoles();
            String hash3 = roles != null ? roles.getHash() : null;
            if (hash == null || hash2 == null || hash3 == null) {
                return null;
            }
            return new String[]{hash, hash2, hash3};
        }

        public final Map<Long, GuildHashes> component1() {
            return this.guildHashes;
        }

        /* renamed from: component2, reason: from getter */
        public final long getHighestLastMessageId() {
            return this.highestLastMessageId;
        }

        /* renamed from: component3, reason: from getter */
        public final int getReadStateVersion() {
            return this.readStateVersion;
        }

        /* renamed from: component4, reason: from getter */
        public final int getUserGuildSettingsVersion() {
            return this.userGuildSettingsVersion;
        }

        public final ClientDataState copy(Map<Long, GuildHashes> guildHashes, long highestLastMessageId, int readStateVersion, int userGuildSettingsVersion) {
            Intrinsics3.checkNotNullParameter(guildHashes, "guildHashes");
            return new ClientDataState(guildHashes, highestLastMessageId, readStateVersion, userGuildSettingsVersion);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClientDataState)) {
                return false;
            }
            ClientDataState clientDataState = (ClientDataState) other;
            return Intrinsics3.areEqual(this.guildHashes, clientDataState.guildHashes) && this.highestLastMessageId == clientDataState.highestLastMessageId && this.readStateVersion == clientDataState.readStateVersion && this.userGuildSettingsVersion == clientDataState.userGuildSettingsVersion;
        }

        public final Map<Long, GuildHashes> getGuildHashes() {
            return this.guildHashes;
        }

        public final long getHighestLastMessageId() {
            return this.highestLastMessageId;
        }

        public final int getReadStateVersion() {
            return this.readStateVersion;
        }

        public final int getUserGuildSettingsVersion() {
            return this.userGuildSettingsVersion;
        }

        public int hashCode() {
            Map<Long, GuildHashes> map = this.guildHashes;
            return ((((b.a(this.highestLastMessageId) + ((map != null ? map.hashCode() : 0) * 31)) * 31) + this.readStateVersion) * 31) + this.userGuildSettingsVersion;
        }

        public final Outgoing2.IdentifyClientState toIdentifyData() {
            Map<Long, GuildHashes> map = this.guildHashes;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), toArray((GuildHashes) entry.getValue()));
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                if (entry2.getValue() != null) {
                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap2.size()));
            for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                Object key = entry3.getKey();
                Object value = entry3.getValue();
                Intrinsics3.checkNotNull(value);
                linkedHashMap3.put(key, (String[]) value);
            }
            return new Outgoing2.IdentifyClientState(linkedHashMap3, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ClientDataState(guildHashes=");
            sbU.append(this.guildHashes);
            sbU.append(", highestLastMessageId=");
            sbU.append(this.highestLastMessageId);
            sbU.append(", readStateVersion=");
            sbU.append(this.readStateVersion);
            sbU.append(", userGuildSettingsVersion=");
            return outline.B(sbU, this.userGuildSettingsVersion, ")");
        }

        public /* synthetic */ ClientDataState(Map map, long j, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new HashMap() : map, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? -1 : i, (i3 & 8) != 0 ? -1 : i2);
        }
    }

    /* compiled from: StoreClientDataState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/stores/StoreClientDataState$ClientDataState;", "invoke", "()Lcom/discord/stores/StoreClientDataState$ClientDataState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreClientDataState$observeClientState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ClientDataState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ClientDataState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClientDataState invoke() {
            return StoreClientDataState.access$getClientDataStateSnapshot$p(StoreClientDataState.this);
        }
    }

    public StoreClientDataState() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreClientDataState(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ ClientDataState access$getClientDataStateSnapshot$p(StoreClientDataState storeClientDataState) {
        return storeClientDataState.clientDataStateSnapshot;
    }

    public static final /* synthetic */ void access$setClientDataStateSnapshot$p(StoreClientDataState storeClientDataState, ClientDataState clientDataState) {
        storeClientDataState.clientDataStateSnapshot = clientDataState;
    }

    @Store3
    private final void updateGuildHash(Guild guild) {
        GuildHashes guildHashes;
        if (guild.getUnavailable() || (guildHashes = guild.getGuildHashes()) == null || !GuildHashUtils.isSupported(guildHashes)) {
            this.guildHashes.remove(Long.valueOf(guild.getId()));
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(guild.getId());
        GuildHashes guildHashes2 = guild.getGuildHashes();
        Intrinsics3.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
    }

    @Store3
    private final void updateHighestLastMessageId(long newMessageId) {
        if (newMessageId > this.highestLastMessageId) {
            this.highestLastMessageId = newMessageId;
        }
    }

    @Store3
    public final void clear() {
        this.guildHashes.clear();
        this.highestLastMessageId = 0L;
        this.readStateVersion = 0;
        this.userGuildSettingsVersion = -1;
        markChanged();
    }

    @Store3
    public final void handleChannelCreateOrUpdateOrDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        GuildHashes guildHashes = channel.getGuildHashes();
        if (guildHashes == null || !GuildHashUtils.isSupported(guildHashes)) {
            return;
        }
        Map<Long, GuildHashes> map = this.guildHashes;
        Long lValueOf = Long.valueOf(channel.getGuildId());
        GuildHashes guildHashes2 = channel.getGuildHashes();
        Intrinsics3.checkNotNull(guildHashes2);
        map.put(lValueOf, guildHashes2);
        markChanged();
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        clear();
        for (Guild guild : payload.getGuilds()) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            updateGuildHash(guild);
            List<Channel> listG = guild.g();
            if (listG != null) {
                Iterator<T> it = listG.iterator();
                while (it.hasNext()) {
                    updateHighestLastMessageId(((Channel) it.next()).getLastMessageId());
                }
            }
        }
        Iterator<Channel> it2 = payload.getPrivateChannels().iterator();
        while (it2.hasNext()) {
            updateHighestLastMessageId(it2.next().getLastMessageId());
        }
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        this.readStateVersion = readState.getVersion();
        ModelPayload.VersionedUserGuildSettings userGuildSettings = payload.getUserGuildSettings();
        Intrinsics3.checkNotNullExpressionValue(userGuildSettings, "payload.userGuildSettings");
        this.userGuildSettingsVersion = userGuildSettings.getVersion();
        markChanged();
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (GuildHashUtils.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        updateGuildHash(guild);
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.guildHashes.remove(Long.valueOf(guild.getId()));
        markChanged();
    }

    @Store3
    public final void handleGuildSettingUpdated(ModelNotificationSettings userGuildSettings) {
        Intrinsics3.checkNotNullParameter(userGuildSettings, "userGuildSettings");
        if (userGuildSettings.getVersion() > this.userGuildSettingsVersion) {
            this.userGuildSettingsVersion = userGuildSettings.getVersion();
            markChanged();
        }
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        if (readState.getVersion() > this.readStateVersion) {
            this.readStateVersion = readState.getVersion();
            markChanged();
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        updateHighestLastMessageId(message.getId());
        markChanged();
    }

    @Store3
    public final void handleRoleAddOrRemove(long guildId, GuildHashes guildHashes) {
        if (guildHashes == null || !GuildHashUtils.isSupported(guildHashes)) {
            return;
        }
        this.guildHashes.put(Long.valueOf(guildId), guildHashes);
        markChanged();
    }

    @Store3
    public final void handleStickersUpdate(GuildStickersUpdate payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        if (GuildHashUtils.isSupported(payload.getGuildHashes())) {
            this.guildHashes.put(Long.valueOf(payload.getGuildId()), payload.getGuildHashes());
            markChanged();
        }
    }

    public final Observable<ClientDataState> observeClientState() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.clientDataStateSnapshot = new ClientDataState(this.guildHashes, this.highestLastMessageId, this.readStateVersion, this.userGuildSettingsVersion);
    }

    public StoreClientDataState(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.guildHashes = new HashMap();
        this.readStateVersion = -1;
        this.userGuildSettingsVersion = -1;
        this.clientDataStateSnapshot = new ClientDataState(null, 0L, 0, 0, 15, null);
    }
}
