package com.discord.widgets.status;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.status.WidgetThreadStatus;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetThreadStatusViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004&'()B\u0017\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0015J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u001aR:\u0010\"\u001a&\u0012\f\u0012\n !*\u0004\u0018\u00010\u00180\u0018 !*\u0012\u0012\f\u0012\n !*\u0004\u0018\u00010\u00180\u0018\u0018\u00010 0 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006*"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "status", "", "updateViewWithStatus", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;)V", "", "isLoading", "updateViewLoading", "(Z)V", "", ModelAuditLogEntry.CHANGE_KEY_CODE, "emitError", "(I)V", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;)V", "onJoinTapped", "()V", "onUnarchiveTapped", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetThreadStatus$Event;", "observeEvents", "()Lrx/Observable;", "currentStoreState", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "storeStateObservable", "Lrx/Observable;", "getStoreStateObservable", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "<init>", "(Lrx/Observable;)V", "Companion", "Status", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StoreState currentStoreState;
    private final PublishSubject<WidgetThreadStatus.Event> eventSubject;
    private final Observable<StoreState> storeStateObservable;

    /* compiled from: WidgetThreadStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetThreadStatusViewModel.access$handleStoreState(WidgetThreadStatusViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetThreadStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011JG\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Companion;", "", "Lcom/discord/stores/StoreThreadsActiveJoined;", "storeThreadsActiveJoined", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannels;", "storeChannels", "Lcom/discord/stores/StorePermissions;", "storePermissions", "Lcom/discord/stores/StoreExperiments;", "storeExperiments", "Lrx/Observable;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreThreadsActiveJoined;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreChannels;Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreExperiments;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreThreadsActiveJoined storeThreadsActiveJoined, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StorePermissions storePermissions, StoreExperiments storeExperiments) {
            Observable<R> observableG = storeChannelsSelected.observeSelectedChannel().y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.Y(new WidgetThreadStatusViewModel6(storeThreadsActiveJoined, storePermissions, storeChannels, storeExperiments));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…ntilChanged()\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StorePermissions storePermissions, StoreExperiments storeExperiments, int i, Object obj) {
            if ((i & 1) != 0) {
                storeThreadsActiveJoined = StoreStream.INSTANCE.getThreadsActiveJoined();
            }
            if ((i & 2) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            StorePermissions storePermissions2 = storePermissions;
            if ((i & 16) != 0) {
                storeExperiments = StoreStream.INSTANCE.getExperiments();
            }
            return companion.observeStoreState(storeThreadsActiveJoined, storeChannelsSelected2, storeChannels2, storePermissions2, storeExperiments);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "", "<init>", "()V", "Archived", "Hide", "Unjoined", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Hide;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Unjoined;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Archived;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Status {

        /* compiled from: WidgetThreadStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0006\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Archived;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "", "component1", "()Z", "component2", "isLocked", "canArchive", "copy", "(ZZ)Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Archived;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCanArchive", "<init>", "(ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Archived extends Status {
            private final boolean canArchive;
            private final boolean isLocked;

            public Archived(boolean z2, boolean z3) {
                super(null);
                this.isLocked = z2;
                this.canArchive = z3;
            }

            public static /* synthetic */ Archived copy$default(Archived archived, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = archived.isLocked;
                }
                if ((i & 2) != 0) {
                    z3 = archived.canArchive;
                }
                return archived.copy(z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsLocked() {
                return this.isLocked;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getCanArchive() {
                return this.canArchive;
            }

            public final Archived copy(boolean isLocked, boolean canArchive) {
                return new Archived(isLocked, canArchive);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Archived)) {
                    return false;
                }
                Archived archived = (Archived) other;
                return this.isLocked == archived.isLocked && this.canArchive == archived.canArchive;
            }

            public final boolean getCanArchive() {
                return this.canArchive;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.isLocked;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.canArchive;
                return i + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isLocked() {
                return this.isLocked;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Archived(isLocked=");
                sbU.append(this.isLocked);
                sbU.append(", canArchive=");
                return outline.O(sbU, this.canArchive, ")");
            }
        }

        /* compiled from: WidgetThreadStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Hide;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Hide extends Status {
            public static final Hide INSTANCE = new Hide();

            private Hide() {
                super(null);
            }
        }

        /* compiled from: WidgetThreadStatusViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status$Unjoined;", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Unjoined extends Status {
            public static final Unjoined INSTANCE = new Unjoined();

            private Unjoined() {
                super(null);
            }
        }

        private Status() {
        }

        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012&\u0010\u0011\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b*\u0010+J0\u0010\u0006\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJp\u0010\u0017\u001a\u00020\u00002(\b\u0002\u0010\u0011\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0014\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b%\u0010\u000eR\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b&\u0010\u000eR9\u0010\u0011\u001a\"\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\u0007R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b)\u0010\nR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b\u0015\u0010\u000e¨\u0006,"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/stores/StoreThreadsActiveJoined$ActiveJoinedThread;", "component1", "()Ljava/util/Map;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "component3", "", "component4", "()Z", "component5", "component6", "activeJoinedThreads", "selectedChannel", "parentChannel", "canArchive", "isModerator", "canAccessRedesignedForumChannels", "copy", "(Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;ZZZ)Lcom/discord/widgets/status/WidgetThreadStatusViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/channel/Channel;", "getSelectedChannel", "Z", "getCanArchive", "getCanAccessRedesignedForumChannels", "Ljava/util/Map;", "getActiveJoinedThreads", "getParentChannel", "<init>", "(Ljava/util/Map;Lcom/discord/api/channel/Channel;Lcom/discord/api/channel/Channel;ZZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedThreads;
        private final boolean canAccessRedesignedForumChannels;
        private final boolean canArchive;
        private final boolean isModerator;
        private final Channel parentChannel;
        private final Channel selectedChannel;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map, Channel channel, Channel channel2, boolean z2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(map, "activeJoinedThreads");
            this.activeJoinedThreads = map;
            this.selectedChannel = channel;
            this.parentChannel = channel2;
            this.canArchive = z2;
            this.isModerator = z3;
            this.canAccessRedesignedForumChannels = z4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, Channel channel, Channel channel2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.activeJoinedThreads;
            }
            if ((i & 2) != 0) {
                channel = storeState.selectedChannel;
            }
            Channel channel3 = channel;
            if ((i & 4) != 0) {
                channel2 = storeState.parentChannel;
            }
            Channel channel4 = channel2;
            if ((i & 8) != 0) {
                z2 = storeState.canArchive;
            }
            boolean z5 = z2;
            if ((i & 16) != 0) {
                z3 = storeState.isModerator;
            }
            boolean z6 = z3;
            if ((i & 32) != 0) {
                z4 = storeState.canAccessRedesignedForumChannels;
            }
            return storeState.copy(map, channel3, channel4, z5, z6, z4);
        }

        public final Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> component1() {
            return this.activeJoinedThreads;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCanArchive() {
            return this.canArchive;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        public final StoreState copy(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedThreads, Channel selectedChannel, Channel parentChannel, boolean canArchive, boolean isModerator, boolean canAccessRedesignedForumChannels) {
            Intrinsics3.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            return new StoreState(activeJoinedThreads, selectedChannel, parentChannel, canArchive, isModerator, canAccessRedesignedForumChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.activeJoinedThreads, storeState.activeJoinedThreads) && Intrinsics3.areEqual(this.selectedChannel, storeState.selectedChannel) && Intrinsics3.areEqual(this.parentChannel, storeState.parentChannel) && this.canArchive == storeState.canArchive && this.isModerator == storeState.isModerator && this.canAccessRedesignedForumChannels == storeState.canAccessRedesignedForumChannels;
        }

        public final Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        public final boolean getCanArchive() {
            return this.canArchive;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map = this.activeJoinedThreads;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Channel channel = this.selectedChannel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            boolean z2 = this.canArchive;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            boolean z3 = this.isModerator;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.canAccessRedesignedForumChannels;
            return i4 + (z4 ? 1 : z4 ? 1 : 0);
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(activeJoinedThreads=");
            sbU.append(this.activeJoinedThreads);
            sbU.append(", selectedChannel=");
            sbU.append(this.selectedChannel);
            sbU.append(", parentChannel=");
            sbU.append(this.parentChannel);
            sbU.append(", canArchive=");
            sbU.append(this.canArchive);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", canAccessRedesignedForumChannels=");
            return outline.O(sbU, this.canAccessRedesignedForumChannels, ")");
        }
    }

    /* compiled from: WidgetThreadStatusViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\t\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;", "", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "component1", "()Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "", "component2", "()Z", "threadStatus", "isLoading", "copy", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;Z)Lcom/discord/widgets/status/WidgetThreadStatusViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;", "getThreadStatus", "<init>", "(Lcom/discord/widgets/status/WidgetThreadStatusViewModel$Status;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Status threadStatus;

        public ViewState(Status status, boolean z2) {
            Intrinsics3.checkNotNullParameter(status, "threadStatus");
            this.threadStatus = status;
            this.isLoading = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Status status, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                status = viewState.threadStatus;
            }
            if ((i & 2) != 0) {
                z2 = viewState.isLoading;
            }
            return viewState.copy(status, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Status getThreadStatus() {
            return this.threadStatus;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final ViewState copy(Status threadStatus, boolean isLoading) {
            Intrinsics3.checkNotNullParameter(threadStatus, "threadStatus");
            return new ViewState(threadStatus, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.threadStatus, viewState.threadStatus) && this.isLoading == viewState.isLoading;
        }

        public final Status getThreadStatus() {
            return this.threadStatus;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Status status = this.threadStatus;
            int iHashCode = (status != null ? status.hashCode() : 0) * 31;
            boolean z2 = this.isLoading;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(threadStatus=");
            sbU.append(this.threadStatus);
            sbU.append(", isLoading=");
            return outline.O(sbU, this.isLoading, ")");
        }

        public /* synthetic */ ViewState(Status status, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(status, (i & 2) != 0 ? false : z2);
        }
    }

    public WidgetThreadStatusViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetThreadStatusViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, null, null, null, 31, null) : observable);
    }

    public static final /* synthetic */ void access$emitError(WidgetThreadStatusViewModel widgetThreadStatusViewModel, int i) {
        widgetThreadStatusViewModel.emitError(i);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadStatusViewModel widgetThreadStatusViewModel, StoreState storeState) {
        widgetThreadStatusViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewLoading(WidgetThreadStatusViewModel widgetThreadStatusViewModel, boolean z2) {
        widgetThreadStatusViewModel.updateViewLoading(z2);
    }

    private final void emitError(int code) {
        PublishSubject<WidgetThreadStatus.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetThreadStatus.Event.Error(code));
    }

    private final void handleStoreState(StoreState storeState) {
        Status archived;
        this.currentStoreState = storeState;
        Channel selectedChannel = storeState.getSelectedChannel();
        Channel parentChannel = storeState.getParentChannel();
        Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedThreads = storeState.getActiveJoinedThreads();
        Channel selectedChannel2 = storeState.getSelectedChannel();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map = activeJoinedThreads.get(selectedChannel2 != null ? Long.valueOf(selectedChannel2.getParentId()) : null);
        if (map != null) {
            Channel selectedChannel3 = storeState.getSelectedChannel();
            activeJoinedThread = map.get(selectedChannel3 != null ? Long.valueOf(selectedChannel3.getId()) : null);
        }
        boolean z2 = false;
        boolean z3 = activeJoinedThread != null;
        if (selectedChannel == null || !ChannelUtils.H(selectedChannel)) {
            archived = Status.Hide.INSTANCE;
        } else if (parentChannel != null && ChannelUtils.q(parentChannel) && storeState.getCanAccessRedesignedForumChannels()) {
            archived = Status.Hide.INSTANCE;
        } else {
            ThreadMetadata threadMetadata = selectedChannel.getThreadMetadata();
            if (threadMetadata == null || !threadMetadata.getArchived()) {
                archived = z3 ? Status.Hide.INSTANCE : Status.Unjoined.INSTANCE;
            } else {
                ThreadMetadata threadMetadata2 = selectedChannel.getThreadMetadata();
                if (threadMetadata2 != null && threadMetadata2.getLocked()) {
                    z2 = true;
                }
                archived = new Status.Archived(z2, storeState.getCanArchive());
            }
        }
        updateViewWithStatus(archived);
    }

    private final void updateViewLoading(boolean isLoading) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, null, isLoading, 1, null));
        }
    }

    private final void updateViewWithStatus(Status status) {
        updateViewState(new ViewState(status, false, 2, null));
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<WidgetThreadStatus.Event> observeEvents() {
        PublishSubject<WidgetThreadStatus.Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onJoinTapped() {
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            if (storeState.getSelectedChannel() == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(storeState.getSelectedChannel().getId(), "Banner", new RestAPIParams.EmptyBody()), false, 1, null), this, null, 2, null), WidgetThreadStatusViewModel.class, (Context) null, (Function1) null, new WidgetThreadStatusViewModel2(this), (Function0) null, new WidgetThreadStatusViewModel3(this), WidgetThreadStatusViewModel7.INSTANCE, 22, (Object) null);
        }
        updateViewLoading(true);
    }

    public final void onUnarchiveTapped() {
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            if (storeState.getSelectedChannel() == null) {
                return;
            }
            RestAPI api = RestAPI.INSTANCE.getApi();
            long id2 = storeState.getSelectedChannel().getId();
            Boolean bool = Boolean.FALSE;
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, storeState.isModerator() ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), WidgetThreadStatusViewModel.class, (Context) null, (Function1) null, new WidgetThreadStatusViewModel4(this), (Function0) null, new WidgetThreadStatusViewModel5(this), WidgetThreadStatusViewModel8.INSTANCE, 22, (Object) null);
        }
        updateViewLoading(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatusViewModel(Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetThreadStatusViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
