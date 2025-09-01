package com.discord.rtcconnection.socket.io;

import d0.Tuples;
import d0.t.Maps6;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: Opcodes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0016\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\bR\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/rtcconnection/socket/io/Opcodes;", "", "", "opcode", "", "getNameOf", "(I)Ljava/lang/String;", "SPEAKING", "I", "CLIENT_DISCONNECT", "SELECT_PROTOCOL", "SELECT_PROTOCOL_ACK", "SESSION_UPDATE", "MEDIA_SINK_WANTS", "HEARTBEAT", "IDENTIFY", "RESUME", "HELLO", "VIDEO", "", "nameLookup", "Ljava/util/Map;", "READY", "HEARTBEAT_ACK", "RESUMED", "<init>", "()V", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class Opcodes {
    public static final int CLIENT_DISCONNECT = 13;
    public static final int HEARTBEAT = 3;
    public static final int HEARTBEAT_ACK = 6;
    public static final int HELLO = 8;
    public static final int IDENTIFY = 0;
    public static final int MEDIA_SINK_WANTS = 15;
    public static final int READY = 2;
    public static final int RESUME = 7;
    public static final int RESUMED = 9;
    public static final int SELECT_PROTOCOL = 1;
    public static final int SELECT_PROTOCOL_ACK = 4;
    public static final int SESSION_UPDATE = 14;
    public static final int SPEAKING = 5;
    public static final int VIDEO = 12;
    public static final Opcodes INSTANCE = new Opcodes();
    private static final Map<Integer, String> nameLookup = Maps6.mapOf(Tuples.to(0, "IDENTIFY"), Tuples.to(1, "SELECT_PROTOCOL"), Tuples.to(2, "READY"), Tuples.to(3, "HEARTBEAT"), Tuples.to(4, "SELECT_PROTOCOL_ACK"), Tuples.to(5, "SPEAKING"), Tuples.to(6, "HEARTBEAT_ACK"), Tuples.to(7, "RESUME"), Tuples.to(8, "HELLO"), Tuples.to(9, "RESUMED"), Tuples.to(12, "VIDEO"), Tuples.to(13, "CLIENT_DISCONNECT"), Tuples.to(14, "SESSION_UPDATE"), Tuples.to(15, "MEDIA_SINK_WANTS"));

    private Opcodes() {
    }

    public final String getNameOf(int opcode) {
        String str = nameLookup.get(Integer.valueOf(opcode));
        if (str == null) {
            str = "Unknown (" + opcode + ')';
        }
        return str;
    }
}
