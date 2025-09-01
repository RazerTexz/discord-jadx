package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.f0._Sequences2;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: GuildIdsWithActiveEventsModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\n\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00070\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildIdsWithActiveEventsModel;", "", "Lcom/discord/stores/StoreGuildScheduledEvents;", "storeGuildScheduledEvents", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lrx/Observable;", "", "", "Lcom/discord/primitives/GuildId;", "observe", "(Lcom/discord/stores/StoreGuildScheduledEvents;Lcom/discord/stores/updates/ObservationDeck;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel {
    public static final GuildIdsWithActiveEventsModel INSTANCE = new GuildIdsWithActiveEventsModel();

    /* compiled from: GuildIdsWithActiveEventsModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "invoke", "()Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ StoreGuildScheduledEvents $storeGuildScheduledEvents;

        /* compiled from: GuildIdsWithActiveEventsModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "<name for destructuring parameter 0>", "", "invoke", "(Ljava/util/Map$Entry;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02941 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Boolean> {
            public static final C02941 INSTANCE = new C02941();

            public C02941() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Boolean.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                List<GuildScheduledEvent> value = entry.getValue();
                if (!(value instanceof Collection) || !value.isEmpty()) {
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        if (((GuildScheduledEvent) it.next()).getStatus() == GuildScheduledEventStatus.ACTIVE) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }

        /* compiled from: GuildIdsWithActiveEventsModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00060\u0001j\u0002`\u00022\u001c\u0010\u0005\u001a\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "entry", "invoke", "(Ljava/util/Map$Entry;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.widgets.guildscheduledevent.GuildIdsWithActiveEventsModel$observe$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>>, Long> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends List<? extends GuildScheduledEvent>> entry) {
                return Long.valueOf(invoke2((Map.Entry<Long, ? extends List<GuildScheduledEvent>>) entry));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final long invoke2(Map.Entry<Long, ? extends List<GuildScheduledEvent>> entry) {
                Intrinsics3.checkNotNullParameter(entry, "entry");
                return entry.getKey().longValue();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(StoreGuildScheduledEvents storeGuildScheduledEvents) {
            super(0);
            this.$storeGuildScheduledEvents = storeGuildScheduledEvents;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(this.$storeGuildScheduledEvents.getAllGuildScheduledEvents()), C02941.INSTANCE), AnonymousClass2.INSTANCE));
        }
    }

    private GuildIdsWithActiveEventsModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithActiveEventsModel guildIdsWithActiveEventsModel, StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
        }
        if ((i & 2) != 0) {
            observationDeck = ObservationDeck4.get();
        }
        return guildIdsWithActiveEventsModel.observe(storeGuildScheduledEvents, observationDeck);
    }

    public final Observable<Set<Long>> observe(StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildScheduledEvents}, false, null, null, new AnonymousClass1(storeGuildScheduledEvents), 14, null);
    }
}
