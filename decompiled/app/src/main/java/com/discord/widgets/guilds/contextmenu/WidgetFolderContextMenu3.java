package com.discord.widgets.guilds.contextmenu;

import android.view.View;
import com.discord.databinding.WidgetFolderContextMenuBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFolderContextMenu.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetFolderContextMenuBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetFolderContextMenuBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFolderContextMenu3 extends FunctionReferenceImpl implements Function1<View, WidgetFolderContextMenuBinding> {
    public static final WidgetFolderContextMenu3 INSTANCE = new WidgetFolderContextMenu3();

    public WidgetFolderContextMenu3() {
        super(1, WidgetFolderContextMenuBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFolderContextMenuBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFolderContextMenuBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFolderContextMenuBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetFolderContextMenuBinding.a(view);
    }
}
