package com.discord.widgets.chat.list.entries;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;

/* compiled from: StartOfPrivateChatEntry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0018\u001a\u00020\r\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b0\u00101J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JX\u0010\u001a\u001a\u00020\u00002\f\b\u0002\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\r2\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\bJ\u0010\u0010\u001d\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u000bJ\u001a\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0018\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b\u0018\u0010\u000fR\u001f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010#\u001a\u0004\b$\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010\bR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b'\u0010\bR\u0019\u0010\u0016\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\u000bR\u001c\u0010*\u001a\u00020\t8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b*\u0010(\u001a\u0004\b+\u0010\u000bR\u001c\u0010,\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b-\u0010\bR\u001d\u0010\u0014\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010.\u001a\u0004\b/\u0010\u0005¨\u00062"}, d2 = {"Lcom/discord/widgets/chat/list/entries/StartOfPrivateChatEntry;", "Lcom/discord/widgets/chat/list/entries/ChatListEntry;", "", "Lcom/discord/primitives/ChannelId;", "component1", "()J", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "component4", "", "component5", "()Z", "", "Lcom/discord/models/guild/Guild;", "component6", "()Ljava/util/List;", "channelId", "channelName", "channelType", "channelIcon", "isSystemDM", "mutualGuilds", "copy", "(JLjava/lang/String;ILjava/lang/String;ZLjava/util/List;)Lcom/discord/widgets/chat/list/entries/StartOfPrivateChatEntry;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/util/List;", "getMutualGuilds", "Ljava/lang/String;", "getChannelName", "getChannelIcon", "I", "getChannelType", "type", "getType", "key", "getKey", "J", "getChannelId", "<init>", "(JLjava/lang/String;ILjava/lang/String;ZLjava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StartOfPrivateChatEntry extends ChatListEntry {
    private final String channelIcon;
    private final long channelId;
    private final String channelName;
    private final int channelType;
    private final boolean isSystemDM;
    private final String key;
    private final List<Guild> mutualGuilds;
    private final int type;

    public StartOfPrivateChatEntry(long j, String str, int i, String str2, boolean z2, List<Guild> list) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
        Intrinsics3.checkNotNullParameter(list, "mutualGuilds");
        this.channelId = j;
        this.channelName = str;
        this.channelType = i;
        this.channelIcon = str2;
        this.isSystemDM = z2;
        this.mutualGuilds = list;
        this.type = 29;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ StartOfPrivateChatEntry copy$default(StartOfPrivateChatEntry startOfPrivateChatEntry, long j, String str, int i, String str2, boolean z2, List list, int i2, Object obj) {
        return startOfPrivateChatEntry.copy((i2 & 1) != 0 ? startOfPrivateChatEntry.channelId : j, (i2 & 2) != 0 ? startOfPrivateChatEntry.channelName : str, (i2 & 4) != 0 ? startOfPrivateChatEntry.channelType : i, (i2 & 8) != 0 ? startOfPrivateChatEntry.channelIcon : str2, (i2 & 16) != 0 ? startOfPrivateChatEntry.isSystemDM : z2, (i2 & 32) != 0 ? startOfPrivateChatEntry.mutualGuilds : list);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getChannelType() {
        return this.channelType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getChannelIcon() {
        return this.channelIcon;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSystemDM() {
        return this.isSystemDM;
    }

    public final List<Guild> component6() {
        return this.mutualGuilds;
    }

    public final StartOfPrivateChatEntry copy(long channelId, String channelName, int channelType, String channelIcon, boolean isSystemDM, List<Guild> mutualGuilds) {
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        Intrinsics3.checkNotNullParameter(mutualGuilds, "mutualGuilds");
        return new StartOfPrivateChatEntry(channelId, channelName, channelType, channelIcon, isSystemDM, mutualGuilds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartOfPrivateChatEntry)) {
            return false;
        }
        StartOfPrivateChatEntry startOfPrivateChatEntry = (StartOfPrivateChatEntry) other;
        return this.channelId == startOfPrivateChatEntry.channelId && Intrinsics3.areEqual(this.channelName, startOfPrivateChatEntry.channelName) && this.channelType == startOfPrivateChatEntry.channelType && Intrinsics3.areEqual(this.channelIcon, startOfPrivateChatEntry.channelIcon) && this.isSystemDM == startOfPrivateChatEntry.isSystemDM && Intrinsics3.areEqual(this.mutualGuilds, startOfPrivateChatEntry.mutualGuilds);
    }

    public final String getChannelIcon() {
        return this.channelIcon;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final int getChannelType() {
        return this.channelType;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final List<Guild> getMutualGuilds() {
        return this.mutualGuilds;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        String str = this.channelName;
        int iHashCode = (((iA + (str != null ? str.hashCode() : 0)) * 31) + this.channelType) * 31;
        String str2 = this.channelIcon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.isSystemDM;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        List<Guild> list = this.mutualGuilds;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final boolean isSystemDM() {
        return this.isSystemDM;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StartOfPrivateChatEntry(channelId=");
        sbU.append(this.channelId);
        sbU.append(", channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelType=");
        sbU.append(this.channelType);
        sbU.append(", channelIcon=");
        sbU.append(this.channelIcon);
        sbU.append(", isSystemDM=");
        sbU.append(this.isSystemDM);
        sbU.append(", mutualGuilds=");
        return outline.L(sbU, this.mutualGuilds, ")");
    }
}
