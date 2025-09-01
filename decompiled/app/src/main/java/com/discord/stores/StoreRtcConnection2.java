package com.discord.stores;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.voice.state.VoiceState;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: StoreRtcConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010#\u001a\u00020\u0007\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\n\u0010\u0016\u001a\u00060\u0007j\u0002`\b\u0012\u0018\u0010'\u001a\u0014\u0012\b\u0012\u00060\u0007j\u0002`\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001a\u00020\u00042\n\u0010\t\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00060\u0007j\u0002`\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R \u0010\u001c\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR \u0010\u001e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR \u0010 \u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0015R\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0017R \u0010%\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0015¨\u0006*"}, d2 = {"Lcom/discord/stores/VoicePropsTracker;", "", "Lcom/discord/api/voice/state/VoiceState;", "voiceState", "", "handleVoiceStateUpdate", "(Lcom/discord/api/voice/state/VoiceState;)V", "", "Lcom/discord/primitives/UserId;", "userId", "", "isSpeaking", "handleOnSpeaking", "(JZ)V", "", "", "properties", "getProps", "(Ljava/util/Map;)V", "", "allListenerUsers", "Ljava/util/Set;", "localUserId", "J", "", "maxListenerCount", "I", "currentVoiceStateUsers", "currentSpeakerUsers", "maxSpeakerCount", "allVoiceStateUsers", "maxVoiceStateCount", "currentPotentialListeners", "localUserSpeaking", "Z", "guildId", "channelId", "allSpeakerUsers", "", "voiceStates", "<init>", "(JJJLjava/util/Map;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.stores.VoicePropsTracker, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreRtcConnection2 {
    private final long channelId;
    private final long guildId;
    private final long localUserId;
    private boolean localUserSpeaking;
    private int maxListenerCount;
    private int maxSpeakerCount;
    private int maxVoiceStateCount;
    private final Set<Long> allVoiceStateUsers = new LinkedHashSet();
    private final Set<Long> currentVoiceStateUsers = new LinkedHashSet();
    private final Set<Long> allListenerUsers = new LinkedHashSet();
    private final Set<Long> currentPotentialListeners = new LinkedHashSet();
    private final Set<Long> allSpeakerUsers = new LinkedHashSet();
    private final Set<Long> currentSpeakerUsers = new LinkedHashSet();

    public StoreRtcConnection2(long j, long j2, long j3, Map<Long, VoiceState> map) {
        this.guildId = j;
        this.channelId = j2;
        this.localUserId = j3;
        if (map != null) {
            for (Map.Entry<Long, VoiceState> entry : map.entrySet()) {
                long jLongValue = entry.getKey().longValue();
                VoiceState value = entry.getValue();
                Long channelId = value.getChannelId();
                long j4 = this.channelId;
                if (channelId != null && channelId.longValue() == j4) {
                    this.currentVoiceStateUsers.add(Long.valueOf(jLongValue));
                    if (!value.getDeaf() && !value.getSelfDeaf()) {
                        this.currentPotentialListeners.add(Long.valueOf(jLongValue));
                    }
                }
            }
        }
    }

    public final void getProps(Map<String, Object> properties) {
        Intrinsics3.checkNotNullParameter(properties, "properties");
        properties.put("max_voice_state_count", Integer.valueOf(this.maxVoiceStateCount));
        properties.put("total_voice_state_count", Integer.valueOf(this.allVoiceStateUsers.size()));
        properties.put("max_listener_count", Integer.valueOf(this.maxListenerCount));
        properties.put("total_listener_count", Integer.valueOf(this.allListenerUsers.size()));
        properties.put("max_speaker_count", Integer.valueOf(this.maxSpeakerCount));
        properties.put("total_speaker_count", Integer.valueOf(this.allSpeakerUsers.size()));
    }

    public final void handleOnSpeaking(long userId, boolean isSpeaking) {
        if (isSpeaking) {
            this.allSpeakerUsers.add(Long.valueOf(userId));
            this.currentSpeakerUsers.add(Long.valueOf(userId));
            this.maxSpeakerCount = Math.max(this.maxSpeakerCount, this.currentSpeakerUsers.size());
        } else {
            this.currentSpeakerUsers.remove(Long.valueOf(userId));
        }
        if (userId != this.localUserId || this.localUserSpeaking == isSpeaking) {
            return;
        }
        this.localUserSpeaking = isSpeaking;
        if (isSpeaking) {
            this.allListenerUsers.addAll(this.currentPotentialListeners);
            this.maxListenerCount = Math.max(this.maxListenerCount, this.currentPotentialListeners.size());
        }
    }

    public final void handleVoiceStateUpdate(VoiceState voiceState) {
        Intrinsics3.checkNotNullParameter(voiceState, "voiceState");
        if (voiceState.getGuildId() == this.guildId) {
            if (AnimatableValueParser.X0(voiceState)) {
                this.currentVoiceStateUsers.remove(Long.valueOf(voiceState.getUserId()));
                this.currentPotentialListeners.remove(Long.valueOf(voiceState.getUserId()));
                this.currentSpeakerUsers.remove(Long.valueOf(voiceState.getUserId()));
                return;
            }
            Long channelId = voiceState.getChannelId();
            long j = this.channelId;
            if (channelId != null && channelId.longValue() == j) {
                this.currentVoiceStateUsers.add(Long.valueOf(voiceState.getUserId()));
                this.allVoiceStateUsers.add(Long.valueOf(voiceState.getUserId()));
                this.maxVoiceStateCount = Math.max(this.maxVoiceStateCount, this.currentVoiceStateUsers.size());
                if (voiceState.getDeaf() || voiceState.getSelfDeaf()) {
                    this.currentPotentialListeners.remove(Long.valueOf(voiceState.getUserId()));
                    return;
                }
                this.currentPotentialListeners.add(Long.valueOf(voiceState.getUserId()));
                if (this.localUserSpeaking) {
                    this.allListenerUsers.add(Long.valueOf(voiceState.getUserId()));
                    this.maxListenerCount = Math.max(this.maxListenerCount, this.currentPotentialListeners.size());
                }
            }
        }
    }
}
