package com.discord.widgets.media;

import com.discord.databinding.WidgetQrScannerBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetQRScanner.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/databinding/WidgetQrScannerBinding;", "p1", "", "invoke", "(Lcom/discord/databinding/WidgetQrScannerBinding;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.media.WidgetQRScanner$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner3 extends FunctionReferenceImpl implements Function1<WidgetQrScannerBinding, Unit> {
    public WidgetQRScanner3(WidgetQRScanner widgetQRScanner) {
        super(1, widgetQRScanner, WidgetQRScanner.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetQrScannerBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetQrScannerBinding widgetQrScannerBinding) {
        invoke2(widgetQrScannerBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetQrScannerBinding widgetQrScannerBinding) {
        Intrinsics3.checkNotNullParameter(widgetQrScannerBinding, "p1");
        WidgetQRScanner.access$onViewBindingDestroy((WidgetQRScanner) this.receiver, widgetQrScannerBinding);
    }
}
