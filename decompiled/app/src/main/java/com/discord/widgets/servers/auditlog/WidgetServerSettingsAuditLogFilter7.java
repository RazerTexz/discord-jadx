package com.discord.widgets.servers.auditlog;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import d0.f0._Sequences2;
import d0.t._Maps;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsAuditLogFilter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\u0010\u000f\u001a\u001e\u0012\b\u0012\u00060\u0003j\u0002`\b \u0006*\u000e\u0012\b\u0012\u00060\u0003j\u0002`\b\u0018\u00010\f0\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002.\u0010\u0007\u001a*\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0014\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00020\u000226\u0010\u000b\u001a2\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n \u0006*\u0018\u0012\b\u0012\u00060\u0003j\u0002`\b\u0012\b\u0012\u00060\tj\u0002`\n\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/discord/models/guild/Guild;", "guild", "", "", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "kotlin.jvm.PlatformType", "roles", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "members", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Map;)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter7<T1, T2, T3, R> implements Func3<Guild, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Set<? extends Long>> {
    public static final WidgetServerSettingsAuditLogFilter7 INSTANCE = new WidgetServerSettingsAuditLogFilter7();

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "<name for destructuring parameter 0>", "", "invoke", "(Ljava/util/Map$Entry;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends GuildMember>, Boolean> {
        public final /* synthetic */ Guild $guild;
        public final /* synthetic */ Map $roles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Guild guild, Map map) {
            super(1);
            this.$guild = guild;
            this.$roles = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Map.Entry<? extends Long, ? extends GuildMember> entry) {
            return Boolean.valueOf(invoke2((Map.Entry<Long, GuildMember>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Map.Entry<Long, GuildMember> entry) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
            long jLongValue = entry.getKey().longValue();
            GuildMember value = entry.getValue();
            Guild guild = this.$guild;
            if (guild != null && jLongValue == guild.getOwnerId()) {
                return true;
            }
            List<Long> roles = value.getRoles();
            if ((roles instanceof Collection) && roles.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = roles.iterator();
                while (it.hasNext()) {
                    GuildRole guildRole = (GuildRole) this.$roles.get(Long.valueOf(((Number) it.next()).longValue()));
                    if (((guildRole != null ? guildRole.getPermissions() : 0L) & Permission.MANAGEMENT_PERMISSIONS) > 0) {
                        z2 = true;
                        break;
                    }
                }
                z2 = false;
            }
            return z2;
        }
    }

    /* compiled from: WidgetServerSettingsAuditLogFilter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010&\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00060\u0001j\u0002`\u00022\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "it", "invoke", "(Ljava/util/Map$Entry;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$Model$Companion$getPermissionUserIds$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Map.Entry<? extends Long, ? extends GuildMember>, Long> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Long invoke(Map.Entry<? extends Long, ? extends GuildMember> entry) {
            return Long.valueOf(invoke2((Map.Entry<Long, GuildMember>) entry));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2(Map.Entry<Long, GuildMember> entry) {
            Intrinsics3.checkNotNullParameter(entry, "it");
            return entry.getKey().longValue();
        }
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Set<? extends Long> call(Guild guild, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2) {
        return call2(guild, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Set<Long> call2(Guild guild, Map<Long, GuildRole> map, Map<Long, GuildMember> map2) {
        Intrinsics3.checkNotNullExpressionValue(map2, "members");
        return _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Maps.asSequence(map2), new AnonymousClass1(guild, map)), AnonymousClass2.INSTANCE));
    }
}
