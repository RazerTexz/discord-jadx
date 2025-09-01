package com.discord.utilities.auditlogs;

import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AuditLogUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.auditlogs.AuditLogUtils$ALL_ACTION_TYPES$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AuditLogUtils2 extends Lambda implements Function0<List<? extends Integer>> {
    public static final AuditLogUtils2 INSTANCE = new AuditLogUtils2();

    public AuditLogUtils2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Integer> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Integer> invoke2() {
        return Collections2.listOf((Object[]) new Integer[]{0, 1, 10, 11, 12, 13, 14, 15, 20, 21, 22, 23, 24, 25, 26, 27, 28, 110, 111, 112, 30, 31, 32, 40, 41, 42, 50, 51, 52, 60, 61, 62, 72, 73, 74, 75, 80, 81, 82, 83, 84, 85, 90, 91, 92, 100, 101, 102});
    }
}
