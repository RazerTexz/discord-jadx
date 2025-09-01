package com.discord.api.voice.state;

import kotlin.Metadata;

/* compiled from: StageRequestToSpeakState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/discord/api/voice/state/StageRequestToSpeakState;", "", "", "canBeInvitedToSpeak", "Z", "getCanBeInvitedToSpeak", "()Z", "isRequestingToSpeak", "<init>", "(Ljava/lang/String;IZZ)V", "NONE", "REQUESTED_TO_SPEAK", "REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK", "ON_STAGE", "discord_api"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum StageRequestToSpeakState {
    NONE(false, true),
    REQUESTED_TO_SPEAK(true, true),
    REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK(true, false),
    ON_STAGE(false, false);

    private final boolean canBeInvitedToSpeak;
    private final boolean isRequestingToSpeak;

    StageRequestToSpeakState(boolean z2, boolean z3) {
        this.isRequestingToSpeak = z2;
        this.canBeInvitedToSpeak = z3;
    }

    public final boolean getCanBeInvitedToSpeak() {
        return this.canBeInvitedToSpeak;
    }

    /* renamed from: isRequestingToSpeak, reason: from getter */
    public final boolean getIsRequestingToSpeak() {
        return this.isRequestingToSpeak;
    }
}
