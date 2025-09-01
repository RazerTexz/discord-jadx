package com.discord.utilities.rest;

import android.os.Build;
import android.os.LocaleList;
import d0.d0._Ranges;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: RestAPI.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.rest.RestAPI$AppHeadersProvider$acceptLanguageProvider$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RestAPI2 extends Lambda implements Function0<String> {
    public static final RestAPI2 INSTANCE = new RestAPI2();

    public RestAPI2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            Intrinsics3.checkNotNullExpressionValue(adjustedDefault, "LocaleList.getAdjustedDefault()");
            int iCoerceAtLeast = 10;
            int size = adjustedDefault.size();
            for (int i = 0; i < size; i++) {
                String languageTag = adjustedDefault.get(i).toLanguageTag();
                if (i != 0) {
                    arrayList.add(languageTag + ";q=0." + iCoerceAtLeast);
                } else {
                    arrayList.add(languageTag);
                }
                iCoerceAtLeast = _Ranges.coerceAtLeast(1, iCoerceAtLeast - 1);
            }
        } else {
            arrayList.add(Locale.getDefault().toLanguageTag());
        }
        return _Collections.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
    }
}
