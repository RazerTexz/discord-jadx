package b.a.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import d0.z.d.Intrinsics3;

/* compiled from: ChipsEditText.kt */
@SuppressLint({"ViewConstructor"})
/* renamed from: b.a.f.d, reason: use source file name */
/* loaded from: classes.dex */
public final class ChipsEditText extends AppCompatEditText {
    public final a j;

    /* compiled from: ChipsEditText.kt */
    /* renamed from: b.a.f.d$a */
    public interface a {
        InputConnection a(InputConnection inputConnection);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChipsEditText(Context context, a aVar) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(aVar, "mInputConnectionWrapperInterface");
        this.j = aVar;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Intrinsics3.checkNotNullParameter(editorInfo, "outAttrs");
        return this.j.a(super.onCreateInputConnection(editorInfo));
    }
}
