package com.discord.widgets.tos;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.report.ReportReason;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIInterface;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserProfile;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: WidgetTosReportViolationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\"#B\u001f\u0012\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010\u0012\n\u0010\u0013\u001a\u00060\u000fj\u0002`\u0012¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\n\u0010\u0013\u001a\u00060\u000fj\u0002`\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0016\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0013\u001a\u00060\u000fj\u0002`\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u001a\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001f¨\u0006$"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", "storeState", "", "generateViewState", "(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;)V", "Lrx/Observable;", "observeStoreState", "()Lrx/Observable;", "sendReport", "()V", "", ModelAuditLogEntry.CHANGE_KEY_REASON, "", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/primitives/MessageId;", "messageId", "sendReportAPICall", "(IJJ)V", "handleDismissError", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", "Lcom/discord/api/report/ReportReason;", "reasonSelected", "Lcom/discord/api/report/ReportReason;", "getReasonSelected", "()Lcom/discord/api/report/ReportReason;", "setReasonSelected", "(Lcom/discord/api/report/ReportReason;)V", "J", "<init>", "(JJ)V", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetTosReportViolationViewModel extends AppViewModel<ViewState> {
    private final long channelId;
    private final long messageId;
    private ReportReason reasonSelected;
    private StoreState storeState;

    /* compiled from: WidgetTosReportViolationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel) {
            super(1, widgetTosReportViolationViewModel, WidgetTosReportViolationViewModel.class, "generateViewState", "generateViewState(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            WidgetTosReportViolationViewModel.access$generateViewState((WidgetTosReportViolationViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: WidgetTosReportViolationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", "", "<init>", "()V", "ReportReasons", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState$ReportReasons;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class StoreState {

        /* compiled from: WidgetTosReportViolationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState$ReportReasons;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", "", "Lcom/discord/api/report/ReportReason;", "component1", "()Ljava/util/List;", "reasons", "copy", "(Ljava/util/List;)Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState$ReportReasons;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getReasons", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ReportReasons extends StoreState {
            private final List<ReportReason> reasons;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReportReasons(List<ReportReason> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "reasons");
                this.reasons = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ReportReasons copy$default(ReportReasons reportReasons, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = reportReasons.reasons;
                }
                return reportReasons.copy(list);
            }

            public final List<ReportReason> component1() {
                return this.reasons;
            }

            public final ReportReasons copy(List<ReportReason> reasons) {
                Intrinsics3.checkNotNullParameter(reasons, "reasons");
                return new ReportReasons(reasons);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReportReasons) && Intrinsics3.areEqual(this.reasons, ((ReportReasons) other).reasons);
                }
                return true;
            }

            public final List<ReportReason> getReasons() {
                return this.reasons;
            }

            public int hashCode() {
                List<ReportReason> list = this.reasons;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("ReportReasons(reasons="), this.reasons, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTosReportViolationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "", "<init>", "()V", "Loaded", "Loading", "SubmissionError", "Submitted", "Submitting", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Loading;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Submitting;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Submitted;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$SubmissionError;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetTosReportViolationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Loaded;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "", "Lcom/discord/api/report/ReportReason;", "component1", "()Ljava/util/List;", "reasons", "copy", "(Ljava/util/List;)Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Loaded;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getReasons", "<init>", "(Ljava/util/List;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final List<ReportReason> reasons;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<ReportReason> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "reasons");
                this.reasons = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.reasons;
                }
                return loaded.copy(list);
            }

            public final List<ReportReason> component1() {
                return this.reasons;
            }

            public final Loaded copy(List<ReportReason> reasons) {
                Intrinsics3.checkNotNullParameter(reasons, "reasons");
                return new Loaded(reasons);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.reasons, ((Loaded) other).reasons);
                }
                return true;
            }

            public final List<ReportReason> getReasons() {
                return this.reasons;
            }

            public int hashCode() {
                List<ReportReason> list = this.reasons;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Loaded(reasons="), this.reasons, ")");
            }
        }

        /* compiled from: WidgetTosReportViolationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Loading;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: WidgetTosReportViolationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$SubmissionError;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class SubmissionError extends ViewState {
            public static final SubmissionError INSTANCE = new SubmissionError();

            private SubmissionError() {
                super(null);
            }
        }

        /* compiled from: WidgetTosReportViolationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Submitted;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Submitted extends ViewState {
            public static final Submitted INSTANCE = new Submitted();

            private Submitted() {
                super(null);
            }
        }

        /* compiled from: WidgetTosReportViolationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Submitting;", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;", "", "component1", "()I", ModelAuditLogEntry.CHANGE_KEY_REASON, "copy", "(I)Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState$Submitting;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getReason", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Submitting extends ViewState {
            private final int reason;

            public Submitting(int i) {
                super(null);
                this.reason = i;
            }

            public static /* synthetic */ Submitting copy$default(Submitting submitting, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = submitting.reason;
                }
                return submitting.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getReason() {
                return this.reason;
            }

            public final Submitting copy(int reason) {
                return new Submitting(reason);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Submitting) && this.reason == ((Submitting) other).reason;
                }
                return true;
            }

            public final int getReason() {
                return this.reason;
            }

            public int hashCode() {
                return this.reason;
            }

            public String toString() {
                return outline.B(outline.U("Submitting(reason="), this.reason, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTosReportViolationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/discord/api/report/ReportReason;", "kotlin.jvm.PlatformType", "reportReasons", "Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/List;)Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$observeStoreState$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends ReportReason>, StoreState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ StoreState call(List<? extends ReportReason> list) {
            return call2((List<ReportReason>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(List<ReportReason> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "reportReasons");
            return new StoreState.ReportReasons(list);
        }
    }

    /* compiled from: WidgetTosReportViolationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$1, reason: invalid class name */
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
            WidgetTosReportViolationViewModel.access$updateViewState(WidgetTosReportViolationViewModel.this, ViewState.SubmissionError.INSTANCE);
        }
    }

    /* compiled from: WidgetTosReportViolationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolationViewModel$sendReportAPICall$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            WidgetTosReportViolationViewModel.access$updateViewState(WidgetTosReportViolationViewModel.this, ViewState.Submitted.INSTANCE);
        }
    }

    public WidgetTosReportViolationViewModel(long j, long j2) {
        super(ViewState.Loading.INSTANCE);
        this.channelId = j;
        this.messageId = j2;
        Observable<StoreState> observableR = observeStoreState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStoreState()\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetTosReportViolationViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    public static final /* synthetic */ void access$generateViewState(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, StoreState storeState) {
        widgetTosReportViolationViewModel.generateViewState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetTosReportViolationViewModel widgetTosReportViolationViewModel, ViewState viewState) {
        widgetTosReportViolationViewModel.updateViewState(viewState);
    }

    @MainThread
    private final void generateViewState(StoreState storeState) {
        this.storeState = storeState;
        if (storeState instanceof StoreState.ReportReasons) {
            updateViewState(new ViewState.Loaded(((StoreState.ReportReasons) storeState).getReasons()));
        }
    }

    private final Observable<StoreState> observeStoreState() {
        Observable<StoreState> observableG = ObservableExtensionsKt.restSubscribeOn$default(RestAPIInterface.DefaultImpls.report$default(RestAPI.INSTANCE.getApi(), Long.valueOf(this.channelId), null, Long.valueOf(this.messageId), null, 2, null), false, 1, null).G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "RestAPI\n          .api\n …eportReasons)\n          }");
        return observableG;
    }

    public final ReportReason getReasonSelected() {
        return this.reasonSelected;
    }

    @MainThread
    public final void handleDismissError() {
        StoreState storeState = this.storeState;
        if (storeState == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("storeState");
        }
        generateViewState(storeState);
    }

    @MainThread
    public final void sendReport() {
        ReportReason reportReason = this.reasonSelected;
        if (reportReason != null) {
            updateViewState(new ViewState.Submitting(reportReason.getReason()));
        }
    }

    @MainThread
    public final void sendReportAPICall(int reason, long channelId, long messageId) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Channel channel = companion.getChannels().getChannel(channelId);
        if (channel != null && channel.getType() == 1) {
            User userA = ChannelUtils.a(channel);
            Long lValueOf = userA != null ? Long.valueOf(userA.getId()) : null;
            if (lValueOf != null) {
                StoreUserProfile.fetchProfile$default(companion.getUserProfile(), lValueOf.longValue(), null, false, new WidgetTosReportViolationViewModel2(this, reason, channelId, messageId), 6, null);
            }
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().report(new RestAPIParams.Report(reason, Long.valueOf(channelId), Long.valueOf(messageId))), false, 1, null)), WidgetTosReportViolationViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    public final void setReasonSelected(ReportReason reportReason) {
        this.reasonSelected = reportReason;
    }
}
