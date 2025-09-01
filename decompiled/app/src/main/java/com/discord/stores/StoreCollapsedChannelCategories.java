package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.cache.SharedPreferenceExtensions;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreCollapsedChannelCategories.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b)\u0010*J/\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\r0\u00102\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0013\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R0\u0010#\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R0\u0010(\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00050\"0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010$¨\u0006,"}, d2 = {"Lcom/discord/stores/StoreCollapsedChannelCategories;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/ChannelId;", "categoryId", "", "collapsed", "", "setCollapsedState", "(JJZ)V", "", "", "getCollapsedCategories", "()Ljava/util/Map;", "Lrx/Observable;", "observeCollapsedCategories", "(J)Lrx/Observable;", "setCollapsedCategory", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "Lcom/discord/models/domain/ModelPayload;", "payload", "handleConnectionOpen", "(Lcom/discord/models/domain/ModelPayload;)V", "snapshotData", "()V", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "", "collapsedCategories", "Ljava/util/Map;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "collapsedCategoriesSnapshot", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories extends StoreV2 {
    private static final String CACHE_KEY_COLLAPSED_CATEGORIES = "STORE_COLLAPSED_CATEGORIES_V2";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<Long, Set<Long>> collapsedCategories;
    private Map<Long, Set<Long>> collapsedCategoriesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreCollapsedChannelCategories.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\t\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ9\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022 \u0010\u000b\u001a\u001c\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0005j\u0002`\b0\u00070\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/discord/stores/StoreCollapsedChannelCategories$Companion;", "", "Landroid/content/SharedPreferences;", "prefs", "", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/primitives/ChannelId;", "fromCache", "(Landroid/content/SharedPreferences;)Ljava/util/Map;", "collapsedCategories", "", "toCache", "(Landroid/content/SharedPreferences;Ljava/util/Map;)V", "", "CACHE_KEY_COLLAPSED_CATEGORIES", "Ljava/lang/String;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Map access$fromCache(Companion companion, SharedPreferences sharedPreferences) {
            return companion.fromCache(sharedPreferences);
        }

        public static final /* synthetic */ void access$toCache(Companion companion, SharedPreferences sharedPreferences, Map map) {
            companion.toCache(sharedPreferences, map);
        }

        private final Map<Long, Set<Long>> fromCache(SharedPreferences prefs) {
            return SharedPreferenceExtensions.getStringEntrySetAsMap$default(prefs, StoreCollapsedChannelCategories.CACHE_KEY_COLLAPSED_CATEGORIES, null, StoreCollapsedChannelCategories2.INSTANCE, 2, null);
        }

        private final void toCache(SharedPreferences prefs, Map<Long, Set<Long>> collapsedCategories) {
            SharedPreferences.Editor editorEdit = prefs.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            SharedPreferenceExtensions.putStringEntrySetAsMap$default(editorEdit, StoreCollapsedChannelCategories.CACHE_KEY_COLLAPSED_CATEGORIES, collapsedCategories, null, StoreCollapsedChannelCategories4.INSTANCE, 4, null);
            editorEdit.apply();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreCollapsedChannelCategories.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/ChannelId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCollapsedChannelCategories$observeCollapsedCategories$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            Set<Long> setEmptySet = StoreCollapsedChannelCategories.this.getCollapsedCategories().get(Long.valueOf(this.$guildId));
            if (setEmptySet == null) {
                setEmptySet = Sets5.emptySet();
            }
            return setEmptySet;
        }
    }

    /* compiled from: StoreCollapsedChannelCategories.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreCollapsedChannelCategories$setCollapsedCategory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $categoryId;
        public final /* synthetic */ boolean $collapsed;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, boolean z2) {
            super(0);
            this.$guildId = j;
            this.$categoryId = j2;
            this.$collapsed = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreCollapsedChannelCategories.access$setCollapsedState(StoreCollapsedChannelCategories.this, this.$guildId, this.$categoryId, this.$collapsed);
        }
    }

    public StoreCollapsedChannelCategories(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.collapsedCategories = new HashMap();
        this.collapsedCategoriesSnapshot = new HashMap();
    }

    public static final /* synthetic */ void access$setCollapsedState(StoreCollapsedChannelCategories storeCollapsedChannelCategories, long j, long j2, boolean z2) {
        storeCollapsedChannelCategories.setCollapsedState(j, j2, z2);
    }

    private final void setCollapsedState(long guildId, long categoryId, boolean collapsed) {
        Map<Long, Set<Long>> map = this.collapsedCategories;
        Long lValueOf = Long.valueOf(guildId);
        Set<Long> hashSet = map.get(lValueOf);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map.put(lValueOf, hashSet);
        }
        Set<Long> set = hashSet;
        if (collapsed) {
            set.add(Long.valueOf(categoryId));
        } else {
            set.remove(Long.valueOf(categoryId));
            if (set.isEmpty()) {
                this.collapsedCategories.remove(Long.valueOf(guildId));
            }
        }
        markChanged();
    }

    public final Map<Long, Set<Long>> getCollapsedCategories() {
        return this.collapsedCategoriesSnapshot;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        HashSet hashSet = new HashSet(this.collapsedCategories.keySet());
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Set<Long> set = this.collapsedCategories.get(Long.valueOf(guild.getId()));
            if (set != null) {
                HashSet<Long> hashSet2 = new HashSet(set);
                List<Channel> listG = guild.g();
                if (listG != null) {
                    Iterator<T> it = listG.iterator();
                    while (it.hasNext()) {
                        hashSet2.remove(Long.valueOf(((Channel) it.next()).getId()));
                    }
                }
                for (Long l : hashSet2) {
                    long id2 = guild.getId();
                    Intrinsics3.checkNotNullExpressionValue(l, "channelId");
                    setCollapsedState(id2, l.longValue(), false);
                }
                hashSet.remove(Long.valueOf(guild.getId()));
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.collapsedCategories.remove((Long) it2.next());
            markChanged();
        }
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.collapsedCategories = Companion.access$fromCache(INSTANCE, getPrefs());
        markChanged();
    }

    public final Observable<Set<Long>> observeCollapsedCategories(long guildId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final void setCollapsedCategory(long guildId, long categoryId, boolean collapsed) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, categoryId, collapsed));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        Companion.access$toCache(INSTANCE, getPrefs(), this.collapsedCategories);
        HashMap map = new HashMap(this.collapsedCategories);
        Iterator<T> it = this.collapsedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            map.put(entry.getKey(), new HashSet((Set) entry.getValue()));
        }
        this.collapsedCategoriesSnapshot = map;
    }
}
