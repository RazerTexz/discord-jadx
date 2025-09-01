package com.discord.utilities.collections;

import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;

/* compiled from: FixedSizeLineBuffer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/discord/utilities/collections/FixedSizeLineBuffer;", "", "", "getString", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "", "appendString", "(Ljava/lang/StringBuilder;)V", "line", "addLine", "(Ljava/lang/String;)V", "", "maxCharacterCount", "I", "outputLength", "Lkotlin/collections/ArrayDeque;", "output", "Lkotlin/collections/ArrayDeque;", "sync", "Ljava/lang/Object;", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class FixedSizeLineBuffer {
    private final int maxCharacterCount;
    private int outputLength;
    private final ArrayDeque<String> output = new ArrayDeque<>();
    private final Object sync = new Object();

    public FixedSizeLineBuffer(int i) {
        this.maxCharacterCount = i;
    }

    public final void addLine(String line) {
        String strRemoveFirstOrNull;
        Intrinsics3.checkNotNullParameter(line, "line");
        synchronized (this.sync) {
            this.output.add(line);
            this.outputLength = line.length() + 1 + this.outputLength;
            while (this.outputLength > this.maxCharacterCount && (strRemoveFirstOrNull = this.output.removeFirstOrNull()) != null) {
                this.outputLength -= strRemoveFirstOrNull.length() - 1;
            }
        }
    }

    public final void appendString(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        synchronized (this.sync) {
            Iterator<String> it = this.output.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
    }

    public final String getString() {
        String strJoinToString$default;
        synchronized (this.sync) {
            strJoinToString$default = _Collections.joinToString$default(this.output, "\n", null, null, 0, null, null, 62, null);
        }
        return strJoinToString$default;
    }
}
