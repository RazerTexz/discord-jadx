package com.discord.widgets.stage.start;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModeratorStartStageItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Companion", "Continue", Traits.Location.Section.HEADER, "ListItem", "Waiting", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Header;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Continue;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Waiting;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ModeratorStartStageItem implements MGRecyclerDataPayload {
    public static final String KEY_SCHEDULE_EVENT = "KEY_SCHEDULE_EVENT";
    public static final String KEY_START_STAGE = "KEY_START_STAGE";
    public static final int TYPE_CONTINUE = 2;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LIST_ITEM = 1;
    public static final int TYPE_WAITING = 3;

    /* compiled from: ModeratorStartStageItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Continue;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "type", "key", "copy", "(ILjava/lang/String;)Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Continue;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKey", "I", "getType", "<init>", "(ILjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Continue extends ModeratorStartStageItem {
        private final String key;
        private final int type;

        public Continue() {
            this(0, null, 3, null);
        }

        public /* synthetic */ Continue(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 2 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_CONTINUE" : str);
        }

        public static /* synthetic */ Continue copy$default(Continue r0, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = r0.getType();
            }
            if ((i2 & 2) != 0) {
                str = r0.getKey();
            }
            return r0.copy(i, str);
        }

        public final int component1() {
            return getType();
        }

        public final String component2() {
            return getKey();
        }

        public final Continue copy(int type, String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return new Continue(type, key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Continue)) {
                return false;
            }
            Continue r3 = (Continue) other;
            return getType() == r3.getType() && Intrinsics3.areEqual(getKey(), r3.getKey());
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int type = getType() * 31;
            String key = getKey();
            return type + (key != null ? key.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Continue(type=");
            sbU.append(getType());
            sbU.append(", key=");
            sbU.append(getKey());
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Continue(int i, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "key");
            this.type = i;
            this.key = str;
        }
    }

    /* compiled from: ModeratorStartStageItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Header;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "type", "key", "copy", "(ILjava/lang/String;)Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Header;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getType", "Ljava/lang/String;", "getKey", "<init>", "(ILjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Header extends ModeratorStartStageItem {
        private final String key;
        private final int type;

        public Header() {
            this(0, null, 3, null);
        }

        public /* synthetic */ Header(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_HEADER" : str);
        }

        public static /* synthetic */ Header copy$default(Header header, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = header.getType();
            }
            if ((i2 & 2) != 0) {
                str = header.getKey();
            }
            return header.copy(i, str);
        }

        public final int component1() {
            return getType();
        }

        public final String component2() {
            return getKey();
        }

        public final Header copy(int type, String key) {
            Intrinsics3.checkNotNullParameter(key, "key");
            return new Header(type, key);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Header)) {
                return false;
            }
            Header header = (Header) other;
            return getType() == header.getType() && Intrinsics3.areEqual(getKey(), header.getKey());
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            int type = getType() * 31;
            String key = getKey();
            return type + (key != null ? key.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Header(type=");
            sbU.append(getType());
            sbU.append(", key=");
            sbU.append(getKey());
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Header(int i, String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "key");
            this.type = i;
            this.key = str;
        }
    }

    /* compiled from: ModeratorStartStageItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B/\b\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "", "iconBgColorRes", "I", "getIconBgColorRes", "()I", "iconRes", "getIconRes", "type", "getType", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;II)V", "Event", "StaticOption", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$Event;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ListItem extends ModeratorStartStageItem {
        private final int iconBgColorRes;
        private final int iconRes;
        private final String key;
        private final int type;

        /* compiled from: ModeratorStartStageItem.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$Event;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component1", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "event", "copy", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$Event;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getEvent", "<init>", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Event extends ListItem {
            private final GuildScheduledEvent event;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Event(GuildScheduledEvent guildScheduledEvent) {
                super(0, String.valueOf(guildScheduledEvent.getId()), R.drawable.ic_event_20dp, R.color.status_green_600, 1, null);
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
                this.event = guildScheduledEvent;
            }

            public static /* synthetic */ Event copy$default(Event event, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEvent = event.event;
                }
                return event.copy(guildScheduledEvent);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getEvent() {
                return this.event;
            }

            public final Event copy(GuildScheduledEvent event) {
                Intrinsics3.checkNotNullParameter(event, "event");
                return new Event(event);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Event) && Intrinsics3.areEqual(this.event, ((Event) other).event);
                }
                return true;
            }

            public final GuildScheduledEvent getEvent() {
                return this.event;
            }

            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.event;
                if (guildScheduledEvent != null) {
                    return guildScheduledEvent.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Event(event=");
                sbU.append(this.event);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ModeratorStartStageItem.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B5\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem;", "", "iconRes", "I", "getIconRes", "()I", "subtitleRes", "getSubtitleRes", "titleRes", "getTitleRes", "iconBgColorRes", "getIconBgColorRes", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IIII)V", "ScheduleEvent", "StartStage", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption$StartStage;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static abstract class StaticOption extends ListItem {
            private final int iconBgColorRes;
            private final int iconRes;
            private final String key;
            private final int subtitleRes;
            private final int titleRes;

            /* compiled from: ModeratorStartStageItem.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption;", "", "component1", "()Ljava/lang/String;", "key", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption$ScheduleEvent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKey", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class ScheduleEvent extends StaticOption {
                private final String key;

                public ScheduleEvent() {
                    this(null, 1, null);
                }

                public /* synthetic */ ScheduleEvent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? ModeratorStartStageItem.KEY_SCHEDULE_EVENT : str);
                }

                public static /* synthetic */ ScheduleEvent copy$default(ScheduleEvent scheduleEvent, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = scheduleEvent.getKey();
                    }
                    return scheduleEvent.copy(str);
                }

                public final String component1() {
                    return getKey();
                }

                public final ScheduleEvent copy(String key) {
                    Intrinsics3.checkNotNullParameter(key, "key");
                    return new ScheduleEvent(key);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof ScheduleEvent) && Intrinsics3.areEqual(getKey(), ((ScheduleEvent) other).getKey());
                    }
                    return true;
                }

                @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem.StaticOption, com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return this.key;
                }

                public int hashCode() {
                    String key = getKey();
                    if (key != null) {
                        return key.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("ScheduleEvent(key=");
                    sbU.append(getKey());
                    sbU.append(")");
                    return sbU.toString();
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ScheduleEvent(String str) {
                    super(str, R.drawable.ic_event_20dp, R.color.brand_new_500, R.string.schedule_event, R.string.schedule_event_description, null);
                    Intrinsics3.checkNotNullParameter(str, "key");
                    this.key = str;
                }
            }

            /* compiled from: ModeratorStartStageItem.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption$StartStage;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption;", "", "component1", "()Ljava/lang/String;", "key", "copy", "(Ljava/lang/String;)Lcom/discord/widgets/stage/start/ModeratorStartStageItem$ListItem$StaticOption$StartStage;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getKey", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
            public static final /* data */ class StartStage extends StaticOption {
                private final String key;

                public StartStage() {
                    this(null, 1, null);
                }

                public /* synthetic */ StartStage(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? ModeratorStartStageItem.KEY_START_STAGE : str);
                }

                public static /* synthetic */ StartStage copy$default(StartStage startStage, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = startStage.getKey();
                    }
                    return startStage.copy(str);
                }

                public final String component1() {
                    return getKey();
                }

                public final StartStage copy(String key) {
                    Intrinsics3.checkNotNullParameter(key, "key");
                    return new StartStage(key);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof StartStage) && Intrinsics3.areEqual(getKey(), ((StartStage) other).getKey());
                    }
                    return true;
                }

                @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem.StaticOption, com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return this.key;
                }

                public int hashCode() {
                    String key = getKey();
                    if (key != null) {
                        return key.hashCode();
                    }
                    return 0;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("StartStage(key=");
                    sbU.append(getKey());
                    sbU.append(")");
                    return sbU.toString();
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public StartStage(String str) {
                    super(str, R.drawable.ic_channel_stage_24dp, R.color.status_green_600, R.string.stage_channel_start_title, R.string.stage_channel_start_subtitle, null);
                    Intrinsics3.checkNotNullParameter(str, "key");
                    this.key = str;
                }
            }

            public /* synthetic */ StaticOption(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i, i2, i3, i4);
            }

            @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem
            public int getIconBgColorRes() {
                return this.iconBgColorRes;
            }

            @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem
            public int getIconRes() {
                return this.iconRes;
            }

            @Override // com.discord.widgets.stage.start.ModeratorStartStageItem.ListItem, com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getSubtitleRes() {
                return this.subtitleRes;
            }

            public final int getTitleRes() {
                return this.titleRes;
            }

            private StaticOption(String str, int i, int i2, @StringRes int i3, @StringRes int i4) {
                super(0, str, i, i2, 1, null);
                this.key = str;
                this.iconRes = i;
                this.iconBgColorRes = i2;
                this.titleRes = i3;
                this.subtitleRes = i4;
            }
        }

        public /* synthetic */ ListItem(int i, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 1 : i, str, i2, i3);
        }

        public int getIconBgColorRes() {
            return this.iconBgColorRes;
        }

        public int getIconRes() {
            return this.iconRes;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        private ListItem(int i, String str, @DrawableRes int i2, @ColorRes int i3) {
            super(null);
            this.type = i;
            this.key = str;
            this.iconRes = i2;
            this.iconBgColorRes = i3;
        }
    }

    /* compiled from: ModeratorStartStageItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\r\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007¨\u0006 "}, d2 = {"Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Waiting;", "Lcom/discord/widgets/stage/start/ModeratorStartStageItem;", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "", "Lcom/discord/models/guild/UserGuildMember;", "component3", "()Ljava/util/List;", "type", "key", "users", "copy", "(ILjava/lang/String;Ljava/util/List;)Lcom/discord/widgets/stage/start/ModeratorStartStageItem$Waiting;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getType", "Ljava/util/List;", "getUsers", "Ljava/lang/String;", "getKey", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Waiting extends ModeratorStartStageItem {
        private final String key;
        private final int type;
        private final List<UserGuildMember> users;

        public /* synthetic */ Waiting(int i, String str, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 3 : i, (i2 & 2) != 0 ? "KEY_CREATE_STAGE_EVENT_WAITING" : str, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Waiting copy$default(Waiting waiting, int i, String str, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = waiting.getType();
            }
            if ((i2 & 2) != 0) {
                str = waiting.getKey();
            }
            if ((i2 & 4) != 0) {
                list = waiting.users;
            }
            return waiting.copy(i, str, list);
        }

        public final int component1() {
            return getType();
        }

        public final String component2() {
            return getKey();
        }

        public final List<UserGuildMember> component3() {
            return this.users;
        }

        public final Waiting copy(int type, String key, List<UserGuildMember> users) {
            Intrinsics3.checkNotNullParameter(key, "key");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new Waiting(type, key, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Waiting)) {
                return false;
            }
            Waiting waiting = (Waiting) other;
            return getType() == waiting.getType() && Intrinsics3.areEqual(getKey(), waiting.getKey()) && Intrinsics3.areEqual(this.users, waiting.users);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final List<UserGuildMember> getUsers() {
            return this.users;
        }

        public int hashCode() {
            int type = getType() * 31;
            String key = getKey();
            int iHashCode = (type + (key != null ? key.hashCode() : 0)) * 31;
            List<UserGuildMember> list = this.users;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Waiting(type=");
            sbU.append(getType());
            sbU.append(", key=");
            sbU.append(getKey());
            sbU.append(", users=");
            return outline.L(sbU, this.users, ")");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Waiting(int i, String str, List<UserGuildMember> list) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "key");
            Intrinsics3.checkNotNullParameter(list, "users");
            this.type = i;
            this.key = str;
            this.users = list;
        }
    }

    private ModeratorStartStageItem() {
    }

    public /* synthetic */ ModeratorStartStageItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
