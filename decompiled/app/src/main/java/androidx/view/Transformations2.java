package androidx.view;

import androidx.arch.core.util.Function;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Transformations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aE\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aK\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0003H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a&\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\b¢\u0006\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "switchMap", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
/* renamed from: androidx.lifecycle.TransformationsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Transformations2 {

    /* JADX INFO: Add missing generic type declarations: [X, Y] */
    /* compiled from: Transformations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0006\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: androidx.lifecycle.TransformationsKt$map$1, reason: invalid class name */
    public static final class AnonymousClass1<I, O, X, Y> implements Function<X, Y> {
        public final /* synthetic */ Function1 $transform;

        public AnonymousClass1(Function1 function1) {
            this.$transform = function1;
        }

        @Override // androidx.arch.core.util.Function
        public final Y apply(X x2) {
            return (Y) this.$transform.invoke(x2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X, Y] */
    /* compiled from: Transformations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00018\u0001 \u0002*\u0012\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00018\u0001\u0018\u00010\u00040\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "Landroidx/lifecycle/LiveData;", "apply", "(Ljava/lang/Object;)Landroidx/lifecycle/LiveData;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    /* renamed from: androidx.lifecycle.TransformationsKt$switchMap$1, reason: invalid class name */
    public static final class AnonymousClass1<I, O, X, Y> implements Function<X, LiveData<Y>> {
        public final /* synthetic */ Function1 $transform;

        public AnonymousClass1(Function1 function1) {
            this.$transform = function1;
        }

        @Override // androidx.arch.core.util.Function
        public final LiveData<Y> apply(X x2) {
            return (LiveData) this.$transform.invoke(x2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.arch.core.util.Function
        public /* bridge */ /* synthetic */ Object apply(Object obj) {
            return apply((AnonymousClass1<I, O, X, Y>) obj);
        }
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$distinctUntilChanged");
        LiveData<X> liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        Intrinsics3.checkNotNullExpressionValue(liveDataDistinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return liveDataDistinctUntilChanged;
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, Function1<? super X, ? extends Y> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$map");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        LiveData<Y> map = Transformations.map(liveData, new AnonymousClass1(function1));
        Intrinsics3.checkNotNullExpressionValue(map, "Transformations.map(this) { transform(it) }");
        return map;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, Function1<? super X, ? extends LiveData<Y>> function1) {
        Intrinsics3.checkNotNullParameter(liveData, "$this$switchMap");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        LiveData<Y> liveDataSwitchMap = Transformations.switchMap(liveData, new AnonymousClass1(function1));
        Intrinsics3.checkNotNullExpressionValue(liveDataSwitchMap, "Transformations.switchMap(this) { transform(it) }");
        return liveDataSwitchMap;
    }
}
