package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TextWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a3\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bj\u0002`\nH\u0007¢\u0006\u0004\b\u0006\u0010\f\u001a-\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\u000f\u0010\f\"\u0097\u0001\u0010\u0014\u001a\u0082\u0001\u0012\u0004\u0012\u00020\u0001\u00126\u00124\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0010j\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u0013`\u00120\u0010j@\u0012\u0004\u0012\u00020\u0001\u00126\u00124\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0010j\u001e\u0012\u0004\u0012\u00020\u0000\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0011j\b\u0012\u0004\u0012\u00020\u0003`\u0013`\u0012`\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015*$\b\u0002\u0010\u0016\"\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b*H\b\u0002\u0010\u001a\" \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u00172 \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0017*H\b\u0002\u0010\u001b\" \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u00172 \u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0017¨\u0006\u001c"}, d2 = {"Landroid/widget/TextView;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/text/TextWatcher;", "textWatcher", "", "addBindedTextWatcher", "(Landroid/widget/TextView;Landroidx/fragment/app/Fragment;Landroid/text/TextWatcher;)V", "Lkotlin/Function1;", "Landroid/text/Editable;", "Lcom/discord/utilities/view/text/OnAfterTextChanged;", "onAfterTextChanged", "(Landroid/widget/TextView;Landroidx/fragment/app/Fragment;Lkotlin/jvm/functions/Function1;)V", "", "afterTextChanged", "addLifecycleAwareTextWatcher", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "bindedTextWatchers", "Ljava/util/HashMap;", "OnAfterTextChanged", "Lkotlin/Function4;", "", "", "OnBeforeTextChanged", "OnTextChanged", "utils_release"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.view.text.TextWatcherKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class TextWatcher4 {
    private static final HashMap<Fragment, HashMap<TextView, ArrayList<android.text.TextWatcher>>> bindedTextWatchers = new HashMap<>();

    /* compiled from: TextWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.view.text.TextWatcherKt$addLifecycleAwareTextWatcher$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public final /* synthetic */ Function1 $afterTextChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$afterTextChanged = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            this.$afterTextChanged.invoke(editable.toString());
        }
    }

    public static final /* synthetic */ HashMap access$getBindedTextWatchers$p() {
        return bindedTextWatchers;
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, android.text.TextWatcher textWatcher) {
        Intrinsics3.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(textWatcher, "textWatcher");
        HashMap<Fragment, HashMap<TextView, ArrayList<android.text.TextWatcher>>> map = bindedTextWatchers;
        HashMap<TextView, ArrayList<android.text.TextWatcher>> map2 = map.get(fragment);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        ArrayList<android.text.TextWatcher> arrayList = map2.get(textView);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        map.put(fragment, map2);
        HashMap<TextView, ArrayList<android.text.TextWatcher>> map3 = map.get(fragment);
        if (map3 != null) {
            map3.put(textView, arrayList);
        }
        arrayList.add(textWatcher);
        textView.addTextChangedListener(textWatcher);
    }

    public static final void addLifecycleAwareTextWatcher(TextView textView, Fragment fragment, Function1<? super String, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "$this$addLifecycleAwareTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "afterTextChanged");
        textView.addTextChangedListener(new TextWatcher2(fragment, textView, null, null, new AnonymousClass1(function1), 12, null));
    }

    public static final void addBindedTextWatcher(TextView textView, Fragment fragment, Function1<? super Editable, Unit> function1) {
        Intrinsics3.checkNotNullParameter(textView, "$this$addBindedTextWatcher");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(function1, "onAfterTextChanged");
        addBindedTextWatcher(textView, fragment, new TextWatcher(null, null, function1, 3, null));
    }
}
