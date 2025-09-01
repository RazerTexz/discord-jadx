package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.y.Closeable;
import d0.y.ReadWrite;
import d0.z.d.Intrinsics3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;
import kotlin.Metadata;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import okio.ByteString;

/* compiled from: ZLibWebSocketListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002'(B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0011J'\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0016J)\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0019\u0010!\u001a\u00020 8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/discord/utilities/websocket/ZLibWebSocketListener;", "Lokhttp3/WebSocketListener;", "", "resetInflaters", "()V", "Lokhttp3/WebSocket;", "webSocket", "Lokhttp3/Response;", "response", "onOpen", "(Lokhttp3/WebSocket;Lokhttp3/Response;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "onMessage", "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Lokio/ByteString;", "bytes", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", ModelAuditLogEntry.CHANGE_KEY_CODE, ModelAuditLogEntry.CHANGE_KEY_REASON, "onClosing", "(Lokhttp3/WebSocket;ILjava/lang/String;)V", "onClosed", "", "t", "onFailure", "(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V", "Ljava/util/zip/Inflater;", "loggingInflater", "Ljava/util/zip/Inflater;", "inflater", "Lcom/discord/utilities/websocket/ZLibWebSocketListener$Listener;", "listener", "Lcom/discord/utilities/websocket/ZLibWebSocketListener$Listener;", "getListener", "()Lcom/discord/utilities/websocket/ZLibWebSocketListener$Listener;", "<init>", "(Lcom/discord/utilities/websocket/ZLibWebSocketListener$Listener;)V", "Listener", "ZLibByteStream", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ZLibWebSocketListener extends WebSocketListener {
    private final Inflater inflater;
    private final Listener listener;
    private final Inflater loggingInflater;

    /* compiled from: ZLibWebSocketListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\b2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0012\u0010\u0016R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/websocket/ZLibWebSocketListener$Listener;", "Lokhttp3/WebSocketListener;", "Lokhttp3/WebSocket;", "webSocket", "Ljava/io/InputStreamReader;", "reader", "", "compressedByteLength", "", "onInflatedMessage", "(Lokhttp3/WebSocket;Ljava/io/InputStreamReader;I)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onInflateError", "(Ljava/lang/Exception;)V", "Lokio/ByteString;", "bytes", "onMessage", "(Lokhttp3/WebSocket;Lokio/ByteString;)V", "", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "(Lokhttp3/WebSocket;Ljava/lang/String;)V", "Lcom/discord/utilities/websocket/RawMessageHandler;", "rawMessageHandler", "Lcom/discord/utilities/websocket/RawMessageHandler;", "getRawMessageHandler", "()Lcom/discord/utilities/websocket/RawMessageHandler;", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Listener extends WebSocketListener {
        private final RawMessageHandler rawMessageHandler;

        public RawMessageHandler getRawMessageHandler() {
            return this.rawMessageHandler;
        }

        public abstract void onInflateError(Exception e);

        public abstract void onInflatedMessage(okhttp3.WebSocket webSocket, InputStreamReader reader, int compressedByteLength);

        @Override // okhttp3.WebSocketListener
        public final void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(bytes, "bytes");
            throw new UnsupportedOperationException();
        }

        @Override // okhttp3.WebSocketListener
        public final void onMessage(okhttp3.WebSocket webSocket, String text) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: ZLibWebSocketListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/discord/utilities/websocket/ZLibWebSocketListener$ZLibByteStream;", "Ljava/io/ByteArrayOutputStream;", "Ljava/io/InputStreamReader;", "toReader", "()Ljava/io/InputStreamReader;", "Lokio/ByteString;", "bytes", "Ljava/util/zip/Inflater;", "inflater", "<init>", "(Lokio/ByteString;Ljava/util/zip/Inflater;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class ZLibByteStream extends ByteArrayOutputStream {
        private static final int INFLATE_BUFFER_SIZE = 4096;
        private static final int INITIAL_BUFFER_SIZE_MULTIPLIER = 2;
        private static final CharsetDecoder UTF8_DECODER = Charset.forName(Constants.ENCODING).newDecoder();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZLibByteStream(ByteString byteString, Inflater inflater) throws IOException {
            super(byteString.j() * 2);
            Intrinsics3.checkNotNullParameter(byteString, "bytes");
            Intrinsics3.checkNotNullParameter(inflater, "inflater");
            InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(this, inflater, 4096);
            byteString.r(inflaterOutputStream);
            inflaterOutputStream.flush();
        }

        public final InputStreamReader toReader() {
            return new InputStreamReader(new ByteArrayInputStream(((ByteArrayOutputStream) this).buf, 0, ((ByteArrayOutputStream) this).count), UTF8_DECODER);
        }
    }

    public ZLibWebSocketListener(Listener listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.loggingInflater = new Inflater();
        this.inflater = new Inflater();
    }

    private final void resetInflaters() {
        this.inflater.reset();
        this.loggingInflater.reset();
    }

    public final Listener getListener() {
        return this.listener;
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        resetInflaters();
        this.listener.onClosed(webSocket, code, reason);
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        resetInflaters();
        this.listener.onClosing(webSocket, code, reason);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(t, "t");
        resetInflaters();
        this.listener.onFailure(webSocket, t, response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, String text) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.listener.onMessage(webSocket, text);
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(okhttp3.WebSocket webSocket, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(response, "response");
        resetInflaters();
        this.listener.onOpen(webSocket, response);
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(okhttp3.WebSocket webSocket, ByteString bytes) throws IOException {
        InputStreamReader reader;
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(bytes, "bytes");
        if (this.listener.getRawMessageHandler() != null) {
            try {
                reader = new ZLibByteStream(bytes, this.loggingInflater).toReader();
                try {
                    String text = ReadWrite.readText(reader);
                    RawMessageHandler rawMessageHandler = this.listener.getRawMessageHandler();
                    Intrinsics3.checkNotNull(rawMessageHandler);
                    rawMessageHandler.onRawMessage(text);
                    Closeable.closeFinally(reader, null);
                } finally {
                }
            } catch (Throwable th) {
                RawMessageHandler rawMessageHandler2 = this.listener.getRawMessageHandler();
                Intrinsics3.checkNotNull(rawMessageHandler2);
                rawMessageHandler2.onRawMessageInflateFailed(th);
            }
        }
        try {
            reader = new ZLibByteStream(bytes, this.inflater).toReader();
            try {
                this.listener.onInflatedMessage(webSocket, reader, bytes.j());
                Closeable.closeFinally(reader, null);
            } finally {
            }
        } catch (Exception e) {
            this.listener.onInflateError(e);
        }
    }
}
