package com.discord.utilities.systemlog;

import com.discord.utilities.collections.FixedSizeLineBuffer;
import d0.g0.Charsets2;
import d0.g0.Strings4;
import d0.v.Thread2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SystemLogCapture.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00022\n\u0010\r\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/discord/utilities/systemlog/SystemLogCapture;", "", "", "start", "()V", "Ljava/lang/Thread;", "startThread", "()Ljava/lang/Thread;", "", "getOutput", "()Ljava/lang/String;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "appendOutput", "(Ljava/lang/StringBuilder;)V", "Lcom/discord/utilities/collections/FixedSizeLineBuffer;", "tombstoneBuffer", "Lcom/discord/utilities/collections/FixedSizeLineBuffer;", "buffer", "<init>", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SystemLogCapture {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final FixedSizeLineBuffer buffer = new FixedSizeLineBuffer(524288);
    private final FixedSizeLineBuffer tombstoneBuffer = new FixedSizeLineBuffer(102400);

    /* compiled from: SystemLogCapture.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/discord/utilities/systemlog/SystemLogCapture$Companion;", "", "", "line", "", "shouldIncludeLogLine$app_productionGoogleRelease", "(Ljava/lang/String;)Z", "shouldIncludeLogLine", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final boolean shouldIncludeLogLine$app_productionGoogleRelease(String line) {
            Intrinsics3.checkNotNullParameter(line, "line");
            return !Strings4.contains$default((CharSequence) line, (CharSequence) "chatty  : uid=", false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SystemLogCapture.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.systemlog.SystemLogCapture$startThread$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws InterruptedException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws InterruptedException {
            SystemLogCapture.access$start(SystemLogCapture.this);
        }
    }

    public static final /* synthetic */ void access$start(SystemLogCapture systemLogCapture) throws InterruptedException {
        systemLogCapture.start();
    }

    private final void start() throws InterruptedException {
        if (!new File(SystemLogUtils.logcatPath).exists()) {
            this.buffer.addLine("Unable to locate '/system/bin/logcat'");
            return;
        }
        while (true) {
            Process processStart = null;
            try {
                try {
                    processStart = new ProcessBuilder(SystemLogUtils.logcatPath).redirectErrorStream(true).start();
                    Intrinsics3.checkNotNullExpressionValue(processStart, "logcatProcess");
                    InputStream inputStream = processStart.getInputStream();
                    Intrinsics3.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                    Reader inputStreamReader = new InputStreamReader(inputStream, Charsets2.a);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            if (INSTANCE.shouldIncludeLogLine$app_productionGoogleRelease(line)) {
                                this.buffer.addLine(line);
                            }
                            if (SystemLogUtils.INSTANCE.getRegexExtractTombstone$app_productionGoogleRelease().matches(line)) {
                                this.tombstoneBuffer.addLine(line);
                            }
                        } catch (IOException unused) {
                        }
                    }
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.buffer.addLine("Exception getting system logs '" + e + '\'');
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    Intrinsics3.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        this.buffer.addLine("    " + stackTraceElement);
                    }
                    if (processStart != null) {
                    }
                }
                processStart.destroy();
                Thread.sleep(1000L);
            } catch (Throwable th) {
                if (processStart != null) {
                    processStart.destroy();
                }
                throw th;
            }
        }
    }

    public final void appendOutput(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        this.tombstoneBuffer.appendString(sb);
        this.buffer.appendString(sb);
    }

    public final String getOutput() {
        return this.tombstoneBuffer.getString() + '\n' + this.buffer.getString();
    }

    public final Thread startThread() {
        return Thread2.thread$default(true, true, null, SystemLogCapture.class.getSimpleName(), 0, new AnonymousClass1(), 20, null);
    }
}
