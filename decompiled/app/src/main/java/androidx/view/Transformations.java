package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;

/* loaded from: classes.dex */
public class Transformations {

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$1, reason: invalid class name */
    public class AnonymousClass1<X> implements Observer<X> {
        public final /* synthetic */ Function val$mapFunction;
        public final /* synthetic */ MediatorLiveData val$result;

        public AnonymousClass1(MediatorLiveData mediatorLiveData, Function function) {
            this.val$result = mediatorLiveData;
            this.val$mapFunction = function;
        }

        @Override // androidx.view.Observer
        public void onChanged(@Nullable X x2) {
            this.val$result.setValue(this.val$mapFunction.apply(x2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$2, reason: invalid class name */
    public class AnonymousClass2<X> implements Observer<X> {
        public LiveData<Y> mSource;
        public final /* synthetic */ MediatorLiveData val$result;
        public final /* synthetic */ Function val$switchMapFunction;

        /* JADX INFO: Add missing generic type declarations: [Y] */
        /* renamed from: androidx.lifecycle.Transformations$2$1, reason: invalid class name */
        public class AnonymousClass1<Y> implements Observer<Y> {
            public AnonymousClass1() {
            }

            @Override // androidx.view.Observer
            public void onChanged(@Nullable Y y2) {
                AnonymousClass2.this.val$result.setValue(y2);
            }
        }

        public AnonymousClass2(Function function, MediatorLiveData mediatorLiveData) {
            this.val$switchMapFunction = function;
            this.val$result = mediatorLiveData;
        }

        @Override // androidx.view.Observer
        public void onChanged(@Nullable X x2) {
            LiveData<Y> liveData = (LiveData) this.val$switchMapFunction.apply(x2);
            Object obj = this.mSource;
            if (obj == liveData) {
                return;
            }
            if (obj != null) {
                this.val$result.removeSource(obj);
            }
            this.mSource = liveData;
            if (liveData != 0) {
                this.val$result.addSource(liveData, new AnonymousClass1());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* renamed from: androidx.lifecycle.Transformations$3, reason: invalid class name */
    public class AnonymousClass3<X> implements Observer<X> {
        public boolean mFirstTime = true;
        public final /* synthetic */ MediatorLiveData val$outputLiveData;

        public AnonymousClass3(MediatorLiveData mediatorLiveData) {
            this.val$outputLiveData = mediatorLiveData;
        }

        @Override // androidx.view.Observer
        public void onChanged(X x2) {
            T value = this.val$outputLiveData.getValue();
            if (this.mFirstTime || ((value == 0 && x2 != null) || !(value == 0 || value.equals(x2)))) {
                this.mFirstTime = false;
                this.val$outputLiveData.setValue(x2);
            }
        }
    }

    private Transformations() {
    }

    @NonNull
    @MainThread
    public static <X> LiveData<X> distinctUntilChanged(@NonNull LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass3(mediatorLiveData));
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> map(@NonNull LiveData<X> liveData, @NonNull Function<X, Y> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass1(mediatorLiveData, function));
        return mediatorLiveData;
    }

    @NonNull
    @MainThread
    public static <X, Y> LiveData<Y> switchMap(@NonNull LiveData<X> liveData, @NonNull Function<X, LiveData<Y>> function) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
