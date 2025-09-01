package com.discord.utilities.system;

import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: DeviceResourceUsageMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "invoke", "()V", "com/discord/utilities/system/DeviceResourceUsageMonitor$start$oldThread$1$thread$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.system.DeviceResourceUsageMonitor$start$$inlined$synchronized$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ DeviceResourceUsageMonitor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceResourceUsageMonitor2(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
        super(0);
        this.this$0 = deviceResourceUsageMonitor;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        try {
            DeviceResourceUsageMonitor.access$monitor(this.this$0);
        } catch (InterruptedException unused) {
        }
    }
}
