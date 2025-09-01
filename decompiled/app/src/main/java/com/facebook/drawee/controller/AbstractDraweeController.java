package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableMap;
import b.f.d.d.Objects2;
import b.f.d.e.FLog;
import b.f.e.AbstractDataSource3;
import b.f.e.BaseDataSubscriber;
import b.f.g.b.DeferredReleaser;
import b.f.g.b.DeferredReleaserConcurrentImpl;
import b.f.g.b.DraweeEventTracker;
import b.f.g.b.RetryManager;
import b.f.g.c.BaseControllerListener;
import b.f.g.c.ForwardingControllerListener;
import b.f.g.e.ScaleTypeDrawable;
import b.f.g.g.GestureDetector;
import b.f.g.h.SettableDraweeHierarchy;
import b.f.h.b.a.ControllerListener2;
import b.f.h.b.a.ForwardingControllerListener2;
import b.f.j.r.FrescoSystrace;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.a, GestureDetector.a {
    public static final Map<String, Object> a = ImmutableMap.of("component_tag", "drawee");

    /* renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f2885b = ImmutableMap.of("origin", "memory_bitmap", "origin_sub", "shortcut");
    public static final Class<?> c = AbstractDraweeController.class;
    public final DraweeEventTracker d;
    public final DeferredReleaser e;
    public final Executor f;
    public RetryManager g;
    public GestureDetector h;
    public ControllerListener<INFO> i;
    public ForwardingControllerListener2<INFO> j;
    public SettableDraweeHierarchy k;
    public Drawable l;
    public String m;
    public Object n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public String f2886s;
    public DataSource<T> t;
    public T u;
    public boolean v;
    public Drawable w;

    public class a extends BaseDataSubscriber<T> {
        public final /* synthetic */ String a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f2887b;

        public a(String str, boolean z2) {
            this.a = str;
            this.f2887b = z2;
        }

        @Override // b.f.e.BaseDataSubscriber
        public void onFailureImpl(DataSource<T> dataSource) {
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.a;
            Throwable thD = dataSource.d();
            Map<String, Object> map = AbstractDraweeController.a;
            abstractDraweeController.u(str, dataSource, thD, true);
        }

        @Override // b.f.e.BaseDataSubscriber
        public void onNewResultImpl(DataSource<T> dataSource) {
            boolean zC = dataSource.c();
            boolean zE = dataSource.e();
            float progress = dataSource.getProgress();
            T result = dataSource.getResult();
            if (result != null) {
                AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                String str = this.a;
                boolean z2 = this.f2887b;
                Map<String, Object> map = AbstractDraweeController.a;
                abstractDraweeController.w(str, dataSource, result, progress, zC, z2, zE);
                return;
            }
            if (zC) {
                AbstractDraweeController abstractDraweeController2 = AbstractDraweeController.this;
                String str2 = this.a;
                NullPointerException nullPointerException = new NullPointerException();
                Map<String, Object> map2 = AbstractDraweeController.a;
                abstractDraweeController2.u(str2, dataSource, nullPointerException, true);
            }
        }

        @Override // b.f.e.BaseDataSubscriber, b.f.e.DataSubscriber
        public void onProgressUpdate(DataSource<T> dataSource) {
            AbstractDataSource3 abstractDataSource3 = (AbstractDataSource3) dataSource;
            boolean zC = abstractDataSource3.c();
            float progress = abstractDataSource3.getProgress();
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.a;
            Map<String, Object> map = AbstractDraweeController.a;
            if (!abstractDraweeController.o(str, abstractDataSource3)) {
                abstractDraweeController.p("ignore_old_datasource @ onProgress", null);
                abstractDataSource3.close();
            } else {
                if (zC) {
                    return;
                }
                abstractDraweeController.k.d(progress, false);
            }
        }
    }

    public static class b<INFO> extends ForwardingControllerListener<INFO> {
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.d = DraweeEventTracker.f494b ? new DraweeEventTracker() : DraweeEventTracker.a;
        this.j = new ForwardingControllerListener2<>();
        this.v = true;
        this.e = deferredReleaser;
        this.f = executor;
        n(null, null);
    }

    public void A(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.i;
        if (!(controllerListener2 instanceof b)) {
            if (controllerListener2 == controllerListener) {
                this.i = null;
            }
        } else {
            b bVar = (b) controllerListener2;
            synchronized (bVar) {
                int iIndexOf = bVar.a.indexOf(controllerListener);
                if (iIndexOf != -1) {
                    bVar.a.set(iIndexOf, null);
                }
            }
        }
    }

    public void B(DataSource<T> dataSource, INFO info) {
        i().onSubmit(this.m, this.n);
        this.j.a(this.m, this.n, r(dataSource, info, m()));
    }

    public final void C(String str, T t, DataSource<T> dataSource) {
        INFO infoL = l(t);
        i().onFinalImageSet(str, infoL, c());
        this.j.d(str, infoL, r(dataSource, infoL, null));
    }

    public final boolean D() {
        RetryManager retryManager;
        if (this.q && (retryManager = this.g) != null) {
            if (retryManager.a && retryManager.c < retryManager.f499b) {
                return true;
            }
        }
        return false;
    }

    public void E() {
        FrescoSystrace.b();
        T tH = h();
        if (tH != null) {
            FrescoSystrace.b();
            this.t = null;
            this.p = true;
            this.q = false;
            this.d.a(DraweeEventTracker.a.ON_SUBMIT_CACHE_HIT);
            B(this.t, l(tH));
            v(this.m, tH);
            w(this.m, this.t, tH, 1.0f, true, true, true);
            FrescoSystrace.b();
            FrescoSystrace.b();
            return;
        }
        this.d.a(DraweeEventTracker.a.ON_DATASOURCE_SUBMIT);
        this.k.d(0.0f, true);
        this.p = true;
        this.q = false;
        DataSource<T> dataSourceJ = j();
        this.t = dataSourceJ;
        B(dataSourceJ, null);
        if (FLog.h(2)) {
            FLog.j(c, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.m, Integer.valueOf(System.identityHashCode(this.t)));
        }
        this.t.f(new a(this.m, this.t.b()), this.f);
        FrescoSystrace.b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void a() {
        FrescoSystrace.b();
        if (FLog.h(2)) {
            System.identityHashCode(this);
        }
        this.d.a(DraweeEventTracker.a.ON_DETACH_CONTROLLER);
        this.o = false;
        DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = (DeferredReleaserConcurrentImpl) this.e;
        Objects.requireNonNull(deferredReleaserConcurrentImpl);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            synchronized (deferredReleaserConcurrentImpl.f493b) {
                if (!deferredReleaserConcurrentImpl.d.contains(this)) {
                    deferredReleaserConcurrentImpl.d.add(this);
                    boolean z2 = deferredReleaserConcurrentImpl.d.size() == 1;
                    if (z2) {
                        deferredReleaserConcurrentImpl.c.post(deferredReleaserConcurrentImpl.f);
                    }
                }
            }
        } else {
            release();
        }
        FrescoSystrace.b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public DraweeHierarchy b() {
        return this.k;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public Animatable c() {
        Object obj = this.w;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void d() {
        FrescoSystrace.b();
        if (FLog.h(2)) {
            FLog.j(c, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.m, this.p ? "request already submitted" : "request needs submit");
        }
        this.d.a(DraweeEventTracker.a.ON_ATTACH_CONTROLLER);
        Objects.requireNonNull(this.k);
        this.e.a(this);
        this.o = true;
        if (!this.p) {
            E();
        }
        FrescoSystrace.b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void e(DraweeHierarchy draweeHierarchy) {
        if (FLog.h(2)) {
            FLog.j(c, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.m, draweeHierarchy);
        }
        this.d.a(draweeHierarchy != null ? DraweeEventTracker.a.ON_SET_HIERARCHY : DraweeEventTracker.a.ON_CLEAR_HIERARCHY);
        if (this.p) {
            this.e.a(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.k;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.a(null);
            this.k = null;
        }
        if (draweeHierarchy != null) {
            AnimatableValueParser.i(Boolean.valueOf(draweeHierarchy instanceof SettableDraweeHierarchy));
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.k = settableDraweeHierarchy2;
            settableDraweeHierarchy2.a(this.l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.i;
        if (controllerListener2 instanceof b) {
            ((b) controllerListener2).a(controllerListener);
            return;
        }
        if (controllerListener2 == null) {
            this.i = controllerListener;
            return;
        }
        FrescoSystrace.b();
        b bVar = new b();
        bVar.a(controllerListener2);
        bVar.a(controllerListener);
        FrescoSystrace.b();
        this.i = bVar;
    }

    public abstract Drawable g(T t);

    public T h() {
        return null;
    }

    public ControllerListener<INFO> i() {
        ControllerListener<INFO> controllerListener = this.i;
        return controllerListener == null ? BaseControllerListener.getNoOpListener() : controllerListener;
    }

    public abstract DataSource<T> j();

    public int k(T t) {
        return System.identityHashCode(t);
    }

    public abstract INFO l(T t);

    public Uri m() {
        return null;
    }

    public final synchronized void n(String str, Object obj) {
        DeferredReleaser deferredReleaser;
        FrescoSystrace.b();
        this.d.a(DraweeEventTracker.a.ON_INIT_CONTROLLER);
        if (!this.v && (deferredReleaser = this.e) != null) {
            deferredReleaser.a(this);
        }
        this.o = false;
        y();
        this.r = false;
        RetryManager retryManager = this.g;
        if (retryManager != null) {
            retryManager.a = false;
            retryManager.f499b = 4;
            retryManager.c = 0;
        }
        GestureDetector gestureDetector = this.h;
        if (gestureDetector != null) {
            gestureDetector.a = null;
            gestureDetector.c = false;
            gestureDetector.d = false;
            gestureDetector.a = this;
        }
        ControllerListener<INFO> controllerListener = this.i;
        if (controllerListener instanceof b) {
            b bVar = (b) controllerListener;
            synchronized (bVar) {
                bVar.a.clear();
            }
        } else {
            this.i = null;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.k;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.k.a(null);
            this.k = null;
        }
        this.l = null;
        if (FLog.h(2)) {
            FLog.j(c, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.m, str);
        }
        this.m = str;
        this.n = obj;
        FrescoSystrace.b();
    }

    public final boolean o(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.t == null) {
            return true;
        }
        return str.equals(this.m) && dataSource == this.t && this.p;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector.a aVar;
        boolean zH = FLog.h(2);
        if (zH) {
            FLog.j(c, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.m, motionEvent);
        }
        GestureDetector gestureDetector = this.h;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.c && !D()) {
            return false;
        }
        GestureDetector gestureDetector2 = this.h;
        Objects.requireNonNull(gestureDetector2);
        int action = motionEvent.getAction();
        if (action == 0) {
            gestureDetector2.c = true;
            gestureDetector2.d = true;
            gestureDetector2.e = motionEvent.getEventTime();
            gestureDetector2.f = motionEvent.getX();
            gestureDetector2.g = motionEvent.getY();
        } else if (action == 1) {
            gestureDetector2.c = false;
            if (Math.abs(motionEvent.getX() - gestureDetector2.f) > gestureDetector2.f524b || Math.abs(motionEvent.getY() - gestureDetector2.g) > gestureDetector2.f524b) {
                gestureDetector2.d = false;
            }
            if (gestureDetector2.d && motionEvent.getEventTime() - gestureDetector2.e <= ViewConfiguration.getLongPressTimeout() && (aVar = gestureDetector2.a) != null) {
                AbstractDraweeController abstractDraweeController = (AbstractDraweeController) aVar;
                if (zH) {
                    System.identityHashCode(abstractDraweeController);
                }
                if (abstractDraweeController.D()) {
                    abstractDraweeController.g.c++;
                    abstractDraweeController.k.reset();
                    abstractDraweeController.E();
                }
            }
            gestureDetector2.d = false;
        } else if (action != 2) {
            if (action == 3) {
                gestureDetector2.c = false;
                gestureDetector2.d = false;
            }
        } else if (Math.abs(motionEvent.getX() - gestureDetector2.f) > gestureDetector2.f524b || Math.abs(motionEvent.getY() - gestureDetector2.g) > gestureDetector2.f524b) {
            gestureDetector2.d = false;
        }
        return true;
    }

    public final void p(String str, Throwable th) {
        if (FLog.h(2)) {
            System.identityHashCode(this);
        }
    }

    public final void q(String str, T t) {
        if (FLog.h(2)) {
            System.identityHashCode(this);
            if (t != null) {
                t.getClass().getSimpleName();
            }
            k(t);
        }
    }

    public final ControllerListener2.a r(DataSource<T> dataSource, INFO info, Uri uri) {
        return s(dataSource == null ? null : dataSource.a(), t(info), uri);
    }

    @Override // b.f.g.b.DeferredReleaser.a
    public void release() {
        this.d.a(DraweeEventTracker.a.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.g;
        if (retryManager != null) {
            retryManager.c = 0;
        }
        GestureDetector gestureDetector = this.h;
        if (gestureDetector != null) {
            gestureDetector.c = false;
            gestureDetector.d = false;
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.k;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        y();
    }

    public final ControllerListener2.a s(Map<String, Object> map, Map<String, Object> map2, Uri uri) {
        SettableDraweeHierarchy settableDraweeHierarchy = this.k;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) settableDraweeHierarchy;
            String.valueOf(!(genericDraweeHierarchy.k(2) instanceof ScaleTypeDrawable) ? null : genericDraweeHierarchy.l(2).n);
            if (genericDraweeHierarchy.k(2) instanceof ScaleTypeDrawable) {
                PointF pointF = genericDraweeHierarchy.l(2).p;
            }
        }
        Map<String, Object> map3 = a;
        Map<String, Object> map4 = f2885b;
        SettableDraweeHierarchy settableDraweeHierarchy2 = this.k;
        Rect bounds = settableDraweeHierarchy2 != null ? settableDraweeHierarchy2.getBounds() : null;
        Object obj = this.n;
        ControllerListener2.a aVar = new ControllerListener2.a();
        if (bounds != null) {
            bounds.width();
            bounds.height();
        }
        aVar.e = obj;
        aVar.c = map;
        aVar.d = map2;
        aVar.f538b = map4;
        aVar.a = map3;
        return aVar;
    }

    public abstract Map<String, Object> t(INFO info);

    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.b("isAttached", this.o);
        objects2H2.b("isRequestSubmitted", this.p);
        objects2H2.b("hasFetchFailed", this.q);
        objects2H2.a("fetchedImage", k(this.u));
        objects2H2.c("events", this.d.toString());
        return objects2H2.toString();
    }

    public final void u(String str, DataSource<T> dataSource, Throwable th, boolean z2) {
        Drawable drawable;
        FrescoSystrace.b();
        if (!o(str, dataSource)) {
            p("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            FrescoSystrace.b();
            return;
        }
        this.d.a(z2 ? DraweeEventTracker.a.ON_DATASOURCE_FAILURE : DraweeEventTracker.a.ON_DATASOURCE_FAILURE_INT);
        if (z2) {
            p("final_failed @ onFailure", th);
            this.t = null;
            this.q = true;
            SettableDraweeHierarchy settableDraweeHierarchy = this.k;
            if (settableDraweeHierarchy != null) {
                if (this.r && (drawable = this.w) != null) {
                    settableDraweeHierarchy.f(drawable, 1.0f, true);
                } else if (D()) {
                    settableDraweeHierarchy.b(th);
                } else {
                    settableDraweeHierarchy.c(th);
                }
            }
            ControllerListener2.a aVarR = r(dataSource, null, null);
            i().onFailure(this.m, th);
            this.j.b(this.m, th, aVarR);
        } else {
            p("intermediate_failed @ onFailure", th);
            i().onIntermediateImageFailed(this.m, th);
            Objects.requireNonNull(this.j);
        }
        FrescoSystrace.b();
    }

    public void v(String str, T t) {
    }

    public final void w(String str, DataSource<T> dataSource, T t, float f, boolean z2, boolean z3, boolean z4) {
        try {
            FrescoSystrace.b();
            if (!o(str, dataSource)) {
                q("ignore_old_datasource @ onNewResult", t);
                z(t);
                dataSource.close();
                FrescoSystrace.b();
                return;
            }
            this.d.a(z2 ? DraweeEventTracker.a.ON_DATASOURCE_RESULT : DraweeEventTracker.a.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable drawableG = g(t);
                T t2 = this.u;
                Drawable drawable = this.w;
                this.u = t;
                this.w = drawableG;
                try {
                    if (z2) {
                        q("set_final_result @ onNewResult", t);
                        this.t = null;
                        this.k.f(drawableG, 1.0f, z3);
                        C(str, t, dataSource);
                    } else if (z4) {
                        q("set_temporary_result @ onNewResult", t);
                        this.k.f(drawableG, 1.0f, z3);
                        C(str, t, dataSource);
                    } else {
                        q("set_intermediate_result @ onNewResult", t);
                        this.k.f(drawableG, f, z3);
                        i().onIntermediateImageSet(str, l(t));
                        Objects.requireNonNull(this.j);
                    }
                    if (drawable != null && drawable != drawableG) {
                        x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        q("release_previous_result @ onNewResult", t2);
                        z(t2);
                    }
                    FrescoSystrace.b();
                } catch (Throwable th) {
                    if (drawable != null && drawable != drawableG) {
                        x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        q("release_previous_result @ onNewResult", t2);
                        z(t2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                q("drawable_failed @ onNewResult", t);
                z(t);
                u(str, dataSource, e, z2);
                FrescoSystrace.b();
            }
        } catch (Throwable th2) {
            FrescoSystrace.b();
            throw th2;
        }
    }

    public abstract void x(Drawable drawable);

    public final void y() {
        Map<String, Object> mapA;
        Map<String, Object> mapT;
        boolean z2 = this.p;
        this.p = false;
        this.q = false;
        DataSource<T> dataSource = this.t;
        if (dataSource != null) {
            mapA = dataSource.a();
            this.t.close();
            this.t = null;
        } else {
            mapA = null;
        }
        Drawable drawable = this.w;
        if (drawable != null) {
            x(drawable);
        }
        if (this.f2886s != null) {
            this.f2886s = null;
        }
        this.w = null;
        T t = this.u;
        if (t != null) {
            mapT = t(l(t));
            q("release", this.u);
            z(this.u);
            this.u = null;
        } else {
            mapT = null;
        }
        if (z2) {
            i().onRelease(this.m);
            this.j.c(this.m, s(mapA, mapT, null));
        }
    }

    public abstract void z(T t);
}
