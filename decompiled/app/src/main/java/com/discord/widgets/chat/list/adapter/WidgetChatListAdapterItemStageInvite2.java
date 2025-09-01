package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreRequestedStageChannels;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreUser;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite;
import com.discord.widgets.chat.list.entries.StageInviteEntry;
import com.discord.widgets.stage.StageRoles;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChatListAdapterItemStageInvite.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "invoke", "()Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemStageInvite$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStageInvite$Model$Companion$observe$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStageInvite2 extends Lambda implements Function0<WidgetChatListAdapterItemStageInvite.Model> {
    public final /* synthetic */ StoreAccessibility $accessibilityStore;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ StageInviteEntry $item;
    public final /* synthetic */ StoreRequestedStageChannels $requestedInstanceStore;
    public final /* synthetic */ StoreStageChannels $stageChannelStore;
    public final /* synthetic */ StoreStageInstances $stageInstanceStore;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStageInvite2(StoreUser storeUser, StageInviteEntry stageInviteEntry, StoreChannels storeChannels, StoreAccessibility storeAccessibility, StoreStageInstances storeStageInstances, StoreRequestedStageChannels storeRequestedStageChannels, StoreStageChannels storeStageChannels, StoreGuilds storeGuilds) {
        super(0);
        this.$userStore = storeUser;
        this.$item = stageInviteEntry;
        this.$channelStore = storeChannels;
        this.$accessibilityStore = storeAccessibility;
        this.$stageInstanceStore = storeStageInstances;
        this.$requestedInstanceStore = storeRequestedStageChannels;
        this.$stageChannelStore = storeStageChannels;
        this.$guildStore = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemStageInvite.Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetChatListAdapterItemStageInvite.Model invoke() {
        Channel channel;
        StageInstance stageInstance;
        StageInstance stageInstance2;
        List listAccess$speakersFromLocalStore;
        Integer num;
        Integer numValueOf;
        long id2 = this.$userStore.getMeSnapshot().getId();
        User user = this.$userStore.getUsers().get(Long.valueOf(this.$item.getUserId()));
        Channel channel2 = this.$item.getInvite().getChannel();
        if (channel2 != null) {
            channel = this.$channelStore.getChannel(channel2.getId());
            if (channel == null) {
                channel = this.$item.getInvite().getChannel();
            }
        }
        Channel channel3 = channel;
        boolean reducedMotionEnabled = this.$accessibilityStore.getReducedMotionEnabled();
        if (channel3 != null) {
            long id3 = channel3.getId();
            StageInstance stageInstanceForChannel = this.$stageInstanceStore.getStageInstanceForChannel(id3);
            if (stageInstanceForChannel == null) {
                stageInstanceForChannel = this.$requestedInstanceStore.getStageInstanceForChannel(id3);
            }
            stageInstance = stageInstanceForChannel;
        } else {
            stageInstance = null;
        }
        Map<Long, StageRoles> channelRoles = channel3 != null ? this.$stageChannelStore.getChannelRoles(channel3.getId()) : null;
        StoreRequestedStageChannels.StageInstanceState stageInstanceState = channel3 != null ? this.$requestedInstanceStore.getRequestedInstanceStatesByChannel().get(Long.valueOf(channel3.getId())) : null;
        if (channel3 != null) {
            long id4 = channel3.getId();
            WidgetChatListAdapterItemStageInvite.Model.Companion companion = WidgetChatListAdapterItemStageInvite.Model.INSTANCE;
            stageInstance2 = stageInstance;
            listAccess$speakersFromLocalStore = WidgetChatListAdapterItemStageInvite.Model.Companion.access$speakersFromLocalStore(companion, this.$guildStore, this.$userStore, this.$stageChannelStore, id4, this.$item.getGuildId());
            if (listAccess$speakersFromLocalStore == null) {
                listAccess$speakersFromLocalStore = WidgetChatListAdapterItemStageInvite.Model.Companion.access$speakersFromRequest(companion, stageInstanceState);
            }
        } else {
            stageInstance2 = stageInstance;
            listAccess$speakersFromLocalStore = null;
        }
        if (channelRoles == null || listAccess$speakersFromLocalStore == null) {
            if ((stageInstanceState != null ? stageInstanceState.getStageInstance() : null) == null) {
                num = null;
                return new WidgetChatListAdapterItemStageInvite.Model(this.$item.getInvite(), id2, user, channel3, !reducedMotionEnabled, stageInstance2, listAccess$speakersFromLocalStore == null ? listAccess$speakersFromLocalStore : Collections2.emptyList(), num);
            }
            numValueOf = Integer.valueOf(stageInstanceState.getStageInstance().getParticipantCount() - stageInstanceState.getStageInstance().d().size());
        } else {
            numValueOf = Integer.valueOf(channelRoles.size() - listAccess$speakersFromLocalStore.size());
        }
        num = numValueOf;
        return new WidgetChatListAdapterItemStageInvite.Model(this.$item.getInvite(), id2, user, channel3, !reducedMotionEnabled, stageInstance2, listAccess$speakersFromLocalStore == null ? listAccess$speakersFromLocalStore : Collections2.emptyList(), num);
    }
}
