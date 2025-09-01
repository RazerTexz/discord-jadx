package com.discord.widgets.voice.fullscreen;

import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: ParticipantsListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "kotlin.jvm.PlatformType", "user1", "user2", "", "compare", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.voice.fullscreen.ParticipantsListItemGenerator$Companion$createUserItemsComparator$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ParticipantsListItemGenerator2<T> implements Comparator<StoreVoiceParticipants.VoiceUser> {
    public final /* synthetic */ String $mySpectatingStreamKey;

    public ParticipantsListItemGenerator2(String str) {
        this.$mySpectatingStreamKey = str;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        return compare2(voiceUser, voiceUser2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(StoreVoiceParticipants.VoiceUser voiceUser, StoreVoiceParticipants.VoiceUser voiceUser2) {
        boolean z2 = false;
        boolean z3 = this.$mySpectatingStreamKey != null;
        ModelApplicationStream applicationStream = voiceUser.getApplicationStream();
        String encodedStreamKey = applicationStream != null ? applicationStream.getEncodedStreamKey() : null;
        ModelApplicationStream applicationStream2 = voiceUser2.getApplicationStream();
        String encodedStreamKey2 = applicationStream2 != null ? applicationStream2.getEncodedStreamKey() : null;
        boolean z4 = encodedStreamKey != null;
        boolean z5 = encodedStreamKey2 != null;
        VoiceState voiceState = voiceUser.getVoiceState();
        boolean z6 = voiceState != null && voiceState.getSelfVideo();
        VoiceState voiceState2 = voiceUser2.getVoiceState();
        boolean z7 = voiceState2 != null && voiceState2.getSelfVideo();
        boolean z8 = z3 && Intrinsics3.areEqual(encodedStreamKey, this.$mySpectatingStreamKey);
        if (z3 && Intrinsics3.areEqual(encodedStreamKey2, this.$mySpectatingStreamKey)) {
            z2 = true;
        }
        if (!z8) {
            if (z2) {
                return 1;
            }
            if (!voiceUser.isMe()) {
                if (voiceUser2.isMe()) {
                    return 1;
                }
                if (!z3 || !Intrinsics3.areEqual(voiceUser.getWatchingStream(), this.$mySpectatingStreamKey) || !(!Intrinsics3.areEqual(voiceUser2.getWatchingStream(), this.$mySpectatingStreamKey))) {
                    if (z3 && Intrinsics3.areEqual(voiceUser2.getWatchingStream(), this.$mySpectatingStreamKey) && (!Intrinsics3.areEqual(voiceUser.getWatchingStream(), this.$mySpectatingStreamKey))) {
                        return 1;
                    }
                    if (!z4 || z5) {
                        if (!z4 && z5) {
                            return 1;
                        }
                        if (!z6 || z7) {
                            if (z6 || !z7) {
                                return UserUtils.INSTANCE.compareUserNames(voiceUser.getUser(), voiceUser2.getUser(), voiceUser.getNickname(), voiceUser2.getNickname());
                            }
                            return 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
