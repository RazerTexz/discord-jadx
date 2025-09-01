package com.discord.utilities.systemlog;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.utilities.debug.DebugPrintable3;
import d0.f0._Sequences2;
import d0.g0.Charsets2;
import d0.g0.Regex5;
import d0.g0.StringBuilderJVM;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.t.Sets5;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.EmptyObservableHolder;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Observable;

/* compiled from: SystemLogUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002¢\u0006\u0004\b3\u00104J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010!\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00068\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010$\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u0010/\u001a\u00020.8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/discord/utilities/systemlog/SystemLogUtils;", "", "Lkotlin/text/Regex;", "filter", "Lrx/Observable;", "Ljava/util/LinkedList;", "", "fetch", "(Lkotlin/text/Regex;)Lrx/Observable;", "input", "hashString", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/Process;", "process", "", "waitFor", "(Ljava/lang/Process;)V", "()Ljava/lang/String;", "Ljava/lang/Thread;", "initSystemLogCapture", "()Ljava/lang/Thread;", "Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", "fetchLastTombstone", "()Lrx/Observable;", "", "crashes", "fetchLastTombstone$app_productionGoogleRelease", "(Ljava/util/Collection;)Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", "Ljava/io/BufferedReader;", "reader", "output", "processLogs$app_productionGoogleRelease", "(Ljava/io/BufferedReader;Ljava/util/LinkedList;Lkotlin/text/Regex;)V", "processLogs", "logcatPath", "Ljava/lang/String;", "regexExtractTombstone", "Lkotlin/text/Regex;", "getRegexExtractTombstone$app_productionGoogleRelease", "()Lkotlin/text/Regex;", "", "maxLogSize", "I", "Lcom/discord/utilities/systemlog/SystemLogCapture;", "systemLogCapture", "Lcom/discord/utilities/systemlog/SystemLogCapture;", "Lcom/discord/utilities/debug/DebugPrintableCollection;", "debugPrintables", "Lcom/discord/utilities/debug/DebugPrintableCollection;", "getDebugPrintables$app_productionGoogleRelease", "()Lcom/discord/utilities/debug/DebugPrintableCollection;", "<init>", "()V", "Tombstone", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SystemLogUtils {
    public static final String logcatPath = "/system/bin/logcat";
    private static final int maxLogSize = 2500000;
    private static final Regex regexExtractTombstone;
    public static final SystemLogUtils INSTANCE = new SystemLogUtils();
    private static final DebugPrintable3 debugPrintables = new DebugPrintable3();
    private static final SystemLogCapture systemLogCapture = new SystemLogCapture();

    /* compiled from: SystemLogUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004JN\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\u0019\u0010\u000f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001f\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b \u0010\u0004¨\u0006#"}, d2 = {"Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", NotificationCompat.MessagingStyle.Message.KEY_TEXT, "cause", "groupBy", "origin", "groupHash", "textHash", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getText", "getGroupBy", "getTextHash", "getOrigin", "getCause", "getGroupHash", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class Tombstone {
        private final String cause;
        private final String groupBy;
        private final String groupHash;
        private final String origin;
        private final String text;
        private final String textHash;

        public Tombstone(String str, String str2, String str3, String str4, String str5, String str6) {
            Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(str3, "groupBy");
            Intrinsics3.checkNotNullParameter(str4, "origin");
            Intrinsics3.checkNotNullParameter(str5, "groupHash");
            Intrinsics3.checkNotNullParameter(str6, "textHash");
            this.text = str;
            this.cause = str2;
            this.groupBy = str3;
            this.origin = str4;
            this.groupHash = str5;
            this.textHash = str6;
        }

        public static /* synthetic */ Tombstone copy$default(Tombstone tombstone, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tombstone.text;
            }
            if ((i & 2) != 0) {
                str2 = tombstone.cause;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                str3 = tombstone.groupBy;
            }
            String str8 = str3;
            if ((i & 8) != 0) {
                str4 = tombstone.origin;
            }
            String str9 = str4;
            if ((i & 16) != 0) {
                str5 = tombstone.groupHash;
            }
            String str10 = str5;
            if ((i & 32) != 0) {
                str6 = tombstone.textHash;
            }
            return tombstone.copy(str, str7, str8, str9, str10, str6);
        }

        /* renamed from: component1, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCause() {
            return this.cause;
        }

        /* renamed from: component3, reason: from getter */
        public final String getGroupBy() {
            return this.groupBy;
        }

        /* renamed from: component4, reason: from getter */
        public final String getOrigin() {
            return this.origin;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGroupHash() {
            return this.groupHash;
        }

        /* renamed from: component6, reason: from getter */
        public final String getTextHash() {
            return this.textHash;
        }

        public final Tombstone copy(String text, String cause, String groupBy, String origin, String groupHash, String textHash) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(groupBy, "groupBy");
            Intrinsics3.checkNotNullParameter(origin, "origin");
            Intrinsics3.checkNotNullParameter(groupHash, "groupHash");
            Intrinsics3.checkNotNullParameter(textHash, "textHash");
            return new Tombstone(text, cause, groupBy, origin, groupHash, textHash);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tombstone)) {
                return false;
            }
            Tombstone tombstone = (Tombstone) other;
            return Intrinsics3.areEqual(this.text, tombstone.text) && Intrinsics3.areEqual(this.cause, tombstone.cause) && Intrinsics3.areEqual(this.groupBy, tombstone.groupBy) && Intrinsics3.areEqual(this.origin, tombstone.origin) && Intrinsics3.areEqual(this.groupHash, tombstone.groupHash) && Intrinsics3.areEqual(this.textHash, tombstone.textHash);
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getGroupBy() {
            return this.groupBy;
        }

        public final String getGroupHash() {
            return this.groupHash;
        }

        public final String getOrigin() {
            return this.origin;
        }

        public final String getText() {
            return this.text;
        }

        public final String getTextHash() {
            return this.textHash;
        }

        public int hashCode() {
            String str = this.text;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.cause;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.groupBy;
            int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.origin;
            int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.groupHash;
            int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            String str6 = this.textHash;
            return iHashCode5 + (str6 != null ? str6.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Tombstone(text=");
            sbU.append(this.text);
            sbU.append(", cause=");
            sbU.append(this.cause);
            sbU.append(", groupBy=");
            sbU.append(this.groupBy);
            sbU.append(", origin=");
            sbU.append(this.origin);
            sbU.append(", groupHash=");
            sbU.append(this.groupHash);
            sbU.append(", textHash=");
            return outline.J(sbU, this.textHash, ")");
        }
    }

    /* compiled from: SystemLogUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/LinkedList;", "", "kotlin.jvm.PlatformType", NotificationCompat.CATEGORY_CALL, "()Ljava/util/LinkedList;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.systemlog.SystemLogUtils$fetch$1, reason: invalid class name */
    public static final class AnonymousClass1<V> implements Callable<LinkedList<String>> {
        public final /* synthetic */ Regex $filter;
        public final /* synthetic */ boolean $logErrors;
        public final /* synthetic */ LinkedList $output;

        public AnonymousClass1(LinkedList linkedList, Regex regex, boolean z2) {
            this.$output = linkedList;
            this.$filter = regex;
            this.$logErrors = z2;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ LinkedList<String> call() {
            return call2();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<String> call2() {
            Process processStart = null;
            try {
                try {
                    processStart = new ProcessBuilder(SystemLogUtils.logcatPath, "-d").redirectErrorStream(true).start();
                    SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(processStart, "logcatProcess");
                    SystemLogUtils.access$waitFor(systemLogUtils, processStart);
                    InputStream inputStream = processStart.getInputStream();
                    Intrinsics3.checkNotNullExpressionValue(inputStream, "logcatProcess.inputStream");
                    Reader inputStreamReader = new InputStreamReader(inputStream, Charsets2.a);
                    BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                    systemLogUtils.processLogs$app_productionGoogleRelease(bufferedReader, this.$output, this.$filter);
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.$logErrors) {
                        this.$output.add("Exception getting system logs '" + e + '\'');
                        StackTraceElement[] stackTrace = e.getStackTrace();
                        Intrinsics3.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            this.$output.add("    " + stackTraceElement);
                        }
                    }
                    if (processStart != null) {
                    }
                }
                processStart.destroy();
                return this.$output;
            } catch (Throwable th) {
                if (processStart != null) {
                    processStart.destroy();
                }
                throw th;
            }
        }
    }

    /* compiled from: SystemLogUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/util/LinkedList;", "", "kotlin.jvm.PlatformType", "crashes", "Lrx/Observable;", "Lcom/discord/utilities/systemlog/SystemLogUtils$Tombstone;", NotificationCompat.CATEGORY_CALL, "(Ljava/util/LinkedList;)Lrx/Observable;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.systemlog.SystemLogUtils$fetchLastTombstone$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<LinkedList<String>, Observable<? extends Tombstone>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Tombstone> call(LinkedList<String> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Tombstone> call2(LinkedList<String> linkedList) {
            SystemLogUtils systemLogUtils = SystemLogUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "crashes");
            Tombstone tombstoneFetchLastTombstone$app_productionGoogleRelease = systemLogUtils.fetchLastTombstone$app_productionGoogleRelease(linkedList);
            return tombstoneFetchLastTombstone$app_productionGoogleRelease == null ? EmptyObservableHolder.k : new ScalarSynchronousObservable(tombstoneFetchLastTombstone$app_productionGoogleRelease);
        }
    }

    /* compiled from: SystemLogUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(B)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.systemlog.SystemLogUtils$hashString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Byte, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Byte b2) {
            return invoke(b2.byteValue());
        }

        public final CharSequence invoke(byte b2) {
            return outline.P(new Object[]{Byte.valueOf(b2)}, 1, "%02X", "java.lang.String.format(this, *args)");
        }
    }

    static {
        StringBuilder sbU = outline.U("(?:^(?:[^\\s]+\\s+){4}F\\s+DEBUG\\s+:\\s(.+))|(^.+(\\[");
        sbU.append(Regex.INSTANCE.escape("libdiscord_version"));
        sbU.append("\\].+))");
        regexExtractTombstone = new Regex(sbU.toString());
    }

    private SystemLogUtils() {
    }

    public static final /* synthetic */ void access$waitFor(SystemLogUtils systemLogUtils, Process process) throws InterruptedException {
        systemLogUtils.waitFor(process);
    }

    private final String hashString(String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
        Charset charset = Charsets2.a;
        Objects.requireNonNull(input, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = input.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics3.checkNotNullExpressionValue(bArrDigest, "bytes");
        return _Arrays.joinToString$default(bArrDigest, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AnonymousClass1.INSTANCE, 30, (Object) null);
    }

    private final void waitFor(Process process) throws InterruptedException {
        long nanos = TimeUnit.SECONDS.toNanos(15L) + System.nanoTime();
        do {
            try {
                process.exitValue();
                return;
            } catch (IllegalThreadStateException unused) {
                Thread.sleep(100L);
            }
        } while (System.nanoTime() < nanos);
    }

    public final String fetch() {
        StringBuilder sb = new StringBuilder();
        debugPrintables.debugPrint(sb);
        systemLogCapture.appendOutput(sb);
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public final Observable<Tombstone> fetchLastTombstone() {
        Observable observableA = fetch(regexExtractTombstone).A(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableA, "fetch(regexExtractTombst…ble.just(tombstone)\n    }");
        return observableA;
    }

    public final Tombstone fetchLastTombstone$app_productionGoogleRelease(Collection<String> crashes) {
        String str;
        List<String> groupValues;
        Intrinsics3.checkNotNullParameter(crashes, "crashes");
        String str2 = null;
        if (crashes.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str3 = null;
        String str4 = null;
        for (String str5 : crashes) {
            if (Strings4.contains$default((CharSequence) str5, (CharSequence) "libdiscord_version", false, 2, (Object) null)) {
                str3 = str5;
            } else {
                if (Strings4.contains$default((CharSequence) str5, (CharSequence) "*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***", false, 2, (Object) null)) {
                    StringBuilderJVM.clear(sb);
                    str4 = str3;
                }
                sb.append(str5);
                Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
                sb.append('\n');
                Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
            }
        }
        if (!StringsJVM.isBlank(sb)) {
            sb.append('\n');
            Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
            sb.append("Tombstone's libdiscord_version: ");
            if (str4 == null) {
                str4 = "Unknown libdiscord_version";
            }
            sb.append(str4);
            Intrinsics3.checkNotNullExpressionValue(sb, "append(value)");
            sb.append('\n');
            Intrinsics3.checkNotNullExpressionValue(sb, "append('\\n')");
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().also { s…\n      }\n    }.toString()");
        if (StringsJVM.isBlank(string)) {
            return null;
        }
        Regex5 regex5 = Regex5.MULTILINE;
        Regex regex = new Regex("^Cause: (.+)$", regex5);
        Sequence map = _Sequences2.map(Regex.findAll$default(new Regex("^\\s+#\\d+ pc .+/(.+? .+?)\\+?[+)]", regex5), string, 0, 2, null), new SystemLogUtils2(new Regex("classes\\d+.dex")));
        HashSet hashSetHashSetOf = Sets5.hashSetOf("libc.so (abort", "libart.so (art::Runtime::Abort(char const*", "libbase.so (android::base::LogMessage::~LogMessage(");
        try {
        } catch (NoSuchElementException unused) {
            str = "Unknown";
        }
        for (Object obj : map) {
            if (!hashSetHashSetOf.contains((String) obj)) {
                str = (String) obj;
                String strJoinToString$default = _Sequences2.joinToString$default(map, "\n", null, null, 0, null, null, 62, null);
                MatchResult matchResultFind$default = Regex.find$default(regex, string, 0, 2, null);
                if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                    str2 = groupValues.get(1);
                }
                return new Tombstone(string, str2, strJoinToString$default, str, hashString(strJoinToString$default), hashString(string));
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final DebugPrintable3 getDebugPrintables$app_productionGoogleRelease() {
        return debugPrintables;
    }

    public final Regex getRegexExtractTombstone$app_productionGoogleRelease() {
        return regexExtractTombstone;
    }

    public final Thread initSystemLogCapture() {
        return systemLogCapture.startThread();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        throw new java.util.NoSuchElementException("List contains no element matching the predicate.");
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void processLogs$app_productionGoogleRelease(BufferedReader reader, LinkedList<String> output, Regex filter) throws IOException {
        Intrinsics3.checkNotNullParameter(reader, "reader");
        Intrinsics3.checkNotNullParameter(output, "output");
        int i = 0;
        loop0: while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (filter != null) {
                    MatchResult matchResultFind$default = Regex.find$default(filter, line, 0, 2, null);
                    if (matchResultFind$default != null) {
                        List<String> groupValues = matchResultFind$default.getGroupValues();
                        ListIterator<String> listIterator = groupValues.listIterator(groupValues.size());
                        while (listIterator.hasPrevious()) {
                            String strPrevious = listIterator.previous();
                            if (strPrevious.length() > 0) {
                                line = strPrevious;
                            }
                        }
                        break loop0;
                    }
                    continue;
                }
                if (!StringsJVM.isBlank(line) && !Strings4.contains$default((CharSequence) line, (CharSequence) "Accessing hidden method", false, 2, (Object) null)) {
                    int length = line.length() + 1 + i;
                    try {
                        output.add(line);
                        if (length > maxLogSize) {
                            length -= output.pop().length() - 1;
                        }
                        i = length;
                    } catch (Exception e) {
                        e = e;
                        i = length;
                        e.printStackTrace();
                        if (filter == null) {
                            output.add("IOException: " + e);
                        }
                        if (i <= maxLogSize) {
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (i <= maxLogSize) {
            output.pop().length();
        }
    }

    private final Observable<LinkedList<String>> fetch(Regex filter) {
        LinkedList linkedList = new LinkedList();
        boolean z2 = filter == null;
        if (!new File(logcatPath).exists()) {
            if (z2) {
                linkedList.add("Unable to locate '/system/bin/logcat'");
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(linkedList);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(output)");
            return scalarSynchronousObservable;
        }
        Observable<LinkedList<String>> observableX = Observable.D(new AnonymousClass1(linkedList, filter, z2)).X(Schedulers2.b().d);
        Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.fromCallable …n(Schedulers.newThread())");
        return observableX;
    }
}
