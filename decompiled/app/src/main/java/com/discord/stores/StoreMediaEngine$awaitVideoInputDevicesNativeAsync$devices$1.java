package com.discord.stores;

import co.discord.media_engine.DeviceDescription4;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StoreMediaEngine.kt */
@DebugMetadata(c = "com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1", f = "StoreMediaEngine.kt", l = {266}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lco/discord/media_engine/VideoInputDeviceDescription;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super DeviceDescription4[]>, Object> {
    public int label;
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(StoreMediaEngine storeMediaEngine, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storeMediaEngine;
    }

    @Override // d0.w.i.a.ContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics3.checkNotNullParameter(continuation, "completion");
        return new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DeviceDescription4[]> continuation) {
        return ((StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0028 -> B:13:0x002c). Please report as a decompilation issue!!! */
    @Override // d0.w.i.a.ContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1;
        Object videoInputDevicesNativeAsync;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            Result3.throwOnFailure(obj);
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = this;
            StoreMediaEngine storeMediaEngine = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.this$0;
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.label = 1;
            videoInputDevicesNativeAsync = storeMediaEngine.getVideoInputDevicesNativeAsync(storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1);
            if (videoInputDevicesNativeAsync != coroutine_suspended) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            Object obj2 = coroutine_suspended;
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12 = this;
            DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) obj;
            if (!(deviceDescription4Arr.length != 0)) {
                if (StoreMediaEngine.access$getHasTimedOutAwaitingDevice$p(storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12.this$0)) {
                    return null;
                }
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12;
                coroutine_suspended = obj2;
                StoreMediaEngine storeMediaEngine2 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.this$0;
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.label = 1;
                videoInputDevicesNativeAsync = storeMediaEngine2.getVideoInputDevicesNativeAsync(storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1);
                if (videoInputDevicesNativeAsync != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Object obj3 = coroutine_suspended;
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1;
                obj = videoInputDevicesNativeAsync;
                obj2 = obj3;
                DeviceDescription4[] deviceDescription4Arr2 = (DeviceDescription4[]) obj;
                if (!(deviceDescription4Arr2.length != 0)) {
                    return deviceDescription4Arr2;
                }
            }
        }
    }
}
