package b.i.a.c.b3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import androidx.core.view.ViewCompat;
import b.i.a.c.Bundleable;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Bundleable.a {
    public static final /* synthetic */ a a = new a();

    @Override // b.i.a.c.Bundleable.a
    public final Bundleable a(Bundle bundle) {
        float f;
        int i;
        int i2;
        float f2;
        boolean z2;
        int i3;
        CharSequence charSequence = bundle.getCharSequence(Cue.b(0));
        CharSequence charSequence2 = charSequence != null ? charSequence : null;
        Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(Cue.b(1));
        Layout.Alignment alignment2 = alignment != null ? alignment : null;
        Layout.Alignment alignment3 = (Layout.Alignment) bundle.getSerializable(Cue.b(2));
        Layout.Alignment alignment4 = alignment3 != null ? alignment3 : null;
        Bitmap bitmap = (Bitmap) bundle.getParcelable(Cue.b(3));
        Bitmap bitmap2 = bitmap != null ? bitmap : null;
        if (bundle.containsKey(Cue.b(4)) && bundle.containsKey(Cue.b(5))) {
            f = bundle.getFloat(Cue.b(4));
            i = bundle.getInt(Cue.b(5));
        } else {
            f = -3.4028235E38f;
            i = Integer.MIN_VALUE;
        }
        int i4 = bundle.containsKey(Cue.b(6)) ? bundle.getInt(Cue.b(6)) : Integer.MIN_VALUE;
        float f3 = bundle.containsKey(Cue.b(7)) ? bundle.getFloat(Cue.b(7)) : -3.4028235E38f;
        int i5 = bundle.containsKey(Cue.b(8)) ? bundle.getInt(Cue.b(8)) : Integer.MIN_VALUE;
        if (bundle.containsKey(Cue.b(10)) && bundle.containsKey(Cue.b(9))) {
            f2 = bundle.getFloat(Cue.b(10));
            i2 = bundle.getInt(Cue.b(9));
        } else {
            i2 = Integer.MIN_VALUE;
            f2 = -3.4028235E38f;
        }
        float f4 = bundle.containsKey(Cue.b(11)) ? bundle.getFloat(Cue.b(11)) : -3.4028235E38f;
        float f5 = bundle.containsKey(Cue.b(12)) ? bundle.getFloat(Cue.b(12)) : -3.4028235E38f;
        if (bundle.containsKey(Cue.b(13))) {
            i3 = bundle.getInt(Cue.b(13));
            z2 = true;
        } else {
            z2 = false;
            i3 = ViewCompat.MEASURED_STATE_MASK;
        }
        return new Cue(charSequence2, alignment2, alignment4, bitmap2, f, i, i4, f3, i5, i2, f2, f4, f5, bundle.getBoolean(Cue.b(14), false) ? z2 : false, i3, bundle.containsKey(Cue.b(15)) ? bundle.getInt(Cue.b(15)) : Integer.MIN_VALUE, bundle.containsKey(Cue.b(16)) ? bundle.getFloat(Cue.b(16)) : 0.0f, null);
    }
}
