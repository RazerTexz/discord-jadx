package com.discord.widgets.servers;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsRolesAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "", "it", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$roleDropListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter7 extends Lambda implements Function1<Map<String, ? extends Integer>, Unit> {
    public static final WidgetServerSettingsRolesAdapter7 INSTANCE = new WidgetServerSettingsRolesAdapter7();

    public WidgetServerSettingsRolesAdapter7() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Integer> map) {
        invoke2((Map<String, Integer>) map);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Map<String, Integer> map) {
        Intrinsics3.checkNotNullParameter(map, "it");
    }
}
