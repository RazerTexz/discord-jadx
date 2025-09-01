package com.discord.widgets.guildscheduledevent;

import b.a.d.AppViewModel;
import com.discord.api.directory.DirectoryEntryGuild3;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEventBroadcast;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDirectoryAssociationState;", "", "Lcom/discord/primitives/GuildId;", "guildId", "existingGuildScheduledEventId", "Lcom/discord/stores/StoreGuilds;", "guildsStore", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "<init>", "(JLjava/lang/Long;Lcom/discord/stores/StoreGuilds;Lcom/discord/utilities/rest/RestAPI;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class GuildScheduledEventDirectoryAssociationViewModel extends AppViewModel<GuildScheduledEventDirectoryAssociationViewModel2> {

    /* compiled from: GuildScheduledEventDirectoryAssociationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/guildscheduledevent/GuildScheduledEventBroadcast;", "async", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDirectoryAssociationViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends GuildScheduledEventBroadcast>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends GuildScheduledEventBroadcast> restCallState) {
            invoke2((RestCallState<GuildScheduledEventBroadcast>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<GuildScheduledEventBroadcast> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "async");
            GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2Access$getViewState$p = GuildScheduledEventDirectoryAssociationViewModel.access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel.this);
            if (guildScheduledEventDirectoryAssociationViewModel2Access$getViewState$p != null) {
                GuildScheduledEventDirectoryAssociationViewModel.access$updateViewState(GuildScheduledEventDirectoryAssociationViewModel.this, guildScheduledEventDirectoryAssociationViewModel2Access$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, l, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ GuildScheduledEventDirectoryAssociationViewModel2 access$getViewState$p(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel) {
        return guildScheduledEventDirectoryAssociationViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(GuildScheduledEventDirectoryAssociationViewModel guildScheduledEventDirectoryAssociationViewModel, GuildScheduledEventDirectoryAssociationViewModel2 guildScheduledEventDirectoryAssociationViewModel2) {
        guildScheduledEventDirectoryAssociationViewModel.updateViewState(guildScheduledEventDirectoryAssociationViewModel2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDirectoryAssociationViewModel(long j, Long l, StoreGuilds storeGuilds, RestAPI restAPI) {
        super(new GuildScheduledEventDirectoryAssociationViewModel2(null, 1, null));
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Guild guild = storeGuilds.getGuild(j);
        if (guild != null ? guild.hasFeature(GuildFeature.HAS_DIRECTORY_ENTRY) : true) {
            RestCallState5.executeRequest(restAPI.getDirectoryEntryBroadcastInfo(j, l, DirectoryEntryGuild3.GuildScheduledEvent.getKey()), new AnonymousClass1());
        }
    }
}
