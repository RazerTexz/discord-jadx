package com.discord.widgets.stage.model;

import kotlin.Metadata;

/* compiled from: StageAnalyticsRequestToSpeakState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/discord/widgets/stage/model/StageAnalyticsRequestToSpeakState;", "", "", "integerValue", "I", "getIntegerValue", "()I", "<init>", "(Ljava/lang/String;II)V", "REQUEST_TO_SPEAK_EVERYONE", "REQUEST_TO_SPEAK_NO_ONE", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public enum StageAnalyticsRequestToSpeakState {
    REQUEST_TO_SPEAK_EVERYONE(1),
    REQUEST_TO_SPEAK_NO_ONE(2);

    private final int integerValue;

    StageAnalyticsRequestToSpeakState(int i) {
        this.integerValue = i;
    }

    public final int getIntegerValue() {
        return this.integerValue;
    }
}
