package com.discord.widgets.stage.start;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.stage.start.ModeratorStartStageViewModel;
import d0.t.Iterables2;
import d0.t._Collections;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: ModeratorStartStageViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a*\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004 \u0001*\u0014\u0012\u000e\b\u0001\u0012\n \u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/api/channel/Channel;", "kotlin.jvm.PlatformType", "channel", "Lrx/Observable;", "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/api/channel/Channel;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ModeratorStartStageViewModel2<T, R> implements Func1<Channel, Observable<? extends ModeratorStartStageViewModel.StoreState>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreGuildScheduledEvents $guildScheduledEventsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;
    public final /* synthetic */ StoreVoiceParticipants $voiceParticipantsStore;

    /* compiled from: ModeratorStartStageViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000e\u001a\n \u0004*\u0004\u0018\u00010\u000b0\u000b2.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u00002\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007 \u0004*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00062\u000e\u0010\n\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\tH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "kotlin.jvm.PlatformType", "voiceParticipants", "", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvents", "Lcom/discord/api/permission/PermissionBit;", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS, "Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Long;)Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.stage.start.ModeratorStartStageViewModel$Companion$observeStores$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends StoreVoiceParticipants.VoiceUser>, List<? extends GuildScheduledEvent>, Long, ModeratorStartStageViewModel.StoreState> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ ModeratorStartStageViewModel.StoreState call(Map<Long, ? extends StoreVoiceParticipants.VoiceUser> map, List<? extends GuildScheduledEvent> list, Long l) {
            return call2((Map<Long, StoreVoiceParticipants.VoiceUser>) map, (List<GuildScheduledEvent>) list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModeratorStartStageViewModel.StoreState call2(Map<Long, StoreVoiceParticipants.VoiceUser> map, List<GuildScheduledEvent> list, Long l) {
            ArrayList arrayListA0 = outline.a0(list, "guildScheduledEvents");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Long channelId = ((GuildScheduledEvent) next).getChannelId();
                if (channelId != null && channelId.longValue() == ModeratorStartStageViewModel2.this.$channelId) {
                    arrayListA0.add(next);
                }
            }
            List listSortedWith = _Collections.sortedWith(arrayListA0, new ModeratorStartStageViewModel$Companion$observeStores$1$1$$special$$inlined$sortedBy$1());
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = map.values();
            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
            for (T t : collectionValues) {
                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                    arrayList.add(t);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                arrayList2.add(new UserGuildMember(voiceUser.getUser(), voiceUser.getGuildMember()));
            }
            return new ModeratorStartStageViewModel.StoreState(listSortedWith, arrayList2, PermissionUtils.can(Permission.START_STAGE_EVENT, l));
        }
    }

    public ModeratorStartStageViewModel2(StoreVoiceParticipants storeVoiceParticipants, StoreGuildScheduledEvents storeGuildScheduledEvents, StorePermissions storePermissions, long j) {
        this.$voiceParticipantsStore = storeVoiceParticipants;
        this.$guildScheduledEventsStore = storeGuildScheduledEvents;
        this.$permissionsStore = storePermissions;
        this.$channelId = j;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends ModeratorStartStageViewModel.StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ModeratorStartStageViewModel.StoreState> call2(Channel channel) {
        return Observable.i(ObservableExtensionsKt.leadingEdgeThrottle(this.$voiceParticipantsStore.get(channel.getId()), 250L, TimeUnit.MILLISECONDS), StoreGuildScheduledEvents.observeGuildScheduledEvents$default(this.$guildScheduledEventsStore, channel.getGuildId(), false, 2, null), this.$permissionsStore.observePermissionsForChannel(channel.getId()), new AnonymousClass1());
    }
}
