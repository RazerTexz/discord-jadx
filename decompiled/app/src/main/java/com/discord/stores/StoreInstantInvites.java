package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionInviteResolve;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreInstantInvites.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001>B#\u0012\u0006\u0010:\u001a\u000209\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u00101\u001a\u000200¢\u0006\u0004\b<\u0010=J+\u0010\u0007\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0002H\u0002¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00022\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0007\u0010\u0015J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u001b\u0010\u001cJQ\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00052\u0010\b\u0002\u0010\u001f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b*\u0010\u001cJ\u000f\u0010+\u001a\u00020\rH\u0016¢\u0006\u0004\b+\u0010,R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R2\u0010/\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R2\u00104\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000603038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010.R\"\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010.R\u0016\u00107\u001a\u0002068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006?"}, d2 = {"Lcom/discord/stores/StoreInstantInvites;", "Lcom/discord/stores/StoreV2;", "", "", "Lcom/discord/primitives/GuildId;", "", "Lcom/discord/models/domain/ModelInvite;", "getInvites", "()Ljava/util/Map;", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "getKnownInvites", "", "updatedInvites", "", "onLoadedInvites", "(Ljava/util/List;)V", "inviteKey", "inviteState", "setChatInvites", "(Ljava/lang/String;Lcom/discord/stores/StoreInstantInvites$InviteState;)V", "guildId", "(J)Ljava/util/Map;", "Lrx/Observable;", "observeInvite", "(Ljava/lang/String;)Lrx/Observable;", "observeKnownInvites", "()Lrx/Observable;", "fetchGuildInvites", "(J)V", "inviteCode", "Lcom/discord/primitives/GuildScheduledEventId;", "eventId", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "", "inviteResolved", "Lkotlin/Function0;", "onError", "fetchInviteIfNotLoaded", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function0;)V", "invite", "onInviteRemoved", "(Lcom/discord/models/domain/ModelInvite;)V", "clearInvites", "snapshotData", "()V", "knownInvitesSnapshot", "Ljava/util/Map;", "invitesSnapshot", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "invites", "knownInvites", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/Dispatcher;Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/utilities/rest/RestAPI;)V", "InviteState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreInstantInvites extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<String, ModelInvite>> invites;
    private Map<Long, ? extends Map<String, ? extends ModelInvite>> invitesSnapshot;
    private final Map<String, InviteState> knownInvites;
    private Map<String, ? extends InviteState> knownInvitesSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState;", "", "<init>", "()V", "Invalid", "LoadFailed", "Loading", "Resolved", "Lcom/discord/stores/StoreInstantInvites$InviteState$Loading;", "Lcom/discord/stores/StoreInstantInvites$InviteState$LoadFailed;", "Lcom/discord/stores/StoreInstantInvites$InviteState$Invalid;", "Lcom/discord/stores/StoreInstantInvites$InviteState$Resolved;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class InviteState {

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState$Invalid;", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends InviteState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState$LoadFailed;", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class LoadFailed extends InviteState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState$Loading;", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends InviteState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/stores/StoreInstantInvites$InviteState$Resolved;", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "Lcom/discord/models/domain/ModelInvite;", "component1", "()Lcom/discord/models/domain/ModelInvite;", "invite", "copy", "(Lcom/discord/models/domain/ModelInvite;)Lcom/discord/stores/StoreInstantInvites$InviteState$Resolved;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "<init>", "(Lcom/discord/models/domain/ModelInvite;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Resolved extends InviteState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelInvite modelInvite) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = resolved.invite;
                }
                return resolved.copy(modelInvite);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Resolved copy(ModelInvite invite) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Resolved(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.invite, ((Resolved) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Resolved(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private InviteState() {
        }

        public /* synthetic */ InviteState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            iArr[Error.Type.DISCORD_REQUEST_ERROR.ordinal()] = 1;
            iArr[Error.Type.NETWORK.ordinal()] = 2;
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$clearInvites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreInstantInvites.access$getInvites$p(StoreInstantInvites.this).get(Long.valueOf(this.$guildId));
            if (map != null) {
                map.clear();
            }
            StoreInstantInvites.this.markChanged();
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/models/domain/ModelInvite;", "invites", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelInvite>, Unit> {

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01411 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $invites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01411(List list) {
                super(0);
                this.$invites = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreInstantInvites.access$onLoadedInvites(StoreInstantInvites.this, this.$invites);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelInvite> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelInvite> list) {
            Intrinsics3.checkNotNullParameter(list, "invites");
            StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new C01411(list));
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ String $inviteCode;
        public final /* synthetic */ String $inviteKey;
        public final /* synthetic */ Boolean $inviteResolved;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function0 $onError;

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "invoke", "(Lcom/discord/models/domain/ModelInvite;)Lcom/discord/analytics/generated/traits/TrackNetworkMetadataReceiver;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01421 extends Lambda implements Function1<ModelInvite, TrackNetworkMetadata2> {
            public C01421() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ModelInvite modelInvite) {
                return invoke2(modelInvite);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(ModelInvite modelInvite) {
                User inviter;
                Channel channel;
                Channel channel2;
                Guild guild;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                return new TrackNetworkActionInviteResolve(anonymousClass1.$inviteResolved, anonymousClass1.$inviteCode, Boolean.valueOf(StoreStream.INSTANCE.getAuthentication().isAuthed()), (modelInvite == null || (guild = modelInvite.guild) == null) ? null : Long.valueOf(guild.getId()), (modelInvite == null || (channel2 = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel2.getId()), (modelInvite == null || (channel = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel.getType()), (modelInvite == null || (inviter = modelInvite.getInviter()) == null) ? null : Long.valueOf(inviter.getId()), modelInvite != null ? Long.valueOf(modelInvite.getApproximateMemberCount()) : null, modelInvite != null ? Long.valueOf(modelInvite.getApproximatePresenceCount()) : null, modelInvite != null ? modelInvite.getInviteType() : null, null, modelInvite != null ? Boolean.valueOf(Intrinsics3.areEqual(modelInvite.code, String.valueOf(RestAPIAbortCodes.USER_BANNED))) : null, null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelInvite;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelInvite;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<ModelInvite, Unit> {

            /* compiled from: StoreInstantInvites.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C01431 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelInvite $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C01431(ModelInvite modelInvite) {
                    super(0);
                    this.$it = modelInvite;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, new InviteState.Resolved(this.$it));
                    GuildScheduledEvent guildScheduledEvent = this.$it.getGuildScheduledEvent();
                    if (guildScheduledEvent != null) {
                        StoreGuildScheduledEvents guildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
                        Intrinsics3.checkNotNullExpressionValue(guildScheduledEvent, "event");
                        guildScheduledEvents.addGuildScheduledEventFromInvite(guildScheduledEvent);
                    }
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                invoke2(modelInvite);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                Intrinsics3.checkNotNullParameter(modelInvite, "it");
                StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new C01431(modelInvite));
                String str = AnonymousClass1.this.$location;
                if (str != null) {
                    AnalyticsTracker.INSTANCE.inviteResolved(modelInvite, str);
                }
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "error", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreInstantInvites.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1, reason: invalid class name and collision with other inner class name */
            public static final class C01441 extends Lambda implements Function0<Unit> {
                public C01441() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.Invalid.INSTANCE);
                }
            }

            /* compiled from: StoreInstantInvites.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$2, reason: invalid class name */
            public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.LoadFailed.INSTANCE);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Function0 function0 = AnonymousClass1.this.$onError;
                if (function0 != null) {
                }
                int iOrdinal = error.getType().ordinal();
                if (iOrdinal != 3) {
                    if (iOrdinal != 11) {
                        return;
                    }
                    StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new AnonymousClass2());
                    return;
                }
                error.setShowErrorToasts(false);
                StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new C01441());
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                String str = anonymousClass1.$location;
                if (str != null) {
                    String str2 = anonymousClass1.$inviteCode;
                    Error.Response response = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                    String message = response.getMessage();
                    Error.Response response2 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                    AnalyticsTracker.inviteResolveFailed(str2, str, message, Integer.valueOf(response2.getCode()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, Long l, Boolean bool, String str3, Function0 function0) {
            super(0);
            this.$inviteKey = str;
            this.$inviteCode = str2;
            this.$eventId = l;
            this.$inviteResolved = bool;
            this.$location = str3;
            this.$onError = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreInstantInvites.access$getKnownInvites$p(StoreInstantInvites.this).containsKey(this.$inviteKey) || (StoreInstantInvites.access$getKnownInvites$p(StoreInstantInvites.this).get(this.$inviteKey) instanceof InviteState.LoadFailed)) {
                AnalyticsTracker.inviteOpened(this.$inviteCode);
                StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                String str = this.$inviteKey;
                Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.Loading.INSTANCE);
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(StoreInstantInvites.access$getRestAPI$p(StoreInstantInvites.this).getInviteCode(this.$inviteCode, true, this.$eventId), new C01421()), false, 1, null), StoreInstantInvites.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
            }
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$observeInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends InviteState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends InviteState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends InviteState> invoke2() {
            return StoreInstantInvites.access$getKnownInvites(StoreInstantInvites.this);
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0007\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "kotlin.jvm.PlatformType", "knownInvites", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Lcom/discord/stores/StoreInstantInvites$InviteState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$observeInvite$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<Map<String, ? extends InviteState>, InviteState> {
        public final /* synthetic */ String $inviteKey;

        public AnonymousClass2(String str) {
            this.$inviteKey = str;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ InviteState call(Map<String, ? extends InviteState> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final InviteState call2(Map<String, ? extends InviteState> map) {
            InviteState inviteState = map.get(this.$inviteKey);
            return inviteState != null ? inviteState : InviteState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "", "Lcom/discord/stores/StoreInstantInvites$InviteState;", "invoke", "()Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$observeKnownInvites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Map<String, ? extends InviteState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends InviteState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends InviteState> invoke2() {
            return StoreInstantInvites.access$getKnownInvites(StoreInstantInvites.this);
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreInstantInvites$onInviteRemoved$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelInvite $invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite) {
            super(0);
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map;
            Guild guild = this.$invite.guild;
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            String str = this.$invite.code;
            if (lValueOf == null || (map = (Map) StoreInstantInvites.access$getInvites$p(StoreInstantInvites.this).get(lValueOf)) == null || ((ModelInvite) map.remove(str)) == null) {
                return;
            }
            StoreInstantInvites.this.markChanged();
        }
    }

    public /* synthetic */ StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.dispatcher;
    }

    public static final /* synthetic */ Map access$getInvites$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.invites;
    }

    public static final /* synthetic */ Map access$getKnownInvites(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.getKnownInvites();
    }

    public static final /* synthetic */ Map access$getKnownInvites$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.knownInvites;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.restAPI;
    }

    public static final /* synthetic */ void access$onLoadedInvites(StoreInstantInvites storeInstantInvites, List list) {
        storeInstantInvites.onLoadedInvites(list);
    }

    public static final /* synthetic */ void access$setChatInvites(StoreInstantInvites storeInstantInvites, String str, InviteState inviteState) {
        storeInstantInvites.setChatInvites(str, inviteState);
    }

    public static /* synthetic */ void fetchInviteIfNotLoaded$default(StoreInstantInvites storeInstantInvites, String str, Long l, String str2, Boolean bool, Function0 function0, int i, Object obj) {
        storeInstantInvites.fetchInviteIfNotLoaded(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : function0);
    }

    private final Map<Long, Map<String, ModelInvite>> getInvites() {
        return this.invitesSnapshot;
    }

    private final Map<String, InviteState> getKnownInvites() {
        return this.knownInvitesSnapshot;
    }

    @Store3
    private final void onLoadedInvites(List<? extends ModelInvite> updatedInvites) {
        this.invites.clear();
        for (ModelInvite modelInvite : updatedInvites) {
            Guild guild = modelInvite.guild;
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            if (lValueOf != null) {
                Map<String, ModelInvite> linkedHashMap = this.invites.get(lValueOf);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                String str = modelInvite.code;
                Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
                linkedHashMap.put(str, modelInvite);
                this.invites.put(lValueOf, linkedHashMap);
            }
        }
        markChanged();
    }

    @Store3
    private final void setChatInvites(String inviteKey, InviteState inviteState) {
        this.knownInvites.put(inviteKey, inviteState);
        markChanged();
    }

    public final void clearInvites(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void fetchGuildInvites(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildInvites(guildId), false, 1, null), StoreInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void fetchInviteIfNotLoaded(String inviteCode, Long eventId, String location, Boolean inviteResolved, Function0<Unit> onError) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        this.dispatcher.schedule(new AnonymousClass1(ModelInvite.getInviteStoreKey(inviteCode, eventId), inviteCode, eventId, inviteResolved, location, onError));
    }

    public final Observable<InviteState> observeInvite(String inviteKey) {
        if (inviteKey == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(InviteState.LoadFailed.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(InviteState.LoadFailed)");
            return scalarSynchronousObservable;
        }
        Observable<InviteState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new AnonymousClass2(inviteKey)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<String, InviteState>> observeKnownInvites() {
        Observable<Map<String, InviteState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onInviteRemoved(ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        this.dispatcher.schedule(new AnonymousClass1(invite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<String, ModelInvite>> entry : this.invites.entrySet()) {
            linkedHashMap.put(Long.valueOf(entry.getKey().longValue()), new HashMap(entry.getValue()));
        }
        this.invitesSnapshot = linkedHashMap;
        this.knownInvitesSnapshot = new HashMap(this.knownInvites);
    }

    public final Map<String, ModelInvite> getInvites(long guildId) {
        Map<String, ModelInvite> map = getInvites().get(Long.valueOf(guildId));
        return map != null ? map : Maps6.emptyMap();
    }

    public StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.invites = new LinkedHashMap();
        this.invitesSnapshot = Maps6.emptyMap();
        this.knownInvites = new LinkedHashMap();
        this.knownInvitesSnapshot = Maps6.emptyMap();
    }
}
