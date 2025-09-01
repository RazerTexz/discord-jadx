package com.discord.stores;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreEmoji.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "invoke", "(Ljava/lang/String;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.stores.StoreEmoji$compileSurrogatesPattern$emojiSurrogatesPattern$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreEmoji2 extends Lambda implements Function1<String, CharSequence> {
    public static final StoreEmoji2 INSTANCE = new StoreEmoji2();

    public StoreEmoji2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(String str) {
        return invoke2(str);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        String strQuote = Pattern.quote(str);
        Intrinsics3.checkNotNullExpressionValue(strQuote, "Pattern.quote(it)");
        return strQuote;
    }
}
