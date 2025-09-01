package d0.z.d;

import java.io.Serializable;

/* compiled from: Lambda.kt */
/* renamed from: d0.z.d.o, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Lambda<R> implements FunctionBase<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // d0.z.d.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strRenderLambdaToString = Reflection2.renderLambdaToString((Lambda) this);
        Intrinsics3.checkNotNullExpressionValue(strRenderLambdaToString, "Reflection.renderLambdaToString(this)");
        return strRenderLambdaToString;
    }
}
