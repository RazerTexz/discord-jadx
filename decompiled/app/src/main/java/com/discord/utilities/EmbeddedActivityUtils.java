package com.discord.utilities;

import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: EmbeddedActivityUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00002\u0016\u0010\u0005\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "voiceParticipants", "", "Lcom/discord/models/guild/UserGuildMember;", "getActivityParticipants", "(Lcom/discord/models/embeddedactivities/EmbeddedActivity;Ljava/util/Map;)Ljava/util/List;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.EmbeddedActivityUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmbeddedActivityUtils {
    public static final List<UserGuildMember> getActivityParticipants(EmbeddedActivity embeddedActivity, Map<Long, StoreVoiceParticipants.VoiceUser> map) {
        Intrinsics3.checkNotNullParameter(embeddedActivity, "$this$getActivityParticipants");
        Intrinsics3.checkNotNullParameter(map, "voiceParticipants");
        List<Long> userIds = embeddedActivity.getUserIds();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            StoreVoiceParticipants.VoiceUser voiceUser = map.get(Long.valueOf(((Number) it.next()).longValue()));
            UserGuildMember userGuildMember = null;
            User user = voiceUser != null ? voiceUser.getUser() : null;
            GuildMember guildMember = voiceUser != null ? voiceUser.getGuildMember() : null;
            if (user != null && guildMember != null) {
                userGuildMember = new UserGuildMember(user, guildMember);
            }
            if (userGuildMember != null) {
                arrayList.add(userGuildMember);
            }
        }
        return arrayList;
    }
}
