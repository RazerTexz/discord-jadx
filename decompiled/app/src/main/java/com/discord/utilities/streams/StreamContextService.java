package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.streams.StreamContext;
import d0.d0._Ranges;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.FuncN;

/* compiled from: StreamContextService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010'\u001a\u00020&\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010$\u001a\u00020#\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b,\u0010-J1\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0012\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0012\u0004\u0012\u00020\f0\u000f0\b¢\u0006\u0004\b\u0012\u0010\u000eJ)\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b2\n\u0010\u0013\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/discord/utilities/streams/StreamContextService;", "", "Lcom/discord/models/domain/ModelApplicationStream;", "stream", "", "includePreview", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "applicationStreamPreviewStore", "Lrx/Observable;", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "getPreviewObservable", "(Lcom/discord/models/domain/ModelApplicationStream;ZLcom/discord/stores/StoreApplicationStreamPreviews;)Lrx/Observable;", "Lcom/discord/utilities/streams/StreamContext;", "getForActiveStream", "()Lrx/Observable;", "", "", "Lcom/discord/primitives/UserId;", "getForAllStreamingUsers", "userId", "getForUser", "(JZ)Lrx/Observable;", "Lcom/discord/stores/StoreVoiceStates;", "voiceStateStore", "Lcom/discord/stores/StoreVoiceStates;", "Lcom/discord/stores/StoreVoiceChannelSelected;", "voiceChannelSelectedStore", "Lcom/discord/stores/StoreVoiceChannelSelected;", "Lcom/discord/stores/StoreApplicationStreamPreviews;", "Lcom/discord/stores/StoreChannels;", "channelStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/stores/StoreApplicationStreaming;", "applicationStreamingStore", "Lcom/discord/stores/StoreApplicationStreaming;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "<init>", "(Lcom/discord/stores/StoreApplicationStreaming;Lcom/discord/stores/StoreGuilds;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreVoiceChannelSelected;Lcom/discord/stores/StoreVoiceStates;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreApplicationStreamPreviews;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StreamContextService {
    private final StoreApplicationStreamPreviews applicationStreamPreviewStore;
    private final StoreApplicationStreaming applicationStreamingStore;
    private final StoreChannels channelStore;
    private final StoreGuilds guildStore;
    private final StorePermissions permissionsStore;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;
    private final StoreVoiceStates voiceStateStore;

    /* compiled from: StreamContextService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeStream", "Lrx/Observable;", "Lcom/discord/utilities/streams/StreamContext;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForActiveStream$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<StoreApplicationStreaming.ActiveApplicationStream, Observable<? extends StreamContext>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends StreamContext> call(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
            return call2(activeApplicationStream);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StreamContext> call2(StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
            if (activeApplicationStream == null) {
                return new ScalarSynchronousObservable(null);
            }
            return StreamContextService.this.getForUser(activeApplicationStream.getStream().getOwnerId(), false);
        }
    }

    /* compiled from: StreamContextService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00060\u00062.\u0010\u0005\u001a*\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003 \u0004*\u0014\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/domain/ModelApplicationStream;", "kotlin.jvm.PlatformType", "allUserStreamsMap", "", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/Collection;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForAllStreamingUsers$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends ModelApplicationStream>, Collection<? extends ModelApplicationStream>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Collection<? extends ModelApplicationStream> call(Map<Long, ? extends ModelApplicationStream> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Collection<ModelApplicationStream> call2(Map<Long, ? extends ModelApplicationStream> map) {
            return map.values();
        }
    }

    /* compiled from: StreamContextService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001aj\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0002*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u0005 \u0002*4\u0012.\b\u0001\u0012*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0002*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lcom/discord/models/domain/ModelApplicationStream;", "kotlin.jvm.PlatformType", "allUserStreams", "Lrx/Observable;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/utilities/streams/StreamContext;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Collection;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForAllStreamingUsers$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Collection<? extends ModelApplicationStream>, Observable<? extends Map<Long, ? extends StreamContext>>> {

        /* compiled from: StreamContextService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a*\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007 \u0002*\u0014\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00040\u00042,\u0010\u0003\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "", "kotlin.jvm.PlatformType", "allUserStreamContexts", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/utilities/streams/StreamContext;", NotificationCompat.CATEGORY_CALL, "([Ljava/lang/Object;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForAllStreamingUsers$2$1, reason: invalid class name */
        public static final class AnonymousClass1<R> implements FuncN<Map<Long, ? extends StreamContext>> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // rx.functions.FuncN
            public /* bridge */ /* synthetic */ Map<Long, ? extends StreamContext> call(Object[] objArr) {
                return call2(objArr);
            }

            @Override // rx.functions.FuncN
            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, ? extends StreamContext> call2(Object[] objArr) {
                Intrinsics3.checkNotNullExpressionValue(objArr, "allUserStreamContexts");
                ArrayList arrayList = new ArrayList();
                for (Object obj : objArr) {
                    if (!(obj instanceof StreamContext)) {
                        obj = null;
                    }
                    StreamContext streamContext = (StreamContext) obj;
                    if (streamContext != null) {
                        arrayList.add(streamContext);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
                for (T t : arrayList) {
                    linkedHashMap.put(Long.valueOf(((StreamContext) t).getUser().getId()), t);
                }
                return linkedHashMap;
            }
        }

        public AnonymousClass2() {
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends StreamContext>> call(Collection<? extends ModelApplicationStream> collection) {
            return call2(collection);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Map<Long, StreamContext>> call2(Collection<? extends ModelApplicationStream> collection) {
            if (collection.isEmpty()) {
                return new ScalarSynchronousObservable(Maps6.emptyMap());
            }
            Intrinsics3.checkNotNullExpressionValue(collection, "allUserStreams");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(StreamContextService.this.getForUser(((ModelApplicationStream) it.next()).getOwnerId(), false));
            }
            return Observable.b(arrayList, AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: StreamContextService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u001e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003 \u0004*\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/domain/ModelApplicationStream;", "stream", "Lrx/Observable;", "Lcom/discord/utilities/streams/StreamContext;", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/domain/ModelApplicationStream;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelApplicationStream, Observable<? extends StreamContext>> {
        public final /* synthetic */ boolean $includePreview;
        public final /* synthetic */ long $userId;

        /* compiled from: StreamContextService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\t\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u000426\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "kotlin.jvm.PlatformType", "members", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/models/member/GuildMember;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02251<T, R> implements Func1<Map<Long, ? extends GuildMember>, GuildMember> {
            public C02251() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                return call2((Map<Long, GuildMember>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final GuildMember call2(Map<Long, GuildMember> map) {
                return map.get(Long.valueOf(AnonymousClass1.this.$userId));
            }
        }

        /* compiled from: StreamContextService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/member/GuildMember;)Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<GuildMember, String> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ String call(GuildMember guildMember) {
                return call2(guildMember);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final String call2(GuildMember guildMember) {
                if (guildMember != null) {
                    return guildMember.getNick();
                }
                return null;
            }
        }

        /* compiled from: StreamContextService.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0004j\u0002`\u000e\u0012\u0004\u0012\u00020\u000f0\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\u0010\u0014\u001a\u00060\u0004j\u0002`\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\n¢\u0006\u0004\b\u0018\u0010\u0019"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;", "preview", "", "Lcom/discord/api/permission/PermissionBit;", "channelPermissions", "Lcom/discord/models/user/User;", "user", "Lcom/discord/models/user/MeUser;", "me", "", "userNickname", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/api/voice/state/VoiceState;", "voiceStates", "Lcom/discord/api/channel/Channel;", "channel", "Lcom/discord/primitives/ChannelId;", "selectedVoiceChannelId", "Lcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;", "activeStream", "Lcom/discord/utilities/streams/StreamContext;", "invoke", "(Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreApplicationStreamPreviews$StreamPreview;Ljava/lang/Long;Lcom/discord/models/user/User;Lcom/discord/models/user/MeUser;Ljava/lang/String;Ljava/util/Map;Lcom/discord/api/channel/Channel;JLcom/discord/stores/StoreApplicationStreaming$ActiveApplicationStream;)Lcom/discord/utilities/streams/StreamContext;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.utilities.streams.StreamContextService$getForUser$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function10<Guild, StoreApplicationStreamPreviews.StreamPreview, Long, User, MeUser, String, Map<Long, ? extends VoiceState>, Channel, Long, StoreApplicationStreaming.ActiveApplicationStream, StreamContext> {
            public final /* synthetic */ ModelApplicationStream $stream;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(ModelApplicationStream modelApplicationStream) {
                super(10);
                this.$stream = modelApplicationStream;
            }

            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ StreamContext invoke(Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Long l, User user, MeUser meUser, String str, Map<Long, ? extends VoiceState> map, Channel channel, Long l2, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                return invoke(guild, streamPreview, l, user, meUser, str, (Map<Long, VoiceState>) map, channel, l2.longValue(), activeApplicationStream);
            }

            public final StreamContext invoke(Guild guild, StoreApplicationStreamPreviews.StreamPreview streamPreview, Long l, User user, MeUser meUser, String str, Map<Long, VoiceState> map, Channel channel, long j, StoreApplicationStreaming.ActiveApplicationStream activeApplicationStream) {
                Intrinsics3.checkNotNullParameter(meUser, "me");
                Intrinsics3.checkNotNullParameter(map, "voiceStates");
                if (((this.$stream instanceof ModelApplicationStream.GuildStream) && guild == null) || user == null) {
                    return null;
                }
                int userLimit = channel != null ? channel.getUserLimit() : 0;
                boolean z2 = userLimit > 0 && map.size() >= userLimit;
                return new StreamContext(this.$stream, guild, streamPreview, (!(this.$stream instanceof ModelApplicationStream.GuildStream) || PermissionUtils.can(Permission.CONNECT, l) || (channel != null && (channel.getId() > j ? 1 : (channel.getId() == j ? 0 : -1)) == 0)) ? (!z2 || PermissionUtils.can(16L, l)) ? StreamContext.Joinability.CAN_CONNECT : StreamContext.Joinability.VOICE_CHANNEL_FULL : StreamContext.Joinability.MISSING_PERMISSIONS, user, str, activeApplicationStream != null && activeApplicationStream.getState().isStreamActive() && Intrinsics3.areEqual(activeApplicationStream.getStream(), this.$stream), user.getId() == meUser.getId());
            }
        }

        public AnonymousClass1(boolean z2, long j) {
            this.$includePreview = z2;
            this.$userId = j;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends StreamContext> call(ModelApplicationStream modelApplicationStream) {
            return call2(modelApplicationStream);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends StreamContext> call2(ModelApplicationStream modelApplicationStream) {
            long guildId;
            if (modelApplicationStream == null) {
                return new ScalarSynchronousObservable(null);
            }
            if (modelApplicationStream instanceof ModelApplicationStream.GuildStream) {
                guildId = ((ModelApplicationStream.GuildStream) modelApplicationStream).getGuildId();
            } else {
                if (!(modelApplicationStream instanceof ModelApplicationStream.CallStream)) {
                    throw new NoWhenBranchMatchedException();
                }
                guildId = 0;
            }
            Observable<Guild> observableObserveGuild = StreamContextService.access$getGuildStore$p(StreamContextService.this).observeGuild(guildId);
            StreamContextService streamContextService = StreamContextService.this;
            Observable observableAccess$getPreviewObservable = StreamContextService.access$getPreviewObservable(streamContextService, modelApplicationStream, this.$includePreview, StreamContextService.access$getApplicationStreamPreviewStore$p(streamContextService));
            Observable<Long> observableObservePermissionsForChannel = StreamContextService.access$getPermissionsStore$p(StreamContextService.this).observePermissionsForChannel(modelApplicationStream.getChannelId());
            Observable<User> observableObserveUser = StreamContextService.access$getUserStore$p(StreamContextService.this).observeUser(this.$userId);
            Observable observableObserveMe$default = StoreUser.observeMe$default(StreamContextService.access$getUserStore$p(StreamContextService.this), false, 1, null);
            Observable<R> observableR = StreamContextService.access$getGuildStore$p(StreamContextService.this).observeComputed(guildId).G(new C02251()).G(AnonymousClass2.INSTANCE).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "guildStore\n             …  .distinctUntilChanged()");
            return ObservableCombineLatestOverloads2.combineLatest(observableObserveGuild, observableAccess$getPreviewObservable, observableObservePermissionsForChannel, observableObserveUser, observableObserveMe$default, observableR, StreamContextService.access$getVoiceStateStore$p(StreamContextService.this).observe(guildId, modelApplicationStream.getChannelId()), StreamContextService.access$getChannelStore$p(StreamContextService.this).observeChannel(modelApplicationStream.getChannelId()), StreamContextService.access$getVoiceChannelSelectedStore$p(StreamContextService.this).observeSelectedVoiceChannelId(), StreamContextService.access$getApplicationStreamingStore$p(StreamContextService.this).observeActiveStream(), new AnonymousClass3(modelApplicationStream));
        }
    }

    public StreamContextService() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "applicationStreamingStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeVoiceStates, "voiceStateStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelStore");
        Intrinsics3.checkNotNullParameter(storeApplicationStreamPreviews, "applicationStreamPreviewStore");
        this.applicationStreamingStore = storeApplicationStreaming;
        this.guildStore = storeGuilds;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.voiceStateStore = storeVoiceStates;
        this.channelStore = storeChannels;
        this.applicationStreamPreviewStore = storeApplicationStreamPreviews;
    }

    public static final /* synthetic */ StoreApplicationStreamPreviews access$getApplicationStreamPreviewStore$p(StreamContextService streamContextService) {
        return streamContextService.applicationStreamPreviewStore;
    }

    public static final /* synthetic */ StoreApplicationStreaming access$getApplicationStreamingStore$p(StreamContextService streamContextService) {
        return streamContextService.applicationStreamingStore;
    }

    public static final /* synthetic */ StoreChannels access$getChannelStore$p(StreamContextService streamContextService) {
        return streamContextService.channelStore;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildStore$p(StreamContextService streamContextService) {
        return streamContextService.guildStore;
    }

    public static final /* synthetic */ StorePermissions access$getPermissionsStore$p(StreamContextService streamContextService) {
        return streamContextService.permissionsStore;
    }

    public static final /* synthetic */ Observable access$getPreviewObservable(StreamContextService streamContextService, ModelApplicationStream modelApplicationStream, boolean z2, StoreApplicationStreamPreviews storeApplicationStreamPreviews) {
        return streamContextService.getPreviewObservable(modelApplicationStream, z2, storeApplicationStreamPreviews);
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StreamContextService streamContextService) {
        return streamContextService.userStore;
    }

    public static final /* synthetic */ StoreVoiceChannelSelected access$getVoiceChannelSelectedStore$p(StreamContextService streamContextService) {
        return streamContextService.voiceChannelSelectedStore;
    }

    public static final /* synthetic */ StoreVoiceStates access$getVoiceStateStore$p(StreamContextService streamContextService) {
        return streamContextService.voiceStateStore;
    }

    private final Observable<? extends StoreApplicationStreamPreviews.StreamPreview> getPreviewObservable(ModelApplicationStream stream, boolean includePreview, StoreApplicationStreamPreviews applicationStreamPreviewStore) {
        if (includePreview) {
            return applicationStreamPreviewStore.observeStreamPreview(stream);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
        return scalarSynchronousObservable;
    }

    public final Observable<StreamContext> getForActiveStream() {
        Observable observableY = this.applicationStreamingStore.observeActiveStream().Y(new AnonymousClass1());
        Intrinsics3.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  )\n          }\n        }");
        return observableY;
    }

    public final Observable<Map<Long, StreamContext>> getForAllStreamingUsers() {
        Observable<Map<Long, StreamContext>> observableY = this.applicationStreamingStore.observeStreamsByUser().G(AnonymousClass1.INSTANCE).Y(new AnonymousClass2());
        Intrinsics3.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public final Observable<StreamContext> getForUser(long userId, boolean includePreview) {
        Observable observableY = this.applicationStreamingStore.observeStreamsForUser(userId).Y(new AnonymousClass1(includePreview, userId));
        Intrinsics3.checkNotNullExpressionValue(observableY, "applicationStreamingStor…  }\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ StreamContextService(StoreApplicationStreaming storeApplicationStreaming, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreUser storeUser, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreVoiceStates storeVoiceStates, StoreChannels storeChannels, StoreApplicationStreamPreviews storeApplicationStreamPreviews, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getApplicationStreamPreviews() : storeApplicationStreamPreviews);
    }
}
