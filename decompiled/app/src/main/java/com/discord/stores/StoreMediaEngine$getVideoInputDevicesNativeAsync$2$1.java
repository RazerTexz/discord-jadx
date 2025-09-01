package com.discord.stores;

import co.discord.media_engine.DeviceDescription4;
import d0.Result2;
import d0.w.Continuation2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: StoreMediaEngine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lco/discord/media_engine/VideoInputDeviceDescription;", "p1", "", "invoke", "([Lco/discord/media_engine/VideoInputDeviceDescription;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1 extends FunctionReferenceImpl implements Function1<DeviceDescription4[], Unit> {
    public StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(CancellableContinuation cancellableContinuation) {
        super(1, cancellableContinuation, Continuation2.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
        invoke2(deviceDescription4Arr);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
        Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "p1");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) this.receiver;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(deviceDescription4Arr));
    }
}
