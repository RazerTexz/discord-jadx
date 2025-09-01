package org.webrtc;

/* loaded from: classes3.dex */
public interface Predicate<T> {

    /* renamed from: org.webrtc.Predicate$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Predicate a(Predicate _this, Predicate predicate) {
            return new AnonymousClass2(predicate);
        }

        public static Predicate b(Predicate _this) {
            return new AnonymousClass3();
        }

        public static Predicate c(Predicate _this, Predicate predicate) {
            return new AnonymousClass1(predicate);
        }
    }

    /* renamed from: org.webrtc.Predicate$1, reason: invalid class name */
    public class AnonymousClass1 implements Predicate<T> {
        public final /* synthetic */ Predicate val$other;

        public AnonymousClass1(Predicate predicate) {
            this.val$other = predicate;
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return CC.a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate negate() {
            return CC.b(this);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate or(Predicate predicate) {
            return CC.c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(T t) {
            return Predicate.this.test(t) || this.val$other.test(t);
        }
    }

    /* renamed from: org.webrtc.Predicate$2, reason: invalid class name */
    public class AnonymousClass2 implements Predicate<T> {
        public final /* synthetic */ Predicate val$other;

        public AnonymousClass2(Predicate predicate) {
            this.val$other = predicate;
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return CC.a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate negate() {
            return CC.b(this);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate or(Predicate predicate) {
            return CC.c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(T t) {
            return Predicate.this.test(t) && this.val$other.test(t);
        }
    }

    /* renamed from: org.webrtc.Predicate$3, reason: invalid class name */
    public class AnonymousClass3 implements Predicate<T> {
        public AnonymousClass3() {
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate and(Predicate predicate) {
            return CC.a(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate negate() {
            return CC.b(this);
        }

        @Override // org.webrtc.Predicate
        public /* synthetic */ Predicate or(Predicate predicate) {
            return CC.c(this, predicate);
        }

        @Override // org.webrtc.Predicate
        public boolean test(T t) {
            return !Predicate.this.test(t);
        }
    }

    Predicate<T> and(Predicate<? super T> predicate);

    Predicate<T> negate();

    Predicate<T> or(Predicate<? super T> predicate);

    boolean test(T t);
}
