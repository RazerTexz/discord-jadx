package com.discord.models.experiments.domain;

import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import j0.l.e.UtilityFunctions;
import kotlin.Metadata;

/* compiled from: ExperimentHash.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/discord/models/experiments/domain/ExperimentHash;", "", "", ModelAuditLogEntry.CHANGE_KEY_NAME, "", "from", "(Ljava/lang/CharSequence;)J", "<init>", "()V", "app_models_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ExperimentHash {
    public static final ExperimentHash INSTANCE = new ExperimentHash();

    private ExperimentHash() {
    }

    public final long from(CharSequence name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iA = UtilityFunctions.a(name, 0, name.length(), 0);
        return iA < 0 ? iA + Permission.REQUEST_TO_SPEAK : iA;
    }
}
