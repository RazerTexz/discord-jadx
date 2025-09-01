package com.discord.widgets.guildscheduledevent;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventSettingsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003@ABBO\u0012\n\u00104\u001a\u000602j\u0002`3\u0012\u000e\u00106\u001a\n\u0018\u000102j\u0004\u0018\u0001`5\u0012\u0006\u00108\u001a\u000207\u0012\u000e\u0010:\u001a\n\u0018\u000102j\u0004\u0018\u0001`9\u0012\b\u0010;\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010=\u001a\u00020<¢\u0006\u0004\b>\u0010?J%\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0007J\u0017\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u0012J\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u001a\u0010\u000bJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J1\u0010)\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010\u001f2\b\u0010(\u001a\u0004\u0018\u00010!¢\u0006\u0004\b)\u0010*J\u0015\u0010-\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b/\u0010.J\u0015\u0010)\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b)\u0010.J\r\u00100\u001a\u00020\u001b¢\u0006\u0004\b0\u00101¨\u0006C"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;", "Lkotlin/Function1;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "updateEventModel", "", "(Lkotlin/jvm/functions/Function1;)Lkotlin/Unit;", "", ModelAuditLogEntry.CHANGE_KEY_TOPIC, "setTopic", "(Ljava/lang/String;)Lkotlin/Unit;", "", "year", "month", "dayOfMonth", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$DateError;", "setStartDate", "(III)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$DateError;", "hourOfDay", "minute", "setStartTime", "(II)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$DateError;", "setEndDate", "setEndTime", ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, "setDescription", "", "associateToHubs", "toggleBroadcastToDirectoryChannel", "(Z)Lkotlin/Unit;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;", "date", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;", "time", "isDateInFuture", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;)Z", "startDate", "startTime", "endDate", "endTime", "isStartDateBeforeEndDate", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerDate;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventPickerTime;)Z", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Initialized;", "viewState", "hasStartTimeChanged", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Initialized;)Z", "hasEndTimeChanged", "isNextButtonEnabled", "()Z", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/primitives/GuildScheduledEventId;", "existingGuildScheduledEventId", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;", "entityType", "Lcom/discord/primitives/ChannelId;", "channelId", "externalLocation", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "<init>", "(JLjava/lang/Long;Lcom/discord/api/guildscheduledevent/GuildScheduledEventEntityType;Ljava/lang/Long;Ljava/lang/String;Lcom/discord/stores/StoreGuildScheduledEvents;)V", "Companion", "DateError", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventSettingsViewModel extends AppViewModel<ViewState> {
    public static final int SAMPLE_USER_COUNT = 1;

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$DateError;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_VIEW_STATE", "START_DATE_IN_PAST", "END_DATE_IN_PAST", "END_DATE_BEFORE_START_DATE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum DateError {
        INVALID_VIEW_STATE,
        START_DATE_IN_PAST,
        END_DATE_IN_PAST,
        END_DATE_BEFORE_START_DATE
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;", "", "<init>", "()V", "Initialized", "Invalid", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Initialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: GuildScheduledEventSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Initialized;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "component1", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component2", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "eventModel", "existingEvent", "copy", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Initialized;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getExistingEvent", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "getEventModel", "<init>", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Initialized extends ViewState {
            private final GuildScheduledEventModel eventModel;
            private final GuildScheduledEvent existingEvent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "eventModel");
                this.eventModel = guildScheduledEventModel;
                this.existingEvent = guildScheduledEvent;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, GuildScheduledEventModel guildScheduledEventModel, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildScheduledEventModel = initialized.eventModel;
                }
                if ((i & 2) != 0) {
                    guildScheduledEvent = initialized.existingEvent;
                }
                return initialized.copy(guildScheduledEventModel, guildScheduledEvent);
            }

            /* renamed from: component1, reason: from getter */
            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            /* renamed from: component2, reason: from getter */
            public final GuildScheduledEvent getExistingEvent() {
                return this.existingEvent;
            }

            public final Initialized copy(GuildScheduledEventModel eventModel, GuildScheduledEvent existingEvent) {
                Intrinsics3.checkNotNullParameter(eventModel, "eventModel");
                return new Initialized(eventModel, existingEvent);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return Intrinsics3.areEqual(this.eventModel, initialized.eventModel) && Intrinsics3.areEqual(this.existingEvent, initialized.existingEvent);
            }

            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            public final GuildScheduledEvent getExistingEvent() {
                return this.existingEvent;
            }

            public int hashCode() {
                GuildScheduledEventModel guildScheduledEventModel = this.eventModel;
                int iHashCode = (guildScheduledEventModel != null ? guildScheduledEventModel.hashCode() : 0) * 31;
                GuildScheduledEvent guildScheduledEvent = this.existingEvent;
                return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Initialized(eventModel=");
                sbU.append(this.eventModel);
                sbU.append(", existingEvent=");
                sbU.append(this.existingEvent);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GuildScheduledEventSettingsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventSettingsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setDescription$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ String $description;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$description = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, null, null, this.$description, null, null, null, null, 7935, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setEndDate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime2 $newEndDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2) {
            super(1);
            this.$newEndDate = guildScheduledEventPickerDateTime2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, this.$newEndDate, null, null, null, null, null, null, 8127, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setEndTime$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime3 $newEndTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3) {
            super(1);
            this.$newEndTime = guildScheduledEventPickerDateTime3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, null, this.$newEndTime, null, null, null, null, null, 8063, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setStartDate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime2 $newStartDate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEventPickerDateTime2 guildScheduledEventPickerDateTime2) {
            super(1);
            this.$newStartDate = guildScheduledEventPickerDateTime2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, this.$newStartDate, null, null, null, null, null, null, null, null, 8175, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setStartTime$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ GuildScheduledEventPickerDateTime3 $newStartTime;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEventPickerDateTime3 guildScheduledEventPickerDateTime3) {
            super(1);
            this.$newStartTime = guildScheduledEventPickerDateTime3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, this.$newStartTime, null, null, null, null, null, null, null, 8159, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$setTopic$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ String $topic;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$topic = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, this.$topic, null, null, null, null, null, null, null, null, null, null, null, 8189, null);
        }
    }

    /* compiled from: GuildScheduledEventSettingsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "invoke", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$toggleBroadcastToDirectoryChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildScheduledEventModel, GuildScheduledEventModel> {
        public final /* synthetic */ boolean $associateToHubs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$associateToHubs = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ GuildScheduledEventModel invoke(GuildScheduledEventModel guildScheduledEventModel) {
            return invoke2(guildScheduledEventModel);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final GuildScheduledEventModel invoke2(GuildScheduledEventModel guildScheduledEventModel) {
            Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$receiver");
            return GuildScheduledEventModel.copy$default(guildScheduledEventModel, 0L, null, null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(this.$associateToHubs), 4095, null);
        }
    }

    public /* synthetic */ GuildScheduledEventSettingsViewModel(long j, Long l, GuildScheduledEventEntityType guildScheduledEventEntityType, Long l2, String str, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, guildScheduledEventEntityType, l2, str, (i & 32) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    private final Unit updateEventModel(Function1<? super GuildScheduledEventModel, GuildScheduledEventModel> updateEventModel) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized == null) {
            return null;
        }
        updateViewState(ViewState.Initialized.copy$default(initialized, updateEventModel.invoke(initialized.getEventModel()), null, 2, null));
        return Unit.a;
    }

    public final boolean hasEndTimeChanged(ViewState.Initialized viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (viewState.getExistingEvent() == null) {
            return true;
        }
        if (viewState.getEventModel().getEndDate() == null || viewState.getEventModel().getEndTime() == null) {
            return viewState.getExistingEvent().getScheduledEndTime() == null;
        }
        long millis = GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
        UtcDateTime scheduledEndTime = viewState.getExistingEvent().getScheduledEndTime();
        Long lValueOf = scheduledEndTime != null ? Long.valueOf(scheduledEndTime.getDateTimeMillis()) : null;
        return lValueOf == null || millis != lValueOf.longValue();
    }

    public final boolean hasStartTimeChanged(ViewState.Initialized viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        return viewState.getExistingEvent() == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime()) != viewState.getExistingEvent().getScheduledStartTime().getDateTimeMillis();
    }

    public final boolean isDateInFuture(GuildScheduledEventPickerDateTime2 date, GuildScheduledEventPickerDateTime3 time) {
        return date == null || time == null || GuildScheduledEventPickerDateTime.INSTANCE.toMillis(date, time) >= ClockFactory.get().currentTimeMillis();
    }

    public final boolean isNextButtonEnabled() {
        GuildScheduledEventModel eventModel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized == null || (eventModel = initialized.getEventModel()) == null) {
            return false;
        }
        String name = eventModel.getName();
        if (name == null || name.length() == 0) {
            return false;
        }
        return (eventModel.getEntityType() == GuildScheduledEventEntityType.EXTERNAL && (eventModel.getEndDate() == null || eventModel.getEndTime() == null)) ? false : true;
    }

    public final boolean isStartDateBeforeEndDate(GuildScheduledEventPickerDateTime2 startDate, GuildScheduledEventPickerDateTime3 startTime, GuildScheduledEventPickerDateTime2 endDate, GuildScheduledEventPickerDateTime3 endTime) {
        Intrinsics3.checkNotNullParameter(startDate, "startDate");
        Intrinsics3.checkNotNullParameter(startTime, "startTime");
        if (endDate == null || endTime == null) {
            return endDate == null || endDate.toMillis() >= startDate.toMillis();
        }
        GuildScheduledEventPickerDateTime guildScheduledEventPickerDateTime = GuildScheduledEventPickerDateTime.INSTANCE;
        return guildScheduledEventPickerDateTime.toMillis(endDate, endTime) > guildScheduledEventPickerDateTime.toMillis(startDate, startTime);
    }

    public final Unit setDescription(String description) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        return updateEventModel(new AnonymousClass1(description));
    }

    public final DateError setEndDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new AnonymousClass1(new GuildScheduledEventPickerDateTime2(year, month, dayOfMonth))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setEndTime(int hourOfDay, int minute) {
        if (updateEventModel(new AnonymousClass1(new GuildScheduledEventPickerDateTime3(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setStartDate(int year, int month, int dayOfMonth) {
        if (updateEventModel(new AnonymousClass1(new GuildScheduledEventPickerDateTime2(year, month, dayOfMonth))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final DateError setStartTime(int hourOfDay, int minute) {
        if (updateEventModel(new AnonymousClass1(new GuildScheduledEventPickerDateTime3(hourOfDay, minute, 0))) != null) {
            return null;
        }
        return DateError.INVALID_VIEW_STATE;
    }

    public final Unit setTopic(String topic) {
        Intrinsics3.checkNotNullParameter(topic, ModelAuditLogEntry.CHANGE_KEY_TOPIC);
        return updateEventModel(new AnonymousClass1(topic));
    }

    public final Unit toggleBroadcastToDirectoryChannel(boolean associateToHubs) {
        return updateEventModel(new AnonymousClass1(associateToHubs));
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public GuildScheduledEventSettingsViewModel(long r22, java.lang.Long r24, com.discord.api.guildscheduledevent.GuildScheduledEventEntityType r25, java.lang.Long r26, java.lang.String r27, com.discord.stores.StoreGuildScheduledEvents r28) {
        /*
            r21 = this;
            r0 = r21
            r12 = r25
            r5 = r27
            r1 = r28
            java.lang.String r2 = "entityType"
            d0.z.d.Intrinsics3.checkNotNullParameter(r12, r2)
            java.lang.String r2 = "guildScheduledEventsStore"
            d0.z.d.Intrinsics3.checkNotNullParameter(r1, r2)
            r2 = 0
            r15 = 1
            r0.<init>(r2, r15, r2)
            if (r24 == 0) goto L26
            long r3 = r24.longValue()
            java.lang.Long r6 = java.lang.Long.valueOf(r22)
            com.discord.api.guildscheduledevent.GuildScheduledEvent r1 = r1.findEventFromStore(r3, r6)
            goto L27
        L26:
            r1 = r2
        L27:
            if (r1 == 0) goto L57
            com.discord.widgets.guildscheduledevent.GuildScheduledEventModel r18 = com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2.toModel(r1)
            if (r18 == 0) goto L57
            r2 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata$Companion r13 = com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata.INSTANCE
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata r13 = r13.a(r12, r5)
            r14 = 0
            r16 = 0
            r19 = 1
            r15 = r16
            r16 = 6651(0x19fb, float:9.32E-42)
            r17 = 0
            r20 = r1
            r1 = r18
            r5 = r26
            r0 = r12
            r12 = r25
            com.discord.widgets.guildscheduledevent.GuildScheduledEventModel r2 = com.discord.widgets.guildscheduledevent.GuildScheduledEventModel.copy$default(r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L5c
        L57:
            r20 = r1
            r0 = r12
            r19 = 1
        L5c:
            com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime r1 = com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime.INSTANCE
            kotlin.Pair r3 = r1.generateAppropriateStartDateTime()
            com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$ViewState$Initialized r12 = new com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel$ViewState$Initialized
            if (r2 == 0) goto L68
            r0 = r12
            goto L9c
        L68:
            com.discord.widgets.guildscheduledevent.GuildScheduledEventModel r18 = new com.discord.widgets.guildscheduledevent.GuildScheduledEventModel
            r1 = r18
            r4 = 0
            r6 = 0
            java.lang.Object r2 = r3.getFirst()
            r7 = r2
            com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDate r7 = (com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime2) r7
            java.lang.Object r2 = r3.getSecond()
            r8 = r2
            com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerTime r8 = (com.discord.widgets.guildscheduledevent.GuildScheduledEventPickerDateTime3) r8
            r9 = 0
            r10 = 0
            r11 = 0
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata$Companion r2 = com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata.INSTANCE
            r3 = r27
            com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata r13 = r2.a(r0, r3)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r19)
            r15 = 0
            r16 = 4096(0x1000, float:5.74E-42)
            r17 = 0
            r2 = r22
            r5 = r26
            r0 = r12
            r12 = r25
            r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r2 = r18
        L9c:
            r1 = r20
            r0.<init>(r2, r1)
            r1 = r21
            r1.updateViewState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel.<init>(long, java.lang.Long, com.discord.api.guildscheduledevent.GuildScheduledEventEntityType, java.lang.Long, java.lang.String, com.discord.stores.StoreGuildScheduledEvents):void");
    }

    public final boolean isStartDateBeforeEndDate(ViewState.Initialized viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        return isStartDateBeforeEndDate(viewState.getEventModel().getStartDate(), viewState.getEventModel().getStartTime(), viewState.getEventModel().getEndDate(), viewState.getEventModel().getEndTime());
    }
}
