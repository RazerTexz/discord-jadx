package b.g.a.c.b0;

import b.g.a.c.PropertyName;
import b.g.a.c.c0.Annotated;
import b.g.a.c.c0.AnnotatedParameter;
import b.g.a.c.c0.AnnotatedWithParams;
import java.beans.ConstructorProperties;
import java.beans.Transient;

/* compiled from: Java7SupportImpl.java */
/* renamed from: b.g.a.c.b0.d, reason: use source file name */
/* loaded from: classes3.dex */
public class Java7SupportImpl extends Java7Support {
    @Override // b.g.a.c.b0.Java7Support
    public PropertyName a(AnnotatedParameter annotatedParameter) {
        ConstructorProperties constructorPropertiesB;
        AnnotatedWithParams annotatedWithParams = annotatedParameter._owner;
        if (annotatedWithParams == null || (constructorPropertiesB = annotatedWithParams.b(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] strArrValue = constructorPropertiesB.value();
        int i = annotatedParameter._index;
        if (i < strArrValue.length) {
            return PropertyName.a(strArrValue[i]);
        }
        return null;
    }

    @Override // b.g.a.c.b0.Java7Support
    public Boolean b(Annotated annotated) {
        Transient transientB = annotated.b(Transient.class);
        if (transientB != null) {
            return Boolean.valueOf(transientB.value());
        }
        return null;
    }

    @Override // b.g.a.c.b0.Java7Support
    public Boolean c(Annotated annotated) {
        if (annotated.b(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }
}
