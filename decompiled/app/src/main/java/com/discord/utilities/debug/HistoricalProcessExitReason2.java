package com.discord.utilities.debug;

import com.discord.utilities.debug.HistoricalProcessExitReason;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: HistoricalProcessExitReason.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/utilities/debug/HistoricalProcessExitReason$Reason;", "invoke", "()Lcom/discord/utilities/debug/HistoricalProcessExitReason$Reason;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.debug.HistoricalProcessExitReason$lastReason$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class HistoricalProcessExitReason2 extends Lambda implements Function0<HistoricalProcessExitReason.Reason> {
    public static final HistoricalProcessExitReason2 INSTANCE = new HistoricalProcessExitReason2();

    public HistoricalProcessExitReason2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ HistoricalProcessExitReason.Reason invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final HistoricalProcessExitReason.Reason invoke() {
        return HistoricalProcessExitReason.access$createLastReason(HistoricalProcessExitReason.INSTANCE);
    }
}
