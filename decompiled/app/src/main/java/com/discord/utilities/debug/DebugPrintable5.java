package com.discord.utilities.debug;

import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* compiled from: DebugPrintable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R'\u0010\n\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/discord/utilities/debug/DebugPrintableRef;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Ljava/lang/ref/WeakReference;", "Lcom/discord/utilities/debug/DebugPrintable;", "kotlin.jvm.PlatformType", "reference", "Ljava/lang/ref/WeakReference;", "getReference", "()Ljava/lang/ref/WeakReference;", "debugPrintable", "<init>", "(Ljava/lang/String;Lcom/discord/utilities/debug/DebugPrintable;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.debug.DebugPrintableRef, reason: use source file name */
/* loaded from: classes2.dex */
public final class DebugPrintable5 {
    private final WeakReference<DebugPrintable> reference;
    private final String tag;

    public DebugPrintable5(String str, DebugPrintable debugPrintable) {
        Intrinsics3.checkNotNullParameter(debugPrintable, "debugPrintable");
        this.tag = str;
        this.reference = new WeakReference<>(debugPrintable);
    }

    public final WeakReference<DebugPrintable> getReference() {
        return this.reference;
    }

    public final String getTag() {
        return this.tag;
    }
}
