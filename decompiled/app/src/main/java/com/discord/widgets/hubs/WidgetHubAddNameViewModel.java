package com.discord.widgets.hubs;

import b.a.d.AppViewModel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAddNameViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\n\u0010\n\u001a\u00060\bj\u0002`\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u00060\bj\u0002`\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubAddNameViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/AddNameState;", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "setName", "(Ljava/lang/String;)V", "", "Lcom/discord/primitives/GuildId;", "guildId", "J", "getGuildId", "()J", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "Lcom/discord/stores/StoreUser;", "userStore", "Lcom/discord/stores/StoreUser;", "getUserStore", "()Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreGuilds;", "guildStore", "Lcom/discord/stores/StoreGuilds;", "getGuildStore", "()Lcom/discord/stores/StoreGuilds;", "<init>", "(JLcom/discord/stores/StoreGuilds;Lcom/discord/stores/StoreUser;Lcom/discord/utilities/rest/RestAPI;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubAddNameViewModel extends AppViewModel<WidgetHubAddNameViewModel2> {
    private final long guildId;
    private final StoreGuilds guildStore;
    private final RestAPI restAPI;
    private final StoreUser userStore;

    /* compiled from: WidgetHubAddNameViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Ljava/lang/Void;", "async", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubAddNameViewModel$setName$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RestCallState<? extends Void>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends Void> restCallState) {
            invoke2((RestCallState<Void>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<Void> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "async");
            WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2Access$getViewState$p = WidgetHubAddNameViewModel.access$getViewState$p(WidgetHubAddNameViewModel.this);
            if (widgetHubAddNameViewModel2Access$getViewState$p != null) {
                WidgetHubAddNameViewModel.access$updateViewState(WidgetHubAddNameViewModel.this, WidgetHubAddNameViewModel2.copy$default(widgetHubAddNameViewModel2Access$getViewState$p, null, null, restCallState, 3, null));
            }
        }
    }

    public /* synthetic */ WidgetHubAddNameViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ WidgetHubAddNameViewModel2 access$getViewState$p(WidgetHubAddNameViewModel widgetHubAddNameViewModel) {
        return widgetHubAddNameViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubAddNameViewModel widgetHubAddNameViewModel, WidgetHubAddNameViewModel2 widgetHubAddNameViewModel2) {
        widgetHubAddNameViewModel.updateViewState(widgetHubAddNameViewModel2);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final StoreGuilds getGuildStore() {
        return this.guildStore;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final StoreUser getUserStore() {
        return this.userStore;
    }

    public final void setName(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        WidgetHubAddNameViewModel2 viewState = getViewState();
        if (viewState != null) {
            updateViewState(WidgetHubAddNameViewModel2.copy$default(viewState, name, null, null, 6, null));
        }
        RestCallState5.executeRequest(this.restAPI.changeGuildNickname(this.guildId, new RestAPIParams.Nick(name)), new AnonymousClass2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddNameViewModel(long j, StoreGuilds storeGuilds, StoreUser storeUser, RestAPI restAPI) {
        super(new WidgetHubAddNameViewModel2(null, null, null, 7, null));
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.guildId = j;
        this.guildStore = storeGuilds;
        this.userStore = storeUser;
        this.restAPI = restAPI;
        Guild guild = storeGuilds.getGuild(j);
        GuildMember member = storeGuilds.getMember(j, storeUser.getMeSnapshot().getId());
        String nick = member != null ? member.getNick() : null;
        updateViewState(new WidgetHubAddNameViewModel2(nick == null ? "" : nick, guild, null, 4, null));
    }
}
