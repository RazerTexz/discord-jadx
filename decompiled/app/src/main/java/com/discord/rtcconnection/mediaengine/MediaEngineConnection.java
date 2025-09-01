package com.discord.rtcconnection.mediaengine;

import android.content.Intent;
import b.a.q.m0.Codec2;
import b.d.b.a.outline;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.KrispOveruseDetector;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MediaEngineConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001:\tV,IWX\u000f\u001bYZJ;\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H&¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0007H&¢\u0006\u0004\b\u001b\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0007H&¢\u0006\u0004\b\u001f\u0010\u0010J\u001f\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u0007H&¢\u0006\u0004\b'\u0010\u0010J#\u0010,\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020(2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*H&¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u000bH&¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u000b2\u0006\u00101\u001a\u000200H&¢\u0006\u0004\b2\u00103J\u001f\u00108\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00107\u001a\u000206H&¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\u000b2\u0006\u0010:\u001a\u0002042\u0006\u0010;\u001a\u000204H&¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>H&¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020>H&¢\u0006\u0004\bB\u0010AJ\u000f\u0010C\u001a\u00020\u000bH&¢\u0006\u0004\bC\u0010/J#\u0010G\u001a\u00020\u000b2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u000b0DH&¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0007H&¢\u0006\u0004\bI\u0010JJ\u0017\u0010M\u001a\u00020\u000b2\u0006\u0010L\u001a\u00020KH&¢\u0006\u0004\bM\u0010NJ#\u0010Q\u001a\u00020\u000b2\n\u0010\u0003\u001a\u00060\u0002j\u0002`O2\u0006\u0010P\u001a\u00020\u0007H&¢\u0006\u0004\bQ\u0010\u0017R\u0016\u0010U\u001a\u00020R8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T¨\u0006["}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection;", "", "", "userId", "", "audioSsrc", "videoSsrc", "", "isMuted", "", "volume", "", "s", "(JILjava/lang/Integer;ZF)V", "selfMute", "c", "(Z)V", "selfDeaf", "v", "u", "(J)Z", ModelAuditLogEntry.CHANGE_KEY_MUTE, "w", "(JZ)V", "g", "p", "offScreen", "d", "e", "(JF)V", "active", "q", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "inputMode", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$c;", "inputModeOptions", "k", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$c;)V", "isVideoBroadcast", "j", "Landroid/content/Intent;", "permission", "Lcom/discord/rtcconnection/mediaengine/ThumbnailEmitter;", "thumbnailEmitter", "a", "(Landroid/content/Intent;Lcom/discord/rtcconnection/mediaengine/ThumbnailEmitter;)V", "h", "()V", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$b;", "quality", "m", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$b;)V", "", "mode", "", "secretKey", "t", "(Ljava/lang/String;[I)V", "audioCodec", "videoCodec", "r", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$d;", "listener", "l", "(Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$d;)V", "o", "destroy", "Lkotlin/Function1;", "Lco/discord/media_engine/Stats;", "onStats", "n", "(Lkotlin/jvm/functions/Function1;)V", "b", "()Z", "Lcom/discord/rtcconnection/KrispOveruseDetector$Status;", "status", "f", "(Lcom/discord/rtcconnection/KrispOveruseDetector$Status;)V", "Lcom/discord/primitives/UserId;", "disabled", "i", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$Type;", "getType", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$Type;", "type", "ConnectionState", "FailedConnectionException", "InputMode", "TransportInfo", "Type", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public interface MediaEngineConnection {

    /* compiled from: MediaEngineConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$ConnectionState;", "", "<init>", "(Ljava/lang/String;I)V", "DISCONNECTED", "CONNECTING", "CONNECTED", "NO_ROUTE", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum ConnectionState {
        DISCONNECTED,
        CONNECTING,
        CONNECTED,
        NO_ROUTE
    }

    /* compiled from: MediaEngineConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\fB\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$FailedConnectionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$FailedConnectionException$FailureType;", "type", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$FailedConnectionException$FailureType;", "a", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$FailedConnectionException$FailureType;", "", "message", "<init>", "(Ljava/lang/String;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$FailedConnectionException$FailureType;)V", "FailureType", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final class FailedConnectionException extends Exception {
        private final FailureType type;

        /* compiled from: MediaEngineConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$FailedConnectionException$FailureType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "a", "DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED", "TIMEOUT", "ADDRESS_IP_RESOLVED", "NO_CONNECTION_INFO", "CODEC_NEGOTIATION_FAILED", "UNKNOWN", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
        public enum FailureType {
            DISCONNECTED_BEFORE_CONNECTION_ESTABLISHED,
            TIMEOUT,
            ADDRESS_IP_RESOLVED,
            NO_CONNECTION_INFO,
            CODEC_NEGOTIATION_FAILED,
            UNKNOWN;


            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* compiled from: MediaEngineConnection.kt */
            /* renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException$FailureType$a, reason: from kotlin metadata */
            public static final class Companion {
                public Companion(DefaultConstructorMarker defaultConstructorMarker) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedConnectionException(String str, FailureType failureType) {
            super(str);
            Intrinsics3.checkNotNullParameter(failureType, "type");
            this.type = failureType;
        }

        /* renamed from: a, reason: from getter */
        public final FailureType getType() {
            return this.type;
        }
    }

    /* compiled from: MediaEngineConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;", "", "", "numeral", "I", "getNumeral", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "VOICE_ACTIVITY", "PUSH_TO_TALK", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum InputMode {
        VOICE_ACTIVITY(1),
        PUSH_TO_TALK(2);


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int numeral;

        /* compiled from: MediaEngineConnection.kt */
        /* renamed from: com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode$a, reason: from kotlin metadata */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        InputMode(int i) {
            this.numeral = i;
        }

        public final int getNumeral() {
            return this.numeral;
        }
    }

    /* compiled from: MediaEngineConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0019\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo$Protocol;", "c", "Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo$Protocol;", "getProtocol", "()Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo$Protocol;", "protocol", "a", "Ljava/lang/String;", "getAddress", "address", "b", "I", "getPort", "port", "<init>", "(Ljava/lang/String;ILcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo$Protocol;)V", "Protocol", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class TransportInfo {

        /* renamed from: a, reason: from kotlin metadata */
        public final String address;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final int port;

        /* renamed from: c, reason: from kotlin metadata */
        public final Protocol protocol;

        /* compiled from: MediaEngineConnection.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$TransportInfo$Protocol;", "", "<init>", "(Ljava/lang/String;I)V", "UDP", "TCP", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
        public enum Protocol {
            UDP,
            TCP
        }

        public TransportInfo(String str, int i, Protocol protocol) {
            Intrinsics3.checkNotNullParameter(str, "address");
            Intrinsics3.checkNotNullParameter(protocol, "protocol");
            this.address = str;
            this.port = i;
            this.protocol = protocol;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TransportInfo)) {
                return false;
            }
            TransportInfo transportInfo = (TransportInfo) other;
            return Intrinsics3.areEqual(this.address, transportInfo.address) && this.port == transportInfo.port && Intrinsics3.areEqual(this.protocol, transportInfo.protocol);
        }

        public int hashCode() {
            String str = this.address;
            int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.port) * 31;
            Protocol protocol = this.protocol;
            return iHashCode + (protocol != null ? protocol.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("TransportInfo(address=");
            sbU.append(this.address);
            sbU.append(", port=");
            sbU.append(this.port);
            sbU.append(", protocol=");
            sbU.append(this.protocol);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MediaEngineConnection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$Type;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "STREAM", "rtcconnection_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        DEFAULT,
        STREAM
    }

    /* compiled from: MediaEngineConnection.kt */
    public static abstract class a implements d {
        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onConnected(MediaEngineConnection mediaEngineConnection, TransportInfo transportInfo, List<Codec2> list) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
            Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, ConnectionState connectionState) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public abstract void onDestroy(MediaEngineConnection mediaEngineConnection);

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onError(MediaEngineConnection mediaEngineConnection, FailedConnectionException failedConnectionException) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(status, "status");
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onLocalMute(long j, boolean z2) {
        }

        public void onLocalVideoDisabled(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onLocalVideoOffScreen(long j, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onSpeaking(long j, int i, boolean z2) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onTargetBitrate(int i) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onTargetFrameRate(int i) {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr) {
            Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
        }
    }

    /* compiled from: MediaEngineConnection.kt */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2799b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.f2799b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.f2799b == bVar.f2799b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
        }

        public int hashCode() {
            return (((((((((this.a * 31) + this.f2799b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f;
        }

        public String toString() {
            StringBuilder sbU = outline.U("EncodingQuality(minBitrate=");
            sbU.append(this.a);
            sbU.append(", maxBitrate=");
            sbU.append(this.f2799b);
            sbU.append(", width=");
            sbU.append(this.c);
            sbU.append(", height=");
            sbU.append(this.d);
            sbU.append(", mutedFramerate=");
            sbU.append(this.e);
            sbU.append(", framerate=");
            return outline.B(sbU, this.f, ")");
        }
    }

    /* compiled from: MediaEngineConnection.kt */
    public static final class c {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final int f2800b;
        public final int c;
        public final boolean d;
        public final boolean e;
        public final int f;

        public c() {
            this(0, 0, 0, false, false, 0, 63);
        }

        public c(int i, int i2, int i3, boolean z2, boolean z3, int i4) {
            this.a = i;
            this.f2800b = i2;
            this.c = i3;
            this.d = z2;
            this.e = z3;
            this.f = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.f2800b == cVar.f2800b && this.c == cVar.c && this.d == cVar.d && this.e == cVar.e && this.f == cVar.f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = ((((this.a * 31) + this.f2800b) * 31) + this.c) * 31;
            boolean z2 = this.d;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.e;
            return ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31) + this.f;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InputModeOptions(vadThreshold=");
            sbU.append(this.a);
            sbU.append(", vadLeadingFrames=");
            sbU.append(this.f2800b);
            sbU.append(", vadTrailingFrames=");
            sbU.append(this.c);
            sbU.append(", vadAutoThreshold=");
            sbU.append(this.d);
            sbU.append(", vadUseKrisp=");
            sbU.append(this.e);
            sbU.append(", pttReleaseDelayMs=");
            return outline.B(sbU, this.f, ")");
        }

        public c(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            i = (i5 & 1) != 0 ? 0 : i;
            i2 = (i5 & 2) != 0 ? 10 : i2;
            i3 = (i5 & 4) != 0 ? 40 : i3;
            z2 = (i5 & 8) != 0 ? true : z2;
            z3 = (i5 & 16) != 0 ? true : z3;
            i4 = (i5 & 32) != 0 ? 5 : i4;
            this.a = i;
            this.f2800b = i2;
            this.c = i3;
            this.d = z2;
            this.e = z3;
            this.f = i4;
        }
    }

    /* compiled from: MediaEngineConnection.kt */
    public interface d {
        void onConnected(MediaEngineConnection mediaEngineConnection, TransportInfo transportInfo, List<Codec2> list);

        void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, ConnectionState connectionState);

        void onDestroy(MediaEngineConnection mediaEngineConnection);

        void onError(MediaEngineConnection mediaEngineConnection, FailedConnectionException failedConnectionException);

        void onKrispStatus(MediaEngineConnection mediaEngineConnection, KrispOveruseDetector.Status status);

        void onLocalMute(long j, boolean z2);

        void onLocalVideoOffScreen(long j, boolean z2);

        void onSpeaking(long j, int i, boolean z2);

        void onTargetBitrate(int i);

        void onTargetFrameRate(int i);

        void onVideo(long j, Integer num, int i, int i2, int i3, StreamParameters[] streamParametersArr);
    }

    void a(Intent permission, ThumbnailEmitter thumbnailEmitter);

    boolean b();

    void c(boolean selfMute);

    void d(long userId, boolean offScreen);

    void destroy();

    void e(long userId, float volume);

    void f(KrispOveruseDetector.Status status);

    boolean g(long userId);

    Type getType();

    void h();

    void i(long userId, boolean disabled);

    void j(boolean isVideoBroadcast);

    void k(InputMode inputMode, c inputModeOptions);

    void l(d listener);

    void m(b quality);

    void n(Function1<? super Stats, Unit> onStats);

    void o(d listener);

    boolean p(long userId);

    void q(boolean active);

    void r(String audioCodec, String videoCodec);

    void s(long userId, int audioSsrc, Integer videoSsrc, boolean isMuted, float volume);

    void t(String mode, int[] secretKey);

    boolean u(long userId);

    void v(boolean selfDeaf);

    void w(long userId, boolean mute);
}
