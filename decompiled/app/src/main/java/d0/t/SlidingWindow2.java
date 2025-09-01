package d0.t;

import b.d.b.a.outline;
import d0.Result3;
import d0.d0._Ranges;
import d0.f0.SequenceBuilder2;
import d0.f0.SequenceBuilder3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl5;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: SlidingWindow.kt */
/* renamed from: d0.t.p0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SlidingWindow2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    /* renamed from: d0.t.p0$a */
    public static final class a<T> extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Iterator $iterator;
        public final /* synthetic */ boolean $partialWindows;
        public final /* synthetic */ boolean $reuseBuffer;
        public final /* synthetic */ int $size;
        public final /* synthetic */ int $step;
        public int I$0;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Iterator it, boolean z2, boolean z3, Continuation continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z2;
            this.$partialWindows = z3;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((a) create(obj, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please report as a decompilation issue!!! */
        @Override // d0.w.i.a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Iterator it;
            SequenceBuilder2 sequenceBuilder2;
            a<T> aVar;
            int i2;
            SequenceBuilder2 sequenceBuilder22;
            a<T> aVar2;
            ArrayList arrayList;
            Iterator it2;
            SlidingWindow slidingWindowExpanded;
            SlidingWindow slidingWindow;
            SequenceBuilder2 sequenceBuilder23;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                Result3.throwOnFailure(obj);
                SequenceBuilder2 sequenceBuilder24 = (SequenceBuilder2) this.L$0;
                int iCoerceAtMost = _Ranges.coerceAtMost(this.$size, 1024);
                i = this.$step - this.$size;
                if (i < 0) {
                    SlidingWindow slidingWindow2 = new SlidingWindow(iCoerceAtMost);
                    it = this.$iterator;
                    sequenceBuilder2 = sequenceBuilder24;
                    aVar = this;
                    slidingWindowExpanded = slidingWindow2;
                    while (it.hasNext()) {
                    }
                    if (aVar.$partialWindows) {
                    }
                    return Unit.a;
                }
                ArrayList arrayList2 = new ArrayList(iCoerceAtMost);
                i2 = 0;
                sequenceBuilder22 = sequenceBuilder24;
                aVar2 = this;
                arrayList = arrayList2;
                it2 = this.$iterator;
                while (it2.hasNext()) {
                }
                if (!arrayList.isEmpty()) {
                    aVar2.L$0 = null;
                    aVar2.L$1 = null;
                    aVar2.L$2 = null;
                    aVar2.label = 2;
                    if (sequenceBuilder22.yield(arrayList, aVar2) == coroutine_suspended) {
                    }
                }
                return Unit.a;
            }
            if (i3 == 1) {
                i2 = this.I$0;
                it2 = (Iterator) this.L$2;
                arrayList = (ArrayList) this.L$1;
                sequenceBuilder22 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
                aVar2 = this;
                if (aVar2.$reuseBuffer) {
                    arrayList = new ArrayList(aVar2.$size);
                } else {
                    arrayList.clear();
                }
                i = i2;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (i2 > 0) {
                        i2--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == aVar2.$size) {
                            aVar2.L$0 = sequenceBuilder22;
                            aVar2.L$1 = arrayList;
                            aVar2.L$2 = it2;
                            aVar2.I$0 = i;
                            aVar2.label = 1;
                            if (sequenceBuilder22.yield(arrayList, aVar2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i2 = i;
                            if (aVar2.$reuseBuffer) {
                            }
                            i = i2;
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
                if ((!arrayList.isEmpty()) && (aVar2.$partialWindows || arrayList.size() == aVar2.$size)) {
                    aVar2.L$0 = null;
                    aVar2.L$1 = null;
                    aVar2.L$2 = null;
                    aVar2.label = 2;
                    if (sequenceBuilder22.yield(arrayList, aVar2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.a;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    it = (Iterator) this.L$2;
                    SlidingWindow slidingWindow3 = (SlidingWindow) this.L$1;
                    sequenceBuilder2 = (SequenceBuilder2) this.L$0;
                    Result3.throwOnFailure(obj);
                    aVar = this;
                    SlidingWindow slidingWindow4 = slidingWindow3;
                    slidingWindow4.removeFirst(aVar.$step);
                    slidingWindowExpanded = slidingWindow4;
                    while (it.hasNext()) {
                        slidingWindowExpanded.add((SlidingWindow) it.next());
                        if (slidingWindowExpanded.isFull()) {
                            int size = slidingWindowExpanded.size();
                            int i4 = aVar.$size;
                            if (size >= i4) {
                                ArrayList arrayList3 = aVar.$reuseBuffer ? slidingWindowExpanded : new ArrayList(slidingWindowExpanded);
                                aVar.L$0 = sequenceBuilder2;
                                aVar.L$1 = slidingWindowExpanded;
                                aVar.L$2 = it;
                                aVar.label = 3;
                                slidingWindow4 = slidingWindowExpanded;
                                if (sequenceBuilder2.yield(arrayList3, aVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                slidingWindow4.removeFirst(aVar.$step);
                                slidingWindowExpanded = slidingWindow4;
                                while (it.hasNext()) {
                                }
                            } else {
                                slidingWindowExpanded = slidingWindowExpanded.expanded(i4);
                            }
                        }
                    }
                    if (aVar.$partialWindows) {
                        slidingWindow = slidingWindowExpanded;
                        sequenceBuilder23 = sequenceBuilder2;
                        if (slidingWindow.size() <= aVar.$step) {
                        }
                    }
                    return Unit.a;
                }
                if (i3 == 4) {
                    slidingWindow = (SlidingWindow) this.L$1;
                    sequenceBuilder23 = (SequenceBuilder2) this.L$0;
                    Result3.throwOnFailure(obj);
                    aVar = this;
                    slidingWindow.removeFirst(aVar.$step);
                    if (slidingWindow.size() <= aVar.$step) {
                        RandomAccess arrayList4 = aVar.$reuseBuffer ? slidingWindow : new ArrayList(slidingWindow);
                        aVar.L$0 = sequenceBuilder23;
                        aVar.L$1 = slidingWindow;
                        aVar.L$2 = null;
                        aVar.label = 4;
                        if (sequenceBuilder23.yield(arrayList4, aVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        slidingWindow.removeFirst(aVar.$step);
                        if (slidingWindow.size() <= aVar.$step) {
                            if (!slidingWindow.isEmpty()) {
                                aVar.L$0 = null;
                                aVar.L$1 = null;
                                aVar.L$2 = null;
                                aVar.label = 5;
                                if (sequenceBuilder23.yield(slidingWindow, aVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.a;
                        }
                    }
                } else if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    public static final void checkWindowSizeStep(int i, int i2) {
        String strR;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            strR = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            strR = outline.r("size ", i, " must be greater than zero.");
        }
        throw new IllegalArgumentException(strR.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? Collections3.j : SequenceBuilder3.iterator(new a(i, i2, it, z3, z2, null));
    }
}
