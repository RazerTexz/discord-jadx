package com.discord.tooltips;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import b.a.j.FloatingViewManager;
import b.a.j.FloatingViewManager2;
import b.a.j.FloatingViewManager3;
import b.a.j.FloatingViewManager4;
import b.a.j.c;
import b.a.v.AcknowledgedTooltipsCache;
import b.a.v.TooltipManager2;
import com.discord.floating_view_manager.FloatingViewGravity;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: TooltipManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0015\u0016J]\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0015\u0010\u0014J!\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t0 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010$R\u0016\u0010'\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010&¨\u0006("}, d2 = {"Lcom/discord/tooltips/TooltipManager;", "", "Landroid/view/View;", "anchorView", "tooltipView", "Lcom/discord/tooltips/TooltipManager$b;", "tooltip", "Lcom/discord/floating_view_manager/FloatingViewGravity;", "tooltipGravity", "", "xOffset", "yOffset", "", "ignoreMaxTooltips", "Lrx/Observable;", "", "componentPausedObservable", "d", "(Landroid/view/View;Landroid/view/View;Lcom/discord/tooltips/TooltipManager$b;Lcom/discord/floating_view_manager/FloatingViewGravity;IIZLrx/Observable;)V", "c", "(Lcom/discord/tooltips/TooltipManager$b;)V", "a", "b", "(Lcom/discord/tooltips/TooltipManager$b;Z)Z", "", "", "Ljava/util/Set;", "shownTooltipNames", "Lb/a/j/a;", "e", "Lb/a/j/a;", "floatingViewManager", "", "Ljava/util/Map;", "tooltipNameToTooltipViewIdMap", "Lb/a/v/a;", "Lb/a/v/a;", "acknowledgedTooltipsCache", "I", "maxTooltipsPerColdStart", "tooltips_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public class TooltipManager {

    /* renamed from: a, reason: from kotlin metadata */
    public Map<String, Integer> tooltipNameToTooltipViewIdMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AcknowledgedTooltipsCache acknowledgedTooltipsCache;

    /* renamed from: c, reason: from kotlin metadata */
    public final Set<String> shownTooltipNames;

    /* renamed from: d, reason: from kotlin metadata */
    public final int maxTooltipsPerColdStart;

    /* renamed from: e, reason: from kotlin metadata */
    public final FloatingViewManager floatingViewManager;

    /* compiled from: TooltipManager.kt */
    public static final class a {
        public static WeakReference<TooltipManager> a;

        /* renamed from: b, reason: collision with root package name */
        public static final Lazy f2815b = LazyJVM.lazy(C0202a.j);
        public static final Lazy c = LazyJVM.lazy(b.j);
        public static final a d = null;

        /* compiled from: TooltipManager.kt */
        /* renamed from: com.discord.tooltips.TooltipManager$a$a, reason: collision with other inner class name */
        public static final class C0202a extends Lambda implements Function0<AcknowledgedTooltipsCache> {
            public static final C0202a j = new C0202a();

            public C0202a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AcknowledgedTooltipsCache invoke() {
                return new AcknowledgedTooltipsCache(null, 1);
            }
        }

        /* compiled from: TooltipManager.kt */
        public static final class b extends Lambda implements Function0<Set<String>> {
            public static final b j = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Set<String> invoke() {
                return new LinkedHashSet();
            }
        }
    }

    /* compiled from: TooltipManager.kt */
    public static class b {
        private final String cacheKey;
        private final String tooltipName;

        public b(String str, String str2) {
            Intrinsics3.checkNotNullParameter(str2, "tooltipName");
            this.cacheKey = str;
            this.tooltipName = str2;
        }

        public final String getCacheKey() {
            return this.cacheKey;
        }

        public final String getTooltipName() {
            return this.tooltipName;
        }

        public /* synthetic */ b(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, str2);
        }
    }

    public TooltipManager(AcknowledgedTooltipsCache acknowledgedTooltipsCache, Set set, int i, FloatingViewManager floatingViewManager, int i2) {
        i = (i2 & 4) != 0 ? 1 : i;
        Intrinsics3.checkNotNullParameter(acknowledgedTooltipsCache, "acknowledgedTooltipsCache");
        Intrinsics3.checkNotNullParameter(set, "shownTooltipNames");
        Intrinsics3.checkNotNullParameter(floatingViewManager, "floatingViewManager");
        this.acknowledgedTooltipsCache = acknowledgedTooltipsCache;
        this.shownTooltipNames = set;
        this.maxTooltipsPerColdStart = i;
        this.floatingViewManager = floatingViewManager;
        floatingViewManager.a = new TooltipManager2(this);
        this.tooltipNameToTooltipViewIdMap = new LinkedHashMap();
    }

    @MainThread
    public final void a(b tooltip) {
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        c(tooltip);
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            AcknowledgedTooltipsCache acknowledgedTooltipsCache = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(acknowledgedTooltipsCache);
            Intrinsics3.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            if (acknowledgedTooltipsCache.a.getBoolean(cacheKey, false)) {
                return;
            }
            AcknowledgedTooltipsCache acknowledgedTooltipsCache2 = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(acknowledgedTooltipsCache2);
            Intrinsics3.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            SharedPreferences.Editor editorEdit = acknowledgedTooltipsCache2.a.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean(cacheKey, true);
            editorEdit.apply();
        }
    }

    @MainThread
    public final boolean b(b tooltip, boolean ignoreMaxTooltips) {
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            AcknowledgedTooltipsCache acknowledgedTooltipsCache = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(acknowledgedTooltipsCache);
            Intrinsics3.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            boolean z2 = acknowledgedTooltipsCache.a.getBoolean(cacheKey, false);
            boolean zContains = this.shownTooltipNames.contains(tooltip.getTooltipName());
            int size = this.shownTooltipNames.size();
            if (z2) {
                return false;
            }
            if (!zContains && !ignoreMaxTooltips && size >= this.maxTooltipsPerColdStart) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    public final void c(b tooltip) {
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        Integer num = this.tooltipNameToTooltipViewIdMap.get(tooltip.getTooltipName());
        if (num != null) {
            this.floatingViewManager.b(num.intValue());
        }
    }

    @MainThread
    public final void d(View anchorView, View tooltipView, b tooltip, FloatingViewGravity tooltipGravity, int xOffset, int yOffset, boolean ignoreMaxTooltips, Observable<Unit> componentPausedObservable) {
        Intrinsics3.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics3.checkNotNullParameter(tooltipView, "tooltipView");
        Intrinsics3.checkNotNullParameter(tooltip, "tooltip");
        Intrinsics3.checkNotNullParameter(tooltipGravity, "tooltipGravity");
        Intrinsics3.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
        if (b(tooltip, ignoreMaxTooltips)) {
            c(tooltip);
            this.shownTooltipNames.add(tooltip.getTooltipName());
            this.tooltipNameToTooltipViewIdMap.put(tooltip.getTooltipName(), Integer.valueOf(tooltipView.getId()));
            FloatingViewManager floatingViewManager = this.floatingViewManager;
            Objects.requireNonNull(floatingViewManager);
            Intrinsics3.checkNotNullParameter(anchorView, "anchorView");
            Intrinsics3.checkNotNullParameter(tooltipView, "floatingView");
            Intrinsics3.checkNotNullParameter(tooltipGravity, "floatingViewGravity");
            Intrinsics3.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
            View rootView = anchorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            tooltipView.setVisibility(4);
            if (!floatingViewManager.f243b.containsKey(Integer.valueOf(tooltipView.getId()))) {
                viewGroup.addView(tooltipView);
            }
            if (!ViewCompat.isLaidOut(tooltipView) || tooltipView.isLayoutRequested()) {
                tooltipView.addOnLayoutChangeListener(new b.a.j.b(floatingViewManager, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else if (!ViewCompat.isLaidOut(anchorView) || anchorView.isLayoutRequested()) {
                anchorView.addOnLayoutChangeListener(new c(floatingViewManager, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else {
                FloatingViewManager.a(floatingViewManager, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
                tooltipView.setVisibility(0);
            }
            FloatingViewManager4 floatingViewManager4 = new FloatingViewManager4(floatingViewManager, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(floatingViewManager4);
            floatingViewManager.f243b.put(Integer.valueOf(tooltipView.getId()), new FloatingViewManager.a(tooltipView, viewGroup, floatingViewManager4));
            componentPausedObservable.Z(1).W(new FloatingViewManager2(floatingViewManager, tooltipView), new FloatingViewManager3(floatingViewManager));
        }
    }
}
