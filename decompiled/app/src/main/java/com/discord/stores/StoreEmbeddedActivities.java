package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.BuildConfig;
import com.discord.api.embeddedactivities.EmbeddedActivityInGuild;
import com.discord.api.embeddedactivities.EmbeddedActivityInboundUpdate;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreEmbeddedActivities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010/\u001a\u00020.¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006JE\u0010\u0012\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0010\u0010\f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u000b0\n2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\n\u0010\u0011\u001a\u00060\u0007j\u0002`\u0010H\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\u0015\u001a\u00060\u0007j\u0002`\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001c\u001a&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u00190\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ7\u0010\u001f\u001a,\u0012(\u0012&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u00190\u00190\u001e¢\u0006\u0004\b\u001f\u0010 J3\u0010!\u001a\u001c\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u00190\u001e2\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010\u0006J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0017¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R:\u00102\u001a&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u001aj\u0002`\u001b01018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R:\u00104\u001a&\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0007j\u0002`\u0014\u0012\b\u0012\u00060\u001aj\u0002`\u001b0\u00190\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103¨\u00067"}, d2 = {"Lcom/discord/stores/StoreEmbeddedActivities;", "Lcom/discord/stores/StoreV2;", "Lcom/discord/api/guild/Guild;", "guild", "", "handleEmbeddedActivitiesForGuild", "(Lcom/discord/api/guild/Guild;)V", "", "Lcom/discord/primitives/ChannelId;", "channelId", "", "Lcom/discord/primitives/UserId;", "userIds", "Lcom/discord/api/embeddedactivities/EmbeddedActivity;", "Lcom/discord/stores/ApiEmbeddedActivity;", "apiEmbeddedActivity", "Lcom/discord/primitives/GuildId;", "guildId", "handleEmbeddedActivityForChannel", "(JLjava/util/List;Lcom/discord/api/embeddedactivities/EmbeddedActivity;J)V", "Lcom/discord/primitives/ApplicationId;", "applicationId", "", "getUrlForApplication", "(J)Ljava/lang/String;", "", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "Lcom/discord/stores/ClientEmbeddedActivity;", "getEmbeddedActivities", "()Ljava/util/Map;", "Lrx/Observable;", "observeEmbeddedActivities", "()Lrx/Observable;", "observeEmbeddedActivitiesForChannel", "(J)Lrx/Observable;", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "handleGuildCreate", "Lcom/discord/api/embeddedactivities/EmbeddedActivityInboundUpdate;", "embeddedActivityInboundUpdate", "handleEmbeddedActivityInboundUpdate", "(Lcom/discord/api/embeddedactivities/EmbeddedActivityInboundUpdate;)V", "snapshotData", "()V", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "", "embeddedActivitiesByChannel", "Ljava/util/Map;", "embeddedActivitiesByChannelSnapshot", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreEmbeddedActivities extends StoreV2 {
    private final Map<Long, Map<Long, EmbeddedActivity>> embeddedActivitiesByChannel;
    private Map<Long, ? extends Map<Long, EmbeddedActivity>> embeddedActivitiesByChannelSnapshot;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreEmbeddedActivities.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a&\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "Lcom/discord/stores/ClientEmbeddedActivity;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmbeddedActivities$observeEmbeddedActivities$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> invoke2() {
            return StoreEmbeddedActivities.this.getEmbeddedActivities();
        }
    }

    /* compiled from: StoreEmbeddedActivities.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\n\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005 \u0006*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0018\u00010\u00000\u00002V\u0010\u0007\u001aR\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000 \u0006*(\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0018\u0012\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0003\u0012\b\u0012\u00060\u0004j\u0002`\u00050\u0000\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/primitives/ApplicationId;", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "Lcom/discord/stores/ClientEmbeddedActivity;", "kotlin.jvm.PlatformType", "embeddedActivitiesByChannel", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreEmbeddedActivities$observeEmbeddedActivitiesForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>>, Map<Long, ? extends EmbeddedActivity>> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends EmbeddedActivity> call(Map<Long, ? extends Map<Long, ? extends EmbeddedActivity>> map) {
            return call2((Map<Long, ? extends Map<Long, EmbeddedActivity>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, EmbeddedActivity> call2(Map<Long, ? extends Map<Long, EmbeddedActivity>> map) {
            Map<Long, EmbeddedActivity> map2 = map.get(Long.valueOf(this.$channelId));
            return map2 != null ? map2 : Maps6.emptyMap();
        }
    }

    public StoreEmbeddedActivities() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreEmbeddedActivities(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    private final String getUrlForApplication(long applicationId) {
        if (BuildConfig.EMBEDDED_ACTIVITY_APPLICATION_HOST.length() == 0) {
            return null;
        }
        return "https://" + applicationId + '.' + BuildConfig.EMBEDDED_ACTIVITY_APPLICATION_HOST;
    }

    @Store3
    private final void handleEmbeddedActivitiesForGuild(Guild guild) {
        List<EmbeddedActivityInGuild> listJ = guild.j();
        if (listJ == null) {
            listJ = Collections2.emptyList();
        }
        for (EmbeddedActivityInGuild embeddedActivityInGuild : listJ) {
            handleEmbeddedActivityForChannel(embeddedActivityInGuild.getChannelId(), embeddedActivityInGuild.c(), embeddedActivityInGuild.getEmbeddedActivity(), guild.getId());
        }
    }

    @Store3
    private final void handleEmbeddedActivityForChannel(long channelId, List<Long> userIds, com.discord.api.embeddedactivities.EmbeddedActivity apiEmbeddedActivity, long guildId) {
        String urlForApplication = getUrlForApplication(apiEmbeddedActivity.getApplicationId());
        if (urlForApplication != null) {
            EmbeddedActivity embeddedActivityFromApiEmbeddedActivity = EmbeddedActivity.INSTANCE.fromApiEmbeddedActivity(apiEmbeddedActivity, userIds, urlForApplication, guildId);
            Map<Long, EmbeddedActivity> linkedHashMap = this.embeddedActivitiesByChannel.get(Long.valueOf(channelId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap<>();
            }
            long applicationId = embeddedActivityFromApiEmbeddedActivity.getApplicationId();
            if (!userIds.isEmpty()) {
                linkedHashMap.put(Long.valueOf(applicationId), embeddedActivityFromApiEmbeddedActivity);
            } else {
                linkedHashMap.remove(Long.valueOf(applicationId));
            }
            this.embeddedActivitiesByChannel.put(Long.valueOf(channelId), linkedHashMap);
            markChanged();
        }
    }

    public final Map<Long, Map<Long, EmbeddedActivity>> getEmbeddedActivities() {
        return this.embeddedActivitiesByChannelSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.embeddedActivitiesByChannel.clear();
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Intrinsics3.checkNotNullExpressionValue(guild, "guild");
            handleEmbeddedActivitiesForGuild(guild);
        }
        markChanged();
    }

    @Store3
    public final void handleEmbeddedActivityInboundUpdate(EmbeddedActivityInboundUpdate embeddedActivityInboundUpdate) {
        Intrinsics3.checkNotNullParameter(embeddedActivityInboundUpdate, "embeddedActivityInboundUpdate");
        handleEmbeddedActivityForChannel(embeddedActivityInboundUpdate.getChannelId(), embeddedActivityInboundUpdate.d(), embeddedActivityInboundUpdate.getEmbeddedActivity(), embeddedActivityInboundUpdate.getGuildId());
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        handleEmbeddedActivitiesForGuild(guild);
    }

    public final Observable<Map<Long, Map<Long, EmbeddedActivity>>> observeEmbeddedActivities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, EmbeddedActivity>> observeEmbeddedActivitiesForChannel(long channelId) {
        Observable observableG = observeEmbeddedActivities().G(new AnonymousClass1(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableG, "observeEmbeddedActivitie…] ?: emptyMap()\n        }");
        return observableG;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Map<Long, EmbeddedActivity>> entry : this.embeddedActivitiesByChannel.entrySet()) {
            map.put(entry.getKey(), new HashMap(entry.getValue()));
        }
        this.embeddedActivitiesByChannelSnapshot = map;
    }

    public StoreEmbeddedActivities(ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        this.embeddedActivitiesByChannelSnapshot = Maps6.emptyMap();
        this.embeddedActivitiesByChannel = new LinkedHashMap();
    }
}
