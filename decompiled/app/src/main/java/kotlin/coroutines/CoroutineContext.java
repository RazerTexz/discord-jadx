package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import d0.w.ContinuationInterceptor;
import d0.w.CoroutineContextImpl3;
import d0.w.CoroutineContextImpl4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: CoroutineContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001:\u0002\u0013\u0014J*\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "Lkotlin/coroutines/CoroutineContext$Element;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "context", "plus", "(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;", "minusKey", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "Element", "Key", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Key;", "key", "get", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public interface Element extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        public static final class a {
            public static <R> R fold(Element element, R r, Function2<? super R, ? super Element, ? extends R> function2) {
                Intrinsics3.checkNotNullParameter(function2, "operation");
                return function2.invoke(r, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                if (Intrinsics3.areEqual(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return Intrinsics3.areEqual(element.getKey(), key) ? CoroutineContextImpl4.j : element;
            }

            public static CoroutineContext plus(Element element, CoroutineContext coroutineContext) {
                Intrinsics3.checkNotNullParameter(coroutineContext, "context");
                return a.plus(element, coroutineContext);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlin/coroutines/CoroutineContext$Element;", ExifInterface.LONGITUDE_EAST, "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public interface Key<E extends Element> {
    }

    /* compiled from: CoroutineContext.kt */
    public static final class a {

        /* compiled from: CoroutineContext.kt */
        /* renamed from: kotlin.coroutines.CoroutineContext$a$a, reason: collision with other inner class name */
        public static final class C0433a extends Lambda implements Function2<CoroutineContext, Element, CoroutineContext> {
            public static final C0433a j = new C0433a();

            public C0433a() {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ CoroutineContext invoke(CoroutineContext coroutineContext, Element element) {
                return invoke2(coroutineContext, element);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CoroutineContext invoke2(CoroutineContext coroutineContext, Element element) {
                CoroutineContextImpl3 coroutineContextImpl3;
                Intrinsics3.checkNotNullParameter(coroutineContext, "acc");
                Intrinsics3.checkNotNullParameter(element, "element");
                CoroutineContext coroutineContextMinusKey = coroutineContext.minusKey(element.getKey());
                CoroutineContextImpl4 coroutineContextImpl4 = CoroutineContextImpl4.j;
                if (coroutineContextMinusKey == coroutineContextImpl4) {
                    return element;
                }
                int i = ContinuationInterceptor.e;
                ContinuationInterceptor.b bVar = ContinuationInterceptor.b.a;
                ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(bVar);
                if (continuationInterceptor == null) {
                    coroutineContextImpl3 = new CoroutineContextImpl3(coroutineContextMinusKey, element);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(bVar);
                    if (coroutineContextMinusKey2 == coroutineContextImpl4) {
                        return new CoroutineContextImpl3(element, continuationInterceptor);
                    }
                    coroutineContextImpl3 = new CoroutineContextImpl3(new CoroutineContextImpl3(coroutineContextMinusKey2, element), continuationInterceptor);
                }
                return coroutineContextImpl3;
            }
        }

        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            Intrinsics3.checkNotNullParameter(coroutineContext2, "context");
            return coroutineContext2 == CoroutineContextImpl4.j ? coroutineContext : (CoroutineContext) coroutineContext2.fold(coroutineContext, C0433a.j);
        }
    }

    <R> R fold(R initial, Function2<? super R, ? super Element, ? extends R> operation);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext context);
}
