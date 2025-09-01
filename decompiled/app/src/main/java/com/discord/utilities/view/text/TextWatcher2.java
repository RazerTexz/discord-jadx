package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnLifecycleEvent;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0095\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012.\b\u0002\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014\u0012.\b\u0002\u0010\u0017\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u0016\u0012\u001c\b\u0002\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R<\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0015R<\u0010\u0017\u001a(\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013j\u0004\u0018\u0001`\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR*\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001d¨\u0006\""}, d2 = {"Lcom/discord/utilities/view/text/FragmentLifecycleTextWatcher;", "Landroid/text/TextWatcher;", "Landroidx/lifecycle/LifecycleObserver;", "", "onDestroyView", "()V", "", "s", "", "start", "count", "after", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Lkotlin/Function4;", "Lcom/discord/utilities/view/text/OnBeforeTextChanged;", "Lkotlin/jvm/functions/Function4;", "Lcom/discord/utilities/view/text/OnTextChanged;", "textChanged", "Landroid/widget/TextView;", "textView", "Landroid/widget/TextView;", "Lkotlin/Function1;", "Lcom/discord/utilities/view/text/OnAfterTextChanged;", "Lkotlin/jvm/functions/Function1;", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/widget/TextView;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;)V", "utils_release"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.text.FragmentLifecycleTextWatcher, reason: use source file name */
/* loaded from: classes2.dex */
public final class TextWatcher2 implements android.text.TextWatcher, LifecycleObserver {
    private final Function1<Editable, Unit> afterTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> beforeTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> textChanged;
    private final TextView textView;

    /* JADX WARN: Multi-variable type inference failed */
    public TextWatcher2(Fragment fragment, TextView textView, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(textView, "textView");
        this.textView = textView;
        this.beforeTextChanged = function4;
        this.textChanged = function42;
        this.afterTextChanged = function1;
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics3.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        viewLifecycleOwner.getLifecycle().addObserver(this);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function1<Editable, Unit> function1 = this.afterTextChanged;
        if (function1 != null) {
            function1.invoke(s2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.beforeTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroyView() {
        this.textView.removeTextChangedListener(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.textChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public /* synthetic */ TextWatcher2(Fragment fragment, TextView textView, Function4 function4, Function4 function42, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, textView, (i & 4) != 0 ? null : function4, (i & 8) != 0 ? null : function42, (i & 16) != 0 ? null : function1);
    }
}
