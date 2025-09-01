package com.discord.widgets.botuikit.views.select;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: SelectComponentBottomSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\n\u0010\u000f\u001a\u00060\u0002j\u0002`\u0006\u0012\n\u0010\u0010\u001a\u00060\u0002j\u0002`\t\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\u0010\u0012\u001a\u00060\u0002j\u0002`\f¢\u0006\u0004\b'\u0010(J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0007\u001a\u00060\u0002j\u0002`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\n\u001a\u00060\u0002j\u0002`\tHÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0014\u0010\r\u001a\u00060\u0002j\u0002`\fHÆ\u0003¢\u0006\u0004\b\r\u0010\bJX\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\f\b\u0002\u0010\u000f\u001a\u00060\u0002j\u0002`\u00062\f\b\u0002\u0010\u0010\u001a\u00060\u0002j\u0002`\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\f\b\u0002\u0010\u0012\u001a\u00060\u0002j\u0002`\fHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\u000e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\u0005R\u001d\u0010\u000f\u001a\u00060\u0002j\u0002`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b$\u0010\u0005R\u001d\u0010\u0012\u001a\u00060\u0002j\u0002`\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b%\u0010\bR\u001d\u0010\u0010\u001a\u00060\u0002j\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/ComponentContext;", "Ljava/io/Serializable;", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/lang/Long;", "Lcom/discord/primitives/MessageId;", "component2", "()J", "Lcom/discord/primitives/ChannelId;", "component3", "component4", "Lcom/discord/primitives/ApplicationId;", "component5", "guildId", "messageId", "channelId", "messageFlags", "applicationId", "copy", "(Ljava/lang/Long;JJLjava/lang/Long;J)Lcom/discord/widgets/botuikit/views/select/ComponentContext;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getGuildId", "J", "getMessageId", "getMessageFlags", "getApplicationId", "getChannelId", "<init>", "(Ljava/lang/Long;JJLjava/lang/Long;J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.botuikit.views.select.ComponentContext, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class SelectComponentBottomSheet2 implements Serializable {
    private final long applicationId;
    private final long channelId;
    private final Long guildId;
    private final Long messageFlags;
    private final long messageId;

    public SelectComponentBottomSheet2(Long l, long j, long j2, Long l2, long j3) {
        this.guildId = l;
        this.messageId = j;
        this.channelId = j2;
        this.messageFlags = l2;
        this.applicationId = j3;
    }

    public static /* synthetic */ SelectComponentBottomSheet2 copy$default(SelectComponentBottomSheet2 selectComponentBottomSheet2, Long l, long j, long j2, Long l2, long j3, int i, Object obj) {
        return selectComponentBottomSheet2.copy((i & 1) != 0 ? selectComponentBottomSheet2.guildId : l, (i & 2) != 0 ? selectComponentBottomSheet2.messageId : j, (i & 4) != 0 ? selectComponentBottomSheet2.channelId : j2, (i & 8) != 0 ? selectComponentBottomSheet2.messageFlags : l2, (i & 16) != 0 ? selectComponentBottomSheet2.applicationId : j3);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getMessageFlags() {
        return this.messageFlags;
    }

    /* renamed from: component5, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    public final SelectComponentBottomSheet2 copy(Long guildId, long messageId, long channelId, Long messageFlags, long applicationId) {
        return new SelectComponentBottomSheet2(guildId, messageId, channelId, messageFlags, applicationId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectComponentBottomSheet2)) {
            return false;
        }
        SelectComponentBottomSheet2 selectComponentBottomSheet2 = (SelectComponentBottomSheet2) other;
        return Intrinsics3.areEqual(this.guildId, selectComponentBottomSheet2.guildId) && this.messageId == selectComponentBottomSheet2.messageId && this.channelId == selectComponentBottomSheet2.channelId && Intrinsics3.areEqual(this.messageFlags, selectComponentBottomSheet2.messageFlags) && this.applicationId == selectComponentBottomSheet2.applicationId;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Long getGuildId() {
        return this.guildId;
    }

    public final Long getMessageFlags() {
        return this.messageFlags;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public int hashCode() {
        Long l = this.guildId;
        int iA = (b.a(this.channelId) + ((b.a(this.messageId) + ((l != null ? l.hashCode() : 0) * 31)) * 31)) * 31;
        Long l2 = this.messageFlags;
        return b.a(this.applicationId) + ((iA + (l2 != null ? l2.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ComponentContext(guildId=");
        sbU.append(this.guildId);
        sbU.append(", messageId=");
        sbU.append(this.messageId);
        sbU.append(", channelId=");
        sbU.append(this.channelId);
        sbU.append(", messageFlags=");
        sbU.append(this.messageFlags);
        sbU.append(", applicationId=");
        return outline.C(sbU, this.applicationId, ")");
    }
}
