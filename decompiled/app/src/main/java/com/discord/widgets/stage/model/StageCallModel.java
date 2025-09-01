package com.discord.widgets.stage.model;

import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StageCallModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001CB~\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010$\u001a\u00020\u0010\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010&\u001a\u00020\u0019\u0012\u0006\u0010'\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0019\u0010\u0005\u001a\u00020\u0002HÆ\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006HÆ\u0003¢\u0006\u0004\b\r\u0010\tJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J \u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00022\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u00062\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\b\b\u0002\u0010\"\u001a\u00020\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010$\u001a\u00020\u00102\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0010HÆ\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010,\u001a\u00020+HÖ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b.\u0010\u0004J\u001a\u00100\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101R\u0019\u0010&\u001a\u00020\u00198\u0006@\u0006¢\u0006\f\n\u0004\b&\u00102\u001a\u0004\b&\u0010\u001bR\u001b\u0010%\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\b%\u00103\u001a\u0004\b4\u0010\u0018R\u0019\u0010'\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b'\u00105\u001a\u0004\b6\u0010\u0004R\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u00107\u001a\u0004\b8\u0010\tR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b9\u0010\u0004R\u0019\u0010$\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b:\u0010\u0004R\u001f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u00107\u001a\u0004\b;\u0010\tR\u0019\u0010\"\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b<\u0010\u0004R\u001b\u0010#\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010=\u001a\u0004\b>\u0010\u0014R\u001f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u00107\u001a\u0004\b?\u0010\tR\u001f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00068\u0006@\u0006¢\u0006\f\n\u0004\b \u00107\u001a\u0004\b@\u0010\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"Lcom/discord/widgets/stage/model/StageCallModel;", "", "Lcom/discord/widgets/stage/StageRoles;", "component1-1LxfuJo", "()I", "component1", "", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$SpeakerItem;", "component2", "()Ljava/util/List;", "Lcom/discord/widgets/stage/model/StageMediaParticipant;", "component3", "Lcom/discord/widgets/voice/fullscreen/stage/StageCallItem$AudienceItem;", "component4", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component5", "", "component6", "Lcom/discord/api/stageinstance/StageInstance;", "component7", "()Lcom/discord/api/stageinstance/StageInstance;", "component8", "Lcom/discord/models/guild/Guild;", "component9", "()Lcom/discord/models/guild/Guild;", "", "component10", "()Z", "component11", "myStageRoles", "speakerItems", "mediaParticipants", "audience", "speakingVoiceUsers", "requestingToSpeakCount", "stageInstance", "numBlockedUsers", "guild", "isLurking", "numSpeakers", "copy-YvLQhEs", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILcom/discord/api/stageinstance/StageInstance;ILcom/discord/models/guild/Guild;ZI)Lcom/discord/widgets/stage/model/StageCallModel;", "copy", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Lcom/discord/models/guild/Guild;", "getGuild", "I", "getNumSpeakers", "Ljava/util/List;", "getSpeakerItems", "getMyStageRoles-1LxfuJo", "getNumBlockedUsers", "getMediaParticipants", "getRequestingToSpeakCount", "Lcom/discord/api/stageinstance/StageInstance;", "getStageInstance", "getSpeakingVoiceUsers", "getAudience", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ILcom/discord/api/stageinstance/StageInstance;ILcom/discord/models/guild/Guild;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* data */ class StageCallModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<StageCallItem.AudienceItem> audience;
    private final Guild guild;
    private final boolean isLurking;
    private final List<StageCallModel5> mediaParticipants;
    private final int myStageRoles;
    private final int numBlockedUsers;
    private final int numSpeakers;
    private final int requestingToSpeakCount;
    private final List<StageCallItem.SpeakerItem> speakerItems;
    private final List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers;
    private final StageInstance stageInstance;

    /* compiled from: StageCallModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u0097\u0001\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u00070\u00042\u0016\u0010\u000b\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\t\u0012\u0004\u0012\u00020\n0\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0016\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0004\u0012\u00020\u000e0\u00042\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001d2\n\u0010\u001c\u001a\u00060\u0005j\u0002`\u001b¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/discord/widgets/stage/model/StageCallModel$Companion;", "", "Lcom/discord/api/channel/Channel;", "channel", "", "", "Lcom/discord/primitives/UserId;", "Lcom/discord/models/member/GuildMember;", "guildMembers", "Lcom/discord/primitives/RoleId;", "Lcom/discord/api/role/GuildRole;", "guildRoles", "Lcom/discord/models/guild/Guild;", "guild", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "participants", "", "blockedUsers", "Lcom/discord/api/stageinstance/StageInstance;", "stageInstance", "", "isLurking", "Lcom/discord/stores/StoreStageChannels;", "stagesStore", "Lcom/discord/widgets/stage/model/StageCallModel;", "create", "(Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/util/Map;Lcom/discord/models/guild/Guild;Ljava/util/Map;Ljava/util/Set;Lcom/discord/api/stageinstance/StageInstance;ZLcom/discord/stores/StoreStageChannels;)Lcom/discord/widgets/stage/model/StageCallModel;", "Lcom/discord/primitives/ChannelId;", "channelId", "Lrx/Observable;", "observeStageCallModel", "(J)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        private final StageCallModel create(Channel channel, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Guild guild, Map<Long, StoreVoiceParticipants.VoiceUser> participants, Set<Long> blockedUsers, StageInstance stageInstance, boolean isLurking, StoreStageChannels stagesStore) {
            int i;
            int i2;
            VoiceState voiceState;
            int i3;
            boolean z2;
            String string;
            Collection<StoreVoiceParticipants.VoiceUser> collectionValues = participants.values();
            ArrayList<StoreVoiceParticipants.VoiceUser> arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (((StoreVoiceParticipants.VoiceUser) obj).isConnected()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(Long.valueOf(((StoreVoiceParticipants.VoiceUser) obj2).getUser().getId()), obj2);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Object key = entry.getKey();
                StageRoles stageRolesM17getUserRolesuOBN1zc = stagesStore.m17getUserRolesuOBN1zc(((Number) entry.getKey()).longValue(), channel.getId());
                linkedHashMap2.put(key, StageRoles.m25boximpl(stageRolesM17getUserRolesuOBN1zc != null ? stageRolesM17getUserRolesuOBN1zc.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo()));
            }
            Collection collectionValues2 = linkedHashMap2.values();
            if ((collectionValues2 instanceof Collection) && collectionValues2.isEmpty()) {
                i = 0;
            } else {
                Iterator it = collectionValues2.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    if (StageRoles.m33isSpeakerimpl(((StageRoles) it.next()).m35unboximpl()) && (i4 = i4 + 1) < 0) {
                        Collections2.throwCountOverflow();
                    }
                }
                i = i4;
            }
            if (arrayList.isEmpty()) {
                i2 = 0;
            } else {
                int i5 = 0;
                for (StoreVoiceParticipants.VoiceUser voiceUser : arrayList) {
                    StageRoles stageRolesM17getUserRolesuOBN1zc2 = stagesStore.m17getUserRolesuOBN1zc(voiceUser.getUser().getId(), channel.getId());
                    if ((StageRoles.m33isSpeakerimpl(stageRolesM17getUserRolesuOBN1zc2 != null ? stageRolesM17getUserRolesuOBN1zc2.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo()) && ((voiceState = voiceUser.getVoiceState()) == null || !voiceState.getSelfVideo())) && (i5 = i5 + 1) < 0) {
                        Collections2.throwCountOverflow();
                    }
                }
                i2 = i5;
            }
            int iCoerceAtMost = _Ranges.coerceAtMost(i2, 3);
            int i6 = 0;
            int i7 = 0;
            for (StoreVoiceParticipants.VoiceUser voiceUser2 : arrayList) {
                VoiceState voiceState2 = voiceUser2.getVoiceState();
                if (voiceState2 != null) {
                    Intrinsics3.checkNotNullParameter(voiceState2, "$this$hasUnackedRequestToSpeak");
                    if (AnimatableValueParser.y0(voiceState2) == StageRequestToSpeakState.REQUESTED_TO_SPEAK) {
                        i6++;
                    }
                }
                int i8 = i6;
                boolean zContains = blockedUsers.contains(Long.valueOf(voiceUser2.getUser().getId()));
                if (zContains) {
                    i7++;
                }
                int i9 = i7;
                StageRoles stageRoles = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                if (stageRoles == null || !StageRoles.m33isSpeakerimpl(stageRoles.m35unboximpl())) {
                    arrayList4.add(new StageCallItem.AudienceItem(voiceUser2, channel, RoleUtils.getHighestHoistedRole(guildRoles, guildMembers.get(Long.valueOf(voiceUser2.getUser().getId()))), zContains));
                } else {
                    if (voiceUser2.getStreamContext() != null) {
                        StageCallItem.MediaType mediaType = StageCallItem.MediaType.STREAM;
                        StringBuilder sbU = outline.U("STREAM-");
                        sbU.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageCallModel5(sbU.toString(), voiceUser2, channel, false, zContains, mediaType));
                    }
                    VoiceState voiceState3 = voiceUser2.getVoiceState();
                    if (voiceState3 != null && voiceState3.getSelfVideo()) {
                        StageRoles stageRoles2 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        boolean z3 = stageRoles2 != null && StageRoles.m32isModeratorimpl(stageRoles2.m35unboximpl());
                        StageCallItem.MediaType mediaType2 = StageCallItem.MediaType.USER;
                        StringBuilder sbU2 = outline.U("USER-");
                        sbU2.append(voiceUser2.getUser().getId());
                        arrayList2.add(new StageCallModel5(sbU2.toString(), voiceUser2, channel, z3, zContains, mediaType2));
                    } else {
                        StageRoles stageRoles3 = (StageRoles) linkedHashMap2.get(Long.valueOf(voiceUser2.getUser().getId()));
                        if (stageRoles3 == null || !StageRoles.m32isModeratorimpl(stageRoles3.m35unboximpl())) {
                            i3 = 3;
                            z2 = false;
                        } else {
                            i3 = 3;
                            z2 = true;
                        }
                        if (i > i3) {
                            string = String.valueOf(arrayList3.size() % i3);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append(arrayList3.size() % i3);
                            sb.append('-');
                            sb.append(i);
                            string = sb.toString();
                        }
                        arrayList3.add(new StageCallItem.SpeakerItem(voiceUser2, channel, z2, string, iCoerceAtMost, zContains));
                    }
                }
                i6 = i8;
                i7 = i9;
            }
            StageRoles stageRolesM15getMyRolesvisDeB4 = stagesStore.m15getMyRolesvisDeB4(channel.getId());
            return new StageCallModel(stageRolesM15getMyRolesvisDeB4 != null ? stageRolesM15getMyRolesvisDeB4.m35unboximpl() : StageRoles.INSTANCE.m37getAUDIENCE1LxfuJo(), arrayList3, arrayList2, _Collections.sorted(arrayList4), _Sequences2.toList(_Sequences2.map(_Sequences2.filter(_Collections.asSequence(arrayList3), StageCallModel2.INSTANCE), StageCallModel3.INSTANCE)), i6, stageInstance, i7, guild, isLurking, i, null);
        }

        public static /* synthetic */ StageCallModel create$default(Companion companion, Channel channel, Map map, Map map2, Guild guild, Map map3, Set set, StageInstance stageInstance, boolean z2, StoreStageChannels storeStageChannels, int i, Object obj) {
            return companion.create(channel, map, map2, guild, map3, set, stageInstance, z2, (i & 256) != 0 ? StoreStream.INSTANCE.getStageChannels() : storeStageChannels);
        }

        public final Observable<StageCallModel> observeStageCallModel(long channelId) {
            Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new StageCallModel4(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private StageCallModel(int i, List<StageCallItem.SpeakerItem> list, List<StageCallModel5> list2, List<StageCallItem.AudienceItem> list3, List<StoreVoiceParticipants.VoiceUser> list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4) {
        this.myStageRoles = i;
        this.speakerItems = list;
        this.mediaParticipants = list2;
        this.audience = list3;
        this.speakingVoiceUsers = list4;
        this.requestingToSpeakCount = i2;
        this.stageInstance = stageInstance;
        this.numBlockedUsers = i3;
        this.guild = guild;
        this.isLurking = z2;
        this.numSpeakers = i4;
    }

    /* renamed from: copy-YvLQhEs$default, reason: not valid java name */
    public static /* synthetic */ StageCallModel m39copyYvLQhEs$default(StageCallModel stageCallModel, int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, int i5, Object obj) {
        return stageCallModel.m41copyYvLQhEs((i5 & 1) != 0 ? stageCallModel.myStageRoles : i, (i5 & 2) != 0 ? stageCallModel.speakerItems : list, (i5 & 4) != 0 ? stageCallModel.mediaParticipants : list2, (i5 & 8) != 0 ? stageCallModel.audience : list3, (i5 & 16) != 0 ? stageCallModel.speakingVoiceUsers : list4, (i5 & 32) != 0 ? stageCallModel.requestingToSpeakCount : i2, (i5 & 64) != 0 ? stageCallModel.stageInstance : stageInstance, (i5 & 128) != 0 ? stageCallModel.numBlockedUsers : i3, (i5 & 256) != 0 ? stageCallModel.guild : guild, (i5 & 512) != 0 ? stageCallModel.isLurking : z2, (i5 & 1024) != 0 ? stageCallModel.numSpeakers : i4);
    }

    /* renamed from: component1-1LxfuJo, reason: not valid java name and from getter */
    public final int getMyStageRoles() {
        return this.myStageRoles;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsLurking() {
        return this.isLurking;
    }

    /* renamed from: component11, reason: from getter */
    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final List<StageCallItem.SpeakerItem> component2() {
        return this.speakerItems;
    }

    public final List<StageCallModel5> component3() {
        return this.mediaParticipants;
    }

    public final List<StageCallItem.AudienceItem> component4() {
        return this.audience;
    }

    public final List<StoreVoiceParticipants.VoiceUser> component5() {
        return this.speakingVoiceUsers;
    }

    /* renamed from: component6, reason: from getter */
    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    /* renamed from: component7, reason: from getter */
    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* renamed from: component8, reason: from getter */
    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    /* renamed from: component9, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: copy-YvLQhEs, reason: not valid java name */
    public final StageCallModel m41copyYvLQhEs(int myStageRoles, List<StageCallItem.SpeakerItem> speakerItems, List<StageCallModel5> mediaParticipants, List<StageCallItem.AudienceItem> audience, List<StoreVoiceParticipants.VoiceUser> speakingVoiceUsers, int requestingToSpeakCount, StageInstance stageInstance, int numBlockedUsers, Guild guild, boolean isLurking, int numSpeakers) {
        Intrinsics3.checkNotNullParameter(speakerItems, "speakerItems");
        Intrinsics3.checkNotNullParameter(mediaParticipants, "mediaParticipants");
        Intrinsics3.checkNotNullParameter(audience, "audience");
        Intrinsics3.checkNotNullParameter(speakingVoiceUsers, "speakingVoiceUsers");
        return new StageCallModel(myStageRoles, speakerItems, mediaParticipants, audience, speakingVoiceUsers, requestingToSpeakCount, stageInstance, numBlockedUsers, guild, isLurking, numSpeakers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallModel)) {
            return false;
        }
        StageCallModel stageCallModel = (StageCallModel) other;
        return this.myStageRoles == stageCallModel.myStageRoles && Intrinsics3.areEqual(this.speakerItems, stageCallModel.speakerItems) && Intrinsics3.areEqual(this.mediaParticipants, stageCallModel.mediaParticipants) && Intrinsics3.areEqual(this.audience, stageCallModel.audience) && Intrinsics3.areEqual(this.speakingVoiceUsers, stageCallModel.speakingVoiceUsers) && this.requestingToSpeakCount == stageCallModel.requestingToSpeakCount && Intrinsics3.areEqual(this.stageInstance, stageCallModel.stageInstance) && this.numBlockedUsers == stageCallModel.numBlockedUsers && Intrinsics3.areEqual(this.guild, stageCallModel.guild) && this.isLurking == stageCallModel.isLurking && this.numSpeakers == stageCallModel.numSpeakers;
    }

    public final List<StageCallItem.AudienceItem> getAudience() {
        return this.audience;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<StageCallModel5> getMediaParticipants() {
        return this.mediaParticipants;
    }

    /* renamed from: getMyStageRoles-1LxfuJo, reason: not valid java name */
    public final int m42getMyStageRoles1LxfuJo() {
        return this.myStageRoles;
    }

    public final int getNumBlockedUsers() {
        return this.numBlockedUsers;
    }

    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final int getRequestingToSpeakCount() {
        return this.requestingToSpeakCount;
    }

    public final List<StageCallItem.SpeakerItem> getSpeakerItems() {
        return this.speakerItems;
    }

    public final List<StoreVoiceParticipants.VoiceUser> getSpeakingVoiceUsers() {
        return this.speakingVoiceUsers;
    }

    public final StageInstance getStageInstance() {
        return this.stageInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.myStageRoles * 31;
        List<StageCallItem.SpeakerItem> list = this.speakerItems;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<StageCallModel5> list2 = this.mediaParticipants;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<StageCallItem.AudienceItem> list3 = this.audience;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        List<StoreVoiceParticipants.VoiceUser> list4 = this.speakingVoiceUsers;
        int iHashCode4 = (((iHashCode3 + (list4 != null ? list4.hashCode() : 0)) * 31) + this.requestingToSpeakCount) * 31;
        StageInstance stageInstance = this.stageInstance;
        int iHashCode5 = (((iHashCode4 + (stageInstance != null ? stageInstance.hashCode() : 0)) * 31) + this.numBlockedUsers) * 31;
        Guild guild = this.guild;
        int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
        boolean z2 = this.isLurking;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return ((iHashCode6 + i2) * 31) + this.numSpeakers;
    }

    public final boolean isLurking() {
        return this.isLurking;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StageCallModel(myStageRoles=");
        sbU.append(StageRoles.m34toStringimpl(this.myStageRoles));
        sbU.append(", speakerItems=");
        sbU.append(this.speakerItems);
        sbU.append(", mediaParticipants=");
        sbU.append(this.mediaParticipants);
        sbU.append(", audience=");
        sbU.append(this.audience);
        sbU.append(", speakingVoiceUsers=");
        sbU.append(this.speakingVoiceUsers);
        sbU.append(", requestingToSpeakCount=");
        sbU.append(this.requestingToSpeakCount);
        sbU.append(", stageInstance=");
        sbU.append(this.stageInstance);
        sbU.append(", numBlockedUsers=");
        sbU.append(this.numBlockedUsers);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", isLurking=");
        sbU.append(this.isLurking);
        sbU.append(", numSpeakers=");
        return outline.B(sbU, this.numSpeakers, ")");
    }

    public /* synthetic */ StageCallModel(int i, List list, List list2, List list3, List list4, int i2, StageInstance stageInstance, int i3, Guild guild, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, list2, list3, list4, i2, stageInstance, i3, guild, z2, i4);
    }
}
