package d0.e0;

import java.util.List;
import kotlin.reflect.KType;

/* compiled from: KTypeParameter.kt */
/* renamed from: d0.e0.h, reason: use source file name */
/* loaded from: classes3.dex */
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();
}
