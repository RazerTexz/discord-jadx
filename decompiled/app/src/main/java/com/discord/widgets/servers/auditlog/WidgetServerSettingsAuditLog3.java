package com.discord.widgets.servers.auditlog;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.domain.ModelWebhook;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreAuditLog;
import com.discord.utilities.auditlogs.AuditLogChangeUtils;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogAdapter;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import rx.functions.Func6;

/* compiled from: WidgetServerSettingsAuditLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0016\u001a\n \u0001*\u0004\u0018\u00010\u00130\u00132\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032.\u0010\t\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00050\u00052.\u0010\f\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u000b \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00050\u00052.\u0010\u000f\u001a*\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e \u0001*\u0014\u0012\b\u0012\u00060\u0006j\u0002`\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00050\u000526\u0010\u0012\u001a2\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\b\u0012\u00060\u0010j\u0002`\u0011 \u0001*\u0018\u0012\b\u0012\u00060\u0006j\u0002`\n\u0012\b\u0012\u00060\u0010j\u0002`\u0011\u0018\u00010\u00050\u0005H\n¢\u0006\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/discord/stores/StoreAuditLog$AuditLogState;", "kotlin.jvm.PlatformType", "auditLogState", "Lcom/discord/models/guild/Guild;", "guild", "", "", "Lcom/discord/primitives/ChannelId;", "Lcom/discord/api/channel/Channel;", "channels", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/user/User;", "users", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "roles", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "guildMembers", "Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreAuditLog$AuditLogState;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLog$Model;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLog3<T1, T2, T3, T4, T5, T6, R> implements Func6<StoreAuditLog.AuditLogState, Guild, Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, WidgetServerSettingsAuditLog.Model> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsAuditLog3(long j, Context context) {
        this.$guildId = j;
        this.$context = context;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLog.Model call(StoreAuditLog.AuditLogState auditLogState, Guild guild, Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildRole> map3, Map<Long, ? extends GuildMember> map4) {
        return call2(auditLogState, guild, (Map<Long, Channel>) map, map2, (Map<Long, GuildRole>) map3, (Map<Long, GuildMember>) map4);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetServerSettingsAuditLog.Model call2(StoreAuditLog.AuditLogState auditLogState, Guild guild, Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildRole> map3, Map<Long, GuildMember> map4) {
        CharSequence string;
        CharSequence userNameWithDiscriminator$default;
        Channel channel;
        CharSequence charSequenceAccess$resolveChannelName;
        Map map5;
        Map<Long, Channel> map6 = map;
        if ((auditLogState != null ? auditLogState.getEntries() : null) == null || guild == null) {
            return WidgetServerSettingsAuditLog.Model.Loading.INSTANCE;
        }
        HashMap map7 = new HashMap();
        map7.putAll(auditLogState.getDeletedTargets());
        for (ModelAuditLogEntry modelAuditLogEntry : auditLogState.getEntries()) {
            if (map7.get(modelAuditLogEntry.getTargetType()) == null) {
                ModelAuditLogEntry.TargetType targetType = modelAuditLogEntry.getTargetType();
                Intrinsics3.checkNotNullExpressionValue(targetType, "entry.targetType");
                map7.put(targetType, new HashMap());
            }
            ModelAuditLogEntry.TargetType targetType2 = modelAuditLogEntry.getTargetType();
            if (targetType2 == null) {
                charSequenceAccess$resolveChannelName = null;
            } else {
                switch (targetType2) {
                    case ALL:
                    case UNKNOWN:
                    case GUILD:
                    case INVITE:
                    case WEBHOOK:
                    case EMOJI:
                    case INTEGRATION:
                    case STAGE_INSTANCE:
                    case GUILD_SCHEDULED_EVENT:
                    case STICKER:
                    case THREAD:
                        break;
                    case CHANNEL:
                    case CHANNEL_OVERWRITE:
                        WidgetServerSettingsAuditLog.Model.Companion companion = WidgetServerSettingsAuditLog.Model.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(map6, "channels");
                        charSequenceAccess$resolveChannelName = WidgetServerSettingsAuditLog.Model.Companion.access$resolveChannelName(companion, map6, modelAuditLogEntry);
                        break;
                    case USER:
                        User user = map2.get(Long.valueOf(modelAuditLogEntry.getTargetId()));
                        if (user != null) {
                            charSequenceAccess$resolveChannelName = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
                            break;
                        } else {
                            charSequenceAccess$resolveChannelName = null;
                            break;
                        }
                    case ROLE:
                        GuildRole guildRole = map3.get(Long.valueOf(modelAuditLogEntry.getTargetId()));
                        if (guildRole != null) {
                            charSequenceAccess$resolveChannelName = guildRole.getName();
                            break;
                        }
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            if (charSequenceAccess$resolveChannelName != null && (map5 = (Map) map7.get(modelAuditLogEntry.getTargetType())) != null) {
            }
        }
        ModelAuditLogEntry.TargetType targetType3 = ModelAuditLogEntry.TargetType.CHANNEL;
        if (map7.get(targetType3) == null) {
            map7.put(targetType3, new HashMap());
        }
        Intrinsics3.checkNotNullExpressionValue(map6, "channels");
        Iterator<Map.Entry<Long, Channel>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                ModelAuditLogEntry.TargetType targetType4 = ModelAuditLogEntry.TargetType.USER;
                if (map7.get(targetType4) == null) {
                    map7.put(targetType4, new HashMap());
                }
                for (Map.Entry<Long, User> entry : auditLogState.getUsers().entrySet()) {
                    Map map8 = (Map) map7.get(ModelAuditLogEntry.TargetType.USER);
                    if (map8 != null) {
                    }
                }
                ModelAuditLogEntry.TargetType targetType5 = ModelAuditLogEntry.TargetType.GUILD;
                if (map7.get(targetType5) == null) {
                    map7.put(targetType5, new HashMap());
                }
                Map map9 = (Map) map7.get(targetType5);
                if (map9 != null) {
                }
                ModelAuditLogEntry.TargetType targetType6 = ModelAuditLogEntry.TargetType.WEBHOOK;
                if (map7.get(targetType6) == null) {
                    map7.put(targetType6, new HashMap());
                }
                for (ModelWebhook modelWebhook : auditLogState.getWebhooks()) {
                    Map map10 = (Map) map7.get(ModelAuditLogEntry.TargetType.WEBHOOK);
                    if (map10 != null) {
                    }
                }
                ModelAuditLogEntry.TargetType targetType7 = ModelAuditLogEntry.TargetType.INTEGRATION;
                if (map7.get(targetType7) == null) {
                    map7.put(targetType7, new HashMap());
                }
                for (ModelGuildIntegration modelGuildIntegration : auditLogState.getIntegrations()) {
                    Map map11 = (Map) map7.get(ModelAuditLogEntry.TargetType.INTEGRATION);
                    if (map11 != null) {
                    }
                }
                ModelAuditLogEntry.TargetType targetType8 = ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT;
                if (map7.get(targetType8) == null) {
                    map7.put(targetType8, new HashMap());
                }
                for (GuildScheduledEvent guildScheduledEvent : auditLogState.getGuildScheduledEvents()) {
                    Map map12 = (Map) map7.get(ModelAuditLogEntry.TargetType.GUILD_SCHEDULED_EVENT);
                    if (map12 != null) {
                    }
                }
                ModelAuditLogEntry.TargetType targetType9 = ModelAuditLogEntry.TargetType.THREAD;
                if (map7.get(targetType9) == null) {
                    map7.put(targetType9, new HashMap());
                }
                for (Channel channel2 : auditLogState.getThreads()) {
                    Map map13 = (Map) map7.get(ModelAuditLogEntry.TargetType.THREAD);
                    if (map13 != null) {
                    }
                }
                boolean z2 = true;
                ArrayList arrayList = new ArrayList(auditLogState.getEntries().size() + 1);
                List<ModelAuditLogEntry> entries = auditLogState.getEntries();
                ArrayList<ModelAuditLogEntry> arrayList2 = new ArrayList();
                for (Object obj : entries) {
                    if (AuditLogUtils.INSTANCE.getALL_ACTION_TYPES().contains(Integer.valueOf(((ModelAuditLogEntry) obj).getActionTypeId()))) {
                        arrayList2.add(obj);
                    }
                }
                for (ModelAuditLogEntry modelAuditLogEntry2 : arrayList2) {
                    String str = ((modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL || modelAuditLogEntry2.getTargetType() == ModelAuditLogEntry.TargetType.CHANNEL_OVERWRITE) && (channel = map6.get(Long.valueOf(modelAuditLogEntry2.getTargetId()))) != null && ChannelUtils.v(channel) == z2) ? "#" : "";
                    User user2 = auditLogState.getUsers().get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                    CharSequence charSequence = (user2 == null || (userNameWithDiscriminator$default = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user2, null, null, 3, null)) == null) ? "" : userNameWithDiscriminator$default;
                    long id2 = modelAuditLogEntry2.getId();
                    Long selectedItemId = auditLogState.getSelectedItemId();
                    boolean z3 = selectedItemId != null && id2 == selectedItemId.longValue();
                    User user3 = auditLogState.getUsers().get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                    GuildMember guildMember = map4.get(Long.valueOf(modelAuditLogEntry2.getUserId()));
                    AuditLogUtils auditLogUtils = AuditLogUtils.INSTANCE;
                    CharSequence headerString = auditLogUtils.getHeaderString(modelAuditLogEntry2, charSequence, this.$context, map7, str);
                    AuditLogChangeUtils auditLogChangeUtils = AuditLogChangeUtils.INSTANCE;
                    arrayList.add(new WidgetServerSettingsAuditLogAdapter.AuditLogEntryItem(modelAuditLogEntry2, z3, user3, guildMember, headerString, auditLogChangeUtils.getChangeSummary(this.$context, modelAuditLogEntry2, map7), auditLogChangeUtils.hasChangesToRender(modelAuditLogEntry2), auditLogUtils.getTimestampString(modelAuditLogEntry2, this.$context)));
                    z2 = true;
                    map6 = map;
                }
                if (auditLogState.isLoading()) {
                    arrayList.add(new WidgetServerSettingsAuditLogAdapter.AuditLogLoadingItem());
                }
                User user4 = map2.get(Long.valueOf(auditLogState.getFilter().getUserFilter()));
                if (user4 == null || (string = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user4, null, null, 3, null)) == null) {
                    string = this.$context.getString(R.string.guild_settings_filter_all_users);
                    Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…ettings_filter_all_users)");
                }
                String string2 = this.$context.getString(AuditLogUtils.INSTANCE.getActionName(auditLogState.getFilter().getActionFilter()));
                Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(AuditL…ate.filter.actionFilter))");
                return new WidgetServerSettingsAuditLog.Model.Loaded(arrayList, string, string2);
            }
            Map.Entry<Long, Channel> next = it.next();
            String str2 = ChannelUtils.v(next.getValue()) ? "#" : "";
            Map map14 = (Map) map7.get(ModelAuditLogEntry.TargetType.CHANNEL);
            if (map14 != null) {
                Long lValueOf = Long.valueOf(next.getValue().getId());
                StringBuilder sbU = outline.U(str2);
                sbU.append(ChannelUtils.c(next.getValue()));
            }
        }
    }
}
