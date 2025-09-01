package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ForumPostReadState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB#\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ2\u0010\r\u001a\u00020\u00002\f\b\u0002\u0010\n\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\n\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\b¨\u0006 "}, d2 = {"Lcom/discord/widgets/forums/ForumPostReadState;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Z", "component3", "channelId", "hasSeenBefore", "hasUnread", "copy", "(JZZ)Lcom/discord/widgets/forums/ForumPostReadState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "getChannelId", "Z", "getHasSeenBefore", "getHasUnread", "<init>", "(JZZ)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class ForumPostReadState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final boolean hasSeenBefore;
    private final boolean hasUnread;

    /* compiled from: ForumPostReadState.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/widgets/forums/ForumPostReadState$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/widgets/forums/ForumPostReadState;", "createDefault", "(J)Lcom/discord/widgets/forums/ForumPostReadState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final ForumPostReadState createDefault(long channelId) {
            return new ForumPostReadState(channelId, true, false);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ForumPostReadState(long j, boolean z2, boolean z3) {
        this.channelId = j;
        this.hasSeenBefore = z2;
        this.hasUnread = z3;
    }

    public static /* synthetic */ ForumPostReadState copy$default(ForumPostReadState forumPostReadState, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = forumPostReadState.channelId;
        }
        if ((i & 2) != 0) {
            z2 = forumPostReadState.hasSeenBefore;
        }
        if ((i & 4) != 0) {
            z3 = forumPostReadState.hasUnread;
        }
        return forumPostReadState.copy(j, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasSeenBefore() {
        return this.hasSeenBefore;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasUnread() {
        return this.hasUnread;
    }

    public final ForumPostReadState copy(long channelId, boolean hasSeenBefore, boolean hasUnread) {
        return new ForumPostReadState(channelId, hasSeenBefore, hasUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumPostReadState)) {
            return false;
        }
        ForumPostReadState forumPostReadState = (ForumPostReadState) other;
        return this.channelId == forumPostReadState.channelId && this.hasSeenBefore == forumPostReadState.hasSeenBefore && this.hasUnread == forumPostReadState.hasUnread;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getHasSeenBefore() {
        return this.hasSeenBefore;
    }

    public final boolean getHasUnread() {
        return this.hasUnread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        boolean z2 = this.hasSeenBefore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        boolean z3 = this.hasUnread;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ForumPostReadState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", hasSeenBefore=");
        sbU.append(this.hasSeenBefore);
        sbU.append(", hasUnread=");
        return outline.O(sbU, this.hasUnread, ")");
    }
}
