package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import b.o.a.CameraLogger;
import b.o.a.q.GestureFinder;
import com.otaliastudios.cameraview.CameraView;

/* compiled from: ScrollGestureFinder.java */
/* renamed from: b.o.a.q.f, reason: use source file name */
/* loaded from: classes3.dex */
public class ScrollGestureFinder extends GestureFinder {
    public static final CameraLogger d = new CameraLogger(ScrollGestureFinder.class.getSimpleName());
    public GestureDetector e;
    public boolean f;
    public float g;

    /* compiled from: ScrollGestureFinder.java */
    /* renamed from: b.o.a.q.f$a */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ GestureFinder.a j;

        public a(GestureFinder.a aVar) {
            this.j = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Gesture gesture = Gesture.m;
            boolean z2 = false;
            ScrollGestureFinder.d.a(1, "onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() == ScrollGestureFinder.this.c[0].x) {
                float y2 = motionEvent.getY();
                ScrollGestureFinder scrollGestureFinder = ScrollGestureFinder.this;
                if (y2 != scrollGestureFinder.c[0].y) {
                    boolean z3 = Math.abs(f) >= Math.abs(f2);
                    ScrollGestureFinder scrollGestureFinder2 = ScrollGestureFinder.this;
                    if (!z3) {
                        gesture = Gesture.n;
                    }
                    scrollGestureFinder2.f1947b = gesture;
                    scrollGestureFinder2.c[0].set(motionEvent.getX(), motionEvent.getY());
                    z2 = z3;
                } else if (scrollGestureFinder.f1947b == gesture) {
                    z2 = true;
                }
            }
            ScrollGestureFinder.this.c[1].set(motionEvent2.getX(), motionEvent2.getY());
            ScrollGestureFinder.this.g = z2 ? f / CameraView.this.getWidth() : f2 / CameraView.this.getHeight();
            ScrollGestureFinder scrollGestureFinder3 = ScrollGestureFinder.this;
            scrollGestureFinder3.g = z2 ? -scrollGestureFinder3.g : scrollGestureFinder3.g;
            scrollGestureFinder3.f = true;
            return true;
        }
    }

    public ScrollGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 2);
        CameraView.b bVar = (CameraView.b) aVar;
        GestureDetector gestureDetector = new GestureDetector(bVar.g(), new a(bVar));
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // b.o.a.q.GestureFinder
    public float b(float f, float f2, float f3) {
        return ((f3 - f2) * this.g * 2.0f) + f;
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            d.a(1, "Notifying a gesture of type", this.f1947b.name());
        }
        return this.f;
    }
}
