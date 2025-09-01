package com.discord.utilities.debug;

import android.os.Build;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DebugPrintable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00022\n\u0010\u0011\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00022\n\u0010\u0016\u001a\u00060\u0014j\u0002`\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00060\rj\u0002`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR&\u0010\u001f\u001a\u0012\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/discord/utilities/debug/DebugPrintableCollection;", "", "", "removeDeadReferencesLocked", "()V", "Lcom/discord/utilities/debug/DebugPrintBuilder;", "dp", "addSystemEntry", "(Lcom/discord/utilities/debug/DebugPrintBuilder;)V", "Lcom/discord/utilities/debug/DebugPrintable;", "ref", "", "tag", "", "Lcom/discord/utilities/debug/DebugPrintableId;", "add", "(Lcom/discord/utilities/debug/DebugPrintable;Ljava/lang/String;)J", "debugPrintableId", "remove", "(J)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "sb", "debugPrint", "(Ljava/lang/StringBuilder;)V", "sync", "Ljava/lang/Object;", "idCounter", "J", "", "Lcom/discord/utilities/debug/DebugPrintableRef;", "collection", "Ljava/util/Map;", "<init>", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.debug.DebugPrintableCollection, reason: use source file name */
/* loaded from: classes2.dex */
public final class DebugPrintable3 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String libdiscordVersion = null;
    private static final int maxDebugPrintableStringLength = 524288;
    private long idCounter = 1;
    private final Map<Long, DebugPrintable5> collection = new LinkedHashMap();
    private final Object sync = new Object();

    /* compiled from: DebugPrintable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/utilities/debug/DebugPrintableCollection$Companion;", "", "", "libdiscordVersion", "", "initialize", "(Ljava/lang/String;)V", "Ljava/lang/String;", "", "maxDebugPrintableStringLength", "I", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.debug.DebugPrintableCollection$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final void initialize(String libdiscordVersion) {
            Intrinsics3.checkNotNullParameter(libdiscordVersion, "libdiscordVersion");
            DebugPrintable3.access$setLibdiscordVersion$cp(libdiscordVersion);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ String access$getLibdiscordVersion$cp() {
        return libdiscordVersion;
    }

    public static final /* synthetic */ void access$setLibdiscordVersion$cp(String str) {
        libdiscordVersion = str;
    }

    public static /* synthetic */ long add$default(DebugPrintable3 debugPrintable3, DebugPrintable debugPrintable, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return debugPrintable3.add(debugPrintable, str);
    }

    private final void addSystemEntry(DebugPrintable2 dp) {
        dp.appendLine("System:");
        dp.appendKeyValue("libdiscordVersion", libdiscordVersion);
        dp.appendKeyValue("SDK_INT", Integer.valueOf(Build.VERSION.SDK_INT));
        dp.append("\n");
    }

    private final void removeDeadReferencesLocked() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, DebugPrintable5> entry : this.collection.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            if (entry.getValue().getReference().get() == null) {
                arrayList.add(Long.valueOf(jLongValue));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.collection.remove(Long.valueOf(((Number) it.next()).longValue()));
        }
    }

    public final long add(DebugPrintable ref, String tag) {
        long j;
        Intrinsics3.checkNotNullParameter(ref, "ref");
        synchronized (this.sync) {
            j = this.idCounter;
            this.idCounter = j + 1;
            long j2 = 0;
            while (this.collection.containsKey(Long.valueOf(j))) {
                j = this.idCounter;
                this.idCounter = j + 1;
                j2++;
                if (j2 < 0) {
                    break;
                }
            }
            this.collection.put(Long.valueOf(j), new DebugPrintable5(tag, ref));
            removeDeadReferencesLocked();
        }
        return j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0087, code lost:
    
        r9.delete(524288, r9.length() - 1);
        r9.append(" {truncated}");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void debugPrint(StringBuilder sb) {
        Intrinsics3.checkNotNullParameter(sb, "sb");
        DebugPrintable2 debugPrintable2 = new DebugPrintable2(sb);
        synchronized (this.sync) {
            addSystemEntry(debugPrintable2);
            Iterator<Map.Entry<Long, DebugPrintable5>> it = this.collection.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, DebugPrintable5> next = it.next();
                long jLongValue = next.getKey().longValue();
                DebugPrintable5 value = next.getValue();
                DebugPrintable debugPrintable = value.getReference().get();
                if (debugPrintable != null) {
                    Intrinsics3.checkNotNullExpressionValue(debugPrintable, "printableRef.reference.get() ?: continue");
                    sb.append(jLongValue);
                    if (value.getTag() != null) {
                        sb.append(' ');
                        sb.append(value.getTag());
                    }
                    sb.append(":\n");
                    try {
                        debugPrintable.debugPrint(debugPrintable2);
                    } catch (Exception e) {
                        sb.append("Exception: " + e);
                    }
                    sb.append('\n');
                    if (sb.length() > 524288) {
                        break;
                    }
                }
            }
        }
    }

    public final void remove(long debugPrintableId) {
        synchronized (this.sync) {
            if (this.collection.remove(Long.valueOf(debugPrintableId)) == null) {
                Logger.w$default(LoggingProvider.INSTANCE.get(), "DebugPrintable", "Unable to locate tag '" + debugPrintableId + '\'', null, 4, null);
            }
        }
    }
}
