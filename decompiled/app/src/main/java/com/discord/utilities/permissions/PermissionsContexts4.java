package com.discord.utilities.permissions;

import com.discord.models.message.Message;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: PermissionsContexts.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/discord/models/message/Message;", "", "isDeleteable", "(Lcom/discord/models/message/Message;)Z", "", "", "DELETEABLE_MESSAGE_TYPES", "Ljava/util/Set;", "getDELETEABLE_MESSAGE_TYPES", "()Ljava/util/Set;", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.permissions.PermissionsContextsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class PermissionsContexts4 {
    private static final Set<Integer> DELETEABLE_MESSAGE_TYPES = Sets5.setOf((Object[]) new Integer[]{0, 6, 7, 8, 9, 10, 11, 12, 18, 19, 20, 22, 23, 25});

    public static final Set<Integer> getDELETEABLE_MESSAGE_TYPES() {
        return DELETEABLE_MESSAGE_TYPES;
    }

    public static final boolean isDeleteable(Message message) {
        Intrinsics3.checkNotNullParameter(message, "$this$isDeleteable");
        return _Collections.contains(DELETEABLE_MESSAGE_TYPES, message.getType()) || message.isLocal();
    }
}
