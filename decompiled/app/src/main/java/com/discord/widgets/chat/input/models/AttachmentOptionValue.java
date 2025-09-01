package com.discord.widgets.chat.input.models;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: CommandOptionValue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/widgets/chat/input/models/AttachmentOptionValue;", "Lcom/discord/widgets/chat/input/models/CommandOptionValue;", "", "filename", "Ljava/lang/String;", "getFilename", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class AttachmentOptionValue extends CommandOptionValue {
    private final String filename;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttachmentOptionValue(String str) {
        super(str, null);
        Intrinsics3.checkNotNullParameter(str, "filename");
        this.filename = str;
    }

    public final String getFilename() {
        return this.filename;
    }
}
