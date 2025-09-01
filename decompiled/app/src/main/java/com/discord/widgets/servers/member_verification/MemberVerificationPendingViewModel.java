package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: MemberVerificationPendingViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005#$%&'B7\u0012\n\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\tJ\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\tJ\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\tR\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00060\u001bj\u0002`\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u001f¨\u0006("}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;)V", "onResetSuccess", "()V", "Lrx/Observable;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;", "dialogState", "updateDialogState", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;)V", "leaveGuild", "resetGuildJoinRequest", "deleteGuildJoinRequest", "Lrx/subjects/PublishSubject;", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;", "storeObservable", "<init>", "(JLcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Companion", "DialogState", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MemberVerificationPendingViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DialogState dialogState;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$1, reason: invalid class name */
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
            MemberVerificationPendingViewModel.access$handleStoreState(MemberVerificationPendingViewModel.this, storeState);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lrx/Observable;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "observeStores", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, long j) {
            return companion.observeStores(j);
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableI = Observable.i(companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), MemberVerificationPendingViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…Reason,\n        )\n      }");
            return observableI;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;", "", "<init>", "(Ljava/lang/String;I)V", "UPGRADE", "PENDING", "CANCEL", "REJECTED", "LEAVE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum DialogState {
        UPGRADE,
        PENDING,
        CANCEL,
        REJECTED,
        LEAVE
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event;", "", "<init>", "()V", "Error", "Success", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event$Success;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: MemberVerificationPendingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event$Error;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: MemberVerificationPendingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event$Success;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends Event {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0012\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\r\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\f\u0010\u0004¨\u0006 "}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "", "", "component1", "()Z", "component2", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "component3", "()Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "", "component4", "()Ljava/lang/String;", "isFormOutdated", "isPreviewEnabled", "applicationStatus", "rejectionReason", "copy", "(ZZLcom/discord/api/guildjoinrequest/ApplicationStatus;Ljava/lang/String;)Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$StoreState;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "getApplicationStatus", "Ljava/lang/String;", "getRejectionReason", "<init>", "(ZZLcom/discord/api/guildjoinrequest/ApplicationStatus;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final ApplicationStatus applicationStatus;
        private final boolean isFormOutdated;
        private final boolean isPreviewEnabled;
        private final String rejectionReason;

        public StoreState(boolean z2, boolean z3, ApplicationStatus applicationStatus, String str) {
            Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
            this.isFormOutdated = z2;
            this.isPreviewEnabled = z3;
            this.applicationStatus = applicationStatus;
            this.rejectionReason = str;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, boolean z2, boolean z3, ApplicationStatus applicationStatus, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = storeState.isFormOutdated;
            }
            if ((i & 2) != 0) {
                z3 = storeState.isPreviewEnabled;
            }
            if ((i & 4) != 0) {
                applicationStatus = storeState.applicationStatus;
            }
            if ((i & 8) != 0) {
                str = storeState.rejectionReason;
            }
            return storeState.copy(z2, z3, applicationStatus, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsFormOutdated() {
            return this.isFormOutdated;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsPreviewEnabled() {
            return this.isPreviewEnabled;
        }

        /* renamed from: component3, reason: from getter */
        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRejectionReason() {
            return this.rejectionReason;
        }

        public final StoreState copy(boolean isFormOutdated, boolean isPreviewEnabled, ApplicationStatus applicationStatus, String rejectionReason) {
            Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
            return new StoreState(isFormOutdated, isPreviewEnabled, applicationStatus, rejectionReason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return this.isFormOutdated == storeState.isFormOutdated && this.isPreviewEnabled == storeState.isPreviewEnabled && Intrinsics3.areEqual(this.applicationStatus, storeState.applicationStatus) && Intrinsics3.areEqual(this.rejectionReason, storeState.rejectionReason);
        }

        public final ApplicationStatus getApplicationStatus() {
            return this.applicationStatus;
        }

        public final String getRejectionReason() {
            return this.rejectionReason;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z2 = this.isFormOutdated;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isPreviewEnabled;
            int i2 = (i + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            ApplicationStatus applicationStatus = this.applicationStatus;
            int iHashCode = (i2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
            String str = this.rejectionReason;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public final boolean isFormOutdated() {
            return this.isFormOutdated;
        }

        public final boolean isPreviewEnabled() {
            return this.isPreviewEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(isFormOutdated=");
            sbU.append(this.isFormOutdated);
            sbU.append(", isPreviewEnabled=");
            sbU.append(this.isPreviewEnabled);
            sbU.append(", applicationStatus=");
            sbU.append(this.applicationStatus);
            sbU.append(", rejectionReason=");
            return outline.J(sbU, this.rejectionReason, ")");
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: MemberVerificationPendingViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u0019\u0010\u000f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0010\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u0010\u0010\u0007R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010\u0004¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState;", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;", "component1", "()Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;", "", "component2", "()Z", "component3", "component4", "", "component5", "()Ljava/lang/String;", "dialogState", "showPendingImage", "showTertiaryButton", "isPreviewEnabled", "rejectionReason", "copy", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;ZZZLjava/lang/String;)Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$ViewState$Loaded;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getShowPendingImage", "Ljava/lang/String;", "getRejectionReason", "getShowTertiaryButton", "Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;", "getDialogState", "<init>", "(Lcom/discord/widgets/servers/member_verification/MemberVerificationPendingViewModel$DialogState;ZZZLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final DialogState dialogState;
            private final boolean isPreviewEnabled;
            private final String rejectionReason;
            private final boolean showPendingImage;
            private final boolean showTertiaryButton;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(DialogState dialogState, boolean z2, boolean z3, boolean z4, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
                this.dialogState = dialogState;
                this.showPendingImage = z2;
                this.showTertiaryButton = z3;
                this.isPreviewEnabled = z4;
                this.rejectionReason = str;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, DialogState dialogState, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    dialogState = loaded.dialogState;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.showPendingImage;
                }
                boolean z5 = z2;
                if ((i & 4) != 0) {
                    z3 = loaded.showTertiaryButton;
                }
                boolean z6 = z3;
                if ((i & 8) != 0) {
                    z4 = loaded.isPreviewEnabled;
                }
                boolean z7 = z4;
                if ((i & 16) != 0) {
                    str = loaded.rejectionReason;
                }
                return loaded.copy(dialogState, z5, z6, z7, str);
            }

            /* renamed from: component1, reason: from getter */
            public final DialogState getDialogState() {
                return this.dialogState;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getShowPendingImage() {
                return this.showPendingImage;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getShowTertiaryButton() {
                return this.showTertiaryButton;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getIsPreviewEnabled() {
                return this.isPreviewEnabled;
            }

            /* renamed from: component5, reason: from getter */
            public final String getRejectionReason() {
                return this.rejectionReason;
            }

            public final Loaded copy(DialogState dialogState, boolean showPendingImage, boolean showTertiaryButton, boolean isPreviewEnabled, String rejectionReason) {
                Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
                return new Loaded(dialogState, showPendingImage, showTertiaryButton, isPreviewEnabled, rejectionReason);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.dialogState, loaded.dialogState) && this.showPendingImage == loaded.showPendingImage && this.showTertiaryButton == loaded.showTertiaryButton && this.isPreviewEnabled == loaded.isPreviewEnabled && Intrinsics3.areEqual(this.rejectionReason, loaded.rejectionReason);
            }

            public final DialogState getDialogState() {
                return this.dialogState;
            }

            public final String getRejectionReason() {
                return this.rejectionReason;
            }

            public final boolean getShowPendingImage() {
                return this.showPendingImage;
            }

            public final boolean getShowTertiaryButton() {
                return this.showTertiaryButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                DialogState dialogState = this.dialogState;
                int iHashCode = (dialogState != null ? dialogState.hashCode() : 0) * 31;
                boolean z2 = this.showPendingImage;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.showTertiaryButton;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (i2 + i3) * 31;
                boolean z4 = this.isPreviewEnabled;
                int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
                String str = this.rejectionReason;
                return i5 + (str != null ? str.hashCode() : 0);
            }

            public final boolean isPreviewEnabled() {
                return this.isPreviewEnabled;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(dialogState=");
                sbU.append(this.dialogState);
                sbU.append(", showPendingImage=");
                sbU.append(this.showPendingImage);
                sbU.append(", showTertiaryButton=");
                sbU.append(this.showTertiaryButton);
                sbU.append(", isPreviewEnabled=");
                sbU.append(this.isPreviewEnabled);
                sbU.append(", rejectionReason=");
                return outline.J(sbU, this.rejectionReason, ")");
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
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.PENDING.ordinal()] = 1;
            iArr[ApplicationStatus.REJECTED.ordinal()] = 2;
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$1, reason: invalid class name */
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
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationFormResponse;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelMemberVerificationFormResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$deleteGuildJoinRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            MemberVerificationPendingViewModel.access$onResetSuccess(MemberVerificationPendingViewModel.this);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$1, reason: invalid class name */
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
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$leaveGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Success.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$1, reason: invalid class name */
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
            PublishSubject publishSubjectAccess$getEventSubject$p = MemberVerificationPendingViewModel.access$getEventSubject$p(MemberVerificationPendingViewModel.this);
            publishSubjectAccess$getEventSubject$p.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* compiled from: MemberVerificationPendingViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationFormResponse;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelMemberVerificationFormResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel$resetGuildJoinRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            Intrinsics3.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
            MemberVerificationPendingViewModel.access$onResetSuccess(MemberVerificationPendingViewModel.this);
        }
    }

    public /* synthetic */ MemberVerificationPendingViewModel(long j, DialogState dialogState, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, dialogState, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? Companion.access$observeStores(INSTANCE, j) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        return memberVerificationPendingViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(MemberVerificationPendingViewModel memberVerificationPendingViewModel, StoreState storeState) {
        memberVerificationPendingViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$onResetSuccess(MemberVerificationPendingViewModel memberVerificationPendingViewModel) {
        memberVerificationPendingViewModel.onResetSuccess();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        DialogState dialogState = this.dialogState;
        if (dialogState == null) {
            int iOrdinal = storeState.getApplicationStatus().ordinal();
            dialogState = iOrdinal != 1 ? iOrdinal != 2 ? null : DialogState.REJECTED : storeState.isPreviewEnabled() ? DialogState.CANCEL : DialogState.PENDING;
        }
        DialogState dialogState2 = dialogState;
        if (storeState.isFormOutdated()) {
            updateViewState(new ViewState.Loaded(DialogState.UPGRADE, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        } else if (dialogState2 != null) {
            updateViewState(new ViewState.Loaded(dialogState2, true, false, storeState.isPreviewEnabled(), storeState.getRejectionReason()));
        }
    }

    private final void onResetSuccess() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.Success.INSTANCE);
    }

    public final void deleteGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.deleteGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void leaveGuild() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final Observable<Event> observeEvents() {
        return this.eventSubject;
    }

    public final void resetGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.resetGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void updateDialogState(DialogState dialogState) {
        Intrinsics3.checkNotNullParameter(dialogState, "dialogState");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            DialogState dialogState2 = DialogState.PENDING;
            updateViewState(ViewState.Loaded.copy$default(loaded, dialogState, dialogState == dialogState2, dialogState == dialogState2 && !loaded.isPreviewEnabled(), false, null, 24, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingViewModel(long j, DialogState dialogState, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.dialogState = dialogState;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), MemberVerificationPendingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
