package com.discord.widgets.hubs.events;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubEventsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\t¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ@\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR%\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b\u001c\u0010\fR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "", "", "component1", "()Z", "", "Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "component2", "()Ljava/util/List;", "Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/directory/DirectoryEntryEvent;", "component3", "()Lcom/discord/stores/utilities/RestCallState;", "showHeader", "eventsData", "eventsAsync", "copy", "(ZLjava/util/List;Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/events/WidgetHubEventsState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/utilities/RestCallState;", "getEventsAsync", "Ljava/util/List;", "getEventsData", "Z", "getShowHeader", "<init>", "(ZLjava/util/List;Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsState, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsViewModel3 {
    private final RestCallState<List<DirectoryEntryGuild2>> eventsAsync;
    private final List<WidgetHubEventsViewModel2> eventsData;
    private final boolean showHeader;

    public WidgetHubEventsViewModel3() {
        this(false, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetHubEventsViewModel3(boolean z2, List<WidgetHubEventsViewModel2> list, RestCallState<? extends List<DirectoryEntryGuild2>> restCallState) {
        Intrinsics3.checkNotNullParameter(list, "eventsData");
        Intrinsics3.checkNotNullParameter(restCallState, "eventsAsync");
        this.showHeader = z2;
        this.eventsData = list;
        this.eventsAsync = restCallState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubEventsViewModel3 copy$default(WidgetHubEventsViewModel3 widgetHubEventsViewModel3, boolean z2, List list, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = widgetHubEventsViewModel3.showHeader;
        }
        if ((i & 2) != 0) {
            list = widgetHubEventsViewModel3.eventsData;
        }
        if ((i & 4) != 0) {
            restCallState = widgetHubEventsViewModel3.eventsAsync;
        }
        return widgetHubEventsViewModel3.copy(z2, list, restCallState);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShowHeader() {
        return this.showHeader;
    }

    public final List<WidgetHubEventsViewModel2> component2() {
        return this.eventsData;
    }

    public final RestCallState<List<DirectoryEntryGuild2>> component3() {
        return this.eventsAsync;
    }

    public final WidgetHubEventsViewModel3 copy(boolean showHeader, List<WidgetHubEventsViewModel2> eventsData, RestCallState<? extends List<DirectoryEntryGuild2>> eventsAsync) {
        Intrinsics3.checkNotNullParameter(eventsData, "eventsData");
        Intrinsics3.checkNotNullParameter(eventsAsync, "eventsAsync");
        return new WidgetHubEventsViewModel3(showHeader, eventsData, eventsAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsViewModel3)) {
            return false;
        }
        WidgetHubEventsViewModel3 widgetHubEventsViewModel3 = (WidgetHubEventsViewModel3) other;
        return this.showHeader == widgetHubEventsViewModel3.showHeader && Intrinsics3.areEqual(this.eventsData, widgetHubEventsViewModel3.eventsData) && Intrinsics3.areEqual(this.eventsAsync, widgetHubEventsViewModel3.eventsAsync);
    }

    public final RestCallState<List<DirectoryEntryGuild2>> getEventsAsync() {
        return this.eventsAsync;
    }

    public final List<WidgetHubEventsViewModel2> getEventsData() {
        return this.eventsData;
    }

    public final boolean getShowHeader() {
        return this.showHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z2 = this.showHeader;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<WidgetHubEventsViewModel2> list = this.eventsData;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        RestCallState<List<DirectoryEntryGuild2>> restCallState = this.eventsAsync;
        return iHashCode + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetHubEventsState(showHeader=");
        sbU.append(this.showHeader);
        sbU.append(", eventsData=");
        sbU.append(this.eventsData);
        sbU.append(", eventsAsync=");
        sbU.append(this.eventsAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubEventsViewModel3(boolean z2, List list, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? Collections2.emptyList() : list, (i & 4) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
