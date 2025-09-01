package com.discord.utilities.stage;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.start.WidgetModeratorStartStage;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: StageChannelUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b#\u0010$J?\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\n\u0010\n\u001a\u00060\u0006j\u0002`\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u001a\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u0006j\u0002`\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/discord/utilities/stage/StageChannelUtils;", "", "Lcom/discord/stores/StorePermissions;", "permissionStore", "Lcom/discord/stores/StoreGuilds;", "guildStore", "", "Lcom/discord/primitives/UserId;", "meId", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/api/channel/Channel;", "channel", "", "computeCanEditStageModerators", "(Lcom/discord/stores/StorePermissions;Lcom/discord/stores/StoreGuilds;JJLcom/discord/api/channel/Channel;)Z", "Lcom/discord/primitives/ChannelId;", "channelId", "Lcom/discord/stores/StoreChannels;", "channelsStore", "Lcom/discord/stores/StoreStageChannels;", "stageChannelsStore", "Lcom/discord/stores/StoreStageInstances;", "stageInstanceStore", "Lcom/discord/stores/StoreUser;", "userStore", "shouldShowEndStageBottomSheet", "(JLcom/discord/stores/StoreChannels;Lcom/discord/stores/StoreStageChannels;Lcom/discord/stores/StoreStageInstances;Lcom/discord/stores/StoreUser;)Z", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "connectToStageChannel", "(Lcom/discord/api/channel/Channel;Landroid/content/Context;Landroidx/fragment/app/FragmentManager;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageChannelUtils {
    public static final StageChannelUtils INSTANCE = new StageChannelUtils();

    /* compiled from: StageChannelUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.stage.StageChannelUtils$connectToStageChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context, FragmentManager fragmentManager, Channel channel) {
            super(0);
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, this.$context, this.$fragmentManager, this.$channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
        }
    }

    private StageChannelUtils() {
    }

    public static final boolean computeCanEditStageModerators(StorePermissions permissionStore, StoreGuilds guildStore, long meId, long guildId, Channel channel) {
        Intrinsics3.checkNotNullParameter(permissionStore, "permissionStore");
        Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Guild guild = guildStore.getGuilds().get(Long.valueOf(guildId));
        if ((guild != null && guild.isOwner(meId)) || AnimatableValueParser.H0((Long) outline.d(channel, permissionStore.getPermissionsByChannel()), 8L) || AnimatableValueParser.H0(permissionStore.getGuildPermissions().get(Long.valueOf(guildId)), 289406992L)) {
            return true;
        }
        PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
        Map<Long, GuildMember> map = guildStore.getMembers().get(Long.valueOf(guildId));
        return AnimatableValueParser.H0(Long.valueOf(permissionUtils.computeChannelOverwrite(meId, guildId, map != null ? map.get(Long.valueOf(meId)) : null, channel.v())), Permission.MANAGE_ROLES);
    }

    public static /* synthetic */ boolean shouldShowEndStageBottomSheet$default(StageChannelUtils stageChannelUtils, long j, StoreChannels storeChannels, StoreStageChannels storeStageChannels, StoreStageInstances storeStageInstances, StoreUser storeUser, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannels = StoreStream.INSTANCE.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 4) != 0) {
            storeStageChannels = StoreStream.INSTANCE.getStageChannels();
        }
        StoreStageChannels storeStageChannels2 = storeStageChannels;
        if ((i & 8) != 0) {
            storeStageInstances = StoreStream.INSTANCE.getStageInstances();
        }
        StoreStageInstances storeStageInstances2 = storeStageInstances;
        if ((i & 16) != 0) {
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        return stageChannelUtils.shouldShowEndStageBottomSheet(j, storeChannels2, storeStageChannels2, storeStageInstances2, storeUser);
    }

    public final void connectToStageChannel(Channel channel, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (channel.getType() != 13) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StageInstance stageInstanceForChannel = companion.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long l = (Long) outline.d(channel, companion.getPermissions().getPermissionsByChannel());
        if (stageInstanceForChannel != null && AnimatableValueParser.W0(stageInstanceForChannel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
            return;
        }
        if (stageInstanceForChannel != null || l == null || !PermissionUtils.can(20971536L, Long.valueOf(l.longValue()))) {
            MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, channel.getGuildId(), "Guild Voice", null, null, new AnonymousClass2(context, fragmentManager, channel), 48, null);
            return;
        }
        WidgetModeratorStartStage.INSTANCE.launch(context, channel.getId(), channel.getGuildId());
    }

    public final boolean shouldShowEndStageBottomSheet(long channelId, StoreChannels channelsStore, StoreStageChannels stageChannelsStore, StoreStageInstances stageInstanceStore, StoreUser userStore) {
        StageRoles stageRolesM15getMyRolesvisDeB4;
        Map<Long, StageRoles> channelRoles;
        Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
        Intrinsics3.checkNotNullParameter(stageChannelsStore, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(stageInstanceStore, "stageInstanceStore");
        Intrinsics3.checkNotNullParameter(userStore, "userStore");
        Channel channel = channelsStore.getChannel(channelId);
        if (channel == null || !ChannelUtils.D(channel) || stageInstanceStore.getStageInstanceForChannel(channel.getId()) == null || (stageRolesM15getMyRolesvisDeB4 = stageChannelsStore.m15getMyRolesvisDeB4(channel.getId())) == null || !StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) || (channelRoles = stageChannelsStore.getChannelRoles(channel.getId())) == null) {
            return false;
        }
        long id2 = userStore.getMeSnapshot().getId();
        boolean z2 = false;
        boolean z3 = false;
        for (Map.Entry<Long, StageRoles> entry : channelRoles.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            int iM35unboximpl = entry.getValue().m35unboximpl();
            if (jLongValue != id2 && StageRoles.m32isModeratorimpl(iM35unboximpl)) {
                if (StageRoles.m33isSpeakerimpl(iM35unboximpl)) {
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            return true;
        }
        if (StageRoles.m33isSpeakerimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
            return !z3;
        }
        return false;
    }
}
