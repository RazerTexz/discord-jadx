package com.discord.utilities.system;

import a0.a.a.b;
import b.d.b.a.outline;
import d0.LazyJVM;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.y.FileReadWrite;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;

/* compiled from: ProcfsReader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0011R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/discord/utilities/system/ProcfsReader;", "", "", "s", "", "toLong", "(Ljava/lang/String;)J", "Ljava/io/File;", "file", "readFile", "(Ljava/io/File;)Ljava/lang/String;", "input", "Lcom/discord/utilities/system/ProcfsReader$Stat;", "parsePidStats", "(Ljava/lang/String;)Lcom/discord/utilities/system/ProcfsReader$Stat;", "readStatFile", "()Lcom/discord/utilities/system/ProcfsReader$Stat;", "(Ljava/io/File;)Lcom/discord/utilities/system/ProcfsReader$Stat;", "", "pid$delegate", "Lkotlin/Lazy;", "getPid", "()I", "pid", "default", "Lcom/discord/utilities/system/ProcfsReader$Stat;", "<init>", "()V", "Stat", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ProcfsReader {
    public static final ProcfsReader INSTANCE = new ProcfsReader();

    /* renamed from: pid$delegate, reason: from kotlin metadata */
    private static final Lazy pid = LazyJVM.lazy(ProcfsReader2.INSTANCE);
    private static final Stat default = new Stat(0, 0, 0, 0);

    /* compiled from: ProcfsReader.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J8\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/discord/utilities/system/ProcfsReader$Stat;", "", "", "component1", "()J", "component2", "component3", "component4", "userTime", "systemTime", "totalTime", "rssPages", "copy", "(JJJJ)Lcom/discord/utilities/system/ProcfsReader$Stat;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "getUserTime", "getRssPages", "getSystemTime", "getTotalTime", "<init>", "(JJJJ)V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Stat {
        private final long rssPages;
        private final long systemTime;
        private final long totalTime;
        private final long userTime;

        public Stat(long j, long j2, long j3, long j4) {
            this.userTime = j;
            this.systemTime = j2;
            this.totalTime = j3;
            this.rssPages = j4;
        }

        public static /* synthetic */ Stat copy$default(Stat stat, long j, long j2, long j3, long j4, int i, Object obj) {
            return stat.copy((i & 1) != 0 ? stat.userTime : j, (i & 2) != 0 ? stat.systemTime : j2, (i & 4) != 0 ? stat.totalTime : j3, (i & 8) != 0 ? stat.rssPages : j4);
        }

        /* renamed from: component1, reason: from getter */
        public final long getUserTime() {
            return this.userTime;
        }

        /* renamed from: component2, reason: from getter */
        public final long getSystemTime() {
            return this.systemTime;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTotalTime() {
            return this.totalTime;
        }

        /* renamed from: component4, reason: from getter */
        public final long getRssPages() {
            return this.rssPages;
        }

        public final Stat copy(long userTime, long systemTime, long totalTime, long rssPages) {
            return new Stat(userTime, systemTime, totalTime, rssPages);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stat)) {
                return false;
            }
            Stat stat = (Stat) other;
            return this.userTime == stat.userTime && this.systemTime == stat.systemTime && this.totalTime == stat.totalTime && this.rssPages == stat.rssPages;
        }

        public final long getRssPages() {
            return this.rssPages;
        }

        public final long getSystemTime() {
            return this.systemTime;
        }

        public final long getTotalTime() {
            return this.totalTime;
        }

        public final long getUserTime() {
            return this.userTime;
        }

        public int hashCode() {
            return b.a(this.rssPages) + ((b.a(this.totalTime) + ((b.a(this.systemTime) + (b.a(this.userTime) * 31)) * 31)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Stat(userTime=");
            sbU.append(this.userTime);
            sbU.append(", systemTime=");
            sbU.append(this.systemTime);
            sbU.append(", totalTime=");
            sbU.append(this.totalTime);
            sbU.append(", rssPages=");
            return outline.C(sbU, this.rssPages, ")");
        }
    }

    private ProcfsReader() {
    }

    private final int getPid() {
        return ((Number) pid.getValue()).intValue();
    }

    private final Stat parsePidStats(String input) {
        if (input.length() == 0) {
            return default;
        }
        List listSplit$default = Strings4.split$default((CharSequence) input, new char[]{' '}, false, 0, 6, (Object) null);
        long j = toLong((String) listSplit$default.get(13));
        long j2 = toLong((String) listSplit$default.get(14));
        return new Stat(j, j2, j + j2, toLong((String) listSplit$default.get(23)));
    }

    private final String readFile(File file) {
        try {
            if (file.exists()) {
                return FileReadWrite.readText$default(file, null, 1, null);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final long toLong(String s2) {
        Long longOrNull = StringNumberConversions.toLongOrNull(s2);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final Stat readStatFile() {
        return readStatFile(new File(outline.B(outline.U("/proc/"), getPid(), "/stat")));
    }

    public final Stat readStatFile(File file) {
        Intrinsics3.checkNotNullParameter(file, "file");
        String file2 = readFile(file);
        return file2 != null ? parsePidStats(file2) : default;
    }
}
