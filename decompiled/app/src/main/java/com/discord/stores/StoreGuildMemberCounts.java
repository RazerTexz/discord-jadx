package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreGuildMemberCounts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010\u001cJ\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\r2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u0015J\u000f\u0010\u001b\u001a\u00020\rH\u0017¢\u0006\u0004\b\u001b\u0010\u001cR&\u0010\u001e\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR:\u0010\"\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00060 j\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0006`!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/discord/stores/StoreGuildMemberCounts;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "", "observeApproximateMemberCount", "(J)Lrx/Observable;", "getApproximateMemberCount", "(J)I", "Lcom/discord/models/domain/ModelPayload;", "payload", "", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "Lcom/discord/api/guild/Guild;", "guild", "handleGuildCreate", "(Lcom/discord/api/guild/Guild;)V", "handleGuildDelete", "(J)V", "Lcom/discord/api/guildmember/GuildMember;", "member", "handleGuildMemberAdd", "(Lcom/discord/api/guildmember/GuildMember;)V", "handleGuildMemberRemove", "snapshotData", "()V", "", "guildMemberCountsSnapshot", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guildMemberCounts", "Ljava/util/HashMap;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreGuildMemberCounts extends StoreV2 {
    private final HashMap<Long, Integer> guildMemberCounts = new HashMap<>();
    private Map<Long, Integer> guildMemberCountsSnapshot = Maps6.emptyMap();

    /* compiled from: StoreGuildMemberCounts.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreGuildMemberCounts$observeApproximateMemberCount$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Integer num = (Integer) StoreGuildMemberCounts.access$getGuildMemberCountsSnapshot$p(StoreGuildMemberCounts.this).get(Long.valueOf(this.$guildId));
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
    }

    public static final /* synthetic */ Map access$getGuildMemberCountsSnapshot$p(StoreGuildMemberCounts storeGuildMemberCounts) {
        return storeGuildMemberCounts.guildMemberCountsSnapshot;
    }

    public static final /* synthetic */ void access$setGuildMemberCountsSnapshot$p(StoreGuildMemberCounts storeGuildMemberCounts, Map map) {
        storeGuildMemberCounts.guildMemberCountsSnapshot = map;
    }

    public final int getApproximateMemberCount(long guildId) {
        Integer num = this.guildMemberCountsSnapshot.get(Long.valueOf(guildId));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        if (guilds != null) {
            for (Guild guild : guilds) {
                this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
        markChanged();
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        this.guildMemberCounts.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        Integer num = this.guildMemberCounts.get(Long.valueOf(member.getGuildId()));
        if (num != null) {
            this.guildMemberCounts.put(Long.valueOf(member.getGuildId()), Integer.valueOf(num.intValue() + 1));
            markChanged();
        }
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId) {
        if (this.guildMemberCounts.get(Long.valueOf(guildId)) != null) {
            this.guildMemberCounts.put(Long.valueOf(guildId), Integer.valueOf(r0.intValue() - 1));
            markChanged();
        }
    }

    public final Observable<Integer> observeApproximateMemberCount(long guildId) {
        Observable<Integer> observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        try {
            this.guildMemberCountsSnapshot = new HashMap(this.guildMemberCounts);
        } catch (OutOfMemoryError e) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("OOM in StoreGuildMemberCounts. size: ");
            sbU.append(this.guildMemberCounts.size());
            appLog.recordBreadcrumb(sbU.toString(), "StoreGuildMemberCounts");
            throw e;
        }
    }
}
