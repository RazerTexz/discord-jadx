package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.stage.StageChannelAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PreviewGuildScheduledEventViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B7\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010(\u001a\u00020'\u0012\b\b\u0002\u0010%\u001a\u00020$¢\u0006\u0004\b0\u00101J/\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u001a\u0010\t\u001a\u0016\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u001a\u0010\t\u001a\u0016\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ3\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u001a\u0010\t\u001a\u0016\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u0004\u0012\u00020\b0\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J;\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\u001a\u0010\t\u001a\u0016\u0012\f\u0012\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\u0018\u0010\u000fJ\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lcom/discord/primitives/GuildScheduledEventId;", "", "onRequestSuccess", "startEvent", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "", "sendNotification", "startStageEvent", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;)V", "createEvent", "editEvent", "setRequestFinished", "()V", "Lcom/discord/api/channel/Channel;", "channel", "canNotifyEveryone", "(Lcom/discord/api/channel/Channel;)Z", "onBottomButtonClicked", "isCreate", "()Z", "currentViewState", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "getCurrentViewState", "()Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "setCurrentViewState", "(Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;)V", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreChannels;", "Lcom/discord/stores/StoreGuildScheduledEvents;", "guildScheduledEventsStore", "Lcom/discord/stores/StoreGuildScheduledEvents;", "Lcom/discord/stores/StorePermissions;", "permissionsStore", "Lcom/discord/stores/StorePermissions;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "eventModel", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;", "existingEventData", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;", "<init>", "(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$ExistingEventData;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuildScheduledEvents;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class PreviewGuildScheduledEventViewModel extends AppViewModel<ViewState> {
    private final StoreChannels channelsStore;
    private ViewState currentViewState;
    private final GuildScheduledEventModel eventModel;
    private final WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StorePermissions permissionsStore;

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "", "<init>", "()V", "Initial", "Initialized", "Invalid", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initial;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: PreviewGuildScheduledEventViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initial;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Initial extends ViewState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        /* compiled from: PreviewGuildScheduledEventViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b!\u0010\u0007R\u0019\u0010\u0013\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b#\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\u000bR\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b(\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b)\u0010\u0004¨\u0006,"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initialized;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "", "component1", "()Z", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "component2", "()Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "component3", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "component4", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "component5", "()Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "requestProcessing", "existingEventAction", "canNotifyEveryone", "locationInfo", "eventModel", "copy", "(ZLcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;ZLcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Initialized;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;", "getExistingEventAction", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;", "getEventModel", "Z", "getRequestProcessing", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;", "getLocationInfo", "isStartingEvent", "getCanNotifyEveryone", "<init>", "(ZLcom/discord/widgets/guildscheduledevent/WidgetPreviewGuildScheduledEvent$Companion$Action;ZLcom/discord/widgets/guildscheduledevent/GuildScheduledEventLocationInfo;Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventModel;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Initialized extends ViewState {
            private final boolean canNotifyEveryone;
            private final GuildScheduledEventModel eventModel;
            private final WidgetPreviewGuildScheduledEvent.Companion.Action existingEventAction;
            private final boolean isStartingEvent;
            private final GuildScheduledEventLocationInfo locationInfo;
            private final boolean requestProcessing;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(boolean z2, WidgetPreviewGuildScheduledEvent.Companion.Action action, boolean z3, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, GuildScheduledEventModel guildScheduledEventModel) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEventLocationInfo, "locationInfo");
                Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "eventModel");
                this.requestProcessing = z2;
                this.existingEventAction = action;
                this.canNotifyEveryone = z3;
                this.locationInfo = guildScheduledEventLocationInfo;
                this.eventModel = guildScheduledEventModel;
                this.isStartingEvent = action == WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, boolean z2, WidgetPreviewGuildScheduledEvent.Companion.Action action, boolean z3, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, GuildScheduledEventModel guildScheduledEventModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = initialized.requestProcessing;
                }
                if ((i & 2) != 0) {
                    action = initialized.existingEventAction;
                }
                WidgetPreviewGuildScheduledEvent.Companion.Action action2 = action;
                if ((i & 4) != 0) {
                    z3 = initialized.canNotifyEveryone;
                }
                boolean z4 = z3;
                if ((i & 8) != 0) {
                    guildScheduledEventLocationInfo = initialized.locationInfo;
                }
                GuildScheduledEventLocationInfo guildScheduledEventLocationInfo2 = guildScheduledEventLocationInfo;
                if ((i & 16) != 0) {
                    guildScheduledEventModel = initialized.eventModel;
                }
                return initialized.copy(z2, action2, z4, guildScheduledEventLocationInfo2, guildScheduledEventModel);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getRequestProcessing() {
                return this.requestProcessing;
            }

            /* renamed from: component2, reason: from getter */
            public final WidgetPreviewGuildScheduledEvent.Companion.Action getExistingEventAction() {
                return this.existingEventAction;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getCanNotifyEveryone() {
                return this.canNotifyEveryone;
            }

            /* renamed from: component4, reason: from getter */
            public final GuildScheduledEventLocationInfo getLocationInfo() {
                return this.locationInfo;
            }

            /* renamed from: component5, reason: from getter */
            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            public final Initialized copy(boolean requestProcessing, WidgetPreviewGuildScheduledEvent.Companion.Action existingEventAction, boolean canNotifyEveryone, GuildScheduledEventLocationInfo locationInfo, GuildScheduledEventModel eventModel) {
                Intrinsics3.checkNotNullParameter(locationInfo, "locationInfo");
                Intrinsics3.checkNotNullParameter(eventModel, "eventModel");
                return new Initialized(requestProcessing, existingEventAction, canNotifyEveryone, locationInfo, eventModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return this.requestProcessing == initialized.requestProcessing && Intrinsics3.areEqual(this.existingEventAction, initialized.existingEventAction) && this.canNotifyEveryone == initialized.canNotifyEveryone && Intrinsics3.areEqual(this.locationInfo, initialized.locationInfo) && Intrinsics3.areEqual(this.eventModel, initialized.eventModel);
            }

            public final boolean getCanNotifyEveryone() {
                return this.canNotifyEveryone;
            }

            public final GuildScheduledEventModel getEventModel() {
                return this.eventModel;
            }

            public final WidgetPreviewGuildScheduledEvent.Companion.Action getExistingEventAction() {
                return this.existingEventAction;
            }

            public final GuildScheduledEventLocationInfo getLocationInfo() {
                return this.locationInfo;
            }

            public final boolean getRequestProcessing() {
                return this.requestProcessing;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v10 */
            /* JADX WARN: Type inference failed for: r0v11 */
            public int hashCode() {
                boolean z2 = this.requestProcessing;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                WidgetPreviewGuildScheduledEvent.Companion.Action action = this.existingEventAction;
                int iHashCode = (i + (action != null ? action.hashCode() : 0)) * 31;
                boolean z3 = this.canNotifyEveryone;
                int i2 = (iHashCode + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
                int iHashCode2 = (i2 + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31;
                GuildScheduledEventModel guildScheduledEventModel = this.eventModel;
                return iHashCode2 + (guildScheduledEventModel != null ? guildScheduledEventModel.hashCode() : 0);
            }

            /* renamed from: isStartingEvent, reason: from getter */
            public final boolean getIsStartingEvent() {
                return this.isStartingEvent;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Initialized(requestProcessing=");
                sbU.append(this.requestProcessing);
                sbU.append(", existingEventAction=");
                sbU.append(this.existingEventAction);
                sbU.append(", canNotifyEveryone=");
                sbU.append(this.canNotifyEveryone);
                sbU.append(", locationInfo=");
                sbU.append(this.locationInfo);
                sbU.append(", eventModel=");
                sbU.append(this.eventModel);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: PreviewGuildScheduledEventViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState$Invalid;", "Lcom/discord/widgets/guildscheduledevent/PreviewGuildScheduledEventViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
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

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventEntityType.STAGE_INSTANCE.ordinal()] = 1;
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$createEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "it", "", "invoke", "(Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$createEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildScheduledEvent, Unit> {
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$onRequestSuccess = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEvent guildScheduledEvent) {
            invoke2(guildScheduledEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEvent guildScheduledEvent) {
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
            this.$onRequestSuccess.invoke(guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getId()) : null);
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$editEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$editEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1, long j) {
            super(1);
            this.$onRequestSuccess = function1;
            this.$eventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
            this.$onRequestSuccess.invoke(Long.valueOf(this.$eventId));
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1, long j) {
            super(1);
            this.$onRequestSuccess = function1;
            this.$eventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
            this.$onRequestSuccess.invoke(Long.valueOf(this.$eventId));
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startStageEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
        }
    }

    /* compiled from: PreviewGuildScheduledEventViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/stageinstance/StageInstance;", "it", "", "invoke", "(Lcom/discord/api/stageinstance/StageInstance;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel$startStageEvent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<StageInstance, Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ Function1 $onRequestSuccess;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1, Long l) {
            super(1);
            this.$onRequestSuccess = function1;
            this.$eventId = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(stageInstance, "it");
            PreviewGuildScheduledEventViewModel.access$setRequestFinished(PreviewGuildScheduledEventViewModel.this);
            this.$onRequestSuccess.invoke(this.$eventId);
        }
    }

    public /* synthetic */ PreviewGuildScheduledEventViewModel(GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildScheduledEventModel, existingEventData, (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    public static final /* synthetic */ void access$setRequestFinished(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel) {
        previewGuildScheduledEventViewModel.setRequestFinished();
    }

    private final boolean canNotifyEveryone(Channel channel) {
        Long l;
        if (channel == null || !ChannelUtils.D(channel) || (l = (Long) outline.d(channel, this.permissionsStore.getPermissionsByChannel())) == null) {
            return false;
        }
        return PermissionUtils.can(Permission.MENTION_EVERYONE, Long.valueOf(l.longValue()));
    }

    private final void createEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        RestAPIParams.CreateGuildScheduledEventBody createRequestBody = this.eventModel.toCreateRequestBody();
        if (createRequestBody != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createGuildScheduledEvent(this.eventModel.getGuildId(), createRequestBody), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(onRequestSuccess), 52, (Object) null);
        }
    }

    private final void editEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        long guildScheduledEventId;
        GuildScheduledEvent guildScheduledEventFindEventFromStore;
        RestAPIParams.UpdateGuildScheduledEventBody updateRequestBody;
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        if (existingEventData == null || (guildScheduledEventFindEventFromStore = this.guildScheduledEventsStore.findEventFromStore((guildScheduledEventId = existingEventData.getGuildScheduledEventId()), Long.valueOf(this.eventModel.getGuildId()))) == null || (updateRequestBody = this.eventModel.toUpdateRequestBody(guildScheduledEventFindEventFromStore)) == null) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuildScheduledEvent(guildScheduledEventFindEventFromStore.getGuildId(), guildScheduledEventId, updateRequestBody), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(onRequestSuccess, guildScheduledEventId), 52, (Object) null);
    }

    public static /* synthetic */ void onBottomButtonClicked$default(PreviewGuildScheduledEventViewModel previewGuildScheduledEventViewModel, Context context, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        previewGuildScheduledEventViewModel.onBottomButtonClicked(context, z2, function1);
    }

    private final void setRequestFinished() {
        ViewState viewStateRequireViewState = requireViewState();
        Objects.requireNonNull(viewStateRequireViewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel.ViewState.Initialized");
        updateViewState(ViewState.Initialized.copy$default((ViewState.Initialized) viewStateRequireViewState, false, null, false, null, null, 30, null));
    }

    private final void startEvent(Context context, Function1<? super Long, Unit> onRequestSuccess) {
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        if (existingEventData != null) {
            long guildScheduledEventId = existingEventData.getGuildScheduledEventId();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.startEvent(this.eventModel.getGuildId(), guildScheduledEventId), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(onRequestSuccess, guildScheduledEventId), 52, (Object) null);
        }
    }

    private final void startStageEvent(Context context, boolean sendNotification, Function1<? super Long, Unit> onRequestSuccess) {
        if (this.eventModel.getName() == null || this.eventModel.getChannelId() == null) {
            return;
        }
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        Long lValueOf = existingEventData != null ? Long.valueOf(existingEventData.getGuildScheduledEventId()) : null;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.INSTANCE.startStageInstance(this.eventModel.getChannelId().longValue(), this.eventModel.getName(), StageInstancePrivacyLevel.GUILD_ONLY, sendNotification, String.valueOf(lValueOf)), false, 1, null), this, null, 2, null), PreviewGuildScheduledEventViewModel.class, context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(onRequestSuccess, lValueOf), 52, (Object) null);
    }

    public final ViewState getCurrentViewState() {
        return this.currentViewState;
    }

    public final boolean isCreate() {
        return this.existingEventData == null;
    }

    public final void onBottomButtonClicked(Context context, boolean sendNotification, Function1<? super Long, Unit> onRequestSuccess) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onRequestSuccess, "onRequestSuccess");
        ViewState viewState = this.currentViewState;
        Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.guildscheduledevent.PreviewGuildScheduledEventViewModel.ViewState.Initialized");
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized.getRequestProcessing()) {
            return;
        }
        updateViewState(ViewState.Initialized.copy$default(initialized, true, null, false, null, null, 30, null));
        WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData = this.existingEventData;
        if (existingEventData == null) {
            createEvent(context, onRequestSuccess);
            return;
        }
        if (existingEventData.getAction() == WidgetPreviewGuildScheduledEvent.Companion.Action.EDIT_EVENT) {
            editEvent(context, onRequestSuccess);
        } else if (this.eventModel.getEntityType().ordinal() != 1) {
            startEvent(context, onRequestSuccess);
        } else {
            startStageEvent(context, sendNotification, onRequestSuccess);
        }
    }

    public final void setCurrentViewState(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "<set-?>");
        this.currentViewState = viewState;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreviewGuildScheduledEventViewModel(GuildScheduledEventModel guildScheduledEventModel, WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData existingEventData, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(ViewState.Initial.INSTANCE);
        Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "eventModel");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        this.eventModel = guildScheduledEventModel;
        this.existingEventData = existingEventData;
        this.channelsStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        boolean z2 = (existingEventData != null ? existingEventData.getAction() : null) == WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT;
        Long channelId = guildScheduledEventModel.getChannelId();
        Channel channel = channelId != null ? storeChannels.getChannel(channelId.longValue()) : null;
        ViewState.Initialized initialized = new ViewState.Initialized(false, existingEventData != null ? existingEventData.getAction() : null, z2 && canNotifyEveryone(channel), GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(guildScheduledEventModel, channel), guildScheduledEventModel);
        this.currentViewState = initialized;
        updateViewState(initialized);
    }
}
