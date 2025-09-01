package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.application.Application;
import com.discord.api.application.ApplicationType;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u001d\u0012\n\u0010\u000b\u001a\u00060\tj\u0002`\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00060\tj\u0002`\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsEmptyGuildRoleSubscriptionsViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState;", "", "Lcom/discord/api/application/Application;", "applications", "", "handleMonetizationStatus", "(Ljava/util/List;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/utilities/rest/RestAPI;", "restApi", "<init>", "(JLcom/discord/utilities/rest/RestAPI;)V", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ServerSettingsEmptyGuildRoleSubscriptionsViewModel extends AppViewModel<ViewState> {
    private final long guildId;

    /* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/api/application/Application;", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Application>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
            invoke2((List<Application>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Application> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$handleMonetizationStatus(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.this, list);
        }
    }

    /* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel$2, reason: invalid class name */
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
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel = ServerSettingsEmptyGuildRoleSubscriptionsViewModel.this;
            ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$updateViewState(serverSettingsEmptyGuildRoleSubscriptionsViewModel, ViewState.copy$default(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.access$requireViewState(serverSettingsEmptyGuildRoleSubscriptionsViewModel), false, null, 2, null));
        }
    }

    /* compiled from: ServerSettingsEmptyGuildRoleSubscriptionsViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0007\u0010\u0004R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\b\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState;", "", "", "component1", "()Z", "component2", "()Ljava/lang/Boolean;", "isLoading", "isMonetizationEnabled", "copy", "(ZLjava/lang/Boolean;)Lcom/discord/widgets/servers/guild_role_subscription/ServerSettingsEmptyGuildRoleSubscriptionsViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/Boolean;", "<init>", "(ZLjava/lang/Boolean;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Boolean isMonetizationEnabled;

        public ViewState() {
            this(false, null, 3, null);
        }

        public ViewState(boolean z2, Boolean bool) {
            this.isLoading = z2;
            this.isMonetizationEnabled = bool;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isLoading;
            }
            if ((i & 2) != 0) {
                bool = viewState.isMonetizationEnabled;
            }
            return viewState.copy(z2, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getIsMonetizationEnabled() {
            return this.isMonetizationEnabled;
        }

        public final ViewState copy(boolean isLoading, Boolean isMonetizationEnabled) {
            return new ViewState(isLoading, isMonetizationEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics3.areEqual(this.isMonetizationEnabled, viewState.isMonetizationEnabled);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Boolean bool = this.isMonetizationEnabled;
            return i + (bool != null ? bool.hashCode() : 0);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final Boolean isMonetizationEnabled() {
            return this.isMonetizationEnabled;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isLoading=");
            sbU.append(this.isLoading);
            sbU.append(", isMonetizationEnabled=");
            return outline.D(sbU, this.isMonetizationEnabled, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z2, (i & 2) != 0 ? null : bool);
        }
    }

    public /* synthetic */ ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ void access$handleMonetizationStatus(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel, List list) {
        serverSettingsEmptyGuildRoleSubscriptionsViewModel.handleMonetizationStatus(list);
    }

    public static final /* synthetic */ ViewState access$requireViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel) {
        return serverSettingsEmptyGuildRoleSubscriptionsViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsEmptyGuildRoleSubscriptionsViewModel serverSettingsEmptyGuildRoleSubscriptionsViewModel, ViewState viewState) {
        serverSettingsEmptyGuildRoleSubscriptionsViewModel.updateViewState(viewState);
    }

    private final void handleMonetizationStatus(List<Application> applications) {
        Object next;
        Iterator<T> it = applications.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Application application = (Application) next;
            Long guildId = application.getGuildId();
            if (guildId != null && guildId.longValue() == this.guildId && application.getType() == ApplicationType.GUILD_ROLE_SUBSCRIPTIONS) {
                break;
            }
        }
        updateViewState(requireViewState().copy(false, Boolean.valueOf(((Application) next) != null)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsEmptyGuildRoleSubscriptionsViewModel(long j, RestAPI restAPI) {
        super(new ViewState(false, null, 3, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        this.guildId = j;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.getGuildApplications(j, false), false, 1, null), this, null, 2, null), ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
    }
}
