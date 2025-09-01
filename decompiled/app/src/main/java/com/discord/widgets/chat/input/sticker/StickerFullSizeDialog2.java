package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.StickerFullSizeDialogBinding;
import com.discord.views.sticker.StickerView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: StickerFullSizeDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/StickerFullSizeDialogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/StickerFullSizeDialogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.chat.input.sticker.StickerFullSizeDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class StickerFullSizeDialog2 extends FunctionReferenceImpl implements Function1<View, StickerFullSizeDialogBinding> {
    public static final StickerFullSizeDialog2 INSTANCE = new StickerFullSizeDialog2();

    public StickerFullSizeDialog2() {
        super(1, StickerFullSizeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/StickerFullSizeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ StickerFullSizeDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final StickerFullSizeDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        StickerView stickerView = (StickerView) view.findViewById(R.id.sticker_full_size_sticker);
        if (stickerView != null) {
            return new StickerFullSizeDialogBinding((FrameLayout) view, stickerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sticker_full_size_sticker)));
    }
}
