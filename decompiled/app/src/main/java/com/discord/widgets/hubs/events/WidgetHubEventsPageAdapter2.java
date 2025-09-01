package com.discord.widgets.hubs.events;

import b.d.b.a.outline;
import com.discord.api.directory.DirectoryEntryGuild2;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.analytics.Traits;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubEventsPageAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\t\n\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/hubs/events/HubEventsPage;", "", "", "viewType", "I", "getViewType", "()I", "<init>", "(I)V", "Companion", "Event", Traits.Location.Section.FOOTER, Traits.Location.Section.HEADER, "Lcom/discord/widgets/hubs/events/HubEventsPage$Header;", "Lcom/discord/widgets/hubs/events/HubEventsPage$Footer;", "Lcom/discord/widgets/hubs/events/HubEventsPage$Event;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.hubs.events.HubEventsPage, reason: use source file name */
/* loaded from: classes2.dex */
public abstract class WidgetHubEventsPageAdapter2 {
    public static final int ENTRY = 2;
    public static final int FOOTER = 1;
    public static final int HEADER = 0;
    private final int viewType;

    /* compiled from: WidgetHubEventsPageAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/hubs/events/HubEventsPage$Event;", "Lcom/discord/widgets/hubs/events/HubEventsPage;", "Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "component1", "()Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "guildScheduledEventData", "copy", "(Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;)Lcom/discord/widgets/hubs/events/HubEventsPage$Event;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;", "getGuildScheduledEventData", "<init>", "(Lcom/discord/widgets/hubs/events/HubGuildScheduledEventData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.HubEventsPage$Event */
    public static final /* data */ class Event extends WidgetHubEventsPageAdapter2 {
        private final WidgetHubEventsViewModel2 guildScheduledEventData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Event(WidgetHubEventsViewModel2 widgetHubEventsViewModel2) {
            super(2, null);
            Intrinsics3.checkNotNullParameter(widgetHubEventsViewModel2, "guildScheduledEventData");
            this.guildScheduledEventData = widgetHubEventsViewModel2;
        }

        public static /* synthetic */ Event copy$default(Event event, WidgetHubEventsViewModel2 widgetHubEventsViewModel2, int i, Object obj) {
            if ((i & 1) != 0) {
                widgetHubEventsViewModel2 = event.guildScheduledEventData;
            }
            return event.copy(widgetHubEventsViewModel2);
        }

        /* renamed from: component1, reason: from getter */
        public final WidgetHubEventsViewModel2 getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public final Event copy(WidgetHubEventsViewModel2 guildScheduledEventData) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventData, "guildScheduledEventData");
            return new Event(guildScheduledEventData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Event) && Intrinsics3.areEqual(this.guildScheduledEventData, ((Event) other).guildScheduledEventData);
            }
            return true;
        }

        public final WidgetHubEventsViewModel2 getGuildScheduledEventData() {
            return this.guildScheduledEventData;
        }

        public int hashCode() {
            WidgetHubEventsViewModel2 widgetHubEventsViewModel2 = this.guildScheduledEventData;
            if (widgetHubEventsViewModel2 != null) {
                return widgetHubEventsViewModel2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Event(guildScheduledEventData=");
            sbU.append(this.guildScheduledEventData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetHubEventsPageAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/hubs/events/HubEventsPage$Footer;", "Lcom/discord/widgets/hubs/events/HubEventsPage;", "Lcom/discord/stores/utilities/RestCallState;", "", "Lcom/discord/api/directory/DirectoryEntryEvent;", "component1", "()Lcom/discord/stores/utilities/RestCallState;", "eventsAsync", "copy", "(Lcom/discord/stores/utilities/RestCallState;)Lcom/discord/widgets/hubs/events/HubEventsPage$Footer;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/utilities/RestCallState;", "getEventsAsync", "<init>", "(Lcom/discord/stores/utilities/RestCallState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.HubEventsPage$Footer */
    public static final /* data */ class Footer extends WidgetHubEventsPageAdapter2 {
        private final RestCallState<List<DirectoryEntryGuild2>> eventsAsync;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Footer(RestCallState<? extends List<DirectoryEntryGuild2>> restCallState) {
            super(1, null);
            Intrinsics3.checkNotNullParameter(restCallState, "eventsAsync");
            this.eventsAsync = restCallState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Footer copy$default(Footer footer, RestCallState restCallState, int i, Object obj) {
            if ((i & 1) != 0) {
                restCallState = footer.eventsAsync;
            }
            return footer.copy(restCallState);
        }

        public final RestCallState<List<DirectoryEntryGuild2>> component1() {
            return this.eventsAsync;
        }

        public final Footer copy(RestCallState<? extends List<DirectoryEntryGuild2>> eventsAsync) {
            Intrinsics3.checkNotNullParameter(eventsAsync, "eventsAsync");
            return new Footer(eventsAsync);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Footer) && Intrinsics3.areEqual(this.eventsAsync, ((Footer) other).eventsAsync);
            }
            return true;
        }

        public final RestCallState<List<DirectoryEntryGuild2>> getEventsAsync() {
            return this.eventsAsync;
        }

        public int hashCode() {
            RestCallState<List<DirectoryEntryGuild2>> restCallState = this.eventsAsync;
            if (restCallState != null) {
                return restCallState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Footer(eventsAsync=");
            sbU.append(this.eventsAsync);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetHubEventsPageAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/hubs/events/HubEventsPage$Header;", "Lcom/discord/widgets/hubs/events/HubEventsPage;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.events.HubEventsPage$Header */
    public static final class Header extends WidgetHubEventsPageAdapter2 {
        public static final Header INSTANCE = new Header();

        private Header() {
            super(0, null);
        }
    }

    private WidgetHubEventsPageAdapter2(int i) {
        this.viewType = i;
    }

    public final int getViewType() {
        return this.viewType;
    }

    public /* synthetic */ WidgetHubEventsPageAdapter2(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
