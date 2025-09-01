package com.discord.utilities.view.text;

import android.text.Editable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

/* compiled from: TextWatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0085\u0001\u0012.\b\u0002\u0010\u0016\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u0015\u0012.\b\u0002\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u0018\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ/\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R<\u0010\u0016\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R<\u0010\f\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014j\u0004\u0018\u0001`\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/discord/utilities/view/text/TextWatcher;", "Landroid/text/TextWatcher;", "", "s", "", "start", "count", "after", "", "beforeTextChanged", "(Ljava/lang/CharSequence;III)V", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "(Landroid/text/Editable;)V", "Lkotlin/Function1;", "Lcom/discord/utilities/view/text/OnAfterTextChanged;", "onAfterTextChanged", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function4;", "Lcom/discord/utilities/view/text/OnBeforeTextChanged;", "onBeforeTextChanged", "Lkotlin/jvm/functions/Function4;", "Lcom/discord/utilities/view/text/OnTextChanged;", "<init>", "(Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;)V", "Companion", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class TextWatcher implements android.text.TextWatcher {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Function1<Editable, Unit> onAfterTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> onBeforeTextChanged;
    private final Function4<CharSequence, Integer, Integer, Integer, Unit> onTextChanged;

    /* compiled from: TextWatcher.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/discord/utilities/view/text/TextWatcher$Companion;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", ModelAuditLogEntry.CHANGE_KEY_PERMISSIONS_RESET, "(Landroidx/fragment/app/Fragment;)V", "Landroid/widget/TextView;", "textView", "Lrx/functions/Action1;", "", "onAfterTextChanged", "addBindedTextWatcher", "(Landroidx/fragment/app/Fragment;Landroid/widget/TextView;Lrx/functions/Action1;)V", "<init>", "()V", "utils_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final void addBindedTextWatcher(Fragment fragment, TextView textView, Action1<String> onAfterTextChanged) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(textView, "textView");
            Intrinsics3.checkNotNullParameter(onAfterTextChanged, "onAfterTextChanged");
            TextWatcher4.addBindedTextWatcher(textView, fragment, new TextWatcher3(onAfterTextChanged));
        }

        public final void reset(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            HashMap map = (HashMap) TextWatcher4.access$getBindedTextWatchers$p().get(fragment);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    TextView textView = (TextView) entry.getKey();
                    Iterator it = ((ArrayList) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        textView.removeTextChangedListener((android.text.TextWatcher) it.next());
                    }
                }
            }
            TextWatcher4.access$getBindedTextWatchers$p().remove(fragment);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TextWatcher() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextWatcher(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Unit> function42, Function1<? super Editable, Unit> function1) {
        this.onBeforeTextChanged = function4;
        this.onTextChanged = function42;
        this.onAfterTextChanged = function1;
    }

    public static final void addBindedTextWatcher(Fragment fragment, TextView textView, Action1<String> action1) {
        INSTANCE.addBindedTextWatcher(fragment, textView, action1);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function1<Editable, Unit> function1 = this.onAfterTextChanged;
        if (function1 != null) {
            function1.invoke(s2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence s2, int start, int count, int after) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.onBeforeTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence s2, int start, int before, int count) {
        Intrinsics3.checkNotNullParameter(s2, "s");
        Function4<CharSequence, Integer, Integer, Integer, Unit> function4 = this.onTextChanged;
        if (function4 != null) {
            function4.invoke(s2, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public /* synthetic */ TextWatcher(Function4 function4, Function4 function42, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function4, (i & 2) != 0 ? null : function42, (i & 4) != 0 ? null : function1);
    }
}
