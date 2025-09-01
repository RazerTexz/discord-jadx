package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.WidgetQrScannerBinding;
import com.google.android.material.chip.Chip;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* compiled from: WidgetQRScanner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetQrScannerBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetQrScannerBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetQRScanner$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner2 extends FunctionReferenceImpl implements Function1<View, WidgetQrScannerBinding> {
    public static final WidgetQRScanner2 INSTANCE = new WidgetQRScanner2();

    public WidgetQRScanner2() {
        super(1, WidgetQrScannerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQrScannerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetQrScannerBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetQrScannerBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.qr_scanner;
        ZXingScannerView zXingScannerView = (ZXingScannerView) view.findViewById(R.id.qr_scanner);
        if (zXingScannerView != null) {
            i = R.id.qr_scanner_chip;
            Chip chip = (Chip) view.findViewById(R.id.qr_scanner_chip);
            if (chip != null) {
                return new WidgetQrScannerBinding((FrameLayout) view, zXingScannerView, chip);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
