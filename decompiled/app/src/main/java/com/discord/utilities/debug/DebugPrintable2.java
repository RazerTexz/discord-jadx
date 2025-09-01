package com.discord.utilities.debug;

import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: DebugPrintable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0013\u0012\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\r\u0010\u0010R\u001d\u0010\u0013\u001a\u00060\u0011j\u0002`\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/debug/DebugPrintBuilder;", "", "", "s", "", "append", "(Ljava/lang/String;)V", "appendLine", "", "(I)V", "(Ljava/lang/Object;)V", "key", "value", "appendKeyValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/discord/utilities/debug/DebugPrintable;", "(Ljava/lang/String;Lcom/discord/utilities/debug/DebugPrintable;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "Ljava/lang/StringBuilder;", "getSb", "()Ljava/lang/StringBuilder;", "indentation", "I", "<init>", "(Ljava/lang/StringBuilder;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.debug.DebugPrintBuilder, reason: use source file name */
/* loaded from: classes2.dex */
public final class DebugPrintable2 {
    private static final int maxDepth = 10;
    private int indentation;
    private final StringBuilder sb;

    public DebugPrintable2(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        this.sb = sb;
    }

    public final void append(String s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        this.sb.append(s2);
    }

    public final void appendKeyValue(String key, Object value) {
        String string;
        Intrinsics3.checkNotNullParameter(key, "key");
        int i = this.indentation;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                this.sb.append("  ");
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.sb.append(" - ");
        this.sb.append(key);
        this.sb.append(": ");
        StringBuilder sb = this.sb;
        if (value == null || (string = value.toString()) == null) {
            string = "{null}";
        }
        sb.append(string);
        this.sb.append("\n");
    }

    public final void appendLine(String s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        StringBuilder sb = this.sb;
        sb.append(s2);
        Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
        sb.append('\n');
        Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
    }

    public final StringBuilder getSb() {
        return this.sb;
    }

    public final void append(int s2) {
        this.sb.append(s2);
    }

    public final void append(Object s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        this.sb.append(s2);
    }

    public final void appendKeyValue(String key, DebugPrintable value) {
        Intrinsics3.checkNotNullParameter(key, "key");
        int i = this.indentation;
        if (i >= 10) {
            this.sb.append(" + Reached maxDepth 10");
            return;
        }
        int i2 = 0;
        if (i >= 0) {
            while (true) {
                this.sb.append("  ");
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.sb.append(" + ");
        this.sb.append(key);
        if (value == null) {
            this.sb.append(": {null}\n");
            return;
        }
        this.sb.append(":\n");
        this.indentation++;
        value.debugPrint(this);
        this.indentation--;
    }
}
