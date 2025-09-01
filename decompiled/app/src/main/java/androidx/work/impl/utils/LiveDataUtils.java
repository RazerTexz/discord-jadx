package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class LiveDataUtils {

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    public class AnonymousClass1<In> implements Observer<In> {
        public Out mCurrentOutput = null;
        public final /* synthetic */ Object val$lock;
        public final /* synthetic */ Function val$mappingMethod;
        public final /* synthetic */ MediatorLiveData val$outputLiveData;
        public final /* synthetic */ TaskExecutor val$workTaskExecutor;

        /* renamed from: androidx.work.impl.utils.LiveDataUtils$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC00071 implements Runnable {
            public final /* synthetic */ Object val$input;

            public RunnableC00071(Object obj) {
                this.val$input = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AnonymousClass1.this.val$lock) {
                    ?? Apply = AnonymousClass1.this.val$mappingMethod.apply(this.val$input);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    Out out = anonymousClass1.mCurrentOutput;
                    if (out == 0 && Apply != 0) {
                        anonymousClass1.mCurrentOutput = Apply;
                        anonymousClass1.val$outputLiveData.postValue(Apply);
                    } else if (out != 0 && !out.equals(Apply)) {
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        anonymousClass12.mCurrentOutput = Apply;
                        anonymousClass12.val$outputLiveData.postValue(Apply);
                    }
                }
            }
        }

        public AnonymousClass1(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.val$workTaskExecutor = taskExecutor;
            this.val$lock = obj;
            this.val$mappingMethod = function;
            this.val$outputLiveData = mediatorLiveData;
        }

        @Override // androidx.view.Observer
        public void onChanged(@Nullable In in) {
            this.val$workTaskExecutor.executeOnBackgroundThread(new RunnableC00071(in));
        }
    }

    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull Function<In, Out> function, @NonNull TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new AnonymousClass1(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }
}
