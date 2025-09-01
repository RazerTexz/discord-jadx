package com.discord.utilities.stateful;

import android.text.Editable;
import android.view.View;
import com.discord.app.AppFragment;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: StatefulViews.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/text/Editable;", "editable", "", "invoke", "(Landroid/text/Editable;)V", "com/discord/utilities/stateful/StatefulViews$setupTextWatcherWithSaveAction$1$onAfterTextChanged$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.stateful.StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StatefulViews2 extends Lambda implements Function1<Editable, Unit> {
    public final /* synthetic */ AppFragment $fragment$inlined;
    public final /* synthetic */ View $saveAction$inlined;
    public final /* synthetic */ View $view;
    public final /* synthetic */ StatefulViews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatefulViews2(View view, StatefulViews statefulViews, View view2, AppFragment appFragment) {
        super(1);
        this.$view = view;
        this.this$0 = statefulViews;
        this.$saveAction$inlined = view2;
        this.$fragment$inlined = appFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        Intrinsics3.checkNotNullParameter(editable, "editable");
        this.this$0.put(this.$view.getId(), editable.toString());
        this.this$0.configureSaveActionView(this.$saveAction$inlined);
    }
}
