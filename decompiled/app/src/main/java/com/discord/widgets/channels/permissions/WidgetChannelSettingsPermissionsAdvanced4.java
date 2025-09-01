package com.discord.widgets.channels.permissions;

import d0.z.d.Intrinsics3;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced4 implements Comparator {
    private final /* synthetic */ Function2 function;

    public WidgetChannelSettingsPermissionsAdvanced4(Function2 function2) {
        this.function = function2;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Object objInvoke = this.function.invoke(obj, obj2);
        Intrinsics3.checkNotNullExpressionValue(objInvoke, "invoke(...)");
        return ((Number) objInvoke).intValue();
    }
}
