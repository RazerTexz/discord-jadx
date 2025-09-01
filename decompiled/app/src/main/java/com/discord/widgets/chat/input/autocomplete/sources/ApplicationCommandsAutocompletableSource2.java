package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.member.GuildMember;
import com.discord.stores.DiscoverCommands;
import com.discord.widgets.chat.input.WidgetChatInputDiscoveryCommandsModel;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import rx.functions.Func5;

/* compiled from: ApplicationCommandsAutocompletableSource.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0012\u001a\n \u0002*\u0004\u0018\u00010\u000f0\u000f2\u0018\u0010\u0003\u001a\u0014 \u0002*\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00010\u0000j\u0002`\u000126\u0010\u0007\u001a2\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u0005j\u0002`\u0006 \u0002*\u0018\u0012\b\u0012\u00060\u0000j\u0002`\u0001\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0018\u00010\u00040\u00042\u000e\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b \u0002*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n2\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\r \u0002*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n0\nH\n¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", "Lcom/discord/primitives/UserId;", "kotlin.jvm.PlatformType", "meId", "", "Lcom/discord/models/member/GuildMember;", "Lcom/discord/stores/ClientGuildMember;", "myRoles", "Lcom/discord/stores/DiscoverCommands;", "discoveryCommands", "", "Lcom/discord/models/commands/Application;", "apps", "Lcom/discord/models/commands/ApplicationCommand;", "frecency", "Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Long;Ljava/util/Map;Lcom/discord/stores/DiscoverCommands;Ljava/util/List;Ljava/util/List;)Lcom/discord/widgets/chat/input/WidgetChatInputDiscoveryCommandsModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.autocomplete.sources.ApplicationCommandsAutocompletableSource$Companion$getDiscoveryCommands$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ApplicationCommandsAutocompletableSource2<T1, T2, T3, T4, T5, R> implements Func5<Long, Map<Long, ? extends GuildMember>, DiscoverCommands, List<? extends Application>, List<? extends ApplicationCommand>, WidgetChatInputDiscoveryCommandsModel> {
    public final /* synthetic */ boolean $includeHeaders;
    public final /* synthetic */ int $placeholdersCount;

    public ApplicationCommandsAutocompletableSource2(boolean z2, int i) {
        this.$includeHeaders = z2;
        this.$placeholdersCount = i;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChatInputDiscoveryCommandsModel call(Long l, Map<Long, ? extends GuildMember> map, DiscoverCommands discoverCommands, List<? extends Application> list, List<? extends ApplicationCommand> list2) {
        return call2(l, (Map<Long, GuildMember>) map, discoverCommands, (List<Application>) list, list2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatInputDiscoveryCommandsModel call2(Long l, Map<Long, GuildMember> map, DiscoverCommands discoverCommands, List<Application> list, List<? extends ApplicationCommand> list2) {
        WidgetChatInputDiscoveryCommandsModel.Companion companion = WidgetChatInputDiscoveryCommandsModel.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(l, "meId");
        long jLongValue = l.longValue();
        GuildMember guildMember = map.get(l);
        List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
        if (roles == null) {
            roles = Collections2.emptyList();
        }
        Intrinsics3.checkNotNullExpressionValue(list, "apps");
        Intrinsics3.checkNotNullExpressionValue(discoverCommands, "discoveryCommands");
        boolean z2 = this.$includeHeaders;
        int i = this.$placeholdersCount;
        Intrinsics3.checkNotNullExpressionValue(list2, "frecency");
        return companion.parseModelDiscoveryCommands(jLongValue, roles, list, discoverCommands, z2, i, list2);
    }
}
