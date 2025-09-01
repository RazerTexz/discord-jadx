package com.discord.utilities.analytics;

import android.util.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.b0.ObservableProperty;
import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* compiled from: Delegates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kotlin/properties/Delegates$observable$1", "Ld0/b0/a;", "Lkotlin/reflect/KProperty;", "property", "oldValue", "newValue", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.analytics.AnalyticSuperProperties$$special$$inlined$observable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class Delegates extends ObservableProperty<Map<String, ? extends Object>> {
    public final /* synthetic */ Object $initialValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Delegates(Object obj, Object obj2) {
        super(obj2);
        this.$initialValue = obj;
    }

    @Override // d0.b0.ObservableProperty
    public void afterChange(KProperty<?> property, Map<String, ? extends Object> oldValue, Map<String, ? extends Object> newValue) throws JsonIOException {
        Intrinsics3.checkNotNullParameter(property, "property");
        AnalyticSuperProperties analyticSuperProperties = AnalyticSuperProperties.INSTANCE;
        String strM = new Gson().m(newValue);
        if (strM == null) {
            strM = "{}";
        }
        AnalyticSuperProperties.access$setSuperPropertiesString$p(analyticSuperProperties, strM);
        String superPropertiesString = analyticSuperProperties.getSuperPropertiesString();
        Charset charset = Charsets2.a;
        Objects.requireNonNull(superPropertiesString, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = superPropertiesString.getBytes(charset);
        Intrinsics3.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        Intrinsics3.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(su…eArray(), Base64.NO_WRAP)");
        AnalyticSuperProperties.access$setSuperPropertiesStringBase64$p(analyticSuperProperties, strEncodeToString);
    }
}
