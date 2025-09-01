package com.discord.widgets.guilds.create;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.Guild;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* compiled from: WidgetGuildCreateViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003;<=Bm\u0012\b\b\u0001\u0010/\u001a\u00020.\u0012\b\b\u0002\u00102\u001a\u000201\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020\u0015\u0012\b\u00104\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010-\u001a\u00020#\u0012\b\b\u0002\u0010*\u001a\u00020)\u0012\b\b\u0002\u00106\u001a\u000205\u0012\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0003¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001d\u0010\u001eR:\u0010!\u001a&\u0012\f\u0012\n  *\u0004\u0018\u00010\n0\n  *\u0012\u0012\f\u0012\n  *\u0004\u0018\u00010\n0\n\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010-\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010%R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010(R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u0006>"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "Lcom/discord/models/guild/Guild;", "guild", "", "handleGuildCreateSuccess", "(Lcom/discord/models/guild/Guild;)V", "handleGuildCreateFailure", "()V", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "event", "emitEvent", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;)V", "Lrx/Observable;", "observeEvents", "()Lrx/Observable;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;", "storeState", "handleStoreState", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;)V", "", "guildName", "updateGuildName", "(Ljava/lang/String;)V", "guildIconUri", "updateGuildIconUri", "Landroid/content/Context;", "context", "createGuild", "(Landroid/content/Context;)V", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventsSubject", "Lrx/subjects/PublishSubject;", "", "showChannelPrompt", "Z", "didTrackCreateGuildViewed", "analyticLocation", "Ljava/lang/String;", "Lcom/discord/stores/StoreGuildSelected;", "selectedGuildStore", "Lcom/discord/stores/StoreGuildSelected;", "guildTemplateCode", "closeWithResult", "", "defaultGuildNameFormatRes", "I", "Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "stockGuildTemplate", "Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "customTitle", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "storeObservable", "<init>", "(ILcom/discord/widgets/guilds/create/StockGuildTemplate;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLcom/discord/stores/StoreGuildSelected;Lcom/discord/utilities/rest/RestAPI;Lrx/Observable;)V", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel extends AppViewModel<ViewState> {
    private final String analyticLocation;
    private final boolean closeWithResult;
    private final String customTitle;
    private final int defaultGuildNameFormatRes;
    private boolean didTrackCreateGuildViewed;
    private final PublishSubject<Event> eventsSubject;
    private final String guildTemplateCode;
    private final RestAPI restAPI;
    private final StoreGuildSelected selectedGuildStore;
    private final boolean showChannelPrompt;
    private final StockGuildTemplate stockGuildTemplate;

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", NotificationCompat.CATEGORY_CALL, "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Action0 {
        public final /* synthetic */ String $guildTemplateCode;

        public AnonymousClass1(String str) {
            this.$guildTemplateCode = str;
        }

        @Override // rx.functions.Action0
        public final void call() {
            StoreStream.INSTANCE.getGuildTemplates().maybeInitTemplateState(this.$guildTemplateCode);
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/models/user/User;", "p1", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "p2", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;", "invoke", "(Lcom/discord/models/user/User;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<User, StoreGuildTemplates.GuildTemplateState, StoreState> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(2, StoreState.class, "<init>", "<init>(Lcom/discord/models/user/User;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ StoreState invoke(User user, StoreGuildTemplates.GuildTemplateState guildTemplateState) {
            return invoke2(user, guildTemplateState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final StoreState invoke2(User user, StoreGuildTemplates.GuildTemplateState guildTemplateState) {
            Intrinsics3.checkNotNullParameter(user, "p1");
            Intrinsics3.checkNotNullParameter(guildTemplateState, "p2");
            return new StoreState(user, guildTemplateState);
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;", "it", "", "invoke", "(Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "it");
            WidgetGuildCreateViewModel.this.handleStoreState(storeState);
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "", "<init>", "()V", "CloseWithResult", "LaunchChannelPrompt", "LaunchInviteShareScreen", "ShowToast", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$ShowToast;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$LaunchChannelPrompt;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$CloseWithResult;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetGuildCreateViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$CloseWithResult;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$CloseWithResult;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class CloseWithResult extends Event {
            private final long guildId;

            public CloseWithResult(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ CloseWithResult copy$default(CloseWithResult closeWithResult, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = closeWithResult.guildId;
                }
                return closeWithResult.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final CloseWithResult copy(long guildId) {
                return new CloseWithResult(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CloseWithResult) && this.guildId == ((CloseWithResult) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("CloseWithResult(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: WidgetGuildCreateViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$LaunchChannelPrompt;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$LaunchChannelPrompt;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchChannelPrompt extends Event {
            private final long guildId;

            public LaunchChannelPrompt(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ LaunchChannelPrompt copy$default(LaunchChannelPrompt launchChannelPrompt, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchChannelPrompt.guildId;
                }
                return launchChannelPrompt.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchChannelPrompt copy(long guildId) {
                return new LaunchChannelPrompt(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchChannelPrompt) && this.guildId == ((LaunchChannelPrompt) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchChannelPrompt(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: WidgetGuildCreateViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "", "Lcom/discord/primitives/GuildId;", "component1", "()J", "guildId", "copy", "(J)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$LaunchInviteShareScreen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getGuildId", "<init>", "(J)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class LaunchInviteShareScreen extends Event {
            private final long guildId;

            public LaunchInviteShareScreen(long j) {
                super(null);
                this.guildId = j;
            }

            public static /* synthetic */ LaunchInviteShareScreen copy$default(LaunchInviteShareScreen launchInviteShareScreen, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchInviteShareScreen.guildId;
                }
                return launchInviteShareScreen.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final LaunchInviteShareScreen copy(long guildId) {
                return new LaunchInviteShareScreen(guildId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof LaunchInviteShareScreen) && this.guildId == ((LaunchInviteShareScreen) other).guildId;
                }
                return true;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public int hashCode() {
                return b.a(this.guildId);
            }

            public String toString() {
                return outline.C(outline.U("LaunchInviteShareScreen(guildId="), this.guildId, ")");
            }
        }

        /* compiled from: WidgetGuildCreateViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$ShowToast;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event;", "", "component1", "()I", "stringResId", "copy", "(I)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$Event$ShowToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getStringResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowToast extends Event {
            private final int stringResId;

            public ShowToast(@StringRes int i) {
                super(null);
                this.stringResId = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.stringResId;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getStringResId() {
                return this.stringResId;
            }

            public final ShowToast copy(@StringRes int stringResId) {
                return new ShowToast(stringResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.stringResId == ((ShowToast) other).stringResId;
                }
                return true;
            }

            public final int getStringResId() {
                return this.stringResId;
            }

            public int hashCode() {
                return this.stringResId;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(stringResId="), this.stringResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;", "", "Lcom/discord/models/user/User;", "component1", "()Lcom/discord/models/user/User;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "component2", "()Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "meUser", "guildTemplate", "copy", "(Lcom/discord/models/user/User;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "getGuildTemplate", "Lcom/discord/models/user/User;", "getMeUser", "<init>", "(Lcom/discord/models/user/User;Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final StoreGuildTemplates.GuildTemplateState guildTemplate;
        private final User meUser;

        public StoreState(User user, StoreGuildTemplates.GuildTemplateState guildTemplateState) {
            Intrinsics3.checkNotNullParameter(user, "meUser");
            Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplate");
            this.meUser = user;
            this.guildTemplate = guildTemplateState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, StoreGuildTemplates.GuildTemplateState guildTemplateState, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.meUser;
            }
            if ((i & 2) != 0) {
                guildTemplateState = storeState.guildTemplate;
            }
            return storeState.copy(user, guildTemplateState);
        }

        /* renamed from: component1, reason: from getter */
        public final User getMeUser() {
            return this.meUser;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
            return this.guildTemplate;
        }

        public final StoreState copy(User meUser, StoreGuildTemplates.GuildTemplateState guildTemplate) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
            return new StoreState(meUser, guildTemplate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.guildTemplate, storeState.guildTemplate);
        }

        public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
            return this.guildTemplate;
        }

        public final User getMeUser() {
            return this.meUser;
        }

        public int hashCode() {
            User user = this.meUser;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            StoreGuildTemplates.GuildTemplateState guildTemplateState = this.guildTemplate;
            return iHashCode + (guildTemplateState != null ? guildTemplateState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", guildTemplate=");
            sbU.append(this.guildTemplate);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "", "<init>", "()V", "Initialized", "Uninitialized", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState$Initialized;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetGuildCreateViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0015\u001a\u00020\r\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u001a\u001a\u00020\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0007J\\\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0003\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0004J\u001a\u0010\"\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b%\u0010\u0007R\u0019\u0010\u001a\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b\u001a\u0010\u0013R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b'\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010*R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010$¨\u0006-"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState$Initialized;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "", "component2", "()I", "", "component3", "()Ljava/lang/String;", "component4", "Landroid/content/Context;", "context", "getGuildName", "(Landroid/content/Context;)Ljava/lang/String;", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "component1", "()Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "component5", "", "component6", "()Z", "component7", "guildTemplate", "defaultGuildNameFormatRes", "username", "guildName", "guildIconUri", "isBusy", "customTitle", "copy", "(Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState$Initialized;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getGuildIconUri", "Z", "getCustomTitle", "Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;", "getGuildTemplate", "I", "<init>", "(Lcom/discord/stores/StoreGuildTemplates$GuildTemplateState;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Initialized extends ViewState {
            private final String customTitle;
            private final int defaultGuildNameFormatRes;
            private final String guildIconUri;
            private final String guildName;
            private final StoreGuildTemplates.GuildTemplateState guildTemplate;
            private final boolean isBusy;
            private final String username;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(StoreGuildTemplates.GuildTemplateState guildTemplateState, @StringRes int i, String str, String str2, String str3, boolean z2, String str4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplate");
                Intrinsics3.checkNotNullParameter(str, "username");
                this.guildTemplate = guildTemplateState;
                this.defaultGuildNameFormatRes = i;
                this.username = str;
                this.guildName = str2;
                this.guildIconUri = str3;
                this.isBusy = z2;
                this.customTitle = str4;
            }

            /* renamed from: component2, reason: from getter */
            private final int getDefaultGuildNameFormatRes() {
                return this.defaultGuildNameFormatRes;
            }

            /* renamed from: component3, reason: from getter */
            private final String getUsername() {
                return this.username;
            }

            /* renamed from: component4, reason: from getter */
            private final String getGuildName() {
                return this.guildName;
            }

            public static /* synthetic */ Initialized copy$default(Initialized initialized, StoreGuildTemplates.GuildTemplateState guildTemplateState, int i, String str, String str2, String str3, boolean z2, String str4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    guildTemplateState = initialized.guildTemplate;
                }
                if ((i2 & 2) != 0) {
                    i = initialized.defaultGuildNameFormatRes;
                }
                int i3 = i;
                if ((i2 & 4) != 0) {
                    str = initialized.username;
                }
                String str5 = str;
                if ((i2 & 8) != 0) {
                    str2 = initialized.guildName;
                }
                String str6 = str2;
                if ((i2 & 16) != 0) {
                    str3 = initialized.guildIconUri;
                }
                String str7 = str3;
                if ((i2 & 32) != 0) {
                    z2 = initialized.isBusy;
                }
                boolean z3 = z2;
                if ((i2 & 64) != 0) {
                    str4 = initialized.customTitle;
                }
                return initialized.copy(guildTemplateState, i3, str5, str6, str7, z3, str4);
            }

            /* renamed from: component1, reason: from getter */
            public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
                return this.guildTemplate;
            }

            /* renamed from: component5, reason: from getter */
            public final String getGuildIconUri() {
                return this.guildIconUri;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getIsBusy() {
                return this.isBusy;
            }

            /* renamed from: component7, reason: from getter */
            public final String getCustomTitle() {
                return this.customTitle;
            }

            public final Initialized copy(StoreGuildTemplates.GuildTemplateState guildTemplate, @StringRes int defaultGuildNameFormatRes, String username, String guildName, String guildIconUri, boolean isBusy, String customTitle) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                Intrinsics3.checkNotNullParameter(username, "username");
                return new Initialized(guildTemplate, defaultGuildNameFormatRes, username, guildName, guildIconUri, isBusy, customTitle);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return Intrinsics3.areEqual(this.guildTemplate, initialized.guildTemplate) && this.defaultGuildNameFormatRes == initialized.defaultGuildNameFormatRes && Intrinsics3.areEqual(this.username, initialized.username) && Intrinsics3.areEqual(this.guildName, initialized.guildName) && Intrinsics3.areEqual(this.guildIconUri, initialized.guildIconUri) && this.isBusy == initialized.isBusy && Intrinsics3.areEqual(this.customTitle, initialized.customTitle);
            }

            public final String getCustomTitle() {
                return this.customTitle;
            }

            public final String getGuildIconUri() {
                return this.guildIconUri;
            }

            public final String getGuildName(Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                String str = this.guildName;
                return str != null ? str : FormatUtils.h(context, this.defaultGuildNameFormatRes, new Object[]{this.username}, null, 4).toString();
            }

            public final StoreGuildTemplates.GuildTemplateState getGuildTemplate() {
                return this.guildTemplate;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                StoreGuildTemplates.GuildTemplateState guildTemplateState = this.guildTemplate;
                int iHashCode = (((guildTemplateState != null ? guildTemplateState.hashCode() : 0) * 31) + this.defaultGuildNameFormatRes) * 31;
                String str = this.username;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.guildName;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.guildIconUri;
                int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
                boolean z2 = this.isBusy;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode4 + i) * 31;
                String str4 = this.customTitle;
                return i2 + (str4 != null ? str4.hashCode() : 0);
            }

            public final boolean isBusy() {
                return this.isBusy;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Initialized(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(", defaultGuildNameFormatRes=");
                sbU.append(this.defaultGuildNameFormatRes);
                sbU.append(", username=");
                sbU.append(this.username);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", guildIconUri=");
                sbU.append(this.guildIconUri);
                sbU.append(", isBusy=");
                sbU.append(this.isBusy);
                sbU.append(", customTitle=");
                return outline.J(sbU, this.customTitle, ")");
            }
        }

        /* compiled from: WidgetGuildCreateViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState$Uninitialized;", "Lcom/discord/widgets/guilds/create/WidgetGuildCreateViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/api/guild/Guild;", "createdGuild", "", "invoke", "(Lcom/discord/api/guild/Guild;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "createdGuild");
            WidgetGuildCreateViewModel.access$handleGuildCreateSuccess(WidgetGuildCreateViewModel.this, new com.discord.models.guild.Guild(guild));
        }
    }

    /* compiled from: WidgetGuildCreateViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
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
            WidgetGuildCreateViewModel.access$handleGuildCreateFailure(WidgetGuildCreateViewModel.this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildCreateViewModel(int i, StockGuildTemplate stockGuildTemplate, String str, boolean z2, String str2, String str3, boolean z3, StoreGuildSelected storeGuildSelected, RestAPI restAPI, Observable observable, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        Observable observable2;
        StockGuildTemplate stockGuildTemplate2 = (i2 & 2) != 0 ? StockGuildTemplate.CREATE : stockGuildTemplate;
        boolean z4 = (i2 & 64) != 0 ? false : z3;
        StoreGuildSelected guildSelected = (i2 & 128) != 0 ? StoreStream.INSTANCE.getGuildSelected() : storeGuildSelected;
        RestAPI api = (i2 & 256) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i2 & 512) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableZ = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).Z(1);
            Observable<StoreGuildTemplates.GuildTemplateState> scalarSynchronousObservable = str == null ? new ScalarSynchronousObservable<>(StoreGuildTemplates.GuildTemplateState.None.INSTANCE) : companion.getGuildTemplates().observeGuildTemplate(str).v(new AnonymousClass1(str));
            AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
            Observable observableJ = Observable.j(observableZ, scalarSynchronousObservable, (Func2) (anonymousClass2 != null ? new WidgetGuildCreateViewModel3(anonymousClass2) : anonymousClass2));
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…},\n      ::StoreState\n  )");
            observable2 = observableJ;
        } else {
            observable2 = observable;
        }
        this(i, stockGuildTemplate2, str, z2, str2, str3, z4, guildSelected, api, observable2);
    }

    public static final /* synthetic */ StockGuildTemplate access$getStockGuildTemplate$p(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        return widgetGuildCreateViewModel.stockGuildTemplate;
    }

    public static final /* synthetic */ void access$handleGuildCreateFailure(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        widgetGuildCreateViewModel.handleGuildCreateFailure();
    }

    public static final /* synthetic */ void access$handleGuildCreateSuccess(WidgetGuildCreateViewModel widgetGuildCreateViewModel, com.discord.models.guild.Guild guild) {
        widgetGuildCreateViewModel.handleGuildCreateSuccess(guild);
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventsSubject.k.onNext(event);
    }

    @MainThread
    private final void handleGuildCreateFailure() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, null, null, false, null, 95, null));
        }
    }

    @MainThread
    private final void handleGuildCreateSuccess(com.discord.models.guild.Guild guild) {
        if (!this.closeWithResult) {
            this.selectedGuildStore.set(guild.getId());
        }
        emitEvent(this.showChannelPrompt ? new Event.LaunchChannelPrompt(guild.getId()) : this.closeWithResult ? new Event.CloseWithResult(guild.getId()) : new Event.LaunchInviteShareScreen(guild.getId()));
    }

    @MainThread
    public final void createGuild(Context context) {
        Observable<Guild> observableLogNetworkAction;
        Intrinsics3.checkNotNullParameter(context, "context");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            String guildName = initialized.getGuildName(context);
            String guildIconUri = initialized.getGuildIconUri();
            if (initialized.isBusy()) {
                return;
            }
            if (StringsJVM.isBlank(guildName)) {
                emitEvent(new Event.ShowToast(R.string.server_name_required));
                return;
            }
            if (initialized.getGuildTemplate() instanceof StoreGuildTemplates.GuildTemplateState.Resolved) {
                observableLogNetworkAction = this.restAPI.createGuildFromTemplate(((StoreGuildTemplates.GuildTemplateState.Resolved) initialized.getGuildTemplate()).getGuildTemplate().getCode(), new RestAPIParams.CreateGuildFromTemplate(guildName, guildIconUri));
            } else {
                RestAPI restAPI = this.restAPI;
                StockGuildTemplate stockGuildTemplate = this.stockGuildTemplate;
                Resources resources = context.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "context.resources");
                observableLogNetworkAction = RestCallState5.logNetworkAction(restAPI.createGuild(new RestAPIParams.CreateGuild(guildName, guildIconUri, stockGuildTemplate.getChannels(resources), Long.valueOf(this.stockGuildTemplate.getSystemChannelId()))), new WidgetGuildCreateViewModel2(this));
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(observableLogNetworkAction, false), this, null, 2, null), WidgetGuildCreateViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, null, null, true, null, 95, null));
        }
    }

    @MainThread
    public final void handleStoreState(StoreState storeState) {
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        updateViewState(new ViewState.Initialized(storeState.getGuildTemplate(), this.defaultGuildNameFormatRes, storeState.getMeUser().getUsername(), null, null, false, this.customTitle));
        if (this.didTrackCreateGuildViewed || (storeState.getGuildTemplate() instanceof StoreGuildTemplates.GuildTemplateState.Loading)) {
            return;
        }
        AnalyticsTracker.INSTANCE.createGuildViewed(this.stockGuildTemplate, storeState.getGuildTemplate() instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? ((StoreGuildTemplates.GuildTemplateState.Resolved) storeState.getGuildTemplate()).getGuildTemplate() : null, this.analyticLocation);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventsSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventsSubject");
        return publishSubject;
    }

    @MainThread
    public final void updateGuildIconUri(String guildIconUri) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, null, guildIconUri, false, null, 111, null));
        }
    }

    @MainThread
    public final void updateGuildName(String guildName) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            updateViewState(ViewState.Initialized.copy$default(initialized, null, 0, null, guildName, null, false, null, 119, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel(@StringRes int i, StockGuildTemplate stockGuildTemplate, String str, boolean z2, String str2, String str3, boolean z3, StoreGuildSelected storeGuildSelected, RestAPI restAPI, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(stockGuildTemplate, "stockGuildTemplate");
        Intrinsics3.checkNotNullParameter(str2, "analyticLocation");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "selectedGuildStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.defaultGuildNameFormatRes = i;
        this.stockGuildTemplate = stockGuildTemplate;
        this.guildTemplateCode = str;
        this.showChannelPrompt = z2;
        this.analyticLocation = str2;
        this.customTitle = str3;
        this.closeWithResult = z3;
        this.selectedGuildStore = storeGuildSelected;
        this.restAPI = restAPI;
        this.eventsSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetGuildCreateViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
