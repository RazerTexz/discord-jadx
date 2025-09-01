package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.applicationcommands.ApplicationCommandFrecencyTracker;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreApplicationCommandFrecency.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b(\u0010)J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\n\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\f\u0010\bJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ)\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00112\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\r2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0016\u0010\u000fR,\u0010\u0018\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R,\u0010'\u001a\u0018\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0019¨\u0006*"}, d2 = {"Lcom/discord/stores/StoreApplicationCommandFrecency;", "Lcom/discord/stores/StoreV2;", "", "Lcom/discord/primitives/GuildId;", "guildId", "", "", "getAllTopCommandIds", "(Ljava/lang/Long;)Ljava/util/List;", "commandId", "getKey", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "getTopCommandIds", "", "populateStore", "()V", "handlePreLogout", "Lrx/Observable;", "observeTopCommandIds", "(Ljava/lang/Long;)Lrx/Observable;", "onCommandUsed", "(Ljava/lang/Long;Ljava/lang/String;)V", "snapshotData", "", "topCommandIdsSnapshot", "Ljava/util/Map;", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/utilities/applicationcommands/ApplicationCommandFrecencyTracker;", "frecencyCache", "Lcom/discord/utilities/persister/Persister;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "frecency", "Lcom/discord/utilities/applicationcommands/ApplicationCommandFrecencyTracker;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "", "topCommandIds", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreApplicationCommandFrecency extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ApplicationCommandFrecencyTracker frecency;
    private final Persister<ApplicationCommandFrecencyTracker> frecencyCache;
    private final ObservationDeck observationDeck;
    private Map<Long, List<String>> topCommandIds;
    private Map<Long, ? extends List<String>> topCommandIdsSnapshot;

    /* compiled from: StoreApplicationCommandFrecency.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationCommandFrecency$observeTopCommandIds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends String>> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends String> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends String> invoke2() {
            return StoreApplicationCommandFrecency.this.getTopCommandIds(this.$guildId);
        }
    }

    /* compiled from: StoreApplicationCommandFrecency.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreApplicationCommandFrecency$onCommandUsed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $commandId;
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, String str) {
            super(0);
            this.$guildId = l;
            this.$commandId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FrecencyTracker.track$default(StoreApplicationCommandFrecency.access$getFrecency$p(StoreApplicationCommandFrecency.this), StoreApplicationCommandFrecency.access$getKey(StoreApplicationCommandFrecency.this, this.$guildId, this.$commandId), 0L, 2, null);
            StoreApplicationCommandFrecency.access$getFrecencyCache$p(StoreApplicationCommandFrecency.this).set(StoreApplicationCommandFrecency.access$getFrecency$p(StoreApplicationCommandFrecency.this), true);
            Map mapAccess$getTopCommandIds$p = StoreApplicationCommandFrecency.access$getTopCommandIds$p(StoreApplicationCommandFrecency.this);
            Long l = this.$guildId;
            mapAccess$getTopCommandIds$p.put(Long.valueOf(l != null ? l.longValue() : 0L), StoreApplicationCommandFrecency.access$getAllTopCommandIds(StoreApplicationCommandFrecency.this, this.$guildId));
            StoreApplicationCommandFrecency storeApplicationCommandFrecency = StoreApplicationCommandFrecency.this;
            storeApplicationCommandFrecency.markChanged(storeApplicationCommandFrecency);
        }
    }

    public /* synthetic */ StoreApplicationCommandFrecency(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ List access$getAllTopCommandIds(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Long l) {
        return storeApplicationCommandFrecency.getAllTopCommandIds(l);
    }

    public static final /* synthetic */ ApplicationCommandFrecencyTracker access$getFrecency$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return storeApplicationCommandFrecency.frecency;
    }

    public static final /* synthetic */ Persister access$getFrecencyCache$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return storeApplicationCommandFrecency.frecencyCache;
    }

    public static final /* synthetic */ String access$getKey(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Long l, String str) {
        return storeApplicationCommandFrecency.getKey(l, str);
    }

    public static final /* synthetic */ Map access$getTopCommandIds$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency) {
        return storeApplicationCommandFrecency.topCommandIds;
    }

    public static final /* synthetic */ void access$setTopCommandIds$p(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Map map) {
        storeApplicationCommandFrecency.topCommandIds = map;
    }

    private final List<String> getAllTopCommandIds(Long guildId) {
        Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null);
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = sortedKeys$default.iterator();
        while (true) {
            boolean zAreEqual = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (guildId == null) {
                zAreEqual = !Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null);
            } else if (Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                zAreEqual = Intrinsics3.areEqual((String) Strings4.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).get(1), String.valueOf(guildId.longValue()));
            }
            if (zAreEqual) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (String str2 : arrayList) {
            if (Strings4.contains$default((CharSequence) str2, (CharSequence) ":", false, 2, (Object) null)) {
                str2 = (String) Strings4.split$default((CharSequence) str2, new String[]{":"}, false, 0, 6, (Object) null).get(0);
            }
            arrayList2.add(str2);
        }
        return arrayList2;
    }

    private final String getKey(Long guildId, String commandId) {
        if (guildId == null) {
            return commandId;
        }
        return commandId + MentionUtils.EMOJIS_AND_STICKERS_CHAR + guildId;
    }

    public final List<String> getTopCommandIds(Long guildId) {
        List<String> list = this.topCommandIdsSnapshot.get(Long.valueOf(guildId != null ? guildId.longValue() : 0L));
        return list != null ? list : Collections2.emptyList();
    }

    @Store3
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final Observable<List<String>> observeTopCommandIds(Long guildId) {
        Observable<List<String>> observableT = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).T(getTopCommandIds(guildId));
        Intrinsics3.checkNotNullExpressionValue(observableT, "observationDeck.connectR…etTopCommandIds(guildId))");
        return observableT;
    }

    public final void onCommandUsed(Long guildId, String commandId) {
        Intrinsics3.checkNotNullParameter(commandId, "commandId");
        this.dispatcher.schedule(new AnonymousClass1(guildId, commandId));
    }

    public final void populateStore() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : FrecencyTracker.getSortedKeys$default(this.frecency, 0L, 1, null)) {
            if (Strings4.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
                List listSplit$default = Strings4.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                Long longOrNull = StringNumberConversions.toLongOrNull((String) listSplit$default.get(1));
                long jLongValue = longOrNull != null ? longOrNull.longValue() : 0L;
                String str2 = (String) listSplit$default.get(0);
                List arrayList = (List) linkedHashMap.get(Long.valueOf(jLongValue));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(Long.valueOf(jLongValue), arrayList);
                }
                arrayList.add(str2);
            } else {
                List arrayList2 = (List) linkedHashMap.get(0L);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap.put(0L, arrayList2);
                }
                arrayList2.add(str);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), _Collections.toList((Iterable) entry.getValue()));
        }
        this.topCommandIds = Maps6.toMutableMap(linkedHashMap2);
        this.topCommandIdsSnapshot = linkedHashMap;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        this.topCommandIdsSnapshot = new HashMap(this.topCommandIds);
    }

    public StoreApplicationCommandFrecency(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        Persister<ApplicationCommandFrecencyTracker> persister = new Persister<>("CACHE_KEY_APPLICATION_COMMANDS", new ApplicationCommandFrecencyTracker(0, 0, 3, null));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.topCommandIds = new LinkedHashMap();
        this.topCommandIdsSnapshot = Maps6.emptyMap();
        populateStore();
    }
}
