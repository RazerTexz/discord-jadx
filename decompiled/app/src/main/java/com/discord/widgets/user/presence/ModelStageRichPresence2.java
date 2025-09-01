package com.discord.widgets.user.presence;

import androidx.core.app.NotificationCompat;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.models.presence.Presence;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.ActivityUtils2;
import d0.f0._Sequences2;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ModelStageRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\b \u0005*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u000726\u0010\u0006\u001a2\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004 \u0005*\u0018\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/presence/Presence;", "Lcom/discord/stores/AppPresence;", "kotlin.jvm.PlatformType", "userPresences", "", "Lcom/discord/widgets/user/presence/ModelStageRichPresence;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/Map;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelStageRichPresence2<T, R> implements Func1<Map<Long, ? extends Presence>, List<? extends ModelStageRichPresence>> {
    public static final ModelStageRichPresence2 INSTANCE = new ModelStageRichPresence2();

    /* compiled from: ModelStageRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/discord/primitives/UserId;", "userId", "Lcom/discord/widgets/user/presence/ModelStageRichPresence;", "invoke", "(J)Lcom/discord/widgets/user/presence/ModelStageRichPresence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.presence.ModelStageRichPresence$Companion$observeStageRichPresence$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, ModelStageRichPresence> {
        public final /* synthetic */ Map $userPresences;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$userPresences = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ModelStageRichPresence invoke(Long l) {
            return invoke(l.longValue());
        }

        public final ModelStageRichPresence invoke(long j) {
            List<Activity> activities;
            T next;
            ActivityUtils2 stageChannelRichPresencePartyData;
            String smallText;
            Presence presence = (Presence) this.$userPresences.get(Long.valueOf(j));
            if (presence != null && (activities = presence.getActivities()) != null) {
                Iterator<T> it = activities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = (T) null;
                        break;
                    }
                    next = it.next();
                    if (ActivityUtils.isStageChannelActivity((Activity) next)) {
                        break;
                    }
                }
                Activity activity = next;
                if (activity != null && (stageChannelRichPresencePartyData = ActivityUtils.getStageChannelRichPresencePartyData(activity)) != null) {
                    long channelId = stageChannelRichPresencePartyData.getChannelId();
                    long stageInstanceId = stageChannelRichPresencePartyData.getStageInstanceId();
                    boolean userIsSpeaker = stageChannelRichPresencePartyData.getUserIsSpeaker();
                    long guildId = stageChannelRichPresencePartyData.getGuildId();
                    boolean guildIsPartnered = stageChannelRichPresencePartyData.getGuildIsPartnered();
                    boolean guildIsVerified = stageChannelRichPresencePartyData.getGuildIsVerified();
                    ActivityAssets assets = activity.getAssets();
                    String smallImage = assets != null ? assets.getSmallImage() : null;
                    ActivityAssets assets2 = activity.getAssets();
                    if (assets2 == null || (smallText = assets2.getSmallText()) == null) {
                        smallText = "";
                    }
                    return new ModelStageRichPresence(channelId, stageInstanceId, userIsSpeaker, guildId, guildIsPartnered, guildIsVerified, smallText, smallImage, activity.getName(), SetsJVM.setOf(Long.valueOf(j)), stageChannelRichPresencePartyData.getUserIsSpeaker() ? SetsJVM.setOf(Long.valueOf(j)) : Sets5.emptySet(), stageChannelRichPresencePartyData.getSpeakerCount(), stageChannelRichPresencePartyData.getAudienceSize());
                }
            }
            return null;
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ List<? extends ModelStageRichPresence> call(Map<Long, ? extends Presence> map) {
        return call2((Map<Long, Presence>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final List<ModelStageRichPresence> call2(Map<Long, Presence> map) {
        return _Sequences2.toList(_Sequences2.mapNotNull(_Collections.asSequence(map.keySet()), new AnonymousClass1(map)));
    }
}
