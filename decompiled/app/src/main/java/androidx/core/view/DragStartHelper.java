package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener = new AnonymousClass1();
    private final View.OnTouchListener mTouchListener = new AnonymousClass2();
    private final View mView;

    /* renamed from: androidx.core.view.DragStartHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements View.OnLongClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return DragStartHelper.this.onLongClick(view);
        }
    }

    /* renamed from: androidx.core.view.DragStartHelper$2, reason: invalid class name */
    public class AnonymousClass2 implements View.OnTouchListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return DragStartHelper.this.onTouch(view, motionEvent);
        }
    }

    public interface OnDragStartListener {
        boolean onDragStart(View view, DragStartHelper dragStartHelper);
    }

    public DragStartHelper(View view, OnDragStartListener onDragStartListener) {
        this.mView = view;
        this.mListener = onDragStartListener;
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point point) {
        point.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View view) {
        return this.mListener.onDragStart(view, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = x2;
            this.mLastTouchY = y2;
        } else if (action == 1) {
            this.mDragging = false;
        } else if (action != 2) {
            if (action == 3) {
            }
        } else if (MotionEventCompat.isFromSource(motionEvent, 8194) && (motionEvent.getButtonState() & 1) != 0 && !this.mDragging && (this.mLastTouchX != x2 || this.mLastTouchY != y2)) {
            this.mLastTouchX = x2;
            this.mLastTouchY = y2;
            boolean zOnDragStart = this.mListener.onDragStart(view, this);
            this.mDragging = zOnDragStart;
            return zOnDragStart;
        }
        return false;
    }
}
