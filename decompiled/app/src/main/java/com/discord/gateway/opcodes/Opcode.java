package com.discord.gateway.opcodes;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Opcode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/discord/gateway/opcodes/Opcode;", "", "", "apiInt", "I", "getApiInt", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "UNHANDLED", "DISPATCH", "HEARTBEAT", "IDENTIFY", "PRESENCE_UPDATE", "VOICE_STATE_UPDATE", "VOICE_SERVER_PING", "RESUME", "RECONNECT", "REQUEST_GUILD_MEMBERS", "INVALID_SESSION", "HELLO", "HEARTBEAT_ACK", "CALL_CONNECT", "GUILD_SUBSCRIPTIONS", "STREAM_CREATE", "STREAM_DELETE", "STREAM_WATCH", "OPCODE_STREAM_PING", "REQUEST_GUILD_APPLICATION_COMMANDS", "REQUEST_FORUM_UNREADS", "gateway_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum Opcode {
    UNHANDLED(-1),
    DISPATCH(0),
    HEARTBEAT(1),
    IDENTIFY(2),
    PRESENCE_UPDATE(3),
    VOICE_STATE_UPDATE(4),
    VOICE_SERVER_PING(5),
    RESUME(6),
    RECONNECT(7),
    REQUEST_GUILD_MEMBERS(8),
    INVALID_SESSION(9),
    HELLO(10),
    HEARTBEAT_ACK(11),
    CALL_CONNECT(13),
    GUILD_SUBSCRIPTIONS(14),
    STREAM_CREATE(18),
    STREAM_DELETE(19),
    STREAM_WATCH(20),
    OPCODE_STREAM_PING(21),
    REQUEST_GUILD_APPLICATION_COMMANDS(24),
    REQUEST_FORUM_UNREADS(28);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Integer, Opcode> intLookup;
    private final int apiInt;

    /* compiled from: Opcode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R2\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/gateway/opcodes/Opcode$Companion;", "", "", "apiInt", "Lcom/discord/gateway/opcodes/Opcode;", "fromApiInt", "(I)Lcom/discord/gateway/opcodes/Opcode;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "intLookup", "Ljava/util/HashMap;", "<init>", "()V", "gateway_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Opcode fromApiInt(int apiInt) {
            Opcode opcode = (Opcode) Opcode.access$getIntLookup$cp().get(Integer.valueOf(apiInt));
            return opcode != null ? opcode : Opcode.UNHANDLED;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        HashMap<Integer, Opcode> map = new HashMap<>();
        Opcode[] opcodeArrValues = values();
        for (int i = 0; i < 21; i++) {
            Opcode opcode = opcodeArrValues[i];
            map.put(Integer.valueOf(opcode.apiInt), opcode);
        }
        intLookup = map;
    }

    Opcode(int i) {
        this.apiInt = i;
    }

    public static final /* synthetic */ HashMap access$getIntLookup$cp() {
        return intLookup;
    }

    public final int getApiInt() {
        return this.apiInt;
    }
}
