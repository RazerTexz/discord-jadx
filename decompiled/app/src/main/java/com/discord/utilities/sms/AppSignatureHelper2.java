package com.discord.utilities.sms;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.sms.AppSignatureHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: AppSignatureHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invoke", "()Ljava/util/ArrayList;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.sms.AppSignatureHelper$appSignatures$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AppSignatureHelper2 extends Lambda implements Function0<ArrayList<String>> {
    public final /* synthetic */ AppSignatureHelper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSignatureHelper2(AppSignatureHelper appSignatureHelper) {
        super(0);
        this.this$0 = appSignatureHelper;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ArrayList<String> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ArrayList<String> invoke2() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String packageName = this.this$0.getPackageName();
            Signature[] signatureArr = this.this$0.getPackageManager().getPackageInfo(packageName, 64).signatures;
            Intrinsics3.checkNotNullExpressionValue(signatureArr, "packageManager.getPackag…ATURES\n      ).signatures");
            ArrayList<String> arrayList2 = new ArrayList();
            for (Signature signature : signatureArr) {
                AppSignatureHelper.Companion companion = AppSignatureHelper.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(packageName, "packageName");
                String charsString = signature.toCharsString();
                Intrinsics3.checkNotNullExpressionValue(charsString, "signature.toCharsString()");
                String strAccess$hash = AppSignatureHelper.Companion.access$hash(companion, packageName, charsString);
                if (strAccess$hash != null) {
                    arrayList2.add(strAccess$hash);
                }
            }
            for (String str : arrayList2) {
                arrayList.add(str);
                Logger.d$default(AppLog.g, AppSignatureHelper.INSTANCE.getTAG(), "Hash " + str, null, 4, null);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e$default(AppLog.g, AppSignatureHelper.INSTANCE.getTAG(), "Unable to find package to obtain hash.", e, null, 8, null);
        }
        return arrayList;
    }
}
