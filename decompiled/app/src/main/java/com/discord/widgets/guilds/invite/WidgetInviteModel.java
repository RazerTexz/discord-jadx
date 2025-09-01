package com.discord.widgets.guilds.invite;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.widgets.guilds.invite.InviteGenerator;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetInviteModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 92\u00020\u0001:\u00019Bg\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u000b\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0012\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b7\u00108J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ|\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020%HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b\u001b\u0010\rR\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u0010\u0004R\u001f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u00100\u001a\u0004\b1\u0010\u0011R\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b2\u0010\u0011R\u0019\u0010\u001d\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u00103\u001a\u0004\b4\u0010\u0014R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\b6\u0010\nR\u0019\u0010\u001f\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010-\u001a\u0004\b\u001f\u0010\rR\u0019\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010-\u001a\u0004\b\u001a\u0010\r¨\u0006:"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "", "Lcom/discord/api/channel/Channel;", "component1", "()Lcom/discord/api/channel/Channel;", "Lcom/discord/models/domain/ModelInvite$Settings;", "component2", "()Lcom/discord/models/domain/ModelInvite$Settings;", "Lcom/discord/models/domain/ModelInvite;", "component3", "()Lcom/discord/models/domain/ModelInvite;", "", "component4", "()Z", "component5", "", "component6", "()Ljava/util/List;", "Lcom/discord/models/user/MeUser;", "component7", "()Lcom/discord/models/user/MeUser;", "component8", "component9", "targetChannel", "settings", "invite", "isGeneratingInvite", "isValidInvite", "invitableChannels", "me", "dms", "isInviteFromStore", "copy", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelInvite$Settings;Lcom/discord/models/domain/ModelInvite;ZZLjava/util/List;Lcom/discord/models/user/MeUser;Ljava/util/List;Z)Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/domain/ModelInvite$Settings;", "getSettings", "Z", "Lcom/discord/api/channel/Channel;", "getTargetChannel", "Ljava/util/List;", "getInvitableChannels", "getDms", "Lcom/discord/models/user/MeUser;", "getMe", "Lcom/discord/models/domain/ModelInvite;", "getInvite", "<init>", "(Lcom/discord/api/channel/Channel;Lcom/discord/models/domain/ModelInvite$Settings;Lcom/discord/models/domain/ModelInvite;ZZLjava/util/List;Lcom/discord/models/user/MeUser;Ljava/util/List;Z)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class WidgetInviteModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<Channel> dms;
    private final List<Channel> invitableChannels;
    private final ModelInvite invite;
    private final boolean isGeneratingInvite;
    private final boolean isInviteFromStore;
    private final boolean isValidInvite;
    private final MeUser me;
    private final ModelInvite.Settings settings;
    private final Channel targetChannel;

    /* compiled from: WidgetInviteModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJC\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u008d\u0001\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0016\u0010\t\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/guilds/invite/WidgetInviteModel$Companion;", "", "", "Lcom/discord/primitives/ChannelId;", "selectedChannelId", "Lcom/discord/models/guild/Guild;", "guild", "", "Lcom/discord/api/stageinstance/StageInstance;", "guildStageInstances", "Lcom/discord/models/domain/ModelInvite;", "tryGetStaticInvite", "(Ljava/lang/Long;Lcom/discord/models/guild/Guild;Ljava/util/Map;)Lcom/discord/models/domain/ModelInvite;", "Lcom/discord/models/domain/ModelInvite$Settings;", "settings", "Lcom/discord/api/channel/Channel;", "invitableChannels", "Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;", "inviteGenerationState", "Lcom/discord/models/user/MeUser;", "me", "", "dms", "Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;", "guildScheduledEvent", "existingInviteFromStore", "Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "create", "(Lcom/discord/models/domain/ModelInvite$Settings;Ljava/util/Map;Lcom/discord/widgets/guilds/invite/InviteGenerator$InviteGenerationState;Ljava/lang/Long;Lcom/discord/models/user/MeUser;Ljava/util/List;Lcom/discord/models/guild/Guild;Ljava/util/Map;Lcom/discord/api/guildscheduledevent/GuildScheduledEvent;Lcom/discord/models/domain/ModelInvite;)Lcom/discord/widgets/guilds/invite/WidgetInviteModel;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final ModelInvite tryGetStaticInvite(Long selectedChannelId, Guild guild, Map<Long, StageInstance> guildStageInstances) {
            String inviteCode;
            if (guild == null) {
                return null;
            }
            StageInstance stageInstance = guildStageInstances.get(selectedChannelId);
            if (stageInstance != null && (inviteCode = stageInstance.getInviteCode()) != null) {
                return ModelInvite.createForStaticUrl(inviteCode, GuildUtils.createApiGuild(guild));
            }
            String vanityUrlCode = guild.getVanityUrlCode();
            if (vanityUrlCode != null) {
                return ModelInvite.createForStaticUrl(vanityUrlCode, GuildUtils.createApiGuild(guild));
            }
            return null;
        }

        public final WidgetInviteModel create(ModelInvite.Settings settings, Map<Long, Channel> invitableChannels, InviteGenerator.InviteGenerationState inviteGenerationState, Long selectedChannelId, MeUser me2, List<Channel> dms, Guild guild, Map<Long, StageInstance> guildStageInstances, GuildScheduledEvent guildScheduledEvent, ModelInvite existingInviteFromStore) {
            ModelInvite modelInviteTryGetStaticInvite;
            boolean z2;
            Channel channel;
            Intrinsics3.checkNotNullParameter(settings, "settings");
            Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
            Intrinsics3.checkNotNullParameter(inviteGenerationState, "inviteGenerationState");
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(dms, "dms");
            Intrinsics3.checkNotNullParameter(guildStageInstances, "guildStageInstances");
            if (existingInviteFromStore != null) {
                return new WidgetInviteModel(null, null, existingInviteFromStore, false, true, Collections2.emptyList(), me2, dms, true);
            }
            ModelInvite lastGeneratedInvite = inviteGenerationState.getLastGeneratedInvite();
            ArrayList arrayList = new ArrayList(invitableChannels.values());
            Collections.sort(arrayList, ChannelUtils.h(Channel.INSTANCE));
            Channel channel2 = invitableChannels.containsKey(selectedChannelId) ? invitableChannels.get(selectedChannelId) : arrayList.isEmpty() ^ true ? (Channel) arrayList.get(0) : null;
            boolean z3 = (lastGeneratedInvite == null || channel2 == null || lastGeneratedInvite.getChannel() == null || (channel = lastGeneratedInvite.getChannel()) == null || channel.getId() != channel2.getId()) ? false : true;
            if ((channel2 == null || inviteGenerationState.getState() == InviteGenerator.GenerationState.FAILURE) && (modelInviteTryGetStaticInvite = tryGetStaticInvite(selectedChannelId, guild, guildStageInstances)) != null) {
                z2 = true;
            } else {
                z2 = z3;
                modelInviteTryGetStaticInvite = lastGeneratedInvite;
            }
            if (channel2 != null && guildScheduledEvent != null && guildScheduledEvent.p(channel2.getId()) && modelInviteTryGetStaticInvite != null) {
                modelInviteTryGetStaticInvite.setGuildScheduledEvent(guildScheduledEvent);
            }
            return new WidgetInviteModel(channel2, settings, modelInviteTryGetStaticInvite, inviteGenerationState.getState() == InviteGenerator.GenerationState.GENERATING, z2, arrayList, me2, dms, false);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetInviteModel(Channel channel, ModelInvite.Settings settings, ModelInvite modelInvite, boolean z2, boolean z3, List<Channel> list, MeUser meUser, List<Channel> list2, boolean z4) {
        Intrinsics3.checkNotNullParameter(list, "invitableChannels");
        Intrinsics3.checkNotNullParameter(meUser, "me");
        Intrinsics3.checkNotNullParameter(list2, "dms");
        this.targetChannel = channel;
        this.settings = settings;
        this.invite = modelInvite;
        this.isGeneratingInvite = z2;
        this.isValidInvite = z3;
        this.invitableChannels = list;
        this.me = meUser;
        this.dms = list2;
        this.isInviteFromStore = z4;
    }

    public static /* synthetic */ WidgetInviteModel copy$default(WidgetInviteModel widgetInviteModel, Channel channel, ModelInvite.Settings settings, ModelInvite modelInvite, boolean z2, boolean z3, List list, MeUser meUser, List list2, boolean z4, int i, Object obj) {
        return widgetInviteModel.copy((i & 1) != 0 ? widgetInviteModel.targetChannel : channel, (i & 2) != 0 ? widgetInviteModel.settings : settings, (i & 4) != 0 ? widgetInviteModel.invite : modelInvite, (i & 8) != 0 ? widgetInviteModel.isGeneratingInvite : z2, (i & 16) != 0 ? widgetInviteModel.isValidInvite : z3, (i & 32) != 0 ? widgetInviteModel.invitableChannels : list, (i & 64) != 0 ? widgetInviteModel.me : meUser, (i & 128) != 0 ? widgetInviteModel.dms : list2, (i & 256) != 0 ? widgetInviteModel.isInviteFromStore : z4);
    }

    /* renamed from: component1, reason: from getter */
    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    /* renamed from: component2, reason: from getter */
    public final ModelInvite.Settings getSettings() {
        return this.settings;
    }

    /* renamed from: component3, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsGeneratingInvite() {
        return this.isGeneratingInvite;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsValidInvite() {
        return this.isValidInvite;
    }

    public final List<Channel> component6() {
        return this.invitableChannels;
    }

    /* renamed from: component7, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final List<Channel> component8() {
        return this.dms;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsInviteFromStore() {
        return this.isInviteFromStore;
    }

    public final WidgetInviteModel copy(Channel targetChannel, ModelInvite.Settings settings, ModelInvite invite, boolean isGeneratingInvite, boolean isValidInvite, List<Channel> invitableChannels, MeUser me2, List<Channel> dms, boolean isInviteFromStore) {
        Intrinsics3.checkNotNullParameter(invitableChannels, "invitableChannels");
        Intrinsics3.checkNotNullParameter(me2, "me");
        Intrinsics3.checkNotNullParameter(dms, "dms");
        return new WidgetInviteModel(targetChannel, settings, invite, isGeneratingInvite, isValidInvite, invitableChannels, me2, dms, isInviteFromStore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetInviteModel)) {
            return false;
        }
        WidgetInviteModel widgetInviteModel = (WidgetInviteModel) other;
        return Intrinsics3.areEqual(this.targetChannel, widgetInviteModel.targetChannel) && Intrinsics3.areEqual(this.settings, widgetInviteModel.settings) && Intrinsics3.areEqual(this.invite, widgetInviteModel.invite) && this.isGeneratingInvite == widgetInviteModel.isGeneratingInvite && this.isValidInvite == widgetInviteModel.isValidInvite && Intrinsics3.areEqual(this.invitableChannels, widgetInviteModel.invitableChannels) && Intrinsics3.areEqual(this.me, widgetInviteModel.me) && Intrinsics3.areEqual(this.dms, widgetInviteModel.dms) && this.isInviteFromStore == widgetInviteModel.isInviteFromStore;
    }

    public final List<Channel> getDms() {
        return this.dms;
    }

    public final List<Channel> getInvitableChannels() {
        return this.invitableChannels;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final ModelInvite.Settings getSettings() {
        return this.settings;
    }

    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Channel channel = this.targetChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        ModelInvite.Settings settings = this.settings;
        int iHashCode2 = (iHashCode + (settings != null ? settings.hashCode() : 0)) * 31;
        ModelInvite modelInvite = this.invite;
        int iHashCode3 = (iHashCode2 + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31;
        boolean z2 = this.isGeneratingInvite;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        boolean z3 = this.isValidInvite;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        List<Channel> list = this.invitableChannels;
        int iHashCode4 = (i4 + (list != null ? list.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode5 = (iHashCode4 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        List<Channel> list2 = this.dms;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        boolean z4 = this.isInviteFromStore;
        return iHashCode6 + (z4 ? 1 : z4 ? 1 : 0);
    }

    public final boolean isGeneratingInvite() {
        return this.isGeneratingInvite;
    }

    public final boolean isInviteFromStore() {
        return this.isInviteFromStore;
    }

    public final boolean isValidInvite() {
        return this.isValidInvite;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetInviteModel(targetChannel=");
        sbU.append(this.targetChannel);
        sbU.append(", settings=");
        sbU.append(this.settings);
        sbU.append(", invite=");
        sbU.append(this.invite);
        sbU.append(", isGeneratingInvite=");
        sbU.append(this.isGeneratingInvite);
        sbU.append(", isValidInvite=");
        sbU.append(this.isValidInvite);
        sbU.append(", invitableChannels=");
        sbU.append(this.invitableChannels);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", dms=");
        sbU.append(this.dms);
        sbU.append(", isInviteFromStore=");
        return outline.O(sbU, this.isInviteFromStore, ")");
    }

    public /* synthetic */ WidgetInviteModel(Channel channel, ModelInvite.Settings settings, ModelInvite modelInvite, boolean z2, boolean z3, List list, MeUser meUser, List list2, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(channel, settings, modelInvite, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? false : z3, list, meUser, list2, (i & 256) != 0 ? false : z4);
    }
}
