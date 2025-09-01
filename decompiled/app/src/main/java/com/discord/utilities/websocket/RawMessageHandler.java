package com.discord.utilities.websocket;

import kotlin.Metadata;

/* compiled from: RawMessageHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/websocket/RawMessageHandler;", "", "", "rawMessage", "", "onRawMessage", "(Ljava/lang/String;)V", "", "throwable", "onRawMessageInflateFailed", "(Ljava/lang/Throwable;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface RawMessageHandler {
    void onRawMessage(String rawMessage);

    void onRawMessageInflateFailed(Throwable throwable);
}
