package com.discord.widgets.mobile_reports;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.report.MenuAPIResponse;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNode;
import com.discord.api.report.ReportNodeBottomButton;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElement;
import com.discord.api.report.ReportNodeElementData;
import com.discord.api.report.ReportSubmissionBody;
import com.discord.api.stageinstance.StageInstance;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.mobile_reports.WidgetMobileReports2;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.Tuples;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: MobileReportsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\f012/3456789:BA\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010#\u001a\u00020\"\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030+¢\u0006\u0004\b-\u0010.J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "storeState", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "parseMessagePreview", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "parseChannelPreview", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "parseDirectoryServerPreview", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "parseEventPreview", "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "", "handleBack", "()Z", "Lcom/discord/api/report/ReportNodeChild;", "destination", "Lcom/discord/api/report/NodeElementResult;", "elementResult", "", "handleNext", "(Lcom/discord/api/report/ReportNodeChild;Lcom/discord/api/report/NodeElementResult;)V", "handleSubmit", "()V", "handleBlockUser", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "context", "Ljava/lang/ref/WeakReference;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "args", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "Lrx/Observable;", "storeStateObservable", "<init>", "(Ljava/lang/ref/WeakReference;Lcom/discord/widgets/mobile_reports/MobileReportArgs;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/utilities/time/Clock;Lrx/Observable;)V", "Companion", "BlockUserElement", "ChannelPreview", "CheckboxElement", "DirectoryServerPreview", "GuildScheduledEventPreview", "MessagePreview", "NodeNavigationType", "NodeState", "StoreState", "SubmitState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class MobileReportsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WidgetMobileReports2 args;
    private final Clock clock;
    private final WeakReference<Context> context;
    private final RestAPI restAPI;

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001aB\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00030\u0003 \u0001* \u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00000\u0000\u0012\f\u0012\n \u0001*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00050\u00052\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "kotlin.jvm.PlatformType", "storeState", "Lcom/discord/api/report/MenuAPIResponse;", "menuAPI", "Lkotlin/Pair;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;Lcom/discord/api/report/MenuAPIResponse;)Lkotlin/Pair;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<StoreState, MenuAPIResponse, Tuples2<? extends StoreState, ? extends MenuAPIResponse>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends StoreState, ? extends MenuAPIResponse> call(StoreState storeState, MenuAPIResponse menuAPIResponse) {
            return call2(storeState, menuAPIResponse);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<StoreState, MenuAPIResponse> call2(StoreState storeState, MenuAPIResponse menuAPIResponse) {
            return Tuples.to(storeState, menuAPIResponse);
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052F\u0010\u0004\u001aB\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003 \u0002* \u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Pair;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "kotlin.jvm.PlatformType", "Lcom/discord/api/report/MenuAPIResponse;", "<name for destructuring parameter 0>", "", "invoke", "(Lkotlin/Pair;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends StoreState, ? extends MenuAPIResponse>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends StoreState, ? extends MenuAPIResponse> tuples2) {
            invoke2((Tuples2<StoreState, MenuAPIResponse>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<StoreState, MenuAPIResponse> tuples2) {
            StoreState storeStateComponent1 = tuples2.component1();
            MenuAPIResponse menuAPIResponseComponent2 = tuples2.component2();
            ReportNode reportNode = menuAPIResponseComponent2 != null ? menuAPIResponseComponent2.c().get(Integer.valueOf(menuAPIResponseComponent2.getRoot_node_id())) : null;
            if (menuAPIResponseComponent2 == null || reportNode == null) {
                MobileReportsViewModel.access$updateViewState(MobileReportsViewModel.this, ViewState.Invalid.INSTANCE);
                return;
            }
            MobileReportsViewModel mobileReportsViewModel = MobileReportsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeStateComponent1, "storeState");
            MessagePreview messagePreviewAccess$parseMessagePreview = MobileReportsViewModel.access$parseMessagePreview(mobileReportsViewModel, storeStateComponent1);
            MobileReportsViewModel mobileReportsViewModel2 = MobileReportsViewModel.this;
            ViewState viewStateAccess$getViewState$p = MobileReportsViewModel.access$getViewState$p(mobileReportsViewModel2);
            if (viewStateAccess$getViewState$p == null) {
                viewStateAccess$getViewState$p = new ViewState.Menu(menuAPIResponseComponent2, messagePreviewAccess$parseMessagePreview, MobileReportsViewModel.access$parseChannelPreview(MobileReportsViewModel.this, storeStateComponent1), MobileReportsViewModel.access$parseDirectoryServerPreview(MobileReportsViewModel.this, storeStateComponent1), MobileReportsViewModel.access$parseEventPreview(MobileReportsViewModel.this, storeStateComponent1), new NodeNavigationType.Initial(reportNode), null, Collections2.emptyList(), messagePreviewAccess$parseMessagePreview != null ? new BlockUserElement(storeStateComponent1.getBlockedUsers().containsKey(Long.valueOf(messagePreviewAccess$parseMessagePreview.getAuthor().getId())), messagePreviewAccess$parseMessagePreview.getAuthor()) : null, 64, null);
            }
            MobileReportsViewModel.access$updateViewState(mobileReportsViewModel2, viewStateAccess$getViewState$p);
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
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
            Logger.e$default(AppLog.g, "Can't parse report message? Closing report screen.", null, null, 6, null);
            MobileReportsViewModel.access$updateViewState(MobileReportsViewModel.this, ViewState.Invalid.INSTANCE);
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\b\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "", "", "component1", "()Z", "Lcom/discord/models/user/User;", "component2", "()Lcom/discord/models/user/User;", "isBlocked", "user", "copy", "(ZLcom/discord/models/user/User;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/user/User;", "getUser", "<init>", "(ZLcom/discord/models/user/User;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class BlockUserElement {
        private final boolean isBlocked;
        private final User user;

        public BlockUserElement(boolean z2, User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.isBlocked = z2;
            this.user = user;
        }

        public static /* synthetic */ BlockUserElement copy$default(BlockUserElement blockUserElement, boolean z2, User user, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = blockUserElement.isBlocked;
            }
            if ((i & 2) != 0) {
                user = blockUserElement.user;
            }
            return blockUserElement.copy(z2, user);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsBlocked() {
            return this.isBlocked;
        }

        /* renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final BlockUserElement copy(boolean isBlocked, User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new BlockUserElement(isBlocked, user);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BlockUserElement)) {
                return false;
            }
            BlockUserElement blockUserElement = (BlockUserElement) other;
            return this.isBlocked == blockUserElement.isBlocked && Intrinsics3.areEqual(this.user, blockUserElement.user);
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isBlocked;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            User user = this.user;
            return i + (user != null ? user.hashCode() : 0);
        }

        public final boolean isBlocked() {
            return this.isBlocked;
        }

        public String toString() {
            StringBuilder sbU = outline.U("BlockUserElement(isBlocked=");
            sbU.append(this.isBlocked);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/stageinstance/StageInstance;", "component2", "()Lcom/discord/api/stageinstance/StageInstance;", "guild", "stageInstance", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/stageinstance/StageInstance;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/stageinstance/StageInstance;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChannelPreview {
        private final Guild guild;
        private final StageInstance stageInstance;

        public ChannelPreview(Guild guild, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
            this.guild = guild;
            this.stageInstance = stageInstance;
        }

        public static /* synthetic */ ChannelPreview copy$default(ChannelPreview channelPreview, Guild guild, StageInstance stageInstance, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = channelPreview.guild;
            }
            if ((i & 2) != 0) {
                stageInstance = channelPreview.stageInstance;
            }
            return channelPreview.copy(guild, stageInstance);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final ChannelPreview copy(Guild guild, StageInstance stageInstance) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(stageInstance, "stageInstance");
            return new ChannelPreview(guild, stageInstance);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelPreview)) {
                return false;
            }
            ChannelPreview channelPreview = (ChannelPreview) other;
            return Intrinsics3.areEqual(this.guild, channelPreview.guild) && Intrinsics3.areEqual(this.stageInstance, channelPreview.stageInstance);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            StageInstance stageInstance = this.stageInstance;
            return iHashCode + (stageInstance != null ? stageInstance.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelPreview(guild=");
            sbU.append(this.guild);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\n¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJD\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R)\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\fR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\bR\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/discord/api/report/ReportNodeElementData;", "component2", "()Ljava/util/List;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "component3", "()Ljava/util/HashSet;", ModelAuditLogEntry.CHANGE_KEY_NAME, "data", "selections", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/util/HashSet;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/HashSet;", "getSelections", "Ljava/util/List;", "getData", "Ljava/lang/String;", "getName", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/HashSet;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class CheckboxElement {
        private final List<ReportNodeElementData> data;
        private final String name;
        private final HashSet<ReportNodeElementData> selections;

        public CheckboxElement(String str, List<ReportNodeElementData> list, HashSet<ReportNodeElementData> hashSet) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(list, "data");
            Intrinsics3.checkNotNullParameter(hashSet, "selections");
            this.name = str;
            this.data = list;
            this.selections = hashSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CheckboxElement copy$default(CheckboxElement checkboxElement, String str, List list, HashSet hashSet, int i, Object obj) {
            if ((i & 1) != 0) {
                str = checkboxElement.name;
            }
            if ((i & 2) != 0) {
                list = checkboxElement.data;
            }
            if ((i & 4) != 0) {
                hashSet = checkboxElement.selections;
            }
            return checkboxElement.copy(str, list, hashSet);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final List<ReportNodeElementData> component2() {
            return this.data;
        }

        public final HashSet<ReportNodeElementData> component3() {
            return this.selections;
        }

        public final CheckboxElement copy(String name, List<ReportNodeElementData> data, HashSet<ReportNodeElementData> selections) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(data, "data");
            Intrinsics3.checkNotNullParameter(selections, "selections");
            return new CheckboxElement(name, data, selections);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CheckboxElement)) {
                return false;
            }
            CheckboxElement checkboxElement = (CheckboxElement) other;
            return Intrinsics3.areEqual(this.name, checkboxElement.name) && Intrinsics3.areEqual(this.data, checkboxElement.data) && Intrinsics3.areEqual(this.selections, checkboxElement.selections);
        }

        public final List<ReportNodeElementData> getData() {
            return this.data;
        }

        public final String getName() {
            return this.name;
        }

        public final HashSet<ReportNodeElementData> getSelections() {
            return this.selections;
        }

        public int hashCode() {
            String str = this.name;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            List<ReportNodeElementData> list = this.data;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            HashSet<ReportNodeElementData> hashSet = this.selections;
            return iHashCode2 + (hashSet != null ? hashSet.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("CheckboxElement(name=");
            sbU.append(this.name);
            sbU.append(", data=");
            sbU.append(this.data);
            sbU.append(", selections=");
            sbU.append(this.selections);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$Companion;", "", "Lcom/discord/api/report/ReportNode;", "node", "", "getLocation", "(Lcom/discord/api/report/ReportNode;)Ljava/lang/String;", "Lcom/discord/widgets/mobile_reports/MobileReportArgs;", "args", "Lrx/Observable;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "getStoreState", "(Lcom/discord/widgets/mobile_reports/MobileReportArgs;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$getLocation(Companion companion, ReportNode reportNode) {
            return companion.getLocation(reportNode);
        }

        public static final /* synthetic */ Observable access$getStoreState(Companion companion, WidgetMobileReports2 widgetMobileReports2) {
            return companion.getStoreState(widgetMobileReports2);
        }

        private final String getLocation(ReportNode node) {
            return "REPORT_MENU_NODE_" + node + ".id";
        }

        private final Observable<StoreState> getStoreState(WidgetMobileReports2 args) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            StoreMessages messages = companion.getMessages();
            long channelId = args.getChannelId();
            WidgetMobileReports2.Message message = (WidgetMobileReports2.Message) (!(args instanceof WidgetMobileReports2.Message) ? null : args);
            Observable<Message> observableObserveMessagesForChannel = messages.observeMessagesForChannel(channelId, message != null ? message.getMessageId() : -1L);
            Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(args.getChannelId());
            Observable<Guild> observableObserveFromChannelId = companion.getGuilds().observeFromChannelId(args.getChannelId());
            Observable<StageInstance> observableObserveStageInstanceForChannel = companion.getStageInstances().observeStageInstanceForChannel(args.getChannelId());
            Observable<Map<Long, Integer>> observableObserveForType = companion.getUserRelationships().observeForType(2);
            Observable<RestCallState<List<DirectoryEntryGuild>>> observableObserveDirectoriesForChannel = companion.getDirectories().observeDirectoriesForChannel(args.getChannelId());
            StoreGuildScheduledEvents guildScheduledEvents = companion.getGuildScheduledEvents();
            boolean z2 = args instanceof WidgetMobileReports2.GuildScheduledEvent;
            WidgetMobileReports2.GuildScheduledEvent guildScheduledEvent = (WidgetMobileReports2.GuildScheduledEvent) (!z2 ? null : args);
            Long lValueOf = guildScheduledEvent != null ? Long.valueOf(guildScheduledEvent.getEventId()) : null;
            WidgetMobileReports2.GuildScheduledEvent guildScheduledEvent2 = (WidgetMobileReports2.GuildScheduledEvent) (!z2 ? null : args);
            Observable<GuildScheduledEvent> observableObserveGuildScheduledEvent = guildScheduledEvents.observeGuildScheduledEvent(lValueOf, guildScheduledEvent2 != null ? Long.valueOf(guildScheduledEvent2.getGuildId()) : null);
            StoreGuilds guilds = companion.getGuilds();
            WidgetMobileReports2.GuildScheduledEvent guildScheduledEvent3 = (WidgetMobileReports2.GuildScheduledEvent) (z2 ? args : null);
            Observable<StoreState> observableD = Observable.d(observableObserveMessagesForChannel, observableObserveChannel, observableObserveFromChannelId, observableObserveStageInstanceForChannel, observableObserveForType, observableObserveDirectoriesForChannel, observableObserveGuildScheduledEvent, guilds.observeGuild(guildScheduledEvent3 != null ? guildScheduledEvent3.getGuildId() : -1L), new MobileReportsViewModel2(args));
            Intrinsics3.checkNotNullExpressionValue(observableD, "Observable.combineLatest…nt = event,\n      )\n    }");
            return observableD;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component2", "()Lcom/discord/api/directory/DirectoryEntryGuild;", "hub", "directoryEntry", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/directory/DirectoryEntryGuild;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/directory/DirectoryEntryGuild;", "getDirectoryEntry", "Lcom/discord/models/guild/Guild;", "getHub", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/directory/DirectoryEntryGuild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DirectoryServerPreview {
        private final DirectoryEntryGuild directoryEntry;
        private final Guild hub;

        public DirectoryServerPreview(Guild guild, DirectoryEntryGuild directoryEntryGuild) {
            Intrinsics3.checkNotNullParameter(guild, "hub");
            Intrinsics3.checkNotNullParameter(directoryEntryGuild, "directoryEntry");
            this.hub = guild;
            this.directoryEntry = directoryEntryGuild;
        }

        public static /* synthetic */ DirectoryServerPreview copy$default(DirectoryServerPreview directoryServerPreview, Guild guild, DirectoryEntryGuild directoryEntryGuild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = directoryServerPreview.hub;
            }
            if ((i & 2) != 0) {
                directoryEntryGuild = directoryServerPreview.directoryEntry;
            }
            return directoryServerPreview.copy(guild, directoryEntryGuild);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getHub() {
            return this.hub;
        }

        /* renamed from: component2, reason: from getter */
        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        public final DirectoryServerPreview copy(Guild hub, DirectoryEntryGuild directoryEntry) {
            Intrinsics3.checkNotNullParameter(hub, "hub");
            Intrinsics3.checkNotNullParameter(directoryEntry, "directoryEntry");
            return new DirectoryServerPreview(hub, directoryEntry);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DirectoryServerPreview)) {
                return false;
            }
            DirectoryServerPreview directoryServerPreview = (DirectoryServerPreview) other;
            return Intrinsics3.areEqual(this.hub, directoryServerPreview.hub) && Intrinsics3.areEqual(this.directoryEntry, directoryServerPreview.directoryEntry);
        }

        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        public final Guild getHub() {
            return this.hub;
        }

        public int hashCode() {
            Guild guild = this.hub;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            DirectoryEntryGuild directoryEntryGuild = this.directoryEntry;
            return iHashCode + (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DirectoryServerPreview(hub=");
            sbU.append(this.hub);
            sbU.append(", directoryEntry=");
            sbU.append(this.directoryEntry);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "", "Lcom/discord/models/guild/Guild;", "component1", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component2", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guild", "event", "copy", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getEvent", "Lcom/discord/models/guild/Guild;", "getGuild", "<init>", "(Lcom/discord/models/guild/Guild;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GuildScheduledEventPreview {
        private final GuildScheduledEvent event;
        private final Guild guild;

        public GuildScheduledEventPreview(Guild guild, GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
            this.guild = guild;
            this.event = guildScheduledEvent;
        }

        public static /* synthetic */ GuildScheduledEventPreview copy$default(GuildScheduledEventPreview guildScheduledEventPreview, Guild guild, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = guildScheduledEventPreview.guild;
            }
            if ((i & 2) != 0) {
                guildScheduledEvent = guildScheduledEventPreview.event;
            }
            return guildScheduledEventPreview.copy(guild, guildScheduledEvent);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final GuildScheduledEventPreview copy(Guild guild, GuildScheduledEvent event) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(event, "event");
            return new GuildScheduledEventPreview(guild, event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildScheduledEventPreview)) {
                return false;
            }
            GuildScheduledEventPreview guildScheduledEventPreview = (GuildScheduledEventPreview) other;
            return Intrinsics3.areEqual(this.guild, guildScheduledEventPreview.guild) && Intrinsics3.areEqual(this.event, guildScheduledEventPreview.event);
        }

        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            GuildScheduledEvent guildScheduledEvent = this.event;
            return iHashCode + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GuildScheduledEventPreview(guild=");
            sbU.append(this.guild);
            sbU.append(", event=");
            sbU.append(this.event);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JB\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010\n¨\u0006)"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "component1", "()Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "", "component2", "()Ljava/lang/String;", "", "component3", "()I", "Lcom/discord/models/user/User;", "component4", "()Lcom/discord/models/user/User;", "", "component5", "()Z", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "authorName", "authorNameColor", "author", "hasEmbeds", "copy", "(Lcom/facebook/drawee/span/DraweeSpanStringBuilder;Ljava/lang/String;ILcom/discord/models/user/User;Z)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/facebook/drawee/span/DraweeSpanStringBuilder;", "getText", "Ljava/lang/String;", "getAuthorName", "Lcom/discord/models/user/User;", "getAuthor", "Z", "getHasEmbeds", "I", "getAuthorNameColor", "<init>", "(Lcom/facebook/drawee/span/DraweeSpanStringBuilder;Ljava/lang/String;ILcom/discord/models/user/User;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class MessagePreview {
        private final User author;
        private final String authorName;
        private final int authorNameColor;
        private final boolean hasEmbeds;
        private final DraweeSpanStringBuilder text;

        public MessagePreview(DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2) {
            Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(str, "authorName");
            Intrinsics3.checkNotNullParameter(user, "author");
            this.text = draweeSpanStringBuilder;
            this.authorName = str;
            this.authorNameColor = i;
            this.author = user;
            this.hasEmbeds = z2;
        }

        public static /* synthetic */ MessagePreview copy$default(MessagePreview messagePreview, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                draweeSpanStringBuilder = messagePreview.text;
            }
            if ((i2 & 2) != 0) {
                str = messagePreview.authorName;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                i = messagePreview.authorNameColor;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                user = messagePreview.author;
            }
            User user2 = user;
            if ((i2 & 16) != 0) {
                z2 = messagePreview.hasEmbeds;
            }
            return messagePreview.copy(draweeSpanStringBuilder, str2, i3, user2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final DraweeSpanStringBuilder getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getAuthorName() {
            return this.authorName;
        }

        /* renamed from: component3, reason: from getter */
        public final int getAuthorNameColor() {
            return this.authorNameColor;
        }

        /* renamed from: component4, reason: from getter */
        public final User getAuthor() {
            return this.author;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getHasEmbeds() {
            return this.hasEmbeds;
        }

        public final MessagePreview copy(DraweeSpanStringBuilder text, String authorName, int authorNameColor, User author, boolean hasEmbeds) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(authorName, "authorName");
            Intrinsics3.checkNotNullParameter(author, "author");
            return new MessagePreview(text, authorName, authorNameColor, author, hasEmbeds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessagePreview)) {
                return false;
            }
            MessagePreview messagePreview = (MessagePreview) other;
            return Intrinsics3.areEqual(this.text, messagePreview.text) && Intrinsics3.areEqual(this.authorName, messagePreview.authorName) && this.authorNameColor == messagePreview.authorNameColor && Intrinsics3.areEqual(this.author, messagePreview.author) && this.hasEmbeds == messagePreview.hasEmbeds;
        }

        public final User getAuthor() {
            return this.author;
        }

        public final String getAuthorName() {
            return this.authorName;
        }

        public final int getAuthorNameColor() {
            return this.authorNameColor;
        }

        public final boolean getHasEmbeds() {
            return this.hasEmbeds;
        }

        public final DraweeSpanStringBuilder getText() {
            return this.text;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            DraweeSpanStringBuilder draweeSpanStringBuilder = this.text;
            int iHashCode = (draweeSpanStringBuilder != null ? draweeSpanStringBuilder.hashCode() : 0) * 31;
            String str = this.authorName;
            int iHashCode2 = (((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.authorNameColor) * 31;
            User user = this.author;
            int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
            boolean z2 = this.hasEmbeds;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MessagePreview(text=");
            sbU.append((Object) this.text);
            sbU.append(", authorName=");
            sbU.append(this.authorName);
            sbU.append(", authorNameColor=");
            sbU.append(this.authorNameColor);
            sbU.append(", author=");
            sbU.append(this.author);
            sbU.append(", hasEmbeds=");
            return outline.O(sbU, this.hasEmbeds, ")");
        }

        public /* synthetic */ MessagePreview(DraweeSpanStringBuilder draweeSpanStringBuilder, String str, int i, User user, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(draweeSpanStringBuilder, str, i, user, (i2 & 16) != 0 ? false : z2);
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "", "Lcom/discord/api/report/ReportNode;", "node", "Lcom/discord/api/report/ReportNode;", "getNode", "()Lcom/discord/api/report/ReportNode;", "<init>", "(Lcom/discord/api/report/ReportNode;)V", "Back", "Initial", "Next", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Next;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Back;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Initial;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class NodeNavigationType {
        private final ReportNode node;

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Back;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "Lcom/discord/api/report/ReportNode;", "component1", "()Lcom/discord/api/report/ReportNode;", "prevNode", "copy", "(Lcom/discord/api/report/ReportNode;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Back;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/report/ReportNode;", "<init>", "(Lcom/discord/api/report/ReportNode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Back extends NodeNavigationType {
            private final ReportNode prevNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Back(ReportNode reportNode) {
                super(reportNode, null);
                Intrinsics3.checkNotNullParameter(reportNode, "prevNode");
                this.prevNode = reportNode;
            }

            /* renamed from: component1, reason: from getter */
            private final ReportNode getPrevNode() {
                return this.prevNode;
            }

            public static /* synthetic */ Back copy$default(Back back, ReportNode reportNode, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportNode = back.prevNode;
                }
                return back.copy(reportNode);
            }

            public final Back copy(ReportNode prevNode) {
                Intrinsics3.checkNotNullParameter(prevNode, "prevNode");
                return new Back(prevNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Back) && Intrinsics3.areEqual(this.prevNode, ((Back) other).prevNode);
                }
                return true;
            }

            public int hashCode() {
                ReportNode reportNode = this.prevNode;
                if (reportNode != null) {
                    return reportNode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Back(prevNode=");
                sbU.append(this.prevNode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Initial;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "Lcom/discord/api/report/ReportNode;", "component1", "()Lcom/discord/api/report/ReportNode;", "initialNode", "copy", "(Lcom/discord/api/report/ReportNode;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Initial;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/report/ReportNode;", "<init>", "(Lcom/discord/api/report/ReportNode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Initial extends NodeNavigationType {
            private final ReportNode initialNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initial(ReportNode reportNode) {
                super(reportNode, null);
                Intrinsics3.checkNotNullParameter(reportNode, "initialNode");
                this.initialNode = reportNode;
            }

            /* renamed from: component1, reason: from getter */
            private final ReportNode getInitialNode() {
                return this.initialNode;
            }

            public static /* synthetic */ Initial copy$default(Initial initial, ReportNode reportNode, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportNode = initial.initialNode;
                }
                return initial.copy(reportNode);
            }

            public final Initial copy(ReportNode initialNode) {
                Intrinsics3.checkNotNullParameter(initialNode, "initialNode");
                return new Initial(initialNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Initial) && Intrinsics3.areEqual(this.initialNode, ((Initial) other).initialNode);
                }
                return true;
            }

            public int hashCode() {
                ReportNode reportNode = this.initialNode;
                if (reportNode != null) {
                    return reportNode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Initial(initialNode=");
                sbU.append(this.initialNode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Next;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "Lcom/discord/api/report/ReportNode;", "component1", "()Lcom/discord/api/report/ReportNode;", "nextNode", "copy", "(Lcom/discord/api/report/ReportNode;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType$Next;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/report/ReportNode;", "<init>", "(Lcom/discord/api/report/ReportNode;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Next extends NodeNavigationType {
            private final ReportNode nextNode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Next(ReportNode reportNode) {
                super(reportNode, null);
                Intrinsics3.checkNotNullParameter(reportNode, "nextNode");
                this.nextNode = reportNode;
            }

            /* renamed from: component1, reason: from getter */
            private final ReportNode getNextNode() {
                return this.nextNode;
            }

            public static /* synthetic */ Next copy$default(Next next, ReportNode reportNode, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportNode = next.nextNode;
                }
                return next.copy(reportNode);
            }

            public final Next copy(ReportNode nextNode) {
                Intrinsics3.checkNotNullParameter(nextNode, "nextNode");
                return new Next(nextNode);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Next) && Intrinsics3.areEqual(this.nextNode, ((Next) other).nextNode);
                }
                return true;
            }

            public int hashCode() {
                ReportNode reportNode = this.nextNode;
                if (reportNode != null) {
                    return reportNode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Next(nextNode=");
                sbU.append(this.nextNode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private NodeNavigationType(ReportNode reportNode) {
            this.node = reportNode;
        }

        public final ReportNode getNode() {
            return this.node;
        }

        public /* synthetic */ NodeNavigationType(ReportNode reportNode, DefaultConstructorMarker defaultConstructorMarker) {
            this(reportNode);
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0014\u0012\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\u0006\u0010,\u001a\u00020\u001b\u0012\b\u0010-\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010.\u001a\u0004\u0018\u00010!¢\u0006\u0004\bP\u0010QJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0096\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\b\b\u0002\u0010,\u001a\u00020\u001b2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00105\u001a\u000204HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u00108\u001a\u00020\u001b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b8\u00109R\u001b\u0010*\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010:\u001a\u0004\b;\u0010\u0016R\u001b\u0010)\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010<\u001a\u0004\b=\u0010\u0013R\u001b\u0010%\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\b?\u0010\u0007R\u0019\u0010,\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010@\u001a\u0004\bA\u0010\u001dR\u001b\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bC\u0010\rR\u001b\u0010&\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010D\u001a\u0004\bE\u0010\nR\u001b\u0010-\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bG\u0010 R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010H\u001a\u0004\bI\u0010\u0004R!\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010J\u001a\u0004\bK\u0010\u001aR\u001b\u0010.\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010L\u001a\u0004\bM\u0010#R\u001b\u0010(\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010N\u001a\u0004\bO\u0010\u0010¨\u0006R"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "", "Lcom/discord/api/report/ReportNode;", "component1", "()Lcom/discord/api/report/ReportNode;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;", "component2", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "component3", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "component4", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "component5", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "component6", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "component7", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "", "Lcom/discord/api/report/NodeResult;", "component8", "()Ljava/util/List;", "", "component9", "()Z", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "component10", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "Lcom/discord/api/report/ReportNodeBottomButton;", "component11", "()Lcom/discord/api/report/ReportNodeBottomButton;", "node", "checkboxElement", "messagePreviewElement", "channelPreviewElement", "directoryServerPreviewElement", "eventPreviewElement", "blockUserElement", "breadcrumbsElement", "successElement", "submitState", "bottomButton", "copy", "(Lcom/discord/api/report/ReportNode;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;Ljava/util/List;ZLcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;Lcom/discord/api/report/ReportNodeBottomButton;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "getBlockUserElement", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "getEventPreviewElement", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;", "getCheckboxElement", "Z", "getSuccessElement", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "getChannelPreviewElement", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "getMessagePreviewElement", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "getSubmitState", "Lcom/discord/api/report/ReportNode;", "getNode", "Ljava/util/List;", "getBreadcrumbsElement", "Lcom/discord/api/report/ReportNodeBottomButton;", "getBottomButton", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "getDirectoryServerPreviewElement", "<init>", "(Lcom/discord/api/report/ReportNode;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$CheckboxElement;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;Ljava/util/List;ZLcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;Lcom/discord/api/report/ReportNodeBottomButton;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class NodeState {
        private final BlockUserElement blockUserElement;
        private final ReportNodeBottomButton bottomButton;
        private final List<NodeResult> breadcrumbsElement;
        private final ChannelPreview channelPreviewElement;
        private final CheckboxElement checkboxElement;
        private final DirectoryServerPreview directoryServerPreviewElement;
        private final GuildScheduledEventPreview eventPreviewElement;
        private final MessagePreview messagePreviewElement;
        private final ReportNode node;
        private final SubmitState submitState;
        private final boolean successElement;

        public NodeState(ReportNode reportNode, CheckboxElement checkboxElement, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, BlockUserElement blockUserElement, List<NodeResult> list, boolean z2, SubmitState submitState, ReportNodeBottomButton reportNodeBottomButton) {
            Intrinsics3.checkNotNullParameter(reportNode, "node");
            this.node = reportNode;
            this.checkboxElement = checkboxElement;
            this.messagePreviewElement = messagePreview;
            this.channelPreviewElement = channelPreview;
            this.directoryServerPreviewElement = directoryServerPreview;
            this.eventPreviewElement = guildScheduledEventPreview;
            this.blockUserElement = blockUserElement;
            this.breadcrumbsElement = list;
            this.successElement = z2;
            this.submitState = submitState;
            this.bottomButton = reportNodeBottomButton;
        }

        public static /* synthetic */ NodeState copy$default(NodeState nodeState, ReportNode reportNode, CheckboxElement checkboxElement, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, BlockUserElement blockUserElement, List list, boolean z2, SubmitState submitState, ReportNodeBottomButton reportNodeBottomButton, int i, Object obj) {
            return nodeState.copy((i & 1) != 0 ? nodeState.node : reportNode, (i & 2) != 0 ? nodeState.checkboxElement : checkboxElement, (i & 4) != 0 ? nodeState.messagePreviewElement : messagePreview, (i & 8) != 0 ? nodeState.channelPreviewElement : channelPreview, (i & 16) != 0 ? nodeState.directoryServerPreviewElement : directoryServerPreview, (i & 32) != 0 ? nodeState.eventPreviewElement : guildScheduledEventPreview, (i & 64) != 0 ? nodeState.blockUserElement : blockUserElement, (i & 128) != 0 ? nodeState.breadcrumbsElement : list, (i & 256) != 0 ? nodeState.successElement : z2, (i & 512) != 0 ? nodeState.submitState : submitState, (i & 1024) != 0 ? nodeState.bottomButton : reportNodeBottomButton);
        }

        /* renamed from: component1, reason: from getter */
        public final ReportNode getNode() {
            return this.node;
        }

        /* renamed from: component10, reason: from getter */
        public final SubmitState getSubmitState() {
            return this.submitState;
        }

        /* renamed from: component11, reason: from getter */
        public final ReportNodeBottomButton getBottomButton() {
            return this.bottomButton;
        }

        /* renamed from: component2, reason: from getter */
        public final CheckboxElement getCheckboxElement() {
            return this.checkboxElement;
        }

        /* renamed from: component3, reason: from getter */
        public final MessagePreview getMessagePreviewElement() {
            return this.messagePreviewElement;
        }

        /* renamed from: component4, reason: from getter */
        public final ChannelPreview getChannelPreviewElement() {
            return this.channelPreviewElement;
        }

        /* renamed from: component5, reason: from getter */
        public final DirectoryServerPreview getDirectoryServerPreviewElement() {
            return this.directoryServerPreviewElement;
        }

        /* renamed from: component6, reason: from getter */
        public final GuildScheduledEventPreview getEventPreviewElement() {
            return this.eventPreviewElement;
        }

        /* renamed from: component7, reason: from getter */
        public final BlockUserElement getBlockUserElement() {
            return this.blockUserElement;
        }

        public final List<NodeResult> component8() {
            return this.breadcrumbsElement;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getSuccessElement() {
            return this.successElement;
        }

        public final NodeState copy(ReportNode node, CheckboxElement checkboxElement, MessagePreview messagePreviewElement, ChannelPreview channelPreviewElement, DirectoryServerPreview directoryServerPreviewElement, GuildScheduledEventPreview eventPreviewElement, BlockUserElement blockUserElement, List<NodeResult> breadcrumbsElement, boolean successElement, SubmitState submitState, ReportNodeBottomButton bottomButton) {
            Intrinsics3.checkNotNullParameter(node, "node");
            return new NodeState(node, checkboxElement, messagePreviewElement, channelPreviewElement, directoryServerPreviewElement, eventPreviewElement, blockUserElement, breadcrumbsElement, successElement, submitState, bottomButton);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NodeState)) {
                return false;
            }
            NodeState nodeState = (NodeState) other;
            return Intrinsics3.areEqual(this.node, nodeState.node) && Intrinsics3.areEqual(this.checkboxElement, nodeState.checkboxElement) && Intrinsics3.areEqual(this.messagePreviewElement, nodeState.messagePreviewElement) && Intrinsics3.areEqual(this.channelPreviewElement, nodeState.channelPreviewElement) && Intrinsics3.areEqual(this.directoryServerPreviewElement, nodeState.directoryServerPreviewElement) && Intrinsics3.areEqual(this.eventPreviewElement, nodeState.eventPreviewElement) && Intrinsics3.areEqual(this.blockUserElement, nodeState.blockUserElement) && Intrinsics3.areEqual(this.breadcrumbsElement, nodeState.breadcrumbsElement) && this.successElement == nodeState.successElement && Intrinsics3.areEqual(this.submitState, nodeState.submitState) && Intrinsics3.areEqual(this.bottomButton, nodeState.bottomButton);
        }

        public final BlockUserElement getBlockUserElement() {
            return this.blockUserElement;
        }

        public final ReportNodeBottomButton getBottomButton() {
            return this.bottomButton;
        }

        public final List<NodeResult> getBreadcrumbsElement() {
            return this.breadcrumbsElement;
        }

        public final ChannelPreview getChannelPreviewElement() {
            return this.channelPreviewElement;
        }

        public final CheckboxElement getCheckboxElement() {
            return this.checkboxElement;
        }

        public final DirectoryServerPreview getDirectoryServerPreviewElement() {
            return this.directoryServerPreviewElement;
        }

        public final GuildScheduledEventPreview getEventPreviewElement() {
            return this.eventPreviewElement;
        }

        public final MessagePreview getMessagePreviewElement() {
            return this.messagePreviewElement;
        }

        public final ReportNode getNode() {
            return this.node;
        }

        public final SubmitState getSubmitState() {
            return this.submitState;
        }

        public final boolean getSuccessElement() {
            return this.successElement;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ReportNode reportNode = this.node;
            int iHashCode = (reportNode != null ? reportNode.hashCode() : 0) * 31;
            CheckboxElement checkboxElement = this.checkboxElement;
            int iHashCode2 = (iHashCode + (checkboxElement != null ? checkboxElement.hashCode() : 0)) * 31;
            MessagePreview messagePreview = this.messagePreviewElement;
            int iHashCode3 = (iHashCode2 + (messagePreview != null ? messagePreview.hashCode() : 0)) * 31;
            ChannelPreview channelPreview = this.channelPreviewElement;
            int iHashCode4 = (iHashCode3 + (channelPreview != null ? channelPreview.hashCode() : 0)) * 31;
            DirectoryServerPreview directoryServerPreview = this.directoryServerPreviewElement;
            int iHashCode5 = (iHashCode4 + (directoryServerPreview != null ? directoryServerPreview.hashCode() : 0)) * 31;
            GuildScheduledEventPreview guildScheduledEventPreview = this.eventPreviewElement;
            int iHashCode6 = (iHashCode5 + (guildScheduledEventPreview != null ? guildScheduledEventPreview.hashCode() : 0)) * 31;
            BlockUserElement blockUserElement = this.blockUserElement;
            int iHashCode7 = (iHashCode6 + (blockUserElement != null ? blockUserElement.hashCode() : 0)) * 31;
            List<NodeResult> list = this.breadcrumbsElement;
            int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.successElement;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode8 + i) * 31;
            SubmitState submitState = this.submitState;
            int iHashCode9 = (i2 + (submitState != null ? submitState.hashCode() : 0)) * 31;
            ReportNodeBottomButton reportNodeBottomButton = this.bottomButton;
            return iHashCode9 + (reportNodeBottomButton != null ? reportNodeBottomButton.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("NodeState(node=");
            sbU.append(this.node);
            sbU.append(", checkboxElement=");
            sbU.append(this.checkboxElement);
            sbU.append(", messagePreviewElement=");
            sbU.append(this.messagePreviewElement);
            sbU.append(", channelPreviewElement=");
            sbU.append(this.channelPreviewElement);
            sbU.append(", directoryServerPreviewElement=");
            sbU.append(this.directoryServerPreviewElement);
            sbU.append(", eventPreviewElement=");
            sbU.append(this.eventPreviewElement);
            sbU.append(", blockUserElement=");
            sbU.append(this.blockUserElement);
            sbU.append(", breadcrumbsElement=");
            sbU.append(this.breadcrumbsElement);
            sbU.append(", successElement=");
            sbU.append(this.successElement);
            sbU.append(", submitState=");
            sbU.append(this.submitState);
            sbU.append(", bottomButton=");
            sbU.append(this.bottomButton);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\u001a\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b;\u0010<J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J$\u0010\u0016\u001a\u0016\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u0011HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJv\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u001c\b\u0002\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00112\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010%\u001a\u00020$HÖ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010\u0004R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u0010\nR\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\rR-\u0010 \u001a\u0016\u0012\b\u0012\u00060\u0012j\u0002`\u0013\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u00118\u0006@\u0006¢\u0006\f\n\u0004\b \u00103\u001a\u0004\b4\u0010\u0017R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\b6\u0010\u0007R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b8\u0010\u0010R\u001b\u0010!\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b!\u00109\u001a\u0004\b:\u0010\u001a¨\u0006="}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "", "Lcom/discord/models/message/Message;", "component1", "()Lcom/discord/models/message/Message;", "Lcom/discord/api/channel/Channel;", "component2", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/guild/Guild;", "component3", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "component4", "()Lcom/discord/api/directory/DirectoryEntryGuild;", "Lcom/discord/api/stageinstance/StageInstance;", "component5", "()Lcom/discord/api/stageinstance/StageInstance;", "", "", "Lcom/discord/primitives/UserId;", "", "Lcom/discord/primitives/RelationshipType;", "component6", "()Ljava/util/Map;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "component7", "()Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "message", "channel", "guild", "directoryEntry", "stageInstance", "blockedUsers", "event", "copy", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/api/directory/DirectoryEntryGuild;Lcom/discord/api/stageinstance/StageInstance;Ljava/util/Map;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/message/Message;", "getMessage", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/api/directory/DirectoryEntryGuild;", "getDirectoryEntry", "Ljava/util/Map;", "getBlockedUsers", "Lcom/discord/api/channel/Channel;", "getChannel", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "getEvent", "<init>", "(Lcom/discord/models/message/Message;Lcom/discord/api/channel/Channel;Lcom/discord/models/guild/Guild;Lcom/discord/api/directory/DirectoryEntryGuild;Lcom/discord/api/stageinstance/StageInstance;Ljava/util/Map;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Map<Long, Integer> blockedUsers;
        private final Channel channel;
        private final DirectoryEntryGuild directoryEntry;
        private final GuildScheduledEvent event;
        private final Guild guild;
        private final Message message;
        private final StageInstance stageInstance;

        public StoreState(Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntryGuild, StageInstance stageInstance, Map<Long, Integer> map, GuildScheduledEvent guildScheduledEvent) {
            Intrinsics3.checkNotNullParameter(map, "blockedUsers");
            this.message = message;
            this.channel = channel;
            this.guild = guild;
            this.directoryEntry = directoryEntryGuild;
            this.stageInstance = stageInstance;
            this.blockedUsers = map;
            this.event = guildScheduledEvent;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntryGuild, StageInstance stageInstance, Map map, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                message = storeState.message;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 8) != 0) {
                directoryEntryGuild = storeState.directoryEntry;
            }
            DirectoryEntryGuild directoryEntryGuild2 = directoryEntryGuild;
            if ((i & 16) != 0) {
                stageInstance = storeState.stageInstance;
            }
            StageInstance stageInstance2 = stageInstance;
            if ((i & 32) != 0) {
                map = storeState.blockedUsers;
            }
            Map map2 = map;
            if ((i & 64) != 0) {
                guildScheduledEvent = storeState.event;
            }
            return storeState.copy(message, channel2, guild2, directoryEntryGuild2, stageInstance2, map2, guildScheduledEvent);
        }

        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component4, reason: from getter */
        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        /* renamed from: component5, reason: from getter */
        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public final Map<Long, Integer> component6() {
            return this.blockedUsers;
        }

        /* renamed from: component7, reason: from getter */
        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final StoreState copy(Message message, Channel channel, Guild guild, DirectoryEntryGuild directoryEntry, StageInstance stageInstance, Map<Long, Integer> blockedUsers, GuildScheduledEvent event) {
            Intrinsics3.checkNotNullParameter(blockedUsers, "blockedUsers");
            return new StoreState(message, channel, guild, directoryEntry, stageInstance, blockedUsers, event);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.message, storeState.message) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.directoryEntry, storeState.directoryEntry) && Intrinsics3.areEqual(this.stageInstance, storeState.stageInstance) && Intrinsics3.areEqual(this.blockedUsers, storeState.blockedUsers) && Intrinsics3.areEqual(this.event, storeState.event);
        }

        public final Map<Long, Integer> getBlockedUsers() {
            return this.blockedUsers;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final DirectoryEntryGuild getDirectoryEntry() {
            return this.directoryEntry;
        }

        public final GuildScheduledEvent getEvent() {
            return this.event;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final StageInstance getStageInstance() {
            return this.stageInstance;
        }

        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            DirectoryEntryGuild directoryEntryGuild = this.directoryEntry;
            int iHashCode4 = (iHashCode3 + (directoryEntryGuild != null ? directoryEntryGuild.hashCode() : 0)) * 31;
            StageInstance stageInstance = this.stageInstance;
            int iHashCode5 = (iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31;
            Map<Long, Integer> map = this.blockedUsers;
            int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
            GuildScheduledEvent guildScheduledEvent = this.event;
            return iHashCode6 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(message=");
            sbU.append(this.message);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", directoryEntry=");
            sbU.append(this.directoryEntry);
            sbU.append(", stageInstance=");
            sbU.append(this.stageInstance);
            sbU.append(", blockedUsers=");
            sbU.append(this.blockedUsers);
            sbU.append(", event=");
            sbU.append(this.event);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "", "<init>", "()V", "Error", "Loading", "None", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState$None;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState$Loading;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class SubmitState {

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState$Error;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends SubmitState {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState$Loading;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends SubmitState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState$None;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class None extends SubmitState {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        private SubmitState() {
        }

        public /* synthetic */ SubmitState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Menu", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Menu;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Invalid;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: MobileReportsViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010$\u001a\u00020\b\u0012\b\u0010%\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010)\u001a\u00020\u0017\u0012\b\b\u0002\u0010*\u001a\u00020\u001a\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0012\b\u0010,\u001a\u0004\u0018\u00010!¢\u0006\u0004\bK\u0010LJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#Jz\u0010-\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\b2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001a2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010!HÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u00100\u001a\u00020/HÖ\u0001¢\u0006\u0004\b0\u00101J\u0010\u00103\u001a\u000202HÖ\u0001¢\u0006\u0004\b3\u00104J\u001a\u00107\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u000105HÖ\u0003¢\u0006\u0004\b7\u00108R\u0019\u0010)\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b)\u00109\u001a\u0004\b:\u0010\u0019R\u001f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010;\u001a\u0004\b<\u0010 R\u001b\u0010,\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010=\u001a\u0004\b>\u0010#R\u0019\u0010$\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010?\u001a\u0004\b@\u0010\nR\u001b\u0010%\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010A\u001a\u0004\bB\u0010\rR\u001b\u0010(\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010C\u001a\u0004\bD\u0010\u0016R\u0019\u0010*\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010E\u001a\u0004\bF\u0010\u001cR\u001b\u0010&\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010G\u001a\u0004\bH\u0010\u0010R\u001b\u0010'\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010I\u001a\u0004\bJ\u0010\u0013¨\u0006M"}, d2 = {"Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Menu;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState;", "", "shouldHideBackArrow", "()Z", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "genNodeState", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeState;", "Lcom/discord/api/report/MenuAPIResponse;", "component1", "()Lcom/discord/api/report/MenuAPIResponse;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "component2", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "component3", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "component4", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "component5", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "component6", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "component7", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "", "Lcom/discord/api/report/NodeResult;", "component8", "()Ljava/util/List;", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "component9", "()Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "menu", "messagePreview", "channelPreview", "directoryServerPreview", "eventPreview", "nodeNavigationType", "submitState", "history", "blockUserElement", "copy", "(Lcom/discord/api/report/MenuAPIResponse;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;Ljava/util/List;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;)Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ViewState$Menu;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;", "getNodeNavigationType", "Ljava/util/List;", "getHistory", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;", "getBlockUserElement", "Lcom/discord/api/report/MenuAPIResponse;", "getMenu", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;", "getMessagePreview", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;", "getEventPreview", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;", "getSubmitState", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;", "getChannelPreview", "Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;", "getDirectoryServerPreview", "<init>", "(Lcom/discord/api/report/MenuAPIResponse;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$MessagePreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$ChannelPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$DirectoryServerPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$GuildScheduledEventPreview;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$NodeNavigationType;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$SubmitState;Ljava/util/List;Lcom/discord/widgets/mobile_reports/MobileReportsViewModel$BlockUserElement;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Menu extends ViewState {
            private final BlockUserElement blockUserElement;
            private final ChannelPreview channelPreview;
            private final DirectoryServerPreview directoryServerPreview;
            private final GuildScheduledEventPreview eventPreview;
            private final List<NodeResult> history;
            private final MenuAPIResponse menu;
            private final MessagePreview messagePreview;
            private final NodeNavigationType nodeNavigationType;
            private final SubmitState submitState;

            public /* synthetic */ Menu(MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List list, BlockUserElement blockUserElement, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(menuAPIResponse, messagePreview, channelPreview, directoryServerPreview, guildScheduledEventPreview, nodeNavigationType, (i & 64) != 0 ? SubmitState.None.INSTANCE : submitState, list, blockUserElement);
            }

            public static /* synthetic */ Menu copy$default(Menu menu, MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List list, BlockUserElement blockUserElement, int i, Object obj) {
                return menu.copy((i & 1) != 0 ? menu.menu : menuAPIResponse, (i & 2) != 0 ? menu.messagePreview : messagePreview, (i & 4) != 0 ? menu.channelPreview : channelPreview, (i & 8) != 0 ? menu.directoryServerPreview : directoryServerPreview, (i & 16) != 0 ? menu.eventPreview : guildScheduledEventPreview, (i & 32) != 0 ? menu.nodeNavigationType : nodeNavigationType, (i & 64) != 0 ? menu.submitState : submitState, (i & 128) != 0 ? menu.history : list, (i & 256) != 0 ? menu.blockUserElement : blockUserElement);
            }

            /* renamed from: component1, reason: from getter */
            public final MenuAPIResponse getMenu() {
                return this.menu;
            }

            /* renamed from: component2, reason: from getter */
            public final MessagePreview getMessagePreview() {
                return this.messagePreview;
            }

            /* renamed from: component3, reason: from getter */
            public final ChannelPreview getChannelPreview() {
                return this.channelPreview;
            }

            /* renamed from: component4, reason: from getter */
            public final DirectoryServerPreview getDirectoryServerPreview() {
                return this.directoryServerPreview;
            }

            /* renamed from: component5, reason: from getter */
            public final GuildScheduledEventPreview getEventPreview() {
                return this.eventPreview;
            }

            /* renamed from: component6, reason: from getter */
            public final NodeNavigationType getNodeNavigationType() {
                return this.nodeNavigationType;
            }

            /* renamed from: component7, reason: from getter */
            public final SubmitState getSubmitState() {
                return this.submitState;
            }

            public final List<NodeResult> component8() {
                return this.history;
            }

            /* renamed from: component9, reason: from getter */
            public final BlockUserElement getBlockUserElement() {
                return this.blockUserElement;
            }

            public final Menu copy(MenuAPIResponse menu, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview eventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List<NodeResult> history, BlockUserElement blockUserElement) {
                Intrinsics3.checkNotNullParameter(menu, "menu");
                Intrinsics3.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
                Intrinsics3.checkNotNullParameter(submitState, "submitState");
                Intrinsics3.checkNotNullParameter(history, "history");
                return new Menu(menu, messagePreview, channelPreview, directoryServerPreview, eventPreview, nodeNavigationType, submitState, history, blockUserElement);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Menu)) {
                    return false;
                }
                Menu menu = (Menu) other;
                return Intrinsics3.areEqual(this.menu, menu.menu) && Intrinsics3.areEqual(this.messagePreview, menu.messagePreview) && Intrinsics3.areEqual(this.channelPreview, menu.channelPreview) && Intrinsics3.areEqual(this.directoryServerPreview, menu.directoryServerPreview) && Intrinsics3.areEqual(this.eventPreview, menu.eventPreview) && Intrinsics3.areEqual(this.nodeNavigationType, menu.nodeNavigationType) && Intrinsics3.areEqual(this.submitState, menu.submitState) && Intrinsics3.areEqual(this.history, menu.history) && Intrinsics3.areEqual(this.blockUserElement, menu.blockUserElement);
            }

            public final NodeState genNodeState() {
                Object obj;
                Object next;
                CheckboxElement checkboxElement;
                Object next2;
                Object next3;
                Object next4;
                Object next5;
                Object next6;
                Object next7;
                ReportNode node = this.nodeNavigationType.getNode();
                List<ReportNodeElement> listC = node.c();
                ReportNodeElement.Companion companion = ReportNodeElement.INSTANCE;
                Iterator<T> it = listC.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    ReportNodeElement reportNodeElement = (ReportNodeElement) next;
                    Objects.requireNonNull(companion);
                    Intrinsics3.checkNotNullParameter(reportNodeElement, "element");
                    if (Intrinsics3.areEqual(reportNodeElement.getType(), "checkbox")) {
                        break;
                    }
                }
                ReportNodeElement reportNodeElement2 = (ReportNodeElement) next;
                if (reportNodeElement2 != null) {
                    List<ReportNodeElementData> listA = reportNodeElement2.a();
                    checkboxElement = listA == null ? null : new CheckboxElement(reportNodeElement2.getName(), listA, new HashSet());
                } else {
                    checkboxElement = null;
                }
                List<ReportNodeElement> listC2 = node.c();
                ReportNodeElement.Companion companion2 = ReportNodeElement.INSTANCE;
                Iterator<T> it2 = listC2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it2.next();
                    ReportNodeElement reportNodeElement3 = (ReportNodeElement) next2;
                    Objects.requireNonNull(companion2);
                    Intrinsics3.checkNotNullParameter(reportNodeElement3, "element");
                    if (Intrinsics3.areEqual(reportNodeElement3.getType(), "message_preview")) {
                        break;
                    }
                }
                MessagePreview messagePreview = ((ReportNodeElement) next2) != null ? this.messagePreview : null;
                List<ReportNodeElement> listC3 = node.c();
                ReportNodeElement.Companion companion3 = ReportNodeElement.INSTANCE;
                Iterator<T> it3 = listC3.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        next3 = null;
                        break;
                    }
                    next3 = it3.next();
                    ReportNodeElement reportNodeElement4 = (ReportNodeElement) next3;
                    Objects.requireNonNull(companion3);
                    Intrinsics3.checkNotNullParameter(reportNodeElement4, "element");
                    if (Intrinsics3.areEqual(reportNodeElement4.getType(), "channel_preview")) {
                        break;
                    }
                }
                ChannelPreview channelPreview = ((ReportNodeElement) next3) != null ? this.channelPreview : null;
                List<ReportNodeElement> listC4 = node.c();
                ReportNodeElement.Companion companion4 = ReportNodeElement.INSTANCE;
                Iterator<T> it4 = listC4.iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        next4 = null;
                        break;
                    }
                    next4 = it4.next();
                    ReportNodeElement reportNodeElement5 = (ReportNodeElement) next4;
                    Objects.requireNonNull(companion4);
                    Intrinsics3.checkNotNullParameter(reportNodeElement5, "element");
                    if (Intrinsics3.areEqual(reportNodeElement5.getType(), "guild_directory_entry_preview")) {
                        break;
                    }
                }
                DirectoryServerPreview directoryServerPreview = ((ReportNodeElement) next4) != null ? this.directoryServerPreview : null;
                List<ReportNodeElement> listC5 = node.c();
                ReportNodeElement.Companion companion5 = ReportNodeElement.INSTANCE;
                Iterator<T> it5 = listC5.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        next5 = null;
                        break;
                    }
                    next5 = it5.next();
                    ReportNodeElement reportNodeElement6 = (ReportNodeElement) next5;
                    Objects.requireNonNull(companion5);
                    Intrinsics3.checkNotNullParameter(reportNodeElement6, "element");
                    if (Intrinsics3.areEqual(reportNodeElement6.getType(), "guild_scheduled_event_preview")) {
                        break;
                    }
                }
                GuildScheduledEventPreview guildScheduledEventPreview = ((ReportNodeElement) next5) != null ? this.eventPreview : null;
                List<ReportNodeElement> listC6 = node.c();
                ReportNodeElement.Companion companion6 = ReportNodeElement.INSTANCE;
                Iterator<T> it6 = listC6.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        next6 = null;
                        break;
                    }
                    next6 = it6.next();
                    ReportNodeElement reportNodeElement7 = (ReportNodeElement) next6;
                    Objects.requireNonNull(companion6);
                    Intrinsics3.checkNotNullParameter(reportNodeElement7, "element");
                    if (Intrinsics3.areEqual(reportNodeElement7.getType(), "block_users")) {
                        break;
                    }
                }
                BlockUserElement blockUserElement = ((ReportNodeElement) next6) != null ? this.blockUserElement : null;
                List<ReportNodeElement> listC7 = node.c();
                ReportNodeElement.Companion companion7 = ReportNodeElement.INSTANCE;
                Iterator<T> it7 = listC7.iterator();
                while (true) {
                    if (!it7.hasNext()) {
                        next7 = null;
                        break;
                    }
                    next7 = it7.next();
                    ReportNodeElement reportNodeElement8 = (ReportNodeElement) next7;
                    Objects.requireNonNull(companion7);
                    Intrinsics3.checkNotNullParameter(reportNodeElement8, "element");
                    if (Intrinsics3.areEqual(reportNodeElement8.getType(), "breadcrumbs")) {
                        break;
                    }
                }
                List<NodeResult> list = ((ReportNodeElement) next7) != null ? this.history : null;
                List<ReportNodeElement> listC8 = node.c();
                ReportNodeElement.Companion companion8 = ReportNodeElement.INSTANCE;
                Iterator<T> it8 = listC8.iterator();
                while (true) {
                    if (!it8.hasNext()) {
                        break;
                    }
                    Object next8 = it8.next();
                    ReportNodeElement reportNodeElement9 = (ReportNodeElement) next8;
                    Objects.requireNonNull(companion8);
                    Intrinsics3.checkNotNullParameter(reportNodeElement9, "element");
                    if (Intrinsics3.areEqual(reportNodeElement9.getType(), "success")) {
                        obj = next8;
                        break;
                    }
                }
                return new NodeState(node, checkboxElement, messagePreview, channelPreview, directoryServerPreview, guildScheduledEventPreview, blockUserElement, list, obj != null, this.submitState, node.getButton());
            }

            public final BlockUserElement getBlockUserElement() {
                return this.blockUserElement;
            }

            public final ChannelPreview getChannelPreview() {
                return this.channelPreview;
            }

            public final DirectoryServerPreview getDirectoryServerPreview() {
                return this.directoryServerPreview;
            }

            public final GuildScheduledEventPreview getEventPreview() {
                return this.eventPreview;
            }

            public final List<NodeResult> getHistory() {
                return this.history;
            }

            public final MenuAPIResponse getMenu() {
                return this.menu;
            }

            public final MessagePreview getMessagePreview() {
                return this.messagePreview;
            }

            public final NodeNavigationType getNodeNavigationType() {
                return this.nodeNavigationType;
            }

            public final SubmitState getSubmitState() {
                return this.submitState;
            }

            public int hashCode() {
                MenuAPIResponse menuAPIResponse = this.menu;
                int iHashCode = (menuAPIResponse != null ? menuAPIResponse.hashCode() : 0) * 31;
                MessagePreview messagePreview = this.messagePreview;
                int iHashCode2 = (iHashCode + (messagePreview != null ? messagePreview.hashCode() : 0)) * 31;
                ChannelPreview channelPreview = this.channelPreview;
                int iHashCode3 = (iHashCode2 + (channelPreview != null ? channelPreview.hashCode() : 0)) * 31;
                DirectoryServerPreview directoryServerPreview = this.directoryServerPreview;
                int iHashCode4 = (iHashCode3 + (directoryServerPreview != null ? directoryServerPreview.hashCode() : 0)) * 31;
                GuildScheduledEventPreview guildScheduledEventPreview = this.eventPreview;
                int iHashCode5 = (iHashCode4 + (guildScheduledEventPreview != null ? guildScheduledEventPreview.hashCode() : 0)) * 31;
                NodeNavigationType nodeNavigationType = this.nodeNavigationType;
                int iHashCode6 = (iHashCode5 + (nodeNavigationType != null ? nodeNavigationType.hashCode() : 0)) * 31;
                SubmitState submitState = this.submitState;
                int iHashCode7 = (iHashCode6 + (submitState != null ? submitState.hashCode() : 0)) * 31;
                List<NodeResult> list = this.history;
                int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
                BlockUserElement blockUserElement = this.blockUserElement;
                return iHashCode8 + (blockUserElement != null ? blockUserElement.hashCode() : 0);
            }

            public final boolean shouldHideBackArrow() {
                return (this.submitState instanceof SubmitState.Loading) || this.nodeNavigationType.getNode().getId() == this.menu.getSuccess_node_id() || this.nodeNavigationType.getNode().getId() == this.menu.getRoot_node_id();
            }

            public String toString() {
                StringBuilder sbU = outline.U("Menu(menu=");
                sbU.append(this.menu);
                sbU.append(", messagePreview=");
                sbU.append(this.messagePreview);
                sbU.append(", channelPreview=");
                sbU.append(this.channelPreview);
                sbU.append(", directoryServerPreview=");
                sbU.append(this.directoryServerPreview);
                sbU.append(", eventPreview=");
                sbU.append(this.eventPreview);
                sbU.append(", nodeNavigationType=");
                sbU.append(this.nodeNavigationType);
                sbU.append(", submitState=");
                sbU.append(this.submitState);
                sbU.append(", history=");
                sbU.append(this.history);
                sbU.append(", blockUserElement=");
                sbU.append(this.blockUserElement);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Menu(MenuAPIResponse menuAPIResponse, MessagePreview messagePreview, ChannelPreview channelPreview, DirectoryServerPreview directoryServerPreview, GuildScheduledEventPreview guildScheduledEventPreview, NodeNavigationType nodeNavigationType, SubmitState submitState, List<NodeResult> list, BlockUserElement blockUserElement) {
                super(null);
                Intrinsics3.checkNotNullParameter(menuAPIResponse, "menu");
                Intrinsics3.checkNotNullParameter(nodeNavigationType, "nodeNavigationType");
                Intrinsics3.checkNotNullParameter(submitState, "submitState");
                Intrinsics3.checkNotNullParameter(list, "history");
                this.menu = menuAPIResponse;
                this.messagePreview = messagePreview;
                this.channelPreview = channelPreview;
                this.directoryServerPreview = directoryServerPreview;
                this.eventPreview = guildScheduledEventPreview;
                this.nodeNavigationType = nodeNavigationType;
                this.submitState = submitState;
                this.history = list;
                this.blockUserElement = blockUserElement;
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Void;", "it", "", "invoke", "(Ljava/lang/Void;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleBlockUser$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", "invoke", "(Lkotlin/Unit;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleSubmit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public final /* synthetic */ ViewState.Menu $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Menu menu) {
            super(1);
            this.$currentViewState = menu;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
            MobileReportsViewModel.this.handleNext(new ReportNodeChild("", this.$currentViewState.getMenu().getSuccess_node_id()), null);
        }
    }

    /* compiled from: MobileReportsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.mobile_reports.MobileReportsViewModel$handleSubmit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Menu $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Menu menu) {
            super(1);
            this.$currentViewState = menu;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MobileReportsViewModel.access$updateViewState(MobileReportsViewModel.this, ViewState.Menu.copy$default(this.$currentViewState, null, null, null, null, null, null, SubmitState.Error.INSTANCE, null, null, 447, null));
        }
    }

    public /* synthetic */ MobileReportsViewModel(WeakReference weakReference, WidgetMobileReports2 widgetMobileReports2, RestAPI restAPI, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, widgetMobileReports2, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? Companion.access$getStoreState(INSTANCE, widgetMobileReports2) : observable);
    }

    public static final /* synthetic */ ViewState access$getViewState$p(MobileReportsViewModel mobileReportsViewModel) {
        return mobileReportsViewModel.getViewState();
    }

    public static final /* synthetic */ ChannelPreview access$parseChannelPreview(MobileReportsViewModel mobileReportsViewModel, StoreState storeState) {
        return mobileReportsViewModel.parseChannelPreview(storeState);
    }

    public static final /* synthetic */ DirectoryServerPreview access$parseDirectoryServerPreview(MobileReportsViewModel mobileReportsViewModel, StoreState storeState) {
        return mobileReportsViewModel.parseDirectoryServerPreview(storeState);
    }

    public static final /* synthetic */ GuildScheduledEventPreview access$parseEventPreview(MobileReportsViewModel mobileReportsViewModel, StoreState storeState) {
        return mobileReportsViewModel.parseEventPreview(storeState);
    }

    public static final /* synthetic */ MessagePreview access$parseMessagePreview(MobileReportsViewModel mobileReportsViewModel, StoreState storeState) {
        return mobileReportsViewModel.parseMessagePreview(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(MobileReportsViewModel mobileReportsViewModel, ViewState viewState) {
        mobileReportsViewModel.updateViewState(viewState);
    }

    private final ChannelPreview parseChannelPreview(StoreState storeState) {
        StageInstance stageInstance;
        Guild guild = storeState.getGuild();
        if (guild == null || (stageInstance = storeState.getStageInstance()) == null) {
            return null;
        }
        return new ChannelPreview(guild, stageInstance);
    }

    private final DirectoryServerPreview parseDirectoryServerPreview(StoreState storeState) {
        DirectoryEntryGuild directoryEntry;
        Guild guild = storeState.getGuild();
        if (guild == null || (directoryEntry = storeState.getDirectoryEntry()) == null) {
            return null;
        }
        return new DirectoryServerPreview(guild, directoryEntry);
    }

    private final GuildScheduledEventPreview parseEventPreview(StoreState storeState) {
        Guild guild;
        GuildScheduledEvent event = storeState.getEvent();
        if (event == null || (guild = storeState.getGuild()) == null) {
            return null;
        }
        return new GuildScheduledEventPreview(guild, event);
    }

    private final MessagePreview parseMessagePreview(StoreState storeState) {
        Message message;
        Map<Long, String> map;
        Long lValueOf;
        Context context = this.context.get();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context.get() ?: return null");
            Channel channel = storeState.getChannel();
            if (channel != null && (message = storeState.getMessage()) != null) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Map<Long, User> users = companion.getUsers().getUsers();
                com.discord.api.user.User author = message.getAuthor();
                User user = users.get(author != null ? Long.valueOf(author.getId()) : null);
                if (user == null || (getViewState() instanceof ViewState.Invalid)) {
                    return null;
                }
                long id2 = companion.getUsers().getMeSnapshot().getId();
                Map map2 = (Map) outline.c(channel, companion.getGuilds().getMembers());
                if (map2 == null) {
                    map2 = new HashMap();
                }
                Map map3 = map2;
                Map map4 = (Map) outline.c(channel, companion.getGuilds().getRoles());
                Map<Long, String> channelNames = companion.getChannels().getChannelNames();
                Map<Long, String> nickOrUsernames = MessageUtils.getNickOrUsernames(message, channel, map3, channel.q());
                String content = message.getContent();
                DraweeSpanStringBuilder channelMessage = DiscordParser.parseChannelMessage(context, content != null ? new Regex("\n").replace(content, " ") : null, new MessageRenderContext(context, id2, false, nickOrUsernames, channelNames, map4, 0, null, null, 0, 0, null, null, null, 16320, null), new MessagePreprocessor(id2, null, null, false, 50, 6, null), DiscordParser.ParserOptions.REPLY, false);
                com.discord.api.user.User author2 = message.getAuthor();
                if (author2 != null) {
                    lValueOf = Long.valueOf(author2.getId());
                    map = nickOrUsernames;
                } else {
                    map = nickOrUsernames;
                    lValueOf = null;
                }
                String username = map.get(lValueOf);
                if (username == null) {
                    com.discord.api.user.User author3 = message.getAuthor();
                    username = author3 != null ? author3.getUsername() : null;
                }
                if (username == null) {
                    username = "";
                }
                String str = username;
                GuildMember.Companion companion2 = GuildMember.INSTANCE;
                com.discord.api.user.User author4 = message.getAuthor();
                return new MessagePreview(channelMessage, str, companion2.getColor((GuildMember) map3.get(author4 != null ? Long.valueOf(author4.getId()) : null), ColorCompat.getThemedColor(context, R.attr.colorHeaderPrimary)), user, message.hasEmbeds() || message.hasAttachments());
            }
        }
        return null;
    }

    public final boolean handleBack() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null) {
            return false;
        }
        NodeResult nodeResult = (NodeResult) _Collections.lastOrNull((List) menu.getHistory());
        ReportNode node = nodeResult != null ? nodeResult.getNode() : null;
        ReportNode node2 = menu.getNodeNavigationType().getNode();
        MenuAPIResponse menu2 = menu.getMenu();
        if (menu2.getSuccess_node_id() != node2.getId() && !(menu.getSubmitState() instanceof SubmitState.Loading)) {
            if (node == null || menu2.getRoot_node_id() == node2.getId()) {
                return false;
            }
            updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, new NodeNavigationType.Back(node), null, _Collections.dropLast(menu.getHistory(), 1), null, 351, null));
        }
        return true;
    }

    public final void handleBlockUser() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu != null) {
            ReportNode node = menu.getNodeNavigationType().getNode();
            BlockUserElement blockUserElement = menu.getBlockUserElement();
            if (blockUserElement != null) {
                updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, null, null, null, BlockUserElement.copy$default(blockUserElement, true, null, 2, null), 255, null));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.addRelationship$default(this.restAPI, Companion.access$getLocation(INSTANCE, node), blockUserElement.getUser().getId(), 2, null, null, 24, null), false, 1, null), this, null, 2, null), MobileReportsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
            }
        }
    }

    public final void handleNext(ReportNodeChild destination, NodeElementResult elementResult) {
        ReportNode reportNode;
        Intrinsics3.checkNotNullParameter(destination, "destination");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null || (reportNode = menu.getMenu().c().get(Integer.valueOf(destination.getRef()))) == null) {
            return;
        }
        updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, new NodeNavigationType.Next(reportNode), SubmitState.None.INSTANCE, _Collections.plus((Collection<? extends NodeResult>) menu.getHistory(), new NodeResult(menu.getNodeNavigationType().getNode(), destination, elementResult)), null, 287, null));
    }

    public final void handleSubmit() {
        ReportSubmissionBody reportSubmissionBody;
        Guild guild;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Menu)) {
            viewState = null;
        }
        ViewState.Menu menu = (ViewState.Menu) viewState;
        if (menu == null || (menu.getSubmitState() instanceof SubmitState.Loading)) {
            return;
        }
        updateViewState(ViewState.Menu.copy$default(menu, null, null, null, null, null, null, SubmitState.Loading.INSTANCE, null, null, 447, null));
        WidgetMobileReports2 widgetMobileReports2 = this.args;
        if (widgetMobileReports2 instanceof WidgetMobileReports2.Message) {
            ReportSubmissionBody.Companion companion = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId = this.args.getChannelId();
            long messageId = ((WidgetMobileReports2.Message) this.args).getMessageId();
            MenuAPIResponse menu2 = menu.getMenu();
            List<NodeResult> history = menu.getHistory();
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(menu2, "menu");
            Intrinsics3.checkNotNullParameter(history, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A = companion.a(history);
            List<Integer> listComponent1 = tuples2A.component1();
            Map<String, List<String>> mapComponent2 = tuples2A.component2();
            Long lValueOf = Long.valueOf(messageId);
            Long lValueOf2 = Long.valueOf(channelId);
            String name = menu2.getName();
            String language = menu2.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis, lValueOf, lValueOf2, null, null, null, language != null ? language : "en", menu2.getVariant(), name, menu2.getVersion(), listComponent1, mapComponent2, 56);
        } else if (widgetMobileReports2 instanceof WidgetMobileReports2.StageChannel) {
            ChannelPreview channelPreview = menu.getChannelPreview();
            if (channelPreview == null || (guild = channelPreview.getGuild()) == null) {
                Logger.e$default(AppLog.g, "Tried to send report for stage channel, but without guild id?", null, null, 6, null);
                return;
            }
            long id2 = guild.getId();
            ReportSubmissionBody.Companion companion2 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis2 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId2 = this.args.getChannelId();
            MenuAPIResponse menu3 = menu.getMenu();
            List<NodeResult> history2 = menu.getHistory();
            Objects.requireNonNull(companion2);
            Intrinsics3.checkNotNullParameter(menu3, "menu");
            Intrinsics3.checkNotNullParameter(history2, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A2 = companion2.a(history2);
            List<Integer> listComponent12 = tuples2A2.component1();
            Map<String, List<String>> mapComponent22 = tuples2A2.component2();
            Long lValueOf3 = Long.valueOf(id2);
            Long lValueOf4 = Long.valueOf(channelId2);
            String name2 = menu3.getName();
            String language2 = menu3.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis2, null, lValueOf4, lValueOf3, null, null, language2 != null ? language2 : "en", menu3.getVariant(), name2, menu3.getVersion(), listComponent12, mapComponent22, 50);
        } else if (widgetMobileReports2 instanceof WidgetMobileReports2.DirectoryServer) {
            ReportSubmissionBody.Companion companion3 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis3 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long channelId3 = this.args.getChannelId();
            long guildId = ((WidgetMobileReports2.DirectoryServer) this.args).getGuildId();
            long hubId = ((WidgetMobileReports2.DirectoryServer) this.args).getHubId();
            MenuAPIResponse menu4 = menu.getMenu();
            List<NodeResult> history3 = menu.getHistory();
            Objects.requireNonNull(companion3);
            Intrinsics3.checkNotNullParameter(menu4, "menu");
            Intrinsics3.checkNotNullParameter(history3, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A3 = companion3.a(history3);
            List<Integer> listComponent13 = tuples2A3.component1();
            Map<String, List<String>> mapComponent23 = tuples2A3.component2();
            Long lValueOf5 = Long.valueOf(guildId);
            Long lValueOf6 = Long.valueOf(channelId3);
            Long lValueOf7 = Long.valueOf(hubId);
            String name3 = menu4.getName();
            String language3 = menu4.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis3, null, lValueOf6, lValueOf5, lValueOf7, null, language3 != null ? language3 : "en", menu4.getVariant(), name3, menu4.getVersion(), listComponent13, mapComponent23, 34);
        } else {
            if (!(widgetMobileReports2 instanceof WidgetMobileReports2.GuildScheduledEvent)) {
                throw new NoWhenBranchMatchedException();
            }
            ReportSubmissionBody.Companion companion4 = ReportSubmissionBody.INSTANCE;
            long jCurrentTimeMillis4 = (this.clock.currentTimeMillis() - SnowflakeUtils.DISCORD_EPOCH) << 22;
            long guildId2 = ((WidgetMobileReports2.GuildScheduledEvent) this.args).getGuildId();
            long eventId = ((WidgetMobileReports2.GuildScheduledEvent) this.args).getEventId();
            MenuAPIResponse menu5 = menu.getMenu();
            List<NodeResult> history4 = menu.getHistory();
            Objects.requireNonNull(companion4);
            Intrinsics3.checkNotNullParameter(menu5, "menu");
            Intrinsics3.checkNotNullParameter(history4, "results");
            Tuples2<List<Integer>, Map<String, List<String>>> tuples2A4 = companion4.a(history4);
            List<Integer> listComponent14 = tuples2A4.component1();
            Map<String, List<String>> mapComponent24 = tuples2A4.component2();
            Long lValueOf8 = Long.valueOf(guildId2);
            Long lValueOf9 = Long.valueOf(eventId);
            String name4 = menu5.getName();
            String language4 = menu5.getLanguage();
            reportSubmissionBody = new ReportSubmissionBody(jCurrentTimeMillis4, null, null, lValueOf8, null, lValueOf9, language4 != null ? language4 : "en", menu5.getVariant(), name4, menu5.getVersion(), listComponent14, mapComponent24, 22);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.submitReport(this.args.getReportType().getPathValue(), reportSubmissionBody), false, 1, null), this, null, 2, null), MobileReportsViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(menu), (Function0) null, (Function0) null, new AnonymousClass1(menu), 54, (Object) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsViewModel(WeakReference<Context> weakReference, WidgetMobileReports2 widgetMobileReports2, RestAPI restAPI, Clock clock, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(weakReference, "context");
        Intrinsics3.checkNotNullParameter(widgetMobileReports2, "args");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.context = weakReference;
        this.args = widgetMobileReports2;
        this.restAPI = restAPI;
        this.clock = clock;
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(observable), ObservableExtensionsKt.restSubscribeOn$default(restAPI.getReportMenu(widgetMobileReports2.getReportType().getPathValue()), false, 1, null), AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…> storeState to menuAPI }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), MobileReportsViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }
}
