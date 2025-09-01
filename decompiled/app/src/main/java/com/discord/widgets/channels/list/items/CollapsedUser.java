package com.discord.widgets.channels.list.items;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CollapsedUser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u001c\u0010\u001c\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0015R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\nR\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u0012¨\u0006)"}, d2 = {"Lcom/discord/widgets/channels/list/items/CollapsedUser;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "", "component2", "()Z", "", "component3", "()J", "user", "emptySlot", "extraCount", "copy", "(Lcom/discord/models/user/User;ZJ)Lcom/discord/widgets/channels/list/items/CollapsedUser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/User;", "getUser", "type", "I", "getType", "J", "getExtraCount", "Z", "getEmptySlot", "key", "Ljava/lang/String;", "getKey", "<init>", "(Lcom/discord/models/user/User;ZJ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class CollapsedUser implements MGRecyclerDataPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean emptySlot;
    private final long extraCount;
    private final String key;
    private final int type;
    private final User user;

    /* compiled from: CollapsedUser.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/channels/list/items/CollapsedUser$Companion;", "", "", "extraCount", "Lcom/discord/widgets/channels/list/items/CollapsedUser;", "createEmptyUser", "(J)Lcom/discord/widgets/channels/list/items/CollapsedUser;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ CollapsedUser createEmptyUser$default(Companion companion, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return companion.createEmptyUser(j);
        }

        public final CollapsedUser createEmptyUser(long extraCount) {
            return new CollapsedUser(UserUtils.INSTANCE.getEMPTY_USER(), true, Math.min(99L, extraCount));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CollapsedUser(User user, boolean z2, long j) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.emptySlot = z2;
        this.extraCount = j;
        this.key = String.valueOf(user.getId());
    }

    public static /* synthetic */ CollapsedUser copy$default(CollapsedUser collapsedUser, User user, boolean z2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            user = collapsedUser.user;
        }
        if ((i & 2) != 0) {
            z2 = collapsedUser.emptySlot;
        }
        if ((i & 4) != 0) {
            j = collapsedUser.extraCount;
        }
        return collapsedUser.copy(user, z2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEmptySlot() {
        return this.emptySlot;
    }

    /* renamed from: component3, reason: from getter */
    public final long getExtraCount() {
        return this.extraCount;
    }

    public final CollapsedUser copy(User user, boolean emptySlot, long extraCount) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new CollapsedUser(user, emptySlot, extraCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollapsedUser)) {
            return false;
        }
        CollapsedUser collapsedUser = (CollapsedUser) other;
        return Intrinsics3.areEqual(this.user, collapsedUser.user) && this.emptySlot == collapsedUser.emptySlot && this.extraCount == collapsedUser.extraCount;
    }

    public final boolean getEmptySlot() {
        return this.emptySlot;
    }

    public final long getExtraCount() {
        return this.extraCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        boolean z2 = this.emptySlot;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return b.a(this.extraCount) + ((iHashCode + i) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CollapsedUser(user=");
        sbU.append(this.user);
        sbU.append(", emptySlot=");
        sbU.append(this.emptySlot);
        sbU.append(", extraCount=");
        return outline.C(sbU, this.extraCount, ")");
    }

    public /* synthetic */ CollapsedUser(User user, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 0L : j);
    }
}
