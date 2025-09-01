package com.discord.utilities.system;

import a0.a.a.b;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.AnyThread;
import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import com.discord.utilities.system.ProcfsReader;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeSpan;
import d0.Result2;
import d0.Result3;
import d0.v.Thread2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DeviceResourceUsageMonitor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB+\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0005¢\u0006\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/system/DeviceResourceUsageMonitor;", "", "", "monitor", "()V", "start", "stop", "finalize", "threadSync", "Ljava/lang/Object;", "", "activeThreadId", "Ljava/lang/Long;", "Lkotlin/Function1;", "Lcom/discord/utilities/system/DeviceResourceUsageMonitor$ResourceUsage;", "callback", "Lkotlin/jvm/functions/Function1;", "Ljava/lang/Thread;", "thread", "Ljava/lang/Thread;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "Lcom/discord/utilities/time/TimeSpan;", "timeSpan", "Lcom/discord/utilities/time/TimeSpan;", "<init>", "(Lcom/discord/utilities/time/TimeSpan;Lcom/discord/utilities/time/Clock;Lkotlin/jvm/functions/Function1;)V", "Companion", "ResourceUsage", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class DeviceResourceUsageMonitor {
    private static final long SC_CLK_TCK;
    private static final long SC_PAGE_SIZE;
    private static final int cpuCoreCount;
    private Long activeThreadId;
    private final Function1<ResourceUsage, Unit> callback;
    private final Clock clock;
    private Thread thread;
    private final Object threadSync;
    private final TimeSpan timeSpan;

    /* compiled from: DeviceResourceUsageMonitor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/system/DeviceResourceUsageMonitor$ResourceUsage;", "", "", "component1", "()I", "", "component2", "()J", "component3", "cpuUsagePercent", "memoryRssBytes", "cpuCoreCount", "copy", "(IJI)Lcom/discord/utilities/system/DeviceResourceUsageMonitor$ResourceUsage;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCpuCoreCount", "getCpuUsagePercent", "J", "getMemoryRssBytes", "<init>", "(IJI)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ResourceUsage {
        private final int cpuCoreCount;
        private final int cpuUsagePercent;
        private final long memoryRssBytes;

        public ResourceUsage(int i, long j, int i2) {
            this.cpuUsagePercent = i;
            this.memoryRssBytes = j;
            this.cpuCoreCount = i2;
        }

        public static /* synthetic */ ResourceUsage copy$default(ResourceUsage resourceUsage, int i, long j, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = resourceUsage.cpuUsagePercent;
            }
            if ((i3 & 2) != 0) {
                j = resourceUsage.memoryRssBytes;
            }
            if ((i3 & 4) != 0) {
                i2 = resourceUsage.cpuCoreCount;
            }
            return resourceUsage.copy(i, j, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCpuUsagePercent() {
            return this.cpuUsagePercent;
        }

        /* renamed from: component2, reason: from getter */
        public final long getMemoryRssBytes() {
            return this.memoryRssBytes;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCpuCoreCount() {
            return this.cpuCoreCount;
        }

        public final ResourceUsage copy(int cpuUsagePercent, long memoryRssBytes, int cpuCoreCount) {
            return new ResourceUsage(cpuUsagePercent, memoryRssBytes, cpuCoreCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResourceUsage)) {
                return false;
            }
            ResourceUsage resourceUsage = (ResourceUsage) other;
            return this.cpuUsagePercent == resourceUsage.cpuUsagePercent && this.memoryRssBytes == resourceUsage.memoryRssBytes && this.cpuCoreCount == resourceUsage.cpuCoreCount;
        }

        public final int getCpuCoreCount() {
            return this.cpuCoreCount;
        }

        public final int getCpuUsagePercent() {
            return this.cpuUsagePercent;
        }

        public final long getMemoryRssBytes() {
            return this.memoryRssBytes;
        }

        public int hashCode() {
            return ((b.a(this.memoryRssBytes) + (this.cpuUsagePercent * 31)) * 31) + this.cpuCoreCount;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ResourceUsage(cpuUsagePercent=");
            sbU.append(this.cpuUsagePercent);
            sbU.append(", memoryRssBytes=");
            sbU.append(this.memoryRssBytes);
            sbU.append(", cpuCoreCount=");
            return outline.B(sbU, this.cpuCoreCount, ")");
        }
    }

    static {
        Object objM97constructorimpl;
        Object objM97constructorimpl2;
        Object objM97constructorimpl3;
        try {
            Result2.a aVar = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_CLK_TCK)));
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            objM97constructorimpl = Result2.m97constructorimpl(Result3.createFailure(th));
        }
        if (Result2.m101isFailureimpl(objM97constructorimpl)) {
            objM97constructorimpl = 100L;
        }
        SC_CLK_TCK = ((Number) objM97constructorimpl).longValue();
        try {
            Result2.a aVar3 = Result2.j;
            objM97constructorimpl2 = Result2.m97constructorimpl(Long.valueOf(Os.sysconf(OsConstants._SC_PAGE_SIZE)));
        } catch (Throwable th2) {
            Result2.a aVar4 = Result2.j;
            objM97constructorimpl2 = Result2.m97constructorimpl(Result3.createFailure(th2));
        }
        Long lValueOf = Long.valueOf(Permission.SEND_TTS_MESSAGES);
        if (Result2.m101isFailureimpl(objM97constructorimpl2)) {
            objM97constructorimpl2 = lValueOf;
        }
        SC_PAGE_SIZE = ((Number) objM97constructorimpl2).longValue();
        try {
            Result2.a aVar5 = Result2.j;
            objM97constructorimpl3 = Result2.m97constructorimpl(Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        } catch (Throwable th3) {
            Result2.a aVar6 = Result2.j;
            objM97constructorimpl3 = Result2.m97constructorimpl(Result3.createFailure(th3));
        }
        if (Result2.m101isFailureimpl(objM97constructorimpl3)) {
            objM97constructorimpl3 = 1;
        }
        cpuCoreCount = ((Number) objM97constructorimpl3).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceResourceUsageMonitor(TimeSpan timeSpan, Clock clock, Function1<? super ResourceUsage, Unit> function1) {
        Intrinsics3.checkNotNullParameter(timeSpan, "timeSpan");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        this.timeSpan = timeSpan;
        this.clock = clock;
        this.callback = function1;
        this.threadSync = new Object();
    }

    public static final /* synthetic */ void access$monitor(DeviceResourceUsageMonitor deviceResourceUsageMonitor) {
        deviceResourceUsageMonitor.monitor();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void monitor() throws InterruptedException {
        ProcfsReader.Stat stat = null;
        Long lValueOf = null;
        while (true) {
            synchronized (this.threadSync) {
                Long l = this.activeThreadId;
                Thread threadCurrentThread = Thread.currentThread();
                Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
                long id2 = threadCurrentThread.getId();
                if (l == null || l.longValue() != id2) {
                    break;
                }
                if (Thread.interrupted()) {
                    return;
                }
                ProcfsReader.Stat statFile = ProcfsReader.INSTANCE.readStatFile();
                long jCurrentTimeMillis = this.clock.currentTimeMillis();
                if (stat != null && lValueOf != null) {
                    double totalTime = ((statFile.getTotalTime() - stat.getTotalTime()) * 100) / (SC_CLK_TCK * ((jCurrentTimeMillis - lValueOf.longValue()) / 1000.0d));
                    int i = cpuCoreCount;
                    if (i == 0) {
                        i = 1;
                    }
                    this.callback.invoke(new ResourceUsage((int) (totalTime / i), statFile.getRssPages() * SC_PAGE_SIZE, i));
                }
                lValueOf = Long.valueOf(jCurrentTimeMillis);
                Thread.sleep(this.timeSpan.toMillis());
                stat = statFile;
            }
        }
    }

    @AnyThread
    public final void finalize() {
        stop();
    }

    @AnyThread
    public final void start() {
        Thread thread;
        synchronized (this.threadSync) {
            thread = this.thread;
            Thread threadThread$default = Thread2.thread$default(true, true, null, "DeviceResourceUsageMonitor", 2, new DeviceResourceUsageMonitor2(this), 4, null);
            this.activeThreadId = Long.valueOf(threadThread$default.getId());
            this.thread = threadThread$default;
        }
        if (thread != null) {
            thread.interrupt();
        }
    }

    @AnyThread
    public final void stop() {
        Thread thread;
        synchronized (this.threadSync) {
            thread = this.thread;
            this.thread = null;
            this.activeThreadId = null;
        }
        if (thread != null) {
            thread.interrupt();
        }
    }
}
