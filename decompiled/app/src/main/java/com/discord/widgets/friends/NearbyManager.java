package com.discord.widgets.friends;

import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.e.h.j.k;
import b.i.a.f.j.b.a;
import b.i.a.f.j.b.b;
import b.i.a.f.j.b.e.i;
import b.i.a.f.j.b.e.n;
import b.i.a.f.j.b.e.o;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: NearbyManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b5\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\n\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\u0012\u0010\u000bJ\u001b\u0010\u0013\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002¢\u0006\u0004\b\u0013\u0010\u000bJ\u0019\u0010\u0014\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u0014\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\r\u0010\u0016\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\rJ\r\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\rR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0019\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u001e\u0010%\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R.\u0010,\u001a\u001a\u0012\b\u0012\u00060\u0007j\u0002`\b0*j\f\u0012\b\u0012\u00060\u0007j\u0002`\b`+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R:\u00103\u001a&\u0012\f\u0012\n 2*\u0004\u0018\u00010\u001e0\u001e 2*\u0012\u0012\f\u0012\n 2*\u0004\u0018\u00010\u001e0\u001e\u0018\u000101018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/discord/widgets/friends/NearbyManager;", "", "Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "buildClient", "(Landroidx/fragment/app/FragmentActivity;)V", "", "Lcom/discord/primitives/UserId;", "userId", "setupBroadcaster", "(J)V", "setupListener", "()V", "Lcom/google/android/gms/nearby/messages/Message;", "message", "parseUserId", "(Lcom/google/android/gms/nearby/messages/Message;)Ljava/lang/Long;", "foundUserId", "lostUserId", "initialize", "buildClientAndPublish", "disableNearby", "activateNearby", "outboundMessage", "Lcom/google/android/gms/nearby/messages/Message;", "Lcom/google/android/gms/nearby/messages/PublishOptions;", "messagePublishOptions", "Lcom/google/android/gms/nearby/messages/PublishOptions;", "Lrx/Observable;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "getState", "()Lrx/Observable;", "state", "Lcom/google/android/gms/nearby/messages/MessagesClient;", "messagesClient", "Lcom/google/android/gms/nearby/messages/MessagesClient;", "meUserId", "Ljava/lang/Long;", "Lcom/google/android/gms/nearby/messages/MessageListener;", "messageListener", "Lcom/google/android/gms/nearby/messages/MessageListener;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "nearbyUserIds", "Ljava/util/HashSet;", "Lcom/google/android/gms/nearby/messages/SubscribeOptions;", "subscribeOptions", "Lcom/google/android/gms/nearby/messages/SubscribeOptions;", "Lrx/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "nearbyStateSubject", "Lrx/subjects/BehaviorSubject;", "<init>", "Companion", "NearbyState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NearbyManager {
    public static final int CONNECTION_ERROR = 99;
    public static final int PERMISSION_DENIED = 98;
    private Long meUserId;
    private MessageListener messageListener;
    private PublishOptions messagePublishOptions;
    private MessagesClient messagesClient;
    private Message outboundMessage;
    private SubscribeOptions subscribeOptions;
    private final HashSet<Long> nearbyUserIds = new HashSet<>();
    private final BehaviorSubject<NearbyState> nearbyStateSubject = BehaviorSubject.l0(NearbyState.Uninitialized.INSTANCE);

    /* compiled from: NearbyManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "", "<init>", "()V", "Connected", "Disconnected", "Uninitialized", "Lcom/discord/widgets/friends/NearbyManager$NearbyState$Uninitialized;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState$Disconnected;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState$Connected;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class NearbyState {

        /* compiled from: NearbyManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R#\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/friends/NearbyManager$NearbyState$Connected;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "", "", "Lcom/discord/primitives/UserId;", "component1", "()Ljava/util/Set;", "nearbyUserIds", "copy", "(Ljava/util/Set;)Lcom/discord/widgets/friends/NearbyManager$NearbyState$Connected;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Set;", "getNearbyUserIds", "<init>", "(Ljava/util/Set;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Connected extends NearbyState {
            private final Set<Long> nearbyUserIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Connected(Set<Long> set) {
                super(null);
                Intrinsics3.checkNotNullParameter(set, "nearbyUserIds");
                this.nearbyUserIds = set;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Connected copy$default(Connected connected, Set set, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = connected.nearbyUserIds;
                }
                return connected.copy(set);
            }

            public final Set<Long> component1() {
                return this.nearbyUserIds;
            }

            public final Connected copy(Set<Long> nearbyUserIds) {
                Intrinsics3.checkNotNullParameter(nearbyUserIds, "nearbyUserIds");
                return new Connected(nearbyUserIds);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Connected) && Intrinsics3.areEqual(this.nearbyUserIds, ((Connected) other).nearbyUserIds);
                }
                return true;
            }

            public final Set<Long> getNearbyUserIds() {
                return this.nearbyUserIds;
            }

            public int hashCode() {
                Set<Long> set = this.nearbyUserIds;
                if (set != null) {
                    return set.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.N(outline.U("Connected(nearbyUserIds="), this.nearbyUserIds, ")");
            }
        }

        /* compiled from: NearbyManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/friends/NearbyManager$NearbyState$Disconnected;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "", "component1", "()I", ModelAuditLogEntry.CHANGE_KEY_CODE, "copy", "(I)Lcom/discord/widgets/friends/NearbyManager$NearbyState$Disconnected;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCode", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Disconnected extends NearbyState {
            private final int code;

            public Disconnected(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Disconnected copy$default(Disconnected disconnected, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = disconnected.code;
                }
                return disconnected.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Disconnected copy(int code) {
                return new Disconnected(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Disconnected) && this.code == ((Disconnected) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return outline.B(outline.U("Disconnected(code="), this.code, ")");
            }
        }

        /* compiled from: NearbyManager.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/friends/NearbyManager$NearbyState$Uninitialized;", "Lcom/discord/widgets/friends/NearbyManager$NearbyState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends NearbyState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private NearbyState() {
        }

        public /* synthetic */ NearbyState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: NearbyManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/discord/widgets/friends/NearbyManager$setupBroadcaster$1", "Lb/i/a/f/j/b/b;", "", "onExpired", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.NearbyManager$setupBroadcaster$1, reason: invalid class name */
    public static final class AnonymousClass1 extends b {
        public AnonymousClass1() {
        }

        @Override // b.i.a.f.j.b.b
        public void onExpired() {
            super.onExpired();
            NearbyManager.this.activateNearby();
        }
    }

    /* compiled from: NearbyManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/discord/widgets/friends/NearbyManager$setupListener$1", "Lcom/google/android/gms/nearby/messages/MessageListener;", "Lcom/google/android/gms/nearby/messages/Message;", "message", "", "onFound", "(Lcom/google/android/gms/nearby/messages/Message;)V", "onLost", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.friends.NearbyManager$setupListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends MessageListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.gms.nearby.messages.MessageListener
        public void onFound(Message message) {
            Long lAccess$parseUserId;
            super.onFound(message);
            if (message == null || (lAccess$parseUserId = NearbyManager.access$parseUserId(NearbyManager.this, message)) == null) {
                return;
            }
            NearbyManager.access$foundUserId(NearbyManager.this, lAccess$parseUserId.longValue());
        }

        @Override // com.google.android.gms.nearby.messages.MessageListener
        public void onLost(Message message) {
            Long lAccess$parseUserId;
            super.onLost(message);
            if (message == null || (lAccess$parseUserId = NearbyManager.access$parseUserId(NearbyManager.this, message)) == null) {
                return;
            }
            NearbyManager.access$lostUserId(NearbyManager.this, lAccess$parseUserId.longValue());
        }
    }

    public static final /* synthetic */ void access$foundUserId(NearbyManager nearbyManager, long j) {
        nearbyManager.foundUserId(j);
    }

    public static final /* synthetic */ BehaviorSubject access$getNearbyStateSubject$p(NearbyManager nearbyManager) {
        return nearbyManager.nearbyStateSubject;
    }

    public static final /* synthetic */ HashSet access$getNearbyUserIds$p(NearbyManager nearbyManager) {
        return nearbyManager.nearbyUserIds;
    }

    public static final /* synthetic */ void access$lostUserId(NearbyManager nearbyManager, long j) {
        nearbyManager.lostUserId(j);
    }

    public static final /* synthetic */ Long access$parseUserId(NearbyManager nearbyManager, Message message) {
        return nearbyManager.parseUserId(message);
    }

    private final void buildClient(FragmentActivity fragmentActivity) {
        a aVar = new a(new a.C0042a(), null);
        AnimatableValueParser.z(fragmentActivity, "Activity must not be null");
        AnimatableValueParser.z(aVar, "Options must not be null");
        i iVar = new i(fragmentActivity, aVar);
        k kVarM = iVar.m(new NearbyManager2(this));
        iVar.k(kVarM, new n(kVarM), new o(kVarM));
        this.messagesClient = iVar;
    }

    private final synchronized void foundUserId(long userId) {
        Long l = this.meUserId;
        if (l == null || userId != l.longValue()) {
            this.nearbyUserIds.add(Long.valueOf(userId));
            this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
        }
    }

    private final synchronized void lostUserId(long userId) {
        this.nearbyUserIds.remove(Long.valueOf(userId));
        this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
    }

    private final Long parseUserId(Message message) {
        byte[] bArr = message.l;
        Intrinsics3.checkNotNullExpressionValue(bArr, "message.content");
        String str = new String(bArr, Charsets2.a);
        if (str.charAt(0) == 'u') {
            try {
                String strSubstring = str.substring(2);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                return Long.valueOf(Long.parseLong(strSubstring));
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private final void setupBroadcaster(long userId) {
        this.messagePublishOptions = new PublishOptions(Strategy.j, new AnonymousClass1(), null);
        String strT = outline.t("u:", userId);
        Charset charset = Charsets2.a;
        Objects.requireNonNull(strT, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strT.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        this.outboundMessage = new Message(2, bytes, "", "", Message.j, 0L);
    }

    private final void setupListener() {
        this.messageListener = new AnonymousClass1();
        Strategy strategy = Strategy.j;
        this.subscribeOptions = new SubscribeOptions(Strategy.k, MessageFilter.j, null);
    }

    public final void activateNearby() {
        Message message;
        PublishOptions publishOptions;
        MessageListener messageListener;
        SubscribeOptions subscribeOptions;
        MessagesClient messagesClient = this.messagesClient;
        if (messagesClient == null || (message = this.outboundMessage) == null || (publishOptions = this.messagePublishOptions) == null || (messageListener = this.messageListener) == null || (subscribeOptions = this.subscribeOptions) == null) {
            return;
        }
        this.nearbyStateSubject.onNext(new NearbyState.Connected(new HashSet(this.nearbyUserIds)));
        messagesClient.f(message, publishOptions);
        messagesClient.g(messageListener, subscribeOptions);
    }

    public final void buildClientAndPublish(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        if (this.messagesClient == null) {
            buildClient(fragmentActivity);
        }
        activateNearby();
    }

    public final void disableNearby() {
        Message message;
        MessageListener messageListener;
        MessagesClient messagesClient = this.messagesClient;
        if (messagesClient == null || (message = this.outboundMessage) == null || (messageListener = this.messageListener) == null) {
            return;
        }
        messagesClient.h(message);
        messagesClient.i(messageListener);
        this.nearbyUserIds.clear();
        this.nearbyStateSubject.onNext(NearbyState.Uninitialized.INSTANCE);
    }

    public final Observable<NearbyState> getState() {
        BehaviorSubject<NearbyState> behaviorSubject = this.nearbyStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "nearbyStateSubject");
        return behaviorSubject;
    }

    public final void initialize(long userId) {
        this.meUserId = Long.valueOf(userId);
        setupBroadcaster(userId);
        setupListener();
    }
}
