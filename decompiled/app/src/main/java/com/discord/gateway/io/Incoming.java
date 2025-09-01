package com.discord.gateway.io;

import com.discord.gateway.opcodes.Opcode;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: Incoming.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B-\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/discord/gateway/io/Incoming;", "", "", "seq", "Ljava/lang/Integer;", "getSeq", "()Ljava/lang/Integer;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "Lcom/discord/gateway/opcodes/Opcode;", "opcode", "Lcom/discord/gateway/opcodes/Opcode;", "getOpcode", "()Lcom/discord/gateway/opcodes/Opcode;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/discord/gateway/opcodes/Opcode;Ljava/lang/Object;)V", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Incoming {
    private final Object data;
    private final Opcode opcode;
    private final Integer seq;
    private final String type;

    public Incoming(String str, Integer num, Opcode opcode, Object obj) {
        Intrinsics3.checkNotNullParameter(opcode, "opcode");
        this.type = str;
        this.seq = num;
        this.opcode = opcode;
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }

    public final Opcode getOpcode() {
        return this.opcode;
    }

    public final Integer getSeq() {
        return this.seq;
    }

    public final String getType() {
        return this.type;
    }
}
