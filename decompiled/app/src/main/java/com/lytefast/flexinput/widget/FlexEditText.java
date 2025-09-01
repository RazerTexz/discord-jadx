package com.lytefast.flexinput.widget;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import b.b.a.i.FlexEditText2;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: FlexEditText.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR.\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R6\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Lcom/lytefast/flexinput/widget/FlexEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/view/inputmethod/EditorInfo;", "editorInfo", "Landroid/view/inputmethod/InputConnection;", "onCreateInputConnection", "(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;", "", "start", "end", "", "onSelectionChanged", "(II)V", "maxLines", "setMaxLines", "(I)V", "Lkotlin/Function1;", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "j", "Lkotlin/jvm/functions/Function1;", "getInputContentHandler", "()Lkotlin/jvm/functions/Function1;", "setInputContentHandler", "(Lkotlin/jvm/functions/Function1;)V", "inputContentHandler", "l", "getOnMaxLinesChangedListener", "setOnMaxLinesChangedListener", "onMaxLinesChangedListener", "Lkotlin/Function2;", "k", "Lkotlin/jvm/functions/Function2;", "getOnSelectionChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionChangedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "flexinput_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class FlexEditText extends AppCompatEditText {

    /* renamed from: j, reason: from kotlin metadata */
    public Function1<? super InputContentInfoCompat, Unit> inputContentHandler;

    /* renamed from: k, reason: from kotlin metadata */
    public Function2<? super Integer, ? super Integer, Unit> onSelectionChangedListener;

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> onMaxLinesChangedListener;

    /* compiled from: FlexEditText.kt */
    public static final class a implements InputConnectionCompat.OnCommitContentListener {
        public a(EditorInfo editorInfo) {
        }

        @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
        public final boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                } catch (Exception unused) {
                    return false;
                }
            }
            Function1<InputContentInfoCompat, Unit> inputContentHandler = FlexEditText.this.getInputContentHandler();
            Intrinsics3.checkNotNullExpressionValue(inputContentInfoCompat, "inputContentInfo");
            inputContentHandler.invoke(inputContentInfoCompat);
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.inputContentHandler = new FlexEditText2(this);
    }

    public final Function1<InputContentInfoCompat, Unit> getInputContentHandler() {
        return this.inputContentHandler;
    }

    public final Function1<Integer, Unit> getOnMaxLinesChangedListener() {
        return this.onMaxLinesChangedListener;
    }

    public final Function2<Integer, Integer, Unit> getOnSelectionChangedListener() {
        return this.onSelectionChangedListener;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Intrinsics3.checkNotNullParameter(editorInfo, "editorInfo");
        InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (inputConnectionOnCreateInputConnection == null) {
            return null;
        }
        EditorInfoCompat.setContentMimeTypes(editorInfo, new String[]{"image/*"});
        return InputConnectionCompat.createWrapper(inputConnectionOnCreateInputConnection, editorInfo, new a(editorInfo));
    }

    @Override // android.widget.TextView
    public void onSelectionChanged(int start, int end) {
        super.onSelectionChanged(start, end);
        Function2<? super Integer, ? super Integer, Unit> function2 = this.onSelectionChangedListener;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(start), Integer.valueOf(end));
        }
    }

    public final void setInputContentHandler(Function1<? super InputContentInfoCompat, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.inputContentHandler = function1;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int maxLines) {
        super.setMaxLines(maxLines);
        Function1<? super Integer, Unit> function1 = this.onMaxLinesChangedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(maxLines));
        }
    }

    public final void setOnMaxLinesChangedListener(Function1<? super Integer, Unit> function1) {
        this.onMaxLinesChangedListener = function1;
    }

    public final void setOnSelectionChangedListener(Function2<? super Integer, ? super Integer, Unit> function2) {
        this.onSelectionChangedListener = function2;
    }
}
