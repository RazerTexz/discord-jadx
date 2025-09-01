package com.discord.overlay;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import b.a.n.TrashEventListener;
import b.a.n.h.OverlayTrashWrap;
import b.d.b.a.outline;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.Standard2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: OverlayService.kt */
/* loaded from: classes.dex */
public abstract class OverlayService extends Service {
    public static final Companion Companion = new Companion(null);
    public static final int NOTIFICATION_ID = 5858;
    public OverlayManager overlayManager;

    /* compiled from: OverlayService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/discord/overlay/OverlayService$Companion;", "", "", "NOTIFICATION_ID", "I", "<init>", "()V", "overlay_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: OverlayService.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ OverlayBubbleWrap k;

        public a(OverlayBubbleWrap overlayBubbleWrap) {
            this.k = overlayBubbleWrap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverlayService.this.getOverlayManager().b(this.k);
        }
    }

    /* compiled from: OverlayService.kt */
    public static final class b implements TrashEventListener {
        public b() {
        }

        @Override // b.a.n.TrashEventListener
        public void a(OverlayBubbleWrap overlayBubbleWrap) {
        }

        @Override // b.a.n.TrashEventListener
        public void b(OverlayBubbleWrap overlayBubbleWrap) {
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
            OverlayService.this.getOverlayManager().d(overlayBubbleWrap);
        }
    }

    /* compiled from: OverlayService.kt */
    public static final class c extends Lambda implements Function1<View, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (OverlayService.this.getOverlayManager().activeBubbles.isEmpty()) {
                throw new Standard2(outline.w("An operation is not implemented: ", "handle stop service"));
            }
            return Unit.a;
        }
    }

    private final boolean attachBubbleToWindow(Intent intent) {
        OverlayBubbleWrap overlayBubbleWrapCreateOverlayBubble = createOverlayBubble(intent);
        if (overlayBubbleWrapCreateOverlayBubble == null) {
            return false;
        }
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.a(overlayBubbleWrapCreateOverlayBubble);
        overlayBubbleWrapCreateOverlayBubble.post(new a(overlayBubbleWrapCreateOverlayBubble));
        OverlayManager overlayManager2 = this.overlayManager;
        if (overlayManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        if (overlayManager2.trashWrap != null) {
            return true;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayTrashWrap overlayTrashWrap = new OverlayTrashWrap(applicationContext);
        OverlayManager overlayManager3 = this.overlayManager;
        if (overlayManager3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        Objects.requireNonNull(overlayManager3);
        Intrinsics3.checkNotNullParameter(overlayTrashWrap, "trashWrap");
        overlayManager3.trashWrap = overlayTrashWrap;
        overlayManager3.windowManager.addView(overlayTrashWrap, overlayTrashWrap.getWindowLayoutParams());
        return true;
    }

    public abstract Notification createNotification(Intent intent);

    public abstract OverlayBubbleWrap createOverlayBubble(Intent intent);

    public final OverlayManager getOverlayManager() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        return overlayManager;
    }

    public final void handleStart(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (attachBubbleToWindow(intent)) {
            startForeground(NOTIFICATION_ID, createNotification(intent));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayManager overlayManager = new OverlayManager(applicationContext, null, 2);
        this.overlayManager = overlayManager;
        overlayManager.trashEventListener = new b();
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        c cVar = new c();
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(cVar, "<set-?>");
        overlayManager.onOverlayBubbleRemoved = cVar;
    }

    @Override // android.app.Service
    public void onDestroy() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.close();
        super.onDestroy();
    }

    public final void setOverlayManager(OverlayManager overlayManager) {
        Intrinsics3.checkNotNullParameter(overlayManager, "<set-?>");
        this.overlayManager = overlayManager;
    }
}
