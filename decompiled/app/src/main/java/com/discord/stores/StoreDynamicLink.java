package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import b.a.d.m0.RoutingPatterns;
import b.a.e.Backgrounded4;
import b.d.b.a.outline;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreDynamicLink.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/discord/stores/StoreDynamicLink;", "", "Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", "data", "Landroid/content/Context;", "context", "", "handleDataReceived", "(Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;Landroid/content/Context;)V", "Landroid/content/Intent;", "intent", "Lrx/Observable;", "Landroid/net/Uri;", "getDynamicLinkObservable", "(Landroid/content/Intent;)Lrx/Observable;", "storeLinkIfExists", "(Landroid/content/Intent;Landroid/content/Context;)V", "Lcom/discord/stores/StoreStream;", "stream", "Lcom/discord/stores/StoreStream;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "<init>", "(Lcom/discord/stores/StoreStream;Lcom/discord/stores/Dispatcher;)V", "Companion", "DynamicLinkData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreDynamicLink {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long DYNAMIC_LINK_TIMEOUT_MS = 1000;
    private final Dispatcher dispatcher;
    private final StoreStream stream;

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/stores/StoreDynamicLink$Companion;", "", "", "DYNAMIC_LINK_TIMEOUT_MS", "J", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001BI\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ^\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\bR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001f\u0010\bR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b \u0010\bR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b!\u0010\bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010\u0004R!\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b$\u0010\b¨\u0006'"}, d2 = {"Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", "", "Landroid/net/Uri;", "component1", "()Landroid/net/Uri;", "", "Lcom/discord/primitives/FingerPrint;", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "fingerprint", "attemptId", "inviteCode", "guildTemplateCode", "authToken", "copy", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getAttemptId", "getInviteCode", "getGuildTemplateCode", "getAuthToken", "Landroid/net/Uri;", "getUri", "getFingerprint", "<init>", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DynamicLinkData {
        private final String attemptId;
        private final String authToken;
        private final String fingerprint;
        private final String guildTemplateCode;
        private final String inviteCode;
        private final Uri uri;

        public DynamicLinkData(Uri uri, String str, String str2, String str3, String str4, String str5) {
            this.uri = uri;
            this.fingerprint = str;
            this.attemptId = str2;
            this.inviteCode = str3;
            this.guildTemplateCode = str4;
            this.authToken = str5;
        }

        public static /* synthetic */ DynamicLinkData copy$default(DynamicLinkData dynamicLinkData, Uri uri, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = dynamicLinkData.uri;
            }
            if ((i & 2) != 0) {
                str = dynamicLinkData.fingerprint;
            }
            String str6 = str;
            if ((i & 4) != 0) {
                str2 = dynamicLinkData.attemptId;
            }
            String str7 = str2;
            if ((i & 8) != 0) {
                str3 = dynamicLinkData.inviteCode;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = dynamicLinkData.guildTemplateCode;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = dynamicLinkData.authToken;
            }
            return dynamicLinkData.copy(uri, str6, str7, str8, str9, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final Uri getUri() {
            return this.uri;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFingerprint() {
            return this.fingerprint;
        }

        /* renamed from: component3, reason: from getter */
        public final String getAttemptId() {
            return this.attemptId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getInviteCode() {
            return this.inviteCode;
        }

        /* renamed from: component5, reason: from getter */
        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        /* renamed from: component6, reason: from getter */
        public final String getAuthToken() {
            return this.authToken;
        }

        public final DynamicLinkData copy(Uri uri, String fingerprint, String attemptId, String inviteCode, String guildTemplateCode, String authToken) {
            return new DynamicLinkData(uri, fingerprint, attemptId, inviteCode, guildTemplateCode, authToken);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DynamicLinkData)) {
                return false;
            }
            DynamicLinkData dynamicLinkData = (DynamicLinkData) other;
            return Intrinsics3.areEqual(this.uri, dynamicLinkData.uri) && Intrinsics3.areEqual(this.fingerprint, dynamicLinkData.fingerprint) && Intrinsics3.areEqual(this.attemptId, dynamicLinkData.attemptId) && Intrinsics3.areEqual(this.inviteCode, dynamicLinkData.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, dynamicLinkData.guildTemplateCode) && Intrinsics3.areEqual(this.authToken, dynamicLinkData.authToken);
        }

        public final String getAttemptId() {
            return this.attemptId;
        }

        public final String getAuthToken() {
            return this.authToken;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }

        public final String getGuildTemplateCode() {
            return this.guildTemplateCode;
        }

        public final String getInviteCode() {
            return this.inviteCode;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public int hashCode() {
            Uri uri = this.uri;
            int iHashCode = (uri != null ? uri.hashCode() : 0) * 31;
            String str = this.fingerprint;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.attemptId;
            int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.inviteCode;
            int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.guildTemplateCode;
            int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.authToken;
            return iHashCode5 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DynamicLinkData(uri=");
            sbU.append(this.uri);
            sbU.append(", fingerprint=");
            sbU.append(this.fingerprint);
            sbU.append(", attemptId=");
            sbU.append(this.attemptId);
            sbU.append(", inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", guildTemplateCode=");
            sbU.append(this.guildTemplateCode);
            sbU.append(", authToken=");
            return outline.J(sbU, this.authToken, ")");
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Landroid/net/Uri;", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Throwable;)Landroid/net/Uri;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$getDynamicLinkObservable$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Throwable, Uri> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Uri call(Throwable th) {
            return call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Uri call2(Throwable th) {
            return Uri.EMPTY;
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$handleDataReceived$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DynamicLinkData $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DynamicLinkData dynamicLinkData) {
            super(0);
            this.$data = dynamicLinkData;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreAuthentication authentication = StoreDynamicLink.access$getStream$p(StoreDynamicLink.this).getAuthentication();
            DynamicLinkData dynamicLinkData = this.$data;
            authentication.setFingerprint(dynamicLinkData != null ? dynamicLinkData.getFingerprint() : null, false);
            DynamicLinkData dynamicLinkData2 = this.$data;
            if ((dynamicLinkData2 != null ? dynamicLinkData2.getAuthToken() : null) != null) {
                StoreDynamicLink.access$getStream$p(StoreDynamicLink.this).getAuthentication().setAuthed(this.$data.getAuthToken());
            }
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/net/Uri;", "kotlin.jvm.PlatformType", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", NotificationCompat.CATEGORY_CALL, "(Landroid/net/Uri;)Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Uri, DynamicLinkData> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ DynamicLinkData call(Uri uri) {
            return call2(uri);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0112  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final DynamicLinkData call2(Uri uri) {
            String str;
            String str2;
            String queryParameter;
            String queryParameter2;
            List<String> groupValues;
            String strPrevious;
            String path;
            List<String> groupValues2;
            String strPrevious2;
            String path2;
            String queryParameter3 = null;
            if (Intrinsics3.areEqual(uri, Uri.EMPTY)) {
                return null;
            }
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Uri uri2 = intentUtils.isHttpDomainUrl(uri) ? uri : null;
            RoutingPatterns routingPatterns = RoutingPatterns.G;
            Intrinsics3.checkNotNullParameter(uri, "$this$isInviteLink");
            boolean z2 = false;
            if (StringsJVM.equals(uri.getHost(), RoutingPatterns.d, true) || ((StringsJVM.equals(uri.getHost(), RoutingPatterns.a, true) || StringsJVM.equals(uri.getHost(), RoutingPatterns.f60b, true)) && (path2 = uri.getPath()) != null && RoutingPatterns.n.matches(path2))) {
                Regex regex = RoutingPatterns.n;
                String path3 = uri.getPath();
                if (path3 == null) {
                    path3 = "";
                }
                Intrinsics3.checkNotNullExpressionValue(path3, "uri.path ?: \"\"");
                MatchResult matchResultMatchEntire = regex.matchEntire(path3);
                if (matchResultMatchEntire == null || (groupValues2 = matchResultMatchEntire.getGroupValues()) == null) {
                    str = null;
                } else {
                    ListIterator<String> listIterator = groupValues2.listIterator(groupValues2.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            strPrevious2 = null;
                            break;
                        }
                        strPrevious2 = listIterator.previous();
                        if (!StringsJVM.isBlank(strPrevious2)) {
                            break;
                        }
                    }
                    str = strPrevious2;
                }
            }
            RoutingPatterns routingPatterns2 = RoutingPatterns.G;
            Intrinsics3.checkNotNullParameter(uri, "$this$isGuildTemplateLink");
            if (StringsJVM.equals(uri.getHost(), RoutingPatterns.e, true) || ((StringsJVM.equals(uri.getHost(), RoutingPatterns.a, true) || StringsJVM.equals(uri.getHost(), RoutingPatterns.f60b, true)) && (path = uri.getPath()) != null && RoutingPatterns.p.matches(path))) {
                z2 = true;
            }
            if (z2) {
                Regex regex2 = RoutingPatterns.p;
                String path4 = uri.getPath();
                String str3 = path4 != null ? path4 : "";
                Intrinsics3.checkNotNullExpressionValue(str3, "uri.path ?: \"\"");
                MatchResult matchResultMatchEntire2 = regex2.matchEntire(str3);
                if (matchResultMatchEntire2 == null || (groupValues = matchResultMatchEntire2.getGroupValues()) == null) {
                    str2 = null;
                } else {
                    ListIterator<String> listIterator2 = groupValues.listIterator(groupValues.size());
                    while (true) {
                        if (!listIterator2.hasPrevious()) {
                            strPrevious = null;
                            break;
                        }
                        strPrevious = listIterator2.previous();
                        if (!StringsJVM.isBlank(strPrevious)) {
                            break;
                        }
                    }
                    str2 = strPrevious;
                }
            }
            try {
                queryParameter = uri.getQueryParameter("fingerprint");
            } catch (Exception unused) {
                queryParameter = null;
            }
            try {
                queryParameter2 = uri.getQueryParameter("attemptId");
            } catch (Exception unused2) {
                queryParameter2 = null;
            }
            try {
                queryParameter3 = uri.getQueryParameter("auth_token");
            } catch (Exception unused3) {
            }
            return new DynamicLinkData(uri2, queryParameter, queryParameter2, str, str2, queryParameter3);
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", "it", "", NotificationCompat.CATEGORY_CALL, "(Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<DynamicLinkData> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(DynamicLinkData dynamicLinkData) {
            call2(dynamicLinkData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(DynamicLinkData dynamicLinkData) {
            if (dynamicLinkData != null) {
                AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                String fingerprint = dynamicLinkData.getFingerprint();
                String attemptId = dynamicLinkData.getAttemptId();
                String inviteCode = dynamicLinkData.getInviteCode();
                String guildTemplateCode = dynamicLinkData.getGuildTemplateCode();
                String authToken = dynamicLinkData.getAuthToken();
                Backgrounded4 backgrounded4 = Backgrounded4.d;
                analyticsTracker.externalDynamicLinkReceived(fingerprint, attemptId, inviteCode, guildTemplateCode, authToken, Backgrounded4.a);
            }
        }
    }

    /* compiled from: StoreDynamicLink.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;", "dynamicLinkData", "", "invoke", "(Lcom/discord/stores/StoreDynamicLink$DynamicLinkData;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreDynamicLink$storeLinkIfExists$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<DynamicLinkData, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DynamicLinkData dynamicLinkData) {
            invoke2(dynamicLinkData);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DynamicLinkData dynamicLinkData) {
            StoreDynamicLink.access$handleDataReceived(StoreDynamicLink.this, dynamicLinkData, this.$context);
        }
    }

    public StoreDynamicLink(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreDynamicLink storeDynamicLink) {
        return storeDynamicLink.stream;
    }

    public static final /* synthetic */ void access$handleDataReceived(StoreDynamicLink storeDynamicLink, DynamicLinkData dynamicLinkData, Context context) {
        storeDynamicLink.handleDataReceived(dynamicLinkData, context);
    }

    private final Observable<Uri> getDynamicLinkObservable(Intent intent) {
        Observable observableO = Observable.o(new StoreDynamicLink2(intent), Emitter.BackpressureMode.BUFFER);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({\n    ….BackpressureMode.BUFFER)");
        Observable<Uri> observableM = Observable.I(new ScalarSynchronousObservable(Uri.EMPTY).q(1000L, TimeUnit.MILLISECONDS), observableO).M(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM, "Observable\n        .merg…ErrorReturn { Uri.EMPTY }");
        return observableM;
    }

    private final void handleDataReceived(DynamicLinkData data, Context context) {
        String guildTemplateCode;
        String inviteCode;
        this.dispatcher.schedule(new AnonymousClass1(data));
        if (data != null && (inviteCode = data.getInviteCode()) != null && (!StringsJVM.isBlank(inviteCode))) {
            IntentUtils.RouteBuilders routeBuilders = IntentUtils.RouteBuilders.INSTANCE;
            String inviteCode2 = data.getInviteCode();
            Objects.requireNonNull(inviteCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders.selectInvite(Strings4.trim(inviteCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if (data != null && (guildTemplateCode = data.getGuildTemplateCode()) != null && (!StringsJVM.isBlank(guildTemplateCode))) {
            IntentUtils.RouteBuilders routeBuilders2 = IntentUtils.RouteBuilders.INSTANCE;
            String guildTemplateCode2 = data.getGuildTemplateCode();
            Objects.requireNonNull(guildTemplateCode2, "null cannot be cast to non-null type kotlin.CharSequence");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, routeBuilders2.selectGuildTemplate(Strings4.trim(guildTemplateCode2).toString(), StoreInviteSettings.LOCATION_DEEPLINK), context, null, 4, null);
            return;
        }
        if ((data != null ? data.getUri() : null) != null) {
            Intent data2 = new Intent().setData(data.getUri());
            Intrinsics3.checkNotNullExpressionValue(data2, "Intent().setData(data.uri)");
            IntentUtils.consumeRoutingIntent$default(IntentUtils.INSTANCE, data2, context, null, 4, null);
        }
    }

    public final void storeLinkIfExists(Intent intent, Context context) {
        Intrinsics3.checkNotNullParameter(intent, "intent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Observable<R> observableG = getDynamicLinkObservable(intent).G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "getDynamicLinkObservable…ode, authToken)\n        }");
        Observable observableU = ObservableExtensionsKt.computationBuffered(observableG).r().u(AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableU, "getDynamicLinkObservable…  )\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableU, StoreDynamicLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(context), 62, (Object) null);
    }
}
