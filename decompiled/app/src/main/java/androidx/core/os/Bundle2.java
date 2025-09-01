package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Tuples2;

/* compiled from: Bundle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lkotlin/Pair;", "", "", "pairs", "Landroid/os/Bundle;", "bundleOf", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.os.BundleKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Bundle2 {
    public static final Bundle bundleOf(Tuples2<String, ? extends Object>... tuples2Arr) {
        Intrinsics3.checkNotNullParameter(tuples2Arr, "pairs");
        Bundle bundle = new Bundle(tuples2Arr.length);
        int length = tuples2Arr.length;
        int i = 0;
        while (i < length) {
            Tuples2<String, ? extends Object> tuples2 = tuples2Arr[i];
            i++;
            String strComponent1 = tuples2.component1();
            Object objComponent2 = tuples2.component2();
            if (objComponent2 == null) {
                bundle.putString(strComponent1, null);
            } else if (objComponent2 instanceof Boolean) {
                bundle.putBoolean(strComponent1, ((Boolean) objComponent2).booleanValue());
            } else if (objComponent2 instanceof Byte) {
                bundle.putByte(strComponent1, ((Number) objComponent2).byteValue());
            } else if (objComponent2 instanceof Character) {
                bundle.putChar(strComponent1, ((Character) objComponent2).charValue());
            } else if (objComponent2 instanceof Double) {
                bundle.putDouble(strComponent1, ((Number) objComponent2).doubleValue());
            } else if (objComponent2 instanceof Float) {
                bundle.putFloat(strComponent1, ((Number) objComponent2).floatValue());
            } else if (objComponent2 instanceof Integer) {
                bundle.putInt(strComponent1, ((Number) objComponent2).intValue());
            } else if (objComponent2 instanceof Long) {
                bundle.putLong(strComponent1, ((Number) objComponent2).longValue());
            } else if (objComponent2 instanceof Short) {
                bundle.putShort(strComponent1, ((Number) objComponent2).shortValue());
            } else if (objComponent2 instanceof Bundle) {
                bundle.putBundle(strComponent1, (Bundle) objComponent2);
            } else if (objComponent2 instanceof CharSequence) {
                bundle.putCharSequence(strComponent1, (CharSequence) objComponent2);
            } else if (objComponent2 instanceof Parcelable) {
                bundle.putParcelable(strComponent1, (Parcelable) objComponent2);
            } else if (objComponent2 instanceof boolean[]) {
                bundle.putBooleanArray(strComponent1, (boolean[]) objComponent2);
            } else if (objComponent2 instanceof byte[]) {
                bundle.putByteArray(strComponent1, (byte[]) objComponent2);
            } else if (objComponent2 instanceof char[]) {
                bundle.putCharArray(strComponent1, (char[]) objComponent2);
            } else if (objComponent2 instanceof double[]) {
                bundle.putDoubleArray(strComponent1, (double[]) objComponent2);
            } else if (objComponent2 instanceof float[]) {
                bundle.putFloatArray(strComponent1, (float[]) objComponent2);
            } else if (objComponent2 instanceof int[]) {
                bundle.putIntArray(strComponent1, (int[]) objComponent2);
            } else if (objComponent2 instanceof long[]) {
                bundle.putLongArray(strComponent1, (long[]) objComponent2);
            } else if (objComponent2 instanceof short[]) {
                bundle.putShortArray(strComponent1, (short[]) objComponent2);
            } else if (objComponent2 instanceof Object[]) {
                Class<?> componentType = objComponent2.getClass().getComponentType();
                Intrinsics3.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(strComponent1, (Parcelable[]) objComponent2);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(strComponent1, (String[]) objComponent2);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(strComponent1, (CharSequence[]) objComponent2);
                } else {
                    if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + ((Object) componentType.getCanonicalName()) + " for key \"" + strComponent1 + '\"');
                    }
                    bundle.putSerializable(strComponent1, (Serializable) objComponent2);
                }
            } else if (objComponent2 instanceof Serializable) {
                bundle.putSerializable(strComponent1, (Serializable) objComponent2);
            } else if (objComponent2 instanceof IBinder) {
                bundle.putBinder(strComponent1, (IBinder) objComponent2);
            } else if (objComponent2 instanceof Size) {
                bundle.putSize(strComponent1, (Size) objComponent2);
            } else {
                if (!(objComponent2 instanceof SizeF)) {
                    throw new IllegalArgumentException("Illegal value type " + ((Object) objComponent2.getClass().getCanonicalName()) + " for key \"" + strComponent1 + '\"');
                }
                bundle.putSizeF(strComponent1, (SizeF) objComponent2);
            }
        }
        return bundle;
    }
}
