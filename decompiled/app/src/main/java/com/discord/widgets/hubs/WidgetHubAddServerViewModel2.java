package com.discord.widgets.hubs;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.guild.Guild;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAddServerViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJf\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u0010\b\u0002\u0010\u0014\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\b\b\u0002\u0010\u0015\u001a\u00020\t2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\fHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u000bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010!\u001a\u0004\b\"\u0010\u000fR\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b#\u0010\u000fR\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010!\u001a\u0004\b$\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0015\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010\u000bR!\u0010\u0014\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\b¨\u0006-"}, d2 = {"Lcom/discord/widgets/hubs/HubAddServerState;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/primitives/ChannelId;", "component2", "()Ljava/lang/Long;", "", "component3", "()I", "", "Lcom/discord/models/guild/Guild;", "component4", "()Ljava/util/List;", "component5", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component6", "hubName", "directoryChannelId", "selectedIndex", "selectableGuilds", "addedGuilds", "addedDirectories", "copy", "(Ljava/lang/String;Ljava/lang/Long;ILjava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/hubs/HubAddServerState;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getAddedGuilds", "getAddedDirectories", "getSelectableGuilds", "Ljava/lang/String;", "getHubName", "I", "getSelectedIndex", "Ljava/lang/Long;", "getDirectoryChannelId", "<init>", "(Ljava/lang/String;Ljava/lang/Long;ILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.HubAddServerState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubAddServerViewModel2 {
    private final List<DirectoryEntryGuild> addedDirectories;
    private final List<Guild> addedGuilds;
    private final Long directoryChannelId;
    private final String hubName;
    private final List<Guild> selectableGuilds;
    private final int selectedIndex;

    public WidgetHubAddServerViewModel2() {
        this(null, null, 0, null, null, null, 63, null);
    }

    public WidgetHubAddServerViewModel2(String str, Long l, int i, List<Guild> list, List<Guild> list2, List<DirectoryEntryGuild> list3) {
        Intrinsics3.checkNotNullParameter(str, "hubName");
        Intrinsics3.checkNotNullParameter(list, "selectableGuilds");
        Intrinsics3.checkNotNullParameter(list2, "addedGuilds");
        Intrinsics3.checkNotNullParameter(list3, "addedDirectories");
        this.hubName = str;
        this.directoryChannelId = l;
        this.selectedIndex = i;
        this.selectableGuilds = list;
        this.addedGuilds = list2;
        this.addedDirectories = list3;
    }

    public static /* synthetic */ WidgetHubAddServerViewModel2 copy$default(WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2, String str, Long l, int i, List list, List list2, List list3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetHubAddServerViewModel2.hubName;
        }
        if ((i2 & 2) != 0) {
            l = widgetHubAddServerViewModel2.directoryChannelId;
        }
        Long l2 = l;
        if ((i2 & 4) != 0) {
            i = widgetHubAddServerViewModel2.selectedIndex;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            list = widgetHubAddServerViewModel2.selectableGuilds;
        }
        List list4 = list;
        if ((i2 & 16) != 0) {
            list2 = widgetHubAddServerViewModel2.addedGuilds;
        }
        List list5 = list2;
        if ((i2 & 32) != 0) {
            list3 = widgetHubAddServerViewModel2.addedDirectories;
        }
        return widgetHubAddServerViewModel2.copy(str, l2, i3, list4, list5, list3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHubName() {
        return this.hubName;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final List<Guild> component4() {
        return this.selectableGuilds;
    }

    public final List<Guild> component5() {
        return this.addedGuilds;
    }

    public final List<DirectoryEntryGuild> component6() {
        return this.addedDirectories;
    }

    public final WidgetHubAddServerViewModel2 copy(String hubName, Long directoryChannelId, int selectedIndex, List<Guild> selectableGuilds, List<Guild> addedGuilds, List<DirectoryEntryGuild> addedDirectories) {
        Intrinsics3.checkNotNullParameter(hubName, "hubName");
        Intrinsics3.checkNotNullParameter(selectableGuilds, "selectableGuilds");
        Intrinsics3.checkNotNullParameter(addedGuilds, "addedGuilds");
        Intrinsics3.checkNotNullParameter(addedDirectories, "addedDirectories");
        return new WidgetHubAddServerViewModel2(hubName, directoryChannelId, selectedIndex, selectableGuilds, addedGuilds, addedDirectories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubAddServerViewModel2)) {
            return false;
        }
        WidgetHubAddServerViewModel2 widgetHubAddServerViewModel2 = (WidgetHubAddServerViewModel2) other;
        return Intrinsics3.areEqual(this.hubName, widgetHubAddServerViewModel2.hubName) && Intrinsics3.areEqual(this.directoryChannelId, widgetHubAddServerViewModel2.directoryChannelId) && this.selectedIndex == widgetHubAddServerViewModel2.selectedIndex && Intrinsics3.areEqual(this.selectableGuilds, widgetHubAddServerViewModel2.selectableGuilds) && Intrinsics3.areEqual(this.addedGuilds, widgetHubAddServerViewModel2.addedGuilds) && Intrinsics3.areEqual(this.addedDirectories, widgetHubAddServerViewModel2.addedDirectories);
    }

    public final List<DirectoryEntryGuild> getAddedDirectories() {
        return this.addedDirectories;
    }

    public final List<Guild> getAddedGuilds() {
        return this.addedGuilds;
    }

    public final Long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final String getHubName() {
        return this.hubName;
    }

    public final List<Guild> getSelectableGuilds() {
        return this.selectableGuilds;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public int hashCode() {
        String str = this.hubName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.directoryChannelId;
        int iHashCode2 = (((iHashCode + (l != null ? l.hashCode() : 0)) * 31) + this.selectedIndex) * 31;
        List<Guild> list = this.selectableGuilds;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Guild> list2 = this.addedGuilds;
        int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<DirectoryEntryGuild> list3 = this.addedDirectories;
        return iHashCode4 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubAddServerState(hubName=");
        sbU.append(this.hubName);
        sbU.append(", directoryChannelId=");
        sbU.append(this.directoryChannelId);
        sbU.append(", selectedIndex=");
        sbU.append(this.selectedIndex);
        sbU.append(", selectableGuilds=");
        sbU.append(this.selectableGuilds);
        sbU.append(", addedGuilds=");
        sbU.append(this.addedGuilds);
        sbU.append(", addedDirectories=");
        return outline.L(sbU, this.addedDirectories, ")");
    }

    public /* synthetic */ WidgetHubAddServerViewModel2(String str, Long l, int i, List list, List list2, List list3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? Collections2.emptyList() : list, (i2 & 16) != 0 ? Collections2.emptyList() : list2, (i2 & 32) != 0 ? Collections2.emptyList() : list3);
    }
}
