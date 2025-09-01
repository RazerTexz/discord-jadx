package com.discord.overlay;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import b.a.n.OverlayManager2;
import b.a.n.OverlayManager3;
import b.a.n.TrashEventListener;
import b.a.n.h.OverlayTrashWrap;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.utilities.display.DisplayUtils;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import defpackage.n;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: OverlayManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006R.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u00020\u00188\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R.\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000f\u001a\u0004\b-\u0010\u0011\"\u0004\b.\u0010\u0013R(\u00106\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001008\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R&\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000207j\b\u0012\u0004\u0012\u00020\u0002`88\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010E\u001a\u00020@8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/discord/overlay/OverlayManager;", "Ljava/io/Closeable;", "Lcom/discord/overlay/views/OverlayBubbleWrap;", "bubble", "", "d", "(Lcom/discord/overlay/views/OverlayBubbleWrap;)V", "a", "b", "close", "()V", "c", "Lkotlin/Function1;", "Landroid/view/View;", "l", "Lkotlin/jvm/functions/Function1;", "getOnOverlayBubbleAdded", "()Lkotlin/jvm/functions/Function1;", "setOnOverlayBubbleAdded", "(Lkotlin/jvm/functions/Function1;)V", "onOverlayBubbleAdded", "q", "Lcom/discord/overlay/views/OverlayBubbleWrap;", "bubbleInTrashZone", "Landroid/content/Context;", "r", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "k", "Ljava/util/List;", "getActiveBubbles", "()Ljava/util/List;", "activeBubbles", "Lb/a/n/f;", "o", "Lb/a/n/f;", "getTrashEventListener", "()Lb/a/n/f;", "setTrashEventListener", "(Lb/a/n/f;)V", "trashEventListener", "m", "getOnOverlayBubbleRemoved", "setOnOverlayBubbleRemoved", "onOverlayBubbleRemoved", "Lb/a/n/h/a;", "<set-?>", "n", "Lb/a/n/h/a;", "getTrashWrap", "()Lb/a/n/h/a;", "trashWrap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "Ljava/util/ArrayList;", "overlaysOnDisplay", "Landroid/view/View$OnTouchListener;", "p", "Landroid/view/View$OnTouchListener;", "bubbleOnTouchListener", "Landroid/view/WindowManager;", "s", "Landroid/view/WindowManager;", "getWindowManager", "()Landroid/view/WindowManager;", "windowManager", "overlay_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public class OverlayManager implements Closeable {

    /* renamed from: j, reason: from kotlin metadata */
    public final ArrayList<OverlayBubbleWrap> overlaysOnDisplay;

    /* renamed from: k, reason: from kotlin metadata */
    public final List<OverlayBubbleWrap> activeBubbles;

    /* renamed from: l, reason: from kotlin metadata */
    public Function1<? super View, Unit> onOverlayBubbleAdded;

    /* renamed from: m, reason: from kotlin metadata */
    public Function1<? super View, Unit> onOverlayBubbleRemoved;

    /* renamed from: n, reason: from kotlin metadata */
    public OverlayTrashWrap trashWrap;

    /* renamed from: o, reason: from kotlin metadata */
    public TrashEventListener trashEventListener;

    /* renamed from: p, reason: from kotlin metadata */
    public View.OnTouchListener bubbleOnTouchListener;

    /* renamed from: q, reason: from kotlin metadata */
    public OverlayBubbleWrap bubbleInTrashZone;

    /* renamed from: r, reason: from kotlin metadata */
    public final Context context;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final WindowManager windowManager;

    public OverlayManager(Context context, WindowManager windowManager, int i) {
        WindowManager windowManager2;
        if ((i & 2) != 0) {
            Object systemService = context.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager2 = (WindowManager) systemService;
        } else {
            windowManager2 = null;
        }
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(windowManager2, "windowManager");
        this.context = context;
        this.windowManager = windowManager2;
        ArrayList<OverlayBubbleWrap> arrayList = new ArrayList<>(5);
        this.overlaysOnDisplay = arrayList;
        this.activeBubbles = arrayList;
        this.onOverlayBubbleAdded = n.j;
        this.onOverlayBubbleRemoved = n.k;
        this.bubbleOnTouchListener = new OverlayManager2(this);
    }

    public final void a(OverlayBubbleWrap bubble) {
        Intrinsics3.checkNotNullParameter(bubble, "bubble");
        this.windowManager.addView(bubble, bubble.getWindowLayoutParams());
        this.overlaysOnDisplay.add(bubble);
        this.onOverlayBubbleAdded.invoke(bubble);
    }

    public final void b(OverlayBubbleWrap bubble) {
        Intrinsics3.checkNotNullParameter(bubble, "bubble");
        if (bubble.getCenterX() > DisplayUtils.getScreenSize(this.context).centerX()) {
            OverlayBubbleWrap.c(bubble, Integer.MAX_VALUE, (int) bubble.getY(), null, 4, null);
        } else {
            OverlayBubbleWrap.c(bubble, Integer.MIN_VALUE, (int) bubble.getY(), null, 4, null);
        }
    }

    public final void c(OverlayBubbleWrap bubble) {
        if (Intrinsics3.areEqual(this.bubbleInTrashZone, bubble)) {
            return;
        }
        this.bubbleInTrashZone = bubble;
        OverlayTrashWrap overlayTrashWrap = this.trashWrap;
        if (overlayTrashWrap != null) {
            overlayTrashWrap.a(bubble);
        }
        TrashEventListener trashEventListener = this.trashEventListener;
        if (trashEventListener != null) {
            trashEventListener.a(bubble);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MutableCollections.removeAll((List) this.overlaysOnDisplay, (Function1) new OverlayManager3(this));
        OverlayTrashWrap overlayTrashWrap = this.trashWrap;
        if (overlayTrashWrap != null) {
            this.windowManager.removeView(overlayTrashWrap);
        }
        this.trashWrap = null;
    }

    public final void d(OverlayBubbleWrap bubble) {
        Intrinsics3.checkNotNullParameter(bubble, "bubble");
        if (this.overlaysOnDisplay.remove(bubble)) {
            this.windowManager.removeViewImmediate(bubble);
            this.onOverlayBubbleRemoved.invoke(bubble);
        }
    }
}
