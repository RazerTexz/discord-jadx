package com.discord.gateway.io;

import com.discord.gateway.opcodes.Opcode;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Outgoing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nB\u001d\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/discord/gateway/io/Outgoing;", "", "d", "Ljava/lang/Object;", "", "op", "I", "getOp", "()I", "<init>", "(ILjava/lang/Object;)V", "Lcom/discord/gateway/opcodes/Opcode;", "opcode", "(Lcom/discord/gateway/opcodes/Opcode;Ljava/lang/Object;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Outgoing {
    private final Object d;
    private final int op;

    public Outgoing(int i, Object obj) {
        this.op = i;
        this.d = obj;
    }

    public final int getOp() {
        return this.op;
    }

    public /* synthetic */ Outgoing(int i, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Outgoing(Opcode opcode, Object obj) {
        this(opcode.getApiInt(), obj);
        Intrinsics3.checkNotNullParameter(opcode, "opcode");
    }

    public /* synthetic */ Outgoing(Opcode opcode, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(opcode, (i & 2) != 0 ? null : obj);
    }
}
