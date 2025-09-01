package com.discord.widgets.directories;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetDirectoryCategoryBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetDirectoryCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryCategory5 extends FunctionReferenceImpl implements Function1<View, WidgetDirectoryCategoryBinding> {
    public static final WidgetDirectoryCategory5 INSTANCE = new WidgetDirectoryCategory5();

    public WidgetDirectoryCategory5() {
        super(1, WidgetDirectoryCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDirectoryCategoryBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDirectoryCategoryBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetDirectoryCategoryBinding(recyclerView, recyclerView);
    }
}
