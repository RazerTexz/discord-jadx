package com.discord.utilities.sms;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Base64;
import b.i.a.f.e.o.f;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppSignatureHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rR-\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/discord/utilities/sms/AppSignatureHelper;", "Landroid/content/ContextWrapper;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "appSignatures$delegate", "Lkotlin/Lazy;", "getAppSignatures", "()Ljava/util/ArrayList;", "appSignatures", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"PackageManagerGetSignatures"})
/* loaded from: classes2.dex */
public final class AppSignatureHelper extends ContextWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String HASH_TYPE = "SHA-256";
    private static final int NUM_BASE64_CHAR = 11;
    private static final int NUM_HASHED_BYTES = 9;
    private static final String TAG;

    /* renamed from: appSignatures$delegate, reason: from kotlin metadata */
    private final Lazy appSignatures;

    /* compiled from: AppSignatureHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/discord/utilities/sms/AppSignatureHelper$Companion;", "", "", "packageName", "signature", "hash", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "HASH_TYPE", "", "NUM_BASE64_CHAR", "I", "NUM_HASHED_BYTES", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ String access$hash(Companion companion, String str, String str2) {
            return companion.hash(str, str2);
        }

        private final String hash(String packageName, String signature) throws NoSuchAlgorithmException {
            String str = packageName + ' ' + signature;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                Intrinsics3.checkNotNullExpressionValue(messageDigest, "MessageDigest.getInstance(HASH_TYPE)");
                messageDigest.update(f.K(str));
                byte[] bArrDigest = messageDigest.digest();
                Intrinsics3.checkNotNullExpressionValue(bArrDigest, "messageDigest.digest()");
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, 9);
                Intrinsics3.checkNotNullExpressionValue(bArrCopyOfRange, "Arrays.copyOfRange(hashS…ure, 0, NUM_HASHED_BYTES)");
                String strEncodeToString = Base64.encodeToString(bArrCopyOfRange, 3);
                Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(ha…ADDING or Base64.NO_WRAP)");
                if (strEncodeToString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring = strEncodeToString.substring(0, 11);
                Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                AppLog appLog = AppLog.g;
                String tag = getTAG();
                String str2 = String.format("pkg: %s -- hash: %s", Arrays.copyOf(new Object[]{packageName, strSubstring}, 2));
                Intrinsics3.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
                Logger.d$default(appLog, tag, str2, null, 4, null);
                return strSubstring;
            } catch (NoSuchAlgorithmException e) {
                Logger.e$default(AppLog.g, getTAG(), "hash:NoSuchAlgorithm", e, null, 8, null);
                return null;
            }
        }

        public final String getTAG() {
            return AppSignatureHelper.access$getTAG$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = AppSignatureHelper.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "AppSignatureHelper::class.java.simpleName");
        TAG = simpleName;
    }

    public AppSignatureHelper(Context context) {
        super(context);
        this.appSignatures = LazyJVM.lazy(new AppSignatureHelper2(this));
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final ArrayList<String> getAppSignatures() {
        return (ArrayList) this.appSignatures.getValue();
    }
}
