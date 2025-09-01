package com.discord.utilities.lazy.requester;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: GuildMemberRequestManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eBQ\u0012 \u0010\u001b\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012&\u0010\u0014\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\b0\u0013\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0006\u001a\u00060\u0005R\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010\t\u001a\u00060\u0002j\u0002`\b¢\u0006\u0004\b\u000f\u0010\fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eR6\u0010\u0014\u001a\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\b0\u0013\u0012\u0004\u0012\u00020\n0\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015RB\u0010\u0018\u001a.\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0005R\u00020\u00000\u0016j\u0016\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0005R\u00020\u0000`\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010\u001b\u001a\u001c\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\b\u0012\u00060\u0002j\u0002`\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager$GuildMemberRequestState;", "getGuildRequestState", "(J)Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager$GuildMemberRequestState;", "Lcom/discord/primitives/UserId;", "userId", "", "queueRequest", "(JJ)V", "requestUnacknowledged", "()V", "acknowledge", "flush", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "Lkotlin/Function2;", "", "onFlush", "Lkotlin/jvm/functions/Function2;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guildRequestStates", "Ljava/util/HashMap;", "", "guildMemberExists", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "GuildMemberRequestState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildMemberRequestManager {
    private final Function2<Long, Long, Boolean> guildMemberExists;
    private final HashMap<Long, GuildMemberRequestState> guildRequestStates;
    private final Function2<Long, List<Long>, Unit> onFlush;

    /* compiled from: GuildMemberRequestManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B+\u0012\n\u0010\u001b\u001a\u00060\u0002j\u0002`\u001a\u0012\u0016\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\n2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0010\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00050\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R1\u0010\u0014\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R1\u0010\u0018\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001b\u001a\u00060\u0002j\u0002`\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR1\u0010\u001d\u001a\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0012j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017¨\u0006!"}, d2 = {"Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager$GuildMemberRequestState;", "", "", "Lcom/discord/primitives/UserId;", "userId", "", "request", "(J)Z", "requestUnacknowledged", "()Z", "", "acknowledge", "(J)V", "flushRequests", "()V", "Lkotlin/Function1;", "guildMemberExists", "Lkotlin/jvm/functions/Function1;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "unacknowledgedRequests", "Ljava/util/HashSet;", "getUnacknowledgedRequests", "()Ljava/util/HashSet;", "sentRequests", "getSentRequests", "Lcom/discord/primitives/GuildId;", "guildId", "J", "pendingRequests", "getPendingRequests", "<init>", "(Lcom/discord/utilities/lazy/requester/GuildMemberRequestManager;JLkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public final class GuildMemberRequestState {
        private final long guildId;
        private final Function1<Long, Boolean> guildMemberExists;
        private final HashSet<Long> pendingRequests;
        private final HashSet<Long> sentRequests;
        public final /* synthetic */ GuildMemberRequestManager this$0;
        private final HashSet<Long> unacknowledgedRequests;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildMemberRequestState(GuildMemberRequestManager guildMemberRequestManager, long j, Function1<? super Long, Boolean> function1) {
            Intrinsics3.checkNotNullParameter(function1, "guildMemberExists");
            this.this$0 = guildMemberRequestManager;
            this.guildId = j;
            this.guildMemberExists = function1;
            this.pendingRequests = new HashSet<>();
            this.sentRequests = new HashSet<>();
            this.unacknowledgedRequests = new HashSet<>();
        }

        public final void acknowledge(long userId) {
            this.unacknowledgedRequests.remove(Long.valueOf(userId));
            this.pendingRequests.remove(Long.valueOf(userId));
        }

        public final void flushRequests() {
            HashSet hashSet = new HashSet();
            Iterator<Long> it = this.pendingRequests.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                Function1<Long, Boolean> function1 = this.guildMemberExists;
                Intrinsics3.checkNotNullExpressionValue(next, "userId");
                if (!function1.invoke(next).booleanValue()) {
                    this.unacknowledgedRequests.add(next);
                    this.sentRequests.add(next);
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                GuildMemberRequestManager.access$getOnFlush$p(this.this$0).invoke(Long.valueOf(this.guildId), _Collections.toList(hashSet));
            }
            this.pendingRequests.clear();
        }

        public final HashSet<Long> getPendingRequests() {
            return this.pendingRequests;
        }

        public final HashSet<Long> getSentRequests() {
            return this.sentRequests;
        }

        public final HashSet<Long> getUnacknowledgedRequests() {
            return this.unacknowledgedRequests;
        }

        public final boolean request(long userId) {
            if (this.sentRequests.contains(Long.valueOf(userId)) || this.pendingRequests.contains(Long.valueOf(userId)) || this.guildMemberExists.invoke(Long.valueOf(userId)).booleanValue()) {
                return false;
            }
            this.pendingRequests.add(Long.valueOf(userId));
            return true;
        }

        public final boolean requestUnacknowledged() {
            if (this.unacknowledgedRequests.isEmpty()) {
                return false;
            }
            Iterator<Long> it = this.unacknowledgedRequests.iterator();
            Intrinsics3.checkNotNullExpressionValue(it, "unacknowledgedRequests.iterator()");
            while (it.hasNext()) {
                Long next = it.next();
                Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
                long jLongValue = next.longValue();
                if (this.guildMemberExists.invoke(Long.valueOf(jLongValue)).booleanValue()) {
                    it.remove();
                } else {
                    this.pendingRequests.add(Long.valueOf(jLongValue));
                }
            }
            return !this.pendingRequests.isEmpty();
        }
    }

    /* compiled from: GuildMemberRequestManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "", "invoke", "(J)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.lazy.requester.GuildMemberRequestManager$getGuildRequestState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            return ((Boolean) GuildMemberRequestManager.access$getGuildMemberExists$p(GuildMemberRequestManager.this).invoke(Long.valueOf(this.$guildId), Long.valueOf(j))).booleanValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberRequestManager(Function2<? super Long, ? super Long, Boolean> function2, Function2<? super Long, ? super List<Long>, Unit> function22) {
        Intrinsics3.checkNotNullParameter(function2, "guildMemberExists");
        Intrinsics3.checkNotNullParameter(function22, "onFlush");
        this.guildMemberExists = function2;
        this.onFlush = function22;
        this.guildRequestStates = new HashMap<>();
    }

    public static final /* synthetic */ Function2 access$getGuildMemberExists$p(GuildMemberRequestManager guildMemberRequestManager) {
        return guildMemberRequestManager.guildMemberExists;
    }

    public static final /* synthetic */ Function2 access$getOnFlush$p(GuildMemberRequestManager guildMemberRequestManager) {
        return guildMemberRequestManager.onFlush;
    }

    private final GuildMemberRequestState getGuildRequestState(long guildId) {
        GuildMemberRequestState guildMemberRequestState = this.guildRequestStates.get(Long.valueOf(guildId));
        if (guildMemberRequestState != null) {
            return guildMemberRequestState;
        }
        GuildMemberRequestState guildMemberRequestState2 = new GuildMemberRequestState(this, guildId, new AnonymousClass1(guildId));
        this.guildRequestStates.put(Long.valueOf(guildId), guildMemberRequestState2);
        return guildMemberRequestState2;
    }

    public final void acknowledge(long guildId, long userId) {
        getGuildRequestState(guildId).acknowledge(userId);
    }

    public final void flush() {
        Iterator<GuildMemberRequestState> it = this.guildRequestStates.values().iterator();
        while (it.hasNext()) {
            it.next().flushRequests();
        }
    }

    public final void queueRequest(long guildId, long userId) {
        getGuildRequestState(guildId).request(userId);
    }

    public final void requestUnacknowledged() {
        Collection<GuildMemberRequestState> collectionValues = this.guildRequestStates.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "guildRequestStates.values");
        int i = 0;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((GuildMemberRequestState) it.next()).requestUnacknowledged() && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        if (i > 0) {
            flush();
        }
    }

    public final void reset() {
        this.guildRequestStates.clear();
    }
}
