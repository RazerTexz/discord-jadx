package com.discord.models.application;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.message.Message;
import d0.t.ReversedViews3;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Unread.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0002 !B\u001d\b\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u001bB\u001f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b\u001a\u0010\u001fJ\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\n\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\t¨\u0006\""}, d2 = {"Lcom/discord/models/application/Unread;", "", "createWithEmptyCount", "()Lcom/discord/models/application/Unread;", "Lcom/discord/models/application/Unread$Marker;", "component1", "()Lcom/discord/models/application/Unread$Marker;", "", "component2", "()I", "marker", "count", "copy", "(Lcom/discord/models/application/Unread$Marker;I)Lcom/discord/models/application/Unread;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/application/Unread$Marker;", "getMarker", "I", "getCount", "<init>", "(Lcom/discord/models/application/Unread$Marker;I)V", "", "Lcom/discord/models/message/Message;", "messages", "(Lcom/discord/models/application/Unread$Marker;Ljava/util/List;)V", "Companion", "Marker", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final /* data */ class Unread {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int count;
    private final Marker marker;

    /* compiled from: Unread.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/models/application/Unread$Companion;", "", "Lcom/discord/models/application/Unread$Marker;", "marker", "", "Lcom/discord/models/message/Message;", "messages", "", "getTotalMessages", "(Lcom/discord/models/application/Unread$Marker;Ljava/util/List;)I", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$getTotalMessages(Companion companion, Marker marker, List list) {
            return companion.getTotalMessages(marker, list);
        }

        private final int getTotalMessages(Marker marker, List<Message> messages) {
            int i = 0;
            if (!messages.isEmpty() && marker.getMessageId() != null) {
                Iterator it = ReversedViews3.asReversed(messages).iterator();
                while (it.hasNext()) {
                    long id2 = ((Message) it.next()).getId();
                    Long messageId = marker.getMessageId();
                    if (messageId != null && id2 == messageId.longValue()) {
                        return i;
                    }
                    i++;
                }
            }
            return i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Unread.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001b\u0010\u001cB\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001dB1\b\u0016\u0012\n\u0010\t\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\n\u001a\u00060\u0002j\u0002`\u0006\u0012\u000e\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u001b\u0010\u001fJ\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u00060\u0002j\u0002`\u00032\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R!\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001d\u0010\t\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005¨\u0006 "}, d2 = {"Lcom/discord/models/application/Unread$Marker;", "", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "Lcom/discord/primitives/MessageId;", "component2", "()Ljava/lang/Long;", "channelId", "messageId", "copy", "(JLjava/lang/Long;)Lcom/discord/models/application/Unread$Marker;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getMessageId", "J", "getChannelId", "<init>", "(JLjava/lang/Long;)V", "()V", "mostRecentMessageId", "(JJLjava/lang/Long;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Marker {
        private final long channelId;
        private final Long messageId;

        public Marker(long j, Long l) {
            this.channelId = j;
            this.messageId = l;
        }

        public static /* synthetic */ Marker copy$default(Marker marker, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = marker.channelId;
            }
            if ((i & 2) != 0) {
                l = marker.messageId;
            }
            return marker.copy(j, l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        public final Marker copy(long channelId, Long messageId) {
            return new Marker(channelId, messageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Marker)) {
                return false;
            }
            Marker marker = (Marker) other;
            return this.channelId == marker.channelId && Intrinsics3.areEqual(this.messageId, marker.messageId);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            Long l = this.messageId;
            return iA + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Marker(channelId=");
            sbU.append(this.channelId);
            sbU.append(", messageId=");
            return outline.G(sbU, this.messageId, ")");
        }

        public Marker() {
            this(0L, 0L);
        }

        public Marker(long j, long j2, Long l) {
            this(j, (l == null || l.longValue() != j2) ? Long.valueOf(j2) : null);
        }
    }

    public Unread() {
        this(null, 0, 3, null);
    }

    public Unread(Marker marker) {
        this(marker, 0, 2, null);
    }

    public Unread(Marker marker, int i) {
        Intrinsics3.checkNotNullParameter(marker, "marker");
        this.marker = marker;
        this.count = i;
    }

    public static /* synthetic */ Unread copy$default(Unread unread, Marker marker, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            marker = unread.marker;
        }
        if ((i2 & 2) != 0) {
            i = unread.count;
        }
        return unread.copy(marker, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Marker getMarker() {
        return this.marker;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final Unread copy(Marker marker, int count) {
        Intrinsics3.checkNotNullParameter(marker, "marker");
        return new Unread(marker, count);
    }

    public final Unread createWithEmptyCount() {
        return new Unread(this.marker, 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Unread)) {
            return false;
        }
        Unread unread = (Unread) other;
        return Intrinsics3.areEqual(this.marker, unread.marker) && this.count == unread.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final Marker getMarker() {
        return this.marker;
    }

    public int hashCode() {
        Marker marker = this.marker;
        return ((marker != null ? marker.hashCode() : 0) * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Unread(marker=");
        sbU.append(this.marker);
        sbU.append(", count=");
        return outline.B(sbU, this.count, ")");
    }

    public /* synthetic */ Unread(Marker marker, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Marker() : marker, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Unread(Marker marker, List<Message> list) {
        this(marker, Companion.access$getTotalMessages(INSTANCE, marker, list));
        Intrinsics3.checkNotNullParameter(marker, "marker");
        Intrinsics3.checkNotNullParameter(list, "messages");
    }
}
