package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SharedPreferences.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"Landroid/content/SharedPreferences;", "", "commit", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "", "action", "edit", "(Landroid/content/SharedPreferences;ZLkotlin/jvm/functions/Function1;)V", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.content.SharedPreferencesKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SharedPreferences {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(android.content.SharedPreferences sharedPreferences, boolean z2, Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        function1.invoke(editorEdit);
        if (z2) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(android.content.SharedPreferences sharedPreferences, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        Intrinsics3.checkNotNullParameter(sharedPreferences, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        function1.invoke(editorEdit);
        if (z2) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
